package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.PersonalProjecteJPA;
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
public class PersonalProjecteBeanValidator 
      extends AbstractBeanValidator<PersonalProjecteJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IPersonalProjecteManager __personalProjecteManager;

  protected final org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager;


  public final PersonalProjecteValidator<PersonalProjecteJPA> _validator;


  public PersonalProjecteBeanValidator(org.fundaciobit.queesticfent.model.dao.IPersonalProjecteManager __personalProjecteManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) { 
    this.__personalProjecteManager = __personalProjecteManager;
    this.__projectesManager = __projectesManager;
    _validator = new PersonalProjecteValidator<PersonalProjecteJPA>();
  }

  public PersonalProjecteBeanValidator(PersonalProjecteValidator<PersonalProjecteJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IPersonalProjecteManager __personalProjecteManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {
    this.__personalProjecteManager = __personalProjecteManager;
    this.__projectesManager = __projectesManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(PersonalProjecteJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<PersonalProjecteJPA> _bvr_ = new BeanValidatorResult<PersonalProjecteJPA>();
    _validator.validate(_bvr_, target, isNou, __personalProjecteManager, __projectesManager);
    return _bvr_.getErrors();
  }
}
