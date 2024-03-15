
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.ModificacionsQueEsticFentFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class ModificacionsQueEsticFentFilterForm extends queesticfentBaseFilterForm implements ModificacionsQueEsticFentFields {

  private java.lang.Long modificacioIDDesde;

  public java.lang.Long getModificacioIDDesde() {
    return this.modificacioIDDesde;
  }

  public void setModificacioIDDesde(java.lang.Long modificacioIDDesde) {
    this.modificacioIDDesde = modificacioIDDesde;
  }


  private java.lang.Long modificacioIDFins;

  public java.lang.Long getModificacioIDFins() {
    return this.modificacioIDFins;
  }

  public void setModificacioIDFins(java.lang.Long modificacioIDFins) {
    this.modificacioIDFins = modificacioIDFins;
  }


  private java.lang.Long accioIDDesde;

  public java.lang.Long getAccioIDDesde() {
    return this.accioIDDesde;
  }

  public void setAccioIDDesde(java.lang.Long accioIDDesde) {
    this.accioIDDesde = accioIDDesde;
  }


  private java.lang.Long accioIDFins;

  public java.lang.Long getAccioIDFins() {
    return this.accioIDFins;
  }

  public void setAccioIDFins(java.lang.Long accioIDFins) {
    this.accioIDFins = accioIDFins;
  }


  private java.lang.String usuariID;

  public java.lang.String getUsuariID() {
    return this.usuariID;
  }

  public void setUsuariID(java.lang.String usuariID) {
    this.usuariID = usuariID;
  }


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


  private java.sql.Timestamp dataDesde;

  public java.sql.Timestamp getDataDesde() {
    return this.dataDesde;
  }

  public void setDataDesde(java.sql.Timestamp dataDesde) {
    this.dataDesde = dataDesde;
  }


  private java.sql.Timestamp dataFins;

  public java.sql.Timestamp getDataFins() {
    return this.dataFins;
  }

  public void setDataFins(java.sql.Timestamp dataFins) {
    this.dataFins = dataFins;
  }


  private java.lang.Long queEsticFentIDDesde;

  public java.lang.Long getQueEsticFentIDDesde() {
    return this.queEsticFentIDDesde;
  }

  public void setQueEsticFentIDDesde(java.lang.Long queEsticFentIDDesde) {
    this.queEsticFentIDDesde = queEsticFentIDDesde;
  }


  private java.lang.Long queEsticFentIDFins;

  public java.lang.Long getQueEsticFentIDFins() {
    return this.queEsticFentIDFins;
  }

  public void setQueEsticFentIDFins(java.lang.Long queEsticFentIDFins) {
    this.queEsticFentIDFins = queEsticFentIDFins;
  }


  private java.lang.String dada1;

  public java.lang.String getDada1() {
    return this.dada1;
  }

  public void setDada1(java.lang.String dada1) {
    this.dada1 = dada1;
  }


  private java.lang.String dada2;

  public java.lang.String getDada2() {
    return this.dada2;
  }

  public void setDada2(java.lang.String dada2) {
    this.dada2 = dada2;
  }


  public ModificacionsQueEsticFentFilterForm() {
  }
  
  public ModificacionsQueEsticFentFilterForm(ModificacionsQueEsticFentFilterForm __toClone) {
    super(__toClone);
    this.modificacioIDDesde = __toClone.modificacioIDDesde;
    this.modificacioIDFins = __toClone.modificacioIDFins;
    this.accioIDDesde = __toClone.accioIDDesde;
    this.accioIDFins = __toClone.accioIDFins;
    this.usuariID = __toClone.usuariID;
    this.projecteIDDesde = __toClone.projecteIDDesde;
    this.projecteIDFins = __toClone.projecteIDFins;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
    this.queEsticFentIDDesde = __toClone.queEsticFentIDDesde;
    this.queEsticFentIDFins = __toClone.queEsticFentIDFins;
    this.dada1 = __toClone.dada1;
    this.dada2 = __toClone.dada2;
    this.mapOfAccionsForAccioID = __toClone.mapOfAccionsForAccioID;
    this.mapOfProjectesForProjecteID = __toClone.mapOfProjectesForProjecteID;
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
  private Map<String, String> mapOfAccionsForAccioID;

  public Map<String, String> getMapOfAccionsForAccioID() {
    return this.mapOfAccionsForAccioID;
  }

  public void setMapOfAccionsForAccioID(Map<String, String> mapOfAccionsForAccioID) {
    this.mapOfAccionsForAccioID = mapOfAccionsForAccioID;
  }



  private Map<String, String> mapOfProjectesForProjecteID;

  public Map<String, String> getMapOfProjectesForProjecteID() {
    return this.mapOfProjectesForProjecteID;
  }

  public void setMapOfProjectesForProjecteID(Map<String, String> mapOfProjectesForProjecteID) {
    this.mapOfProjectesForProjecteID = mapOfProjectesForProjecteID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
