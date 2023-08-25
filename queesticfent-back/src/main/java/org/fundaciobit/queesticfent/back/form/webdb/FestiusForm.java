package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.FestiusJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class FestiusForm extends queesticfentBaseForm {
  
  private FestiusJPA festius;
  
  public FestiusForm() {
  }
  
  public FestiusForm(FestiusForm __toClone) {
    super(__toClone);
      this.festius = __toClone.festius;
  }
  
  public FestiusForm(FestiusJPA festius, boolean nou) {
    super(nou);
    this.festius = festius;
  }
  
  public FestiusJPA getFestius() {
    return festius;
  }
  public void setFestius(FestiusJPA festius) {
    this.festius = festius;
  }
  
  
  
} // Final de Classe 
