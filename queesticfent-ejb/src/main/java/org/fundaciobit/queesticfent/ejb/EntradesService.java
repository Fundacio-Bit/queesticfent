
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.EntradesJPA;
import org.fundaciobit.queesticfent.persistence.EntradesIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IEntradesManager;

import org.fundaciobit.queesticfent.model.entity.Entrades;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EntradesService extends EntradesIJPAManager,IEntradesManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/EntradesEJB!org.fundaciobit.queesticfent.ejb.EntradesService";

    public EntradesJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Entrades instance, FitxerService fitxerEjb) throws I18NException;
}
