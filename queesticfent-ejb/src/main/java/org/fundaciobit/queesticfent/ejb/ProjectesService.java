
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.ProjectesJPA;
import org.fundaciobit.queesticfent.persistence.ProjectesIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IProjectesManager;

import org.fundaciobit.queesticfent.model.entity.Projectes;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface ProjectesService extends ProjectesIJPAManager,IProjectesManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/ProjectesEJB!org.fundaciobit.queesticfent.ejb.ProjectesService";

    public ProjectesJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Projectes instance, FitxerService fitxerEjb) throws I18NException;
}
