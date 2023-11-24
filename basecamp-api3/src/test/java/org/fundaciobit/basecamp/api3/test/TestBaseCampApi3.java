package org.fundaciobit.basecamp.api3.test;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.fundaciobit.basecamp.api3.BaseCampApi3;
import org.fundaciobit.basecamp.api3.beans.Assignee;
import org.fundaciobit.basecamp.api3.beans.Dock;
import org.fundaciobit.basecamp.api3.beans.Entries;
import org.fundaciobit.basecamp.api3.beans.Entry;
import org.fundaciobit.basecamp.api3.beans.Folder;
import org.fundaciobit.basecamp.api3.beans.NewEntry;
import org.fundaciobit.basecamp.api3.beans.Project;
import org.fundaciobit.basecamp.api3.beans.Todo;
import org.fundaciobit.basecamp.api3.beans.Upload;
import org.fundaciobit.basecamp.api3.utils.TokenResponse;
import org.fundaciobit.basecamp.api3.utils.UpdateTokenUtils;
import org.fundaciobit.pluginsib.core.utils.ISO8601;

/**
 * 
 * @author anadal
 *
 */
public class TestBaseCampApi3 {

    public static void main(String[] args) {

        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(new File("basecamp_api_3.properties")));

            String urlBase = prop.getProperty("urlBase");
            long organizationID = Long.parseLong(prop.getProperty("organizationID"));

            File basecampTokenFile = new File(prop.getProperty("basecamp_token_properties"));

            BaseCampApi3 tu = new BaseCampApi3(urlBase, organizationID, basecampTokenFile);

            if (tu.isNecessaryUpdateToken()) {

                String redirect_uri = prop.getProperty("redirect_uri"); //~http://localhost:8080/token
                String client_id = prop.getProperty("client_id");
                String client_secret = prop.getProperty("client_secret");

                updateTokenFromStandaloneProgram(tu, basecampTokenFile, redirect_uri, client_id, client_secret);

            }

            Project[] projects = tu.getProjects();
            for (Project project : projects) {
                System.out.println(project.getId() + " => " + project.getName());
            }

            //listProjects(tu);

            //long projectID = Long.parseLong(prop.getProperty("projectID"));

            /*
            Project project = getProject(tu, projectID);
            
            
            Long folderRootID = null;
            Long schedulerID = null;
            {
               for(Dock d : project.getDock()) {
                   if ("vault".equals(d.getName())) {
                       folderRootID = d.getId();
                   }
                   if ("schedule".equals(d.getName())) {
                       schedulerID = d.getId();
                   }
               }
            }
            
            */

            /*
            // Test users
            User[] users = tu.getUsers(projectID);
            
            for (User user : users) {
                System.out.println(user.toString());
            }
            */

            //addSchedulerEntry(tu, projectID, schedulerID);

            //listSchedulerEntries(tu, projectID, scheduleID);

            //listFolders(tu, projectID, folderRootID);

            //uploadFile(tu, projectID, folderRootID);

            //listUploadedFiles(tu, projectID, folderRootID);

            //listTODOs(tu);

            //estadistiquesPinbal(tu);

            //queesticfentPinbal(tu);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("FINAL");

    }



    protected static void updateTokenFromStandaloneProgram(BaseCampApi3 tu, File basecampTokenFile, String redirect_uri,
            String client_id, String client_secret)
            throws MalformedURLException, Exception, IOException, URISyntaxException, FileNotFoundException {
        URL uri = new URL(redirect_uri);

        if (!"localhost".equals(uri.getHost())) {
            throw new Exception(
                    "El servidor redirect ha de ser localhost. Configurar Redirect URI de l'app accedint a https://launchpad.37signals.com/integrations.");
        }

        if (!"http".equals(uri.getProtocol())) {
            throw new Exception(
                    "El servidor redirect ha de tenir protocol http. Configurar Redirect URI de l'app accedint a https://launchpad.37signals.com/integrations.");
        }

        

        String url = UpdateTokenUtils.getGetCodeUrl(client_id, redirect_uri);
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(url));
        } else {
            System.out.println("URL => " + url);
            System.out.println("Per favor obri un Navegador i copia-li la URL anterior ...");
        }

        String resposta = readFromSocket(uri.getPort() == -1 ? 80 : uri.getPort());

        int index = resposta.indexOf("code=");
        if (index == -1) {
            throw new Exception("Error processant resposta del servidor de Basecamp => " + resposta);
        } else {

            int index2 = resposta.indexOf(" ", index);

            if (index2 == -1) {
                throw new Exception("Error processant resposta del servidor de Basecamp => " + resposta);
            } else {

                String code = resposta.substring(index + 5, index2);

                

                TokenResponse token = UpdateTokenUtils.getNewToken(client_id, client_secret, redirect_uri, code);

                UpdateTokenUtils.updateBasecampTokenProperties(basecampTokenFile, token);

                tu.setToken(token.getAccessToken());

            }

        }
    }

    

    protected static void addSchedulerEntry(BaseCampApi3 tu, long projectID, Long schedulerID, String title)
            throws Exception {
        NewEntry e = new NewEntry();
        e.setSummary(title);
        Calendar cal = Calendar.getInstance();

        e.setStarts_at(ISO8601.dateToISO8601(cal.getTime()));

        cal.add(Calendar.HOUR, 3);

        e.setEnds_at(ISO8601.dateToISO8601(cal.getTime()));

        // Només funciona un participant ...
        e.setParticipant_ids(new String[] { "31907487", "29712337" }); // Juan Antonio 31907487 // Atrobat 29712337

        tu.addScheduleEntry(projectID, schedulerID, e);
    }

    protected static void listSchedulerEntries(BaseCampApi3 tu, long projectID, Long scheduleID) throws Exception {
        Entries entrades = tu.getSchedule(projectID, scheduleID, 1);
        int count = 1;

        Entry[] entries = entrades.getEntries();

        System.out.println("Returned Entries => " + entries.length);

        for (Entry entry : entries) {
            //if (count > (entries.length - 10)) 
            {
                System.out.println(
                        count + " " + entry.getId() + " " + entry.getTitle() + "( S: " + entry.getStartsAt() + ")");

            }
            count++;
        }
    }

    protected static void estadistiquesPinbal(BaseCampApi3 tu) throws Exception {

        long projectID = 14002723;

        //long todosGroupID = 2119839561;

        // buckets/14002723/todolists/2119831780

        boolean completed = true;

        String[][] dades = { { "Gestió de PINFOS", "2119831780" }, // PINFOs
                { "Gestió d'incidències PINBAL", "2119839561" }, // Incidències
                { "Suport en la intermediació de dades", "2123252306" } // Basecamp  Suport/Informació 

        };

        String mes = "2021_04";

        for (int i = 0; i < dades.length; i++) {

            System.out.println(" ------ " + dades[i][0] + " ----- ");
            long todosGroupID = Long.parseLong(dades[i][1]);
            Map<String, List<Todo>> incidenciesPerMes = extreuEstadistiques(tu, projectID, todosGroupID, completed);

            List<Todo> todos = incidenciesPerMes.get(mes);
            if (todos == null) {
                System.out.println("        + #" + dades[i][0] + ":  0 ????");
                continue;
            }
            System.out.println("        + #" + dades[i][0] + ": " + todos.size());

        }

    }

    protected static void queesticfentPinbal(BaseCampApi3 tu) throws Exception {

        long projectID = 14002723;

        boolean completed = true;

        String[][] dades = { { "Gestió d'incidències PINBAL", "2119839561" }, // Incidències
                { "Suport en la intermediació de dades", "2123252306" }, // Basecamp  Suport/Informació 
                { "Peticions IB", "2119842030" }, { "Peticions pendent esmenes", "3226024523" },
                { "Peticions Estatals", "2119842315" }, { "Gestió de PINFOS", "2119831780" }, // PINFOs
                { "Altres gestions", "2482916804" }

        };

        String mes = "2020_12";
        String email = "pvico@fundaciobit.org";

        Map<Date, String> feines = new TreeMap<Date, String>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < dades.length; i++) {

            System.out.println(" ------ " + dades[i][0] + " ----- ");
            long todosGroupID = Long.parseLong(dades[i][1]);
            Map<String, List<Todo>> incidenciesPerMes = extreuEstadistiques(tu, projectID, todosGroupID, completed);

            List<Todo> todos = incidenciesPerMes.get(mes);

            if (todos == null) {
                continue;
            }

            // System.out.println("        + #" + dades[i][0] + ": " + todos.size());

            for (Todo todo : todos) {
                for (Assignee a : todo.getAssignees()) {

                    if (email.equals(a.getEmailAddress())) {

                        feines.put(todo.getUpdatedAt(), todo.getTitle());

                        //System.out.println(sdf.format(todo.getUpdatedAt()) + " " + todo.getTitle());
                    }
                }
            }

        }

        for (Map.Entry<Date, String> item : feines.entrySet()) {

            System.out.println(sdf.format(item.getKey()) + " " + item.getValue());

        }

    }

    private static Map<String, List<Todo>> extreuEstadistiques(BaseCampApi3 tu, long projectID, long todosGroupID,
            boolean completed) throws Exception {

        List<Todo> todos = tu.getTodos(projectID, todosGroupID, completed);

        Map<String, List<Todo>> incidenciesPerMes = new TreeMap<String, List<Todo>>();

        if (todos != null) {

            //System.out.println("TODOS LEN : " + todos.size());

            //int i = 1;
            for (Todo todo : todos) {
                //System.out.println("---------- TODO[" + i++ + "] -------------"); 
                //System.out.println( todo.getTitle() + " " + todo.getCompleted() + " " + todo.getUpdatedAt());

                java.util.Date date = todo.getUpdatedAt();

                @SuppressWarnings("deprecation")
                String key = (1900 + date.getYear()) + "_" + String.format("%02d", date.getMonth() + 1);

                List<Todo> mes = incidenciesPerMes.get(key);

                if (mes == null) {
                    mes = new ArrayList<Todo>();
                    incidenciesPerMes.put(key, mes);
                }

                mes.add(todo);

            }

            //            for (String key : incidenciesPerMes.keySet()) {
            //                
            //                System.out.println(key + " " + incidenciesPerMes.get(key).size());
            //                
            //            }
            //            

        }

        return incidenciesPerMes;
    }

    protected static void listTODOs(BaseCampApi3 tu) throws Exception {

        // https://3.basecamp.com/4298697/buckets/14002755/todosets/2116462964

        //long projectID = 14002723;
        //long todosGroupID = 2119839561;

        // GovernDigital
        long projectID = 14002755;
        long todosGroupID = 2116462964;

        boolean completed = true;

        List<Todo> todos = tu.getTodos(projectID, todosGroupID, completed);

        if (todos != null) {

            System.out.println("TODOS LEN : " + todos.size());
            int i = 1;
            for (Todo todo : todos) {
                System.out.println("---------- TODO[" + i++ + "] -------------");
                System.out.println(todo.getTitle() + " " + todo.getCompleted() + " " + todo.getUpdatedAt());
            }
        }

    }

    protected static void listProjects(BaseCampApi3 tu) throws Exception {

        Project[] projects = tu.getProjects();

        if (projects != null) {

            System.out.println("PROJECTS LEN : " + projects.length);

            for (int i = 0; i < projects.length; i++) {
                System.out.println("---------- PROJECT[" + i + "] -------------");
                printProject(projects[i]);
            }
        }

    }

    protected static Project getProject(BaseCampApi3 tu, long projectID) throws Exception {

        Project project = tu.getProject(projectID);
        System.out.println("---------- PROJECTE " + project.getName() + " -------------------");
        printProject(project);

        return project;
    }

    protected static void printProject(Project project) {

        System.out.println("             + name: " + project.getName());
        System.out.println("             + Desc: " + project.getDescription());
        System.out.println("             + URL : " + project.getUrl());
        List<Dock> docks = project.getDock();

        for (Dock dock : docks) {
            System.out.println("                - Dock: " + dock.getName() + " ( " + dock.getTitle() + " | "
                    + dock.getUrl() + " | ID: " + dock.getId() + ")");
        }
    }

    protected static void listFolders(BaseCampApi3 tu, long projectID, Long folderID) throws Exception {

        if (folderID == null) {
            System.err.println("folderID és null.");
        } else {

            Folder[] folders = tu.getFolders(projectID, folderID);

            if (folders != null) {

                System.out.println("FOLDERS LEN : " + folders.length);

                for (int i = 0; i < folders.length; i++) {
                    System.out.println("FOLDER[" + i + "] Titol: " + folders[i].getTitle());
                    System.out.println("FOLDER[" + i + "] tipus: " + folders[i].getType());
                    System.out.println("FOLDER[" + i + "] URL: " + folders[i].getVaultsUrl());
                }
            }
        }

    }

    protected static void listUploadedFiles(BaseCampApi3 tu, long projectID, long folderID) throws Exception {
        Upload[] uploads = tu.getUploads(projectID, folderID);

        if (uploads != null) {

            System.out.println("UPLOADS LEN : " + uploads.length);

            for (int i = 0; i < uploads.length; i++) {
                System.out.println("FILENAME : " + uploads[i].getFilename());
            }
        }
    }

    protected static void uploadFile(BaseCampApi3 tu, long projectID, long folderID) throws Exception {

        File f = new File("logo-reactexample.png");

        System.out.println("UPLOAD FILE: " + tu.uploadFile(f, "image/png", projectID, folderID));
    }

    public static String readFromSocket(int port) throws Exception {

        String resposta;

        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("Servidor escoltant al PORT: " + port);
        {
            Socket clientSocket = serverSocket.accept();
            System.err.println("Resposta del servidor de basecamp des de " + clientSocket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())), true);

            StringBuilder str = new StringBuilder();
            //System.err.println(" =========================== ");
            String s;
            while ((s = in.readLine()) != null) {
                str.append(s).append('\n');
                break;
            }

            // Exemple de RESPOSTA  => GET /token?code=80fc7975 HTTP/1.1
            resposta = str.toString();

            //System.err.println(" =========================== ");

            out.println("HTTP/1.0 200 OK");
            out.println("Content-Type: text/html");
            out.println("\r\n");
            out.println(
                    "<html><body>OK (Revisi consola per saber l'estat final del proc&eacute;s d'actualitzaci&oacute; del TOKEN)</body></html>");

            System.err.println("Connexio amb el client finalitzada.");
            out.flush();
            out.close();
            in.close();
            clientSocket.close();
        }

        serverSocket.close();
        return resposta;
    }

}
