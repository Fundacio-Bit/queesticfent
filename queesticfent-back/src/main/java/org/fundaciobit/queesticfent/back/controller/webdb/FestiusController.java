package org.fundaciobit.queesticfent.back.controller.webdb;

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
import org.fundaciobit.queesticfent.back.form.webdb.FestiusForm;

import org.fundaciobit.queesticfent.back.validator.webdb.FestiusWebValidator;

import org.fundaciobit.queesticfent.persistence.FestiusJPA;
import org.fundaciobit.queesticfent.model.entity.Festius;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Festius
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/festius")
@SessionAttributes(types = { FestiusForm.class, FestiusFilterForm.class })
public class FestiusController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Festius, java.lang.Long> implements FestiusFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.FestiusService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.FestiusService festiusEjb;

  @Autowired
  private FestiusWebValidator festiusWebValidator;

  @Autowired
  protected FestiusRefList festiusRefList;

  /**
   * Llistat de totes Festius
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    FestiusFilterForm ff;
    ff = (FestiusFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Festius de forma paginada
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
    llistat(mav, request, getFestiusFilterForm(pagina, mav, request));
    return mav;
  }

  public FestiusFilterForm getFestiusFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    FestiusFilterForm festiusFilterForm;
    festiusFilterForm = (FestiusFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(festiusFilterForm == null) {
      festiusFilterForm = new FestiusFilterForm();
      festiusFilterForm.setContexte(getContextWeb());
      festiusFilterForm.setEntityNameCode(getEntityNameCode());
      festiusFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      festiusFilterForm.setNou(true);
    } else {
      festiusFilterForm.setNou(false);
    }
    festiusFilterForm.setPage(pagina == null ? 1 : pagina);
    return festiusFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Festius de forma paginada
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
      @ModelAttribute FestiusFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getFestiusFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Festius de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Festius> llistat(ModelAndView mav, HttpServletRequest request,
     FestiusFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Festius> festius = processarLlistat(festiusEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("festiusItems", festius);

    mav.addObject("festiusFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, festius, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, festius);

    return festius;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(FestiusFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Festius> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    FestiusFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Festius> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_FESTIUS_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Festius
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearFestiusGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    FestiusForm festiusForm = getFestiusForm(null, false, request, mav);
    mav.addObject("festiusForm" ,festiusForm);
    fillReferencesForForm(festiusForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public FestiusForm getFestiusForm(FestiusJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    FestiusForm festiusForm;
    if(_jpa == null) {
      festiusForm = new FestiusForm(new FestiusJPA(), true);
    } else {
      festiusForm = new FestiusForm(_jpa, false);
      festiusForm.setView(__isView);
    }
    festiusForm.setContexte(getContextWeb());
    festiusForm.setEntityNameCode(getEntityNameCode());
    festiusForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return festiusForm;
  }

  public void fillReferencesForForm(FestiusForm festiusForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Festius
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearFestiusPost(@ModelAttribute FestiusForm festiusForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    FestiusJPA festius = festiusForm.getFestius();

    try {
      preValidate(request, festiusForm, result);
      getWebValidator().validate(festiusForm, result);
      postValidate(request,festiusForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        festius = create(request, festius);
        createMessageSuccess(request, "success.creation", festius.getFestiuid());
        festiusForm.setFestius(festius);
        return getRedirectWhenCreated(request, festiusForm);
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

  @RequestMapping(value = "/view/{festiuid}", method = RequestMethod.GET)
  public ModelAndView veureFestiusGet(@PathVariable("festiuid") java.lang.Long festiuid,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewFestiusGet(festiuid,
        request, response, true);
  }


  protected ModelAndView editAndViewFestiusGet(@PathVariable("festiuid") java.lang.Long festiuid,
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
    FestiusJPA festius = findByPrimaryKey(request, festiuid);

    if (festius == null) {
      createMessageWarning(request, "error.notfound", festiuid);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, festiuid), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      FestiusForm festiusForm = getFestiusForm(festius, __isView, request, mav);
      festiusForm.setView(__isView);
      if(__isView) {
        festiusForm.setAllFieldsReadOnly(ALL_FESTIUS_FIELDS);
        festiusForm.setSaveButtonVisible(false);
        festiusForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(festiusForm, request, mav);
      mav.addObject("festiusForm", festiusForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Festius existent
   */
  @RequestMapping(value = "/{festiuid}/edit", method = RequestMethod.GET)
  public ModelAndView editarFestiusGet(@PathVariable("festiuid") java.lang.Long festiuid,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewFestiusGet(festiuid,
        request, response, false);
  }



  /**
   * Editar un Festius existent
   */
  @RequestMapping(value = "/{festiuid}/edit", method = RequestMethod.POST)
  public String editarFestiusPost(@ModelAttribute FestiusForm festiusForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    FestiusJPA festius = festiusForm.getFestius();

    try {
      preValidate(request, festiusForm, result);
      getWebValidator().validate(festiusForm, result);
      postValidate(request, festiusForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        festius = update(request, festius);
        createMessageSuccess(request, "success.modification", festius.getFestiuid());
        status.setComplete();
        return getRedirectWhenModified(request, festiusForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          festius.getFestiuid(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, festiusForm, __e);
    }

  }


  /**
   * Eliminar un Festius existent
   */
  @RequestMapping(value = "/{festiuid}/delete")
  public String eliminarFestius(@PathVariable("festiuid") java.lang.Long festiuid,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Festius festius = this.findByPrimaryKey(request, festiuid);
      if (festius == null) {
        String __msg = createMessageError(request, "error.notfound", festiuid);
        return getRedirectWhenDelete(request, festiuid, new Exception(__msg));
      } else {
        delete(request, festius);
        createMessageSuccess(request, "success.deleted", festiuid);
        return getRedirectWhenDelete(request, festiuid,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", festiuid, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, festiuid, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute FestiusFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarFestius(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __festiuid, Throwable e) {
    java.lang.Long festiuid = (java.lang.Long)__festiuid;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (festiuid == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(festiuid),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "festius.festius";
  }

  public String getEntityNameCodePlural() {
    return "festius.festius.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("festius.festiuid");
  }

  @InitBinder("festiusFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("festiusForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "festius.festiuid");
  }

  public FestiusWebValidator getWebValidator() {
    return festiusWebValidator;
  }


  public void setWebValidator(FestiusWebValidator __val) {
    if (__val != null) {
      this.festiusWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Festius
   */
  @RequestMapping(value = "/{festiuid}/cancel")
  public String cancelFestius(@PathVariable("festiuid") java.lang.Long festiuid,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, festiuid);
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


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,FestiusForm festiusForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,FestiusForm festiusForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, FestiusFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, FestiusFilterForm filterForm,  List<Festius> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, FestiusForm festiusForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, FestiusForm festiusForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long festiuid, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long festiuid) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "festiusFormWebDB";
  }

  public String getTileList() {
    return "festiusListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Festius_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public FestiusJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long festiuid) throws I18NException {
    return (FestiusJPA) festiusEjb.findByPrimaryKey(festiuid);
  }


  public FestiusJPA create(HttpServletRequest request, FestiusJPA festius)
    throws I18NException, I18NValidationException {
    return (FestiusJPA) festiusEjb.create(festius);
  }


  public FestiusJPA update(HttpServletRequest request, FestiusJPA festius)
    throws I18NException, I18NValidationException {
    return (FestiusJPA) festiusEjb.update(festius);
  }


  public void delete(HttpServletRequest request, Festius festius) throws I18NException {
    festiusEjb.delete(festius);
  }

} // Final de Classe

