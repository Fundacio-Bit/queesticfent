package org.fundaciobit.basecamp.api3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.fundaciobit.basecamp.api3.beans.AttachFile;
import org.fundaciobit.basecamp.api3.beans.Dock;
import org.fundaciobit.basecamp.api3.beans.Entries;
import org.fundaciobit.basecamp.api3.beans.Entry;
import org.fundaciobit.basecamp.api3.beans.Folder;
import org.fundaciobit.basecamp.api3.beans.NewEntry;
import org.fundaciobit.basecamp.api3.beans.Project;
import org.fundaciobit.basecamp.api3.beans.Root;
import org.fundaciobit.basecamp.api3.beans.Todo;
import org.fundaciobit.basecamp.api3.beans.Upload;
import org.fundaciobit.basecamp.api3.beans.User;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author anadal
 *
 */
public class BaseCampApi3 {
    
    private static Logger log = Logger.getLogger(BaseCampApi3.class);

    private final String urlBaseCamp;

    private final long organizationID;

    private String token;

    private final Gson gson;

    private static String getTokenFromFile(File fileToken) {
        try {
            if (fileToken == null || !fileToken.exists()) {
                return null;
            }
            
            Properties prop = new Properties();
            prop.load(new FileInputStream(fileToken));
            
            String expiresStr = prop.getProperty("expires");
            if (expiresStr != null) {
                long expires = Long.parseLong(expiresStr);
                if (System.currentTimeMillis() > expires) {
                    return null;
                }
            }

            return prop.getProperty("accessToken");
        } catch (Exception e) {
            log.error("Error desconegut llegint token del fitxer " + fileToken.getAbsolutePath(), e);
            return null;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BaseCampApi3(String urlBaseCamp, long organizationID, File fileToken) {
        this(urlBaseCamp, organizationID, getTokenFromFile(fileToken));
    }

    public BaseCampApi3(String urlBaseCamp, long organizationID, String token) {
        // TODO Check que acaba amb /
        this.urlBaseCamp = urlBaseCamp;
        this.organizationID = organizationID;
        this.token = token;
        this.gson = new GsonBuilder().create();

    }

    public boolean isNecessaryUpdateToken() {
        if (token != null) {
            try {
                //this.getProject(-1);
                this.ping();
                return false;
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return true;
    }



    public Upload uploadFile(File f, String mime, long projectID, long folderID) throws Exception {

        // 20172238/vaults/3329411173

        // REM curl -s -H "Authorization: Bearer TOKEN
        // --data-binary "@logo.jpg" -H "Content-Type: image/jpeg" -H "Content-Length:
        // 2533" https://3.basecampapi.com/4298697/attachments.json?name=logo3.jpg

        AttachFile af = attacheFile(f, mime);

        log.info("RESPONSE UPLOAD: " + af.getAttachableSgid());

        // REM PUJAR FITXER

        // curl -s -H "Authorization: Bearer

        // -H 'Content-Type: application/json' -d
        // '{"attachable_sgid":"BAh7CEkiCGdpZAY6BkVUSSIuZ2lkOi8vYmMzL0F0dGFjaG1lbnQvMjQyMjUwNjIyP2V4cGlyZXNfaW4GOwBUSSIMcHVycG9zZQY7AFRJIg9hdHRhY2hhYmxlBjsAVEkiD2V4cGlyZXNfYXQGOwBUMA==--2002816ea2f499dec954357d78a77690017cd2cf",
        // https://3.basecampapi.com/4298697/buckets/20172238/vaults/3329411173/uploads.json

        af.setDescription("description: <div><strong>Yum</strong></div>");
        af.setBaseName(f.getName());
        String endPoint = this.urlBaseCamp + this.organizationID + "/buckets/" + projectID + "/vaults/" + folderID
                + "/uploads.json";
        Response response = commonCall(af, endPoint);

        String rjson = response.readEntity(String.class);

        log.info(" OUTPUT UPLOAD FILE ==> " + rjson);

        Upload upload = deserializeJson(rjson, Upload.class); // response.readEntity(Upload[].class);

        return upload;

    }

    protected AttachFile attacheFile(File f, String mime) throws IOException, ClientProtocolException, Exception {
        String url = this.urlBaseCamp + this.organizationID + "/attachments.json?name=" + f.getName();

        HttpPost post = new HttpPost(url);

        post.setHeader(org.apache.http.HttpHeaders.CONTENT_TYPE, mime);
        post.setHeader(org.apache.http.HttpHeaders.AUTHORIZATION, "Bearer " + this.token);

        post.setEntity(new FileEntity(f, ContentType.create(mime)));

        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse httResponse = httpclient.execute(post);

        String json;

        try {
            log.info("STATUS LINE: " + httResponse.getStatusLine());

            json = EntityUtils.toString(httResponse.getEntity());

            log.info("JSON UPLOAD: " + json);

        } finally {
            httResponse.close();
        }

        AttachFile af = deserializeJson(json, AttachFile.class);
        return af;
    }

    public Upload[] getUploads(long projectID, long folderID) throws Exception {

        // String endPoint =
        // "http://localhost:8080/4298697/buckets/20172238/vaults/3329411173/uploads.json";
        String endPoint = this.urlBaseCamp + this.organizationID + "/buckets/" + projectID + "/vaults/" + folderID
                + "/uploads.json";

        Response response = commonCall(null, endPoint);

        String json = response.readEntity(String.class);

        log.info(" OUTPUT ==> " + json);

        Upload[] uploads = deserializeJson(json, Upload[].class);

        return uploads;

    }

    public Folder[] getFolders(long projectID, long folderID) throws Exception {

        String endPoint = this.urlBaseCamp + this.organizationID + "/buckets/" + projectID + "/vaults/" + folderID
                + "/vaults.json";

        Response response = commonCall(null, endPoint);

        String json = response.readEntity(String.class);

        log.info(" OUTPUT ==> " + json);

        Folder[] folders = deserializeJson(json, Folder[].class);

        return folders;

    }

    public List<Todo> getTodos(long projectID, long todosGroupID, boolean completed) throws Exception {

        // https://3.basecamp.com/4298697/buckets/14002723/todolists/2119839561?updated=true

        List<Todo> todos = new ArrayList<Todo>();

        int total = -1;
        int page = 1;

        Todo[] currenttodos;

        do {

            String endPoint = this.urlBaseCamp + this.organizationID + "/buckets/" + projectID + "/todolist/"
                    + todosGroupID + ".json?completed=" + completed + "&page=" + page; // ?status=archived
                                                                                                                                                                                         // completed=true&

            page++;

            Response response = commonCall(null, endPoint);

            String json = response.readEntity(String.class);

            // log.info(" OUTPUT ==> " + json);
            // log.info(" NEXT ==> " + response.getHeaderString("Link"));
            if (total == -1) {
                // log.info(" X-Total-Count ==> " +
                // response.getHeaderString("X-Total-Count"));
                total = Integer.parseInt(response.getHeaderString("X-Total-Count"));
            }

            currenttodos = deserializeJson(json, Todo[].class);

            List<Todo> newListObject = Arrays.asList(currenttodos);

            todos.addAll(newListObject);

            log.info(todos.size() + " de " + total);

        } while (todos.size() < total && currenttodos.length != 0);

        return todos;

        // return new Todo[0];

    }

    public Project[] getProjects() throws Exception {

        String endPoint = this.urlBaseCamp + this.organizationID + "/projects.json";

        Response response = commonCall(null, endPoint);

        String json = response.readEntity(String.class);

        //log.info(" OUTPUT ==> " + json);

        Project[] projects = deserializeJson(json, Project[].class);

        return projects;

    }

    /**
     * 
     * @param projectID
     * @param scheduleID
     * @param page
     * @return
     * @throws Exception
     */
    public Entries getSchedule(long projectID, long scheduleID, int page) throws Exception {

        String endPointEntries;
        endPointEntries = getScheduleEntriesEndPoint(projectID, scheduleID);
        log.info("ENTRIES URL => " + endPointEntries);

        //   /buckets/1/schedule_entries/2/occurrences/20190218.json

        //endPoint = base + "/schedule_entries/" + scheduleID + "/occurrences/20231122.json";
        //log.info("ENTRIES URL => " + endPoint);
        Response response;
        response = commonCall(null, endPointEntries + "?page=" + page);

        log.info("X-Total-Count => " + response.getHeaderString("X-Total-Count"));
        long total = Long.parseLong(response.getHeaderString("X-Total-Count"));
        //response = commonCall(null, root.getEntries_url() + "?on=2023-11-22");

        String json = response.readEntity(String.class);

        log.info(" OUTPUT ==> " + json);

        Entry[] entrades = deserializeJson(json, Entry[].class);

        return new Entries(entrades, total, page);

    }
    
    
    
    public Long getScheduleID(Long projectID) throws Exception {
        Project project = this.getProject(projectID);

        Long schedulerID = null;

        for (Dock d : project.getDock()) {

            if ("schedule".equals(d.getName())) {
                schedulerID = d.getId();
                break;
            }
        }
        return schedulerID;
    }
    
    
    

    public Entry addScheduleEntry(long projectID, long scheduleID, NewEntry entry) throws Exception {

        String endPointEntries;
        endPointEntries = getScheduleEntriesEndPoint(projectID, scheduleID);
        log.info("ENTRIES URL => " + endPointEntries);
        
        
        Response response;
        response = commonCall(entry, endPointEntries);

        String json = response.readEntity(String.class);

        //log.info(" OUTPUT NEW ENTRY ==> " + json);
        
        Entry fullentry = deserializeJson(json, Entry.class);
        
        return fullentry;
        
    }


    public void deleteScheduleEntry(long projectID, long entryID) throws Exception {

    
        String base = this.urlBaseCamp + this.organizationID + "/buckets/" + projectID;
        String endPoint = base + "/recordings/" + entryID + "/status/trashed.json";
        
        Response response = commonCall(null, endPoint, true);
        String json = response.readEntity(String.class);
        log.info(" OUTPUT DELETE ENTRY ==> " + json);
    
    }

    protected String getScheduleEntriesEndPoint(long projectID, long scheduleID) throws Exception {
        String endPointEntries;
        String base = this.urlBaseCamp + this.organizationID + "/buckets/" + projectID;
        String endPoint = base + "/schedules/" + scheduleID + ".json";
        Response response = commonCall(null, endPoint);
        String json = response.readEntity(String.class);
        log.info(" OUTPUT SHEDULE ==> " + json);
        Root root = deserializeJson(json, Root.class);
        endPoint = root.getEntries_url();
        endPointEntries = endPoint;
        return endPointEntries;
    }

    public Project getProject(long projectID) throws Exception {

        String endPoint = this.urlBaseCamp + this.organizationID + "/projects/" + projectID + ".json";

        Response response = commonCall(null, endPoint);

        String json = response.readEntity(String.class);

        log.info(" OUTPUT ==> " + json);

        Project project = deserializeJson(json, Project.class);

        return project;

    }

    public User[] getUsers(long projectID) throws Exception {

        // https://3.basecamp.com/4298697/projects/14002755/people/users/edit

        String endPoint = this.urlBaseCamp + this.organizationID + "/projects/" + projectID + "/people.json";

        Response response = commonCall(null, endPoint);

        String json = response.readEntity(String.class);

        log.info(" OUTPUT GETUSERS  ==> " + json);

        User[] users = deserializeJson(json, User[].class);

        return users;

    }
    
    
    public User getUserIdFromEmail(long projectID, String email)  throws Exception {
        User[] users = this.getUsers(projectID);
        
        
        for (User user : users) {
            if (email.equalsIgnoreCase(user.getEmailAddress())) {
                return user;
            }
        }
        
        return null;
        
    }
    

    private void ping() throws Exception {

        String endPoint = this.urlBaseCamp + this.organizationID + "/chats.json?page=99999999999999999";

        //String endPoint = "https://launchpad.37signals.com/authorization.json";
        
        Response response = commonCall(null, endPoint);

        String json = response.readEntity(String.class);

        log.info(" OUTPUT EMPTYCALL  ==> " + json);

    }

    protected String serializeJson(Object pojo) throws Exception {

        //ObjectMapper om = new ObjectMapper();
        //return om.writeValueAsString(pojo);

        return gson.toJson(pojo);

    }

    protected <T> T deserializeJson(String pojo, Class<T> classe) throws Exception {

        //ObjectMapper om = new ObjectMapper();
        //T t = om.readValue(pojo, classe);

        return gson.fromJson(pojo, classe);

    }
    
    
    protected Response commonCall(Object parameter, String endPoint) throws Exception {
        return commonCall(parameter, endPoint, false);
    }

    protected Response commonCall(Object parameter, String endPoint, boolean usePut) throws Exception {

        log.info(" COMMON CALL URL: " + endPoint);
        log.info(" COMMON CALL TOK: " + token);

        Response response;
        
        try {

            
            ResteasyClient client = new ResteasyClientBuilder().build();
            
            ResteasyWebTarget webTarget = client.target(endPoint);
            
                        
            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + this.token);
                    
            
            
            /*
            ClientConfig config = new ClientConfig();

            ClientBuilder clientBuilder = ClientBuilder.newBuilder().withConfig(config);

            final Client client = clientBuilder.build();

            WebTarget webTarget = client.target(endPoint);
            log.info(" COMMON CALL : " + endPoint);
            log.info(" COMMON CALL : " + token);

            Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

            invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
*/
            
            
            if (parameter == null) {
                if (usePut) {
                    response = invocationBuilder.put(null);
                } else {
                    response = invocationBuilder.get(); // Entity.json(null));
                }
            } else {

                String data = serializeJson(parameter);

                log.info(" OBJECT PARAMETER: " + data);

                Entity<?> json = Entity.entity(data, MediaType.APPLICATION_JSON_TYPE);

                response = invocationBuilder.post(json);
            }
            

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }

        if (response.getStatus() == 200 || response.getStatus() == 201 || response.getStatus() == 204) {
            return response;
        } else {

            log.error(" ERROR STATUS: ]" + response.getStatus() + "[");

            // Error de Comunicació o no controlat
            String raw_msg;
            try {
              raw_msg = response.readEntity(String.class);
            } catch(Throwable th) {
               Object obj = response.getEntity();
               raw_msg = String.valueOf(obj);
            }
              
            String msg = "Error desconegut (Codi de servidor " + response.getStatus() + "): " + raw_msg
                    + response.toString();
            
            log.error(msg);
              
            throw new Exception(msg);

        }

    }

}
