package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.GrupsusuariJPA;
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
public class GrupsusuariBeanValidator 
      extends AbstractBeanValidator<GrupsusuariJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IGrupsManager __grupsManager;

  protected final org.fundaciobit.queesticfent.model.dao.IGrupsusuariManager __grupsusuariManager;

  protected final org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager;


  public final GrupsusuariValidator<GrupsusuariJPA> _validator;


  public GrupsusuariBeanValidator(org.fundaciobit.queesticfent.model.dao.IGrupsManager __grupsManager,
     org.fundaciobit.queesticfent.model.dao.IGrupsusuariManager __grupsusuariManager,
     org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager) { 
    this.__grupsManager = __grupsManager;
    this.__grupsusuariManager = __grupsusuariManager;
    this.__usuarisManager = __usuarisManager;
    _validator = new GrupsusuariValidator<GrupsusuariJPA>();
  }

  public GrupsusuariBeanValidator(GrupsusuariValidator<GrupsusuariJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IGrupsManager __grupsManager,
     org.fundaciobit.queesticfent.model.dao.IGrupsusuariManager __grupsusuariManager,
     org.fundaciobit.queesticfent.model.dao.IUsuarisManager __usuarisManager) {
    this.__grupsManager = __grupsManager;
    this.__grupsusuariManager = __grupsusuariManager;
    this.__usuarisManager = __usuarisManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(GrupsusuariJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<GrupsusuariJPA> _bvr_ = new BeanValidatorResult<GrupsusuariJPA>();
    _validator.validate(_bvr_, target, isNou, __grupsManager, __grupsusuariManager, __usuarisManager);
    return _bvr_.getErrors();
  }
}
