package org.fundaciobit.queesticfent.back.form.webdb;

import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.DepartamentJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class DepartamentForm extends queesticfentBaseForm {
  
  private DepartamentJPA departament;
  
  public DepartamentForm() {
  }
  
  public DepartamentForm(DepartamentForm __toClone) {
    super(__toClone);
      this.departament = __toClone.departament;
  }
  
  public DepartamentForm(DepartamentJPA departament, boolean nou) {
    super(nou);
    this.departament = departament;
  }
  
  public DepartamentJPA getDepartament() {
    return departament;
  }
  public void setDepartament(DepartamentJPA departament) {
    this.departament = departament;
  }
  
  
  
} // Final de Classe 
