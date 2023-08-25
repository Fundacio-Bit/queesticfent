
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.FestiusFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class FestiusFilterForm extends queesticfentBaseFilterForm implements FestiusFields {

  private java.lang.Long festiuidDesde;

  public java.lang.Long getFestiuidDesde() {
    return this.festiuidDesde;
  }

  public void setFestiuidDesde(java.lang.Long festiuidDesde) {
    this.festiuidDesde = festiuidDesde;
  }


  private java.lang.Long festiuidFins;

  public java.lang.Long getFestiuidFins() {
    return this.festiuidFins;
  }

  public void setFestiuidFins(java.lang.Long festiuidFins) {
    this.festiuidFins = festiuidFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.sql.Date dataDesde;

  public java.sql.Date getDataDesde() {
    return this.dataDesde;
  }

  public void setDataDesde(java.sql.Date dataDesde) {
    this.dataDesde = dataDesde;
  }


  private java.sql.Date dataFins;

  public java.sql.Date getDataFins() {
    return this.dataFins;
  }

  public void setDataFins(java.sql.Date dataFins) {
    this.dataFins = dataFins;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  public FestiusFilterForm() {
  }
  
  public FestiusFilterForm(FestiusFilterForm __toClone) {
    super(__toClone);
    this.festiuidDesde = __toClone.festiuidDesde;
    this.festiuidFins = __toClone.festiuidFins;
    this.nom = __toClone.nom;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
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
