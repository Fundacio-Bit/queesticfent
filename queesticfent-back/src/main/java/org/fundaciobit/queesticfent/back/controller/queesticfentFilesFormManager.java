package org.fundaciobit.queesticfent.back.controller;

import org.fundaciobit.queesticfent.persistence.FitxerJPA;
import org.fundaciobit.queesticfent.model.entity.Fitxer;

import org.fundaciobit.genapp.common.filesystem.IFileManager;
import org.fundaciobit.genapp.common.web.controller.FilesFormManager;


/**
 * Gestiona Multiples Fitxers d'un Form
 * 
 * @author anadal
 * 
 */
public class queesticfentFilesFormManager extends FilesFormManager<Fitxer> {

  public queesticfentFilesFormManager(IFileManager<Fitxer> fitxerEjb) {
    super(fitxerEjb);
  }

  @Override
  public FitxerJPA createEmptyFile() {    
    return new FitxerJPA();
  }

}
