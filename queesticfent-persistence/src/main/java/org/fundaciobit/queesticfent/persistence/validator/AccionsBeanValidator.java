package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.AccionsJPA;
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
public class AccionsBeanValidator 
      extends AbstractBeanValidator<AccionsJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager;


  public final AccionsValidator<AccionsJPA> _validator;


  public AccionsBeanValidator(org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager) { 
    this.__accionsManager = __accionsManager;
    _validator = new AccionsValidator<AccionsJPA>();
  }

  public AccionsBeanValidator(AccionsValidator<AccionsJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IAccionsManager __accionsManager) {
    this.__accionsManager = __accionsManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(AccionsJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<AccionsJPA> _bvr_ = new BeanValidatorResult<AccionsJPA>();
    _validator.validate(_bvr_, target, isNou, __accionsManager);
    return _bvr_.getErrors();
  }
}
