
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.AccionsJPA;
import org.fundaciobit.queesticfent.persistence.AccionsIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IAccionsManager;

import org.fundaciobit.queesticfent.model.entity.Accions;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface AccionsService extends AccionsIJPAManager,IAccionsManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/AccionsEJB!org.fundaciobit.queesticfent.ejb.AccionsService";

    public AccionsJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Accions instance, FitxerService fitxerEjb) throws I18NException;
}
