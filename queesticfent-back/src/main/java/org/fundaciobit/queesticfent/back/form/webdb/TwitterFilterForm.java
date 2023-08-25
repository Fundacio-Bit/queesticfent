
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.TwitterFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class TwitterFilterForm extends queesticfentBaseFilterForm implements TwitterFields {

  private java.lang.Long idDesde;

  public java.lang.Long getIdDesde() {
    return this.idDesde;
  }

  public void setIdDesde(java.lang.Long idDesde) {
    this.idDesde = idDesde;
  }


  private java.lang.Long idFins;

  public java.lang.Long getIdFins() {
    return this.idFins;
  }

  public void setIdFins(java.lang.Long idFins) {
    this.idFins = idFins;
  }


  private java.lang.String username;

  public java.lang.String getUsername() {
    return this.username;
  }

  public void setUsername(java.lang.String username) {
    this.username = username;
  }


  private java.lang.String comentario;

  public java.lang.String getComentario() {
    return this.comentario;
  }

  public void setComentario(java.lang.String comentario) {
    this.comentario = comentario;
  }


  private java.sql.Date fechaDesde;

  public java.sql.Date getFechaDesde() {
    return this.fechaDesde;
  }

  public void setFechaDesde(java.sql.Date fechaDesde) {
    this.fechaDesde = fechaDesde;
  }


  private java.sql.Date fechaFins;

  public java.sql.Date getFechaFins() {
    return this.fechaFins;
  }

  public void setFechaFins(java.sql.Date fechaFins) {
    this.fechaFins = fechaFins;
  }


  private java.lang.Long user_idDesde;

  public java.lang.Long getUser_idDesde() {
    return this.user_idDesde;
  }

  public void setUser_idDesde(java.lang.Long user_idDesde) {
    this.user_idDesde = user_idDesde;
  }


  private java.lang.Long user_idFins;

  public java.lang.Long getUser_idFins() {
    return this.user_idFins;
  }

  public void setUser_idFins(java.lang.Long user_idFins) {
    this.user_idFins = user_idFins;
  }


  private java.lang.String ip;

  public java.lang.String getIp() {
    return this.ip;
  }

  public void setIp(java.lang.String ip) {
    this.ip = ip;
  }


  public TwitterFilterForm() {
  }
  
  public TwitterFilterForm(TwitterFilterForm __toClone) {
    super(__toClone);
    this.idDesde = __toClone.idDesde;
    this.idFins = __toClone.idFins;
    this.username = __toClone.username;
    this.comentario = __toClone.comentario;
    this.fechaDesde = __toClone.fechaDesde;
    this.fechaFins = __toClone.fechaFins;
    this.user_idDesde = __toClone.user_idDesde;
    this.user_idFins = __toClone.user_idFins;
    this.ip = __toClone.ip;
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
