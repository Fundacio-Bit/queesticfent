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
import org.fundaciobit.queesticfent.persistence.validator.FestiuValidator;

import org.fundaciobit.queesticfent.back.form.webdb.FestiuForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Festiu;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class FestiuWebValidator extends AbstractWebValidator<FestiuForm, Festiu>
     implements Validator, FestiuFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected FestiuValidator<Festiu> validator = new FestiuValidator<Festiu>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.FestiuService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.FestiuService festiuEjb;



  public FestiuWebValidator() {
    super();    
  }
  
  @Override
  public Festiu getBeanOfForm(FestiuForm form) {
    return  form.getFestiu();
  }

  @Override
  public Class<FestiuForm> getClassOfForm() {
    return FestiuForm.class;
  }

  @Override
  public void validate(FestiuForm __form, Festiu __bean, Errors errors) {

    WebValidationResult<FestiuForm> wvr;
    wvr = new WebValidationResult<FestiuForm>(errors);

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


  public void validate(FestiuForm __form, Festiu __bean, Errors errors,
    WebValidationResult<FestiuForm> wvr, boolean isNou) {

    BeanValidatorResult<Festiu> __vr = new BeanValidatorResult<Festiu>();
    validator.validate(__vr, __bean,
      isNou, festiuEjb);

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

  public FestiuValidator<Festiu> getValidator() {
    return validator;
  }

  public void setValidator(FestiuValidator<Festiu> validator) {
    this.validator = validator;
  }

}