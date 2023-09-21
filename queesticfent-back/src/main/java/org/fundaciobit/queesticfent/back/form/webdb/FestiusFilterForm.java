
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

  private java.lang.Long festiuIDDesde;

  public java.lang.Long getFestiuIDDesde() {
    return this.festiuIDDesde;
  }

  public void setFestiuIDDesde(java.lang.Long festiuIDDesde) {
    this.festiuIDDesde = festiuIDDesde;
  }


  private java.lang.Long festiuIDFins;

  public java.lang.Long getFestiuIDFins() {
    return this.festiuIDFins;
  }

  public void setFestiuIDFins(java.lang.Long festiuIDFins) {
    this.festiuIDFins = festiuIDFins;
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
    this.festiuIDDesde = __toClone.festiuIDDesde;
    this.festiuIDFins = __toClone.festiuIDFins;
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
