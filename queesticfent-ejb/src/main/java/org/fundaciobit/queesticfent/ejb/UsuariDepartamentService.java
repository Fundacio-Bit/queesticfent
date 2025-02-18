
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Local;

import org.fundaciobit.queesticfent.persistence.UsuariDepartamentJPA;
import org.fundaciobit.queesticfent.persistence.UsuariDepartamentIJPAManager;
import org.fundaciobit.queesticfent.model.dao.IUsuariDepartamentManager;

import org.fundaciobit.queesticfent.model.entity.UsuariDepartament;
import org.fundaciobit.genapp.common.i18n.I18NException;

@Local
public interface UsuariDepartamentService extends UsuariDepartamentIJPAManager,IUsuariDepartamentManager {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/UsuariDepartamentEJB!org.fundaciobit.queesticfent.ejb.UsuariDepartamentService";

    public UsuariDepartamentJPA findByPrimaryKey(Long _ID_);

    public void deleteIncludingFiles(UsuariDepartament instance, FitxerService fitxerEjb) throws I18NException;
}
