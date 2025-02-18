package org.fundaciobit.queesticfent.back.controller.admin;


import org.fundaciobit.queesticfent.back.controller.webdb.ProjecteController;
import org.fundaciobit.queesticfent.back.form.webdb.ProjecteFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.ProjecteForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = GestioProjectesAdminController.CONTEXT_WEB)
@SessionAttributes(types = { ProjecteForm.class, ProjecteFilterForm.class })
public class GestioProjectesAdminController extends ProjecteController{

    public static final String CONTEXT_WEB = "/admin/gestioprojectes";

    @Override
    public String getTileForm() {
        return "gestioProjecteForm";
    }

    @Override
    public String getTileList() {
        return "gestioProjecteList";
    }
  
  
}

