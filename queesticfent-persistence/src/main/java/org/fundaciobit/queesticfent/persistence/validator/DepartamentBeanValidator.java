package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.DepartamentJPA;
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
public class DepartamentBeanValidator 
      extends AbstractBeanValidator<DepartamentJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager;


  public final DepartamentValidator<DepartamentJPA> _validator;


  public DepartamentBeanValidator(org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager) { 
    this.__departamentManager = __departamentManager;
    _validator = new DepartamentValidator<DepartamentJPA>();
  }

  public DepartamentBeanValidator(DepartamentValidator<DepartamentJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager) {
    this.__departamentManager = __departamentManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(DepartamentJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<DepartamentJPA> _bvr_ = new BeanValidatorResult<DepartamentJPA>();
    _validator.validate(_bvr_, target, isNou, __departamentManager);
    return _bvr_.getErrors();
  }
}
