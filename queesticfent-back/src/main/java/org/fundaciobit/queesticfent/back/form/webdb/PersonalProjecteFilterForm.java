
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.PersonalProjecteFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class PersonalProjecteFilterForm extends queesticfentBaseFilterForm implements PersonalProjecteFields {

  private java.lang.Long personalProjecteIdDesde;

  public java.lang.Long getPersonalProjecteIdDesde() {
    return this.personalProjecteIdDesde;
  }

  public void setPersonalProjecteIdDesde(java.lang.Long personalProjecteIdDesde) {
    this.personalProjecteIdDesde = personalProjecteIdDesde;
  }


  private java.lang.Long personalProjecteIdFins;

  public java.lang.Long getPersonalProjecteIdFins() {
    return this.personalProjecteIdFins;
  }

  public void setPersonalProjecteIdFins(java.lang.Long personalProjecteIdFins) {
    this.personalProjecteIdFins = personalProjecteIdFins;
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


  private java.lang.Long ordreDesde;

  public java.lang.Long getOrdreDesde() {
    return this.ordreDesde;
  }

  public void setOrdreDesde(java.lang.Long ordreDesde) {
    this.ordreDesde = ordreDesde;
  }


  private java.lang.Long ordreFins;

  public java.lang.Long getOrdreFins() {
    return this.ordreFins;
  }

  public void setOrdreFins(java.lang.Long ordreFins) {
    this.ordreFins = ordreFins;
  }


  private java.lang.Short percentDesde;

  public java.lang.Short getPercentDesde() {
    return this.percentDesde;
  }

  public void setPercentDesde(java.lang.Short percentDesde) {
    this.percentDesde = percentDesde;
  }


  private java.lang.Short percentFins;

  public java.lang.Short getPercentFins() {
    return this.percentFins;
  }

  public void setPercentFins(java.lang.Short percentFins) {
    this.percentFins = percentFins;
  }


  public PersonalProjecteFilterForm() {
  }
  
  public PersonalProjecteFilterForm(PersonalProjecteFilterForm __toClone) {
    super(__toClone);
    this.personalProjecteIdDesde = __toClone.personalProjecteIdDesde;
    this.personalProjecteIdFins = __toClone.personalProjecteIdFins;
    this.usuariid = __toClone.usuariid;
    this.projecteidDesde = __toClone.projecteidDesde;
    this.projecteidFins = __toClone.projecteidFins;
    this.ordreDesde = __toClone.ordreDesde;
    this.ordreFins = __toClone.ordreFins;
    this.percentDesde = __toClone.percentDesde;
    this.percentFins = __toClone.percentFins;
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
