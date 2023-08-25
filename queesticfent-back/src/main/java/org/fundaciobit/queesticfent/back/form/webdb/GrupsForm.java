package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.GrupsJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class GrupsForm extends queesticfentBaseForm {
  
  private GrupsJPA grups;
  
  public GrupsForm() {
  }
  
  public GrupsForm(GrupsForm __toClone) {
    super(__toClone);
      this.grups = __toClone.grups;
  }
  
  public GrupsForm(GrupsJPA grups, boolean nou) {
    super(nou);
    this.grups = grups;
  }
  
  public GrupsJPA getGrups() {
    return grups;
  }
  public void setGrups(GrupsJPA grups) {
    this.grups = grups;
  }
  
  
  
} // Final de Classe 
