package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.EntradaJPA;
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
public class EntradaBeanValidator 
      extends AbstractBeanValidator<EntradaJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager;

  protected final org.fundaciobit.queesticfent.model.dao.IEntradaManager __entradaManager;

  protected final org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager;


  public final EntradaValidator<EntradaJPA> _validator;


  public EntradaBeanValidator(org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager,
     org.fundaciobit.queesticfent.model.dao.IEntradaManager __entradaManager,
     org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager) { 
    this.__accioManager = __accioManager;
    this.__entradaManager = __entradaManager;
    this.__projecteManager = __projecteManager;
    _validator = new EntradaValidator<EntradaJPA>();
  }

  public EntradaBeanValidator(EntradaValidator<EntradaJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager,
     org.fundaciobit.queesticfent.model.dao.IEntradaManager __entradaManager,
     org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager) {
    this.__accioManager = __accioManager;
    this.__entradaManager = __entradaManager;
    this.__projecteManager = __projecteManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(EntradaJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<EntradaJPA> _bvr_ = new BeanValidatorResult<EntradaJPA>();
    _validator.validate(_bvr_, target, isNou, __accioManager, __entradaManager, __projecteManager);
    return _bvr_.getErrors();
  }
}
