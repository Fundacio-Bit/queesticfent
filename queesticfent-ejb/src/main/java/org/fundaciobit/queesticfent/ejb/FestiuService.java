
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.FestiuJPA;
import org.fundaciobit.queesticfent.persistence.FestiuIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IFestiuManager;

import org.fundaciobit.queesticfent.model.entity.Festiu;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface FestiuService extends FestiuIJPAManager,IFestiuManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/FestiuEJB!org.fundaciobit.queesticfent.ejb.FestiuService";

    public FestiuJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(Festiu instance, FitxerService fitxerEjb) throws I18NException;
}
