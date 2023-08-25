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
import org.fundaciobit.queesticfent.persistence.validator.GrupsValidator;

import org.fundaciobit.queesticfent.back.form.webdb.GrupsForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Grups;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class GrupsWebValidator extends AbstractWebValidator<GrupsForm, Grups>
     implements Validator, GrupsFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected GrupsValidator<Grups> validator = new GrupsValidator<Grups>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.GrupsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.GrupsService grupsEjb;



  public GrupsWebValidator() {
    super();    
  }
  
  @Override
  public Grups getBeanOfForm(GrupsForm form) {
    return  form.getGrups();
  }

  @Override
  public Class<GrupsForm> getClassOfForm() {
    return GrupsForm.class;
  }

  @Override
  public void validate(GrupsForm __form, Grups __bean, Errors errors) {

    WebValidationResult<GrupsForm> wvr;
    wvr = new WebValidationResult<GrupsForm>(errors);

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


  public void validate(GrupsForm __form, Grups __bean, Errors errors,
    WebValidationResult<GrupsForm> wvr, boolean isNou) {

    BeanValidatorResult<Grups> __vr = new BeanValidatorResult<Grups>();
    validator.validate(__vr, __bean,
      isNou, grupsEjb);

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

  public GrupsValidator<Grups> getValidator() {
    return validator;
  }

  public void setValidator(GrupsValidator<Grups> validator) {
    this.validator = validator;
  }

}