
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.UsuarisJPA;
import org.fundaciobit.queesticfent.persistence.UsuarisIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IUsuarisManager;

import org.fundaciobit.queesticfent.model.entity.Usuaris;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface UsuarisService extends UsuarisIJPAManager,IUsuarisManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/UsuarisEJB!org.fundaciobit.queesticfent.ejb.UsuarisService";

    public UsuarisJPA findByPrimaryKey(String _ID_);

    public void deleteIncludingFiles(Usuaris instance, FitxerService fitxerEjb) throws I18NException;
}
