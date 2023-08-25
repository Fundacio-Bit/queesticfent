package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.queesticfent.back.form.queesticfentBaseForm;
import org.fundaciobit.queesticfent.persistence.ProjectesJPA;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * Created by GenApp. Do not modify.
 */
public class ProjectesForm extends queesticfentBaseForm {
  
  private ProjectesJPA projectes;
  
  public ProjectesForm() {
  }
  
  public ProjectesForm(ProjectesForm __toClone) {
    super(__toClone);
      this.projectes = __toClone.projectes;
    this.listOfDepartamentsForDepartamentid = __toClone.listOfDepartamentsForDepartamentid;
  }
  
  public ProjectesForm(ProjectesJPA projectes, boolean nou) {
    super(nou);
    this.projectes = projectes;
  }
  
  public ProjectesJPA getProjectes() {
    return projectes;
  }
  public void setProjectes(ProjectesJPA projectes) {
    this.projectes = projectes;
  }
  
  
  private List<StringKeyValue> listOfDepartamentsForDepartamentid;

  public List<StringKeyValue> getListOfDepartamentsForDepartamentid() {
    return this.listOfDepartamentsForDepartamentid;
  }

  public void setListOfDepartamentsForDepartamentid(List<StringKeyValue> listOfDepartamentsForDepartamentid) {
    this.listOfDepartamentsForDepartamentid = listOfDepartamentsForDepartamentid;
  }



  
} // Final de Classe 
