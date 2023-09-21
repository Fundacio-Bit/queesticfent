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
import org.fundaciobit.queesticfent.back.form.webdb.UsuarisForm;

import org.fundaciobit.queesticfent.back.validator.webdb.UsuarisWebValidator;

import org.fundaciobit.queesticfent.persistence.UsuarisJPA;
import org.fundaciobit.queesticfent.model.entity.Usuaris;
import org.fundaciobit.queesticfent.model.fields.*;

/**
 * Controller per gestionar un Usuaris
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * 
 * @author GenApp
 */
@Controller
@RequestMapping(value = "/webdb/usuaris")
@SessionAttributes(types = { UsuarisForm.class, UsuarisFilterForm.class })
public class UsuarisController
    extends org.fundaciobit.queesticfent.back.controller.queesticfentBaseController<Usuaris, java.lang.String> implements UsuarisFields {

  @EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuarisService usuarisEjb;

  @Autowired
  private UsuarisWebValidator usuarisWebValidator;

  @Autowired
  protected UsuarisRefList usuarisRefList;

  /**
   * Llistat de totes Usuaris
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String llistat(HttpServletRequest request,
    HttpServletResponse response) throws I18NException {
    UsuarisFilterForm ff;
    ff = (UsuarisFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    int pagina = (ff == null)? 1: ff.getPage();
    return "redirect:" + getContextWeb() + "/list/" + pagina;
  }

  /**
   * Primera peticio per llistar Usuaris de forma paginada
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
    llistat(mav, request, getUsuarisFilterForm(pagina, mav, request));
    return mav;
  }

  public UsuarisFilterForm getUsuarisFilterForm(Integer pagina, ModelAndView mav,
    HttpServletRequest request) throws I18NException {
    UsuarisFilterForm usuarisFilterForm;
    usuarisFilterForm = (UsuarisFilterForm) request.getSession().getAttribute(getSessionAttributeFilterForm());
    if(usuarisFilterForm == null) {
      usuarisFilterForm = new UsuarisFilterForm();
      usuarisFilterForm.setContexte(getContextWeb());
      usuarisFilterForm.setEntityNameCode(getEntityNameCode());
      usuarisFilterForm.setEntityNameCodePlural(getEntityNameCodePlural());
      usuarisFilterForm.setNou(true);
    } else {
      usuarisFilterForm.setNou(false);
    }
    usuarisFilterForm.setPage(pagina == null ? 1 : pagina);
    return usuarisFilterForm;
  }

  /**
   * Segona i següent peticions per llistar Usuaris de forma paginada
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
      @ModelAttribute UsuarisFilterForm filterForm) throws I18NException {
    if(!isActiveList()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    ModelAndView mav = new ModelAndView(getTileList());

    filterForm.setPage(pagina == null ? 1 : pagina);
    // Actualitza el filter form

    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);
    filterForm = getUsuarisFilterForm(pagina, mav, request);

    llistat(mav, request, filterForm);
    return mav;
  }

  /**
   * Codi centralitzat de llistat de Usuaris de forma paginada.
   * 
   * @param request
   * @param filterForm
   * @param pagina
   * @return
   * @throws I18NException
   */
  protected List<Usuaris> llistat(ModelAndView mav, HttpServletRequest request,
     UsuarisFilterForm filterForm) throws I18NException {

    int pagina = filterForm.getPage();
    request.getSession().setAttribute(getSessionAttributeFilterForm(), filterForm);

    captureSearchByValueOfAdditionalFields(request, filterForm);

    preList(request, mav, filterForm);

    List<Usuaris> usuaris = processarLlistat(usuarisEjb,
        filterForm, pagina, getAdditionalCondition(request), mav);

    mav.addObject("usuarisItems", usuaris);

    mav.addObject("usuarisFilterForm", filterForm);

    fillReferencesForList(filterForm,request, mav, usuaris, (List<GroupByItem>)mav.getModel().get("groupby_items"));

    postList(request, mav, filterForm, usuaris);

    return usuaris;
  }


  public Map<Field<?>, GroupByItem> fillReferencesForList(UsuarisFilterForm filterForm,
    HttpServletRequest request, ModelAndView mav,
      List<Usuaris> list, List<GroupByItem> groupItems) throws I18NException {
    Map<Field<?>, GroupByItem> groupByItemsMap = new HashMap<Field<?>, GroupByItem>();
    for (GroupByItem groupByItem : groupItems) {
      groupByItemsMap.put(groupByItem.getField(),groupByItem);
    }


    return groupByItemsMap;
  }

  @RequestMapping(value = "/export/{dataExporterID}", method = RequestMethod.POST)
  public void exportList(@PathVariable("dataExporterID") String dataExporterID,
    HttpServletRequest request, HttpServletResponse response,
    UsuarisFilterForm filterForm) throws Exception, I18NException {

    ModelAndView mav = new ModelAndView(getTileList());
    List<Usuaris> list = llistat(mav, request, filterForm);
    Field<?>[] allFields = ALL_USUARIS_FIELDS;

    java.util.Map<Field<?>, java.util.Map<String, String>> __mapping;
    __mapping = new java.util.HashMap<Field<?>, java.util.Map<String, String>>();
    exportData(request, response, dataExporterID, filterForm,
          list, allFields, __mapping, PRIMARYKEY_FIELDS);
  }



  /**
   * Carregar el formulari per un nou Usuaris
   */
  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public ModelAndView crearUsuarisGet(HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    ModelAndView mav = new ModelAndView(getTileForm());
    UsuarisForm usuarisForm = getUsuarisForm(null, false, request, mav);
    mav.addObject("usuarisForm" ,usuarisForm);
    fillReferencesForForm(usuarisForm, request, mav);
  
    return mav;
  }
  
  /**
   * 
   * @return
   * @throws Exception
   */
  public UsuarisForm getUsuarisForm(UsuarisJPA _jpa,
       boolean __isView, HttpServletRequest request, ModelAndView mav) throws I18NException {
    UsuarisForm usuarisForm;
    if(_jpa == null) {
      usuarisForm = new UsuarisForm(new UsuarisJPA(), true);
    } else {
      usuarisForm = new UsuarisForm(_jpa, false);
      usuarisForm.setView(__isView);
    }
    usuarisForm.setContexte(getContextWeb());
    usuarisForm.setEntityNameCode(getEntityNameCode());
    usuarisForm.setEntityNameCodePlural(getEntityNameCodePlural());
    return usuarisForm;
  }

  public void fillReferencesForForm(UsuarisForm usuarisForm,
    HttpServletRequest request, ModelAndView mav) throws I18NException {
    
  }

  /**
   * Guardar un nou Usuaris
   */
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String crearUsuarisPost(@ModelAttribute UsuarisForm usuarisForm,
      BindingResult result, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    if(!isActiveFormNew()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }

    UsuarisJPA usuaris = usuarisForm.getUsuaris();

    try {
      preValidate(request, usuarisForm, result);
      getWebValidator().validate(usuarisForm, result);
      postValidate(request,usuarisForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuaris = create(request, usuaris);
        createMessageSuccess(request, "success.creation", usuaris.getUsuariId());
        usuarisForm.setUsuaris(usuaris);
        return getRedirectWhenCreated(request, usuarisForm);
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

  @RequestMapping(value = "/view/{usuariId}", method = RequestMethod.GET)
  public ModelAndView veureUsuarisGet(@PathVariable("usuariId") java.lang.String usuariId,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuarisGet(usuariId,
        request, response, true);
  }


  protected ModelAndView editAndViewUsuarisGet(@PathVariable("usuariId") java.lang.String usuariId,
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
    UsuarisJPA usuaris = findByPrimaryKey(request, usuariId);

    if (usuaris == null) {
      createMessageWarning(request, "error.notfound", usuariId);
      new ModelAndView(new RedirectView(getRedirectWhenCancel(request, usuariId), true));
      return llistatPaginat(request, response, 1);
    } else {
      ModelAndView mav = new ModelAndView(getTileForm());
      UsuarisForm usuarisForm = getUsuarisForm(usuaris, __isView, request, mav);
      usuarisForm.setView(__isView);
      if(__isView) {
        usuarisForm.setAllFieldsReadOnly(ALL_USUARIS_FIELDS);
        usuarisForm.setSaveButtonVisible(false);
        usuarisForm.setDeleteButtonVisible(false);
      }
      fillReferencesForForm(usuarisForm, request, mav);
      mav.addObject("usuarisForm", usuarisForm);
      return mav;
    }
  }


  /**
   * Carregar el formulari per modificar un Usuaris existent
   */
  @RequestMapping(value = "/{usuariId}/edit", method = RequestMethod.GET)
  public ModelAndView editarUsuarisGet(@PathVariable("usuariId") java.lang.String usuariId,
      HttpServletRequest request,
      HttpServletResponse response) throws I18NException {
      return editAndViewUsuarisGet(usuariId,
        request, response, false);
  }



  /**
   * Editar un Usuaris existent
   */
  @RequestMapping(value = "/{usuariId}/edit", method = RequestMethod.POST)
  public String editarUsuarisPost(@ModelAttribute UsuarisForm usuarisForm,
      BindingResult result, SessionStatus status, HttpServletRequest request,
      HttpServletResponse response) throws I18NException {

    if(!isActiveFormEdit()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    UsuarisJPA usuaris = usuarisForm.getUsuaris();

    try {
      preValidate(request, usuarisForm, result);
      getWebValidator().validate(usuarisForm, result);
      postValidate(request, usuarisForm, result);

      if (result.hasErrors()) {
        result.reject("error.form");
        return getTileForm();
      } else {
        usuaris = update(request, usuaris);
        createMessageSuccess(request, "success.modification", usuaris.getUsuariId());
        status.setComplete();
        return getRedirectWhenModified(request, usuarisForm, null);
      }
    } catch (Throwable __e) {
      if (__e instanceof I18NValidationException) {
        ValidationWebUtils.addFieldErrorsToBindingResult(result, (I18NValidationException)__e);
        return getTileForm();
      }
      String msg = createMessageError(request, "error.modification",
          usuaris.getUsuariId(), __e);
      log.error(msg, __e);
      return getRedirectWhenModified(request, usuarisForm, __e);
    }

  }


  /**
   * Eliminar un Usuaris existent
   */
  @RequestMapping(value = "/{usuariId}/delete")
  public String eliminarUsuaris(@PathVariable("usuariId") java.lang.String usuariId,
      HttpServletRequest request,HttpServletResponse response) {

    if(!isActiveDelete()) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return null;
    }
    try {
      Usuaris usuaris = this.findByPrimaryKey(request, usuariId);
      if (usuaris == null) {
        String __msg = createMessageError(request, "error.notfound", usuariId);
        return getRedirectWhenDelete(request, usuariId, new Exception(__msg));
      } else {
        delete(request, usuaris);
        createMessageSuccess(request, "success.deleted", usuariId);
        return getRedirectWhenDelete(request, usuariId,null);
      }

    } catch (Throwable e) {
      String msg = createMessageError(request, "error.deleting", usuariId, e);
      log.error(msg, e);
      return getRedirectWhenDelete(request, usuariId, e);
    }
  }


@RequestMapping(value = "/deleteSelected", method = RequestMethod.POST)
public String deleteSelected(HttpServletRequest request,
    HttpServletResponse response,
    @ModelAttribute UsuarisFilterForm filterForm) throws Exception {

  if(!isActiveDelete()) {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return null;
  }
  
  String[] seleccionats = filterForm.getSelectedItems();
  String redirect = null;
  if (seleccionats != null && seleccionats.length != 0) {
    for (int i = 0; i < seleccionats.length; i++) {
      redirect = eliminarUsuaris(stringToPK(seleccionats[i]), request, response);
    }
  }
  if (redirect == null) {
    redirect = getRedirectWhenDelete(request, null,null);
  }

  return redirect;
}



public java.lang.String stringToPK(String value) {
  return value;
}

  @Override
  public String[] getArgumentsMissatge(Object __usuariId, Throwable e) {
    java.lang.String usuariId = (java.lang.String)__usuariId;
    String exceptionMsg = "";
    if (e != null) {
      if (e instanceof I18NException) {
        exceptionMsg = I18NUtils.getMessage((I18NException)e);
      } else if (e instanceof I18NValidationException) {
      } else {
        exceptionMsg = e.getMessage();
      };
    };
    if (usuariId == null) {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
         getPrimaryKeyColumnsTranslated(), null, exceptionMsg };
    } else {
      return new String[] { I18NUtils.tradueix(getEntityNameCode()),
        getPrimaryKeyColumnsTranslated(),
         String.valueOf(usuariId),
 exceptionMsg };
    }
  }

  public String getEntityNameCode() {
    return "usuaris.usuaris";
  }

  public String getEntityNameCodePlural() {
    return "usuaris.usuaris.plural";
  }

  public String getPrimaryKeyColumnsTranslated() {
    return  I18NUtils.tradueix("usuaris.usuariId");
  }

  @InitBinder("usuarisFilterForm")
  public void initBinderFilterForm(WebDataBinder binder) {
    super.initBinder(binder);
  }

  @InitBinder("usuarisForm")
  public void initBinderForm(WebDataBinder binder) {
    super.initBinder(binder);

    binder.setValidator(getWebValidator());


    initDisallowedFields(binder);
  }

  public UsuarisWebValidator getWebValidator() {
    return usuarisWebValidator;
  }


  public void setWebValidator(UsuarisWebValidator __val) {
    if (__val != null) {
      this.usuarisWebValidator= __val;
    }
  }


  /**
   * Entra aqui al pitjar el boto cancel en el llistat de Usuaris
   */
  @RequestMapping(value = "/{usuariId}/cancel")
  public String cancelUsuaris(@PathVariable("usuariId") java.lang.String usuariId,
      HttpServletRequest request,HttpServletResponse response) {
     return getRedirectWhenCancel(request, usuariId);
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

  public void preValidate(HttpServletRequest request,UsuarisForm usuarisForm , BindingResult result)  throws I18NException {
  }

  public void postValidate(HttpServletRequest request,UsuarisForm usuarisForm, BindingResult result)  throws I18NException {
  }

  public void preList(HttpServletRequest request, ModelAndView mav, UsuarisFilterForm filterForm)  throws I18NException {
  }

  public void postList(HttpServletRequest request, ModelAndView mav, UsuarisFilterForm filterForm,  List<Usuaris> list) throws I18NException {
  }

  public String getRedirectWhenCreated(HttpServletRequest request, UsuarisForm usuarisForm) {
    return "redirect:" + getContextWeb() + "/list/1";
  }

  public String getRedirectWhenModified(HttpServletRequest request, UsuarisForm usuarisForm, Throwable __e) {
    if (__e == null) {
      return "redirect:" + getContextWeb() + "/list";
    } else {
      return  getTileForm();
    }
  }

  public String getRedirectWhenDelete(HttpServletRequest request, java.lang.String usuariId, Throwable __e) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getRedirectWhenCancel(HttpServletRequest request, java.lang.String usuariId) {
    return "redirect:" + getContextWeb() + "/list";
  }

  public String getTileForm() {
    return "usuarisFormWebDB";
  }

  public String getTileList() {
    return "usuarisListWebDB";
  }

  public String getSessionAttributeFilterForm() {
    return "Usuaris_FilterForm_" + this.getClass().getName();
  }



  public Where getAdditionalCondition(HttpServletRequest request) throws I18NException {
    return null;
  }


  public UsuarisJPA findByPrimaryKey(HttpServletRequest request, java.lang.String usuariId) throws I18NException {
    return (UsuarisJPA) usuarisEjb.findByPrimaryKey(usuariId);
  }


  public UsuarisJPA create(HttpServletRequest request, UsuarisJPA usuaris)
    throws I18NException, I18NValidationException {
    return (UsuarisJPA) usuarisEjb.create(usuaris);
  }


  public UsuarisJPA update(HttpServletRequest request, UsuarisJPA usuaris)
    throws I18NException, I18NValidationException {
    return (UsuarisJPA) usuarisEjb.update(usuaris);
  }


  public void delete(HttpServletRequest request, Usuaris usuaris) throws I18NException {
    usuarisEjb.delete(usuaris);
  }

} // Final de Classe

