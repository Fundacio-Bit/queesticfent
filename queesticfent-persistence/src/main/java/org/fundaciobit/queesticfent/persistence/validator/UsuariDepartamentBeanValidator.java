package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.UsuariDepartamentJPA;
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
public class UsuariDepartamentBeanValidator 
      extends AbstractBeanValidator<UsuariDepartamentJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager;

  protected final org.fundaciobit.queesticfent.model.dao.IUsuariManager __usuariManager;

  protected final org.fundaciobit.queesticfent.model.dao.IUsuariDepartamentManager __usuariDepartamentManager;


  public final UsuariDepartamentValidator<UsuariDepartamentJPA> _validator;


  public UsuariDepartamentBeanValidator(org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager,
     org.fundaciobit.queesticfent.model.dao.IUsuariManager __usuariManager,
     org.fundaciobit.queesticfent.model.dao.IUsuariDepartamentManager __usuariDepartamentManager) { 
    this.__departamentManager = __departamentManager;
    this.__usuariManager = __usuariManager;
    this.__usuariDepartamentManager = __usuariDepartamentManager;
    _validator = new UsuariDepartamentValidator<UsuariDepartamentJPA>();
  }

  public UsuariDepartamentBeanValidator(UsuariDepartamentValidator<UsuariDepartamentJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager,
     org.fundaciobit.queesticfent.model.dao.IUsuariManager __usuariManager,
     org.fundaciobit.queesticfent.model.dao.IUsuariDepartamentManager __usuariDepartamentManager) {
    this.__departamentManager = __departamentManager;
    this.__usuariManager = __usuariManager;
    this.__usuariDepartamentManager = __usuariDepartamentManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(UsuariDepartamentJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<UsuariDepartamentJPA> _bvr_ = new BeanValidatorResult<UsuariDepartamentJPA>();
    _validator.validate(_bvr_, target, isNou, __departamentManager, __usuariManager, __usuariDepartamentManager);
    return _bvr_.getErrors();
  }
}
