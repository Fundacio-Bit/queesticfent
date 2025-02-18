package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.FestiuJPA;
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
public class FestiuBeanValidator 
      extends AbstractBeanValidator<FestiuJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IFestiuManager __festiuManager;


  public final FestiuValidator<FestiuJPA> _validator;


  public FestiuBeanValidator(org.fundaciobit.queesticfent.model.dao.IFestiuManager __festiuManager) { 
    this.__festiuManager = __festiuManager;
    _validator = new FestiuValidator<FestiuJPA>();
  }

  public FestiuBeanValidator(FestiuValidator<FestiuJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IFestiuManager __festiuManager) {
    this.__festiuManager = __festiuManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(FestiuJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<FestiuJPA> _bvr_ = new BeanValidatorResult<FestiuJPA>();
    _validator.validate(_bvr_, target, isNou, __festiuManager);
    return _bvr_.getErrors();
  }
}
