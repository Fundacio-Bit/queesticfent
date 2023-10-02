package org.fundaciobit.queesticfent.back.controller.admin;

import org.fundaciobit.queesticfent.back.controller.webdb.PersonalProjecteController;
import org.fundaciobit.queesticfent.back.form.webdb.PersonalProjecteFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.PersonalProjecteForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = GestioUsuarisProjecteAdminController.CONTEXT_WEB)
@SessionAttributes(types = { PersonalProjecteForm.class, PersonalProjecteFilterForm.class })
public class GestioUsuarisProjecteAdminController extends PersonalProjecteController{

    public static final String CONTEXT_WEB = "/admin/gestiousuarisprojecte";

    @Override
    public String getTileForm() {
        return "gestioUsuarisProjecteForm";
    }

    @Override
    public String getTileList() {
        return "gestioUsuarisProjecteList";
    }
  
  
}
