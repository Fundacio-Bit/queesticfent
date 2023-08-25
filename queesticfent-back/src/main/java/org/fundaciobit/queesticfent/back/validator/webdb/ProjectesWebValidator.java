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
import org.fundaciobit.queesticfent.persistence.validator.ProjectesValidator;

import org.fundaciobit.queesticfent.back.form.webdb.ProjectesForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Projectes;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class ProjectesWebValidator extends AbstractWebValidator<ProjectesForm, Projectes>
     implements Validator, ProjectesFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected ProjectesValidator<Projectes> validator = new ProjectesValidator<Projectes>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.DepartamentsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.DepartamentsService departamentsEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjectesService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjectesService projectesEjb;



  public ProjectesWebValidator() {
    super();    
  }
  
  @Override
  public Projectes getBeanOfForm(ProjectesForm form) {
    return  form.getProjectes();
  }

  @Override
  public Class<ProjectesForm> getClassOfForm() {
    return ProjectesForm.class;
  }

  @Override
  public void validate(ProjectesForm __form, Projectes __bean, Errors errors) {

    WebValidationResult<ProjectesForm> wvr;
    wvr = new WebValidationResult<ProjectesForm>(errors);

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


  public void validate(ProjectesForm __form, Projectes __bean, Errors errors,
    WebValidationResult<ProjectesForm> wvr, boolean isNou) {

    BeanValidatorResult<Projectes> __vr = new BeanValidatorResult<Projectes>();
    validator.validate(__vr, __bean,
      isNou, departamentsEjb, projectesEjb);

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

  public ProjectesValidator<Projectes> getValidator() {
    return validator;
  }

  public void setValidator(ProjectesValidator<Projectes> validator) {
    this.validator = validator;
  }

}