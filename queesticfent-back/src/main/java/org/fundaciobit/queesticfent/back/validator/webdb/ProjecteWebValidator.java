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
import org.fundaciobit.queesticfent.persistence.validator.ProjecteValidator;

import org.fundaciobit.queesticfent.back.form.webdb.ProjecteForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Projecte;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ProjecteWebValidator extends AbstractWebValidator<ProjecteForm, Projecte>
     implements Validator, ProjecteFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected ProjecteValidator<Projecte> validator = new ProjecteValidator<Projecte>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.DepartamentService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.DepartamentService departamentEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjecteService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjecteService projecteEjb;



  public ProjecteWebValidator() {
    super();    
  }
  
  @Override
  public Projecte getBeanOfForm(ProjecteForm form) {
    return  form.getProjecte();
  }

  @Override
  public Class<ProjecteForm> getClassOfForm() {
    return ProjecteForm.class;
  }

  @Override
  public void validate(ProjecteForm __form, Projecte __bean, Errors errors) {

    WebValidationResult<ProjecteForm> wvr;
    wvr = new WebValidationResult<ProjecteForm>(errors);

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


  public void validate(ProjecteForm __form, Projecte __bean, Errors errors,
    WebValidationResult<ProjecteForm> wvr, boolean isNou) {

    BeanValidatorResult<Projecte> __vr = new BeanValidatorResult<Projecte>();
    validator.validate(__vr, __bean,
      isNou, departamentEjb, projecteEjb);

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

  public ProjecteValidator<Projecte> getValidator() {
    return validator;
  }

  public void setValidator(ProjecteValidator<Projecte> validator) {
    this.validator = validator;
  }

}