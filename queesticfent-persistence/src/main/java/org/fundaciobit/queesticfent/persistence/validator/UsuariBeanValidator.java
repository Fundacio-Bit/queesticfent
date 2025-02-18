package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.UsuariJPA;
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
public class UsuariBeanValidator 
      extends AbstractBeanValidator<UsuariJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IUsuariManager __usuariManager;


  public final UsuariValidator<UsuariJPA> _validator;


  public UsuariBeanValidator(org.fundaciobit.queesticfent.model.dao.IUsuariManager __usuariManager) { 
    this.__usuariManager = __usuariManager;
    _validator = new UsuariValidator<UsuariJPA>();
  }

  public UsuariBeanValidator(UsuariValidator<UsuariJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IUsuariManager __usuariManager) {
    this.__usuariManager = __usuariManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(UsuariJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<UsuariJPA> _bvr_ = new BeanValidatorResult<UsuariJPA>();
    _validator.validate(_bvr_, target, isNou, __usuariManager);
    return _bvr_.getErrors();
  }
}
