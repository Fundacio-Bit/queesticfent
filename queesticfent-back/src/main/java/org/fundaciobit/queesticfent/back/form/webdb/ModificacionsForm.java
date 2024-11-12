package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.ModificacionsJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class ModificacionsForm extends queesticfentBaseForm {
  
  private ModificacionsJPA modificacions;
  
  public ModificacionsForm() {
  }
  
  public ModificacionsForm(ModificacionsForm __toClone) {
    super(__toClone);
      this.modificacions = __toClone.modificacions;
    this.listOfEntradesForEntradaid = __toClone.listOfEntradesForEntradaid;
    this.listOfAccionsForAccioid = __toClone.listOfAccionsForAccioid;
    this.listOfProjectesForOldprojecteID = __toClone.listOfProjectesForOldprojecteID;
    this.listOfProjectesForNewprojecteID = __toClone.listOfProjectesForNewprojecteID;
  }
  
  public ModificacionsForm(ModificacionsJPA modificacions, boolean nou) {
    super(nou);
    this.modificacions = modificacions;
  }
  
  public ModificacionsJPA getModificacions() {
    return modificacions;
  }
  public void setModificacions(ModificacionsJPA modificacions) {
    this.modificacions = modificacions;
  }
  
  
  private List<StringKeyValue> listOfEntradesForEntradaid;

  public List<StringKeyValue> getListOfEntradesForEntradaid() {
    return this.listOfEntradesForEntradaid;
  }

  public void setListOfEntradesForEntradaid(List<StringKeyValue> listOfEntradesForEntradaid) {
    this.listOfEntradesForEntradaid = listOfEntradesForEntradaid;
  }



  private List<StringKeyValue> listOfAccionsForAccioid;

  public List<StringKeyValue> getListOfAccionsForAccioid() {
    return this.listOfAccionsForAccioid;
  }

  public void setListOfAccionsForAccioid(List<StringKeyValue> listOfAccionsForAccioid) {
    this.listOfAccionsForAccioid = listOfAccionsForAccioid;
  }



  private List<StringKeyValue> listOfProjectesForOldprojecteID;

  public List<StringKeyValue> getListOfProjectesForOldprojecteID() {
    return this.listOfProjectesForOldprojecteID;
  }

  public void setListOfProjectesForOldprojecteID(List<StringKeyValue> listOfProjectesForOldprojecteID) {
    this.listOfProjectesForOldprojecteID = listOfProjectesForOldprojecteID;
  }



  private List<StringKeyValue> listOfProjectesForNewprojecteID;

  public List<StringKeyValue> getListOfProjectesForNewprojecteID() {
    return this.listOfProjectesForNewprojecteID;
  }

  public void setListOfProjectesForNewprojecteID(List<StringKeyValue> listOfProjectesForNewprojecteID) {
    this.listOfProjectesForNewprojecteID = listOfProjectesForNewprojecteID;
  }



  
} // Final de Classe 
