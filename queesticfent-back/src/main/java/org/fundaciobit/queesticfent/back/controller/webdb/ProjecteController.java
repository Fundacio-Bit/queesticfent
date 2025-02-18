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
import org.fundaciobit.queesticfent.back.form.webdb.ProjecteForm;

import org.fundaciobit.queesticfent.back.validator.webdb.ProjecteWebValidator;

import org.fundaciobit.queesticfent.persistence.ProjecteJPA;
import org.fundaciobit.queesticfent.model.entity.Projecte;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un Projecte
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="projecte.projecte.plural", order=80, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/projecte")
@SessionAttributes(types = { ProjecteForm.class, ProjecteFilterForm.class })
public class ProjecteController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Projecte, java.lang.Long> implements ProjecteFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjecteService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjecteService projecteEjb;

  @Autowired
  private ProjecteWebValidator projecteWebValidator;

  @Autowired
  protected ProjecteRefList projecteRefList;

  // References 
  @Autowired
  protected DepartamentRefList departamentRefList;

  /**
   * Llistat de totes Projecte
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    ProjecteFilterForm ff;
    ff = (ProjecteFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Projecte de forma paginada
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
    llistat(mav, request, getProjecteFilterForm(pagina, mav, request));
    return mav;
  }

  public ProjecteFilterForm getProjecteFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    ProjecteFilterForm projecteFilterForm;
    projecteFilterForm = (ProjecteFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(projecteFilterForm == null) {
      projecteFilterForm = new ProjecteFilterForm();
      projecteFilterForm.setContexte(getContextWeb());
      projecteFilterForm.setEntityNameCode(getEntityNameCode());
      projecteFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      projecteFilterForm.setNou(true);
    } else {
      projecteFilterForm.setNou(false);
    }
    projecteFilterForm.setPage(pagina == null ? 1 : pagina);
    return projecteFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Projecte de forma paginada
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
      @ModelAttribute ProjecteFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getProjecteFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Projecte de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Projecte> llistat(ModelAndView mav, HttpServletRequest request,
     ProjecteFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Projecte> projecte = processarLlistat(projecteEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("projecteItems", projecte);

    mav.addObject("projecteFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, projecte, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, projecte);

    return projecte;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(ProjecteFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Projecte> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }

    Map<String, String> _tmp;
    List<StringKeyValue> _listSKV;

    // Field departamentID
    {
      _listSKV = getReferenceListForDepartamentID(request, mav, filterForm, list, groupByItemsMap, null);
      _tmp = Utils.listToMap(_listSKV);
      filterForm.setMapOfDepartamentForDepartamentID(_tmp);
      if (filterForm.getGroupByFields().contains(DEPARTAMENTID)) {
        fillValuesToGroupByItems(_tmp, groupByItemsMap, DEPARTAMENTID, false);
      };
    }


      fillValuesToGroupByItemsBoolean("genapp.checkbox", groupByItemsMap, ACTIU);


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    ProjecteFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Projecte> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_PROJECTE_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    __mapping.put(DEPARTAMENTID, filterForm.getMapOfDepartamentForDepartamentID());
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Projecte
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearProjecteGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    ProjecteForm projecteForm = getProjecteForm(null, false, request, mav);
    mav.addObject("projecteForm" ,projecteForm);
    fillReferencesForForm(projecteForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public ProjecteForm getProjecteForm(ProjecteJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    ProjecteForm projecteForm;
    if(_jpa == null) {
      projecteForm = new ProjecteForm(new ProjecteJPA(), true);
    } else {
      projecteForm = new ProjecteForm(_jpa, false);
      projecteForm.setView(__isView);
    }
    projecteForm.setContexte(getContextWeb());
    projecteForm.setEntityNameCode(getEntityNameCode());
    projecteForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return projecteForm;
  }

  public void fillReferencesForForm(ProjecteForm projecteForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    // Comprovam si ja esta definida la llista
    if (projecteForm.getListOfDepartamentForDepartamentID() == null) {
      List<StringKeyValue> _listSKV = getReferenceListForDepartamentID(request, mav, projecteForm, null);

      if(_listSKV != null && !_listSKV.isEmpty()) { 
          java.util.Collections.sort(_listSKV, STRINGKEYVALUE_COMPARATOR);
      }
      projecteForm.setListOfDepartamentForDepartamentID(_listSKV);
    }
    
  }

  /**
   * Guardar un nou Projecte
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearProjectePost(@ModelAttribute ProjecteForm projecteForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ProjecteJPA projecte = projecteForm.getProjecte();

    try {
      preValidate(request, projecteForm, result);
      getWebValidator().validate(projecteForm, result);
      postValidate(request,projecteForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        projecte = create(request, projecte);
        createMessageSuccess(request, "success.creation", projecte.getProjecteID());
        projecteForm.setProjecte(projecte);
        return getRedirectWhenCreated(request, projecteForm);
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

  @RequestMapping(value = "/view/{projecteID}", method = RequestMethod.GET)
  public ModelAndView veureProjecteGet(@PathVariable("projecteID") java.lang.Long projecteID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewProjecteGet(projecteID,
        request, response, true);
  }


  protected ModelAndView editAndViewProjecteGet(@PathVariable("projecteID") java.lang.Long projecteID,
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
    ProjecteJPA projecte = findByPrimaryKey(request, projecteID);

    if (projecte == null) {
      createMessageWarning(request, "error.notfound", projecteID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      ProjecteForm projecteForm = getProjecteForm(projecte, __isView, request, mav);
      projecteForm.setView(__isView);
      if(__isView) {
        projecteForm.setAllFieldsReadOnly(ALL_PROJECTE_FIELDS);
        projecteForm.setSaveButtonVisible(false);
        projecteForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(projecteForm, request, mav);
      mav.addObject("projecteForm", projecteForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Projecte existent
   */
  @RequestMapping(value = "/{projecteID}/edit", method = RequestMethod.GET)
  public ModelAndView editarProjecteGet(@PathVariable("projecteID") java.lang.Long projecteID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewProjecteGet(projecteID,
        request, response, false);
  }



  /**
   * Editar un Projecte existent
   */
  @RequestMapping(value = "/{projecteID}/edit", method = RequestMethod.POST)
  public String editarProjectePost(@ModelAttribute ProjecteForm projecteForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ProjecteJPA projecte = projecteForm.getProjecte();

    try {
      preValidate(request, projecteForm, result);
      getWebValidator().validate(projecteForm, result);
      postValidate(request, projecteForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        projecte = update(request, projecte);
        createMessageSuccess(request, "success.modification", projecte.getProjecteID());
        status.setComplete();
        return getRedirectWhenModified(request, projecteForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          projecte.getProjecteID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, projecteForm, __e);
    }

  }


  /**
   * Eliminar un Projecte existent
   */
  @RequestMapping(value = "/{projecteID}/delete")
  public String eliminarProjecte(@PathVariable("projecteID") java.lang.Long projecteID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Projecte projecte = this.findByPrimaryKey(request, projecteID);
      if (projecte == null) {
        String __msg = createMessageError(request, "error.notfound", projecteID);
        return getRedirectWhenDelete(request, projecteID, new Exception(__msg));
      } else {
        delete(request, projecte);
        createMessageSuccess(request, "success.deleted", projecteID);
        return getRedirectWhenDelete(request, projecteID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", projecteID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, projecteID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute ProjecteFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarProjecte(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __projecteID, Throwable e) {
    java.lang.Long projecteID = (java.lang.Long)__projecteID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (projecteID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(projecteID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "projecte.projecte";
  }

  public String getEntityNameCodePlural() {
    return "projecte.projecte.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("projecte.projecteID");
  }

  @InitBinder("projecteFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("projecteForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "projecte.projecteID");
  }

  public ProjecteWebValidator getWebValidator() {
    return projecteWebValidator;
  }


  public void setWebValidator(ProjecteWebValidator __val) {
    if (__val != null) {
      this.projecteWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Projecte
   */
  @RequestMapping(value = "/{projecteID}/cancel")
  public String cancelProjecte(@PathVariable("projecteID") java.lang.Long projecteID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, projecteID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de Projecte
   */
  @RequestMapping(value = "/cancel")
  public String cancelProjecte(HttpServletRequest request,HttpServletResponse response) {
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


  public List<StringKeyValue> getReferenceListForDepartamentID(HttpServletRequest request,
       ModelAndView mav, ProjecteForm projecteForm, Where where)  throws I18NException {
    if (projecteForm.isHiddenField(DEPARTAMENTID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _where = null;
    if (projecteForm.isReadOnlyField(DEPARTAMENTID)) {
      _where = DepartamentFields.DEPARTAMENTID.equal(projecteForm.getProjecte().getDepartamentID());
    }
    return getReferenceListForDepartamentID(request, mav, Where.AND(where, _where));
  }


  public List<StringKeyValue> getReferenceListForDepartamentID(HttpServletRequest request,
       ModelAndView mav, ProjecteFilterForm projecteFilterForm,
       List<Projecte> list, Map<Field<?>, GroupByItem> _groupByItemsMap, Where where)  throws I18NException {
    if (projecteFilterForm.isHiddenField(DEPARTAMENTID)
       && !projecteFilterForm.isGroupByField(DEPARTAMENTID)) {
      return EMPTY_STRINGKEYVALUE_LIST;
    }
    Where _w = null;
    if (!_groupByItemsMap.containsKey(DEPARTAMENTID)) {
      // OBTENIR TOTES LES CLAUS (PK) i despres només cercar referències d'aquestes PK
      java.util.Set<java.lang.Long> _pkList = new java.util.HashSet<java.lang.Long>();
      for (Projecte _item : list) {
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

  public void preValidate(HttpServletRequest request,ProjecteForm projecteForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,ProjecteForm projecteForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, ProjecteFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, ProjecteFilterForm filterForm,  List<Projecte> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, ProjecteForm projecteForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, ProjecteForm projecteForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long projecteID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long projecteID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "projecteFormWebDB";
  }

  public String getTileList() {
    return "projecteListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Projecte_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public ProjecteJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long projecteID) throws I18NException {
    return (ProjecteJPA) projecteEjb.findByPrimaryKey(projecteID);
  }


  public ProjecteJPA create(HttpServletRequest request, ProjecteJPA projecte)
    throws I18NException, I18NValidationException {
    return (ProjecteJPA) projecteEjb.create(projecte);
  }


  public ProjecteJPA update(HttpServletRequest request, ProjecteJPA projecte)
    throws I18NException, I18NValidationException {
    return (ProjecteJPA) projecteEjb.update(projecte);
  }


  public void delete(HttpServletRequest request, Projecte projecte) throws I18NException {
    projecteEjb.delete(projecte);
  }

} // Final de Classe

