package org.fundaciobit.queesticfent.back.validator.webdb;

import org.apache.log4j.Logger;

import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import java.util.List;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.web.validation.WebValidationResult;
import org.fundaciobit.queesticfent.model.fields.*;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.fundaciobit.queesticfent.persistence.validator.ModificacioQueEsticFentValidator;

import org.fundaciobit.queesticfent.back.form.webdb.ModificacioQueEsticFentForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.ModificacioQueEsticFent;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ModificacioQueEsticFentWebValidator extends AbstractWebValidator<ModificacioQueEsticFentForm, ModificacioQueEsticFent>
     implements Validator, ModificacioQueEsticFentFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected ModificacioQueEsticFentValidator<ModificacioQueEsticFent> validator = new ModificacioQueEsticFentValidator<ModificacioQueEsticFent>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccioService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccioService accioEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacioQueEsticFentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ModificacioQueEsticFentService modificacioQueEsticFentEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjecteService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjecteService projecteEjb;



  public ModificacioQueEsticFentWebValidator() {
    super();    
  }
  
  @Override
  public ModificacioQueEsticFent getBeanOfForm(ModificacioQueEsticFentForm form) {
    return  form.getModificacioQueEsticFent();
  }

  @Override
  public Class<ModificacioQueEsticFentForm> getClassOfForm() {
    return ModificacioQueEsticFentForm.class;
  }

  @Override
  public void validate(ModificacioQueEsticFentForm __form, ModificacioQueEsticFent __bean, Errors errors) {

    WebValidationResult<ModificacioQueEsticFentForm> wvr;
    wvr = new WebValidationResult<ModificacioQueEsticFentForm>(errors);

    boolean isNou;
    {
        Object objNou = errors.getFieldValue("nou");
        if (objNou == null) {
            isNou = false;
        } else { 
         Boolean nou = Boolean.parseBoolean(String.valueOf(objNou));
         isNou =  nou != null && nou.booleanValue();
        }
    }

    validate(__form, __bean , errors, wvr, isNou);
  }


  public void validate(ModificacioQueEsticFentForm __form, ModificacioQueEsticFent __bean, Errors errors,
    WebValidationResult<ModificacioQueEsticFentForm> wvr, boolean isNou) {

    BeanValidatorResult<ModificacioQueEsticFent> __vr = new BeanValidatorResult<ModificacioQueEsticFent>();
    validator.validate(__vr, __bean,
      isNou, accioEjb, modificacioQueEsticFentEjb, projecteEjb);

    if (__vr.hasErrors()) {
        List<I18NFieldError> vrErrors = __vr.getErrors();
    	   for (I18NFieldError i18nFieldError : vrErrors) {
    	       wvr.rejectValue(i18nFieldError.getField(), i18nFieldError.getTranslation().getCode(), i18nFieldError.getTranslation().getArgs());
        }
    }


  } // Final de metode

  public String get(Field<?> field) {
    return field.fullName;
  }

  public ModificacioQueEsticFentValidator<ModificacioQueEsticFent> getValidator() {
    return validator;
  }

  public void setValidator(ModificacioQueEsticFentValidator<ModificacioQueEsticFent> validator) {
    this.validator = validator;
  }

}