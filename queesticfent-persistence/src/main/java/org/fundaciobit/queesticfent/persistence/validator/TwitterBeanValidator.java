package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.TwitterJPA;
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
public class TwitterBeanValidator 
      extends AbstractBeanValidator<TwitterJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.ITwitterManager __twitterManager;


  public final TwitterValidator<TwitterJPA> _validator;


  public TwitterBeanValidator(org.fundaciobit.queesticfent.model.dao.ITwitterManager __twitterManager) { 
    this.__twitterManager = __twitterManager;
    _validator = new TwitterValidator<TwitterJPA>();
  }

  public TwitterBeanValidator(TwitterValidator<TwitterJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.ITwitterManager __twitterManager) {
    this.__twitterManager = __twitterManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(TwitterJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<TwitterJPA> _bvr_ = new BeanValidatorResult<TwitterJPA>();
    _validator.validate(_bvr_, target, isNou, __twitterManager);
    return _bvr_.getErrors();
  }
}
