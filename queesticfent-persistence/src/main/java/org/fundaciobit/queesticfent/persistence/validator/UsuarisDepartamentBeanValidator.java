package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.UsuarisDepartamentJPA;
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
public class UsuarisDepartamentBeanValidator 
      extends AbstractBeanValidator<UsuarisDepartamentJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager;

  protected final org.fundaciobit.queesticfent.model.dao.IUsuarisDepartamentManager __usuarisDepartamentManager;


  public final UsuarisDepartamentValidator<UsuarisDepartamentJPA> _validator;


  public UsuarisDepartamentBeanValidator(org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager,
     org.fundaciobit.queesticfent.model.dao.IUsuarisDepartamentManager __usuarisDepartamentManager) { 
    this.__departamentsManager = __departamentsManager;
    this.__usuarisDepartamentManager = __usuarisDepartamentManager;
    _validator = new UsuarisDepartamentValidator<UsuarisDepartamentJPA>();
  }

  public UsuarisDepartamentBeanValidator(UsuarisDepartamentValidator<UsuarisDepartamentJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager,
     org.fundaciobit.queesticfent.model.dao.IUsuarisDepartamentManager __usuarisDepartamentManager) {
    this.__departamentsManager = __departamentsManager;
    this.__usuarisDepartamentManager = __usuarisDepartamentManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(UsuarisDepartamentJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<UsuarisDepartamentJPA> _bvr_ = new BeanValidatorResult<UsuarisDepartamentJPA>();
    _validator.validate(_bvr_, target, isNou, __departamentsManager, __usuarisDepartamentManager);
    return _bvr_.getErrors();
  }
}
