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
import org.fundaciobit.queesticfent.persistence.validator.PersonalProjecteValidator;

import org.fundaciobit.queesticfent.back.form.webdb.PersonalProjecteForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.PersonalProjecte;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class PersonalProjecteWebValidator extends AbstractWebValidator<PersonalProjecteForm, PersonalProjecte>
     implements Validator, PersonalProjecteFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected PersonalProjecteValidator<PersonalProjecte> validator = new PersonalProjecteValidator<PersonalProjecte>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.PersonalProjecteService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.PersonalProjecteService personalProjecteEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjectesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjectesService projectesEjb;



  public PersonalProjecteWebValidator() {
    super();    
  }
  
  @Override
  public PersonalProjecte getBeanOfForm(PersonalProjecteForm form) {
    return  form.getPersonalProjecte();
  }

  @Override
  public Class<PersonalProjecteForm> getClassOfForm() {
    return PersonalProjecteForm.class;
  }

  @Override
  public void validate(PersonalProjecteForm __form, PersonalProjecte __bean, Errors errors) {

    WebValidationResult<PersonalProjecteForm> wvr;
    wvr = new WebValidationResult<PersonalProjecteForm>(errors);

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


  public void validate(PersonalProjecteForm __form, PersonalProjecte __bean, Errors errors,
    WebValidationResult<PersonalProjecteForm> wvr, boolean isNou) {

    BeanValidatorResult<PersonalProjecte> __vr = new BeanValidatorResult<PersonalProjecte>();
    validator.validate(__vr, __bean,
      isNou, personalProjecteEjb, projectesEjb);

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

  public PersonalProjecteValidator<PersonalProjecte> getValidator() {
    return validator;
  }

  public void setValidator(PersonalProjecteValidator<PersonalProjecte> validator) {
    this.validator = validator;
  }

}