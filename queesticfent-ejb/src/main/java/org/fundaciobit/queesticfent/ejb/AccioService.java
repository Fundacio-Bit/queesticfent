
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.AccioJPA;
import org.fundaciobit.queesticfent.persistence.AccioIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IAccioManager;

import org.fundaciobit.queesticfent.model.entity.Accio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface AccioService extends AccioIJPAManager,IAccioManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/AccioEJB!org.fundaciobit.queesticfent.ejb.AccioService";

    public AccioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Accio instance, FitxerService fitxerEjb) throws I18NException;
}
