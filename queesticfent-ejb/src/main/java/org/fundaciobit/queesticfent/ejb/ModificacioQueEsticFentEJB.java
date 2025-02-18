
package org.fundaciobit.queesticfent.ejb;

// NO MODIFICAR - DO NOT MODIFY;
import javax.ejb.Stateless;
import javax.annotation.security.RolesAllowed;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.queesticfent.model.entity.ModificacioQueEsticFent;
import org.fundaciobit.queesticfent.persistence.ModificacioQueEsticFentJPA;
import org.fundaciobit.queesticfent.persistence.ModificacioQueEsticFentJPAManager;

import org.fundaciobit.queesticfent.commons.utils.Constants;

@Stateless
public class ModificacioQueEsticFentEJB extends ModificacioQueEsticFentJPAManager implements ModificacioQueEsticFentService {

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public void delete(ModificacioQueEsticFent instance) {
        super.delete(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public ModificacioQueEsticFent create(ModificacioQueEsticFent instance) throws I18NException {
        return super.create(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public ModificacioQueEsticFent update(ModificacioQueEsticFent instance) throws I18NException {
         return super.update(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public void deleteIncludingFiles(ModificacioQueEsticFent instance,  FitxerService fitxerEjb)
            throws I18NException {

        this.delete(instance);
    }

    @Override
    @RolesAllowed({Constants.ROLE_EJB_FULL_ACCESS, Constants.ROLE_EJB_BASIC_ACCESS, Constants.ROLE_EJB_WS_ACCESS})
    public ModificacioQueEsticFentJPA findByPrimaryKey(Long _ID_) {
        return (ModificacioQueEsticFentJPA)super.findByPrimaryKey(_ID_);
    }

}
