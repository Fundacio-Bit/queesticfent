
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.ModificacioQueEsticFentJPA;
import org.fundaciobit.queesticfent.persistence.ModificacioQueEsticFentIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IModificacioQueEsticFentManager;

import org.fundaciobit.queesticfent.model.entity.ModificacioQueEsticFent;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface ModificacioQueEsticFentService extends ModificacioQueEsticFentIJPAManager,IModificacioQueEsticFentManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/ModificacioQueEsticFentEJB!org.fundaciobit.queesticfent.ejb.ModificacioQueEsticFentService";

    public ModificacioQueEsticFentJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(ModificacioQueEsticFent instance, FitxerService fitxerEjb) throws I18NException;
}
