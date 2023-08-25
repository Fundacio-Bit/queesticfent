
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

  private java.lang.String usuariid;

  public java.lang.String getUsuariid() {
    return this.usuariid;
  }

  public void setUsuariid(java.lang.String usuariid) {
    this.usuariid = usuariid;
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


  private java.lang.Long usuaridepartamentidDesde;

  public java.lang.Long getUsuaridepartamentidDesde() {
    return this.usuaridepartamentidDesde;
  }

  public void setUsuaridepartamentidDesde(java.lang.Long usuaridepartamentidDesde) {
    this.usuaridepartamentidDesde = usuaridepartamentidDesde;
  }


  private java.lang.Long usuaridepartamentidFins;

  public java.lang.Long getUsuaridepartamentidFins() {
    return this.usuaridepartamentidFins;
  }

  public void setUsuaridepartamentidFins(java.lang.Long usuaridepartamentidFins) {
    this.usuaridepartamentidFins = usuaridepartamentidFins;
  }


  public UsuarisDepartamentFilterForm() {
  }
  
  public UsuarisDepartamentFilterForm(UsuarisDepartamentFilterForm __toClone) {
    super(__toClone);
    this.usuariid = __toClone.usuariid;
    this.departamentidDesde = __toClone.departamentidDesde;
    this.departamentidFins = __toClone.departamentidFins;
    this.usuaridepartamentidDesde = __toClone.usuaridepartamentidDesde;
    this.usuaridepartamentidFins = __toClone.usuaridepartamentidFins;
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
