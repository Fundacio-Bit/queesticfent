package org.fundaciobit.queesticfent.back.controller.admin;

import org.fundaciobit.queesticfent.back.controller.webdb.FestiusController;
import org.fundaciobit.queesticfent.back.form.webdb.FestiusFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.FestiusForm;
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
@SessionAttributes(types = { FestiusForm.class, FestiusFilterForm.class })
public class GestioFestiusAdminController extends FestiusController{

    public static final String CONTEXT_WEB = "/admin/gestiofestius";
    
    
    @Override
    public String getTileForm() {
        return "gestioFestiusForm";
    }

    @Override
    public String getTileList() {
        return "gestioFestiusList";
    }

    /*@Override
    public String getSessionAttributeFilterForm() {
        return "GestioFestius_FilterForm_" + this.getClass().getName();
    }*/
  
}
