
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.UsuarisFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class UsuarisFilterForm extends queesticfentBaseFilterForm implements UsuarisFields {

  private java.lang.String usuariID;

  public java.lang.String getUsuariID() {
    return this.usuariID;
  }

  public void setUsuariID(java.lang.String usuariID) {
    this.usuariID = usuariID;
  }


  private java.lang.String llinatge1;

  public java.lang.String getLlinatge1() {
    return this.llinatge1;
  }

  public void setLlinatge1(java.lang.String llinatge1) {
    this.llinatge1 = llinatge1;
  }


  private java.lang.String llinatge2;

  public java.lang.String getLlinatge2() {
    return this.llinatge2;
  }

  public void setLlinatge2(java.lang.String llinatge2) {
    this.llinatge2 = llinatge2;
  }


  private java.lang.String nom;

  public java.lang.String getNom() {
    return this.nom;
  }

  public void setNom(java.lang.String nom) {
    this.nom = nom;
  }


  private java.lang.String correu;

  public java.lang.String getCorreu() {
    return this.correu;
  }

  public void setCorreu(java.lang.String correu) {
    this.correu = correu;
  }


  private java.lang.String descripcio;

  public java.lang.String getDescripcio() {
    return this.descripcio;
  }

  public void setDescripcio(java.lang.String descripcio) {
    this.descripcio = descripcio;
  }


  private java.lang.String extensio;

  public java.lang.String getExtensio() {
    return this.extensio;
  }

  public void setExtensio(java.lang.String extensio) {
    this.extensio = extensio;
  }


  private java.sql.Date naixementDesde;

  public java.sql.Date getNaixementDesde() {
    return this.naixementDesde;
  }

  public void setNaixementDesde(java.sql.Date naixementDesde) {
    this.naixementDesde = naixementDesde;
  }


  private java.sql.Date naixementFins;

  public java.sql.Date getNaixementFins() {
    return this.naixementFins;
  }

  public void setNaixementFins(java.sql.Date naixementFins) {
    this.naixementFins = naixementFins;
  }


  private java.lang.String telefoncasa;

  public java.lang.String getTelefoncasa() {
    return this.telefoncasa;
  }

  public void setTelefoncasa(java.lang.String telefoncasa) {
    this.telefoncasa = telefoncasa;
  }


  private java.lang.String telefonmobil;

  public java.lang.String getTelefonmobil() {
    return this.telefonmobil;
  }

  public void setTelefonmobil(java.lang.String telefonmobil) {
    this.telefonmobil = telefonmobil;
  }


  private java.lang.String color;

  public java.lang.String getColor() {
    return this.color;
  }

  public void setColor(java.lang.String color) {
    this.color = color;
  }


  public UsuarisFilterForm() {
  }
  
  public UsuarisFilterForm(UsuarisFilterForm __toClone) {
    super(__toClone);
    this.usuariID = __toClone.usuariID;
    this.llinatge1 = __toClone.llinatge1;
    this.llinatge2 = __toClone.llinatge2;
    this.nom = __toClone.nom;
    this.correu = __toClone.correu;
    this.descripcio = __toClone.descripcio;
    this.extensio = __toClone.extensio;
    this.naixementDesde = __toClone.naixementDesde;
    this.naixementFins = __toClone.naixementFins;
    this.telefoncasa = __toClone.telefoncasa;
    this.telefonmobil = __toClone.telefonmobil;
    this.color = __toClone.color;
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
