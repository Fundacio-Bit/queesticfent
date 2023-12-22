package org.fundaciobit.queesticfent.back.controller.admin;

import org.fundaciobit.queesticfent.back.controller.webdb.UsuarisController;
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
@RequestMapping(value = GestioUsuarisAdminController.CONTEXT_WEB)
@SessionAttributes(types = { UsuarisForm.class, UsuarisFilterForm.class })
public class GestioUsuarisAdminController extends UsuarisController{

    public static final String CONTEXT_WEB = "/admin/gestiousuaris";

    @Override
    public String getTileForm() {
        return "gestioUsuarisForm";
    }

    @Override
    public String getTileList() {
        return "gestioUsuarisList";
    }
  
  
}

