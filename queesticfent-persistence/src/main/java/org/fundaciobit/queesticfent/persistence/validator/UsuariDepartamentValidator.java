package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.UsuariDepartament;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.UsuariDepartamentFields;
import org.fundaciobit.queesticfent.model.fields.DepartamentFields;
import org.fundaciobit.queesticfent.model.fields.UsuariFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class UsuariDepartamentValidator<I extends UsuariDepartament>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements UsuariDepartamentFields {

    protected final Logger log = Logger.getLogger(getClass());


  public UsuariDepartamentValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager
    ,org.fundaciobit.queesticfent.model.dao.IUsuariManager __usuariManager
    ,org.fundaciobit.queesticfent.model.dao.IUsuariDepartamentManager __usuariDepartamentManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,USUARIID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DEPARTAMENTID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DEPARTAMENTID)));

    // Check size
    if (__vr.getFieldErrorCount(USUARIID) == 0) {
      java.lang.String __usuariid = __target__.getUsuariID();
      if (__usuariid!= null && __usuariid.length() > 20) {
        __vr.rejectValue(USUARIID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(20)));
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
    if (__vr.getFieldErrorCount(USUARIID) == 0) {
      java.lang.String __usuariid = __target__.getUsuariID();
      Long __count_ = null;
      try { __count_ = __usuariManager.count(UsuariFields.USUARIID.equal(__usuariid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(USUARIID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("usuari.usuari"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("usuari.usuariID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__usuariid)));
      }
    }

    if (__vr.getFieldErrorCount(DEPARTAMENTID) == 0) {
      java.lang.Long __departamentid = __target__.getDepartamentID();
      Long __count_ = null;
      try { __count_ = __departamentManager.count(DepartamentFields.DEPARTAMENTID.equal(__departamentid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(DEPARTAMENTID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("departament.departament"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("departament.departamentID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__departamentid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}