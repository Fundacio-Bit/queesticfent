
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Stateless;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.queesticfent.model.entity.UsuarisDepartament;
import org.fundaciobit.queesticfent.persistence.UsuarisDepartamentJPA;
import org.fundaciobit.queesticfent.persistence.UsuarisDepartamentJPAManager;

import org.fundaciobit.queesticfent.commons.utils.Constants;

@Stateless
public class UsuarisDepartamentEJB extends UsuarisDepartamentJPAManager implements UsuarisDepartamentService {

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public void delete(UsuarisDepartament instance) {
        super.delete(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public UsuarisDepartament create(UsuarisDepartament instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public UsuarisDepartament update(UsuarisDepartament instance) throws I18NException {
         return super.update(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public void deleteIncludingFiles(UsuarisDepartament instance,  FitxerService fitxerEjb)
            throws I18NException {

        this.delete(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public UsuarisDepartamentJPA findByPrimaryKey(Long _ID_) {
        return (UsuarisDepartamentJPA)super.findByPrimaryKey(_ID_);
    }

}
