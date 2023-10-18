package org.fundaciobit.queesticfent.back.controller.common;

import org.fundaciobit.queesticfent.back.security.AuthenticationSuccessListener;
import org.fundaciobit.queesticfent.back.security.LoginInfo;
import org.fundaciobit.queesticfent.commons.utils.Configuracio;
import org.fundaciobit.queesticfent.commons.utils.Constants;
import org.fundaciobit.queesticfent.model.fields.UsuarisDepartamentFields;
import org.apache.log4j.Logger;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.web.HtmlUtils;
import org.fundaciobit.pluginsib.userinformation.IUserInformationPlugin;
import org.fundaciobit.pluginsib.userinformation.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @autor anadal
 * 
 */
@Controller
public class PrincipalController {

    protected final Logger log = Logger.getLogger(getClass());

    @EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService.JNDI_NAME)
    protected org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService usuarisDepartamentEjb;

    @RequestMapping(value = "/common/principal.html")
    public ModelAndView principal(HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Boolean initialized = (Boolean) session.getAttribute("inicialitzat");

        if (initialized == null) {
            HtmlUtils.saveMessageInfo(request, "MessageInfo : Benvingut a queesticfent");
            session.setAttribute("inicialitzat", true);

            List<Long> departaments;

            IUserInformationPlugin plugin = AuthenticationSuccessListener.getUserInformationPluginInstance();

            LoginInfo li = LoginInfo.getInstance();
            UserInfo info = plugin.getUserInfoByUserName(li.getUsername());

            Where wud = UsuarisDepartamentFields.USUARIID.equal(info.getUsername());
            departaments = usuarisDepartamentEjb.executeQuery(UsuarisDepartamentFields.DEPARTAMENTID, wud);

            log.info("XXX XYZ departaments: " + departaments.size());

            if (departaments.isEmpty()) {
                HtmlUtils.saveMessageError(request,
                        "ADVERTENCIA: El teu usuari no té cap departament assignat. Contacta amb el teu administrador perque t'assigni un departament, creant una nova entrada per al teu usuari al menú d'Usuaris Departament.");
            } else {

                if (LoginInfo.hasRole(Constants.ROLE_USER)) {
                    return new ModelAndView(new RedirectView("/user/entrades/llistatentrades", true));
                } else if (LoginInfo.hasRole(Constants.ROLE_ADMIN)) {
                    return new ModelAndView(new RedirectView("/admin/gestiofestius/list", true));
                } else {
                    HtmlUtils.saveMessageWarning(request,
                            "ADVERTENCIA: El teu usuari no té assignat cap rol d'usuari o administrador, i per tant no podra fer ús de cap funcionalitat de l'aplicació. Contacta amb l'administrador per obtenir permisos d'usuari o administrador.");
                }
            }
        }

        return new ModelAndView("principal");

    }

    @RequestMapping(value = "/canviarIdioma/{idioma}", method = RequestMethod.GET)
    public ModelAndView canviarIdioma(HttpServletRequest request, HttpServletResponse response,
            @PathVariable(name = "idioma") String idioma) throws Exception {
        org.fundaciobit.queesticfent.back.utils.queesticfentSessionLocaleResolver.setLocaleManually(request, idioma);
        return new ModelAndView("principal");
    }

    @RequestMapping(value = "/canviarPipella", method = RequestMethod.GET)
    public ModelAndView canviarPipella(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return canviarPipella(request, response, null);
    }

    @RequestMapping(value = "/canviarPipella/{pipella}", method = RequestMethod.GET)
    public ModelAndView canviarPipella(HttpServletRequest request, HttpServletResponse response,
            @PathVariable String pipella) throws Exception {

        if (pipella != null && pipella.trim().length() != 0) {

            // TODO GENAPP Afegir altres pipelles !!!!!
            /*
             * if ("ROLE_ADEN".equals(pipella)) { //return new ModelAndView("role_aden");
             * return new ModelAndView(new RedirectView("/aden/peticionscaducades/list/1",
             * true)); }
             */

            if ("admin".equals(pipella)) {
                return new ModelAndView(new RedirectView("/admin/gestiofestius/list", true));
            }

            if ("user".equals(pipella)) {
                return new ModelAndView(new RedirectView("/user/entrades/llistatentrades", true));
            }

            if ("webdb".equals(pipella)) {
                return new ModelAndView("webdb");
            }

            if (Configuracio.isDesenvolupament() && "desenvolupament".equals(pipella)) {
                return new ModelAndView("desenvolupament");
            }

            log.error("S'ha accedit a canviarPipella amb un paràmetre desconegut: " + pipella);
        }

        return new ModelAndView("principal");
    }

}
