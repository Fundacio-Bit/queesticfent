package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.ModificacionsQueEsticFentJPA;
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
public class ModificacionsQueEsticFentBeanValidator 
      extends AbstractBeanValidator<ModificacionsQueEsticFentJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager;

  protected final org.fundaciobit.queesticfent.model.dao.IModificacionsQueEsticFentManager __modificacionsQueEsticFentManager;

  protected final org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager;


  public final ModificacionsQueEsticFentValidator<ModificacionsQueEsticFentJPA> _validator;


  public ModificacionsQueEsticFentBeanValidator(org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager,
     org.fundaciobit.queesticfent.model.dao.IModificacionsQueEsticFentManager __modificacionsQueEsticFentManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) { 
    this.__accionsManager = __accionsManager;
    this.__modificacionsQueEsticFentManager = __modificacionsQueEsticFentManager;
    this.__projectesManager = __projectesManager;
    _validator = new ModificacionsQueEsticFentValidator<ModificacionsQueEsticFentJPA>();
  }

  public ModificacionsQueEsticFentBeanValidator(ModificacionsQueEsticFentValidator<ModificacionsQueEsticFentJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager,
     org.fundaciobit.queesticfent.model.dao.IModificacionsQueEsticFentManager __modificacionsQueEsticFentManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {
    this.__accionsManager = __accionsManager;
    this.__modificacionsQueEsticFentManager = __modificacionsQueEsticFentManager;
    this.__projectesManager = __projectesManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(ModificacionsQueEsticFentJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<ModificacionsQueEsticFentJPA> _bvr_ = new BeanValidatorResult<ModificacionsQueEsticFentJPA>();
    _validator.validate(_bvr_, target, isNou, __accionsManager, __modificacionsQueEsticFentManager, __projectesManager);
    return _bvr_.getErrors();
  }
}
