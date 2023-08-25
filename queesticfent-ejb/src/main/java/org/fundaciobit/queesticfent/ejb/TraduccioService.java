
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.TraduccioJPA;
import org.fundaciobit.queesticfent.persistence.TraduccioIJPAManager;
import org.fundaciobit.queesticfent.model.dao.ITraduccioManager;

import org.fundaciobit.queesticfent.model.entity.Traduccio;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface TraduccioService extends TraduccioIJPAManager,ITraduccioManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/TraduccioEJB!org.fundaciobit.queesticfent.ejb.TraduccioService";

    public TraduccioJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Traduccio instance, FitxerService fitxerEjb) throws I18NException;
}
