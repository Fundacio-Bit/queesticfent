package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.GrupsusuariJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class GrupsusuariForm extends queesticfentBaseForm {
  
  private GrupsusuariJPA grupsusuari;
  
  public GrupsusuariForm() {
  }
  
  public GrupsusuariForm(GrupsusuariForm __toClone) {
    super(__toClone);
      this.grupsusuari = __toClone.grupsusuari;
    this.listOfUsuarisForUsuariID = __toClone.listOfUsuarisForUsuariID;
    this.listOfGrupsForGrupID = __toClone.listOfGrupsForGrupID;
  }
  
  public GrupsusuariForm(GrupsusuariJPA grupsusuari, boolean nou) {
    super(nou);
    this.grupsusuari = grupsusuari;
  }
  
  public GrupsusuariJPA getGrupsusuari() {
    return grupsusuari;
  }
  public void setGrupsusuari(GrupsusuariJPA grupsusuari) {
    this.grupsusuari = grupsusuari;
  }
  
  
  private List<StringKeyValue> listOfUsuarisForUsuariID;

  public List<StringKeyValue> getListOfUsuarisForUsuariID() {
    return this.listOfUsuarisForUsuariID;
  }

  public void setListOfUsuarisForUsuariID(List<StringKeyValue> listOfUsuarisForUsuariID) {
    this.listOfUsuarisForUsuariID = listOfUsuarisForUsuariID;
  }



  private List<StringKeyValue> listOfGrupsForGrupID;

  public List<StringKeyValue> getListOfGrupsForGrupID() {
    return this.listOfGrupsForGrupID;
  }

  public void setListOfGrupsForGrupID(List<StringKeyValue> listOfGrupsForGrupID) {
    this.listOfGrupsForGrupID = listOfGrupsForGrupID;
  }



  
} // Final de Classe 
