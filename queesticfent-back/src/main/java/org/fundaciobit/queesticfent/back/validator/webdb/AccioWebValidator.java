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
import org.fundaciobit.queesticfent.persistence.validator.AccioValidator;

import org.fundaciobit.queesticfent.back.form.webdb.AccioForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Accio;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class AccioWebValidator extends AbstractWebValidator<AccioForm, Accio>
     implements Validator, AccioFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected AccioValidator<Accio> validator = new AccioValidator<Accio>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccioService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccioService accioEjb;



  public AccioWebValidator() {
    super();    
  }
  
  @Override
  public Accio getBeanOfForm(AccioForm form) {
    return  form.getAccio();
  }

  @Override
  public Class<AccioForm> getClassOfForm() {
    return AccioForm.class;
  }

  @Override
  public void validate(AccioForm __form, Accio __bean, Errors errors) {

    WebValidationResult<AccioForm> wvr;
    wvr = new WebValidationResult<AccioForm>(errors);

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


  public void validate(AccioForm __form, Accio __bean, Errors errors,
    WebValidationResult<AccioForm> wvr, boolean isNou) {

    BeanValidatorResult<Accio> __vr = new BeanValidatorResult<Accio>();
    validator.validate(__vr, __bean,
      isNou, accioEjb);

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

  public AccioValidator<Accio> getValidator() {
    return validator;
  }

  public void setValidator(AccioValidator<Accio> validator) {
    this.validator = validator;
  }

}