package org.fundaciobit.queesticfent.back.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fundaciobit.queesticfent.back.controller.user.LlistatEntradesUserController;
import org.fundaciobit.queesticfent.back.controller.webdb.FestiusController;
import org.fundaciobit.queesticfent.back.form.webdb.FestiusFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.FestiusForm;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

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
