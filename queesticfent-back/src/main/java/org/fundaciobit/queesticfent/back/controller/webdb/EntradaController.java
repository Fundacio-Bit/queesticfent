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
import org.fundaciobit.queesticfent.back.form.webdb.EntradaForm;

import org.fundaciobit.queesticfent.back.validator.webdb.EntradaWebValidator;

import org.fundaciobit.queesticfent.persistence.EntradaJPA;
import org.fundaciobit.queesticfent.model.entity.Entrada;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un Entrada
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="entrada.entrada.plural", order=20, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/entrada")
@SessionAttributes(types = { EntradaForm.class, EntradaFilterForm.class })
public class EntradaController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Entrada, java.lang.Long> implements EntradaFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.EntradaService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.EntradaService entradaEjb;

  @Autowired
  private EntradaWebValidator entradaWebValidator;

  @Autowired
  protected EntradaRefList entradaRefList;

  // References 
  @Autowired
  protected AccioRefList accioRefList;

  // References 
  @Autowired
  protected ProjecteRefList projecteRefList;

  /**
   * Llistat de totes Entrada
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    EntradaFilterForm ff;
    ff = (EntradaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Entrada de forma paginada
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
    llistat(mav, request, getEntradaFilterForm(pagina, mav, request));
    return mav;
  }

  public EntradaFilterForm getEntradaFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    EntradaFilterForm entradaFilterForm;
    entradaFilterForm = (EntradaFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(entradaFilterForm == null) {
      entradaFilterForm = new EntradaFilterForm();
      entradaFilterForm.setContexte(getContextWeb());
      entradaFilterForm.setEntityNameCode(getEntityNameCode());
      entradaFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      entradaFilterForm.setNou(true);
    } else {
      entradaFilterForm.setNou(false);
    }
    entradaFilterForm.setPage(pagina == null ? 1 : pagina);
    return entradaFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Entrada de forma paginada
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
      @ModelAttribute EntradaFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getEntradaFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Entrada de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Entrada> llistat(ModelAndView mav, HttpServletRequest request,
     EntradaFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Entrada> entrada = processarLlistat(entradaEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("entradaItems", entrada);

    mav.addObject("entradaFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, entrada, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, entrada);

    return entrada;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(EntradaFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Entrada> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field accioID
    {
      _listSKV = getReferenceListForAccioID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfAccioForAccioID(_tmp);
      if (filterForm.getGroupByFields().contains(ACCIOID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ACCIOID, false);
      };
    }

    // Field projecteID
    {
      _listSKV = getReferenceListForProjecteID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfProjecteForProjecteID(_tmp);
      if (filterForm.getGroupByFields().contains(PROJECTEID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PROJECTEID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    EntradaFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Entrada> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_ENTRADA_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(ACCIOID, filterForm.getMapOfAccioForAccioID());
    __mapping.put(PROJECTEID, filterForm.getMapOfProjecteForProjecteID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Entrada
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearEntradaGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    EntradaForm entradaForm = getEntradaForm(null, false, request, mav);
    mav.addObject("entradaForm" ,entradaForm);
    fillReferencesForForm(entradaForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public EntradaForm getEntradaForm(EntradaJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    EntradaForm entradaForm;
    if(_jpa == null) {
      entradaForm = new EntradaForm(new EntradaJPA(), true);
    } else {
      entradaForm = new EntradaForm(_jpa, false);
      entradaForm.setView(__isView);
    }
    entradaForm.setContexte(getContextWeb());
    entradaForm.setEntityNameCode(getEntityNameCode());
    entradaForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return entradaForm;
  }

  public void fillReferencesForForm(EntradaForm entradaForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (entradaForm.getListOfAccioForAccioID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForAccioID(request, mav, entradaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      entradaForm.setListOfAccioForAccioID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (entradaForm.getListOfProjecteForProjecteID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForProjecteID(request, mav, entradaForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      entradaForm.setListOfProjecteForProjecteID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Entrada
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearEntradaPost(@ModelAttribute EntradaForm entradaForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    EntradaJPA entrada = entradaForm.getEntrada();

    try {
      preValidate(request, entradaForm, result);
      getWebValidator().validate(entradaForm, result);
      postValidate(request,entradaForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        entrada = create(request, entrada);
        createMessageSuccess(request, "success.creation", entrada.getEntradaID());
        entradaForm.setEntrada(entrada);
        return getRedirectWhenCreated(request, entradaForm);
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
  public ModelAndView veureEntradaGet(@PathVariable("entradaID") java.lang.Long entradaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEntradaGet(entradaID,
        request, response, true);
  }


  protected ModelAndView editAndViewEntradaGet(@PathVariable("entradaID") java.lang.Long entradaID,
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
    EntradaJPA entrada = findByPrimaryKey(request, entradaID);

    if (entrada == null) {
      createMessageWarning(request, "error.notfound", entradaID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      EntradaForm entradaForm = getEntradaForm(entrada, __isView, request, mav);
      entradaForm.setView(__isView);
      if(__isView) {
        entradaForm.setAllFieldsReadOnly(ALL_ENTRADA_FIELDS);
        entradaForm.setSaveButtonVisible(false);
        entradaForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(entradaForm, request, mav);
      mav.addObject("entradaForm", entradaForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Entrada existent
   */
  @RequestMapping(value = "/{entradaID}/edit", method = RequestMethod.GET)
  public ModelAndView editarEntradaGet(@PathVariable("entradaID") java.lang.Long entradaID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewEntradaGet(entradaID,
        request, response, false);
  }



  /**
   * Editar un Entrada existent
   */
  @RequestMapping(value = "/{entradaID}/edit", method = RequestMethod.POST)
  public String editarEntradaPost(@ModelAttribute EntradaForm entradaForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    EntradaJPA entrada = entradaForm.getEntrada();

    try {
      preValidate(request, entradaForm, result);
      getWebValidator().validate(entradaForm, result);
      postValidate(request, entradaForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        entrada = update(request, entrada);
        createMessageSuccess(request, "success.modification", entrada.getEntradaID());
        status.setComplete();
        return getRedirectWhenModified(request, entradaForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          entrada.getEntradaID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, entradaForm, __e);
    }

  }


  /**
   * Eliminar un Entrada existent
   */
  @RequestMapping(value = "/{entradaID}/delete")
  public String eliminarEntrada(@PathVariable("entradaID") java.lang.Long entradaID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Entrada entrada = this.findByPrimaryKey(request, entradaID);
      if (entrada == null) {
        String __msg = createMessageError(request, "error.notfound", entradaID);
        return getRedirectWhenDelete(request, entradaID, new Exception(__msg));
      } else {
        delete(request, entrada);
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
    @ModelAttribute EntradaFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarEntrada(stringToPK(seleccionats[i]), request, response);
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
    return "entrada.entrada";
  }

  public String getEntityNameCodePlural() {
    return "entrada.entrada.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("entrada.entradaID");
  }

  @InitBinder("entradaFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("entradaForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "entrada.entradaID");
  }

  public EntradaWebValidator getWebValidator() {
    return entradaWebValidator;
  }


  public void setWebValidator(EntradaWebValidator __val) {
    if (__val != null) {
      this.entradaWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Entrada
   */
  @RequestMapping(value = "/{entradaID}/cancel")
  public String cancelEntrada(@PathVariable("entradaID") java.lang.Long entradaID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, entradaID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de Entrada
   */
  @RequestMapping(value = "/cancel")
  public String cancelEntrada(HttpServletRequest request,HttpServletResponse response) {
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


  public List<StringKeyValue> getReferenceListForAccioID(HttpServletRequest request,
       ModelAndView mav, EntradaForm entradaForm, Where where)  throws I18NException {
    if (entradaForm.isHiddenField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (entradaForm.isReadOnlyField(ACCIOID)) {
      _where = AccioFields.ACCIOID.equal(entradaForm.getEntrada().getAccioID());
    }
    return getReferenceListForAccioID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForAccioID(HttpServletRequest request,
       ModelAndView mav, EntradaFilterForm entradaFilterForm,
       List<Entrada> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (entradaFilterForm.isHiddenField(ACCIOID)
       && !entradaFilterForm.isGroupByField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(ACCIOID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Entrada _item : list) {
        _pkList.add(_item.getAccioID());
        }
        _w = AccioFields.ACCIOID.in(_pkList);
      }
    return getReferenceListForAccioID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForAccioID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return accioRefList.getReferenceList(AccioFields.ACCIOID, where );
  }


  public List<StringKeyValue> getReferenceListForProjecteID(HttpServletRequest request,
       ModelAndView mav, EntradaForm entradaForm, Where where)  throws I18NException {
    if (entradaForm.isHiddenField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (entradaForm.isReadOnlyField(PROJECTEID)) {
      _where = ProjecteFields.PROJECTEID.equal(entradaForm.getEntrada().getProjecteID());
    }
    return getReferenceListForProjecteID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForProjecteID(HttpServletRequest request,
       ModelAndView mav, EntradaFilterForm entradaFilterForm,
       List<Entrada> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (entradaFilterForm.isHiddenField(PROJECTEID)
       && !entradaFilterForm.isGroupByField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PROJECTEID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Entrada _item : list) {
        if(_item.getProjecteID() == null) { continue; };
        _pkList.add(_item.getProjecteID());
        }
        _w = ProjecteFields.PROJECTEID.in(_pkList);
      }
    return getReferenceListForProjecteID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForProjecteID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return projecteRefList.getReferenceList(ProjecteFields.PROJECTEID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,EntradaForm entradaForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,EntradaForm entradaForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, EntradaFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, EntradaFilterForm filterForm,  List<Entrada> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, EntradaForm entradaForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, EntradaForm entradaForm, Throwable __e) {
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
    return "entradaFormWebDB";
  }

  public String getTileList() {
    return "entradaListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Entrada_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public EntradaJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long entradaID) throws I18NException {
    return (EntradaJPA) entradaEjb.findByPrimaryKey(entradaID);
  }


  public EntradaJPA create(HttpServletRequest request, EntradaJPA entrada)
    throws I18NException, I18NValidationException {
    return (EntradaJPA) entradaEjb.create(entrada);
  }


  public EntradaJPA update(HttpServletRequest request, EntradaJPA entrada)
    throws I18NException, I18NValidationException {
    return (EntradaJPA) entradaEjb.update(entrada);
  }


  public void delete(HttpServletRequest request, Entrada entrada) throws I18NException {
    entradaEjb.delete(entrada);
  }

} // Final de Classe

