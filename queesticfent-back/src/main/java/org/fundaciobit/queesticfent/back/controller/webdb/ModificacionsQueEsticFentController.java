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
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentForm;

import org.fundaciobit.queesticfent.back.validator.webdb.ModificacionsQueEsticFentWebValidator;

import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentJPA;
import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un ModificacionsQueEsticFent
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/modificacionsQueEsticFent")
@SessionAttributes(types = { ModificacionsQueEsticFentForm.class, ModificacionsQueEsticFentFilterForm.class })
public class ModificacionsQueEsticFentController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<ModificacionsQueEsticFent, java.lang.Long> implements ModificacionsQueEsticFentFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService modificacionsQueEsticFentEjb;

  @Autowired
  private ModificacionsQueEsticFentWebValidator modificacionsQueEsticFentWebValidator;

  @Autowired
  protected ModificacionsQueEsticFentRefList modificacionsQueEsticFentRefList;

  // References 
  @Autowired
  protected AccionsRefList accionsRefList;

  // References 
  @Autowired
  protected ProjectesRefList projectesRefList;

  /**
   * Llistat de totes ModificacionsQueEsticFent
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    ModificacionsQueEsticFentFilterForm ff;
    ff = (ModificacionsQueEsticFentFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar ModificacionsQueEsticFent de forma paginada
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
    llistat(mav, request, getModificacionsQueEsticFentFilterForm(pagina, mav, request));
    return mav;
  }

  public ModificacionsQueEsticFentFilterForm getModificacionsQueEsticFentFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    ModificacionsQueEsticFentFilterForm modificacionsQueEsticFentFilterForm;
    modificacionsQueEsticFentFilterForm = (ModificacionsQueEsticFentFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(modificacionsQueEsticFentFilterForm == null) {
      modificacionsQueEsticFentFilterForm = new ModificacionsQueEsticFentFilterForm();
      modificacionsQueEsticFentFilterForm.setContexte(getContextWeb());
      modificacionsQueEsticFentFilterForm.setEntityNameCode(getEntityNameCode());
      modificacionsQueEsticFentFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      modificacionsQueEsticFentFilterForm.setNou(true);
    } else {
      modificacionsQueEsticFentFilterForm.setNou(false);
    }
    modificacionsQueEsticFentFilterForm.setPage(pagina == null ? 1 : pagina);
    return modificacionsQueEsticFentFilterForm;
  }

  /**
   * Segona i següent peticions per llistar ModificacionsQueEsticFent de forma paginada
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
      @ModelAttribute ModificacionsQueEsticFentFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getModificacionsQueEsticFentFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de ModificacionsQueEsticFent de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<ModificacionsQueEsticFent> llistat(ModelAndView mav, HttpServletRequest request,
     ModificacionsQueEsticFentFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<ModificacionsQueEsticFent> modificacionsQueEsticFent = processarLlistat(modificacionsQueEsticFentEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("modificacionsQueEsticFentItems", modificacionsQueEsticFent);

    mav.addObject("modificacionsQueEsticFentFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, modificacionsQueEsticFent, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, modificacionsQueEsticFent);

    return modificacionsQueEsticFent;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(ModificacionsQueEsticFentFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<ModificacionsQueEsticFent> list, List<GroupByItem> groupItems) throws I18NException {
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
      filterForm.setMapOfAccionsForAccioID(_tmp);
      if (filterForm.getGroupByFields().contains(ACCIOID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ACCIOID, false);
      };
    }

    // Field projecteID
    {
      _listSKV = getReferenceListForProjecteID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfProjectesForProjecteID(_tmp);
      if (filterForm.getGroupByFields().contains(PROJECTEID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, PROJECTEID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    ModificacionsQueEsticFentFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<ModificacionsQueEsticFent> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_MODIFICACIONSQUEESTICFENT_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(ACCIOID, filterForm.getMapOfAccionsForAccioID());
    __mapping.put(PROJECTEID, filterForm.getMapOfProjectesForProjecteID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou ModificacionsQueEsticFent
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearModificacionsQueEsticFentGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    ModificacionsQueEsticFentForm modificacionsQueEsticFentForm = getModificacionsQueEsticFentForm(null, false, request, mav);
    mav.addObject("modificacionsQueEsticFentForm" ,modificacionsQueEsticFentForm);
    fillReferencesForForm(modificacionsQueEsticFentForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public ModificacionsQueEsticFentForm getModificacionsQueEsticFentForm(ModificacionsQueEsticFentJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    ModificacionsQueEsticFentForm modificacionsQueEsticFentForm;
    if(_jpa == null) {
      modificacionsQueEsticFentForm = new ModificacionsQueEsticFentForm(new ModificacionsQueEsticFentJPA(), true);
    } else {
      modificacionsQueEsticFentForm = new ModificacionsQueEsticFentForm(_jpa, false);
      modificacionsQueEsticFentForm.setView(__isView);
    }
    modificacionsQueEsticFentForm.setContexte(getContextWeb());
    modificacionsQueEsticFentForm.setEntityNameCode(getEntityNameCode());
    modificacionsQueEsticFentForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return modificacionsQueEsticFentForm;
  }

  public void fillReferencesForForm(ModificacionsQueEsticFentForm modificacionsQueEsticFentForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (modificacionsQueEsticFentForm.getListOfAccionsForAccioID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForAccioID(request, mav, modificacionsQueEsticFentForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      modificacionsQueEsticFentForm.setListOfAccionsForAccioID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (modificacionsQueEsticFentForm.getListOfProjectesForProjecteID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForProjecteID(request, mav, modificacionsQueEsticFentForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      modificacionsQueEsticFentForm.setListOfProjectesForProjecteID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou ModificacionsQueEsticFent
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearModificacionsQueEsticFentPost(@ModelAttribute ModificacionsQueEsticFentForm modificacionsQueEsticFentForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModificacionsQueEsticFentJPA modificacionsQueEsticFent = modificacionsQueEsticFentForm.getModificacionsQueEsticFent();

    try {
      preValidate(request, modificacionsQueEsticFentForm, result);
      getWebValidator().validate(modificacionsQueEsticFentForm, result);
      postValidate(request,modificacionsQueEsticFentForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        modificacionsQueEsticFent = create(request, modificacionsQueEsticFent);
        createMessageSuccess(request, "success.creation", modificacionsQueEsticFent.getModificacioID());
        modificacionsQueEsticFentForm.setModificacionsQueEsticFent(modificacionsQueEsticFent);
        return getRedirectWhenCreated(request, modificacionsQueEsticFentForm);
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

  @RequestMapping(value = "/view/{modificacioID}", method = RequestMethod.GET)
  public ModelAndView veureModificacionsQueEsticFentGet(@PathVariable("modificacioID") java.lang.Long modificacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewModificacionsQueEsticFentGet(modificacioID,
        request, response, true);
  }


  protected ModelAndView editAndViewModificacionsQueEsticFentGet(@PathVariable("modificacioID") java.lang.Long modificacioID,
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
    ModificacionsQueEsticFentJPA modificacionsQueEsticFent = findByPrimaryKey(request, modificacioID);

    if (modificacionsQueEsticFent == null) {
      createMessageWarning(request, "error.notfound", modificacioID);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, modificacioID), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      ModificacionsQueEsticFentForm modificacionsQueEsticFentForm = getModificacionsQueEsticFentForm(modificacionsQueEsticFent, __isView, request, mav);
      modificacionsQueEsticFentForm.setView(__isView);
      if(__isView) {
        modificacionsQueEsticFentForm.setAllFieldsReadOnly(ALL_MODIFICACIONSQUEESTICFENT_FIELDS);
        modificacionsQueEsticFentForm.setSaveButtonVisible(false);
        modificacionsQueEsticFentForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(modificacionsQueEsticFentForm, request, mav);
      mav.addObject("modificacionsQueEsticFentForm", modificacionsQueEsticFentForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un ModificacionsQueEsticFent existent
   */
  @RequestMapping(value = "/{modificacioID}/edit", method = RequestMethod.GET)
  public ModelAndView editarModificacionsQueEsticFentGet(@PathVariable("modificacioID") java.lang.Long modificacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewModificacionsQueEsticFentGet(modificacioID,
        request, response, false);
  }



  /**
   * Editar un ModificacionsQueEsticFent existent
   */
  @RequestMapping(value = "/{modificacioID}/edit", method = RequestMethod.POST)
  public String editarModificacionsQueEsticFentPost(@ModelAttribute ModificacionsQueEsticFentForm modificacionsQueEsticFentForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModificacionsQueEsticFentJPA modificacionsQueEsticFent = modificacionsQueEsticFentForm.getModificacionsQueEsticFent();

    try {
      preValidate(request, modificacionsQueEsticFentForm, result);
      getWebValidator().validate(modificacionsQueEsticFentForm, result);
      postValidate(request, modificacionsQueEsticFentForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        modificacionsQueEsticFent = update(request, modificacionsQueEsticFent);
        createMessageSuccess(request, "success.modification", modificacionsQueEsticFent.getModificacioID());
        status.setComplete();
        return getRedirectWhenModified(request, modificacionsQueEsticFentForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          modificacionsQueEsticFent.getModificacioID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, modificacionsQueEsticFentForm, __e);
    }

  }


  /**
   * Eliminar un ModificacionsQueEsticFent existent
   */
  @RequestMapping(value = "/{modificacioID}/delete")
  public String eliminarModificacionsQueEsticFent(@PathVariable("modificacioID") java.lang.Long modificacioID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      ModificacionsQueEsticFent modificacionsQueEsticFent = this.findByPrimaryKey(request, modificacioID);
      if (modificacionsQueEsticFent == null) {
        String __msg = createMessageError(request, "error.notfound", modificacioID);
        return getRedirectWhenDelete(request, modificacioID, new Exception(__msg));
      } else {
        delete(request, modificacionsQueEsticFent);
        createMessageSuccess(request, "success.deleted", modificacioID);
        return getRedirectWhenDelete(request, modificacioID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", modificacioID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, modificacioID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute ModificacionsQueEsticFentFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarModificacionsQueEsticFent(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __modificacioID, Throwable e) {
    java.lang.Long modificacioID = (java.lang.Long)__modificacioID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (modificacioID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(modificacioID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "modificacionsQueEsticFent.modificacionsQueEsticFent";
  }

  public String getEntityNameCodePlural() {
    return "modificacionsQueEsticFent.modificacionsQueEsticFent.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("modificacionsQueEsticFent.modificacioID");
  }

  @InitBinder("modificacionsQueEsticFentFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("modificacionsQueEsticFentForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "modificacionsQueEsticFent.modificacioID");
  }

  public ModificacionsQueEsticFentWebValidator getWebValidator() {
    return modificacionsQueEsticFentWebValidator;
  }


  public void setWebValidator(ModificacionsQueEsticFentWebValidator __val) {
    if (__val != null) {
      this.modificacionsQueEsticFentWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de ModificacionsQueEsticFent
   */
  @RequestMapping(value = "/{modificacioID}/cancel")
  public String cancelModificacionsQueEsticFent(@PathVariable("modificacioID") java.lang.Long modificacioID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, modificacioID);
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
       ModelAndView mav, ModificacionsQueEsticFentForm modificacionsQueEsticFentForm, Where where)  throws I18NException {
    if (modificacionsQueEsticFentForm.isHiddenField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (modificacionsQueEsticFentForm.isReadOnlyField(ACCIOID)) {
      _where = AccionsFields.ACCIOID.equal(modificacionsQueEsticFentForm.getModificacionsQueEsticFent().getAccioID());
    }
    return getReferenceListForAccioID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForAccioID(HttpServletRequest request,
       ModelAndView mav, ModificacionsQueEsticFentFilterForm modificacionsQueEsticFentFilterForm,
       List<ModificacionsQueEsticFent> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (modificacionsQueEsticFentFilterForm.isHiddenField(ACCIOID)
       && !modificacionsQueEsticFentFilterForm.isGroupByField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(ACCIOID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ModificacionsQueEsticFent _item : list) {
        _pkList.add(_item.getAccioID());
        }
        _w = AccionsFields.ACCIOID.in(_pkList);
      }
    return getReferenceListForAccioID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForAccioID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return accionsRefList.getReferenceList(AccionsFields.ACCIOID, where );
  }


  public List<StringKeyValue> getReferenceListForProjecteID(HttpServletRequest request,
       ModelAndView mav, ModificacionsQueEsticFentForm modificacionsQueEsticFentForm, Where where)  throws I18NException {
    if (modificacionsQueEsticFentForm.isHiddenField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (modificacionsQueEsticFentForm.isReadOnlyField(PROJECTEID)) {
      _where = ProjectesFields.PROJECTEID.equal(modificacionsQueEsticFentForm.getModificacionsQueEsticFent().getProjecteID());
    }
    return getReferenceListForProjecteID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForProjecteID(HttpServletRequest request,
       ModelAndView mav, ModificacionsQueEsticFentFilterForm modificacionsQueEsticFentFilterForm,
       List<ModificacionsQueEsticFent> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (modificacionsQueEsticFentFilterForm.isHiddenField(PROJECTEID)
       && !modificacionsQueEsticFentFilterForm.isGroupByField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PROJECTEID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ModificacionsQueEsticFent _item : list) {
        if(_item.getProjecteID() == null) { continue; };
        _pkList.add(_item.getProjecteID());
        }
        _w = ProjectesFields.PROJECTEID.in(_pkList);
      }
    return getReferenceListForProjecteID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForProjecteID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return projectesRefList.getReferenceList(ProjectesFields.PROJECTEID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,ModificacionsQueEsticFentForm modificacionsQueEsticFentForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,ModificacionsQueEsticFentForm modificacionsQueEsticFentForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, ModificacionsQueEsticFentFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, ModificacionsQueEsticFentFilterForm filterForm,  List<ModificacionsQueEsticFent> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, ModificacionsQueEsticFentForm modificacionsQueEsticFentForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, ModificacionsQueEsticFentForm modificacionsQueEsticFentForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long modificacioID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long modificacioID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "modificacionsQueEsticFentFormWebDB";
  }

  public String getTileList() {
    return "modificacionsQueEsticFentListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "ModificacionsQueEsticFent_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public ModificacionsQueEsticFentJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long modificacioID) throws I18NException {
    return (ModificacionsQueEsticFentJPA) modificacionsQueEsticFentEjb.findByPrimaryKey(modificacioID);
  }


  public ModificacionsQueEsticFentJPA create(HttpServletRequest request, ModificacionsQueEsticFentJPA modificacionsQueEsticFent)
    throws I18NException, I18NValidationException {
    return (ModificacionsQueEsticFentJPA) modificacionsQueEsticFentEjb.create(modificacionsQueEsticFent);
  }


  public ModificacionsQueEsticFentJPA update(HttpServletRequest request, ModificacionsQueEsticFentJPA modificacionsQueEsticFent)
    throws I18NException, I18NValidationException {
    return (ModificacionsQueEsticFentJPA) modificacionsQueEsticFentEjb.update(modificacionsQueEsticFent);
  }


  public void delete(HttpServletRequest request, ModificacionsQueEsticFent modificacionsQueEsticFent) throws I18NException {
    modificacionsQueEsticFentEjb.delete(modificacionsQueEsticFent);
  }

} // Final de Classe

