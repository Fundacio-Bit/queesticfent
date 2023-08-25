package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.PersonalProjecteJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class PersonalProjecteForm extends queesticfentBaseForm {
  
  private PersonalProjecteJPA personalProjecte;
  
  public PersonalProjecteForm() {
  }
  
  public PersonalProjecteForm(PersonalProjecteForm __toClone) {
    super(__toClone);
      this.personalProjecte = __toClone.personalProjecte;
    this.listOfProjectesForProjecteid = __toClone.listOfProjectesForProjecteid;
  }
  
  public PersonalProjecteForm(PersonalProjecteJPA personalProjecte, boolean nou) {
    super(nou);
    this.personalProjecte = personalProjecte;
  }
  
  public PersonalProjecteJPA getPersonalProjecte() {
    return personalProjecte;
  }
  public void setPersonalProjecte(PersonalProjecteJPA personalProjecte) {
    this.personalProjecte = personalProjecte;
  }
  
  
  private List<StringKeyValue> listOfProjectesForProjecteid;

  public List<StringKeyValue> getListOfProjectesForProjecteid() {
    return this.listOfProjectesForProjecteid;
  }

  public void setListOfProjectesForProjecteid(List<StringKeyValue> listOfProjectesForProjecteid) {
    this.listOfProjectesForProjecteid = listOfProjectesForProjecteid;
  }



  
} // Final de Classe 
