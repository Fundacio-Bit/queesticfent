package org.fundaciobit.queesticfent.back.controller.admin;

import org.fundaciobit.queesticfent.back.controller.webdb.UsuariController;
import org.fundaciobit.queesticfent.back.form.webdb.UsuariFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.UsuariForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = GestioUsuarisAdminController.CONTEXT_WEB)
@SessionAttributes(types = { UsuariForm.class, UsuariFilterForm.class })
public class GestioUsuarisAdminController extends UsuariController{

    public static final String CONTEXT_WEB = "/admin/gestiousuaris";

    @Override
    public String getTileForm() {
        return "gestioUsuariForm";
    }

    @Override
    public String getTileList() {
        return "gestioUsuariList";
    }
  
  
}

