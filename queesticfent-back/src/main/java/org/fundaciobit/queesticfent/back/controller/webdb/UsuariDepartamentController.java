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
import org.fundaciobit.queesticfent.back.form.webdb.UsuariDepartamentForm;

import org.fundaciobit.queesticfent.back.validator.webdb.UsuariDepartamentWebValidator;

import org.fundaciobit.queesticfent.persistence.UsuariDepartamentJPA;
import org.fundaciobit.queesticfent.model.entity.UsuariDepartament;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un UsuariDepartament
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="usuariDepartament.usuariDepartament.plural", order=120, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/usuariDepartament")
@SessionAttributes(types = { UsuariDepartamentForm.class, UsuariDepartamentFilterForm.class })
public class UsuariDepartamentController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<UsuariDepartament, java.lang.Long> implements UsuariDepartamentFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuariDepartamentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuariDepartamentService usuariDepartamentEjb;

  @Autowired
  private UsuariDepartamentWebValidator usuariDepartamentWebValidator;

  @Autowired
  protected UsuariDepartamentRefList usuariDepartamentRefList;

  // References 
  @Autowired
  protected UsuariRefList usuariRefList;

  // References 
  @Autowired
  protected DepartamentRefList departamentRefList;

  /**
   * Llistat de totes UsuariDepartament
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    UsuariDepartamentFilterForm ff;
    ff = (UsuariDepartamentFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar UsuariDepartament de forma paginada
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
    llistat(mav, request, getUsuariDepartamentFilterForm(pagina, mav, request));
    return mav;
  }

  public UsuariDepartamentFilterForm getUsuariDepartamentFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    UsuariDepartamentFilterForm usuariDepartamentFilterForm;
    usuariDepartamentFilterForm = (UsuariDepartamentFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(usuariDepartamentFilterForm == null) {
      usuariDepartamentFilterForm = new UsuariDepartamentFilterForm();
      usuariDepartamentFilterForm.setContexte(getContextWeb());
      usuariDepartamentFilterForm.setEntityNameCode(getEntityNameCode());
      usuariDepartamentFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      usuariDepartamentFilterForm.setNou(true);
    } else {
      usuariDepartamentFilterForm.setNou(false);
    }
    usuariDepartamentFilterForm.setPage(pagina == null ? 1 : pagina);
    return usuariDepartamentFilterForm;
  }

  /**
   * Segona i següent peticions per llistar UsuariDepartament de forma paginada
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
      @ModelAttribute UsuariDepartamentFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getUsuariDepartamentFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de UsuariDepartament de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<UsuariDepartament> llistat(ModelAndView mav, HttpServletRequest request,
     UsuariDepartamentFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<UsuariDepartament> usuariDepartament = processarLlistat(usuariDepartamentEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("usuariDepartamentItems", usuariDepartament);

    mav.addObject("usuariDepartamentFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, usuariDepartament, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, usuariDepartament);

    return usuariDepartament;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(UsuariDepartamentFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<UsuariDepartament> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field usuariID
    {
      _listSKV = getReferenceListForUsuariID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfUsuariForUsuariID(_tmp);
      if (filterForm.getGroupByFields().contains(USUARIID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, USUARIID, false);
      };
    }

    // Field departamentID
    {
      _listSKV = getReferenceListForDepartamentID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfDepartamentForDepartamentID(_tmp);
      if (filterForm.getGroupByFields().contains(DEPARTAMENTID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, DEPARTAMENTID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    UsuariDepartamentFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<UsuariDepartament> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_USUARIDEPARTAMENT_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(USUARIID, filterForm.getMapOfUsuariForUsuariID());
    __mapping.put(DEPARTAMENTID, filterForm.getMapOfDepartamentForDepartamentID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou UsuariDepartament
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearUsuariDepartamentGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    UsuariDepartamentForm usuariDepartamentForm = getUsuariDepartamentForm(null, false, request, mav);
    mav.addObject("usuariDepartamentForm" ,usuariDepartamentForm);
    fillReferencesForForm(usuariDepartamentForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public UsuariDepartamentForm getUsuariDepartamentForm(UsuariDepartamentJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    UsuariDepartamentForm usuariDepartamentForm;
    if(_jpa == null) {
      usuariDepartamentForm = new UsuariDepartamentForm(new UsuariDepartamentJPA(), true);
    } else {
      usuariDepartamentForm = new UsuariDepartamentForm(_jpa, false);
      usuariDepartamentForm.setView(__isView);
    }
    usuariDepartamentForm.setContexte(getContextWeb());
    usuariDepartamentForm.setEntityNameCode(getEntityNameCode());
    usuariDepartamentForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return usuariDepartamentForm;
  }

  public void fillReferencesForForm(UsuariDepartamentForm usuariDepartamentForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (usuariDepartamentForm.getListOfUsuariForUsuariID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForUsuariID(request, mav, usuariDepartamentForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      usuariDepartamentForm.setListOfUsuariForUsuariID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (usuariDepartamentForm.getListOfDepartamentForDepartamentID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForDepartamentID(request, mav, usuariDepartamentForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      usuariDepartamentForm.setListOfDepartamentForDepartamentID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou UsuariDepartament
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearUsuariDepartamentPost(@ModelAttribute UsuariDepartamentForm usuariDepartamentForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    UsuariDepartamentJPA usuariDepartament = usuariDepartamentForm.getUsuariDepartament();

    try {
      preValidate(request, usuariDepartamentForm, result);
      getWebValidator().validate(usuariDepartamentForm, result);
      postValidate(request,usuariDepartamentForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuariDepartament = create(request, usuariDepartament);
        createMessageSuccess(request, "success.creation", usuariDepartament.getUsuaridepartamentID());
        usuariDepartamentForm.setUsuariDepartament(usuariDepartament);
        return getRedirectWhenCreated(request, usuariDepartamentForm);
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

  @RequestMapping(value = "/view/{usuaridepartamentID}", method = RequestMethod.GET)
  public ModelAndView veureUsuariDepartamentGet(@PathVariable("usuaridepartamentID") java.lang.Long usuaridepartamentID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuariDepartamentGet(usuaridepartamentID,
        request, response, true);
  }


  protected ModelAndView editAndViewUsuariDepartamentGet(@PathVariable("usuaridepartamentID") java.lang.Long usuaridepartamentID,
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
    UsuariDepartamentJPA usuariDepartament = findByPrimaryKey(request, usuaridepartamentID);

    if (usuariDepartament == null) {
      createMessageWarning(request, "error.notfound", usuaridepartamentID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      UsuariDepartamentForm usuariDepartamentForm = getUsuariDepartamentForm(usuariDepartament, __isView, request, mav);
      usuariDepartamentForm.setView(__isView);
      if(__isView) {
        usuariDepartamentForm.setAllFieldsReadOnly(ALL_USUARIDEPARTAMENT_FIELDS);
        usuariDepartamentForm.setSaveButtonVisible(false);
        usuariDepartamentForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(usuariDepartamentForm, request, mav);
      mav.addObject("usuariDepartamentForm", usuariDepartamentForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un UsuariDepartament existent
   */
  @RequestMapping(value = "/{usuaridepartamentID}/edit", method = RequestMethod.GET)
  public ModelAndView editarUsuariDepartamentGet(@PathVariable("usuaridepartamentID") java.lang.Long usuaridepartamentID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuariDepartamentGet(usuaridepartamentID,
        request, response, false);
  }



  /**
   * Editar un UsuariDepartament existent
   */
  @RequestMapping(value = "/{usuaridepartamentID}/edit", method = RequestMethod.POST)
  public String editarUsuariDepartamentPost(@ModelAttribute UsuariDepartamentForm usuariDepartamentForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    UsuariDepartamentJPA usuariDepartament = usuariDepartamentForm.getUsuariDepartament();

    try {
      preValidate(request, usuariDepartamentForm, result);
      getWebValidator().validate(usuariDepartamentForm, result);
      postValidate(request, usuariDepartamentForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuariDepartament = update(request, usuariDepartament);
        createMessageSuccess(request, "success.modification", usuariDepartament.getUsuaridepartamentID());
        status.setComplete();
        return getRedirectWhenModified(request, usuariDepartamentForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          usuariDepartament.getUsuaridepartamentID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, usuariDepartamentForm, __e);
    }

  }


  /**
   * Eliminar un UsuariDepartament existent
   */
  @RequestMapping(value = "/{usuaridepartamentID}/delete")
  public String eliminarUsuariDepartament(@PathVariable("usuaridepartamentID") java.lang.Long usuaridepartamentID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      UsuariDepartament usuariDepartament = this.findByPrimaryKey(request, usuaridepartamentID);
      if (usuariDepartament == null) {
        String __msg = createMessageError(request, "error.notfound", usuaridepartamentID);
        return getRedirectWhenDelete(request, usuaridepartamentID, new Exception(__msg));
      } else {
        delete(request, usuariDepartament);
        createMessageSuccess(request, "success.deleted", usuaridepartamentID);
        return getRedirectWhenDelete(request, usuaridepartamentID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", usuaridepartamentID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, usuaridepartamentID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute UsuariDepartamentFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarUsuariDepartament(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __usuaridepartamentID, Throwable e) {
    java.lang.Long usuaridepartamentID = (java.lang.Long)__usuaridepartamentID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (usuaridepartamentID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(usuaridepartamentID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "usuariDepartament.usuariDepartament";
  }

  public String getEntityNameCodePlural() {
    return "usuariDepartament.usuariDepartament.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("usuariDepartament.usuaridepartamentID");
  }

  @InitBinder("usuariDepartamentFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("usuariDepartamentForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "usuariDepartament.usuaridepartamentID");
  }

  public UsuariDepartamentWebValidator getWebValidator() {
    return usuariDepartamentWebValidator;
  }


  public void setWebValidator(UsuariDepartamentWebValidator __val) {
    if (__val != null) {
      this.usuariDepartamentWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de UsuariDepartament
   */
  @RequestMapping(value = "/{usuaridepartamentID}/cancel")
  public String cancelUsuariDepartament(@PathVariable("usuaridepartamentID") java.lang.Long usuaridepartamentID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, usuaridepartamentID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de UsuariDepartament
   */
  @RequestMapping(value = "/cancel")
  public String cancelUsuariDepartament(HttpServletRequest request,HttpServletResponse response) {
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


  public List<StringKeyValue> getReferenceListForUsuariID(HttpServletRequest request,
       ModelAndView mav, UsuariDepartamentForm usuariDepartamentForm, Where where)  throws I18NException {
    if (usuariDepartamentForm.isHiddenField(USUARIID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (usuariDepartamentForm.isReadOnlyField(USUARIID)) {
      _where = UsuariFields.USUARIID.equal(usuariDepartamentForm.getUsuariDepartament().getUsuariID());
    }
    return getReferenceListForUsuariID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForUsuariID(HttpServletRequest request,
       ModelAndView mav, UsuariDepartamentFilterForm usuariDepartamentFilterForm,
       List<UsuariDepartament> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (usuariDepartamentFilterForm.isHiddenField(USUARIID)
       && !usuariDepartamentFilterForm.isGroupByField(USUARIID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(USUARIID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.String> _pkList = new java.util.HashSet<java.lang.String>();
      for (UsuariDepartament _item : list) {
        _pkList.add(_item.getUsuariID());
        }
        _w = UsuariFields.USUARIID.in(_pkList);
      }
    return getReferenceListForUsuariID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForUsuariID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return usuariRefList.getReferenceList(UsuariFields.USUARIID, where );
  }


  public List<StringKeyValue> getReferenceListForDepartamentID(HttpServletRequest request,
       ModelAndView mav, UsuariDepartamentForm usuariDepartamentForm, Where where)  throws I18NException {
    if (usuariDepartamentForm.isHiddenField(DEPARTAMENTID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (usuariDepartamentForm.isReadOnlyField(DEPARTAMENTID)) {
      _where = DepartamentFields.DEPARTAMENTID.equal(usuariDepartamentForm.getUsuariDepartament().getDepartamentID());
    }
    return getReferenceListForDepartamentID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForDepartamentID(HttpServletRequest request,
       ModelAndView mav, UsuariDepartamentFilterForm usuariDepartamentFilterForm,
       List<UsuariDepartament> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (usuariDepartamentFilterForm.isHiddenField(DEPARTAMENTID)
       && !usuariDepartamentFilterForm.isGroupByField(DEPARTAMENTID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(DEPARTAMENTID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (UsuariDepartament _item : list) {
        _pkList.add(_item.getDepartamentID());
        }
        _w = DepartamentFields.DEPARTAMENTID.in(_pkList);
      }
    return getReferenceListForDepartamentID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForDepartamentID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return departamentRefList.getReferenceList(DepartamentFields.DEPARTAMENTID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,UsuariDepartamentForm usuariDepartamentForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,UsuariDepartamentForm usuariDepartamentForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, UsuariDepartamentFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, UsuariDepartamentFilterForm filterForm,  List<UsuariDepartament> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, UsuariDepartamentForm usuariDepartamentForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, UsuariDepartamentForm usuariDepartamentForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long usuaridepartamentID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long usuaridepartamentID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "usuariDepartamentFormWebDB";
  }

  public String getTileList() {
    return "usuariDepartamentListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "UsuariDepartament_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public UsuariDepartamentJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long usuaridepartamentID) throws I18NException {
    return (UsuariDepartamentJPA) usuariDepartamentEjb.findByPrimaryKey(usuaridepartamentID);
  }


  public UsuariDepartamentJPA create(HttpServletRequest request, UsuariDepartamentJPA usuariDepartament)
    throws I18NException, I18NValidationException {
    return (UsuariDepartamentJPA) usuariDepartamentEjb.create(usuariDepartament);
  }


  public UsuariDepartamentJPA update(HttpServletRequest request, UsuariDepartamentJPA usuariDepartament)
    throws I18NException, I18NValidationException {
    return (UsuariDepartamentJPA) usuariDepartamentEjb.update(usuariDepartament);
  }


  public void delete(HttpServletRequest request, UsuariDepartament usuariDepartament) throws I18NException {
    usuariDepartamentEjb.delete(usuariDepartament);
  }

} // Final de Classe

