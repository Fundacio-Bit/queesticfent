
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.UsuariJPA;
import org.fundaciobit.queesticfent.persistence.UsuariIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IUsuariManager;

import org.fundaciobit.queesticfent.model.entity.Usuari;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface UsuariService extends UsuariIJPAManager,IUsuariManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/UsuariEJB!org.fundaciobit.queesticfent.ejb.UsuariService";

    public UsuariJPA findByPrimaryKey(String _ID_);

    public void deleteIncludingFiles(Usuari instance, FitxerService fitxerEjb) throws I18NException;
}
