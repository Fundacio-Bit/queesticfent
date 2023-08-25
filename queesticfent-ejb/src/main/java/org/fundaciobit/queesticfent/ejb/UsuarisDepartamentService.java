
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.UsuarisDepartamentJPA;
import org.fundaciobit.queesticfent.persistence.UsuarisDepartamentIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IUsuarisDepartamentManager;

import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface UsuarisDepartamentService extends UsuarisDepartamentIJPAManager,IUsuarisDepartamentManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/UsuarisDepartamentEJB!org.fundaciobit.queesticfent.ejb.UsuarisDepartamentService";

    public UsuarisDepartamentJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(UsuarisDepartament instance, FitxerService fitxerEjb) throws I18NException;
}
