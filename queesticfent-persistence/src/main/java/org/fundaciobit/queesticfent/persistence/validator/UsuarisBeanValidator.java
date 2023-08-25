package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.UsuarisJPA;
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
public class UsuarisBeanValidator 
      extends AbstractBeanValidator<UsuarisJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager;


  public final UsuarisValidator<UsuarisJPA> _validator;


  public UsuarisBeanValidator(org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager) { 
    this.__usuarisManager = __usuarisManager;
    _validator = new UsuarisValidator<UsuarisJPA>();
  }

  public UsuarisBeanValidator(UsuarisValidator<UsuarisJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager) {
    this.__usuarisManager = __usuarisManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(UsuarisJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<UsuarisJPA> _bvr_ = new BeanValidatorResult<UsuarisJPA>();
    _validator.validate(_bvr_, target, isNou, __usuarisManager);
    return _bvr_.getErrors();
  }
}
