
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.AccionsFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class AccionsFilterForm extends queesticfentBaseFilterForm implements AccionsFields {

  private java.lang.Long accioidDesde;

  public java.lang.Long getAccioidDesde() {
    return this.accioidDesde;
  }

  public void setAccioidDesde(java.lang.Long accioidDesde) {
    this.accioidDesde = accioidDesde;
  }


  private java.lang.Long accioidFins;

  public java.lang.Long getAccioidFins() {
    return this.accioidFins;
  }

  public void setAccioidFins(java.lang.Long accioidFins) {
    this.accioidFins = accioidFins;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String nomllegenda;

  public java.lang.String getNomllegenda() {
    return this.nomllegenda;
  }

  public void setNomllegenda(java.lang.String nomllegenda) {
    this.nomllegenda = nomllegenda;
  }


  private java.lang.String color;

  public java.lang.String getColor() {
    return this.color;
  }

  public void setColor(java.lang.String color) {
    this.color = color;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  public AccionsFilterForm() {
  }
  
  public AccionsFilterForm(AccionsFilterForm __toClone) {
    super(__toClone);
    this.accioidDesde = __toClone.accioidDesde;
    this.accioidFins = __toClone.accioidFins;
    this.nom = __toClone.nom;
    this.nomllegenda = __toClone.nomllegenda;
    this.color = __toClone.color;
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
