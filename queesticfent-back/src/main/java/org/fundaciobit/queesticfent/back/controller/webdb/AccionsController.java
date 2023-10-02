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
import org.fundaciobit.queesticfent.back.form.webdb.AccionsForm;

import org.fundaciobit.queesticfent.back.validator.webdb.AccionsWebValidator;

import org.fundaciobit.queesticfent.persistence.AccionsJPA;
import org.fundaciobit.queesticfent.model.entity.Accions;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Accions
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/accions")
@SessionAttributes(types = { AccionsForm.class, AccionsFilterForm.class })
public class AccionsController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Accions, java.lang.Long> implements AccionsFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccionsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccionsService accionsEjb;

  @Autowired
  private AccionsWebValidator accionsWebValidator;

  @Autowired
  protected AccionsRefList accionsRefList;

  /**
   * Llistat de totes Accions
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    AccionsFilterForm ff;
    ff = (AccionsFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Accions de forma paginada
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
    llistat(mav, request, getAccionsFilterForm(pagina, mav, request));
    return mav;
  }

  public AccionsFilterForm getAccionsFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    AccionsFilterForm accionsFilterForm;
    accionsFilterForm = (AccionsFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(accionsFilterForm == null) {
      accionsFilterForm = new AccionsFilterForm();
      accionsFilterForm.setContexte(getContextWeb());
      accionsFilterForm.setEntityNameCode(getEntityNameCode());
      accionsFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      accionsFilterForm.setNou(true);
    } else {
      accionsFilterForm.setNou(false);
    }
    accionsFilterForm.setPage(pagina == null ? 1 : pagina);
    return accionsFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Accions de forma paginada
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
      @ModelAttribute AccionsFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getAccionsFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Accions de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Accions> llistat(ModelAndView mav, HttpServletRequest request,
     AccionsFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Accions> accions = processarLlistat(accionsEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("accionsItems", accions);

    mav.addObject("accionsFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, accions, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, accions);

    return accions;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(AccionsFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Accions> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    AccionsFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Accions> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_ACCIONS_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Accions
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearAccionsGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    AccionsForm accionsForm = getAccionsForm(null, false, request, mav);
    mav.addObject("accionsForm" ,accionsForm);
    fillReferencesForForm(accionsForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public AccionsForm getAccionsForm(AccionsJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    AccionsForm accionsForm;
    if(_jpa == null) {
      accionsForm = new AccionsForm(new AccionsJPA(), true);
    } else {
      accionsForm = new AccionsForm(_jpa, false);
      accionsForm.setView(__isView);
    }
    accionsForm.setContexte(getContextWeb());
    accionsForm.setEntityNameCode(getEntityNameCode());
    accionsForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return accionsForm;
  }

  public void fillReferencesForForm(AccionsForm accionsForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Accions
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearAccionsPost(@ModelAttribute AccionsForm accionsForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    AccionsJPA accions = accionsForm.getAccions();

    try {
      preValidate(request, accionsForm, result);
      getWebValidator().validate(accionsForm, result);
      postValidate(request,accionsForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        accions = create(request, accions);
        createMessageSuccess(request, "success.creation", accions.getAccioID());
        accionsForm.setAccions(accions);
        return getRedirectWhenCreated(request, accionsForm);
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

  @RequestMapping(value = "/view/{accioID}", method = RequestMethod.GET)
  public ModelAndView veureAccionsGet(@PathVariable("accioID") java.lang.Long accioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewAccionsGet(accioID,
        request, response, true);
  }


  protected ModelAndView editAndViewAccionsGet(@PathVariable("accioID") java.lang.Long accioID,
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
    AccionsJPA accions = findByPrimaryKey(request, accioID);

    if (accions == null) {
      createMessageWarning(request, "error.notfound", accioID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, accioID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      AccionsForm accionsForm = getAccionsForm(accions, __isView, request, mav);
      accionsForm.setView(__isView);
      if(__isView) {
        accionsForm.setAllFieldsReadOnly(ALL_ACCIONS_FIELDS);
        accionsForm.setSaveButtonVisible(false);
        accionsForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(accionsForm, request, mav);
      mav.addObject("accionsForm", accionsForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Accions existent
   */
  @RequestMapping(value = "/{accioID}/edit", method = RequestMethod.GET)
  public ModelAndView editarAccionsGet(@PathVariable("accioID") java.lang.Long accioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewAccionsGet(accioID,
        request, response, false);
  }



  /**
   * Editar un Accions existent
   */
  @RequestMapping(value = "/{accioID}/edit", method = RequestMethod.POST)
  public String editarAccionsPost(@ModelAttribute AccionsForm accionsForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    AccionsJPA accions = accionsForm.getAccions();

    try {
      preValidate(request, accionsForm, result);
      getWebValidator().validate(accionsForm, result);
      postValidate(request, accionsForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        accions = update(request, accions);
        createMessageSuccess(request, "success.modification", accions.getAccioID());
        status.setComplete();
        return getRedirectWhenModified(request, accionsForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          accions.getAccioID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, accionsForm, __e);
    }

  }


  /**
   * Eliminar un Accions existent
   */
  @RequestMapping(value = "/{accioID}/delete")
  public String eliminarAccions(@PathVariable("accioID") java.lang.Long accioID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Accions accions = this.findByPrimaryKey(request, accioID);
      if (accions == null) {
        String __msg = createMessageError(request, "error.notfound", accioID);
        return getRedirectWhenDelete(request, accioID, new Exception(__msg));
      } else {
        delete(request, accions);
        createMessageSuccess(request, "success.deleted", accioID);
        return getRedirectWhenDelete(request, accioID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", accioID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, accioID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute AccionsFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarAccions(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __accioID, Throwable e) {
    java.lang.Long accioID = (java.lang.Long)__accioID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (accioID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(accioID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "accions.accions";
  }

  public String getEntityNameCodePlural() {
    return "accions.accions.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("accions.accioID");
  }

  @InitBinder("accionsFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("accionsForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "accions.accioID");
  }

  public AccionsWebValidator getWebValidator() {
    return accionsWebValidator;
  }


  public void setWebValidator(AccionsWebValidator __val) {
    if (__val != null) {
      this.accionsWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Accions
   */
  @RequestMapping(value = "/{accioID}/cancel")
  public String cancelAccions(@PathVariable("accioID") java.lang.Long accioID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, accioID);
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

  public void preValidate(HttpServletRequest request,AccionsForm accionsForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,AccionsForm accionsForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, AccionsFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, AccionsFilterForm filterForm,  List<Accions> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, AccionsForm accionsForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, AccionsForm accionsForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long accioID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long accioID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "accionsFormWebDB";
  }

  public String getTileList() {
    return "accionsListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Accions_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public AccionsJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long accioID) throws I18NException {
    return (AccionsJPA) accionsEjb.findByPrimaryKey(accioID);
  }


  public AccionsJPA create(HttpServletRequest request, AccionsJPA accions)
    throws I18NException, I18NValidationException {
    return (AccionsJPA) accionsEjb.create(accions);
  }


  public AccionsJPA update(HttpServletRequest request, AccionsJPA accions)
    throws I18NException, I18NValidationException {
    return (AccionsJPA) accionsEjb.update(accions);
  }


  public void delete(HttpServletRequest request, Accions accions) throws I18NException {
    accionsEjb.delete(accions);
  }

} // Final de Classe

