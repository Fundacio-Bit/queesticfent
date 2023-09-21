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
import org.fundaciobit.queesticfent.back.form.webdb.GrupsusuariForm;

import org.fundaciobit.queesticfent.back.validator.webdb.GrupsusuariWebValidator;

import org.fundaciobit.queesticfent.persistence.GrupsusuariJPA;
import org.fundaciobit.queesticfent.model.entity.Grupsusuari;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Grupsusuari
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/grupsusuari")
@SessionAttributes(types = { GrupsusuariForm.class, GrupsusuariFilterForm.class })
public class GrupsusuariController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Grupsusuari, java.lang.Long> implements GrupsusuariFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.GrupsusuariService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.GrupsusuariService grupsusuariEjb;

  @Autowired
  private GrupsusuariWebValidator grupsusuariWebValidator;

  @Autowired
  protected GrupsusuariRefList grupsusuariRefList;

  // References 
  @Autowired
  protected UsuarisRefList usuarisRefList;

  // References 
  @Autowired
  protected GrupsRefList grupsRefList;

  /**
   * Llistat de totes Grupsusuari
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    GrupsusuariFilterForm ff;
    ff = (GrupsusuariFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Grupsusuari de forma paginada
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
    llistat(mav, request, getGrupsusuariFilterForm(pagina, mav, request));
    return mav;
  }

  public GrupsusuariFilterForm getGrupsusuariFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    GrupsusuariFilterForm grupsusuariFilterForm;
    grupsusuariFilterForm = (GrupsusuariFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(grupsusuariFilterForm == null) {
      grupsusuariFilterForm = new GrupsusuariFilterForm();
      grupsusuariFilterForm.setContexte(getContextWeb());
      grupsusuariFilterForm.setEntityNameCode(getEntityNameCode());
      grupsusuariFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      grupsusuariFilterForm.setNou(true);
    } else {
      grupsusuariFilterForm.setNou(false);
    }
    grupsusuariFilterForm.setPage(pagina == null ? 1 : pagina);
    return grupsusuariFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Grupsusuari de forma paginada
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
      @ModelAttribute GrupsusuariFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getGrupsusuariFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Grupsusuari de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Grupsusuari> llistat(ModelAndView mav, HttpServletRequest request,
     GrupsusuariFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Grupsusuari> grupsusuari = processarLlistat(grupsusuariEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("grupsusuariItems", grupsusuari);

    mav.addObject("grupsusuariFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, grupsusuari, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, grupsusuari);

    return grupsusuari;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(GrupsusuariFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Grupsusuari> list, List<GroupByItem> groupItems) throws I18NException {
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
      filterForm.setMapOfUsuarisForUsuariID(_tmp);
      if (filterForm.getGroupByFields().contains(USUARIID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, USUARIID, false);
      };
    }

    // Field grupID
    {
      _listSKV = getReferenceListForGrupID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfGrupsForGrupID(_tmp);
      if (filterForm.getGroupByFields().contains(GRUPID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, GRUPID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    GrupsusuariFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Grupsusuari> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_GRUPSUSUARI_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(USUARIID, filterForm.getMapOfUsuarisForUsuariID());
    __mapping.put(GRUPID, filterForm.getMapOfGrupsForGrupID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Grupsusuari
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearGrupsusuariGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    GrupsusuariForm grupsusuariForm = getGrupsusuariForm(null, false, request, mav);
    mav.addObject("grupsusuariForm" ,grupsusuariForm);
    fillReferencesForForm(grupsusuariForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public GrupsusuariForm getGrupsusuariForm(GrupsusuariJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    GrupsusuariForm grupsusuariForm;
    if(_jpa == null) {
      grupsusuariForm = new GrupsusuariForm(new GrupsusuariJPA(), true);
    } else {
      grupsusuariForm = new GrupsusuariForm(_jpa, false);
      grupsusuariForm.setView(__isView);
    }
    grupsusuariForm.setContexte(getContextWeb());
    grupsusuariForm.setEntityNameCode(getEntityNameCode());
    grupsusuariForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return grupsusuariForm;
  }

  public void fillReferencesForForm(GrupsusuariForm grupsusuariForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (grupsusuariForm.getListOfUsuarisForUsuariID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForUsuariID(request, mav, grupsusuariForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      grupsusuariForm.setListOfUsuarisForUsuariID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (grupsusuariForm.getListOfGrupsForGrupID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForGrupID(request, mav, grupsusuariForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      grupsusuariForm.setListOfGrupsForGrupID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Grupsusuari
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearGrupsusuariPost(@ModelAttribute GrupsusuariForm grupsusuariForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    GrupsusuariJPA grupsusuari = grupsusuariForm.getGrupsusuari();

    try {
      preValidate(request, grupsusuariForm, result);
      getWebValidator().validate(grupsusuariForm, result);
      postValidate(request,grupsusuariForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        grupsusuari = create(request, grupsusuari);
        createMessageSuccess(request, "success.creation", grupsusuari.getGrupsUsuariID());
        grupsusuariForm.setGrupsusuari(grupsusuari);
        return getRedirectWhenCreated(request, grupsusuariForm);
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

  @RequestMapping(value = "/view/{grupsUsuariID}", method = RequestMethod.GET)
  public ModelAndView veureGrupsusuariGet(@PathVariable("grupsUsuariID") java.lang.Long grupsUsuariID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewGrupsusuariGet(grupsUsuariID,
        request, response, true);
  }


  protected ModelAndView editAndViewGrupsusuariGet(@PathVariable("grupsUsuariID") java.lang.Long grupsUsuariID,
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
    GrupsusuariJPA grupsusuari = findByPrimaryKey(request, grupsUsuariID);

    if (grupsusuari == null) {
      createMessageWarning(request, "error.notfound", grupsUsuariID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, grupsUsuariID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      GrupsusuariForm grupsusuariForm = getGrupsusuariForm(grupsusuari, __isView, request, mav);
      grupsusuariForm.setView(__isView);
      if(__isView) {
        grupsusuariForm.setAllFieldsReadOnly(ALL_GRUPSUSUARI_FIELDS);
        grupsusuariForm.setSaveButtonVisible(false);
        grupsusuariForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(grupsusuariForm, request, mav);
      mav.addObject("grupsusuariForm", grupsusuariForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Grupsusuari existent
   */
  @RequestMapping(value = "/{grupsUsuariID}/edit", method = RequestMethod.GET)
  public ModelAndView editarGrupsusuariGet(@PathVariable("grupsUsuariID") java.lang.Long grupsUsuariID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewGrupsusuariGet(grupsUsuariID,
        request, response, false);
  }



  /**
   * Editar un Grupsusuari existent
   */
  @RequestMapping(value = "/{grupsUsuariID}/edit", method = RequestMethod.POST)
  public String editarGrupsusuariPost(@ModelAttribute GrupsusuariForm grupsusuariForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    GrupsusuariJPA grupsusuari = grupsusuariForm.getGrupsusuari();

    try {
      preValidate(request, grupsusuariForm, result);
      getWebValidator().validate(grupsusuariForm, result);
      postValidate(request, grupsusuariForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        grupsusuari = update(request, grupsusuari);
        createMessageSuccess(request, "success.modification", grupsusuari.getGrupsUsuariID());
        status.setComplete();
        return getRedirectWhenModified(request, grupsusuariForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          grupsusuari.getGrupsUsuariID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, grupsusuariForm, __e);
    }

  }


  /**
   * Eliminar un Grupsusuari existent
   */
  @RequestMapping(value = "/{grupsUsuariID}/delete")
  public String eliminarGrupsusuari(@PathVariable("grupsUsuariID") java.lang.Long grupsUsuariID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Grupsusuari grupsusuari = this.findByPrimaryKey(request, grupsUsuariID);
      if (grupsusuari == null) {
        String __msg = createMessageError(request, "error.notfound", grupsUsuariID);
        return getRedirectWhenDelete(request, grupsUsuariID, new Exception(__msg));
      } else {
        delete(request, grupsusuari);
        createMessageSuccess(request, "success.deleted", grupsUsuariID);
        return getRedirectWhenDelete(request, grupsUsuariID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", grupsUsuariID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, grupsUsuariID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute GrupsusuariFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarGrupsusuari(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __grupsUsuariID, Throwable e) {
    java.lang.Long grupsUsuariID = (java.lang.Long)__grupsUsuariID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (grupsUsuariID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(grupsUsuariID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "grupsusuari.grupsusuari";
  }

  public String getEntityNameCodePlural() {
    return "grupsusuari.grupsusuari.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("grupsusuari.grupsUsuariID");
  }

  @InitBinder("grupsusuariFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("grupsusuariForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "grupsusuari.grupsUsuariID");
  }

  public GrupsusuariWebValidator getWebValidator() {
    return grupsusuariWebValidator;
  }


  public void setWebValidator(GrupsusuariWebValidator __val) {
    if (__val != null) {
      this.grupsusuariWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Grupsusuari
   */
  @RequestMapping(value = "/{grupsUsuariID}/cancel")
  public String cancelGrupsusuari(@PathVariable("grupsUsuariID") java.lang.Long grupsUsuariID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, grupsUsuariID);
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
       ModelAndView mav, GrupsusuariForm grupsusuariForm, Where where)  throws I18NException {
    if (grupsusuariForm.isHiddenField(USUARIID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (grupsusuariForm.isReadOnlyField(USUARIID)) {
      _where = UsuarisFields.USUARIID.equal(grupsusuariForm.getGrupsusuari().getUsuariID());
    }
    return getReferenceListForUsuariID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForUsuariID(HttpServletRequest request,
       ModelAndView mav, GrupsusuariFilterForm grupsusuariFilterForm,
       List<Grupsusuari> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (grupsusuariFilterForm.isHiddenField(USUARIID)
       && !grupsusuariFilterForm.isGroupByField(USUARIID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(USUARIID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.String> _pkList = new java.util.HashSet<java.lang.String>();
      for (Grupsusuari _item : list) {
        _pkList.add(_item.getUsuariID());
        }
        _w = UsuarisFields.USUARIID.in(_pkList);
      }
    return getReferenceListForUsuariID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForUsuariID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return usuarisRefList.getReferenceList(UsuarisFields.USUARIID, where );
  }


  public List<StringKeyValue> getReferenceListForGrupID(HttpServletRequest request,
       ModelAndView mav, GrupsusuariForm grupsusuariForm, Where where)  throws I18NException {
    if (grupsusuariForm.isHiddenField(GRUPID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (grupsusuariForm.isReadOnlyField(GRUPID)) {
      _where = GrupsFields.GRUPID.equal(grupsusuariForm.getGrupsusuari().getGrupID());
    }
    return getReferenceListForGrupID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForGrupID(HttpServletRequest request,
       ModelAndView mav, GrupsusuariFilterForm grupsusuariFilterForm,
       List<Grupsusuari> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (grupsusuariFilterForm.isHiddenField(GRUPID)
       && !grupsusuariFilterForm.isGroupByField(GRUPID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(GRUPID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Grupsusuari _item : list) {
        _pkList.add(_item.getGrupID());
        }
        _w = GrupsFields.GRUPID.in(_pkList);
      }
    return getReferenceListForGrupID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForGrupID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return grupsRefList.getReferenceList(GrupsFields.GRUPID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,GrupsusuariForm grupsusuariForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,GrupsusuariForm grupsusuariForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, GrupsusuariFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, GrupsusuariFilterForm filterForm,  List<Grupsusuari> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, GrupsusuariForm grupsusuariForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, GrupsusuariForm grupsusuariForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long grupsUsuariID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long grupsUsuariID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "grupsusuariFormWebDB";
  }

  public String getTileList() {
    return "grupsusuariListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Grupsusuari_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public GrupsusuariJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long grupsUsuariID) throws I18NException {
    return (GrupsusuariJPA) grupsusuariEjb.findByPrimaryKey(grupsUsuariID);
  }


  public GrupsusuariJPA create(HttpServletRequest request, GrupsusuariJPA grupsusuari)
    throws I18NException, I18NValidationException {
    return (GrupsusuariJPA) grupsusuariEjb.create(grupsusuari);
  }


  public GrupsusuariJPA update(HttpServletRequest request, GrupsusuariJPA grupsusuari)
    throws I18NException, I18NValidationException {
    return (GrupsusuariJPA) grupsusuariEjb.update(grupsusuari);
  }


  public void delete(HttpServletRequest request, Grupsusuari grupsusuari) throws I18NException {
    grupsusuariEjb.delete(grupsusuari);
  }

} // Final de Classe

