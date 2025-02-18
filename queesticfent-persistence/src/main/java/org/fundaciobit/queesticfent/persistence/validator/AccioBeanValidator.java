package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.AccioJPA;
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
public class AccioBeanValidator 
      extends AbstractBeanValidator<AccioJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager;


  public final AccioValidator<AccioJPA> _validator;


  public AccioBeanValidator(org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager) { 
    this.__accioManager = __accioManager;
    _validator = new AccioValidator<AccioJPA>();
  }

  public AccioBeanValidator(AccioValidator<AccioJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IAccioManager __accioManager) {
    this.__accioManager = __accioManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(AccioJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<AccioJPA> _bvr_ = new BeanValidatorResult<AccioJPA>();
    _validator.validate(_bvr_, target, isNou, __accioManager);
    return _bvr_.getErrors();
  }
}
