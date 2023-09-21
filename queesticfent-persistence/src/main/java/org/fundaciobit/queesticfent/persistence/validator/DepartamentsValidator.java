package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.Departaments;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.DepartamentsFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class DepartamentsValidator<I extends Departaments>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements DepartamentsFields {

    protected final Logger log = Logger.getLogger(getClass());


  public DepartamentsValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,COORDINADORID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(COORDINADORID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,NOMLDAP, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOMLDAP)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DESCRIPCIO, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DESCRIPCIO)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 300) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(300)));
      }
    }

    if (__vr.getFieldErrorCount(COORDINADORID) == 0) {
      java.lang.String __coordinadorid = __target__.getCoordinadorId();
      if (__coordinadorid!= null && __coordinadorid.length() > 200) {
        __vr.rejectValue(COORDINADORID, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(COORDINADORID)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(200)));
      }
    }

    if (__vr.getFieldErrorCount(NOMLDAP) == 0) {
      java.lang.String __nomldap = __target__.getNomldap();
      if (__nomldap!= null && __nomldap.length() > 200) {
        __vr.rejectValue(NOMLDAP, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOMLDAP)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(200)));
      }
    }

    if (__vr.getFieldErrorCount(DESCRIPCIO) == 0) {
      java.lang.String __descripcio = __target__.getDescripcio();
      if (__descripcio!= null && __descripcio.length() > 3000) {
        __vr.rejectValue(DESCRIPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DESCRIPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(3000)));
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
  } // Final de mètode
  public String get(Field<?> field) {
    return field.fullName;
  }
  
}