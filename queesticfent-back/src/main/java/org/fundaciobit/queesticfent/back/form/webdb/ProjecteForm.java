package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.ProjecteJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class ProjecteForm extends queesticfentBaseForm {
  
  private ProjecteJPA projecte;
  
  public ProjecteForm() {
  }
  
  public ProjecteForm(ProjecteForm __toClone) {
    super(__toClone);
      this.projecte = __toClone.projecte;
    this.listOfDepartamentForDepartamentID = __toClone.listOfDepartamentForDepartamentID;
  }
  
  public ProjecteForm(ProjecteJPA projecte, boolean nou) {
    super(nou);
    this.projecte = projecte;
  }
  
  public ProjecteJPA getProjecte() {
    return projecte;
  }
  public void setProjecte(ProjecteJPA projecte) {
    this.projecte = projecte;
  }
  
  
  private List<StringKeyValue> listOfDepartamentForDepartamentID;

  public List<StringKeyValue> getListOfDepartamentForDepartamentID() {
    return this.listOfDepartamentForDepartamentID;
  }

  public void setListOfDepartamentForDepartamentID(List<StringKeyValue> listOfDepartamentForDepartamentID) {
    this.listOfDepartamentForDepartamentID = listOfDepartamentForDepartamentID;
  }



  
} // Final de Classe 
