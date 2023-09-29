package org.fundaciobit.queesticfent.back.controller.admin;

import org.fundaciobit.queesticfent.back.controller.webdb.UsuarisDepartamentController;
import org.fundaciobit.queesticfent.back.form.webdb.UsuarisDepartamentFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.UsuarisDepartamentForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = GestioUsuarisDepartamentAdminController.CONTEXT_WEB)
@SessionAttributes(types = { UsuarisDepartamentForm.class, UsuarisDepartamentFilterForm.class })
public class GestioUsuarisDepartamentAdminController extends UsuarisDepartamentController{

    public static final String CONTEXT_WEB = "/admin/gestiousuarisdepartament";
    
    @Override
    public String getTileForm() {
        return "gestioUsuarisDepartamentForm";
    }

    @Override
    public String getTileList() {
        return "gestioUsuarisDepartamentList";
    }

 
}
