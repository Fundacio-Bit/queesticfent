
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseFilterForm;

import org.fundaciobit.queesticfent.model.fields.ModificacionsFields;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class ModificacionsFilterForm extends queesticfentBaseFilterForm implements ModificacionsFields {

  private java.lang.Long modificacioidDesde;

  public java.lang.Long getModificacioidDesde() {
    return this.modificacioidDesde;
  }

  public void setModificacioidDesde(java.lang.Long modificacioidDesde) {
    this.modificacioidDesde = modificacioidDesde;
  }


  private java.lang.Long modificacioidFins;

  public java.lang.Long getModificacioidFins() {
    return this.modificacioidFins;
  }

  public void setModificacioidFins(java.lang.Long modificacioidFins) {
    this.modificacioidFins = modificacioidFins;
  }


  private java.lang.Long entradaidDesde;

  public java.lang.Long getEntradaidDesde() {
    return this.entradaidDesde;
  }

  public void setEntradaidDesde(java.lang.Long entradaidDesde) {
    this.entradaidDesde = entradaidDesde;
  }


  private java.lang.Long entradaidFins;

  public java.lang.Long getEntradaidFins() {
    return this.entradaidFins;
  }

  public void setEntradaidFins(java.lang.Long entradaidFins) {
    this.entradaidFins = entradaidFins;
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


  private java.lang.String oldusuariID;

  public java.lang.String getOldusuariID() {
    return this.oldusuariID;
  }

  public void setOldusuariID(java.lang.String oldusuariID) {
    this.oldusuariID = oldusuariID;
  }


  private java.lang.Long oldprojecteIDDesde;

  public java.lang.Long getOldprojecteIDDesde() {
    return this.oldprojecteIDDesde;
  }

  public void setOldprojecteIDDesde(java.lang.Long oldprojecteIDDesde) {
    this.oldprojecteIDDesde = oldprojecteIDDesde;
  }


  private java.lang.Long oldprojecteIDFins;

  public java.lang.Long getOldprojecteIDFins() {
    return this.oldprojecteIDFins;
  }

  public void setOldprojecteIDFins(java.lang.Long oldprojecteIDFins) {
    this.oldprojecteIDFins = oldprojecteIDFins;
  }


  private java.lang.Long oldqueesticfentidDesde;

  public java.lang.Long getOldqueesticfentidDesde() {
    return this.oldqueesticfentidDesde;
  }

  public void setOldqueesticfentidDesde(java.lang.Long oldqueesticfentidDesde) {
    this.oldqueesticfentidDesde = oldqueesticfentidDesde;
  }


  private java.lang.Long oldqueesticfentidFins;

  public java.lang.Long getOldqueesticfentidFins() {
    return this.oldqueesticfentidFins;
  }

  public void setOldqueesticfentidFins(java.lang.Long oldqueesticfentidFins) {
    this.oldqueesticfentidFins = oldqueesticfentidFins;
  }


  private java.lang.String olddada1;

  public java.lang.String getOlddada1() {
    return this.olddada1;
  }

  public void setOlddada1(java.lang.String olddada1) {
    this.olddada1 = olddada1;
  }


  private java.lang.String olddada2;

  public java.lang.String getOlddada2() {
    return this.olddada2;
  }

  public void setOlddada2(java.lang.String olddada2) {
    this.olddada2 = olddada2;
  }


  private java.sql.Timestamp olddataDesde;

  public java.sql.Timestamp getOlddataDesde() {
    return this.olddataDesde;
  }

  public void setOlddataDesde(java.sql.Timestamp olddataDesde) {
    this.olddataDesde = olddataDesde;
  }


  private java.sql.Timestamp olddataFins;

  public java.sql.Timestamp getOlddataFins() {
    return this.olddataFins;
  }

  public void setOlddataFins(java.sql.Timestamp olddataFins) {
    this.olddataFins = olddataFins;
  }


  private java.lang.String newusuariID;

  public java.lang.String getNewusuariID() {
    return this.newusuariID;
  }

  public void setNewusuariID(java.lang.String newusuariID) {
    this.newusuariID = newusuariID;
  }


  private java.lang.Long newprojecteIDDesde;

  public java.lang.Long getNewprojecteIDDesde() {
    return this.newprojecteIDDesde;
  }

  public void setNewprojecteIDDesde(java.lang.Long newprojecteIDDesde) {
    this.newprojecteIDDesde = newprojecteIDDesde;
  }


  private java.lang.Long newprojecteIDFins;

  public java.lang.Long getNewprojecteIDFins() {
    return this.newprojecteIDFins;
  }

  public void setNewprojecteIDFins(java.lang.Long newprojecteIDFins) {
    this.newprojecteIDFins = newprojecteIDFins;
  }


  private java.lang.Long newqueesticfentidDesde;

  public java.lang.Long getNewqueesticfentidDesde() {
    return this.newqueesticfentidDesde;
  }

  public void setNewqueesticfentidDesde(java.lang.Long newqueesticfentidDesde) {
    this.newqueesticfentidDesde = newqueesticfentidDesde;
  }


  private java.lang.Long newqueesticfentidFins;

  public java.lang.Long getNewqueesticfentidFins() {
    return this.newqueesticfentidFins;
  }

  public void setNewqueesticfentidFins(java.lang.Long newqueesticfentidFins) {
    this.newqueesticfentidFins = newqueesticfentidFins;
  }


  private java.lang.String newdada1;

  public java.lang.String getNewdada1() {
    return this.newdada1;
  }

  public void setNewdada1(java.lang.String newdada1) {
    this.newdada1 = newdada1;
  }


  private java.lang.String newdada2;

  public java.lang.String getNewdada2() {
    return this.newdada2;
  }

  public void setNewdada2(java.lang.String newdada2) {
    this.newdada2 = newdada2;
  }


  private java.sql.Timestamp newdataDesde;

  public java.sql.Timestamp getNewdataDesde() {
    return this.newdataDesde;
  }

  public void setNewdataDesde(java.sql.Timestamp newdataDesde) {
    this.newdataDesde = newdataDesde;
  }


  private java.sql.Timestamp newdataFins;

  public java.sql.Timestamp getNewdataFins() {
    return this.newdataFins;
  }

  public void setNewdataFins(java.sql.Timestamp newdataFins) {
    this.newdataFins = newdataFins;
  }


  public ModificacionsFilterForm() {
  }
  
  public ModificacionsFilterForm(ModificacionsFilterForm __toClone) {
    super(__toClone);
    this.modificacioidDesde = __toClone.modificacioidDesde;
    this.modificacioidFins = __toClone.modificacioidFins;
    this.entradaidDesde = __toClone.entradaidDesde;
    this.entradaidFins = __toClone.entradaidFins;
    this.accioidDesde = __toClone.accioidDesde;
    this.accioidFins = __toClone.accioidFins;
    this.oldusuariID = __toClone.oldusuariID;
    this.oldprojecteIDDesde = __toClone.oldprojecteIDDesde;
    this.oldprojecteIDFins = __toClone.oldprojecteIDFins;
    this.oldqueesticfentidDesde = __toClone.oldqueesticfentidDesde;
    this.oldqueesticfentidFins = __toClone.oldqueesticfentidFins;
    this.olddada1 = __toClone.olddada1;
    this.olddada2 = __toClone.olddada2;
    this.olddataDesde = __toClone.olddataDesde;
    this.olddataFins = __toClone.olddataFins;
    this.newusuariID = __toClone.newusuariID;
    this.newprojecteIDDesde = __toClone.newprojecteIDDesde;
    this.newprojecteIDFins = __toClone.newprojecteIDFins;
    this.newqueesticfentidDesde = __toClone.newqueesticfentidDesde;
    this.newqueesticfentidFins = __toClone.newqueesticfentidFins;
    this.newdada1 = __toClone.newdada1;
    this.newdada2 = __toClone.newdada2;
    this.newdataDesde = __toClone.newdataDesde;
    this.newdataFins = __toClone.newdataFins;
    this.mapOfEntradesForEntradaid = __toClone.mapOfEntradesForEntradaid;
    this.mapOfAccionsForAccioid = __toClone.mapOfAccionsForAccioid;
    this.mapOfProjectesForOldprojecteID = __toClone.mapOfProjectesForOldprojecteID;
    this.mapOfProjectesForNewprojecteID = __toClone.mapOfProjectesForNewprojecteID;
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
  private Map<String, String> mapOfEntradesForEntradaid;

  public Map<String, String> getMapOfEntradesForEntradaid() {
    return this.mapOfEntradesForEntradaid;
  }

  public void setMapOfEntradesForEntradaid(Map<String, String> mapOfEntradesForEntradaid) {
    this.mapOfEntradesForEntradaid = mapOfEntradesForEntradaid;
  }



  private Map<String, String> mapOfAccionsForAccioid;

  public Map<String, String> getMapOfAccionsForAccioid() {
    return this.mapOfAccionsForAccioid;
  }

  public void setMapOfAccionsForAccioid(Map<String, String> mapOfAccionsForAccioid) {
    this.mapOfAccionsForAccioid = mapOfAccionsForAccioid;
  }



  private Map<String, String> mapOfProjectesForOldprojecteID;

  public Map<String, String> getMapOfProjectesForOldprojecteID() {
    return this.mapOfProjectesForOldprojecteID;
  }

  public void setMapOfProjectesForOldprojecteID(Map<String, String> mapOfProjectesForOldprojecteID) {
    this.mapOfProjectesForOldprojecteID = mapOfProjectesForOldprojecteID;
  }



  private Map<String, String> mapOfProjectesForNewprojecteID;

  public Map<String, String> getMapOfProjectesForNewprojecteID() {
    return this.mapOfProjectesForNewprojecteID;
  }

  public void setMapOfProjectesForNewprojecteID(Map<String, String> mapOfProjectesForNewprojecteID) {
    this.mapOfProjectesForNewprojecteID = mapOfProjectesForNewprojecteID;
  }




   // --------------------------------
   // Camps traduibles de referencies.
   // ---------------------------------
   public static final List<String> traduibles;

   static {
     traduibles = new java.util.ArrayList<String>();
   };

}
