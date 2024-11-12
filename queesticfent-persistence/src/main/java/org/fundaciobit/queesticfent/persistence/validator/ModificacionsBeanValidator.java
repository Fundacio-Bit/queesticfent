package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.ModificacionsJPA;
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
public class ModificacionsBeanValidator 
      extends AbstractBeanValidator<ModificacionsJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager;

  protected final org.fundaciobit.queesticfent.model.dao.IEntradesManager __entradesManager;

  protected final org.fundaciobit.queesticfent.model.dao.IModificacionsManager __modificacionsManager;

  protected final org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager;


  public final ModificacionsValidator<ModificacionsJPA> _validator;


  public ModificacionsBeanValidator(org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager,
     org.fundaciobit.queesticfent.model.dao.IEntradesManager __entradesManager,
     org.fundaciobit.queesticfent.model.dao.IModificacionsManager __modificacionsManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) { 
    this.__accionsManager = __accionsManager;
    this.__entradesManager = __entradesManager;
    this.__modificacionsManager = __modificacionsManager;
    this.__projectesManager = __projectesManager;
    _validator = new ModificacionsValidator<ModificacionsJPA>();
  }

  public ModificacionsBeanValidator(ModificacionsValidator<ModificacionsJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager,
     org.fundaciobit.queesticfent.model.dao.IEntradesManager __entradesManager,
     org.fundaciobit.queesticfent.model.dao.IModificacionsManager __modificacionsManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {
    this.__accionsManager = __accionsManager;
    this.__entradesManager = __entradesManager;
    this.__modificacionsManager = __modificacionsManager;
    this.__projectesManager = __projectesManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(ModificacionsJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<ModificacionsJPA> _bvr_ = new BeanValidatorResult<ModificacionsJPA>();
    _validator.validate(_bvr_, target, isNou, __accionsManager, __entradesManager, __modificacionsManager, __projectesManager);
    return _bvr_.getErrors();
  }
}
