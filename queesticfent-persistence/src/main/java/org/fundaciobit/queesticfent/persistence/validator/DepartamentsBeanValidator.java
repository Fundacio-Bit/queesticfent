package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.DepartamentsJPA;
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
public class DepartamentsBeanValidator 
      extends AbstractBeanValidator<DepartamentsJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager;


  public final DepartamentsValidator<DepartamentsJPA> _validator;


  public DepartamentsBeanValidator(org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager) { 
    this.__departamentsManager = __departamentsManager;
    _validator = new DepartamentsValidator<DepartamentsJPA>();
  }

  public DepartamentsBeanValidator(DepartamentsValidator<DepartamentsJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager) {
    this.__departamentsManager = __departamentsManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(DepartamentsJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<DepartamentsJPA> _bvr_ = new BeanValidatorResult<DepartamentsJPA>();
    _validator.validate(_bvr_, target, isNou, __departamentsManager);
    return _bvr_.getErrors();
  }
}
