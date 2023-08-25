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
import org.fundaciobit.queesticfent.persistence.validator.DepartamentsValidator;

import org.fundaciobit.queesticfent.back.form.webdb.DepartamentsForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Departaments;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class DepartamentsWebValidator extends AbstractWebValidator<DepartamentsForm, Departaments>
     implements Validator, DepartamentsFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected DepartamentsValidator<Departaments> validator = new DepartamentsValidator<Departaments>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.DepartamentsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.DepartamentsService departamentsEjb;



  public DepartamentsWebValidator() {
    super();    
  }
  
  @Override
  public Departaments getBeanOfForm(DepartamentsForm form) {
    return  form.getDepartaments();
  }

  @Override
  public Class<DepartamentsForm> getClassOfForm() {
    return DepartamentsForm.class;
  }

  @Override
  public void validate(DepartamentsForm __form, Departaments __bean, Errors errors) {

    WebValidationResult<DepartamentsForm> wvr;
    wvr = new WebValidationResult<DepartamentsForm>(errors);

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


  public void validate(DepartamentsForm __form, Departaments __bean, Errors errors,
    WebValidationResult<DepartamentsForm> wvr, boolean isNou) {

    BeanValidatorResult<Departaments> __vr = new BeanValidatorResult<Departaments>();
    validator.validate(__vr, __bean,
      isNou, departamentsEjb);

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

  public DepartamentsValidator<Departaments> getValidator() {
    return validator;
  }

  public void setValidator(DepartamentsValidator<Departaments> validator) {
    this.validator = validator;
  }

}