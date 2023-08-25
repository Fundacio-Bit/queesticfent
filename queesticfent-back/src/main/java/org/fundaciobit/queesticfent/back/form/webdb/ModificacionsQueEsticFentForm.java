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
    this.listOfAccionsForAccioid = __toClone.listOfAccionsForAccioid;
    this.listOfProjectesForProjecteid = __toClone.listOfProjectesForProjecteid;
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
