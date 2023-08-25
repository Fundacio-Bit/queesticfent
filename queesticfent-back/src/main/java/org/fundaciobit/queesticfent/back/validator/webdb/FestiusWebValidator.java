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
import org.fundaciobit.queesticfent.persistence.validator.FestiusValidator;

import org.fundaciobit.queesticfent.back.form.webdb.FestiusForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Festius;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class FestiusWebValidator extends AbstractWebValidator<FestiusForm, Festius>
     implements Validator, FestiusFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected FestiusValidator<Festius> validator = new FestiusValidator<Festius>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.FestiusService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.FestiusService festiusEjb;



  public FestiusWebValidator() {
    super();    
  }
  
  @Override
  public Festius getBeanOfForm(FestiusForm form) {
    return  form.getFestius();
  }

  @Override
  public Class<FestiusForm> getClassOfForm() {
    return FestiusForm.class;
  }

  @Override
  public void validate(FestiusForm __form, Festius __bean, Errors errors) {

    WebValidationResult<FestiusForm> wvr;
    wvr = new WebValidationResult<FestiusForm>(errors);

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


  public void validate(FestiusForm __form, Festius __bean, Errors errors,
    WebValidationResult<FestiusForm> wvr, boolean isNou) {

    BeanValidatorResult<Festius> __vr = new BeanValidatorResult<Festius>();
    validator.validate(__vr, __bean,
      isNou, festiusEjb);

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

  public FestiusValidator<Festius> getValidator() {
    return validator;
  }

  public void setValidator(FestiusValidator<Festius> validator) {
    this.validator = validator;
  }

}