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
import org.fundaciobit.queesticfent.back.form.webdb.ModificacioQueEsticFentForm;

import org.fundaciobit.queesticfent.back.validator.webdb.ModificacioQueEsticFentWebValidator;

import org.fundaciobit.queesticfent.persistence.ModificacioQueEsticFentJPA;
import org.fundaciobit.queesticfent.model.entity.ModificacioQueEsticFent;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un ModificacioQueEsticFent
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="modificacioQueEsticFent.modificacioQueEsticFent.plural", order=60, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/modificacioQueEsticFent")
@SessionAttributes(types = { ModificacioQueEsticFentForm.class, ModificacioQueEsticFentFilterForm.class })
public class ModificacioQueEsticFentController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<ModificacioQueEsticFent, java.lang.Long> implements ModificacioQueEsticFentFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacioQueEsticFentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ModificacioQueEsticFentService modificacioQueEsticFentEjb;

  @Autowired
  private ModificacioQueEsticFentWebValidator modificacioQueEsticFentWebValidator;

  @Autowired
  protected ModificacioQueEsticFentRefList modificacioQueEsticFentRefList;

  // References 
  @Autowired
  protected AccioRefList accioRefList;

  // References 
  @Autowired
  protected ProjecteRefList projecteRefList;

  /**
   * Llistat de totes ModificacioQueEsticFent
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    ModificacioQueEsticFentFilterForm ff;
    ff = (ModificacioQueEsticFentFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar ModificacioQueEsticFent de forma paginada
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
    llistat(mav, request, getModificacioQueEsticFentFilterForm(pagina, mav, request));
    return mav;
  }

  public ModificacioQueEsticFentFilterForm getModificacioQueEsticFentFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    ModificacioQueEsticFentFilterForm modificacioQueEsticFentFilterForm;
    modificacioQueEsticFentFilterForm = (ModificacioQueEsticFentFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(modificacioQueEsticFentFilterForm == null) {
      modificacioQueEsticFentFilterForm = new ModificacioQueEsticFentFilterForm();
      modificacioQueEsticFentFilterForm.setContexte(getContextWeb());
      modificacioQueEsticFentFilterForm.setEntityNameCode(getEntityNameCode());
      modificacioQueEsticFentFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      modificacioQueEsticFentFilterForm.setNou(true);
    } else {
      modificacioQueEsticFentFilterForm.setNou(false);
    }
    modificacioQueEsticFentFilterForm.setPage(pagina == null ? 1 : pagina);
    return modificacioQueEsticFentFilterForm;
  }

  /**
   * Segona i següent peticions per llistar ModificacioQueEsticFent de forma paginada
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
      @ModelAttribute ModificacioQueEsticFentFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getModificacioQueEsticFentFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de ModificacioQueEsticFent de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<ModificacioQueEsticFent> llistat(ModelAndView mav, HttpServletRequest request,
     ModificacioQueEsticFentFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<ModificacioQueEsticFent> modificacioQueEsticFent = processarLlistat(modificacioQueEsticFentEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("modificacioQueEsticFentItems", modificacioQueEsticFent);

    mav.addObject("modificacioQueEsticFentFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, modificacioQueEsticFent, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, modificacioQueEsticFent);

    return modificacioQueEsticFent;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(ModificacioQueEsticFentFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<ModificacioQueEsticFent> list, List<GroupByItem> groupItems) throws I18NException {
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
    ModificacioQueEsticFentFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<ModificacioQueEsticFent> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_MODIFICACIOQUEESTICFENT_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(ACCIOID, filterForm.getMapOfAccioForAccioID());
    __mapping.put(PROJECTEID, filterForm.getMapOfProjecteForProjecteID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou ModificacioQueEsticFent
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearModificacioQueEsticFentGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    ModificacioQueEsticFentForm modificacioQueEsticFentForm = getModificacioQueEsticFentForm(null, false, request, mav);
    mav.addObject("modificacioQueEsticFentForm" ,modificacioQueEsticFentForm);
    fillReferencesForForm(modificacioQueEsticFentForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public ModificacioQueEsticFentForm getModificacioQueEsticFentForm(ModificacioQueEsticFentJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    ModificacioQueEsticFentForm modificacioQueEsticFentForm;
    if(_jpa == null) {
      modificacioQueEsticFentForm = new ModificacioQueEsticFentForm(new ModificacioQueEsticFentJPA(), true);
    } else {
      modificacioQueEsticFentForm = new ModificacioQueEsticFentForm(_jpa, false);
      modificacioQueEsticFentForm.setView(__isView);
    }
    modificacioQueEsticFentForm.setContexte(getContextWeb());
    modificacioQueEsticFentForm.setEntityNameCode(getEntityNameCode());
    modificacioQueEsticFentForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return modificacioQueEsticFentForm;
  }

  public void fillReferencesForForm(ModificacioQueEsticFentForm modificacioQueEsticFentForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (modificacioQueEsticFentForm.getListOfAccioForAccioID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForAccioID(request, mav, modificacioQueEsticFentForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      modificacioQueEsticFentForm.setListOfAccioForAccioID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (modificacioQueEsticFentForm.getListOfProjecteForProjecteID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForProjecteID(request, mav, modificacioQueEsticFentForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      modificacioQueEsticFentForm.setListOfProjecteForProjecteID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou ModificacioQueEsticFent
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearModificacioQueEsticFentPost(@ModelAttribute ModificacioQueEsticFentForm modificacioQueEsticFentForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModificacioQueEsticFentJPA modificacioQueEsticFent = modificacioQueEsticFentForm.getModificacioQueEsticFent();

    try {
      preValidate(request, modificacioQueEsticFentForm, result);
      getWebValidator().validate(modificacioQueEsticFentForm, result);
      postValidate(request,modificacioQueEsticFentForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        modificacioQueEsticFent = create(request, modificacioQueEsticFent);
        createMessageSuccess(request, "success.creation", modificacioQueEsticFent.getModificacioID());
        modificacioQueEsticFentForm.setModificacioQueEsticFent(modificacioQueEsticFent);
        return getRedirectWhenCreated(request, modificacioQueEsticFentForm);
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
  public ModelAndView veureModificacioQueEsticFentGet(@PathVariable("modificacioID") java.lang.Long modificacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewModificacioQueEsticFentGet(modificacioID,
        request, response, true);
  }


  protected ModelAndView editAndViewModificacioQueEsticFentGet(@PathVariable("modificacioID") java.lang.Long modificacioID,
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
    ModificacioQueEsticFentJPA modificacioQueEsticFent = findByPrimaryKey(request, modificacioID);

    if (modificacioQueEsticFent == null) {
      createMessageWarning(request, "error.notfound", modificacioID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      ModificacioQueEsticFentForm modificacioQueEsticFentForm = getModificacioQueEsticFentForm(modificacioQueEsticFent, __isView, request, mav);
      modificacioQueEsticFentForm.setView(__isView);
      if(__isView) {
        modificacioQueEsticFentForm.setAllFieldsReadOnly(ALL_MODIFICACIOQUEESTICFENT_FIELDS);
        modificacioQueEsticFentForm.setSaveButtonVisible(false);
        modificacioQueEsticFentForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(modificacioQueEsticFentForm, request, mav);
      mav.addObject("modificacioQueEsticFentForm", modificacioQueEsticFentForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un ModificacioQueEsticFent existent
   */
  @RequestMapping(value = "/{modificacioID}/edit", method = RequestMethod.GET)
  public ModelAndView editarModificacioQueEsticFentGet(@PathVariable("modificacioID") java.lang.Long modificacioID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewModificacioQueEsticFentGet(modificacioID,
        request, response, false);
  }



  /**
   * Editar un ModificacioQueEsticFent existent
   */
  @RequestMapping(value = "/{modificacioID}/edit", method = RequestMethod.POST)
  public String editarModificacioQueEsticFentPost(@ModelAttribute ModificacioQueEsticFentForm modificacioQueEsticFentForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModificacioQueEsticFentJPA modificacioQueEsticFent = modificacioQueEsticFentForm.getModificacioQueEsticFent();

    try {
      preValidate(request, modificacioQueEsticFentForm, result);
      getWebValidator().validate(modificacioQueEsticFentForm, result);
      postValidate(request, modificacioQueEsticFentForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        modificacioQueEsticFent = update(request, modificacioQueEsticFent);
        createMessageSuccess(request, "success.modification", modificacioQueEsticFent.getModificacioID());
        status.setComplete();
        return getRedirectWhenModified(request, modificacioQueEsticFentForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          modificacioQueEsticFent.getModificacioID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, modificacioQueEsticFentForm, __e);
    }

  }


  /**
   * Eliminar un ModificacioQueEsticFent existent
   */
  @RequestMapping(value = "/{modificacioID}/delete")
  public String eliminarModificacioQueEsticFent(@PathVariable("modificacioID") java.lang.Long modificacioID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      ModificacioQueEsticFent modificacioQueEsticFent = this.findByPrimaryKey(request, modificacioID);
      if (modificacioQueEsticFent == null) {
        String __msg = createMessageError(request, "error.notfound", modificacioID);
        return getRedirectWhenDelete(request, modificacioID, new Exception(__msg));
      } else {
        delete(request, modificacioQueEsticFent);
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
    @ModelAttribute ModificacioQueEsticFentFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarModificacioQueEsticFent(stringToPK(seleccionats[i]), request, response);
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
    return "modificacioQueEsticFent.modificacioQueEsticFent";
  }

  public String getEntityNameCodePlural() {
    return "modificacioQueEsticFent.modificacioQueEsticFent.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("modificacioQueEsticFent.modificacioID");
  }

  @InitBinder("modificacioQueEsticFentFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("modificacioQueEsticFentForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "modificacioQueEsticFent.modificacioID");
  }

  public ModificacioQueEsticFentWebValidator getWebValidator() {
    return modificacioQueEsticFentWebValidator;
  }


  public void setWebValidator(ModificacioQueEsticFentWebValidator __val) {
    if (__val != null) {
      this.modificacioQueEsticFentWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de ModificacioQueEsticFent
   */
  @RequestMapping(value = "/{modificacioID}/cancel")
  public String cancelModificacioQueEsticFent(@PathVariable("modificacioID") java.lang.Long modificacioID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, modificacioID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de ModificacioQueEsticFent
   */
  @RequestMapping(value = "/cancel")
  public String cancelModificacioQueEsticFent(HttpServletRequest request,HttpServletResponse response) {
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
       ModelAndView mav, ModificacioQueEsticFentForm modificacioQueEsticFentForm, Where where)  throws I18NException {
    if (modificacioQueEsticFentForm.isHiddenField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (modificacioQueEsticFentForm.isReadOnlyField(ACCIOID)) {
      _where = AccioFields.ACCIOID.equal(modificacioQueEsticFentForm.getModificacioQueEsticFent().getAccioID());
    }
    return getReferenceListForAccioID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForAccioID(HttpServletRequest request,
       ModelAndView mav, ModificacioQueEsticFentFilterForm modificacioQueEsticFentFilterForm,
       List<ModificacioQueEsticFent> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (modificacioQueEsticFentFilterForm.isHiddenField(ACCIOID)
       && !modificacioQueEsticFentFilterForm.isGroupByField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(ACCIOID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ModificacioQueEsticFent _item : list) {
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
       ModelAndView mav, ModificacioQueEsticFentForm modificacioQueEsticFentForm, Where where)  throws I18NException {
    if (modificacioQueEsticFentForm.isHiddenField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (modificacioQueEsticFentForm.isReadOnlyField(PROJECTEID)) {
      _where = ProjecteFields.PROJECTEID.equal(modificacioQueEsticFentForm.getModificacioQueEsticFent().getProjecteID());
    }
    return getReferenceListForProjecteID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForProjecteID(HttpServletRequest request,
       ModelAndView mav, ModificacioQueEsticFentFilterForm modificacioQueEsticFentFilterForm,
       List<ModificacioQueEsticFent> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (modificacioQueEsticFentFilterForm.isHiddenField(PROJECTEID)
       && !modificacioQueEsticFentFilterForm.isGroupByField(PROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(PROJECTEID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (ModificacioQueEsticFent _item : list) {
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

  public void preValidate(HttpServletRequest request,ModificacioQueEsticFentForm modificacioQueEsticFentForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,ModificacioQueEsticFentForm modificacioQueEsticFentForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, ModificacioQueEsticFentFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, ModificacioQueEsticFentFilterForm filterForm,  List<ModificacioQueEsticFent> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, ModificacioQueEsticFentForm modificacioQueEsticFentForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, ModificacioQueEsticFentForm modificacioQueEsticFentForm, Throwable __e) {
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
    return "modificacioQueEsticFentFormWebDB";
  }

  public String getTileList() {
    return "modificacioQueEsticFentListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "ModificacioQueEsticFent_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public ModificacioQueEsticFentJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long modificacioID) throws I18NException {
    return (ModificacioQueEsticFentJPA) modificacioQueEsticFentEjb.findByPrimaryKey(modificacioID);
  }


  public ModificacioQueEsticFentJPA create(HttpServletRequest request, ModificacioQueEsticFentJPA modificacioQueEsticFent)
    throws I18NException, I18NValidationException {
    return (ModificacioQueEsticFentJPA) modificacioQueEsticFentEjb.create(modificacioQueEsticFent);
  }


  public ModificacioQueEsticFentJPA update(HttpServletRequest request, ModificacioQueEsticFentJPA modificacioQueEsticFent)
    throws I18NException, I18NValidationException {
    return (ModificacioQueEsticFentJPA) modificacioQueEsticFentEjb.update(modificacioQueEsticFent);
  }


  public void delete(HttpServletRequest request, ModificacioQueEsticFent modificacioQueEsticFent) throws I18NException {
    modificacioQueEsticFentEjb.delete(modificacioQueEsticFent);
  }

} // Final de Classe

