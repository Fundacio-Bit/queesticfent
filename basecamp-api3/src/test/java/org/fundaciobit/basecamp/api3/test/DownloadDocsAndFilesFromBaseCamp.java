package org.fundaciobit.basecamp.api3.test;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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
import org.fundaciobit.basecamp.api3.beans.Document;
import org.fundaciobit.basecamp.api3.beans.Entries;
import org.fundaciobit.basecamp.api3.beans.Entry;
import org.fundaciobit.basecamp.api3.beans.Folder;
import org.fundaciobit.basecamp.api3.beans.NewEntry;
import org.fundaciobit.basecamp.api3.beans.Project;
import org.fundaciobit.basecamp.api3.beans.Todo;
import org.fundaciobit.basecamp.api3.beans.Upload;
import org.fundaciobit.basecamp.api3.utils.TokenResponse;
import org.fundaciobit.basecamp.api3.utils.UpdateTokenUtils;
import org.fundaciobit.pluginsib.documentconverter.IDocumentConverterPlugin;
import org.fundaciobit.pluginsib.documentconverter.openoffice.OpenOfficeDocumentConverterPlugin;


import java.net.HttpURLConnection;
import java.util.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;


/**
 * 
 * @author anadal
 *
 */
public class DownloadDocsAndFilesFromBaseCamp {

    public static void main(String[] args) {

        try {

            Properties prop = new Properties();
            prop.load(new FileInputStream(new File("basecamp_api_3.properties")));

            String urlBase = prop.getProperty("urlBase");
            long organizationID = Long.parseLong(prop.getProperty("organizationID"));

            File basecampTokenFile = new File(prop.getProperty("basecamp_token_properties_file"));

            BaseCampApi3 tu = new BaseCampApi3(urlBase, organizationID, basecampTokenFile);

            if (tu.isNecessaryUpdateToken()) {

                final String redirect_uri = prop.getProperty("redirect_uri"); //~http://localhost:8080/token
                final String client_id = prop.getProperty("client_id");
                final String client_secret = prop.getProperty("client_secret");

                Properties propToken = new Properties();
                propToken.load(new FileInputStream(basecampTokenFile));

                String refreshToken = propToken.getProperty("refreshToken");
                boolean tokenUpdated = false;
                if (refreshToken != null) {
                    try {

                        // Intentam actualitzar emprant el refresh token
                        TokenResponse token = UpdateTokenUtils.getNewTokenFromRefreshToken(client_id, client_secret,
                                redirect_uri, refreshToken);

                        System.out.println(token);

                        if (token.getRefreshToken() == null) {
                            token.setRefreshToken(refreshToken);
                        }

                        UpdateTokenUtils.updateBasecampTokenProperties(basecampTokenFile, token);

                        tu.setToken(token.getAccessToken());

                        System.out.println("\n\n REFRESCAT TOKEN SENSE PROBLEMES \n\n");

                        tokenUpdated = true;

                    } catch (Exception e) {
                        System.err.println("Error intentant refrescar Token: " + e.getMessage());
                        e.printStackTrace();
                    }
                }

                if (!tokenUpdated) {
                    updateTokenViaWebFromStandaloneProgram(tu, basecampTokenFile, redirect_uri, client_id,
                            client_secret);
                }

            }

            Project[] projects = tu.getProjects();
            for (Project project : projects) {
                System.out.println(project.getId() + " => " + project.getName());
            }

            //listProjects(tu);

            Properties testProps = new Properties();
            testProps.load(new FileInputStream(new File("test.properties")));
            long projectID = Long.parseLong(testProps.getProperty("projectID"));

            Project project = getProject(tu, projectID);
            //System.out.println(project);

            Long folderRootID = null;
            Long schedulerID = null;
            {
                for (Dock d : project.getDock()) {
                    if ("vault".equals(d.getName())) {
                        folderRootID = d.getId();
                    }
                    if ("schedule".equals(d.getName())) {
                        schedulerID = d.getId();
                    }
                }
            }

            System.out.println("SchedulerID: " + schedulerID);

            /*
            // Test users
            User[] users = tu.getUsers(projectID);
            
            for (User user : users) {
                System.out.println(user.toString());
            }
            */

            /*
            Entry e = addSchedulerEntry(tu, projectID, schedulerID, "Vacances AN");
            
            System.out.println("Pitja enter per esborrar entrada del Calendari ...");
            System.in.read();
            
            
            long entryID = e.getId();
            
            tu.deleteScheduleEntry(projectID, entryID);
            */

            //listSchedulerEntries(tu, projectID, scheduleID);

            
            
            
            
            /*
             * 
             * FOLDER[9308879620] Titol: Cursos
            ---------------------------------------------
            FOLDER[9266044174] Titol: Sistemes

            ---------------------------------------------
            FOLDER[7215812441] Titol: Normatives

            ---------------------------------------------
            FOLDER[7201650218] Titol: Nouvingut

            ---------------------------------------------
            FOLDER[4748329193] Titol: Qualitat

            ---------------------------------------------
            FOLDER[4525919411] Titol: Recursos

            ---------------------------------------------
            FOLDER[3785262148] Titol: SESSIONS TÈCNIQUES

            ---------------------------------------------
            FOLDER[3112086246] Titol: Agile (Retrospectives)

            ---------------------------------------------
            FOLDER[2153390174] Titol: OTAE
            
            
            ARREL = folderRootID
            */
            
            
            File base = new File("DocsAndFiles_ODT");
            long folderId = folderRootID;
            
            
            /*
            File root = new File("DocsAndFiles");
            File base = new File(root, "Nouvingut");
            base.mkdirs();
            long folderId = 7201650218L;
            */
            
            /*
            File root = new File("DocsAndFiles");
            File base = new File(root, "Cursos");
            base.mkdirs();
            long folderId = 9308879620L;
            */
            
            

            listFolders(tu, projectID, folderId, base);

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

    protected static void updateTokenViaWebFromStandaloneProgram(BaseCampApi3 tu, File basecampTokenFile,
            String redirect_uri, String client_id, String client_secret)
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

        // token?error=access_denied

        int index = resposta.indexOf("code=");
        if (index == -1) {
            throw new Exception("Error processant resposta del servidor de Basecamp => " + resposta);
        } else {

            int index2 = resposta.indexOf(" ", index);

            if (index2 == -1) {
                throw new Exception("Error processant resposta del servidor de Basecamp => " + resposta);
            } else {

                String code = resposta.substring(index + 5, index2);

                TokenResponse token = UpdateTokenUtils.getNewTokenFromCode(client_id, client_secret, redirect_uri,
                        code);

                UpdateTokenUtils.updateBasecampTokenProperties(basecampTokenFile, token);

                tu.setToken(token.getAccessToken());

            }

        }
    }

    protected static Entry addSchedulerEntry(BaseCampApi3 tu, long projectID, Long schedulerID, String title)
            throws Exception {
        NewEntry e = new NewEntry();
        e.setSummary(title);
        Calendar cal = Calendar.getInstance();

        e.setStarts_at(org.fundaciobit.pluginsib.core.v3.utils.ISO8601.dateToISO8601(cal.getTime()));

        cal.add(Calendar.HOUR, 3);

        e.setEnds_at(org.fundaciobit.pluginsib.core.v3.utils.ISO8601.dateToISO8601(cal.getTime()));

        e.setAllDay(true);

        // Només funciona un participant ...
        e.setParticipant_ids(new Integer[] { 27011117 }); // Juan Antonio 31907487 // Atrobat 29712337

        return tu.addScheduleEntry(projectID, schedulerID, e);
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
                System.out.println(projects[i]);
            }
        }

    }

    protected static Project getProject(BaseCampApi3 tu, long projectID) throws Exception {

        Project project = tu.getProject(projectID);
        System.out.println("---------- PROJECTE " + project.getName() + " -------------------");
        System.out.println(project);

        return project;
    }

    protected static void listFolders(BaseCampApi3 tu, long projectID, Long folderID, File base) throws Exception {

        if (folderID == null) {
            System.err.println("folderID és null.");
        } else {

            
            Upload[] uploads = tu.getUploads(projectID, folderID);

            if (uploads != null) {

                for (int j = 0; j < uploads.length; j++) {
                    System.out.println("     -- UPLOAD[" + j + "] FILENAME: " + uploads[j].getFilename());
                    tu.downloadFile(uploads[j], new File(base, uploads[j].getFilename()));
                }
            }

            // Listar todos los documentos que no son Upload de la carpeta
            /*
            List<Document> documents = tu.getDocuments(projectID, folderID);
            
            if (documents != null && !documents.isEmpty()) {
            
                for (int j = 0; j < documents.size(); j++) {
                    System.out.println("     -- DOCUMENT[" + j + "] TITLE: " + documents.get(j).getTitle());
                    System.out.println(" ----------------------------------------------------------------");
            
                    String htmlContent = PRE
            
                            + "    <div class=\"wrapper\">\n" + "      <h1 class=\"title\">"
                            + documents.get(j).getTitle() + "</h1>\n" + "\n" + "   <hr/>\n"
            
                            + "<div class=\"formatted_content\">\n" + documents.get(j).getContent() + POST;
            
                    String name = documents.get(j).getTitle().replaceAll("[\\\\/:*?\"<>|]", "_");
            
                    
            
                    System.out.println();
            
                    String xhtml = embedImagesAsBase64(htmlContent); // Ja està ben formatat i no cal convertir a XHTML  
                    
                    Files.write(new File(base, name + ".html").toPath(), xhtml.getBytes());
            
                    convertHtmlToOdtViaUNO(xhtml, new File(base, name + ".odt"), documents.get(j).getTitle());
            
                    System.out.println(" ----------------------------------------------------------------");
            
                }
            }
            
*/
            Folder[] folders = tu.getFolders(projectID, folderID);

            if (folders != null) {

                System.out.println("FOLDERS LEN : " + folders.length);

                for (int i = 0; i < folders.length; i++) {
                    System.out.println();
                    System.out.println("---------------------------------------------");
                    System.out.println("FOLDER[" + folders[i].getId() + "] Titol: " + folders[i].getTitle());
                    //System.out.println("FOLDER[" + i + "] tipus: " + folders[i].getType());

                    //System.out.println("FOLDER[" + i + "] URL: " + folders[i].getVaultsUrl());

                    String name = folders[i].getTitle();

                    name = name.replaceAll("[\\\\/:*?\"<>|]", "_").trim();

                    File folderFile = new File(base, name);
                    if (!folderFile.exists()) {
                        folderFile.mkdirs();
                    }

                    listFolders(tu, projectID, folders[i].getId(), folderFile);

                }

            }
        }

    }
    
    

    public static String embedImagesAsBase64(String html) throws Exception {
        org.jsoup.nodes.Document doc = Jsoup.parse(html);

        for (Element img : doc.select("img")) {
            String urlStr = firstUrl(img);
            if (urlStr == null) continue;

            byte[] data = download(urlStr);
            String mime = detectMime(urlStr, data);
            String base64 = Base64.getEncoder().encodeToString(data);

            img.removeAttr("srcset");
            img.attr("src", "data:" + mime + ";base64," + base64);
        }
        return doc.outerHtml();
    }

    private static String firstUrl(Element img) {
        String src = img.attr("abs:src");
        if (src != null && !src.isEmpty()) return src;

        String srcset = img.attr("srcset");
        if (srcset == null || srcset.isEmpty()) return null;
        return srcset.split("\\s+")[0]; // first URL before width/dppx
    }

    private static byte[] download(String urlStr) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setInstanceFollowRedirects(true);
        try (InputStream in = conn.getInputStream()) {
            return in.readAllBytes();
        }
    }

    private static String detectMime(String urlStr, byte[] data) {
        // quick guess by extension; default to image/png
        String lower = urlStr.toLowerCase();
        if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) return "image/jpeg";
        if (lower.endsWith(".gif")) return "image/gif";
        if (lower.endsWith(".bmp")) return "image/bmp";
        if (lower.endsWith(".svg")) return "image/svg+xml";
        return "image/png";
    }

    public static void convertHtmlToOdtViaUNO(String htmlContent, File outputOdtFile, String title) throws Exception {

        System.setProperty(OpenOfficeDocumentConverterPlugin.HOST_PROPERTY, "localhost");

        System.setProperty(OpenOfficeDocumentConverterPlugin.PORT_PROPERTY, "8100");

        IDocumentConverterPlugin oodcp = new OpenOfficeDocumentConverterPlugin();

        System.out.println(" ==================================== ");

        InputStream inputData = new ByteArrayInputStream(htmlContent.getBytes(StandardCharsets.UTF_8));

        final String outputFileExtension = "odt";

        FileOutputStream outputData = new FileOutputStream(outputOdtFile);

        String inputFileExtension = "html";
        {
            oodcp.convertDocumentByExtension(inputData, inputFileExtension, outputData, outputFileExtension);
        }
        inputData.close();
        outputData.flush();
        outputData.close();

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
            out.println("\n");
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

    public static final String PRE = "<!DOCTYPE html><html lang=\"en\"><head>\n" + "    <meta charset=\"utf-8\">\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n"
            + "    <style>\n" + "      html {\n" + "        padding: 1em;\n" + "        background: #fff;\n"
            + "        color: #222;\n"
            + "        font-family: \"Lucida Grande\", \"Lucida Sans Unicode\", \"Lucida Sans\", Geneva, Verdana, sans-serif;\n"
            + "        font-size: 100%;\n" + "        line-height: 1.5;\n" + "      }\n" + "\n" + "      h1,\n"
            + "      p,\n" + "      ul,\n" + "      ol,\n" + "      div,\n" + "      figure {\n"
            + "        margin: 0;\n" + "      }\n" + "\n" + "      h1 { font-size: 1.2em; }\n" + "\n" + "      ul {\n"
            + "        list-style: disc;\n" + "        padding-left: 1.3em;\n" + "      }\n" + "\n" + "      ol {\n"
            + "        padding-left: 1.3em;\n" + "        list-style: decimal;\n" + "      }\n" + "\n"
            + "      blockquote {\n" + "        border-left: 3px solid #000;\n" + "        margin: 0;\n"
            + "        padding: 0 0 0 1em;\n" + "      }\n" + "\n" + "      pre {\n"
            + "        font-family: monaco, monospace;\n" + "        font-size: 0.875em;\n" + "        margin: 0;\n"
            + "        padding: 1rem;\n" + "        background: #eee;\n" + "        border-radius: var(--radius-sm);\n"
            + "        white-space: pre;\n" + "        word-wrap: normal;\n" + "        word-break: normal;\n"
            + "        overflow-x: auto;\n" + "      }\n" + "\n" + "      code { border-radius: var(--radius-sm); }\n"
            + "\n" + "      figure {\n" + "        display: inline-block;\n" + "        width: 100%;\n"
            + "        box-sizing: border-box;\n" + "      }\n" + "\n"
            + "      figcaption { word-break: break-word; }\n" + "\n" + "      img {\n" + "        display: block;\n"
            + "        max-width: 100%;\n" + "        margin: 0 auto;\n" + "        padding: 1px;\n"
            + "        border: 1px solid #eee;\n" + "      }\n" + "\n" + "      a {\n" + "        color: #1b6ac9;\n"
            + "        text-decoration: underline;\n" + "      }\n" + "\n" + "      a:active { color: #064ac9; }\n"
            + "\n" + "      .wrapper {\n" + "        max-width: 650px;\n" + "        margin: 0 auto;\n" + "      }\n"
            + "\n" + "      .title {\n" + "        font-size: 2em;\n" + "        margin: 0.5em 0 1em;\n"
            + "        line-height: 1.3;\n" + "      }\n" + "\n" + "      .attachment--image {\n"
            + "        text-align: center;\n" + "        color: #888;\n" + "        font-size: 0.875em;\n" + "      }\n"
            + "\n" + "      .attachment--file {\n" + "        position: relative;\n"
            + "        padding: 1.4em 1em 1.5em;\n" + "        border: 1px solid #ddd;\n"
            + "        border-bottom-width: 3px;\n" + "        border-radius: var(--radius-md);\n"
            + "        color: #222;\n" + "      }\n" + "\n" + "      .attachment__label {\n"
            + "        position: absolute;\n" + "        bottom: 0;\n" + "        right: 0;\n"
            + "        background: #ddd;\n" + "        font-size: 10px;\n" + "        padding: 2px 6px;\n"
            + "        border-radius: var(--radius-md) 0 var(--radius-sm) 0;\n" + "        color: #888;\n" + "      }\n"
            + "\n" + "      .metadata { color: #888; }\n" + "    </style>\n" + "  </head>\n" + "\n" + "  <body>\n";

    public static final String POST = "</div>\n" + "\n" + "    </div>\n" + "  \n" + "\n" + "</body></html>";

}
