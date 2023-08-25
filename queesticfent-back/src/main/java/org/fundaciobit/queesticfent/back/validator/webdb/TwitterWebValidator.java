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
import org.fundaciobit.queesticfent.persistence.validator.TwitterValidator;

import org.fundaciobit.queesticfent.back.form.webdb.TwitterForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Twitter;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class TwitterWebValidator extends AbstractWebValidator<TwitterForm, Twitter>
     implements Validator, TwitterFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected TwitterValidator<Twitter> validator = new TwitterValidator<Twitter>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.TwitterService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.TwitterService twitterEjb;



  public TwitterWebValidator() {
    super();    
  }
  
  @Override
  public Twitter getBeanOfForm(TwitterForm form) {
    return  form.getTwitter();
  }

  @Override
  public Class<TwitterForm> getClassOfForm() {
    return TwitterForm.class;
  }

  @Override
  public void validate(TwitterForm __form, Twitter __bean, Errors errors) {

    WebValidationResult<TwitterForm> wvr;
    wvr = new WebValidationResult<TwitterForm>(errors);

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


  public void validate(TwitterForm __form, Twitter __bean, Errors errors,
    WebValidationResult<TwitterForm> wvr, boolean isNou) {

    BeanValidatorResult<Twitter> __vr = new BeanValidatorResult<Twitter>();
    validator.validate(__vr, __bean,
      isNou, twitterEjb);

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

  public TwitterValidator<Twitter> getValidator() {
    return validator;
  }

  public void setValidator(TwitterValidator<Twitter> validator) {
    this.validator = validator;
  }

}