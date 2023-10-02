
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

  private java.lang.Long projecteIDDesde;

  public java.lang.Long getProjecteIDDesde() {
    return this.projecteIDDesde;
  }

  public void setProjecteIDDesde(java.lang.Long projecteIDDesde) {
    this.projecteIDDesde = projecteIDDesde;
  }


  private java.lang.Long projecteIDFins;

  public java.lang.Long getProjecteIDFins() {
    return this.projecteIDFins;
  }

  public void setProjecteIDFins(java.lang.Long projecteIDFins) {
    this.projecteIDFins = projecteIDFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
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
    this.projecteIDDesde = __toClone.projecteIDDesde;
    this.projecteIDFins = __toClone.projecteIDFins;
    this.nom = __toClone.nom;
    this.departamentIDDesde = __toClone.departamentIDDesde;
    this.departamentIDFins = __toClone.departamentIDFins;
    this.descripcio = __toClone.descripcio;
    this.fromdataDesde = __toClone.fromdataDesde;
    this.fromdataFins = __toClone.fromdataFins;
    this.todataDesde = __toClone.todataDesde;
    this.todataFins = __toClone.todataFins;
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
