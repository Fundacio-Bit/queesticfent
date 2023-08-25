
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentJPA;
import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IModificacionsQueEsticFentManager;

import org.fundaciobit.queesticfent.model.entity.ModificacionsQueEsticFent;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface ModificacionsQueEsticFentService extends ModificacionsQueEsticFentIJPAManager,IModificacionsQueEsticFentManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/ModificacionsQueEsticFentEJB!org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService";

    public ModificacionsQueEsticFentJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(ModificacionsQueEsticFent instance, FitxerService fitxerEjb) throws I18NException;
}
