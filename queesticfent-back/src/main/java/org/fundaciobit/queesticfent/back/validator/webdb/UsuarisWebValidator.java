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
import org.fundaciobit.queesticfent.persistence.validator.UsuarisValidator;

import org.fundaciobit.queesticfent.back.form.webdb.UsuarisForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Usuaris;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class UsuarisWebValidator extends AbstractWebValidator<UsuarisForm, Usuaris>
     implements Validator, UsuarisFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected UsuarisValidator<Usuaris> validator = new UsuarisValidator<Usuaris>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuarisService usuarisEjb;



  public UsuarisWebValidator() {
    super();    
  }
  
  @Override
  public Usuaris getBeanOfForm(UsuarisForm form) {
    return  form.getUsuaris();
  }

  @Override
  public Class<UsuarisForm> getClassOfForm() {
    return UsuarisForm.class;
  }

  @Override
  public void validate(UsuarisForm __form, Usuaris __bean, Errors errors) {

    WebValidationResult<UsuarisForm> wvr;
    wvr = new WebValidationResult<UsuarisForm>(errors);

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


  public void validate(UsuarisForm __form, Usuaris __bean, Errors errors,
    WebValidationResult<UsuarisForm> wvr, boolean isNou) {

    BeanValidatorResult<Usuaris> __vr = new BeanValidatorResult<Usuaris>();
    validator.validate(__vr, __bean,
      isNou, usuarisEjb);

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

  public UsuarisValidator<Usuaris> getValidator() {
    return validator;
  }

  public void setValidator(UsuarisValidator<Usuaris> validator) {
    this.validator = validator;
  }

}