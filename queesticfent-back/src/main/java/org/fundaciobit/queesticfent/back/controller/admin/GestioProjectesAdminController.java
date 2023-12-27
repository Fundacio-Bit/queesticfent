package org.fundaciobit.queesticfent.back.controller.admin;

import org.fundaciobit.queesticfent.back.controller.webdb.ProjectesController;
import org.fundaciobit.queesticfent.back.controller.webdb.UsuarisController;
import org.fundaciobit.queesticfent.back.form.webdb.ProjectesFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.ProjectesForm;
import org.fundaciobit.queesticfent.back.form.webdb.UsuarisFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.UsuarisForm;
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
@SessionAttributes(types = { ProjectesForm.class, ProjectesFilterForm.class })
public class GestioProjectesAdminController extends ProjectesController{

    public static final String CONTEXT_WEB = "/admin/gestioprojectes";

    @Override
    public String getTileForm() {
        return "gestioProjectesForm";
    }

    @Override
    public String getTileList() {
        return "gestioProjectesList";
    }
  
  
}

