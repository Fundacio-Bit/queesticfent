package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.FestiusJPA;
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
public class FestiusBeanValidator 
      extends AbstractBeanValidator<FestiusJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IFestiusManager __festiusManager;


  public final FestiusValidator<FestiusJPA> _validator;


  public FestiusBeanValidator(org.fundaciobit.queesticfent.model.dao.IFestiusManager __festiusManager) { 
    this.__festiusManager = __festiusManager;
    _validator = new FestiusValidator<FestiusJPA>();
  }

  public FestiusBeanValidator(FestiusValidator<FestiusJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IFestiusManager __festiusManager) {
    this.__festiusManager = __festiusManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(FestiusJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<FestiusJPA> _bvr_ = new BeanValidatorResult<FestiusJPA>();
    _validator.validate(_bvr_, target, isNou, __festiusManager);
    return _bvr_.getErrors();
  }
}
