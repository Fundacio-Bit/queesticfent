package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.Usuaris;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.UsuarisFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class UsuarisValidator<I extends Usuaris>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements UsuarisFields {

    protected final Logger log = Logger.getLogger(getClass());


  public UsuarisValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,USUARIID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,CORREU, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CORREU)));

    // Check size
    if (__vr.getFieldErrorCount(USUARIID) == 0) {
      java.lang.String __usuariid = __target__.getUsuariID();
      if (__usuariid!= null && __usuariid.length() > 100) {
        __vr.rejectValue(USUARIID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LLINATGE1) == 0) {
      java.lang.String __llinatge1 = __target__.getLlinatge1();
      if (__llinatge1!= null && __llinatge1.length() > 100) {
        __vr.rejectValue(LLINATGE1, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LLINATGE1)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(LLINATGE2) == 0) {
      java.lang.String __llinatge2 = __target__.getLlinatge2();
      if (__llinatge2!= null && __llinatge2.length() > 100) {
        __vr.rejectValue(LLINATGE2, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(LLINATGE2)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 100) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(CORREU) == 0) {
      java.lang.String __correu = __target__.getCorreu();
      if (__correu!= null && __correu.length() > 100) {
        __vr.rejectValue(CORREU, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(CORREU)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(DESCRIPCIO) == 0) {
      java.lang.String __descripcio = __target__.getDescripcio();
      if (__descripcio!= null && __descripcio.length() > 100) {
        __vr.rejectValue(DESCRIPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DESCRIPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(EXTENSIO) == 0) {
      java.lang.String __extensio = __target__.getExtensio();
      if (__extensio!= null && __extensio.length() > 100) {
        __vr.rejectValue(EXTENSIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(EXTENSIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(TELEFONCASA) == 0) {
      java.lang.String __telefoncasa = __target__.getTelefoncasa();
      if (__telefoncasa!= null && __telefoncasa.length() > 100) {
        __vr.rejectValue(TELEFONCASA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TELEFONCASA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(TELEFONMOBIL) == 0) {
      java.lang.String __telefonmobil = __target__.getTelefonmobil();
      if (__telefonmobil!= null && __telefonmobil.length() > 100) {
        __vr.rejectValue(TELEFONMOBIL, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(TELEFONMOBIL)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__vr.getFieldErrorCount(COLOR) == 0) {
      java.lang.String __color = __target__.getColor();
      if (__color!= null && __color.length() > 100) {
        __vr.rejectValue(COLOR, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(COLOR)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(100)));
      }
    }

    if (__isNou__) { // Creació
      // ================ CREATION
      // Fitxers 
      // ====== Check Unique MULTIPLES - NOU =======

      // Check Unique - no PK
      // Check Unique - PK no AutoIncrement amb UNA SOLA PK 
      if (__vr.getFieldErrorCount(USUARIID) == 0) {
        java.lang.String __usuariid = __target__.getUsuariID();
        Long __count_ = null;
        try { __count_ = __usuarisManager.count(org.fundaciobit.genapp.common.query.Where.AND(USUARIID.equal(__usuariid))); } catch(org.fundaciobit.genapp.common.i18n.I18NException e) { e.printStackTrace(); };
        if (__count_ == null || __count_ != 0) {        
            __vr.rejectValue(USUARIID, "genapp.validation.unique",
                new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(__usuariid)),
                     new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(USUARIID)));
        }
      }

    } else {
      // ================ UPDATE

      // ====== Check Unique MULTIPLES - EDIT  =======

      // Check Unique - no PK
    }

    // Fields with References to Other tables 
  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}