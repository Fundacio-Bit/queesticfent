
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.GrupsusuariFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class GrupsusuariFilterForm extends queesticfentBaseFilterForm implements GrupsusuariFields {

  private java.lang.Long grupsusuariidDesde;

  public java.lang.Long getGrupsusuariidDesde() {
    return this.grupsusuariidDesde;
  }

  public void setGrupsusuariidDesde(java.lang.Long grupsusuariidDesde) {
    this.grupsusuariidDesde = grupsusuariidDesde;
  }


  private java.lang.Long grupsusuariidFins;

  public java.lang.Long getGrupsusuariidFins() {
    return this.grupsusuariidFins;
  }

  public void setGrupsusuariidFins(java.lang.Long grupsusuariidFins) {
    this.grupsusuariidFins = grupsusuariidFins;
  }


  private java.lang.String usuariid;

  public java.lang.String getUsuariid() {
    return this.usuariid;
  }

  public void setUsuariid(java.lang.String usuariid) {
    this.usuariid = usuariid;
  }


  private java.lang.Long grupidDesde;

  public java.lang.Long getGrupidDesde() {
    return this.grupidDesde;
  }

  public void setGrupidDesde(java.lang.Long grupidDesde) {
    this.grupidDesde = grupidDesde;
  }


  private java.lang.Long grupidFins;

  public java.lang.Long getGrupidFins() {
    return this.grupidFins;
  }

  public void setGrupidFins(java.lang.Long grupidFins) {
    this.grupidFins = grupidFins;
  }


  public GrupsusuariFilterForm() {
  }
  
  public GrupsusuariFilterForm(GrupsusuariFilterForm __toClone) {
    super(__toClone);
    this.grupsusuariidDesde = __toClone.grupsusuariidDesde;
    this.grupsusuariidFins = __toClone.grupsusuariidFins;
    this.usuariid = __toClone.usuariid;
    this.grupidDesde = __toClone.grupidDesde;
    this.grupidFins = __toClone.grupidFins;
    this.mapOfUsuarisForUsuariid = __toClone.mapOfUsuarisForUsuariid;
    this.mapOfGrupsForGrupid = __toClone.mapOfGrupsForGrupid;
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
  private Map<String, String> mapOfUsuarisForUsuariid;

  public Map<String, String> getMapOfUsuarisForUsuariid() {
    return this.mapOfUsuarisForUsuariid;
  }

  public void setMapOfUsuarisForUsuariid(Map<String, String> mapOfUsuarisForUsuariid) {
    this.mapOfUsuarisForUsuariid = mapOfUsuarisForUsuariid;
  }



  private Map<String, String> mapOfGrupsForGrupid;

  public Map<String, String> getMapOfGrupsForGrupid() {
    return this.mapOfGrupsForGrupid;
  }

  public void setMapOfGrupsForGrupid(Map<String, String> mapOfGrupsForGrupid) {
    this.mapOfGrupsForGrupid = mapOfGrupsForGrupid;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
