package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.AccioJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class AccioForm extends queesticfentBaseForm {
  
  private AccioJPA accio;
  
  public AccioForm() {
  }
  
  public AccioForm(AccioForm __toClone) {
    super(__toClone);
      this.accio = __toClone.accio;
  }
  
  public AccioForm(AccioJPA accio, boolean nou) {
    super(nou);
    this.accio = accio;
  }
  
  public AccioJPA getAccio() {
    return accio;
  }
  public void setAccio(AccioJPA accio) {
    this.accio = accio;
  }
  
  
  
} // Final de Classe 
