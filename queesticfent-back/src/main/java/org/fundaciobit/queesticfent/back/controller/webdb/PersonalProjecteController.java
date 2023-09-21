package org.fundaciobit.queesticfent.back.controller.webdb;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.utils.Utils;
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
import org.fundaciobit.queesticfent.back.form.webdb.PersonalProjecteForm;

import org.fundaciobit.queesticfent.back.validator.webdb.PersonalProjecteWebValidator;

import org.fundaciobit.queesticfent.persistence.PersonalProjecteJPA;
import org.fundaciobit.queesticfent.model.entity.PersonalProjecte;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un PersonalProjecte
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/personalProjecte")
@SessionAttributes(types = { PersonalProjecteForm.class, PersonalProjecteFilterForm.class })
public class PersonalProjecteController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<PersonalProjecte, java.lang.Long> implements PersonalProjecteFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.PersonalProjecteService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.PersonalProjecteService personalProjecteEjb;

  @Autowired
  private PersonalProjecteWebValidator personalProjecteWebValidator;

  @Autowired
  protected PersonalProjecteRefList personalProjecteRefList;

  // References 
  @Autowired
  protected ProjectesRefList projectesRefList;

  /**
   * Llistat de totes PersonalProjecte
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    PersonalProjecteFilterForm ff;
    ff = (PersonalProjecteFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar PersonalProjecte de forma paginada
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
    llistat(mav, request, getPersonalProjecteFilterForm(pagina, mav, request));
    return mav;
  }

  public PersonalProjecteFilterForm getPersonalProjecteFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    PersonalProjecteFilterForm personalProjecteFilterForm;
    personalProjecteFilterForm = (PersonalProjecteFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(personalProjecteFilterForm == null) {
      personalProjecteFilterForm = new PersonalProjecteFilterForm();
      personalProjecteFilterForm.setContexte(getContextWeb());
      personalProjecteFilterForm.setEntityNameCode(getEntityNameCode());
      personalProjecteFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      personalProjecteFilterForm.setNou(true);
    } else {
      personalProjecteFilterForm.setNou(false);
    }
    personalProjecteFilterForm.setPage(pagina == null ? 1 : pagina);
    return personalProjecteFilterForm;
  }

  /**
   * Segona i següent peticions per llistar PersonalProjecte de forma paginada
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
      @ModelAttribute PersonalProjecteFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getPersonalProjecteFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de PersonalProjecte de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<PersonalProjecte> llistat(ModelAndView mav, HttpServletRequest request,
     PersonalProjecteFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<PersonalProjecte> personalProjecte = processarLlistat(personalProjecteEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("personalProjecteItems", personalProjecte);

    mav.addObject("personalProjecteFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, personalProjecte, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, personalProjecte);

    return personalProjecte;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(PersonalProjecteFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<PersonalProjecte> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field projecteid
    {
      _listSKV = getReferenceListForProjecteid(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfProjectesForProjecteid(_tmp);
      if (filterForm.getGroupByFields().contains(PROJECTEID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PROJECTEID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    PersonalProjecteFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<PersonalProjecte> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_PERSONALPROJECTE_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(PROJECTEID, filterForm.getMapOfProjectesForProjecteid());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou PersonalProjecte
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearPersonalProjecteGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    PersonalProjecteForm personalProjecteForm = getPersonalProjecteForm(null, false, request, mav);
    mav.addObject("personalProjecteForm" ,personalProjecteForm);
    fillReferencesForForm(personalProjecteForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public PersonalProjecteForm getPersonalProjecteForm(PersonalProjecteJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    PersonalProjecteForm personalProjecteForm;
    if(_jpa == null) {
      personalProjecteForm = new PersonalProjecteForm(new PersonalProjecteJPA(), true);
    } else {
      personalProjecteForm = new PersonalProjecteForm(_jpa, false);
      personalProjecteForm.setView(__isView);
    }
    personalProjecteForm.setContexte(getContextWeb());
    personalProjecteForm.setEntityNameCode(getEntityNameCode());
    personalProjecteForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return personalProjecteForm;
  }

  public void fillReferencesForForm(PersonalProjecteForm personalProjecteForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (personalProjecteForm.getListOfProjectesForProjecteid() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForProjecteid(request, mav, personalProjecteForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      personalProjecteForm.setListOfProjectesForProjecteid(_listSKV);
    }
    
  }

  /**
   * Guardar un nou PersonalProjecte
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearPersonalProjectePost(@ModelAttribute PersonalProjecteForm personalProjecteForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    PersonalProjecteJPA personalProjecte = personalProjecteForm.getPersonalProjecte();

    try {
      preValidate(request, personalProjecteForm, result);
      getWebValidator().validate(personalProjecteForm, result);
      postValidate(request,personalProjecteForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        personalProjecte = create(request, personalProjecte);
        createMessageSuccess(request, "success.creation", personalProjecte.getPersonalProjecteId());
        personalProjecteForm.setPersonalProjecte(personalProjecte);
        return getRedirectWhenCreated(request, personalProjecteForm);
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

  @RequestMapping(value = "/view/{personalProjecteId}", method = RequestMethod.GET)
  public ModelAndView veurePersonalProjecteGet(@PathVariable("personalProjecteId") java.lang.Long personalProjecteId,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewPersonalProjecteGet(personalProjecteId,
        request, response, true);
  }


  protected ModelAndView editAndViewPersonalProjecteGet(@PathVariable("personalProjecteId") java.lang.Long personalProjecteId,
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
    PersonalProjecteJPA personalProjecte = findByPrimaryKey(request, personalProjecteId);

    if (personalProjecte == null) {
      createMessageWarning(request, "error.notfound", personalProjecteId);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, personalProjecteId), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      PersonalProjecteForm personalProjecteForm = getPersonalProjecteForm(personalProjecte, __isView, request, mav);
      personalProjecteForm.setView(__isView);
      if(__isView) {
        personalProjecteForm.setAllFieldsReadOnly(ALL_PERSONALPROJECTE_FIELDS);
        personalProjecteForm.setSaveButtonVisible(false);
        personalProjecteForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(personalProjecteForm, request, mav);
      mav.addObject("personalProjecteForm", personalProjecteForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un PersonalProjecte existent
   */
  @RequestMapping(value = "/{personalProjecteId}/edit", method = RequestMethod.GET)
  public ModelAndView editarPersonalProjecteGet(@PathVariable("personalProjecteId") java.lang.Long personalProjecteId,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewPersonalProjecteGet(personalProjecteId,
        request, response, false);
  }



  /**
   * Editar un PersonalProjecte existent
   */
  @RequestMapping(value = "/{personalProjecteId}/edit", method = RequestMethod.POST)
  public String editarPersonalProjectePost(@ModelAttribute PersonalProjecteForm personalProjecteForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    PersonalProjecteJPA personalProjecte = personalProjecteForm.getPersonalProjecte();

    try {
      preValidate(request, personalProjecteForm, result);
      getWebValidator().validate(personalProjecteForm, result);
      postValidate(request, personalProjecteForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        personalProjecte = update(request, personalProjecte);
        createMessageSuccess(request, "success.modification", personalProjecte.getPersonalProjecteId());
        status.setComplete();
        return getRedirectWhenModified(request, personalProjecteForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          personalProjecte.getPersonalProjecteId(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, personalProjecteForm, __e);
    }

  }


  /**
   * Eliminar un PersonalProjecte existent
   */
  @RequestMapping(value = "/{personalProjecteId}/delete")
  public String eliminarPersonalProjecte(@PathVariable("personalProjecteId") java.lang.Long personalProjecteId,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      PersonalProjecte personalProjecte = this.findByPrimaryKey(request, personalProjecteId);
      if (personalProjecte == null) {
        String __msg = createMessageError(request, "error.notfound", personalProjecteId);
        return getRedirectWhenDelete(request, personalProjecteId, new Exception(__msg));
      } else {
        delete(request, personalProjecte);
        createMessageSuccess(request, "success.deleted", personalProjecteId);
        return getRedirectWhenDelete(request, personalProjecteId,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", personalProjecteId, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, personalProjecteId, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute PersonalProjecteFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarPersonalProjecte(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __personalProjecteId, Throwable e) {
    java.lang.Long personalProjecteId = (java.lang.Long)__personalProjecteId;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (personalProjecteId == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(personalProjecteId),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "personalProjecte.personalProjecte";
  }

  public String getEntityNameCodePlural() {
    return "personalProjecte.personalProjecte.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("personalProjecte.personalProjecteId");
  }

  @InitBinder("personalProjecteFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("personalProjecteForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "personalProjecte.personalProjecteId");
  }

  public PersonalProjecteWebValidator getWebValidator() {
    return personalProjecteWebValidator;
  }


  public void setWebValidator(PersonalProjecteWebValidator __val) {
    if (__val != null) {
      this.personalProjecteWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de PersonalProjecte
   */
  @RequestMapping(value = "/{personalProjecteId}/cancel")
  public String cancelPersonalProjecte(@PathVariable("personalProjecteId") java.lang.Long personalProjecteId,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, personalProjecteId);
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


  public List<StringKeyValue> getReferenceListForProjecteid(HttpServletRequest request,
       ModelAndView mav, PersonalProjecteForm personalProjecteForm, Where where)  throws I18NException {
    if (personalProjecteForm.isHiddenField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (personalProjecteForm.isReadOnlyField(PROJECTEID)) {
      _where = ProjectesFields.PROJECTEID.equal(personalProjecteForm.getPersonalProjecte().getProjecteid());
    }
    return getReferenceListForProjecteid(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForProjecteid(HttpServletRequest request,
       ModelAndView mav, PersonalProjecteFilterForm personalProjecteFilterForm,
       List<PersonalProjecte> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (personalProjecteFilterForm.isHiddenField(PROJECTEID)
       && !personalProjecteFilterForm.isGroupByField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PROJECTEID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (PersonalProjecte _item : list) {
        _pkList.add(_item.getProjecteid());
        }
        _w = ProjectesFields.PROJECTEID.in(_pkList);
      }
    return getReferenceListForProjecteid(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForProjecteid(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return projectesRefList.getReferenceList(ProjectesFields.PROJECTEID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,PersonalProjecteForm personalProjecteForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,PersonalProjecteForm personalProjecteForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, PersonalProjecteFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, PersonalProjecteFilterForm filterForm,  List<PersonalProjecte> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, PersonalProjecteForm personalProjecteForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, PersonalProjecteForm personalProjecteForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long personalProjecteId, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long personalProjecteId) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "personalProjecteFormWebDB";
  }

  public String getTileList() {
    return "personalProjecteListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "PersonalProjecte_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public PersonalProjecteJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long personalProjecteId) throws I18NException {
    return (PersonalProjecteJPA) personalProjecteEjb.findByPrimaryKey(personalProjecteId);
  }


  public PersonalProjecteJPA create(HttpServletRequest request, PersonalProjecteJPA personalProjecte)
    throws I18NException, I18NValidationException {
    return (PersonalProjecteJPA) personalProjecteEjb.create(personalProjecte);
  }


  public PersonalProjecteJPA update(HttpServletRequest request, PersonalProjecteJPA personalProjecte)
    throws I18NException, I18NValidationException {
    return (PersonalProjecteJPA) personalProjecteEjb.update(personalProjecte);
  }


  public void delete(HttpServletRequest request, PersonalProjecte personalProjecte) throws I18NException {
    personalProjecteEjb.delete(personalProjecte);
  }

} // Final de Classe

