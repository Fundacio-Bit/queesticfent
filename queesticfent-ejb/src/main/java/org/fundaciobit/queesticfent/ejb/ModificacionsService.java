
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.ModificacionsJPA;
import org.fundaciobit.queesticfent.persistence.ModificacionsIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IModificacionsManager;

import org.fundaciobit.queesticfent.model.entity.Modificacions;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface ModificacionsService extends ModificacionsIJPAManager,IModificacionsManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/ModificacionsEJB!org.fundaciobit.queesticfent.ejb.ModificacionsService";

    public ModificacionsJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Modificacions instance, FitxerService fitxerEjb) throws I18NException;
}
