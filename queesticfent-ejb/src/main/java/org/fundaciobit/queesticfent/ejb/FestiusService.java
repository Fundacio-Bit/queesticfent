
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.FestiusJPA;
import org.fundaciobit.queesticfent.persistence.FestiusIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IFestiusManager;

import org.fundaciobit.queesticfent.model.entity.Festius;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface FestiusService extends FestiusIJPAManager,IFestiusManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/FestiusEJB!org.fundaciobit.queesticfent.ejb.FestiusService";

    public FestiusJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Festius instance, FitxerService fitxerEjb) throws I18NException;
}
