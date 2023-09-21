package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.Grupsusuari;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.GrupsusuariFields;
import org.fundaciobit.queesticfent.model.fields.GrupsFields;
import org.fundaciobit.queesticfent.model.fields.UsuarisFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class GrupsusuariValidator<I extends Grupsusuari>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements GrupsusuariFields {

    protected final Logger log = Logger.getLogger(getClass());


  public GrupsusuariValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IGrupsManager __grupsManager
    ,org.fundaciobit.queesticfent.model.dao.IGrupsusuariManager __grupsusuariManager
    ,org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,USUARIID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,GRUPID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(GRUPID)));

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
      try { __count_ = __usuarisManager.count(UsuarisFields.USUARIID.equal(__usuariid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(USUARIID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("usuaris.usuaris"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("usuaris.usuariId"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__usuariid)));
      }
    }

    if (__vr.getFieldErrorCount(GRUPID) == 0) {
      java.lang.Long __grupid = __target__.getGrupID();
      Long __count_ = null;
      try { __count_ = __grupsManager.count(GrupsFields.GRUPID.equal(__grupid)); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
      if (__count_ == null || __count_ == 0) {        
        __vr.rejectValue(GRUPID, "error.notfound",
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("grups.grups"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentCode("grups.grupID"),
         new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__grupid)));
      }
    }

  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}