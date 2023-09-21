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
import org.fundaciobit.queesticfent.persistence.validator.UsuarisDepartamentValidator;

import org.fundaciobit.queesticfent.back.form.webdb.UsuarisDepartamentForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class UsuarisDepartamentWebValidator extends AbstractWebValidator<UsuarisDepartamentForm, UsuarisDepartament>
     implements Validator, UsuarisDepartamentFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected UsuarisDepartamentValidator<UsuarisDepartament> validator = new UsuarisDepartamentValidator<UsuarisDepartament>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.DepartamentsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.DepartamentsService departamentsEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuarisService usuarisEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService usuarisDepartamentEjb;



  public UsuarisDepartamentWebValidator() {
    super();    
  }
  
  @Override
  public UsuarisDepartament getBeanOfForm(UsuarisDepartamentForm form) {
    return  form.getUsuarisDepartament();
  }

  @Override
  public Class<UsuarisDepartamentForm> getClassOfForm() {
    return UsuarisDepartamentForm.class;
  }

  @Override
  public void validate(UsuarisDepartamentForm __form, UsuarisDepartament __bean, Errors errors) {

    WebValidationResult<UsuarisDepartamentForm> wvr;
    wvr = new WebValidationResult<UsuarisDepartamentForm>(errors);

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


  public void validate(UsuarisDepartamentForm __form, UsuarisDepartament __bean, Errors errors,
    WebValidationResult<UsuarisDepartamentForm> wvr, boolean isNou) {

    BeanValidatorResult<UsuarisDepartament> __vr = new BeanValidatorResult<UsuarisDepartament>();
    validator.validate(__vr, __bean,
      isNou, departamentsEjb, usuarisEjb, usuarisDepartamentEjb);

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

  public UsuarisDepartamentValidator<UsuarisDepartament> getValidator() {
    return validator;
  }

  public void setValidator(UsuarisDepartamentValidator<UsuarisDepartament> validator) {
    this.validator = validator;
  }

}