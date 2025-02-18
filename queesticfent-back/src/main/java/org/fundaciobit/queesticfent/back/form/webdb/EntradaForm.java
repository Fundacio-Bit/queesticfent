package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.EntradaJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class EntradaForm extends queesticfentBaseForm {
  
  private EntradaJPA entrada;
  
  public EntradaForm() {
  }
  
  public EntradaForm(EntradaForm __toClone) {
    super(__toClone);
      this.entrada = __toClone.entrada;
    this.listOfAccioForAccioID = __toClone.listOfAccioForAccioID;
    this.listOfProjecteForProjecteID = __toClone.listOfProjecteForProjecteID;
  }
  
  public EntradaForm(EntradaJPA entrada, boolean nou) {
    super(nou);
    this.entrada = entrada;
  }
  
  public EntradaJPA getEntrada() {
    return entrada;
  }
  public void setEntrada(EntradaJPA entrada) {
    this.entrada = entrada;
  }
  
  
  private List<StringKeyValue> listOfAccioForAccioID;

  public List<StringKeyValue> getListOfAccioForAccioID() {
    return this.listOfAccioForAccioID;
  }

  public void setListOfAccioForAccioID(List<StringKeyValue> listOfAccioForAccioID) {
    this.listOfAccioForAccioID = listOfAccioForAccioID;
  }



  private List<StringKeyValue> listOfProjecteForProjecteID;

  public List<StringKeyValue> getListOfProjecteForProjecteID() {
    return this.listOfProjecteForProjecteID;
  }

  public void setListOfProjecteForProjecteID(List<StringKeyValue> listOfProjecteForProjecteID) {
    this.listOfProjecteForProjecteID = listOfProjecteForProjecteID;
  }



  
} // Final de Classe 
