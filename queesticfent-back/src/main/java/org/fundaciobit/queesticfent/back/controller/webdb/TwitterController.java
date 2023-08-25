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
import org.fundaciobit.queesticfent.back.form.webdb.TwitterForm;

import org.fundaciobit.queesticfent.back.validator.webdb.TwitterWebValidator;

import org.fundaciobit.queesticfent.persistence.TwitterJPA;
import org.fundaciobit.queesticfent.model.entity.Twitter;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Twitter
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/twitter")
@SessionAttributes(types = { TwitterForm.class, TwitterFilterForm.class })
public class TwitterController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Twitter, java.lang.Long> implements TwitterFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.TwitterService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.TwitterService twitterEjb;

  @Autowired
  private TwitterWebValidator twitterWebValidator;

  @Autowired
  protected TwitterRefList twitterRefList;

  /**
   * Llistat de totes Twitter
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    TwitterFilterForm ff;
    ff = (TwitterFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Twitter de forma paginada
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
    llistat(mav, request, getTwitterFilterForm(pagina, mav, request));
    return mav;
  }

  public TwitterFilterForm getTwitterFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    TwitterFilterForm twitterFilterForm;
    twitterFilterForm = (TwitterFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(twitterFilterForm == null) {
      twitterFilterForm = new TwitterFilterForm();
      twitterFilterForm.setContexte(getContextWeb());
      twitterFilterForm.setEntityNameCode(getEntityNameCode());
      twitterFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      twitterFilterForm.setNou(true);
    } else {
      twitterFilterForm.setNou(false);
    }
    twitterFilterForm.setPage(pagina == null ? 1 : pagina);
    return twitterFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Twitter de forma paginada
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
      @ModelAttribute TwitterFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getTwitterFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Twitter de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Twitter> llistat(ModelAndView mav, HttpServletRequest request,
     TwitterFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Twitter> twitter = processarLlistat(twitterEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("twitterItems", twitter);

    mav.addObject("twitterFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, twitter, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, twitter);

    return twitter;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(TwitterFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Twitter> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    TwitterFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Twitter> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_TWITTER_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Twitter
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearTwitterGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    TwitterForm twitterForm = getTwitterForm(null, false, request, mav);
    mav.addObject("twitterForm" ,twitterForm);
    fillReferencesForForm(twitterForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public TwitterForm getTwitterForm(TwitterJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    TwitterForm twitterForm;
    if(_jpa == null) {
      twitterForm = new TwitterForm(new TwitterJPA(), true);
    } else {
      twitterForm = new TwitterForm(_jpa, false);
      twitterForm.setView(__isView);
    }
    twitterForm.setContexte(getContextWeb());
    twitterForm.setEntityNameCode(getEntityNameCode());
    twitterForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return twitterForm;
  }

  public void fillReferencesForForm(TwitterForm twitterForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Twitter
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearTwitterPost(@ModelAttribute TwitterForm twitterForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    TwitterJPA twitter = twitterForm.getTwitter();

    try {
      preValidate(request, twitterForm, result);
      getWebValidator().validate(twitterForm, result);
      postValidate(request,twitterForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        twitter = create(request, twitter);
        createMessageSuccess(request, "success.creation", twitter.getId());
        twitterForm.setTwitter(twitter);
        return getRedirectWhenCreated(request, twitterForm);
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

  @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
  public ModelAndView veureTwitterGet(@PathVariable("id") java.lang.Long id,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewTwitterGet(id,
        request, response, true);
  }


  protected ModelAndView editAndViewTwitterGet(@PathVariable("id") java.lang.Long id,
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
    TwitterJPA twitter = findByPrimaryKey(request, id);

    if (twitter == null) {
      createMessageWarning(request, "error.notfound", id);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, id), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      TwitterForm twitterForm = getTwitterForm(twitter, __isView, request, mav);
      twitterForm.setView(__isView);
      if(__isView) {
        twitterForm.setAllFieldsReadOnly(ALL_TWITTER_FIELDS);
        twitterForm.setSaveButtonVisible(false);
        twitterForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(twitterForm, request, mav);
      mav.addObject("twitterForm", twitterForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Twitter existent
   */
  @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
  public ModelAndView editarTwitterGet(@PathVariable("id") java.lang.Long id,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewTwitterGet(id,
        request, response, false);
  }



  /**
   * Editar un Twitter existent
   */
  @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
  public String editarTwitterPost(@ModelAttribute TwitterForm twitterForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    TwitterJPA twitter = twitterForm.getTwitter();

    try {
      preValidate(request, twitterForm, result);
      getWebValidator().validate(twitterForm, result);
      postValidate(request, twitterForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        twitter = update(request, twitter);
        createMessageSuccess(request, "success.modification", twitter.getId());
        status.setComplete();
        return getRedirectWhenModified(request, twitterForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          twitter.getId(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, twitterForm, __e);
    }

  }


  /**
   * Eliminar un Twitter existent
   */
  @RequestMapping(value = "/{id}/delete")
  public String eliminarTwitter(@PathVariable("id") java.lang.Long id,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Twitter twitter = this.findByPrimaryKey(request, id);
      if (twitter == null) {
        String __msg = createMessageError(request, "error.notfound", id);
        return getRedirectWhenDelete(request, id, new Exception(__msg));
      } else {
        delete(request, twitter);
        createMessageSuccess(request, "success.deleted", id);
        return getRedirectWhenDelete(request, id,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", id, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, id, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute TwitterFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarTwitter(stringToPK(seleccionats[i]), request, response);
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
  public String[] getArgumentsMissatge(Object __id, Throwable e) {
    java.lang.Long id = (java.lang.Long)__id;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (id == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(id),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "twitter.twitter";
  }

  public String getEntityNameCodePlural() {
    return "twitter.twitter.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("twitter.id");
  }

  @InitBinder("twitterFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("twitterForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder, "twitter.id");
  }

  public TwitterWebValidator getWebValidator() {
    return twitterWebValidator;
  }


  public void setWebValidator(TwitterWebValidator __val) {
    if (__val != null) {
      this.twitterWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Twitter
   */
  @RequestMapping(value = "/{id}/cancel")
  public String cancelTwitter(@PathVariable("id") java.lang.Long id,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, id);
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

  public void preValidate(HttpServletRequest request,TwitterForm twitterForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,TwitterForm twitterForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, TwitterFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, TwitterFilterForm filterForm,  List<Twitter> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, TwitterForm twitterForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, TwitterForm twitterForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.Long id, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.Long id) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "twitterFormWebDB";
  }

  public String getTileList() {
    return "twitterListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Twitter_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public TwitterJPA findByPrimaryKey(HttpServletRequest request, java.lang.Long id) throws I18NException {
    return (TwitterJPA) twitterEjb.findByPrimaryKey(id);
  }


  public TwitterJPA create(HttpServletRequest request, TwitterJPA twitter)
    throws I18NException, I18NValidationException {
    return (TwitterJPA) twitterEjb.create(twitter);
  }


  public TwitterJPA update(HttpServletRequest request, TwitterJPA twitter)
    throws I18NException, I18NValidationException {
    return (TwitterJPA) twitterEjb.update(twitter);
  }


  public void delete(HttpServletRequest request, Twitter twitter) throws I18NException {
    twitterEjb.delete(twitter);
  }

} // Final de Classe

