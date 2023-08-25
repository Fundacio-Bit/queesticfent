
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.GrupsJPA;
import org.fundaciobit.queesticfent.persistence.GrupsIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IGrupsManager;

import org.fundaciobit.queesticfent.model.entity.Grups;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface GrupsService extends GrupsIJPAManager,IGrupsManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/GrupsEJB!org.fundaciobit.queesticfent.ejb.GrupsService";

    public GrupsJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Grups instance, FitxerService fitxerEjb) throws I18NException;
}
