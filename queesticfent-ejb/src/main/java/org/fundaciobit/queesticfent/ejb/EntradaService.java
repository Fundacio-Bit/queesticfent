
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.EntradaJPA;
import org.fundaciobit.queesticfent.persistence.EntradaIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IEntradaManager;

import org.fundaciobit.queesticfent.model.entity.Entrada;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface EntradaService extends EntradaIJPAManager,IEntradaManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/EntradaEJB!org.fundaciobit.queesticfent.ejb.EntradaService";

    public EntradaJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Entrada instance, FitxerService fitxerEjb) throws I18NException;
}
