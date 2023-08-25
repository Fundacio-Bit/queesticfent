
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.GrupsusuariJPA;
import org.fundaciobit.queesticfent.persistence.GrupsusuariIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IGrupsusuariManager;

import org.fundaciobit.queesticfent.model.entity.Grupsusuari;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface GrupsusuariService extends GrupsusuariIJPAManager,IGrupsusuariManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/GrupsusuariEJB!org.fundaciobit.queesticfent.ejb.GrupsusuariService";

    public GrupsusuariJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Grupsusuari instance, FitxerService fitxerEjb) throws I18NException;
}
