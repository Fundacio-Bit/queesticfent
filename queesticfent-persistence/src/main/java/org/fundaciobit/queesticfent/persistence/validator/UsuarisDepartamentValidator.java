package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.UsuarisDepartamentFields;
import org.fundaciobit.queesticfent.model.fields.DepartamentsFields;
import org.fundaciobit.queesticfent.model.fields.UsuarisFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class UsuarisDepartamentValidator<I extends UsuarisDepartament>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements UsuarisDepartamentFields {

    protected final Logger log = Logger.getLogger(getClass());


  public UsuarisDepartamentValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager
    ,org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager
    ,org.fundaciobit.queesticfent.model.dao.IUsuarisDepartamentManager __usuarisDepartamentManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,USUARIID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DEPARTAMENTID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DEPARTAMENTID)));

    // Check size
    if (__vr.getFieldErrorCount(USUARIID) == 0) {
      java.lang.String __usuariid = __target__.getUsuariId();
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
      java.lang.String __usuariid = __target__.getUsuariId();
      Long __count_ = null;
      try { __count_ = __usuarisManager.count(UsuarisFields.USUARIID.equal(__usuariid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(USUARIID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("usuaris.usuaris"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("usuaris.usuariId"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__usuariid)));
      }
    }

    if (__vr.getFieldErrorCount(DEPARTAMENTID) == 0) {
      java.lang.Long __departamentid = __target__.getDepartamentid();
      Long __count_ = null;
      try { __count_ = __departamentsManager.count(DepartamentsFields.DEPARTAMENTID.equal(__departamentid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(DEPARTAMENTID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("departaments.departaments"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("departaments.departamentID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__departamentid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}