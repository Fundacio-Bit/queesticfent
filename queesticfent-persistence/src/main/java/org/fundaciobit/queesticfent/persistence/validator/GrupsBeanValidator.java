package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.GrupsJPA;
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
public class GrupsBeanValidator 
      extends AbstractBeanValidator<GrupsJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IGrupsManager __grupsManager;


  public final GrupsValidator<GrupsJPA> _validator;


  public GrupsBeanValidator(org.fundaciobit.queesticfent.model.dao.IGrupsManager __grupsManager) { 
    this.__grupsManager = __grupsManager;
    _validator = new GrupsValidator<GrupsJPA>();
  }

  public GrupsBeanValidator(GrupsValidator<GrupsJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IGrupsManager __grupsManager) {
    this.__grupsManager = __grupsManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(GrupsJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<GrupsJPA> _bvr_ = new BeanValidatorResult<GrupsJPA>();
    _validator.validate(_bvr_, target, isNou, __grupsManager);
    return _bvr_.getErrors();
  }
}
