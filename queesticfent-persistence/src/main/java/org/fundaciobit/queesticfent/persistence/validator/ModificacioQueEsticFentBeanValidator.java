package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.ModificacioQueEsticFentJPA;
import org.fundaciobit.genapp.common.validation.BeanValidatorResult;
import java.util.List;
import org.fundaciobit.genapp.common.i18n.I18NFieldError;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.genapp.common.validation.AbstractBeanValidator;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * @author anadal
 */
public class ModificacioQueEsticFentBeanValidator 
      extends AbstractBeanValidator<ModificacioQueEsticFentJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager;

  protected final org.fundaciobit.queesticfent.model.dao.IModificacioQueEsticFentManager __modificacioQueEsticFentManager;

  protected final org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager;


  public final ModificacioQueEsticFentValidator<ModificacioQueEsticFentJPA> _validator;


  public ModificacioQueEsticFentBeanValidator(org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager,
     org.fundaciobit.queesticfent.model.dao.IModificacioQueEsticFentManager __modificacioQueEsticFentManager,
     org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager) { 
    this.__accioManager = __accioManager;
    this.__modificacioQueEsticFentManager = __modificacioQueEsticFentManager;
    this.__projecteManager = __projecteManager;
    _validator = new ModificacioQueEsticFentValidator<ModificacioQueEsticFentJPA>();
  }

  public ModificacioQueEsticFentBeanValidator(ModificacioQueEsticFentValidator<ModificacioQueEsticFentJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager,
     org.fundaciobit.queesticfent.model.dao.IModificacioQueEsticFentManager __modificacioQueEsticFentManager,
     org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager) {
    this.__accioManager = __accioManager;
    this.__modificacioQueEsticFentManager = __modificacioQueEsticFentManager;
    this.__projecteManager = __projecteManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(ModificacioQueEsticFentJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<ModificacioQueEsticFentJPA> _bvr_ = new BeanValidatorResult<ModificacioQueEsticFentJPA>();
    _validator.validate(_bvr_, target, isNou, __accioManager, __modificacioQueEsticFentManager, __projecteManager);
    return _bvr_.getErrors();
  }
}
