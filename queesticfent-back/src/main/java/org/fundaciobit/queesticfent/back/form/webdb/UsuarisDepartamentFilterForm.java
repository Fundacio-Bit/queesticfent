
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

  private java.lang.String usuariId;

  public java.lang.String getUsuariId() {
    return this.usuariId;
  }

  public void setUsuariId(java.lang.String usuariId) {
    this.usuariId = usuariId;
  }


  private java.lang.Long departamentidDesde;

  public java.lang.Long getDepartamentidDesde() {
    return this.departamentidDesde;
  }

  public void setDepartamentidDesde(java.lang.Long departamentidDesde) {
    this.departamentidDesde = departamentidDesde;
  }


  private java.lang.Long departamentidFins;

  public java.lang.Long getDepartamentidFins() {
    return this.departamentidFins;
  }

  public void setDepartamentidFins(java.lang.Long departamentidFins) {
    this.departamentidFins = departamentidFins;
  }


  private java.lang.Long usuariDepartamentIdDesde;

  public java.lang.Long getUsuariDepartamentIdDesde() {
    return this.usuariDepartamentIdDesde;
  }

  public void setUsuariDepartamentIdDesde(java.lang.Long usuariDepartamentIdDesde) {
    this.usuariDepartamentIdDesde = usuariDepartamentIdDesde;
  }


  private java.lang.Long usuariDepartamentIdFins;

  public java.lang.Long getUsuariDepartamentIdFins() {
    return this.usuariDepartamentIdFins;
  }

  public void setUsuariDepartamentIdFins(java.lang.Long usuariDepartamentIdFins) {
    this.usuariDepartamentIdFins = usuariDepartamentIdFins;
  }


  public UsuarisDepartamentFilterForm() {
  }
  
  public UsuarisDepartamentFilterForm(UsuarisDepartamentFilterForm __toClone) {
    super(__toClone);
    this.usuariId = __toClone.usuariId;
    this.departamentidDesde = __toClone.departamentidDesde;
    this.departamentidFins = __toClone.departamentidFins;
    this.usuariDepartamentIdDesde = __toClone.usuariDepartamentIdDesde;
    this.usuariDepartamentIdFins = __toClone.usuariDepartamentIdFins;
    this.mapOfUsuarisForUsuariId = __toClone.mapOfUsuarisForUsuariId;
    this.mapOfDepartamentsForDepartamentid = __toClone.mapOfDepartamentsForDepartamentid;
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
  private Map<String, String> mapOfUsuarisForUsuariId;

  public Map<String, String> getMapOfUsuarisForUsuariId() {
    return this.mapOfUsuarisForUsuariId;
  }

  public void setMapOfUsuarisForUsuariId(Map<String, String> mapOfUsuarisForUsuariId) {
    this.mapOfUsuarisForUsuariId = mapOfUsuarisForUsuariId;
  }



  private Map<String, String> mapOfDepartamentsForDepartamentid;

  public Map<String, String> getMapOfDepartamentsForDepartamentid() {
    return this.mapOfDepartamentsForDepartamentid;
  }

  public void setMapOfDepartamentsForDepartamentid(Map<String, String> mapOfDepartamentsForDepartamentid) {
    this.mapOfDepartamentsForDepartamentid = mapOfDepartamentsForDepartamentid;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
