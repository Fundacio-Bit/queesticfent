package org.fundaciobit.queesticfent.back.controller.admin;

import org.fundaciobit.queesticfent.back.controller.webdb.UsuariDepartamentController;
import org.fundaciobit.queesticfent.back.form.webdb.UsuariDepartamentFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.UsuariDepartamentForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = GestioUsuariDepartamentAdminController.CONTEXT_WEB)
@SessionAttributes(types = { UsuariDepartamentForm.class, UsuariDepartamentFilterForm.class })
public class GestioUsuariDepartamentAdminController extends UsuariDepartamentController{

    public static final String CONTEXT_WEB = "/admin/gestioUsuariDepartament";
    
    @Override
    public String getTileForm() {
        return "gestioUsuariDepartamentForm";
    }

    @Override
    public String getTileList() {
        return "gestioUsuariDepartamentList";
    }

 
}
