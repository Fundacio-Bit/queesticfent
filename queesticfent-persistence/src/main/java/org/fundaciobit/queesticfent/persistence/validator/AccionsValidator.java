package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.Accions;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.AccionsFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class AccionsValidator<I extends Accions>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements AccionsFields {

    protected final Logger log = Logger.getLogger(getClass());


  public AccionsValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,NOMLLEGENDA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOMLLEGENDA)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 45) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(45)));
      }
    }

    if (__vr.getFieldErrorCount(NOMLLEGENDA) == 0) {
      java.lang.String __nomllegenda = __target__.getNomLlegenda();
      if (__nomllegenda!= null && __nomllegenda.length() > 45) {
        __vr.rejectValue(NOMLLEGENDA, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOMLLEGENDA)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(45)));
      }
    }

    if (__vr.getFieldErrorCount(COLOR) == 0) {
      java.lang.String __color = __target__.getColor();
      if (__color!= null && __color.length() > 2147483647) {
        __vr.rejectValue(COLOR, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(COLOR)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(2147483647)));
      }
    }

    if (__vr.getFieldErrorCount(DESCRIPCIO) == 0) {
      java.lang.String __descripcio = __target__.getDescripcio();
      if (__descripcio!= null && __descripcio.length() > 500) {
        __vr.rejectValue(DESCRIPCIO, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DESCRIPCIO)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(500)));
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