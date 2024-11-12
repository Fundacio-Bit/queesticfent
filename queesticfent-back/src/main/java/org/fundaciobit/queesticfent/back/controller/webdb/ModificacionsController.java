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
import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsForm;

import org.fundaciobit.queesticfent.back.validator.webdb.ModificacionsWebValidator;

import org.fundaciobit.queesticfent.persistence.ModificacionsJPA;
import org.fundaciobit.queesticfent.model.entity.Modificacions;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Modificacions
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/modificacions")
@SessionAttributes(types = { ModificacionsForm.class, ModificacionsFilterForm.class })
public class ModificacionsController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Modificacions, java.lang.Long> implements ModificacionsFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacionsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ModificacionsService modificacionsEjb;

  @Autowired
  private ModificacionsWebValidator modificacionsWebValidator;

  @Autowired
  protected ModificacionsRefList modificacionsRefList;

  // References 
  @Autowired
  protected EntradesRefList entradesRefList;

  // References 
  @Autowired
  protected AccionsRefList accionsRefList;

  // References 
  @Autowired
  protected ProjectesRefList projectesRefList;

  /**
   * Llistat de totes Modificacions
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    ModificacionsFilterForm ff;
    ff = (ModificacionsFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Modificacions de forma paginada
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
    llistat(mav, request, getModificacionsFilterForm(pagina, mav, request));
    return mav;
  }

  public ModificacionsFilterForm getModificacionsFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    ModificacionsFilterForm modificacionsFilterForm;
    modificacionsFilterForm = (ModificacionsFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(modificacionsFilterForm == null) {
      modificacionsFilterForm = new ModificacionsFilterForm();
      modificacionsFilterForm.setContexte(getContextWeb());
      modificacionsFilterForm.setEntityNameCode(getEntityNameCode());
      modificacionsFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      modificacionsFilterForm.setNou(true);
    } else {
      modificacionsFilterForm.setNou(false);
    }
    modificacionsFilterForm.setPage(pagina == null ? 1 : pagina);
    return modificacionsFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Modificacions de forma paginada
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
      @ModelAttribute ModificacionsFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getModificacionsFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Modificacions de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Modificacions> llistat(ModelAndView mav, HttpServletRequest request,
     ModificacionsFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Modificacions> modificacions = processarLlistat(modificacionsEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("modificacionsItems", modificacions);

    mav.addObject("modificacionsFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, modificacions, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, modificacions);

    return modificacions;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(ModificacionsFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Modificacions> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field entradaid
    {
      _listSKV = getReferenceListForEntradaid(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfEntradesForEntradaid(_tmp);
      if (filterForm.getGroupByFields().contains(ENTRADAID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ENTRADAID, false);
      };
    }

    // Field accioid
    {
      _listSKV = getReferenceListForAccioid(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfAccionsForAccioid(_tmp);
      if (filterForm.getGroupByFields().contains(ACCIOID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, ACCIOID, false);
      };
    }

    // Field oldprojecteID
    {
      _listSKV = getReferenceListForOldprojecteID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfProjectesForOldprojecteID(_tmp);
      if (filterForm.getGroupByFields().contains(OLDPROJECTEID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, OLDPROJECTEID, false);
      };
    }

    // Field newprojecteID
    {
      _listSKV = getReferenceListForNewprojecteID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfProjectesForNewprojecteID(_tmp);
      if (filterForm.getGroupByFields().contains(NEWPROJECTEID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, NEWPROJECTEID, false);
      };
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    ModificacionsFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Modificacions> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_MODIFICACIONS_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(ENTRADAID, filterForm.getMapOfEntradesForEntradaid());
    __mapping.put(ACCIOID, filterForm.getMapOfAccionsForAccioid());
    __mapping.put(OLDPROJECTEID, filterForm.getMapOfProjectesForOldprojecteID());
    __mapping.put(NEWPROJECTEID, filterForm.getMapOfProjectesForNewprojecteID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Modificacions
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearModificacionsGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    ModificacionsForm modificacionsForm = getModificacionsForm(null, false, request, mav);
    mav.addObject("modificacionsForm" ,modificacionsForm);
    fillReferencesForForm(modificacionsForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public ModificacionsForm getModificacionsForm(ModificacionsJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    ModificacionsForm modificacionsForm;
    if(_jpa == null) {
      modificacionsForm = new ModificacionsForm(new ModificacionsJPA(), true);
    } else {
      modificacionsForm = new ModificacionsForm(_jpa, false);
      modificacionsForm.setView(__isView);
    }
    modificacionsForm.setContexte(getContextWeb());
    modificacionsForm.setEntityNameCode(getEntityNameCode());
    modificacionsForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return modificacionsForm;
  }

  public void fillReferencesForForm(ModificacionsForm modificacionsForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (modificacionsForm.getListOfEntradesForEntradaid() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForEntradaid(request, mav, modificacionsForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      modificacionsForm.setListOfEntradesForEntradaid(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (modificacionsForm.getListOfAccionsForAccioid() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForAccioid(request, mav, modificacionsForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      modificacionsForm.setListOfAccionsForAccioid(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (modificacionsForm.getListOfProjectesForOldprojecteID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForOldprojecteID(request, mav, modificacionsForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      modificacionsForm.setListOfProjectesForOldprojecteID(_listSKV);
    }
    // Comprovam si ja esta definida la llista
    if (modificacionsForm.getListOfProjectesForNewprojecteID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForNewprojecteID(request, mav, modificacionsForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      modificacionsForm.setListOfProjectesForNewprojecteID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Modificacions
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearModificacionsPost(@ModelAttribute ModificacionsForm modificacionsForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModificacionsJPA modificacions = modificacionsForm.getModificacions();

    try {
      preValidate(request, modificacionsForm, result);
      getWebValidator().validate(modificacionsForm, result);
      postValidate(request,modificacionsForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        modificacions = create(request, modificacions);
        createMessageSuccess(request, "success.creation", modificacions.getModificacioid());
        modificacionsForm.setModificacions(modificacions);
        return getRedirectWhenCreated(request, modificacionsForm);
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

  @RequestMapping(value = "/view/{modificacioid}", method = RequestMethod.GET)
  public ModelAndView veureModificacionsGet(@PathVariable("modificacioid") java.lang.Long modificacioid,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewModificacionsGet(modificacioid,
        request, response, true);
  }


  protected ModelAndView editAndViewModificacionsGet(@PathVariable("modificacioid") java.lang.Long modificacioid,
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
    ModificacionsJPA modificacions = findByPrimaryKey(request, modificacioid);

    if (modificacions == null) {
      createMessageWarning(request, "error.notfound", modificacioid);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, modificacioid), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      ModificacionsForm modificacionsForm = getModificacionsForm(modificacions, __isView, request, mav);
      modificacionsForm.setView(__isView);
      if(__isView) {
        modificacionsForm.setAllFieldsReadOnly(ALL_MODIFICACIONS_FIELDS);
        modificacionsForm.setSaveButtonVisible(false);
        modificacionsForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(modificacionsForm, request, mav);
      mav.addObject("modificacionsForm", modificacionsForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Modificacions existent
   */
  @RequestMapping(value = "/{modificacioid}/edit", method = RequestMethod.GET)
  public ModelAndView editarModificacionsGet(@PathVariable("modificacioid") java.lang.Long modificacioid,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewModificacionsGet(modificacioid,
        request, response, false);
  }



  /**
   * Editar un Modificacions existent
   */
  @RequestMapping(value = "/{modificacioid}/edit", method = RequestMethod.POST)
  public String editarModificacionsPost(@ModelAttribute ModificacionsForm modificacionsForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModificacionsJPA modificacions = modificacionsForm.getModificacions();

    try {
      preValidate(request, modificacionsForm, result);
      getWebValidator().validate(modificacionsForm, result);
      postValidate(request, modificacionsForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        modificacions = update(request, modificacions);
        createMessageSuccess(request, "success.modification", modificacions.getModificacioid());
        status.setComplete();
        return getRedirectWhenModified(request, modificacionsForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          modificacions.getModificacioid(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, modificacionsForm, __e);
    }

  }


  /**
   * Eliminar un Modificacions existent
   */
  @RequestMapping(value = "/{modificacioid}/delete")
  public String eliminarModificacions(@PathVariable("modificacioid") java.lang.Long modificacioid,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Modificacions modificacions = this.findByPrimaryKey(request, modificacioid);
      if (modificacions == null) {
        String __msg = createMessageError(request, "error.notfound", modificacioid);
        return getRedirectWhenDelete(request, modificacioid, new Exception(__msg));
      } else {
        delete(request, modificacions);
        createMessageSuccess(request, "success.deleted", modificacioid);
        return getRedirectWhenDelete(request, modificacioid,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", modificacioid, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, modificacioid, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute ModificacionsFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarModificacions(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __modificacioid, Throwable e) {
    java.lang.Long modificacioid = (java.lang.Long)__modificacioid;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (modificacioid == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(modificacioid),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "modificacions.modificacions";
  }

  public String getEntityNameCodePlural() {
    return "modificacions.modificacions.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("modificacions.modificacioid");
  }

  @InitBinder("modificacionsFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("modificacionsForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "modificacions.modificacioid");
  }

  public ModificacionsWebValidator getWebValidator() {
    return modificacionsWebValidator;
  }


  public void setWebValidator(ModificacionsWebValidator __val) {
    if (__val != null) {
      this.modificacionsWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Modificacions
   */
  @RequestMapping(value = "/{modificacioid}/cancel")
  public String cancelModificacions(@PathVariable("modificacioid") java.lang.Long modificacioid,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, modificacioid);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de Modificacions
   */
  @RequestMapping(value = "/cancel")
  public String cancelModificacions(HttpServletRequest request,HttpServletResponse response) {
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


  public List<StringKeyValue> getReferenceListForEntradaid(HttpServletRequest request,
       ModelAndView mav, ModificacionsForm modificacionsForm, Where where)  throws I18NException {
    if (modificacionsForm.isHiddenField(ENTRADAID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (modificacionsForm.isReadOnlyField(ENTRADAID)) {
      _where = EntradesFields.ENTRADAID.equal(modificacionsForm.getModificacions().getEntradaid());
    }
    return getReferenceListForEntradaid(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForEntradaid(HttpServletRequest request,
       ModelAndView mav, ModificacionsFilterForm modificacionsFilterForm,
       List<Modificacions> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (modificacionsFilterForm.isHiddenField(ENTRADAID)
       && !modificacionsFilterForm.isGroupByField(ENTRADAID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(ENTRADAID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Modificacions _item : list) {
        _pkList.add(_item.getEntradaid());
        }
        _w = EntradesFields.ENTRADAID.in(_pkList);
      }
    return getReferenceListForEntradaid(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForEntradaid(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return entradesRefList.getReferenceList(EntradesFields.ENTRADAID, where );
  }


  public List<StringKeyValue> getReferenceListForAccioid(HttpServletRequest request,
       ModelAndView mav, ModificacionsForm modificacionsForm, Where where)  throws I18NException {
    if (modificacionsForm.isHiddenField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (modificacionsForm.isReadOnlyField(ACCIOID)) {
      _where = AccionsFields.ACCIOID.equal(modificacionsForm.getModificacions().getAccioid());
    }
    return getReferenceListForAccioid(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForAccioid(HttpServletRequest request,
       ModelAndView mav, ModificacionsFilterForm modificacionsFilterForm,
       List<Modificacions> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (modificacionsFilterForm.isHiddenField(ACCIOID)
       && !modificacionsFilterForm.isGroupByField(ACCIOID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(ACCIOID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Modificacions _item : list) {
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


  public List<StringKeyValue> getReferenceListForOldprojecteID(HttpServletRequest request,
       ModelAndView mav, ModificacionsForm modificacionsForm, Where where)  throws I18NException {
    if (modificacionsForm.isHiddenField(OLDPROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (modificacionsForm.isReadOnlyField(OLDPROJECTEID)) {
      _where = ProjectesFields.PROJECTEID.equal(modificacionsForm.getModificacions().getOldprojecteID());
    }
    return getReferenceListForOldprojecteID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForOldprojecteID(HttpServletRequest request,
       ModelAndView mav, ModificacionsFilterForm modificacionsFilterForm,
       List<Modificacions> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (modificacionsFilterForm.isHiddenField(OLDPROJECTEID)
       && !modificacionsFilterForm.isGroupByField(OLDPROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(OLDPROJECTEID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Modificacions _item : list) {
        if(_item.getOldprojecteID() == null) { continue; };
        _pkList.add(_item.getOldprojecteID());
        }
        _w = ProjectesFields.PROJECTEID.in(_pkList);
      }
    return getReferenceListForOldprojecteID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForOldprojecteID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return projectesRefList.getReferenceList(ProjectesFields.PROJECTEID, where );
  }


  public List<StringKeyValue> getReferenceListForNewprojecteID(HttpServletRequest request,
       ModelAndView mav, ModificacionsForm modificacionsForm, Where where)  throws I18NException {
    if (modificacionsForm.isHiddenField(NEWPROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (modificacionsForm.isReadOnlyField(NEWPROJECTEID)) {
      _where = ProjectesFields.PROJECTEID.equal(modificacionsForm.getModificacions().getNewprojecteID());
    }
    return getReferenceListForNewprojecteID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForNewprojecteID(HttpServletRequest request,
       ModelAndView mav, ModificacionsFilterForm modificacionsFilterForm,
       List<Modificacions> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (modificacionsFilterForm.isHiddenField(NEWPROJECTEID)
       && !modificacionsFilterForm.isGroupByField(NEWPROJECTEID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(NEWPROJECTEID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Modificacions _item : list) {
        if(_item.getNewprojecteID() == null) { continue; };
        _pkList.add(_item.getNewprojecteID());
        }
        _w = ProjectesFields.PROJECTEID.in(_pkList);
      }
    return getReferenceListForNewprojecteID(request, mav, Where.AND(where,_w));
  }


  public List<StringKeyValue> getReferenceListForNewprojecteID(HttpServletRequest request,
       ModelAndView mav, Where where)  throws I18NException {
    return projectesRefList.getReferenceList(ProjectesFields.PROJECTEID, where );
  }


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,ModificacionsForm modificacionsForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,ModificacionsForm modificacionsForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, ModificacionsFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, ModificacionsFilterForm filterForm,  List<Modificacions> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, ModificacionsForm modificacionsForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, ModificacionsForm modificacionsForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long modificacioid, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long modificacioid) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "modificacionsFormWebDB";
  }

  public String getTileList() {
    return "modificacionsListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Modificacions_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public ModificacionsJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long modificacioid) throws I18NException {
    return (ModificacionsJPA) modificacionsEjb.findByPrimaryKey(modificacioid);
  }


  public ModificacionsJPA create(HttpServletRequest request, ModificacionsJPA modificacions)
    throws I18NException, I18NValidationException {
    return (ModificacionsJPA) modificacionsEjb.create(modificacions);
  }


  public ModificacionsJPA update(HttpServletRequest request, ModificacionsJPA modificacions)
    throws I18NException, I18NValidationException {
    return (ModificacionsJPA) modificacionsEjb.update(modificacions);
  }


  public void delete(HttpServletRequest request, Modificacions modificacions) throws I18NException {
    modificacionsEjb.delete(modificacions);
  }

} // Final de Classe

