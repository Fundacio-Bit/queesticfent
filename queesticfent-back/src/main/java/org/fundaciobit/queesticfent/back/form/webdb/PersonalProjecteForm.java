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
    this.listOfProjectesForProjecteID = __toClone.listOfProjectesForProjecteID;
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
  
  
  private List<StringKeyValue> listOfProjectesForProjecteID;

  public List<StringKeyValue> getListOfProjectesForProjecteID() {
    return this.listOfProjectesForProjecteID;
  }

  public void setListOfProjectesForProjecteID(List<StringKeyValue> listOfProjectesForProjecteID) {
    this.listOfProjectesForProjecteID = listOfProjectesForProjecteID;
  }



  
} // Final de Classe 
