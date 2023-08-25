
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.FitxerJPA;
import org.fundaciobit.queesticfent.persistence.FitxerIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IFitxerManager;

import org.fundaciobit.queesticfent.model.entity.Fitxer;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface FitxerService extends FitxerIJPAManager,IFitxerManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/FitxerEJB!org.fundaciobit.queesticfent.ejb.FitxerService";

    public FitxerJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Fitxer instance, FitxerService fitxerEjb) throws I18NException;
}
