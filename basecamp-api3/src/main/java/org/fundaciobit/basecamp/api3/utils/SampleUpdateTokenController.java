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
        return new ModelAndView(new RedirectView(UpdateTokenUtils.getGetCodeUrl()));
    }

    @RequestMapping("/token")
    public String token(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {

        try {

            String code = request.getParameter("code");

            System.out.println("CODE => ]" + code + "[");

            TokenResponse tokenInfo = getNewTokenFromCode(client_id, client_secret, redirect_uri, code);

            String token = tokenInfo.getAccessToken();

            Properties prop = new Properties();
            prop.load(new FileInputStream(new File("basecamp_api_3.properties")));
            
            
            File basecampTokenFile = new File(prop.getProperty("basecamp_token_properties_file"));
            
            updateBasecampTokenProperties(basecampTokenFile, token);

            BaseCampApi3 tu = new BaseCampApi3(urlBase, organizationID, basecampTokenFile);

            long projectID = Long.parseLong(prop.getProperty("projectID"));

            Projects[] projects = tu.getProjects();

            return Arrays.toString(projects);

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
