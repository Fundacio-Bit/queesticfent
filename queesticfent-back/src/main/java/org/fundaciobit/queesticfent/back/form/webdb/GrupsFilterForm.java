
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.GrupsFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class GrupsFilterForm extends queesticfentBaseFilterForm implements GrupsFields {

  private java.lang.Long grupIDDesde;

  public java.lang.Long getGrupIDDesde() {
    return this.grupIDDesde;
  }

  public void setGrupIDDesde(java.lang.Long grupIDDesde) {
    this.grupIDDesde = grupIDDesde;
  }


  private java.lang.Long grupIDFins;

  public java.lang.Long getGrupIDFins() {
    return this.grupIDFins;
  }

  public void setGrupIDFins(java.lang.Long grupIDFins) {
    this.grupIDFins = grupIDFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  private java.lang.Long nivellSeguretatDesde;

  public java.lang.Long getNivellSeguretatDesde() {
    return this.nivellSeguretatDesde;
  }

  public void setNivellSeguretatDesde(java.lang.Long nivellSeguretatDesde) {
    this.nivellSeguretatDesde = nivellSeguretatDesde;
  }


  private java.lang.Long nivellSeguretatFins;

  public java.lang.Long getNivellSeguretatFins() {
    return this.nivellSeguretatFins;
  }

  public void setNivellSeguretatFins(java.lang.Long nivellSeguretatFins) {
    this.nivellSeguretatFins = nivellSeguretatFins;
  }


  public GrupsFilterForm() {
  }
  
  public GrupsFilterForm(GrupsFilterForm __toClone) {
    super(__toClone);
    this.grupIDDesde = __toClone.grupIDDesde;
    this.grupIDFins = __toClone.grupIDFins;
    this.nom = __toClone.nom;
    this.descripcio = __toClone.descripcio;
    this.nivellSeguretatDesde = __toClone.nivellSeguretatDesde;
    this.nivellSeguretatFins = __toClone.nivellSeguretatFins;
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
