
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.DepartamentFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class DepartamentFilterForm extends queesticfentBaseFilterForm implements DepartamentFields {

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


  public DepartamentFilterForm() {
  }
  
  public DepartamentFilterForm(DepartamentFilterForm __toClone) {
    super(__toClone);
    this.departamentIDDesde = __toClone.departamentIDDesde;
    this.departamentIDFins = __toClone.departamentIDFins;
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
