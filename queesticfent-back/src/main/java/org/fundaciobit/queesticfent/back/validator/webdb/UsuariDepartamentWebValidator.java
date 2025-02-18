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
import org.fundaciobit.queesticfent.persistence.validator.UsuariDepartamentValidator;

import org.fundaciobit.queesticfent.back.form.webdb.UsuariDepartamentForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.UsuariDepartament;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class UsuariDepartamentWebValidator extends AbstractWebValidator<UsuariDepartamentForm, UsuariDepartament>
     implements Validator, UsuariDepartamentFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected UsuariDepartamentValidator<UsuariDepartament> validator = new UsuariDepartamentValidator<UsuariDepartament>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.DepartamentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.DepartamentService departamentEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuariService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuariService usuariEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuariDepartamentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuariDepartamentService usuariDepartamentEjb;



  public UsuariDepartamentWebValidator() {
    super();    
  }
  
  @Override
  public UsuariDepartament getBeanOfForm(UsuariDepartamentForm form) {
    return  form.getUsuariDepartament();
  }

  @Override
  public Class<UsuariDepartamentForm> getClassOfForm() {
    return UsuariDepartamentForm.class;
  }

  @Override
  public void validate(UsuariDepartamentForm __form, UsuariDepartament __bean, Errors errors) {

    WebValidationResult<UsuariDepartamentForm> wvr;
    wvr = new WebValidationResult<UsuariDepartamentForm>(errors);

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


  public void validate(UsuariDepartamentForm __form, UsuariDepartament __bean, Errors errors,
    WebValidationResult<UsuariDepartamentForm> wvr, boolean isNou) {

    BeanValidatorResult<UsuariDepartament> __vr = new BeanValidatorResult<UsuariDepartament>();
    validator.validate(__vr, __bean,
      isNou, departamentEjb, usuariEjb, usuariDepartamentEjb);

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

  public UsuariDepartamentValidator<UsuariDepartament> getValidator() {
    return validator;
  }

  public void setValidator(UsuariDepartamentValidator<UsuariDepartament> validator) {
    this.validator = validator;
  }

}