package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.EntradesJPA;
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
public class EntradesBeanValidator 
      extends AbstractBeanValidator<EntradesJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager;

  protected final org.fundaciobit.queesticfent.model.dao.IEntradesManager __entradesManager;

  protected final org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager;


  public final EntradesValidator<EntradesJPA> _validator;


  public EntradesBeanValidator(org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager,
     org.fundaciobit.queesticfent.model.dao.IEntradesManager __entradesManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) { 
    this.__accionsManager = __accionsManager;
    this.__entradesManager = __entradesManager;
    this.__projectesManager = __projectesManager;
    _validator = new EntradesValidator<EntradesJPA>();
  }

  public EntradesBeanValidator(EntradesValidator<EntradesJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager,
     org.fundaciobit.queesticfent.model.dao.IEntradesManager __entradesManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {
    this.__accionsManager = __accionsManager;
    this.__entradesManager = __entradesManager;
    this.__projectesManager = __projectesManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(EntradesJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<EntradesJPA> _bvr_ = new BeanValidatorResult<EntradesJPA>();
    _validator.validate(_bvr_, target, isNou, __accionsManager, __entradesManager, __projectesManager);
    return _bvr_.getErrors();
  }
}
