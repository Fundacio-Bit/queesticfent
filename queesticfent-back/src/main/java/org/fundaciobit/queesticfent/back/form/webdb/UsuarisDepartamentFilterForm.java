
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.UsuarisDepartamentFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class UsuarisDepartamentFilterForm extends queesticfentBaseFilterForm implements UsuarisDepartamentFields {

  private java.lang.Long usuariDepartamentIDDesde;

  public java.lang.Long getUsuariDepartamentIDDesde() {
    return this.usuariDepartamentIDDesde;
  }

  public void setUsuariDepartamentIDDesde(java.lang.Long usuariDepartamentIDDesde) {
    this.usuariDepartamentIDDesde = usuariDepartamentIDDesde;
  }


  private java.lang.Long usuariDepartamentIDFins;

  public java.lang.Long getUsuariDepartamentIDFins() {
    return this.usuariDepartamentIDFins;
  }

  public void setUsuariDepartamentIDFins(java.lang.Long usuariDepartamentIDFins) {
    this.usuariDepartamentIDFins = usuariDepartamentIDFins;
  }


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


  public UsuarisDepartamentFilterForm() {
  }
  
  public UsuarisDepartamentFilterForm(UsuarisDepartamentFilterForm __toClone) {
    super(__toClone);
    this.usuariDepartamentIDDesde = __toClone.usuariDepartamentIDDesde;
    this.usuariDepartamentIDFins = __toClone.usuariDepartamentIDFins;
    this.usuariID = __toClone.usuariID;
    this.departamentIDDesde = __toClone.departamentIDDesde;
    this.departamentIDFins = __toClone.departamentIDFins;
    this.mapOfUsuarisForUsuariID = __toClone.mapOfUsuarisForUsuariID;
    this.mapOfDepartamentsForDepartamentID = __toClone.mapOfDepartamentsForDepartamentID;
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
  private Map<String, String> mapOfUsuarisForUsuariID;

  public Map<String, String> getMapOfUsuarisForUsuariID() {
    return this.mapOfUsuarisForUsuariID;
  }

  public void setMapOfUsuarisForUsuariID(Map<String, String> mapOfUsuarisForUsuariID) {
    this.mapOfUsuarisForUsuariID = mapOfUsuarisForUsuariID;
  }



  private Map<String, String> mapOfDepartamentsForDepartamentID;

  public Map<String, String> getMapOfDepartamentsForDepartamentID() {
    return this.mapOfDepartamentsForDepartamentID;
  }

  public void setMapOfDepartamentsForDepartamentID(Map<String, String> mapOfDepartamentsForDepartamentID) {
    this.mapOfDepartamentsForDepartamentID = mapOfDepartamentsForDepartamentID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
