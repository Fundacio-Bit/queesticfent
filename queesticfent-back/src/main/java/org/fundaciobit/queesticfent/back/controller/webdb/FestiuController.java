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
import org.fundaciobit.queesticfent.back.form.webdb.FestiuForm;

import org.fundaciobit.queesticfent.back.validator.webdb.FestiuWebValidator;

import org.fundaciobit.queesticfent.persistence.FestiuJPA;
import org.fundaciobit.queesticfent.model.entity.Festiu;
import org.fundaciobit.queesticfent.model.fields.*;
import org.fundaciobit.genapp.common.web.menuoptions.MenuOption;

/**
 * Controller per gestionar un Festiu
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@MenuOption(labelCode="festiu.festiu.plural", order=30, group="WEBDB")
@Controller
@RequestMapping(value = "/webdb/festiu")
@SessionAttributes(types = { FestiuForm.class, FestiuFilterForm.class })
public class FestiuController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Festiu, java.lang.Long> implements FestiuFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.FestiuService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.FestiuService festiuEjb;

  @Autowired
  private FestiuWebValidator festiuWebValidator;

  @Autowired
  protected FestiuRefList festiuRefList;

  /**
   * Llistat de totes Festiu
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    FestiuFilterForm ff;
    ff = (FestiuFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Festiu de forma paginada
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
    llistat(mav, request, getFestiuFilterForm(pagina, mav, request));
    return mav;
  }

  public FestiuFilterForm getFestiuFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    FestiuFilterForm festiuFilterForm;
    festiuFilterForm = (FestiuFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(festiuFilterForm == null) {
      festiuFilterForm = new FestiuFilterForm();
      festiuFilterForm.setContexte(getContextWeb());
      festiuFilterForm.setEntityNameCode(getEntityNameCode());
      festiuFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      festiuFilterForm.setNou(true);
    } else {
      festiuFilterForm.setNou(false);
    }
    festiuFilterForm.setPage(pagina == null ? 1 : pagina);
    return festiuFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Festiu de forma paginada
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
      @ModelAttribute FestiuFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getFestiuFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Festiu de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Festiu> llistat(ModelAndView mav, HttpServletRequest request,
     FestiuFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Festiu> festiu = processarLlistat(festiuEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("festiuItems", festiu);

    mav.addObject("festiuFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, festiu, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, festiu);

    return festiu;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(FestiuFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Festiu> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    FestiuFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Festiu> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_FESTIU_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Festiu
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearFestiuGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    FestiuForm festiuForm = getFestiuForm(null, false, request, mav);
    mav.addObject("festiuForm" ,festiuForm);
    fillReferencesForForm(festiuForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public FestiuForm getFestiuForm(FestiuJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    FestiuForm festiuForm;
    if(_jpa == null) {
      festiuForm = new FestiuForm(new FestiuJPA(), true);
    } else {
      festiuForm = new FestiuForm(_jpa, false);
      festiuForm.setView(__isView);
    }
    festiuForm.setContexte(getContextWeb());
    festiuForm.setEntityNameCode(getEntityNameCode());
    festiuForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return festiuForm;
  }

  public void fillReferencesForForm(FestiuForm festiuForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Festiu
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearFestiuPost(@ModelAttribute FestiuForm festiuForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    FestiuJPA festiu = festiuForm.getFestiu();

    try {
      preValidate(request, festiuForm, result);
      getWebValidator().validate(festiuForm, result);
      postValidate(request,festiuForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        festiu = create(request, festiu);
        createMessageSuccess(request, "success.creation", festiu.getFestiuID());
        festiuForm.setFestiu(festiu);
        return getRedirectWhenCreated(request, festiuForm);
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

  @RequestMapping(value = "/view/{festiuID}", method = RequestMethod.GET)
  public ModelAndView veureFestiuGet(@PathVariable("festiuID") java.lang.Long festiuID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewFestiuGet(festiuID,
        request, response, true);
  }


  protected ModelAndView editAndViewFestiuGet(@PathVariable("festiuID") java.lang.Long festiuID,
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
    FestiuJPA festiu = findByPrimaryKey(request, festiuID);

    if (festiu == null) {
      createMessageWarning(request, "error.notfound", festiuID);
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      FestiuForm festiuForm = getFestiuForm(festiu, __isView, request, mav);
      festiuForm.setView(__isView);
      if(__isView) {
        festiuForm.setAllFieldsReadOnly(ALL_FESTIU_FIELDS);
        festiuForm.setSaveButtonVisible(false);
        festiuForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(festiuForm, request, mav);
      mav.addObject("festiuForm", festiuForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Festiu existent
   */
  @RequestMapping(value = "/{festiuID}/edit", method = RequestMethod.GET)
  public ModelAndView editarFestiuGet(@PathVariable("festiuID") java.lang.Long festiuID,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewFestiuGet(festiuID,
        request, response, false);
  }



  /**
   * Editar un Festiu existent
   */
  @RequestMapping(value = "/{festiuID}/edit", method = RequestMethod.POST)
  public String editarFestiuPost(@ModelAttribute FestiuForm festiuForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    FestiuJPA festiu = festiuForm.getFestiu();

    try {
      preValidate(request, festiuForm, result);
      getWebValidator().validate(festiuForm, result);
      postValidate(request, festiuForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        festiu = update(request, festiu);
        createMessageSuccess(request, "success.modification", festiu.getFestiuID());
        status.setComplete();
        return getRedirectWhenModified(request, festiuForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          festiu.getFestiuID(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, festiuForm, __e);
    }

  }


  /**
   * Eliminar un Festiu existent
   */
  @RequestMapping(value = "/{festiuID}/delete")
  public String eliminarFestiu(@PathVariable("festiuID") java.lang.Long festiuID,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Festiu festiu = this.findByPrimaryKey(request, festiuID);
      if (festiu == null) {
        String __msg = createMessageError(request, "error.notfound", festiuID);
        return getRedirectWhenDelete(request, festiuID, new Exception(__msg));
      } else {
        delete(request, festiu);
        createMessageSuccess(request, "success.deleted", festiuID);
        return getRedirectWhenDelete(request, festiuID,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", festiuID, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, festiuID, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute FestiuFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarFestiu(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __festiuID, Throwable e) {
    java.lang.Long festiuID = (java.lang.Long)__festiuID;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (festiuID == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(festiuID),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "festiu.festiu";
  }

  public String getEntityNameCodePlural() {
    return "festiu.festiu.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("festiu.festiuID");
  }

  @InitBinder("festiuFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("festiuForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "festiu.festiuID");
  }

  public FestiuWebValidator getWebValidator() {
    return festiuWebValidator;
  }


  public void setWebValidator(FestiuWebValidator __val) {
    if (__val != null) {
      this.festiuWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Festiu
   */
  @RequestMapping(value = "/{festiuID}/cancel")
  public String cancelFestiu(@PathVariable("festiuID") java.lang.Long festiuID,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, festiuID);
  }

  /**
   * Entra aqui al pitjar el boto cancel en el la creació de Festiu
   */
  @RequestMapping(value = "/cancel")
  public String cancelFestiu(HttpServletRequest request,HttpServletResponse response) {
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


  @Override
  /** Ha de ser igual que el RequestMapping de la Classe */
  public String getContextWeb() {
    RequestMapping rm = AnnotationUtils.findAnnotation(this.getClass(), RequestMapping.class);
    return rm.value()[0];
  }

  public void preValidate(HttpServletRequest request,FestiuForm festiuForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,FestiuForm festiuForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, FestiuFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, FestiuFilterForm filterForm,  List<Festiu> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, FestiuForm festiuForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, FestiuForm festiuForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long festiuID, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long festiuID) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "festiuFormWebDB";
  }

  public String getTileList() {
    return "festiuListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Festiu_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public FestiuJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long festiuID) throws I18NException {
    return (FestiuJPA) festiuEjb.findByPrimaryKey(festiuID);
  }


  public FestiuJPA create(HttpServletRequest request, FestiuJPA festiu)
    throws I18NException, I18NValidationException {
    return (FestiuJPA) festiuEjb.create(festiu);
  }


  public FestiuJPA update(HttpServletRequest request, FestiuJPA festiu)
    throws I18NException, I18NValidationException {
    return (FestiuJPA) festiuEjb.update(festiu);
  }


  public void delete(HttpServletRequest request, Festiu festiu) throws I18NException {
    festiuEjb.delete(festiu);
  }

} // Final de Classe

