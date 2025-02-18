package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.FestiuJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class FestiuForm extends queesticfentBaseForm {
  
  private FestiuJPA festiu;
  
  public FestiuForm() {
  }
  
  public FestiuForm(FestiuForm __toClone) {
    super(__toClone);
      this.festiu = __toClone.festiu;
  }
  
  public FestiuForm(FestiuJPA festiu, boolean nou) {
    super(nou);
    this.festiu = festiu;
  }
  
  public FestiuJPA getFestiu() {
    return festiu;
  }
  public void setFestiu(FestiuJPA festiu) {
    this.festiu = festiu;
  }
  
  
  
} // Final de Classe 
