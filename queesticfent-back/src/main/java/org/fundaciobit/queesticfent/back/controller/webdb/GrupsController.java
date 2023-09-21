package org.fundaciobit.queesticfent.back.controller.webdb;

import org.fundaciobit.genapp.common.web.i18n.I18NUtils;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.query.GroupByItem;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.Where;
import org.fundaciobit.genapp.common.i18n.I18NValidationException;
import org.fundaciobit.genapp.common.web.validation.ValidationWebUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.fundaciobit.queesticfent.back.form.webdb.*;
import org.fundaciobit.queesticfent.back.form.webdb.GrupsForm;

import org.fundaciobit.queesticfent.back.validator.webdb.GrupsWebValidator;

import org.fundaciobit.queesticfent.persistence.GrupsJPA;
import org.fundaciobit.queesticfent.model.entity.Grups;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Grups
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/grups")
@SessionAttributes(types = { GrupsForm.class, GrupsFilterForm.class })
public class GrupsController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Grups, java.lang.Long> implements GrupsFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.GrupsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.GrupsService grupsEjb;

  @Autowired
  private GrupsWebValidator grupsWebValidator;

  @Autowired
  protected GrupsRefList grupsRefList;

  /**
   * Llistat de totes Grups
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    GrupsFilterForm ff;
    ff = (GrupsFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Grups de forma paginada
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.GET)
  public ModelAndView llistatPaginat(HttpServletRequest request,
    HttpServletResponse response, @PathVariable Integer pagina)
      throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileList());
    llistat(mav, request, getGrupsFilterForm(pagina, mav, request));
    return mav;
  }

  public GrupsFilterForm getGrupsFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    GrupsFilterForm grupsFilterForm;
    grupsFilterForm = (GrupsFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(grupsFilterForm == null) {
      grupsFilterForm = new GrupsFilterForm();
      grupsFilterForm.setContexte(getContextWeb());
      grupsFilterForm.setEntityNameCode(getEntityNameCode());
      grupsFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      grupsFilterForm.setNou(true);
    } else {
      grupsFilterForm.setNou(false);
    }
    grupsFilterForm.setPage(pagina == null ? 1 : pagina);
    return grupsFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Grups de forma paginada
   * 
   * @param request
   * @param pagina
   * @param filterForm
   * @return
   * @throws I18NException
   */
  @RequestMapping(value = "/list/{pagina}", method = RequestMethod.POST)
  public ModelAndView llistatPaginat(HttpServletRequest request,
      HttpServletResponse response,@PathVariable Integer pagina,
      @ModelAttribute GrupsFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getGrupsFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Grups de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Grups> llistat(ModelAndView mav, HttpServletRequest request,
     GrupsFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Grups> grups = processarLlistat(grupsEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("grupsItems", grups);

    mav.addObject("grupsFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, grups, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, grups);

    return grups;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(GrupsFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Grups> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    GrupsFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Grups> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_GRUPS_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Grups
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearGrupsGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    GrupsForm grupsForm = getGrupsForm(null, false, request, mav);
    mav.addObject("grupsForm" ,grupsForm);
    fillReferencesForForm(grupsForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public GrupsForm getGrupsForm(GrupsJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    GrupsForm grupsForm;
    if(_jpa == null) {
      grupsForm = new GrupsForm(new GrupsJPA(), true);
    } else {
      grupsForm = new GrupsForm(_jpa, false);
      grupsForm.setView(__isView);
    }
    grupsForm.setContexte(getContextWeb());
    grupsForm.setEntityNameCode(getEntityNameCode());
    grupsForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return grupsForm;
  }

  public void fillReferencesForForm(GrupsForm grupsForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Grups
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearGrupsPost(@ModelAttribute GrupsForm grupsForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    GrupsJPA grups = grupsForm.getGrups();

    try {
      preValidate(request, grupsForm, result);
      getWebValidator().validate(grupsForm, result);
      postValidate(request,grupsForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        grups = create(request, grups);
        createMessageSuccess(request, "success.creation", grups.getGrupID());
        grupsForm.setGrups(grups);
        return getRedirectWhenCreated(request, grupsForm);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.creation", null, __e);
      log.error(msg, __e);
      return getTileForm();
    }
  }

  @RequestMapping(value = "/view/{grupID}", method = RequestMethod.GET)
  public ModelAndView veureGrupsGet(@PathVariable("grupID") java.lang.Long grupID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewGrupsGet(grupID,
        request, response, true);
  }


  protected ModelAndView editAndViewGrupsGet(@PathVariable("grupID") java.lang.Long grupID,
      HttpServletRequest request,
      HttpServletResponse response, boolean __isView) throws I18NException {
    if((!__isView) && !isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    } else {
      if(__isView && !isActiveFormView()) {
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
      }
    }
    GrupsJPA grups = findByPrimaryKey(request, grupID);

    if (grups == null) {
      createMessageWarning(request, "error.notfound", grupID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, grupID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      GrupsForm grupsForm = getGrupsForm(grups, __isView, request, mav);
      grupsForm.setView(__isView);
      if(__isView) {
        grupsForm.setAllFieldsReadOnly(ALL_GRUPS_FIELDS);
        grupsForm.setSaveButtonVisible(false);
        grupsForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(grupsForm, request, mav);
      mav.addObject("grupsForm", grupsForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Grups existent
   */
  @RequestMapping(value = "/{grupID}/edit", method = RequestMethod.GET)
  public ModelAndView editarGrupsGet(@PathVariable("grupID") java.lang.Long grupID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewGrupsGet(grupID,
        request, response, false);
  }



  /**
   * Editar un Grups existent
   */
  @RequestMapping(value = "/{grupID}/edit", method = RequestMethod.POST)
  public String editarGrupsPost(@ModelAttribute GrupsForm grupsForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    GrupsJPA grups = grupsForm.getGrups();

    try {
      preValidate(request, grupsForm, result);
      getWebValidator().validate(grupsForm, result);
      postValidate(request, grupsForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        grups = update(request, grups);
        createMessageSuccess(request, "success.modification", grups.getGrupID());
        status.setComplete();
        return getRedirectWhenModified(request, grupsForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          grups.getGrupID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, grupsForm, __e);
    }

  }


  /**
   * Eliminar un Grups existent
   */
  @RequestMapping(value = "/{grupID}/delete")
  public String eliminarGrups(@PathVariable("grupID") java.lang.Long grupID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Grups grups = this.findByPrimaryKey(request, grupID);
      if (grups == null) {
        String __msg = createMessageError(request, "error.notfound", grupID);
        return getRedirectWhenDelete(request, grupID, new Exception(__msg));
      } else {
        delete(request, grups);
        createMessageSuccess(request, "success.deleted", grupID);
        return getRedirectWhenDelete(request, grupID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", grupID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, grupID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute GrupsFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarGrups(stringToPK(seleccionats[i]), request, response);
    }
  }
  if (redirect == null) {
    redirect = getRedirectWhenDelete(request, null,null);
  }

  return redirect;
}



public java.lang.Long stringToPK(String value) {
  return java.lang.Long.parseLong(value, 10);
}

  @Override
  public String[] getArgumentsMissatge(Object __grupID, Throwable e) {
    java.lang.Long grupID = (java.lang.Long)__grupID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (grupID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(grupID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "grups.grups";
  }

  public String getEntityNameCodePlural() {
    return "grups.grups.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("grups.grupID");
  }

  @InitBinder("grupsFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("grupsForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "grups.grupID");
  }

  public GrupsWebValidator getWebValidator() {
    return grupsWebValidator;
  }


  public void setWebValidator(GrupsWebValidator __val) {
    if (__val != null) {
      this.grupsWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Grups
   */
  @RequestMapping(value = "/{grupID}/cancel")
  public String cancelGrups(@PathVariable("grupID") java.lang.Long grupID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, grupID);
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

  // Mètodes a sobreescriure 

  public boolean isActiveList() {
    return true;
  }


  public boolean isActiveFormNew() {
    return true;
  }


  public boolean isActiveFormEdit() {
    return true;
  }


  public boolean isActiveDelete() {
    return true;
  }


  public boolean isActiveFormView() {
    return isActiveFormEdit();
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,GrupsForm grupsForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,GrupsForm grupsForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, GrupsFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, GrupsFilterForm filterForm,  List<Grups> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, GrupsForm grupsForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, GrupsForm grupsForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long grupID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long grupID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "grupsFormWebDB";
  }

  public String getTileList() {
    return "grupsListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Grups_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public GrupsJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long grupID) throws I18NException {
    return (GrupsJPA) grupsEjb.findByPrimaryKey(grupID);
  }


  public GrupsJPA create(HttpServletRequest request, GrupsJPA grups)
    throws I18NException, I18NValidationException {
    return (GrupsJPA) grupsEjb.create(grups);
  }


  public GrupsJPA update(HttpServletRequest request, GrupsJPA grups)
    throws I18NException, I18NValidationException {
    return (GrupsJPA) grupsEjb.update(grups);
  }


  public void delete(HttpServletRequest request, Grups grups) throws I18NException {
    grupsEjb.delete(grups);
  }

} // Final de Classe

