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
import org.fundaciobit.queesticfent.back.form.webdb.UsuarisDepartamentForm;

import org.fundaciobit.queesticfent.back.validator.webdb.UsuarisDepartamentWebValidator;

import org.fundaciobit.queesticfent.persistence.UsuarisDepartamentJPA;
import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un UsuarisDepartament
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/usuarisDepartament")
@SessionAttributes(types = { UsuarisDepartamentForm.class, UsuarisDepartamentFilterForm.class })
public class UsuarisDepartamentController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<UsuarisDepartament, java.lang.Long> implements UsuarisDepartamentFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService usuarisDepartamentEjb;

  @Autowired
  private UsuarisDepartamentWebValidator usuarisDepartamentWebValidator;

  @Autowired
  protected UsuarisDepartamentRefList usuarisDepartamentRefList;

  // References 
  @Autowired
  protected UsuarisRefList usuarisRefList;

  // References 
  @Autowired
  protected DepartamentsRefList departamentsRefList;

  /**
   * Llistat de totes UsuarisDepartament
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    UsuarisDepartamentFilterForm ff;
    ff = (UsuarisDepartamentFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar UsuarisDepartament de forma paginada
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
    llistat(mav, request, getUsuarisDepartamentFilterForm(pagina, mav, request));
    return mav;
  }

  public UsuarisDepartamentFilterForm getUsuarisDepartamentFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    UsuarisDepartamentFilterForm usuarisDepartamentFilterForm;
    usuarisDepartamentFilterForm = (UsuarisDepartamentFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(usuarisDepartamentFilterForm == null) {
      usuarisDepartamentFilterForm = new UsuarisDepartamentFilterForm();
      usuarisDepartamentFilterForm.setContexte(getContextWeb());
      usuarisDepartamentFilterForm.setEntityNameCode(getEntityNameCode());
      usuarisDepartamentFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      usuarisDepartamentFilterForm.setNou(true);
    } else {
      usuarisDepartamentFilterForm.setNou(false);
    }
    usuarisDepartamentFilterForm.setPage(pagina == null ? 1 : pagina);
    return usuarisDepartamentFilterForm;
  }

  /**
   * Segona i següent peticions per llistar UsuarisDepartament de forma paginada
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
      @ModelAttribute UsuarisDepartamentFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getUsuarisDepartamentFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de UsuarisDepartament de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<UsuarisDepartament> llistat(ModelAndView mav, HttpServletRequest request,
     UsuarisDepartamentFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<UsuarisDepartament> usuarisDepartament = processarLlistat(usuarisDepartamentEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("usuarisDepartamentItems", usuarisDepartament);

    mav.addObject("usuarisDepartamentFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, usuarisDepartament, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, usuarisDepartament);

    return usuarisDepartament;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(UsuarisDepartamentFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<UsuarisDepartament> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field usuariId
    {
      _listSKV = getReferenceListForUsuariId(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfUsuarisForUsuariId(_tmp);
      if (filterForm.getGroupByFields().contains(USUARIID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, USUARIID, false);
      };
    }

    // Field departamentid
    {
      _listSKV = getReferenceListForDepartamentid(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfDepartamentsForDepartamentid(_tmp);
      if (filterForm.getGroupByFields().contains(DEPARTAMENTID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, DEPARTAMENTID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    UsuarisDepartamentFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<UsuarisDepartament> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_USUARISDEPARTAMENT_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(USUARIID, filterForm.getMapOfUsuarisForUsuariId());
    __mapping.put(DEPARTAMENTID, filterForm.getMapOfDepartamentsForDepartamentid());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou UsuarisDepartament
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearUsuarisDepartamentGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    UsuarisDepartamentForm usuarisDepartamentForm = getUsuarisDepartamentForm(null, false, request, mav);
    mav.addObject("usuarisDepartamentForm" ,usuarisDepartamentForm);
    fillReferencesForForm(usuarisDepartamentForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public UsuarisDepartamentForm getUsuarisDepartamentForm(UsuarisDepartamentJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    UsuarisDepartamentForm usuarisDepartamentForm;
    if(_jpa == null) {
      usuarisDepartamentForm = new UsuarisDepartamentForm(new UsuarisDepartamentJPA(), true);
    } else {
      usuarisDepartamentForm = new UsuarisDepartamentForm(_jpa, false);
      usuarisDepartamentForm.setView(__isView);
    }
    usuarisDepartamentForm.setContexte(getContextWeb());
    usuarisDepartamentForm.setEntityNameCode(getEntityNameCode());
    usuarisDepartamentForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return usuarisDepartamentForm;
  }

  public void fillReferencesForForm(UsuarisDepartamentForm usuarisDepartamentForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (usuarisDepartamentForm.getListOfUsuarisForUsuariId() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForUsuariId(request, mav, usuarisDepartamentForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      usuarisDepartamentForm.setListOfUsuarisForUsuariId(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (usuarisDepartamentForm.getListOfDepartamentsForDepartamentid() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForDepartamentid(request, mav, usuarisDepartamentForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      usuarisDepartamentForm.setListOfDepartamentsForDepartamentid(_listSKV);
    }
    
  }

  /**
   * Guardar un nou UsuarisDepartament
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearUsuarisDepartamentPost(@ModelAttribute UsuarisDepartamentForm usuarisDepartamentForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    UsuarisDepartamentJPA usuarisDepartament = usuarisDepartamentForm.getUsuarisDepartament();

    try {
      preValidate(request, usuarisDepartamentForm, result);
      getWebValidator().validate(usuarisDepartamentForm, result);
      postValidate(request,usuarisDepartamentForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuarisDepartament = create(request, usuarisDepartament);
        createMessageSuccess(request, "success.creation", usuarisDepartament.getUsuariDepartamentId());
        usuarisDepartamentForm.setUsuarisDepartament(usuarisDepartament);
        return getRedirectWhenCreated(request, usuarisDepartamentForm);
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

  @RequestMapping(value = "/view/{usuariDepartamentId}", method = RequestMethod.GET)
  public ModelAndView veureUsuarisDepartamentGet(@PathVariable("usuariDepartamentId") java.lang.Long usuariDepartamentId,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuarisDepartamentGet(usuariDepartamentId,
        request, response, true);
  }


  protected ModelAndView editAndViewUsuarisDepartamentGet(@PathVariable("usuariDepartamentId") java.lang.Long usuariDepartamentId,
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
    UsuarisDepartamentJPA usuarisDepartament = findByPrimaryKey(request, usuariDepartamentId);

    if (usuarisDepartament == null) {
      createMessageWarning(request, "error.notfound", usuariDepartamentId);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, usuariDepartamentId), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      UsuarisDepartamentForm usuarisDepartamentForm = getUsuarisDepartamentForm(usuarisDepartament, __isView, request, mav);
      usuarisDepartamentForm.setView(__isView);
      if(__isView) {
        usuarisDepartamentForm.setAllFieldsReadOnly(ALL_USUARISDEPARTAMENT_FIELDS);
        usuarisDepartamentForm.setSaveButtonVisible(false);
        usuarisDepartamentForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(usuarisDepartamentForm, request, mav);
      mav.addObject("usuarisDepartamentForm", usuarisDepartamentForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un UsuarisDepartament existent
   */
  @RequestMapping(value = "/{usuariDepartamentId}/edit", method = RequestMethod.GET)
  public ModelAndView editarUsuarisDepartamentGet(@PathVariable("usuariDepartamentId") java.lang.Long usuariDepartamentId,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuarisDepartamentGet(usuariDepartamentId,
        request, response, false);
  }



  /**
   * Editar un UsuarisDepartament existent
   */
  @RequestMapping(value = "/{usuariDepartamentId}/edit", method = RequestMethod.POST)
  public String editarUsuarisDepartamentPost(@ModelAttribute UsuarisDepartamentForm usuarisDepartamentForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    UsuarisDepartamentJPA usuarisDepartament = usuarisDepartamentForm.getUsuarisDepartament();

    try {
      preValidate(request, usuarisDepartamentForm, result);
      getWebValidator().validate(usuarisDepartamentForm, result);
      postValidate(request, usuarisDepartamentForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuarisDepartament = update(request, usuarisDepartament);
        createMessageSuccess(request, "success.modification", usuarisDepartament.getUsuariDepartamentId());
        status.setComplete();
        return getRedirectWhenModified(request, usuarisDepartamentForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          usuarisDepartament.getUsuariDepartamentId(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, usuarisDepartamentForm, __e);
    }

  }


  /**
   * Eliminar un UsuarisDepartament existent
   */
  @RequestMapping(value = "/{usuariDepartamentId}/delete")
  public String eliminarUsuarisDepartament(@PathVariable("usuariDepartamentId") java.lang.Long usuariDepartamentId,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      UsuarisDepartament usuarisDepartament = this.findByPrimaryKey(request, usuariDepartamentId);
      if (usuarisDepartament == null) {
        String __msg = createMessageError(request, "error.notfound", usuariDepartamentId);
        return getRedirectWhenDelete(request, usuariDepartamentId, new Exception(__msg));
      } else {
        delete(request, usuarisDepartament);
        createMessageSuccess(request, "success.deleted", usuariDepartamentId);
        return getRedirectWhenDelete(request, usuariDepartamentId,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", usuariDepartamentId, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, usuariDepartamentId, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute UsuarisDepartamentFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarUsuarisDepartament(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __usuariDepartamentId, Throwable e) {
    java.lang.Long usuariDepartamentId = (java.lang.Long)__usuariDepartamentId;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (usuariDepartamentId == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(usuariDepartamentId),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "usuarisDepartament.usuarisDepartament";
  }

  public String getEntityNameCodePlural() {
    return "usuarisDepartament.usuarisDepartament.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("usuarisDepartament.usuariDepartamentId");
  }

  @InitBinder("usuarisDepartamentFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("usuarisDepartamentForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "usuarisDepartament.usuariDepartamentId");
  }

  public UsuarisDepartamentWebValidator getWebValidator() {
    return usuarisDepartamentWebValidator;
  }


  public void setWebValidator(UsuarisDepartamentWebValidator __val) {
    if (__val != null) {
      this.usuarisDepartamentWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de UsuarisDepartament
   */
  @RequestMapping(value = "/{usuariDepartamentId}/cancel")
  public String cancelUsuarisDepartament(@PathVariable("usuariDepartamentId") java.lang.Long usuariDepartamentId,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, usuariDepartamentId);
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


  public List<StringKeyValue> getReferenceListForUsuariId(HttpServletRequest request,
       ModelAndView mav, UsuarisDepartamentForm usuarisDepartamentForm, Where where)  throws I18NException {
    if (usuarisDepartamentForm.isHiddenField(USUARIID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (usuarisDepartamentForm.isReadOnlyField(USUARIID)) {
      _where = UsuarisFields.USUARIID.equal(usuarisDepartamentForm.getUsuarisDepartament().getUsuariId());
    }
    return getReferenceListForUsuariId(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForUsuariId(HttpServletRequest request,
       ModelAndView mav, UsuarisDepartamentFilterForm usuarisDepartamentFilterForm,
       List<UsuarisDepartament> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (usuarisDepartamentFilterForm.isHiddenField(USUARIID)
       && !usuarisDepartamentFilterForm.isGroupByField(USUARIID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(USUARIID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.String> _pkList = new java.util.HashSet<java.lang.String>();
      for (UsuarisDepartament _item : list) {
        _pkList.add(_item.getUsuariId());
        }
        _w = UsuarisFields.USUARIID.in(_pkList);
      }
    return getReferenceListForUsuariId(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForUsuariId(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return usuarisRefList.getReferenceList(UsuarisFields.USUARIID, where );
  }


  public List<StringKeyValue> getReferenceListForDepartamentid(HttpServletRequest request,
       ModelAndView mav, UsuarisDepartamentForm usuarisDepartamentForm, Where where)  throws I18NException {
    if (usuarisDepartamentForm.isHiddenField(DEPARTAMENTID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (usuarisDepartamentForm.isReadOnlyField(DEPARTAMENTID)) {
      _where = DepartamentsFields.DEPARTAMENTID.equal(usuarisDepartamentForm.getUsuarisDepartament().getDepartamentid());
    }
    return getReferenceListForDepartamentid(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForDepartamentid(HttpServletRequest request,
       ModelAndView mav, UsuarisDepartamentFilterForm usuarisDepartamentFilterForm,
       List<UsuarisDepartament> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (usuarisDepartamentFilterForm.isHiddenField(DEPARTAMENTID)
       && !usuarisDepartamentFilterForm.isGroupByField(DEPARTAMENTID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(DEPARTAMENTID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (UsuarisDepartament _item : list) {
        _pkList.add(_item.getDepartamentid());
        }
        _w = DepartamentsFields.DEPARTAMENTID.in(_pkList);
      }
    return getReferenceListForDepartamentid(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForDepartamentid(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return departamentsRefList.getReferenceList(DepartamentsFields.DEPARTAMENTID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,UsuarisDepartamentForm usuarisDepartamentForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,UsuarisDepartamentForm usuarisDepartamentForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, UsuarisDepartamentFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, UsuarisDepartamentFilterForm filterForm,  List<UsuarisDepartament> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, UsuarisDepartamentForm usuarisDepartamentForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, UsuarisDepartamentForm usuarisDepartamentForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long usuariDepartamentId, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long usuariDepartamentId) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "usuarisDepartamentFormWebDB";
  }

  public String getTileList() {
    return "usuarisDepartamentListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "UsuarisDepartament_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public UsuarisDepartamentJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long usuariDepartamentId) throws I18NException {
    return (UsuarisDepartamentJPA) usuarisDepartamentEjb.findByPrimaryKey(usuariDepartamentId);
  }


  public UsuarisDepartamentJPA create(HttpServletRequest request, UsuarisDepartamentJPA usuarisDepartament)
    throws I18NException, I18NValidationException {
    return (UsuarisDepartamentJPA) usuarisDepartamentEjb.create(usuarisDepartament);
  }


  public UsuarisDepartamentJPA update(HttpServletRequest request, UsuarisDepartamentJPA usuarisDepartament)
    throws I18NException, I18NValidationException {
    return (UsuarisDepartamentJPA) usuarisDepartamentEjb.update(usuarisDepartament);
  }


  public void delete(HttpServletRequest request, UsuarisDepartament usuarisDepartament) throws I18NException {
    usuarisDepartamentEjb.delete(usuarisDepartament);
  }

} // Final de Classe

