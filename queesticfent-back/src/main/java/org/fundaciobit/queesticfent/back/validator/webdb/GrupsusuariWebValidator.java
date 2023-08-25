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
import org.fundaciobit.queesticfent.persistence.validator.GrupsusuariValidator;

import org.fundaciobit.queesticfent.back.form.webdb.GrupsusuariForm;
import org.fundaciobit.genapp.common.web.validation.AbstractWebValidator;
import org.fundaciobit.queesticfent.model.entity.Grupsusuari;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author anadal
 */
@Component
public class GrupsusuariWebValidator extends AbstractWebValidator<GrupsusuariForm, Grupsusuari>
     implements Validator, GrupsusuariFields {

     protected final Logger log = Logger.getLogger(getClass());

  protected GrupsusuariValidator<Grupsusuari> validator = new GrupsusuariValidator<Grupsusuari>();

  // EJB's
  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.GrupsService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.GrupsService grupsEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.GrupsusuariService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.GrupsusuariService grupsusuariEjb;

  @javax.ejb.EJB(mappedName = org.fundaciobit.queesticfent.ejb.UsuarisService.JNDI_NAME)
  protected org.fundaciobit.queesticfent.ejb.UsuarisService usuarisEjb;



  public GrupsusuariWebValidator() {
    super();    
  }
  
  @Override
  public Grupsusuari getBeanOfForm(GrupsusuariForm form) {
    return  form.getGrupsusuari();
  }

  @Override
  public Class<GrupsusuariForm> getClassOfForm() {
    return GrupsusuariForm.class;
  }

  @Override
  public void validate(GrupsusuariForm __form, Grupsusuari __bean, Errors errors) {

    WebValidationResult<GrupsusuariForm> wvr;
    wvr = new WebValidationResult<GrupsusuariForm>(errors);

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


  public void validate(GrupsusuariForm __form, Grupsusuari __bean, Errors errors,
    WebValidationResult<GrupsusuariForm> wvr, boolean isNou) {

    BeanValidatorResult<Grupsusuari> __vr = new BeanValidatorResult<Grupsusuari>();
    validator.validate(__vr, __bean,
      isNou, grupsEjb, grupsusuariEjb, usuarisEjb);

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

  public GrupsusuariValidator<Grupsusuari> getValidator() {
    return validator;
  }

  public void setValidator(GrupsusuariValidator<Grupsusuari> validator) {
    this.validator = validator;
  }

}