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
import org.fundaciobit.queesticfent.persistence.validator.EntradesValidator;

import org.fundaciobit.queesticfent.back.form.webdb.EntradesForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Entrades;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class EntradesWebValidator extends AbstractWebValidator<EntradesForm, Entrades>
     implements Validator, EntradesFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected EntradesValidator<Entrades> validator = new EntradesValidator<Entrades>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccionsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccionsService accionsEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.EntradesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.EntradesService entradesEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjectesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjectesService projectesEjb;



  public EntradesWebValidator() {
    super();    
  }
  
  @Override
  public Entrades getBeanOfForm(EntradesForm form) {
    return  form.getEntrades();
  }

  @Override
  public Class<EntradesForm> getClassOfForm() {
    return EntradesForm.class;
  }

  @Override
  public void validate(EntradesForm __form, Entrades __bean, Errors errors) {

    WebValidationResult<EntradesForm> wvr;
    wvr = new WebValidationResult<EntradesForm>(errors);

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


  public void validate(EntradesForm __form, Entrades __bean, Errors errors,
    WebValidationResult<EntradesForm> wvr, boolean isNou) {

    BeanValidatorResult<Entrades> __vr = new BeanValidatorResult<Entrades>();
    validator.validate(__vr, __bean,
      isNou, accionsEjb, entradesEjb, projectesEjb);

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

  public EntradesValidator<Entrades> getValidator() {
    return validator;
  }

  public void setValidator(EntradesValidator<Entrades> validator) {
    this.validator = validator;
  }

}