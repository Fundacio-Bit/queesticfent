
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

  private java.lang.Long grupsUsuariIDDesde;

  public java.lang.Long getGrupsUsuariIDDesde() {
    return this.grupsUsuariIDDesde;
  }

  public void setGrupsUsuariIDDesde(java.lang.Long grupsUsuariIDDesde) {
    this.grupsUsuariIDDesde = grupsUsuariIDDesde;
  }


  private java.lang.Long grupsUsuariIDFins;

  public java.lang.Long getGrupsUsuariIDFins() {
    return this.grupsUsuariIDFins;
  }

  public void setGrupsUsuariIDFins(java.lang.Long grupsUsuariIDFins) {
    this.grupsUsuariIDFins = grupsUsuariIDFins;
  }


  private java.lang.String usuariID;

  public java.lang.String getUsuariID() {
    return this.usuariID;
  }

  public void setUsuariID(java.lang.String usuariID) {
    this.usuariID = usuariID;
  }


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


  public GrupsusuariFilterForm() {
  }
  
  public GrupsusuariFilterForm(GrupsusuariFilterForm __toClone) {
    super(__toClone);
    this.grupsUsuariIDDesde = __toClone.grupsUsuariIDDesde;
    this.grupsUsuariIDFins = __toClone.grupsUsuariIDFins;
    this.usuariID = __toClone.usuariID;
    this.grupIDDesde = __toClone.grupIDDesde;
    this.grupIDFins = __toClone.grupIDFins;
    this.mapOfUsuarisForUsuariID = __toClone.mapOfUsuarisForUsuariID;
    this.mapOfGrupsForGrupID = __toClone.mapOfGrupsForGrupID;
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
  private Map<String, String> mapOfUsuarisForUsuariID;

  public Map<String, String> getMapOfUsuarisForUsuariID() {
    return this.mapOfUsuarisForUsuariID;
  }

  public void setMapOfUsuarisForUsuariID(Map<String, String> mapOfUsuarisForUsuariID) {
    this.mapOfUsuarisForUsuariID = mapOfUsuarisForUsuariID;
  }



  private Map<String, String> mapOfGrupsForGrupID;

  public Map<String, String> getMapOfGrupsForGrupID() {
    return this.mapOfGrupsForGrupID;
  }

  public void setMapOfGrupsForGrupID(Map<String, String> mapOfGrupsForGrupID) {
    this.mapOfGrupsForGrupID = mapOfGrupsForGrupID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
