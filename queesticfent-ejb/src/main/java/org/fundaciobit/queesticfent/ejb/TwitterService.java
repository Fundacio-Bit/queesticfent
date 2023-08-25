
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.TwitterJPA;
import org.fundaciobit.queesticfent.persistence.TwitterIJPAManager;
import org.fundaciobit.queesticfent.model.dao.ITwitterManager;

import org.fundaciobit.queesticfent.model.entity.Twitter;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface TwitterService extends TwitterIJPAManager,ITwitterManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/TwitterEJB!org.fundaciobit.queesticfent.ejb.TwitterService";

    public TwitterJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Twitter instance, FitxerService fitxerEjb) throws I18NException;
}
