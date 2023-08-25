package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.AccionsJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class AccionsForm extends queesticfentBaseForm {
  
  private AccionsJPA accions;
  
  public AccionsForm() {
  }
  
  public AccionsForm(AccionsForm __toClone) {
    super(__toClone);
      this.accions = __toClone.accions;
  }
  
  public AccionsForm(AccionsJPA accions, boolean nou) {
    super(nou);
    this.accions = accions;
  }
  
  public AccionsJPA getAccions() {
    return accions;
  }
  public void setAccions(AccionsJPA accions) {
    this.accions = accions;
  }
  
  
  
} // Final de Classe 
