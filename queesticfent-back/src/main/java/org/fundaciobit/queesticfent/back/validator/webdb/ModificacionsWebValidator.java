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
import org.fundaciobit.queesticfent.persistence.validator.ModificacionsValidator;

import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Modificacions;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ModificacionsWebValidator extends AbstractWebValidator<ModificacionsForm, Modificacions>
     implements Validator, ModificacionsFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected ModificacionsValidator<Modificacions> validator = new ModificacionsValidator<Modificacions>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccionsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccionsService accionsEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.EntradesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.EntradesService entradesEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacionsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ModificacionsService modificacionsEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjectesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjectesService projectesEjb;



  public ModificacionsWebValidator() {
    super();    
  }
  
  @Override
  public Modificacions getBeanOfForm(ModificacionsForm form) {
    return  form.getModificacions();
  }

  @Override
  public Class<ModificacionsForm> getClassOfForm() {
    return ModificacionsForm.class;
  }

  @Override
  public void validate(ModificacionsForm __form, Modificacions __bean, Errors errors) {

    WebValidationResult<ModificacionsForm> wvr;
    wvr = new WebValidationResult<ModificacionsForm>(errors);

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


  public void validate(ModificacionsForm __form, Modificacions __bean, Errors errors,
    WebValidationResult<ModificacionsForm> wvr, boolean isNou) {

    BeanValidatorResult<Modificacions> __vr = new BeanValidatorResult<Modificacions>();
    validator.validate(__vr, __bean,
      isNou, accionsEjb, entradesEjb, modificacionsEjb, projectesEjb);

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

  public ModificacionsValidator<Modificacions> getValidator() {
    return validator;
  }

  public void setValidator(ModificacionsValidator<Modificacions> validator) {
    this.validator = validator;
  }

}