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
import org.fundaciobit.queesticfent.back.form.webdb.EntradesForm;

import org.fundaciobit.queesticfent.back.validator.webdb.EntradesWebValidator;

import org.fundaciobit.queesticfent.persistence.EntradesJPA;
import org.fundaciobit.queesticfent.model.entity.Entrades;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Entrades
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/entrades")
@SessionAttributes(types = { EntradesForm.class, EntradesFilterForm.class })
public class EntradesController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Entrades, java.lang.Long> implements EntradesFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.EntradesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.EntradesService entradesEjb;

  @Autowired
  private EntradesWebValidator entradesWebValidator;

  @Autowired
  protected EntradesRefList entradesRefList;

  // References 
  @Autowired
  protected AccionsRefList accionsRefList;

  // References 
  @Autowired
  protected ProjectesRefList projectesRefList;

  /**
   * Llistat de totes Entrades
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    EntradesFilterForm ff;
    ff = (EntradesFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Entrades de forma paginada
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
    llistat(mav, request, getEntradesFilterForm(pagina, mav, request));
    return mav;
  }

  public EntradesFilterForm getEntradesFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    EntradesFilterForm entradesFilterForm;
    entradesFilterForm = (EntradesFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(entradesFilterForm == null) {
      entradesFilterForm = new EntradesFilterForm();
      entradesFilterForm.setContexte(getContextWeb());
      entradesFilterForm.setEntityNameCode(getEntityNameCode());
      entradesFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      entradesFilterForm.setNou(true);
    } else {
      entradesFilterForm.setNou(false);
    }
    entradesFilterForm.setPage(pagina == null ? 1 : pagina);
    return entradesFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Entrades de forma paginada
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
      @ModelAttribute EntradesFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getEntradesFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Entrades de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Entrades> llistat(ModelAndView mav, HttpServletRequest request,
     EntradesFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Entrades> entrades = processarLlistat(entradesEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("entradesItems", entrades);

    mav.addObject("entradesFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, entrades, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, entrades);

    return entrades;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(EntradesFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Entrades> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field accioid
    {
      _listSKV = getReferenceListForAccioid(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfAccionsForAccioid(_tmp);
      if (filterForm.getGroupByFields().contains(ACCIOID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ACCIOID, false);
      };
    }

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
    EntradesFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Entrades> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_ENTRADES_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(ACCIOID, filterForm.getMapOfAccionsForAccioid());
    __mapping.put(PROJECTEID, filterForm.getMapOfProjectesForProjecteid());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Entrades
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearEntradesGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    EntradesForm entradesForm = getEntradesForm(null, false, request, mav);
    mav.addObject("entradesForm" ,entradesForm);
    fillReferencesForForm(entradesForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public EntradesForm getEntradesForm(EntradesJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    EntradesForm entradesForm;
    if(_jpa == null) {
      entradesForm = new EntradesForm(new EntradesJPA(), true);
    } else {
      entradesForm = new EntradesForm(_jpa, false);
      entradesForm.setView(__isView);
    }
    entradesForm.setContexte(getContextWeb());
    entradesForm.setEntityNameCode(getEntityNameCode());
    entradesForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return entradesForm;
  }

  public void fillReferencesForForm(EntradesForm entradesForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (entradesForm.getListOfAccionsForAccioid() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForAccioid(request, mav, entradesForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      entradesForm.setListOfAccionsForAccioid(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (entradesForm.getListOfProjectesForProjecteid() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForProjecteid(request, mav, entradesForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      entradesForm.setListOfProjectesForProjecteid(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Entrades
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearEntradesPost(@ModelAttribute EntradesForm entradesForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    EntradesJPA entrades = entradesForm.getEntrades();

    try {
      preValidate(request, entradesForm, result);
      getWebValidator().validate(entradesForm, result);
      postValidate(request,entradesForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        entrades = create(request, entrades);
        createMessageSuccess(request, "success.creation", entrades.getEntradaID());
        entradesForm.setEntrades(entrades);
        return getRedirectWhenCreated(request, entradesForm);
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

  @RequestMapping(value = "/view/{entradaID}", method = RequestMethod.GET)
  public ModelAndView veureEntradesGet(@PathVariable("entradaID") java.lang.Long entradaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEntradesGet(entradaID,
        request, response, true);
  }


  protected ModelAndView editAndViewEntradesGet(@PathVariable("entradaID") java.lang.Long entradaID,
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
    EntradesJPA entrades = findByPrimaryKey(request, entradaID);

    if (entrades == null) {
      createMessageWarning(request, "error.notfound", entradaID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, entradaID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      EntradesForm entradesForm = getEntradesForm(entrades, __isView, request, mav);
      entradesForm.setView(__isView);
      if(__isView) {
        entradesForm.setAllFieldsReadOnly(ALL_ENTRADES_FIELDS);
        entradesForm.setSaveButtonVisible(false);
        entradesForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(entradesForm, request, mav);
      mav.addObject("entradesForm", entradesForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Entrades existent
   */
  @RequestMapping(value = "/{entradaID}/edit", method = RequestMethod.GET)
  public ModelAndView editarEntradesGet(@PathVariable("entradaID") java.lang.Long entradaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEntradesGet(entradaID,
        request, response, false);
  }



  /**
   * Editar un Entrades existent
   */
  @RequestMapping(value = "/{entradaID}/edit", method = RequestMethod.POST)
  public String editarEntradesPost(@ModelAttribute EntradesForm entradesForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    EntradesJPA entrades = entradesForm.getEntrades();

    try {
      preValidate(request, entradesForm, result);
      getWebValidator().validate(entradesForm, result);
      postValidate(request, entradesForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        entrades = update(request, entrades);
        createMessageSuccess(request, "success.modification", entrades.getEntradaID());
        status.setComplete();
        return getRedirectWhenModified(request, entradesForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          entrades.getEntradaID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, entradesForm, __e);
    }

  }


  /**
   * Eliminar un Entrades existent
   */
  @RequestMapping(value = "/{entradaID}/delete")
  public String eliminarEntrades(@PathVariable("entradaID") java.lang.Long entradaID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Entrades entrades = this.findByPrimaryKey(request, entradaID);
      if (entrades == null) {
        String __msg = createMessageError(request, "error.notfound", entradaID);
        return getRedirectWhenDelete(request, entradaID, new Exception(__msg));
      } else {
        delete(request, entrades);
        createMessageSuccess(request, "success.deleted", entradaID);
        return getRedirectWhenDelete(request, entradaID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", entradaID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, entradaID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute EntradesFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarEntrades(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __entradaID, Throwable e) {
    java.lang.Long entradaID = (java.lang.Long)__entradaID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (entradaID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(entradaID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "entrades.entrades";
  }

  public String getEntityNameCodePlural() {
    return "entrades.entrades.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("entrades.entradaID");
  }

  @InitBinder("entradesFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("entradesForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "entrades.entradaID");
  }

  public EntradesWebValidator getWebValidator() {
    return entradesWebValidator;
  }


  public void setWebValidator(EntradesWebValidator __val) {
    if (__val != null) {
      this.entradesWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Entrades
   */
  @RequestMapping(value = "/{entradaID}/cancel")
  public String cancelEntrades(@PathVariable("entradaID") java.lang.Long entradaID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, entradaID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de Entrades
   */
  @RequestMapping(value = "/cancel")
  public String cancelEntrades(HttpServletRequest request,HttpServletResponse response) {
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


  public List<StringKeyValue> getReferenceListForAccioid(HttpServletRequest request,
       ModelAndView mav, EntradesForm entradesForm, Where where)  throws I18NException {
    if (entradesForm.isHiddenField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (entradesForm.isReadOnlyField(ACCIOID)) {
      _where = AccionsFields.ACCIOID.equal(entradesForm.getEntrades().getAccioid());
    }
    return getReferenceListForAccioid(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForAccioid(HttpServletRequest request,
       ModelAndView mav, EntradesFilterForm entradesFilterForm,
       List<Entrades> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (entradesFilterForm.isHiddenField(ACCIOID)
       && !entradesFilterForm.isGroupByField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(ACCIOID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Entrades _item : list) {
        _pkList.add(_item.getAccioid());
        }
        _w = AccionsFields.ACCIOID.in(_pkList);
      }
    return getReferenceListForAccioid(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForAccioid(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return accionsRefList.getReferenceList(AccionsFields.ACCIOID, where );
  }


  public List<StringKeyValue> getReferenceListForProjecteid(HttpServletRequest request,
       ModelAndView mav, EntradesForm entradesForm, Where where)  throws I18NException {
    if (entradesForm.isHiddenField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (entradesForm.isReadOnlyField(PROJECTEID)) {
      _where = ProjectesFields.PROJECTEID.equal(entradesForm.getEntrades().getProjecteid());
    }
    return getReferenceListForProjecteid(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForProjecteid(HttpServletRequest request,
       ModelAndView mav, EntradesFilterForm entradesFilterForm,
       List<Entrades> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (entradesFilterForm.isHiddenField(PROJECTEID)
       && !entradesFilterForm.isGroupByField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PROJECTEID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Entrades _item : list) {
        if(_item.getProjecteid() == null) { continue; };
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

  public void preValidate(HttpServletRequest request,EntradesForm entradesForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,EntradesForm entradesForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, EntradesFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, EntradesFilterForm filterForm,  List<Entrades> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, EntradesForm entradesForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, EntradesForm entradesForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long entradaID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long entradaID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "entradesFormWebDB";
  }

  public String getTileList() {
    return "entradesListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Entrades_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public EntradesJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long entradaID) throws I18NException {
    return (EntradesJPA) entradesEjb.findByPrimaryKey(entradaID);
  }


  public EntradesJPA create(HttpServletRequest request, EntradesJPA entrades)
    throws I18NException, I18NValidationException {
    return (EntradesJPA) entradesEjb.create(entrades);
  }


  public EntradesJPA update(HttpServletRequest request, EntradesJPA entrades)
    throws I18NException, I18NValidationException {
    return (EntradesJPA) entradesEjb.update(entrades);
  }


  public void delete(HttpServletRequest request, Entrades entrades) throws I18NException {
    entradesEjb.delete(entrades);
  }

} // Final de Classe

