package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.ModificacioQueEsticFentJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class ModificacioQueEsticFentForm extends queesticfentBaseForm {
  
  private ModificacioQueEsticFentJPA modificacioQueEsticFent;
  
  public ModificacioQueEsticFentForm() {
  }
  
  public ModificacioQueEsticFentForm(ModificacioQueEsticFentForm __toClone) {
    super(__toClone);
      this.modificacioQueEsticFent = __toClone.modificacioQueEsticFent;
    this.listOfAccioForAccioID = __toClone.listOfAccioForAccioID;
    this.listOfProjecteForProjecteID = __toClone.listOfProjecteForProjecteID;
  }
  
  public ModificacioQueEsticFentForm(ModificacioQueEsticFentJPA modificacioQueEsticFent, boolean nou) {
    super(nou);
    this.modificacioQueEsticFent = modificacioQueEsticFent;
  }
  
  public ModificacioQueEsticFentJPA getModificacioQueEsticFent() {
    return modificacioQueEsticFent;
  }
  public void setModificacioQueEsticFent(ModificacioQueEsticFentJPA modificacioQueEsticFent) {
    this.modificacioQueEsticFent = modificacioQueEsticFent;
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
