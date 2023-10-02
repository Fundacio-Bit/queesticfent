
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

  private java.lang.Long personalProjecteIDDesde;

  public java.lang.Long getPersonalProjecteIDDesde() {
    return this.personalProjecteIDDesde;
  }

  public void setPersonalProjecteIDDesde(java.lang.Long personalProjecteIDDesde) {
    this.personalProjecteIDDesde = personalProjecteIDDesde;
  }


  private java.lang.Long personalProjecteIDFins;

  public java.lang.Long getPersonalProjecteIDFins() {
    return this.personalProjecteIDFins;
  }

  public void setPersonalProjecteIDFins(java.lang.Long personalProjecteIDFins) {
    this.personalProjecteIDFins = personalProjecteIDFins;
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
    this.personalProjecteIDDesde = __toClone.personalProjecteIDDesde;
    this.personalProjecteIDFins = __toClone.personalProjecteIDFins;
    this.usuariID = __toClone.usuariID;
    this.projecteIDDesde = __toClone.projecteIDDesde;
    this.projecteIDFins = __toClone.projecteIDFins;
    this.ordreDesde = __toClone.ordreDesde;
    this.ordreFins = __toClone.ordreFins;
    this.percentDesde = __toClone.percentDesde;
    this.percentFins = __toClone.percentFins;
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
