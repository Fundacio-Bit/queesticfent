
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.DepartamentJPA;
import org.fundaciobit.queesticfent.persistence.DepartamentIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IDepartamentManager;

import org.fundaciobit.queesticfent.model.entity.Departament;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface DepartamentService extends DepartamentIJPAManager,IDepartamentManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/DepartamentEJB!org.fundaciobit.queesticfent.ejb.DepartamentService";

    public DepartamentJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Departament instance, FitxerService fitxerEjb) throws I18NException;
}
