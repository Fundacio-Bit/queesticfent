package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.PersonalProjecte;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.PersonalProjecteFields;
import org.fundaciobit.queesticfent.model.fields.ProjectesFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class PersonalProjecteValidator<I extends PersonalProjecte>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements PersonalProjecteFields {

    protected final Logger log = Logger.getLogger(getClass());


  public PersonalProjecteValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IPersonalProjecteManager __personalProjecteManager
    ,org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,USUARIID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,PROJECTEID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(PROJECTEID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ORDRE, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ORDRE)));

    // Check size
    if (__vr.getFieldErrorCount(USUARIID) == 0) {
      java.lang.String __usuariid = __target__.getUsuariid();
      if (__usuariid!= null && __usuariid.length() > 50) {
        __vr.rejectValue(USUARIID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(50)));
      }
    }

    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
    }

    // Fields with References to Other tables 
    if (__vr.getFieldErrorCount(PROJECTEID) == 0) {
      java.lang.Long __projecteid = __target__.getProjecteid();
      Long __count_ = null;
      try { __count_ = __projectesManager.count(ProjectesFields.PROJECTEID.equal(__projecteid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(PROJECTEID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("projectes.projectes"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("projectes.projecteId"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__projecteid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}