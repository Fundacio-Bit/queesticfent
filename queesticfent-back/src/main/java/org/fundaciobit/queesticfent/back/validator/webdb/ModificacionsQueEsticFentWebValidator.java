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
import org.fundaciobit.queesticfent.persistence.validator.ModificacionsQueEsticFentValidator;

import org.fundaciobit.queesticfent.back.form.webdb.ModificacionsQueEsticFentForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ModificacionsQueEsticFentWebValidator extends AbstractWebValidator<ModificacionsQueEsticFentForm, ModificacionsQueEsticFent>
     implements Validator, ModificacionsQueEsticFentFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected ModificacionsQueEsticFentValidator<ModificacionsQueEsticFent> validator = new ModificacionsQueEsticFentValidator<ModificacionsQueEsticFent>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccionsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccionsService accionsEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService modificacionsQueEsticFentEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjectesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjectesService projectesEjb;



  public ModificacionsQueEsticFentWebValidator() {
    super();    
  }
  
  @Override
  public ModificacionsQueEsticFent getBeanOfForm(ModificacionsQueEsticFentForm form) {
    return  form.getModificacionsQueEsticFent();
  }

  @Override
  public Class<ModificacionsQueEsticFentForm> getClassOfForm() {
    return ModificacionsQueEsticFentForm.class;
  }

  @Override
  public void validate(ModificacionsQueEsticFentForm __form, ModificacionsQueEsticFent __bean, Errors errors) {

    WebValidationResult<ModificacionsQueEsticFentForm> wvr;
    wvr = new WebValidationResult<ModificacionsQueEsticFentForm>(errors);

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


  public void validate(ModificacionsQueEsticFentForm __form, ModificacionsQueEsticFent __bean, Errors errors,
    WebValidationResult<ModificacionsQueEsticFentForm> wvr, boolean isNou) {

    BeanValidatorResult<ModificacionsQueEsticFent> __vr = new BeanValidatorResult<ModificacionsQueEsticFent>();
    validator.validate(__vr, __bean,
      isNou, accionsEjb, modificacionsQueEsticFentEjb, projectesEjb);

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

  public ModificacionsQueEsticFentValidator<ModificacionsQueEsticFent> getValidator() {
    return validator;
  }

  public void setValidator(ModificacionsQueEsticFentValidator<ModificacionsQueEsticFent> validator) {
    this.validator = validator;
  }

}