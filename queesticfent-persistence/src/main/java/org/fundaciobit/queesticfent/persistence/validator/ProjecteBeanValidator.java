package org.fundaciobit.queesticfent.persistence.validator;

import org.fundaciobit.queesticfent.persistence.ProjecteJPA;
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
public class ProjecteBeanValidator 
      extends AbstractBeanValidator<ProjecteJPA> {


  // EJB's
  protected final org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager;

  protected final org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager;


  public final ProjecteValidator<ProjecteJPA> _validator;


  public ProjecteBeanValidator(org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager,
     org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager) { 
    this.__departamentManager = __departamentManager;
    this.__projecteManager = __projecteManager;
    _validator = new ProjecteValidator<ProjecteJPA>();
  }

  public ProjecteBeanValidator(ProjecteValidator<ProjecteJPA> _validator,
     org.fundaciobit.queesticfent.model.dao.IDepartamentManager __departamentManager,
     org.fundaciobit.queesticfent.model.dao.IProjecteManager __projecteManager) {
    this.__departamentManager = __departamentManager;
    this.__projecteManager = __projecteManager;
    this._validator = _validator;
  }

  @Override
  public List<I18NFieldError> validate(ProjecteJPA target, boolean isNou) throws I18NException {
    BeanValidatorResult<ProjecteJPA> _bvr_ = new BeanValidatorResult<ProjecteJPA>();
    _validator.validate(_bvr_, target, isNou, __departamentManager, __projecteManager);
    return _bvr_.getErrors();
  }
}
