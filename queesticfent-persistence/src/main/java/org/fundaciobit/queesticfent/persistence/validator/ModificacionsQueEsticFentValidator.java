package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.ModificacionsQueEsticFentFields;
import org.fundaciobit.queesticfent.model.fields.AccionsFields;
import org.fundaciobit.queesticfent.model.fields.ProjectesFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class ModificacionsQueEsticFentValidator<I extends ModificacionsQueEsticFent>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements ModificacionsQueEsticFentFields {

    protected final Logger log = Logger.getLogger(getClass());


  public ModificacionsQueEsticFentValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager
    ,org.fundaciobit.queesticfent.model.dao.IModificacionsQueEsticFentManager __modificacionsQueEsticFentManager
    ,org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,ACCIOID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ACCIOID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,USUARIID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DATA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DATA)));

    // Check size
    if (__vr.getFieldErrorCount(USUARIID) == 0) {
      java.lang.String __usuariid = __target__.getUsuariID();
      if (__usuariid!= null && __usuariid.length() > 45) {
        __vr.rejectValue(USUARIID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(45)));
      }
    }

    if (__vr.getFieldErrorCount(DADA1) == 0) {
      java.lang.String __dada1 = __target__.getDada1();
      if (__dada1!= null && __dada1.length() > 500) {
        __vr.rejectValue(DADA1, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DADA1)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(500)));
      }
    }

    if (__vr.getFieldErrorCount(DADA2) == 0) {
      java.lang.String __dada2 = __target__.getDada2();
      if (__dada2!= null && __dada2.length() > 500) {
        __vr.rejectValue(DADA2, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DADA2)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(500)));
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
    if (__vr.getFieldErrorCount(ACCIOID) == 0) {
      java.lang.Long __accioid = __target__.getAccioID();
      Long __count_ = null;
      try { __count_ = __accionsManager.count(AccionsFields.ACCIOID.equal(__accioid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(ACCIOID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("accions.accions"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("accions.accioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__accioid)));
      }
    }

    if (__vr.getFieldErrorCount(PROJECTEID) == 0) {
      java.lang.Long __projecteid = __target__.getProjecteID();
      if (__projecteid != null ) {
        Long __count_ = null;
        try { __count_ = __projectesManager.count(ProjectesFields.PROJECTEID.equal(__projecteid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(PROJECTEID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("projectes.projectes"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("projectes.projecteID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__projecteid)));
        }
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}