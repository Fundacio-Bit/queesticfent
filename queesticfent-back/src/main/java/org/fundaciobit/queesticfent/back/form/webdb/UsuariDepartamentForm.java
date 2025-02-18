package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.UsuariDepartamentJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class UsuariDepartamentForm extends queesticfentBaseForm {
  
  private UsuariDepartamentJPA usuariDepartament;
  
  public UsuariDepartamentForm() {
  }
  
  public UsuariDepartamentForm(UsuariDepartamentForm __toClone) {
    super(__toClone);
      this.usuariDepartament = __toClone.usuariDepartament;
    this.listOfUsuariForUsuariID = __toClone.listOfUsuariForUsuariID;
    this.listOfDepartamentForDepartamentID = __toClone.listOfDepartamentForDepartamentID;
  }
  
  public UsuariDepartamentForm(UsuariDepartamentJPA usuariDepartament, boolean nou) {
    super(nou);
    this.usuariDepartament = usuariDepartament;
  }
  
  public UsuariDepartamentJPA getUsuariDepartament() {
    return usuariDepartament;
  }
  public void setUsuariDepartament(UsuariDepartamentJPA usuariDepartament) {
    this.usuariDepartament = usuariDepartament;
  }
  
  
  private List<StringKeyValue> listOfUsuariForUsuariID;

  public List<StringKeyValue> getListOfUsuariForUsuariID() {
    return this.listOfUsuariForUsuariID;
  }

  public void setListOfUsuariForUsuariID(List<StringKeyValue> listOfUsuariForUsuariID) {
    this.listOfUsuariForUsuariID = listOfUsuariForUsuariID;
  }



  private List<StringKeyValue> listOfDepartamentForDepartamentID;

  public List<StringKeyValue> getListOfDepartamentForDepartamentID() {
    return this.listOfDepartamentForDepartamentID;
  }

  public void setListOfDepartamentForDepartamentID(List<StringKeyValue> listOfDepartamentForDepartamentID) {
    this.listOfDepartamentForDepartamentID = listOfDepartamentForDepartamentID;
  }



  
} // Final de Classe 
