package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.DepartamentsJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class DepartamentsForm extends queesticfentBaseForm {
  
  private DepartamentsJPA departaments;
  
  public DepartamentsForm() {
  }
  
  public DepartamentsForm(DepartamentsForm __toClone) {
    super(__toClone);
      this.departaments = __toClone.departaments;
  }
  
  public DepartamentsForm(DepartamentsJPA departaments, boolean nou) {
    super(nou);
    this.departaments = departaments;
  }
  
  public DepartamentsJPA getDepartaments() {
    return departaments;
  }
  public void setDepartaments(DepartamentsJPA departaments) {
    this.departaments = departaments;
  }
  
  
  
} // Final de Classe 
