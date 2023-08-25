package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IModificacionsQueEsticFentManager extends org.fundaciobit.genapp.common.query.ITableManager<ModificacionsQueEsticFent, Long> {


	public ModificacionsQueEsticFent create( long _accioid_, java.lang.String _usuariid_, java.lang.Long _projecteid_, java.sql.Timestamp _data_, java.lang.Long _queesticfentid_, java.lang.String _dada1_, java.lang.String _dada2_) throws I18NException;

	public ModificacionsQueEsticFent findByPrimaryKey(long _modificacioid_);

	public void delete(long _modificacioid_);

}
