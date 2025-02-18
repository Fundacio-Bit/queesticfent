
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Stateless;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.queesticfent.model.entity.UsuariDepartament;
import org.fundaciobit.queesticfent.persistence.UsuariDepartamentJPA;
import org.fundaciobit.queesticfent.persistence.UsuariDepartamentJPAManager;

import org.fundaciobit.queesticfent.commons.utils.Constants;

@Stateless
public class UsuariDepartamentEJB extends UsuariDepartamentJPAManager implements UsuariDepartamentService {

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public void delete(UsuariDepartament instance) {
        super.delete(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public UsuariDepartament create(UsuariDepartament instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public UsuariDepartament update(UsuariDepartament instance) throws I18NException {
         return super.update(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public void deleteIncludingFiles(UsuariDepartament instance,  FitxerService fitxerEjb)
            throws I18NException {

        this.delete(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public UsuariDepartamentJPA findByPrimaryKey(Long _ID_) {
        return (UsuariDepartamentJPA)super.findByPrimaryKey(_ID_);
    }

}
