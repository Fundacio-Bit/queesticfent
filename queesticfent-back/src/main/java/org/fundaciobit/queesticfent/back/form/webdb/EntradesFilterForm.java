
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.EntradesFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EntradesFilterForm extends queesticfentBaseFilterForm implements EntradesFields {

  private java.lang.Long entradaIDDesde;

  public java.lang.Long getEntradaIDDesde() {
    return this.entradaIDDesde;
  }

  public void setEntradaIDDesde(java.lang.Long entradaIDDesde) {
    this.entradaIDDesde = entradaIDDesde;
  }


  private java.lang.Long entradaIDFins;

  public java.lang.Long getEntradaIDFins() {
    return this.entradaIDFins;
  }

  public void setEntradaIDFins(java.lang.Long entradaIDFins) {
    this.entradaIDFins = entradaIDFins;
  }


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


  private java.lang.String usuariid;

  public java.lang.String getUsuariid() {
    return this.usuariid;
  }

  public void setUsuariid(java.lang.String usuariid) {
    this.usuariid = usuariid;
  }


  private java.lang.Long projecteidDesde;

  public java.lang.Long getProjecteidDesde() {
    return this.projecteidDesde;
  }

  public void setProjecteidDesde(java.lang.Long projecteidDesde) {
    this.projecteidDesde = projecteidDesde;
  }


  private java.lang.Long projecteidFins;

  public java.lang.Long getProjecteidFins() {
    return this.projecteidFins;
  }

  public void setProjecteidFins(java.lang.Long projecteidFins) {
    this.projecteidFins = projecteidFins;
  }


  private java.lang.Long queesticfentidDesde;

  public java.lang.Long getQueesticfentidDesde() {
    return this.queesticfentidDesde;
  }

  public void setQueesticfentidDesde(java.lang.Long queesticfentidDesde) {
    this.queesticfentidDesde = queesticfentidDesde;
  }


  private java.lang.Long queesticfentidFins;

  public java.lang.Long getQueesticfentidFins() {
    return this.queesticfentidFins;
  }

  public void setQueesticfentidFins(java.lang.Long queesticfentidFins) {
    this.queesticfentidFins = queesticfentidFins;
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


  private java.sql.Time dataDesde;

  public java.sql.Time getDataDesde() {
    return this.dataDesde;
  }

  public void setDataDesde(java.sql.Time dataDesde) {
    this.dataDesde = dataDesde;
  }


  private java.sql.Time dataFins;

  public java.sql.Time getDataFins() {
    return this.dataFins;
  }

  public void setDataFins(java.sql.Time dataFins) {
    this.dataFins = dataFins;
  }


  public EntradesFilterForm() {
  }
  
  public EntradesFilterForm(EntradesFilterForm __toClone) {
    super(__toClone);
    this.entradaIDDesde = __toClone.entradaIDDesde;
    this.entradaIDFins = __toClone.entradaIDFins;
    this.accioidDesde = __toClone.accioidDesde;
    this.accioidFins = __toClone.accioidFins;
    this.usuariid = __toClone.usuariid;
    this.projecteidDesde = __toClone.projecteidDesde;
    this.projecteidFins = __toClone.projecteidFins;
    this.queesticfentidDesde = __toClone.queesticfentidDesde;
    this.queesticfentidFins = __toClone.queesticfentidFins;
    this.dada1 = __toClone.dada1;
    this.dada2 = __toClone.dada2;
    this.dataDesde = __toClone.dataDesde;
    this.dataFins = __toClone.dataFins;
    this.mapOfAccionsForAccioid = __toClone.mapOfAccionsForAccioid;
    this.mapOfProjectesForProjecteid = __toClone.mapOfProjectesForProjecteid;
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
  private Map<String, String> mapOfAccionsForAccioid;

  public Map<String, String> getMapOfAccionsForAccioid() {
    return this.mapOfAccionsForAccioid;
  }

  public void setMapOfAccionsForAccioid(Map<String, String> mapOfAccionsForAccioid) {
    this.mapOfAccionsForAccioid = mapOfAccionsForAccioid;
  }



  private Map<String, String> mapOfProjectesForProjecteid;

  public Map<String, String> getMapOfProjectesForProjecteid() {
    return this.mapOfProjectesForProjecteid;
  }

  public void setMapOfProjectesForProjecteid(Map<String, String> mapOfProjectesForProjecteid) {
    this.mapOfProjectesForProjecteid = mapOfProjectesForProjecteid;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
