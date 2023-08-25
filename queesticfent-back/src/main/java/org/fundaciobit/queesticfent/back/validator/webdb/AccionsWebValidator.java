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
import org.fundaciobit.queesticfent.persistence.validator.AccionsValidator;

import org.fundaciobit.queesticfent.back.form.webdb.AccionsForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Accions;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class AccionsWebValidator extends AbstractWebValidator<AccionsForm, Accions>
     implements Validator, AccionsFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected AccionsValidator<Accions> validator = new AccionsValidator<Accions>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccionsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccionsService accionsEjb;



  public AccionsWebValidator() {
    super();    
  }
  
  @Override
  public Accions getBeanOfForm(AccionsForm form) {
    return  form.getAccions();
  }

  @Override
  public Class<AccionsForm> getClassOfForm() {
    return AccionsForm.class;
  }

  @Override
  public void validate(AccionsForm __form, Accions __bean, Errors errors) {

    WebValidationResult<AccionsForm> wvr;
    wvr = new WebValidationResult<AccionsForm>(errors);

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


  public void validate(AccionsForm __form, Accions __bean, Errors errors,
    WebValidationResult<AccionsForm> wvr, boolean isNou) {

    BeanValidatorResult<Accions> __vr = new BeanValidatorResult<Accions>();
    validator.validate(__vr, __bean,
      isNou, accionsEjb);

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

  public AccionsValidator<Accions> getValidator() {
    return validator;
  }

  public void setValidator(AccionsValidator<Accions> validator) {
    this.validator = validator;
  }

}