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
import org.fundaciobit.queesticfent.back.form.webdb.DepartamentsForm;

import org.fundaciobit.queesticfent.back.validator.webdb.DepartamentsWebValidator;

import org.fundaciobit.queesticfent.persistence.DepartamentsJPA;
import org.fundaciobit.queesticfent.model.entity.Departaments;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Departaments
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/departaments")
@SessionAttributes(types = { DepartamentsForm.class, DepartamentsFilterForm.class })
public class DepartamentsController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Departaments, java.lang.Long> implements DepartamentsFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.DepartamentsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.DepartamentsService departamentsEjb;

  @Autowired
  private DepartamentsWebValidator departamentsWebValidator;

  @Autowired
  protected DepartamentsRefList departamentsRefList;

  /**
   * Llistat de totes Departaments
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    DepartamentsFilterForm ff;
    ff = (DepartamentsFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Departaments de forma paginada
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
    llistat(mav, request, getDepartamentsFilterForm(pagina, mav, request));
    return mav;
  }

  public DepartamentsFilterForm getDepartamentsFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    DepartamentsFilterForm departamentsFilterForm;
    departamentsFilterForm = (DepartamentsFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(departamentsFilterForm == null) {
      departamentsFilterForm = new DepartamentsFilterForm();
      departamentsFilterForm.setContexte(getContextWeb());
      departamentsFilterForm.setEntityNameCode(getEntityNameCode());
      departamentsFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      departamentsFilterForm.setNou(true);
    } else {
      departamentsFilterForm.setNou(false);
    }
    departamentsFilterForm.setPage(pagina == null ? 1 : pagina);
    return departamentsFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Departaments de forma paginada
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
      @ModelAttribute DepartamentsFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getDepartamentsFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Departaments de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Departaments> llistat(ModelAndView mav, HttpServletRequest request,
     DepartamentsFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Departaments> departaments = processarLlistat(departamentsEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("departamentsItems", departaments);

    mav.addObject("departamentsFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, departaments, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, departaments);

    return departaments;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(DepartamentsFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Departaments> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    DepartamentsFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Departaments> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_DEPARTAMENTS_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Departaments
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearDepartamentsGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    DepartamentsForm departamentsForm = getDepartamentsForm(null, false, request, mav);
    mav.addObject("departamentsForm" ,departamentsForm);
    fillReferencesForForm(departamentsForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public DepartamentsForm getDepartamentsForm(DepartamentsJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    DepartamentsForm departamentsForm;
    if(_jpa == null) {
      departamentsForm = new DepartamentsForm(new DepartamentsJPA(), true);
    } else {
      departamentsForm = new DepartamentsForm(_jpa, false);
      departamentsForm.setView(__isView);
    }
    departamentsForm.setContexte(getContextWeb());
    departamentsForm.setEntityNameCode(getEntityNameCode());
    departamentsForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return departamentsForm;
  }

  public void fillReferencesForForm(DepartamentsForm departamentsForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Departaments
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearDepartamentsPost(@ModelAttribute DepartamentsForm departamentsForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    DepartamentsJPA departaments = departamentsForm.getDepartaments();

    try {
      preValidate(request, departamentsForm, result);
      getWebValidator().validate(departamentsForm, result);
      postValidate(request,departamentsForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        departaments = create(request, departaments);
        createMessageSuccess(request, "success.creation", departaments.getDepartamentID());
        departamentsForm.setDepartaments(departaments);
        return getRedirectWhenCreated(request, departamentsForm);
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

  @RequestMapping(value = "/view/{departamentID}", method = RequestMethod.GET)
  public ModelAndView veureDepartamentsGet(@PathVariable("departamentID") java.lang.Long departamentID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewDepartamentsGet(departamentID,
        request, response, true);
  }


  protected ModelAndView editAndViewDepartamentsGet(@PathVariable("departamentID") java.lang.Long departamentID,
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
    DepartamentsJPA departaments = findByPrimaryKey(request, departamentID);

    if (departaments == null) {
      createMessageWarning(request, "error.notfound", departamentID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, departamentID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      DepartamentsForm departamentsForm = getDepartamentsForm(departaments, __isView, request, mav);
      departamentsForm.setView(__isView);
      if(__isView) {
        departamentsForm.setAllFieldsReadOnly(ALL_DEPARTAMENTS_FIELDS);
        departamentsForm.setSaveButtonVisible(false);
        departamentsForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(departamentsForm, request, mav);
      mav.addObject("departamentsForm", departamentsForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Departaments existent
   */
  @RequestMapping(value = "/{departamentID}/edit", method = RequestMethod.GET)
  public ModelAndView editarDepartamentsGet(@PathVariable("departamentID") java.lang.Long departamentID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewDepartamentsGet(departamentID,
        request, response, false);
  }



  /**
   * Editar un Departaments existent
   */
  @RequestMapping(value = "/{departamentID}/edit", method = RequestMethod.POST)
  public String editarDepartamentsPost(@ModelAttribute DepartamentsForm departamentsForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    DepartamentsJPA departaments = departamentsForm.getDepartaments();

    try {
      preValidate(request, departamentsForm, result);
      getWebValidator().validate(departamentsForm, result);
      postValidate(request, departamentsForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        departaments = update(request, departaments);
        createMessageSuccess(request, "success.modification", departaments.getDepartamentID());
        status.setComplete();
        return getRedirectWhenModified(request, departamentsForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          departaments.getDepartamentID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, departamentsForm, __e);
    }

  }


  /**
   * Eliminar un Departaments existent
   */
  @RequestMapping(value = "/{departamentID}/delete")
  public String eliminarDepartaments(@PathVariable("departamentID") java.lang.Long departamentID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Departaments departaments = this.findByPrimaryKey(request, departamentID);
      if (departaments == null) {
        String __msg = createMessageError(request, "error.notfound", departamentID);
        return getRedirectWhenDelete(request, departamentID, new Exception(__msg));
      } else {
        delete(request, departaments);
        createMessageSuccess(request, "success.deleted", departamentID);
        return getRedirectWhenDelete(request, departamentID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", departamentID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, departamentID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute DepartamentsFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarDepartaments(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __departamentID, Throwable e) {
    java.lang.Long departamentID = (java.lang.Long)__departamentID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (departamentID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(departamentID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "departaments.departaments";
  }

  public String getEntityNameCodePlural() {
    return "departaments.departaments.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("departaments.departamentID");
  }

  @InitBinder("departamentsFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("departamentsForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "departaments.departamentID");
  }

  public DepartamentsWebValidator getWebValidator() {
    return departamentsWebValidator;
  }


  public void setWebValidator(DepartamentsWebValidator __val) {
    if (__val != null) {
      this.departamentsWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Departaments
   */
  @RequestMapping(value = "/{departamentID}/cancel")
  public String cancelDepartaments(@PathVariable("departamentID") java.lang.Long departamentID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, departamentID);
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

  public void preValidate(HttpServletRequest request,DepartamentsForm departamentsForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,DepartamentsForm departamentsForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, DepartamentsFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, DepartamentsFilterForm filterForm,  List<Departaments> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, DepartamentsForm departamentsForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, DepartamentsForm departamentsForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long departamentID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long departamentID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "departamentsFormWebDB";
  }

  public String getTileList() {
    return "departamentsListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Departaments_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public DepartamentsJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long departamentID) throws I18NException {
    return (DepartamentsJPA) departamentsEjb.findByPrimaryKey(departamentID);
  }


  public DepartamentsJPA create(HttpServletRequest request, DepartamentsJPA departaments)
    throws I18NException, I18NValidationException {
    return (DepartamentsJPA) departamentsEjb.create(departaments);
  }


  public DepartamentsJPA update(HttpServletRequest request, DepartamentsJPA departaments)
    throws I18NException, I18NValidationException {
    return (DepartamentsJPA) departamentsEjb.update(departaments);
  }


  public void delete(HttpServletRequest request, Departaments departaments) throws I18NException {
    departamentsEjb.delete(departaments);
  }

} // Final de Classe

