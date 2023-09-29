package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.UsuarisDepartamentJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class UsuarisDepartamentForm extends queesticfentBaseForm {
  
  private UsuarisDepartamentJPA usuarisDepartament;
  
  public UsuarisDepartamentForm() {
  }
  
  public UsuarisDepartamentForm(UsuarisDepartamentForm __toClone) {
    super(__toClone);
      this.usuarisDepartament = __toClone.usuarisDepartament;
    this.listOfUsuarisForUsuariID = __toClone.listOfUsuarisForUsuariID;
    this.listOfDepartamentsForDepartamentID = __toClone.listOfDepartamentsForDepartamentID;
  }
  
  public UsuarisDepartamentForm(UsuarisDepartamentJPA usuarisDepartament, boolean nou) {
    super(nou);
    this.usuarisDepartament = usuarisDepartament;
  }
  
  public UsuarisDepartamentJPA getUsuarisDepartament() {
    return usuarisDepartament;
  }
  public void setUsuarisDepartament(UsuarisDepartamentJPA usuarisDepartament) {
    this.usuarisDepartament = usuarisDepartament;
  }
  
  
  private List<StringKeyValue> listOfUsuarisForUsuariID;

  public List<StringKeyValue> getListOfUsuarisForUsuariID() {
    return this.listOfUsuarisForUsuariID;
  }

  public void setListOfUsuarisForUsuariID(List<StringKeyValue> listOfUsuarisForUsuariID) {
    this.listOfUsuarisForUsuariID = listOfUsuarisForUsuariID;
  }



  private List<StringKeyValue> listOfDepartamentsForDepartamentID;

  public List<StringKeyValue> getListOfDepartamentsForDepartamentID() {
    return this.listOfDepartamentsForDepartamentID;
  }

  public void setListOfDepartamentsForDepartamentID(List<StringKeyValue> listOfDepartamentsForDepartamentID) {
    this.listOfDepartamentsForDepartamentID = listOfDepartamentsForDepartamentID;
  }



  
} // Final de Classe 
