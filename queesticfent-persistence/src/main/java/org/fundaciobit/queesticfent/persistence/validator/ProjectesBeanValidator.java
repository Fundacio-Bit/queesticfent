package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.ProjectesJPA;
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
public class ProjectesBeanValidator 
      extends AbstractBeanValidator<ProjectesJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager;

  protected final org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager;


  public final ProjectesValidator<ProjectesJPA> _validator;


  public ProjectesBeanValidator(org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) { 
    this.__departamentsManager = __departamentsManager;
    this.__projectesManager = __projectesManager;
    _validator = new ProjectesValidator<ProjectesJPA>();
  }

  public ProjectesBeanValidator(ProjectesValidator<ProjectesJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IDepartamentsManager __departamentsManager,
     org.fundaciobit.queesticfent.model.dao.IProjectesManager __projectesManager) {
    this.__departamentsManager = __departamentsManager;
    this.__projectesManager = __projectesManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(ProjectesJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<ProjectesJPA> _bvr_ = new BeanValidatorResult<ProjectesJPA>();
    _validator.validate(_bvr_, target, isNou, __departamentsManager, __projectesManager);
    return _bvr_.getErrors();
  }
}
