
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.DepartamentsFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class DepartamentsFilterForm extends queesticfentBaseFilterForm implements DepartamentsFields {

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


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String coordinadorid;

  public java.lang.String getCoordinadorid() {
    return this.coordinadorid;
  }

  public void setCoordinadorid(java.lang.String coordinadorid) {
    this.coordinadorid = coordinadorid;
  }


  private java.lang.String nomldap;

  public java.lang.String getNomldap() {
    return this.nomldap;
  }

  public void setNomldap(java.lang.String nomldap) {
    this.nomldap = nomldap;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  public DepartamentsFilterForm() {
  }
  
  public DepartamentsFilterForm(DepartamentsFilterForm __toClone) {
    super(__toClone);
    this.departamentidDesde = __toClone.departamentidDesde;
    this.departamentidFins = __toClone.departamentidFins;
    this.nom = __toClone.nom;
    this.coordinadorid = __toClone.coordinadorid;
    this.nomldap = __toClone.nomldap;
    this.descripcio = __toClone.descripcio;
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

   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
