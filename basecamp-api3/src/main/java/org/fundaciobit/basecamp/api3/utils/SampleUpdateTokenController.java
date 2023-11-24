package org.fundaciobit.basecamp.api3.utils;

//@RestController
/**
 * @author anadal
 *
 */
public class SampleUpdateTokenController {
    
    

    /*
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView(new RedirectView("https://launchpad.37signals.com/authorization/new?client_id=" + client_id + "&redirect_uri=" + redirectUrl + "&type=web_server"));
    }

    @RequestMapping("/token")
    public String token(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

        try {

            String code = request.getParameter("code");

            System.out.println("CODE => ]" + code + "[");

            String url = "https://launchpad.37signals.com/authorization/token";

            String params = "client_id=" + client_id + "&"
                    + "client_secret=" + client_secret + "&" + "type=web_server" + "&"
                    + "redirect_uri=" + redirectUrl + "&" + "code=" + code;

            TokenResponse tokenInfo = httpPostCall(url, params);

            String token = tokenInfo.getAccessToken();

            Properties prop = new Properties();
            prop.load(new FileInputStream(new File("basecamp_api_3.properties")));

            String urlBase = prop.getProperty("urlBase");
            long organizationID = Long.parseLong(prop.getProperty("organizationID"));

            BaseCampApi3 tu = new BaseCampApi3(urlBase, organizationID, token, false);

            long projectID = Long.parseLong(prop.getProperty("projectID"));

            User[] users = tu.getUsers(projectID);

            StringBuilder str = new StringBuilder();
            for (User user : users) {
                str.append(user.toString());
            }

            return str.toString();

        } catch (Exception e) {
            // TODO: handle exception

            String error = "Error actualitzant token: " + e.getMessage();

            e.printStackTrace();

            return error;

        }
        //return "redirect:https://launchpad.37signals.com/authorization/new?client_id=7f827149caf2b1160ad7fdc6897590c55d5f3b0e&redirect_uri=http%3A%2F%2Fanadal:8080/token&type=web_server";
    }
    */

    

}
