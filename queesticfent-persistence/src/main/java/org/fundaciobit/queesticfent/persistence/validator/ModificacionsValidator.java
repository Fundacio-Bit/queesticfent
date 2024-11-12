package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.Modificacions;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.ModificacionsFields;
import org.fundaciobit.queesticfent.model.fields.AccionsFields;
import org.fundaciobit.queesticfent.model.fields.EntradesFields;
import org.fundaciobit.queesticfent.model.fields.ProjectesFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class ModificacionsValidator<I extends Modificacions>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements ModificacionsFields {

    protected final Logger log = Logger.getLogger(getClass());


  public ModificacionsValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager
    ,org.fundaciobit.queesticfent.model.dao.IEntradesManager __entradesManager
    ,org.fundaciobit.queesticfent.model.dao.IModificacionsManager __modificacionsManager
    ,org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,ENTRADAID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ENTRADAID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ACCIOID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ACCIOID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,OLDUSUARIID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(OLDUSUARIID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,OLDDATA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(OLDDATA)));

    __vr.rejectIfEmptyOrWhitespace(__target__,NEWUSUARIID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NEWUSUARIID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,NEWDATA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NEWDATA)));

    // Check size
    if (__vr.getFieldErrorCount(OLDUSUARIID) == 0) {
      java.lang.String __oldusuariid = __target__.getOldusuariID();
      if (__oldusuariid!= null && __oldusuariid.length() > 45) {
        __vr.rejectValue(OLDUSUARIID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(OLDUSUARIID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(45)));
      }
    }

    if (__vr.getFieldErrorCount(OLDDADA1) == 0) {
      java.lang.String __olddada1 = __target__.getOlddada1();
      if (__olddada1!= null && __olddada1.length() > 500) {
        __vr.rejectValue(OLDDADA1, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(OLDDADA1)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(500)));
      }
    }

    if (__vr.getFieldErrorCount(OLDDADA2) == 0) {
      java.lang.String __olddada2 = __target__.getOlddada2();
      if (__olddada2!= null && __olddada2.length() > 500) {
        __vr.rejectValue(OLDDADA2, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(OLDDADA2)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(500)));
      }
    }

    if (__vr.getFieldErrorCount(NEWUSUARIID) == 0) {
      java.lang.String __newusuariid = __target__.getNewusuariID();
      if (__newusuariid!= null && __newusuariid.length() > 45) {
        __vr.rejectValue(NEWUSUARIID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NEWUSUARIID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(45)));
      }
    }

    if (__vr.getFieldErrorCount(NEWDADA1) == 0) {
      java.lang.String __newdada1 = __target__.getNewdada1();
      if (__newdada1!= null && __newdada1.length() > 500) {
        __vr.rejectValue(NEWDADA1, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NEWDADA1)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(500)));
      }
    }

    if (__vr.getFieldErrorCount(NEWDADA2) == 0) {
      java.lang.String __newdada2 = __target__.getNewdada2();
      if (__newdada2!= null && __newdada2.length() > 500) {
        __vr.rejectValue(NEWDADA2, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NEWDADA2)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(500)));
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
    if (__vr.getFieldErrorCount(ENTRADAID) == 0) {
      java.lang.Long __entradaid = __target__.getEntradaid();
      Long __count_ = null;
      try { __count_ = __entradesManager.count(EntradesFields.ENTRADAID.equal(__entradaid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(ENTRADAID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("entrades.entrades"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("entrades.entradaID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__entradaid)));
      }
    }

    if (__vr.getFieldErrorCount(ACCIOID) == 0) {
      java.lang.Long __accioid = __target__.getAccioid();
      Long __count_ = null;
      try { __count_ = __accionsManager.count(AccionsFields.ACCIOID.equal(__accioid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(ACCIOID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("accions.accions"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("accions.accioID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__accioid)));
      }
    }

    if (__vr.getFieldErrorCount(OLDPROJECTEID) == 0) {
      java.lang.Long __oldprojecteid = __target__.getOldprojecteID();
      if (__oldprojecteid != null ) {
        Long __count_ = null;
        try { __count_ = __projectesManager.count(ProjectesFields.PROJECTEID.equal(__oldprojecteid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(OLDPROJECTEID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("projectes.projectes"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("projectes.projecteID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__oldprojecteid)));
        }
      }
    }

    if (__vr.getFieldErrorCount(NEWPROJECTEID) == 0) {
      java.lang.Long __newprojecteid = __target__.getNewprojecteID();
      if (__newprojecteid != null ) {
        Long __count_ = null;
        try { __count_ = __projectesManager.count(ProjectesFields.PROJECTEID.equal(__newprojecteid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ == 0) {        
          __vr.rejectValue(NEWPROJECTEID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("projectes.projectes"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("projectes.projecteID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__newprojecteid)));
        }
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}