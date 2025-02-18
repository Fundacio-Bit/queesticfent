
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.ProjecteJPA;
import org.fundaciobit.queesticfent.persistence.ProjecteIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IProjecteManager;

import org.fundaciobit.queesticfent.model.entity.Projecte;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface ProjecteService extends ProjecteIJPAManager,IProjecteManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/ProjecteEJB!org.fundaciobit.queesticfent.ejb.ProjecteService";

    public ProjecteJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Projecte instance, FitxerService fitxerEjb) throws I18NException;
}
