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
import org.fundaciobit.queesticfent.persistence.validator.EntradaValidator;

import org.fundaciobit.queesticfent.back.form.webdb.EntradaForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Entrada;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class EntradaWebValidator extends AbstractWebValidator<EntradaForm, Entrada>
     implements Validator, EntradaFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected EntradaValidator<Entrada> validator = new EntradaValidator<Entrada>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.AccioService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.AccioService accioEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.EntradaService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.EntradaService entradaEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.ProjecteService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.ProjecteService projecteEjb;



  public EntradaWebValidator() {
    super();    
  }
  
  @Override
  public Entrada getBeanOfForm(EntradaForm form) {
    return  form.getEntrada();
  }

  @Override
  public Class<EntradaForm> getClassOfForm() {
    return EntradaForm.class;
  }

  @Override
  public void validate(EntradaForm __form, Entrada __bean, Errors errors) {

    WebValidationResult<EntradaForm> wvr;
    wvr = new WebValidationResult<EntradaForm>(errors);

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


  public void validate(EntradaForm __form, Entrada __bean, Errors errors,
    WebValidationResult<EntradaForm> wvr, boolean isNou) {

    BeanValidatorResult<Entrada> __vr = new BeanValidatorResult<Entrada>();
    validator.validate(__vr, __bean,
      isNou, accioEjb, entradaEjb, projecteEjb);

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

  public EntradaValidator<Entrada> getValidator() {
    return validator;
  }

  public void setValidator(EntradaValidator<Entrada> validator) {
    this.validator = validator;
  }

}