package org.fundaciobit.queesticfent.persistence.validator;

import org.apache.log4j.Logger;

import org.fundaciobit.queesticfent.model.entity.Projectes;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.queesticfent.model.fields.ProjectesFields;
import org.fundaciobit.queesticfent.model.fields.DepartamentsFields;

import org.fundaciobit.genapp.common.validation.IValidatorResult;


/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class ProjectesValidator<I extends Projectes>
    extends org.fundaciobit.genapp.common.validation.AbstractValidator    implements ProjectesFields {

    protected final Logger log = Logger.getLogger(getClass());


  public ProjectesValidator() {
    super();    
  }
  

  /** Constructor */
  public void validate(IValidatorResult<I> __vr,I __target__, boolean __isNou__
    ,org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager
    ,org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {

    // Valors Not Null
    __vr.rejectIfEmptyOrWhitespace(__target__,NOM, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)));

    __vr.rejectIfEmptyOrWhitespace(__target__,DEPARTAMENTID, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(DEPARTAMENTID)));

    __vr.rejectIfEmptyOrWhitespace(__target__,ACTIU, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(ACTIU)));

    __vr.rejectIfEmptyOrWhitespace(__target__,FROMDATA, 
        "genapp.validation.required",
        new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(FROMDATA)));

    // Check size
    if (__vr.getFieldErrorCount(NOM) == 0) {
      java.lang.String __nom = __target__.getNom();
      if (__nom!= null && __nom.length() > 45) {
        __vr.rejectValue(NOM, "genapp.validation.sizeexceeds",
            new org.fundaciobit.genapp.common.i18n.I18NArgumentCode(get(NOM)), new org.fundaciobit.genapp.common.i18n.I18NArgumentString(String.valueOf(45)));
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