package org.fundaciobit.queesticfent.back.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.queesticfent.back.controller.webdb.ModificacionsQueEsticFentController;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentFilterForm;
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentForm;
import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentJPA;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @author anadal
 *
 */
@Controller
@RequestMapping(value = "/user/entrades")
@SessionAttributes(types = { ModificacionsQueEsticFentForm.class, ModificacionsQueEsticFentFilterForm.class })
public class EntradesUserController extends ModificacionsQueEsticFentController {


    public String getTileForm() {
      return "entradesFormUser";
    }

    public String getTileList() {
      return "entradesListUser";
    }

    public String getSessionAttributeFilterForm() {
      return "ModificacionsQueEsticFent_FilterForm_" + this.getClass().getName();
    }


    @Override
    public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
        String userName = request.getRemoteUser();
        return USUARIID.equal(userName);
    }
    
    public ModificacionsQueEsticFentFilterForm getModificacionsQueEsticFentFilterForm(Integer pagina, ModelAndView mav,
            HttpServletRequest request) throws I18NException {
            ModificacionsQueEsticFentFilterForm modificacionsQueEsticFentFilterForm = super.getModificacionsQueEsticFentFilterForm(pagina, mav, request);
            
            if(modificacionsQueEsticFentFilterForm.isNou()) {
                modificacionsQueEsticFentFilterForm.addHiddenField(MODIFICACIOID);
                modificacionsQueEsticFentFilterForm.addHiddenField(QUEESTICFENTID);
                modificacionsQueEsticFentFilterForm.addHiddenField(DADA2);
            }
            
            
            return modificacionsQueEsticFentFilterForm;
          }
    
    public ModificacionsQueEsticFentForm getModificacionsQueEsticFentForm(ModificacionsQueEsticFentJPA _jpa,
            boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
         ModificacionsQueEsticFentForm modificacionsQueEsticFentForm = super.getModificacionsQueEsticFentForm(_jpa, __isView, request, mav);
         modificacionsQueEsticFentForm.addReadOnlyField(USUARIID);
         modificacionsQueEsticFentForm.addHiddenField(MODIFICACIOID);
         modificacionsQueEsticFentForm.addHiddenField(QUEESTICFENTID);
         
         
         
         return modificacionsQueEsticFentForm;
         
       }

  

  
}
