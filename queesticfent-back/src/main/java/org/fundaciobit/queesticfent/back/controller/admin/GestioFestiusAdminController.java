package org.fundaciobit.queesticfent.back.controller.admin;

import org.fundaciobit.queesticfent.back.controller.webdb.FestiuController;
import org.fundaciobit.queesticfent.back.form.webdb.FestiuFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.FestiuForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = GestioFestiusAdminController.CONTEXT_WEB)
@SessionAttributes(types = { FestiuForm.class, FestiuFilterForm.class })
public class GestioFestiusAdminController extends FestiuController{

    public static final String CONTEXT_WEB = "/admin/gestiofestius";
    
    
    @Override
    public String getTileForm() {
        return "gestioFestiuForm";
    }

    @Override
    public String getTileList() {
        return "gestioFestiuList";
    }

    /*@Override
    public String getSessionAttributeFilterForm() {
        return "GestioFestius_FilterForm_" + this.getClass().getName();
    }*/
  
}
