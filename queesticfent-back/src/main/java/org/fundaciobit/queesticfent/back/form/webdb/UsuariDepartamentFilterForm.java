
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.UsuariDepartamentFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class UsuariDepartamentFilterForm extends queesticfentBaseFilterForm implements UsuariDepartamentFields {

  private java.lang.String usuariID;

  public java.lang.String getUsuariID() {
    return this.usuariID;
  }

  public void setUsuariID(java.lang.String usuariID) {
    this.usuariID = usuariID;
  }


  private java.lang.Long departamentIDDesde;

  public java.lang.Long getDepartamentIDDesde() {
    return this.departamentIDDesde;
  }

  public void setDepartamentIDDesde(java.lang.Long departamentIDDesde) {
    this.departamentIDDesde = departamentIDDesde;
  }


  private java.lang.Long departamentIDFins;

  public java.lang.Long getDepartamentIDFins() {
    return this.departamentIDFins;
  }

  public void setDepartamentIDFins(java.lang.Long departamentIDFins) {
    this.departamentIDFins = departamentIDFins;
  }


  private java.lang.Long usuaridepartamentIDDesde;

  public java.lang.Long getUsuaridepartamentIDDesde() {
    return this.usuaridepartamentIDDesde;
  }

  public void setUsuaridepartamentIDDesde(java.lang.Long usuaridepartamentIDDesde) {
    this.usuaridepartamentIDDesde = usuaridepartamentIDDesde;
  }


  private java.lang.Long usuaridepartamentIDFins;

  public java.lang.Long getUsuaridepartamentIDFins() {
    return this.usuaridepartamentIDFins;
  }

  public void setUsuaridepartamentIDFins(java.lang.Long usuaridepartamentIDFins) {
    this.usuaridepartamentIDFins = usuaridepartamentIDFins;
  }


  public UsuariDepartamentFilterForm() {
  }
  
  public UsuariDepartamentFilterForm(UsuariDepartamentFilterForm __toClone) {
    super(__toClone);
    this.usuariID = __toClone.usuariID;
    this.departamentIDDesde = __toClone.departamentIDDesde;
    this.departamentIDFins = __toClone.departamentIDFins;
    this.usuaridepartamentIDDesde = __toClone.usuaridepartamentIDDesde;
    this.usuaridepartamentIDFins = __toClone.usuaridepartamentIDFins;
    this.mapOfUsuariForUsuariID = __toClone.mapOfUsuariForUsuariID;
    this.mapOfDepartamentForDepartamentID = __toClone.mapOfDepartamentForDepartamentID;
  }
  
  /* ========= UTILS ========== */

  @Override
  public List<Field<?>> getDefaultFilterByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }

  @Override
  public List<Field<?>> getDefaultGroupByFields() {
    return new java.util.ArrayList<Field<?>>(Arrays.asList(new Field<?>[] {  }));
  }


  protected OrderBy[] defaultOrderBy = null;


  public OrderBy[] getDefaultOrderBy() {
    return this.defaultOrderBy;
  }

  public void setDefaultOrderBy(OrderBy[] defOrderBy) {
    this.defaultOrderBy = defOrderBy;
  }

  @Override
  public String getTableModelName() {
    return _TABLE_MODEL;
  }

   // -----------------------
   // Maps de referencies.
   // -----------------------
  private Map<String, String> mapOfUsuariForUsuariID;

  public Map<String, String> getMapOfUsuariForUsuariID() {
    return this.mapOfUsuariForUsuariID;
  }

  public void setMapOfUsuariForUsuariID(Map<String, String> mapOfUsuariForUsuariID) {
    this.mapOfUsuariForUsuariID = mapOfUsuariForUsuariID;
  }



  private Map<String, String> mapOfDepartamentForDepartamentID;

  public Map<String, String> getMapOfDepartamentForDepartamentID() {
    return this.mapOfDepartamentForDepartamentID;
  }

  public void setMapOfDepartamentForDepartamentID(Map<String, String> mapOfDepartamentForDepartamentID) {
    this.mapOfDepartamentForDepartamentID = mapOfDepartamentForDepartamentID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
