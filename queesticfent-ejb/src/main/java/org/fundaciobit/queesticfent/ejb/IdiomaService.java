
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.IdiomaJPA;
import org.fundaciobit.queesticfent.persistence.IdiomaIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IIdiomaManager;

import org.fundaciobit.queesticfent.model.entity.Idioma;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface IdiomaService extends IdiomaIJPAManager,IIdiomaManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/IdiomaEJB!org.fundaciobit.queesticfent.ejb.IdiomaService";

    public IdiomaJPA findByPrimaryKey(String _ID_);

    public void deleteIncludingFiles(Idioma instance, FitxerService fitxerEjb) throws I18NException;
}
