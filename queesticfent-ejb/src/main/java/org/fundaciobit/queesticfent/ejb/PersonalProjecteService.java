
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.PersonalProjecteJPA;
import org.fundaciobit.queesticfent.persistence.PersonalProjecteIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IPersonalProjecteManager;

import org.fundaciobit.queesticfent.model.entity.PersonalProjecte;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface PersonalProjecteService extends PersonalProjecteIJPAManager,IPersonalProjecteManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/PersonalProjecteEJB!org.fundaciobit.queesticfent.ejb.PersonalProjecteService";

    public PersonalProjecteJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(PersonalProjecte instance, FitxerService fitxerEjb) throws I18NException;
}
