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
    this.listOfUsuarisForUsuariid = __toClone.listOfUsuarisForUsuariid;
    this.listOfGrupsForGrupid = __toClone.listOfGrupsForGrupid;
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
  
  
  private List<StringKeyValue> listOfUsuarisForUsuariid;

  public List<StringKeyValue> getListOfUsuarisForUsuariid() {
    return this.listOfUsuarisForUsuariid;
  }

  public void setListOfUsuarisForUsuariid(List<StringKeyValue> listOfUsuarisForUsuariid) {
    this.listOfUsuarisForUsuariid = listOfUsuarisForUsuariid;
  }



  private List<StringKeyValue> listOfGrupsForGrupid;

  public List<StringKeyValue> getListOfGrupsForGrupid() {
    return this.listOfGrupsForGrupid;
  }

  public void setListOfGrupsForGrupid(List<StringKeyValue> listOfGrupsForGrupid) {
    this.listOfGrupsForGrupid = listOfGrupsForGrupid;
  }



  
} // Final de Classe 
