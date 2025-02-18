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
import org.fundaciobit.queesticfent.back.form.webdb.AccioForm;

import org.fundaciobit.queesticfent.back.validator.webdb.AccioWebValidator;

import org.fundaciobit.queesticfent.persistence.AccioJPA;
import org.fundaciobit.queesticfent.model.entity.Accio;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un Accio
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="accio.accio.plural", order=0, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/accio")
@SessionAttributes(types = { AccioForm.class, AccioFilterForm.class })
public class AccioController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Accio, java.lang.Long> implements AccioFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccioService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccioService accioEjb;

  @Autowired
  private AccioWebValidator accioWebValidator;

  @Autowired
  protected AccioRefList accioRefList;

  /**
   * Llistat de totes Accio
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    AccioFilterForm ff;
    ff = (AccioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Accio de forma paginada
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
    llistat(mav, request, getAccioFilterForm(pagina, mav, request));
    return mav;
  }

  public AccioFilterForm getAccioFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    AccioFilterForm accioFilterForm;
    accioFilterForm = (AccioFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(accioFilterForm == null) {
      accioFilterForm = new AccioFilterForm();
      accioFilterForm.setContexte(getContextWeb());
      accioFilterForm.setEntityNameCode(getEntityNameCode());
      accioFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      accioFilterForm.setNou(true);
    } else {
      accioFilterForm.setNou(false);
    }
    accioFilterForm.setPage(pagina == null ? 1 : pagina);
    return accioFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Accio de forma paginada
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
      @ModelAttribute AccioFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getAccioFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Accio de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Accio> llistat(ModelAndView mav, HttpServletRequest request,
     AccioFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Accio> accio = processarLlistat(accioEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("accioItems", accio);

    mav.addObject("accioFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, accio, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, accio);

    return accio;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(AccioFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Accio> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    AccioFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Accio> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_ACCIO_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Accio
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearAccioGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    AccioForm accioForm = getAccioForm(null, false, request, mav);
    mav.addObject("accioForm" ,accioForm);
    fillReferencesForForm(accioForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public AccioForm getAccioForm(AccioJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    AccioForm accioForm;
    if(_jpa == null) {
      accioForm = new AccioForm(new AccioJPA(), true);
    } else {
      accioForm = new AccioForm(_jpa, false);
      accioForm.setView(__isView);
    }
    accioForm.setContexte(getContextWeb());
    accioForm.setEntityNameCode(getEntityNameCode());
    accioForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return accioForm;
  }

  public void fillReferencesForForm(AccioForm accioForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Accio
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearAccioPost(@ModelAttribute AccioForm accioForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    AccioJPA accio = accioForm.getAccio();

    try {
      preValidate(request, accioForm, result);
      getWebValidator().validate(accioForm, result);
      postValidate(request,accioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        accio = create(request, accio);
        createMessageSuccess(request, "success.creation", accio.getAccioID());
        accioForm.setAccio(accio);
        return getRedirectWhenCreated(request, accioForm);
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
  public ModelAndView veureAccioGet(@PathVariable("accioID") java.lang.Long accioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewAccioGet(accioID,
        request, response, true);
  }


  protected ModelAndView editAndViewAccioGet(@PathVariable("accioID") java.lang.Long accioID,
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
    AccioJPA accio = findByPrimaryKey(request, accioID);

    if (accio == null) {
      createMessageWarning(request, "error.notfound", accioID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      AccioForm accioForm = getAccioForm(accio, __isView, request, mav);
      accioForm.setView(__isView);
      if(__isView) {
        accioForm.setAllFieldsReadOnly(ALL_ACCIO_FIELDS);
        accioForm.setSaveButtonVisible(false);
        accioForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(accioForm, request, mav);
      mav.addObject("accioForm", accioForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Accio existent
   */
  @RequestMapping(value = "/{accioID}/edit", method = RequestMethod.GET)
  public ModelAndView editarAccioGet(@PathVariable("accioID") java.lang.Long accioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewAccioGet(accioID,
        request, response, false);
  }



  /**
   * Editar un Accio existent
   */
  @RequestMapping(value = "/{accioID}/edit", method = RequestMethod.POST)
  public String editarAccioPost(@ModelAttribute AccioForm accioForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    AccioJPA accio = accioForm.getAccio();

    try {
      preValidate(request, accioForm, result);
      getWebValidator().validate(accioForm, result);
      postValidate(request, accioForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        accio = update(request, accio);
        createMessageSuccess(request, "success.modification", accio.getAccioID());
        status.setComplete();
        return getRedirectWhenModified(request, accioForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          accio.getAccioID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, accioForm, __e);
    }

  }


  /**
   * Eliminar un Accio existent
   */
  @RequestMapping(value = "/{accioID}/delete")
  public String eliminarAccio(@PathVariable("accioID") java.lang.Long accioID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Accio accio = this.findByPrimaryKey(request, accioID);
      if (accio == null) {
        String __msg = createMessageError(request, "error.notfound", accioID);
        return getRedirectWhenDelete(request, accioID, new Exception(__msg));
      } else {
        delete(request, accio);
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
    @ModelAttribute AccioFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarAccio(stringToPK(seleccionats[i]), request, response);
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
    return "accio.accio";
  }

  public String getEntityNameCodePlural() {
    return "accio.accio.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("accio.accioID");
  }

  @InitBinder("accioFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("accioForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "accio.accioID");
  }

  public AccioWebValidator getWebValidator() {
    return accioWebValidator;
  }


  public void setWebValidator(AccioWebValidator __val) {
    if (__val != null) {
      this.accioWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Accio
   */
  @RequestMapping(value = "/{accioID}/cancel")
  public String cancelAccio(@PathVariable("accioID") java.lang.Long accioID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, accioID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de Accio
   */
  @RequestMapping(value = "/cancel")
  public String cancelAccio(HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, null);
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

  public void preValidate(HttpServletRequest request,AccioForm accioForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,AccioForm accioForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, AccioFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, AccioFilterForm filterForm,  List<Accio> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, AccioForm accioForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, AccioForm accioForm, Throwable __e) {
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
    return "accioFormWebDB";
  }

  public String getTileList() {
    return "accioListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Accio_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public AccioJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long accioID) throws I18NException {
    return (AccioJPA) accioEjb.findByPrimaryKey(accioID);
  }


  public AccioJPA create(HttpServletRequest request, AccioJPA accio)
    throws I18NException, I18NValidationException {
    return (AccioJPA) accioEjb.create(accio);
  }


  public AccioJPA update(HttpServletRequest request, AccioJPA accio)
    throws I18NException, I18NValidationException {
    return (AccioJPA) accioEjb.update(accio);
  }


  public void delete(HttpServletRequest request, Accio accio) throws I18NException {
    accioEjb.delete(accio);
  }

} // Final de Classe

