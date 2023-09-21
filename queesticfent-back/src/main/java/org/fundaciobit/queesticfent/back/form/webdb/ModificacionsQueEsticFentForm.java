package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class ModificacionsQueEsticFentForm extends queesticfentBaseForm {
  
  private ModificacionsQueEsticFentJPA modificacionsQueEsticFent;
  
  public ModificacionsQueEsticFentForm() {
  }
  
  public ModificacionsQueEsticFentForm(ModificacionsQueEsticFentForm __toClone) {
    super(__toClone);
      this.modificacionsQueEsticFent = __toClone.modificacionsQueEsticFent;
    this.listOfAccionsForAccioID = __toClone.listOfAccionsForAccioID;
    this.listOfProjectesForProjecteID = __toClone.listOfProjectesForProjecteID;
  }
  
  public ModificacionsQueEsticFentForm(ModificacionsQueEsticFentJPA modificacionsQueEsticFent, boolean nou) {
    super(nou);
    this.modificacionsQueEsticFent = modificacionsQueEsticFent;
  }
  
  public ModificacionsQueEsticFentJPA getModificacionsQueEsticFent() {
    return modificacionsQueEsticFent;
  }
  public void setModificacionsQueEsticFent(ModificacionsQueEsticFentJPA modificacionsQueEsticFent) {
    this.modificacionsQueEsticFent = modificacionsQueEsticFent;
  }
  
  
  private List<StringKeyValue> listOfAccionsForAccioID;

  public List<StringKeyValue> getListOfAccionsForAccioID() {
    return this.listOfAccionsForAccioID;
  }

  public void setListOfAccionsForAccioID(List<StringKeyValue> listOfAccionsForAccioID) {
    this.listOfAccionsForAccioID = listOfAccionsForAccioID;
  }



  private List<StringKeyValue> listOfProjectesForProjecteID;

  public List<StringKeyValue> getListOfProjectesForProjecteID() {
    return this.listOfProjectesForProjecteID;
  }

  public void setListOfProjectesForProjecteID(List<StringKeyValue> listOfProjectesForProjecteID) {
    this.listOfProjectesForProjecteID = listOfProjectesForProjecteID;
  }



  
} // Final de Classe 
