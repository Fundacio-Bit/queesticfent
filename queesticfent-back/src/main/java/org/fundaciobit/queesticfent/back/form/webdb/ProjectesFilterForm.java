
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.ProjectesFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class ProjectesFilterForm extends queesticfentBaseFilterForm implements ProjectesFields {

  private java.lang.Long projecteIdDesde;

  public java.lang.Long getProjecteIdDesde() {
    return this.projecteIdDesde;
  }

  public void setProjecteIdDesde(java.lang.Long projecteIdDesde) {
    this.projecteIdDesde = projecteIdDesde;
  }


  private java.lang.Long projecteIdFins;

  public java.lang.Long getProjecteIdFins() {
    return this.projecteIdFins;
  }

  public void setProjecteIdFins(java.lang.Long projecteIdFins) {
    this.projecteIdFins = projecteIdFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
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


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  private java.sql.Date fromdataDesde;

  public java.sql.Date getFromdataDesde() {
    return this.fromdataDesde;
  }

  public void setFromdataDesde(java.sql.Date fromdataDesde) {
    this.fromdataDesde = fromdataDesde;
  }


  private java.sql.Date fromdataFins;

  public java.sql.Date getFromdataFins() {
    return this.fromdataFins;
  }

  public void setFromdataFins(java.sql.Date fromdataFins) {
    this.fromdataFins = fromdataFins;
  }


  private java.sql.Date todataDesde;

  public java.sql.Date getTodataDesde() {
    return this.todataDesde;
  }

  public void setTodataDesde(java.sql.Date todataDesde) {
    this.todataDesde = todataDesde;
  }


  private java.sql.Date todataFins;

  public java.sql.Date getTodataFins() {
    return this.todataFins;
  }

  public void setTodataFins(java.sql.Date todataFins) {
    this.todataFins = todataFins;
  }


  public ProjectesFilterForm() {
  }
  
  public ProjectesFilterForm(ProjectesFilterForm __toClone) {
    super(__toClone);
    this.projecteIdDesde = __toClone.projecteIdDesde;
    this.projecteIdFins = __toClone.projecteIdFins;
    this.nom = __toClone.nom;
    this.departamentidDesde = __toClone.departamentidDesde;
    this.departamentidFins = __toClone.departamentidFins;
    this.descripcio = __toClone.descripcio;
    this.fromdataDesde = __toClone.fromdataDesde;
    this.fromdataFins = __toClone.fromdataFins;
    this.todataDesde = __toClone.todataDesde;
    this.todataFins = __toClone.todataFins;
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
