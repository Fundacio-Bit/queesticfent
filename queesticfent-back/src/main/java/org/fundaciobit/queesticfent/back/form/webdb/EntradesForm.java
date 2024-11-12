package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.EntradesJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class EntradesForm extends queesticfentBaseForm {
  
  private EntradesJPA entrades;
  
  public EntradesForm() {
  }
  
  public EntradesForm(EntradesForm __toClone) {
    super(__toClone);
      this.entrades = __toClone.entrades;
    this.listOfAccionsForAccioid = __toClone.listOfAccionsForAccioid;
    this.listOfProjectesForProjecteid = __toClone.listOfProjectesForProjecteid;
  }
  
  public EntradesForm(EntradesJPA entrades, boolean nou) {
    super(nou);
    this.entrades = entrades;
  }
  
  public EntradesJPA getEntrades() {
    return entrades;
  }
  public void setEntrades(EntradesJPA entrades) {
    this.entrades = entrades;
  }
  
  
  private List<StringKeyValue> listOfAccionsForAccioid;

  public List<StringKeyValue> getListOfAccionsForAccioid() {
    return this.listOfAccionsForAccioid;
  }

  public void setListOfAccionsForAccioid(List<StringKeyValue> listOfAccionsForAccioid) {
    this.listOfAccionsForAccioid = listOfAccionsForAccioid;
  }



  private List<StringKeyValue> listOfProjectesForProjecteid;

  public List<StringKeyValue> getListOfProjectesForProjecteid() {
    return this.listOfProjectesForProjecteid;
  }

  public void setListOfProjectesForProjecteid(List<StringKeyValue> listOfProjectesForProjecteid) {
    this.listOfProjectesForProjecteid = listOfProjectesForProjecteid;
  }



  
} // Final de Classe 
