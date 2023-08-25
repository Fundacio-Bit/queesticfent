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
import org.fundaciobit.queesticfent.back.form.webdb.ProjectesForm;

import org.fundaciobit.queesticfent.back.validator.webdb.ProjectesWebValidator;

import org.fundaciobit.queesticfent.persistence.ProjectesJPA;
import org.fundaciobit.queesticfent.model.entity.Projectes;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Projectes
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/projectes")
@SessionAttributes(types = { ProjectesForm.class, ProjectesFilterForm.class })
public class ProjectesController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Projectes, java.lang.Long> implements ProjectesFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjectesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjectesService projectesEjb;

  @Autowired
  private ProjectesWebValidator projectesWebValidator;

  @Autowired
  protected ProjectesRefList projectesRefList;

  // References 
  @Autowired
  protected DepartamentsRefList departamentsRefList;

  /**
   * Llistat de totes Projectes
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    ProjectesFilterForm ff;
    ff = (ProjectesFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Projectes de forma paginada
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
    llistat(mav, request, getProjectesFilterForm(pagina, mav, request));
    return mav;
  }

  public ProjectesFilterForm getProjectesFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    ProjectesFilterForm projectesFilterForm;
    projectesFilterForm = (ProjectesFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(projectesFilterForm == null) {
      projectesFilterForm = new ProjectesFilterForm();
      projectesFilterForm.setContexte(getContextWeb());
      projectesFilterForm.setEntityNameCode(getEntityNameCode());
      projectesFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      projectesFilterForm.setNou(true);
    } else {
      projectesFilterForm.setNou(false);
    }
    projectesFilterForm.setPage(pagina == null ? 1 : pagina);
    return projectesFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Projectes de forma paginada
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
      @ModelAttribute ProjectesFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getProjectesFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Projectes de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Projectes> llistat(ModelAndView mav, HttpServletRequest request,
     ProjectesFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Projectes> projectes = processarLlistat(projectesEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("projectesItems", projectes);

    mav.addObject("projectesFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, projectes, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, projectes);

    return projectes;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(ProjectesFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Projectes> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field departamentid
    {
      _listSKV = getReferenceListForDepartamentid(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfDepartamentsForDepartamentid(_tmp);
      if (filterForm.getGroupByFields().contains(DEPARTAMENTID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, DEPARTAMENTID, false);
      };
    }


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ACTIU);


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ACTIU2);


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    ProjectesFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Projectes> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_PROJECTES_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(DEPARTAMENTID, filterForm.getMapOfDepartamentsForDepartamentid());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Projectes
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearProjectesGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    ProjectesForm projectesForm = getProjectesForm(null, false, request, mav);
    mav.addObject("projectesForm" ,projectesForm);
    fillReferencesForForm(projectesForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public ProjectesForm getProjectesForm(ProjectesJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    ProjectesForm projectesForm;
    if(_jpa == null) {
      projectesForm = new ProjectesForm(new ProjectesJPA(), true);
    } else {
      projectesForm = new ProjectesForm(_jpa, false);
      projectesForm.setView(__isView);
    }
    projectesForm.setContexte(getContextWeb());
    projectesForm.setEntityNameCode(getEntityNameCode());
    projectesForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return projectesForm;
  }

  public void fillReferencesForForm(ProjectesForm projectesForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (projectesForm.getListOfDepartamentsForDepartamentid() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForDepartamentid(request, mav, projectesForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      projectesForm.setListOfDepartamentsForDepartamentid(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Projectes
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearProjectesPost(@ModelAttribute ProjectesForm projectesForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ProjectesJPA projectes = projectesForm.getProjectes();

    try {
      preValidate(request, projectesForm, result);
      getWebValidator().validate(projectesForm, result);
      postValidate(request,projectesForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        projectes = create(request, projectes);
        createMessageSuccess(request, "success.creation", projectes.getProjecteid());
        projectesForm.setProjectes(projectes);
        return getRedirectWhenCreated(request, projectesForm);
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

  @RequestMapping(value = "/view/{projecteid}", method = RequestMethod.GET)
  public ModelAndView veureProjectesGet(@PathVariable("projecteid") java.lang.Long projecteid,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewProjectesGet(projecteid,
        request, response, true);
  }


  protected ModelAndView editAndViewProjectesGet(@PathVariable("projecteid") java.lang.Long projecteid,
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
    ProjectesJPA projectes = findByPrimaryKey(request, projecteid);

    if (projectes == null) {
      createMessageWarning(request, "error.notfound", projecteid);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, projecteid), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      ProjectesForm projectesForm = getProjectesForm(projectes, __isView, request, mav);
      projectesForm.setView(__isView);
      if(__isView) {
        projectesForm.setAllFieldsReadOnly(ALL_PROJECTES_FIELDS);
        projectesForm.setSaveButtonVisible(false);
        projectesForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(projectesForm, request, mav);
      mav.addObject("projectesForm", projectesForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Projectes existent
   */
  @RequestMapping(value = "/{projecteid}/edit", method = RequestMethod.GET)
  public ModelAndView editarProjectesGet(@PathVariable("projecteid") java.lang.Long projecteid,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewProjectesGet(projecteid,
        request, response, false);
  }



  /**
   * Editar un Projectes existent
   */
  @RequestMapping(value = "/{projecteid}/edit", method = RequestMethod.POST)
  public String editarProjectesPost(@ModelAttribute ProjectesForm projectesForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ProjectesJPA projectes = projectesForm.getProjectes();

    try {
      preValidate(request, projectesForm, result);
      getWebValidator().validate(projectesForm, result);
      postValidate(request, projectesForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        projectes = update(request, projectes);
        createMessageSuccess(request, "success.modification", projectes.getProjecteid());
        status.setComplete();
        return getRedirectWhenModified(request, projectesForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          projectes.getProjecteid(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, projectesForm, __e);
    }

  }


  /**
   * Eliminar un Projectes existent
   */
  @RequestMapping(value = "/{projecteid}/delete")
  public String eliminarProjectes(@PathVariable("projecteid") java.lang.Long projecteid,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Projectes projectes = this.findByPrimaryKey(request, projecteid);
      if (projectes == null) {
        String __msg = createMessageError(request, "error.notfound", projecteid);
        return getRedirectWhenDelete(request, projecteid, new Exception(__msg));
      } else {
        delete(request, projectes);
        createMessageSuccess(request, "success.deleted", projecteid);
        return getRedirectWhenDelete(request, projecteid,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", projecteid, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, projecteid, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute ProjectesFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarProjectes(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __projecteid, Throwable e) {
    java.lang.Long projecteid = (java.lang.Long)__projecteid;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (projecteid == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(projecteid),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "projectes.projectes";
  }

  public String getEntityNameCodePlural() {
    return "projectes.projectes.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("projectes.projecteid");
  }

  @InitBinder("projectesFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("projectesForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "projectes.projecteid");
  }

  public ProjectesWebValidator getWebValidator() {
    return projectesWebValidator;
  }


  public void setWebValidator(ProjectesWebValidator __val) {
    if (__val != null) {
      this.projectesWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Projectes
   */
  @RequestMapping(value = "/{projecteid}/cancel")
  public String cancelProjectes(@PathVariable("projecteid") java.lang.Long projecteid,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, projecteid);
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


  public List<StringKeyValue> getReferenceListForDepartamentid(HttpServletRequest request,
       ModelAndView mav, ProjectesForm projectesForm, Where where)  throws I18NException {
    if (projectesForm.isHiddenField(DEPARTAMENTID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (projectesForm.isReadOnlyField(DEPARTAMENTID)) {
      _where = DepartamentsFields.DEPARTAMENTID.equal(projectesForm.getProjectes().getDepartamentid());
    }
    return getReferenceListForDepartamentid(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForDepartamentid(HttpServletRequest request,
       ModelAndView mav, ProjectesFilterForm projectesFilterForm,
       List<Projectes> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (projectesFilterForm.isHiddenField(DEPARTAMENTID)
       && !projectesFilterForm.isGroupByField(DEPARTAMENTID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(DEPARTAMENTID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Projectes _item : list) {
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

  public void preValidate(HttpServletRequest request,ProjectesForm projectesForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,ProjectesForm projectesForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, ProjectesFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, ProjectesFilterForm filterForm,  List<Projectes> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, ProjectesForm projectesForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, ProjectesForm projectesForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long projecteid, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long projecteid) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "projectesFormWebDB";
  }

  public String getTileList() {
    return "projectesListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Projectes_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public ProjectesJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long projecteid) throws I18NException {
    return (ProjectesJPA) projectesEjb.findByPrimaryKey(projecteid);
  }


  public ProjectesJPA create(HttpServletRequest request, ProjectesJPA projectes)
    throws I18NException, I18NValidationException {
    return (ProjectesJPA) projectesEjb.create(projectes);
  }


  public ProjectesJPA update(HttpServletRequest request, ProjectesJPA projectes)
    throws I18NException, I18NValidationException {
    return (ProjectesJPA) projectesEjb.update(projectes);
  }


  public void delete(HttpServletRequest request, Projectes projectes) throws I18NException {
    projectesEjb.delete(projectes);
  }

} // Final de Classe

