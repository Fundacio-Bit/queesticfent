
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.DepartamentsJPA;
import org.fundaciobit.queesticfent.persistence.DepartamentsIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IDepartamentsManager;

import org.fundaciobit.queesticfent.model.entity.Departaments;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface DepartamentsService extends DepartamentsIJPAManager,IDepartamentsManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/DepartamentsEJB!org.fundaciobit.queesticfent.ejb.DepartamentsService";

    public DepartamentsJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Departaments instance, FitxerService fitxerEjb) throws I18NException;
}
