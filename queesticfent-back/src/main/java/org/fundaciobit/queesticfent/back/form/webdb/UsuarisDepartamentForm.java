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
    this.listOfUsuarisForUsuariId = __toClone.listOfUsuarisForUsuariId;
    this.listOfDepartamentsForDepartamentid = __toClone.listOfDepartamentsForDepartamentid;
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
  
  
  private List<StringKeyValue> listOfUsuarisForUsuariId;

  public List<StringKeyValue> getListOfUsuarisForUsuariId() {
    return this.listOfUsuarisForUsuariId;
  }

  public void setListOfUsuarisForUsuariId(List<StringKeyValue> listOfUsuarisForUsuariId) {
    this.listOfUsuarisForUsuariId = listOfUsuarisForUsuariId;
  }



  private List<StringKeyValue> listOfDepartamentsForDepartamentid;

  public List<StringKeyValue> getListOfDepartamentsForDepartamentid() {
    return this.listOfDepartamentsForDepartamentid;
  }

  public void setListOfDepartamentsForDepartamentid(List<StringKeyValue> listOfDepartamentsForDepartamentid) {
    this.listOfDepartamentsForDepartamentid = listOfDepartamentsForDepartamentid;
  }



  
} // Final de Classe 
