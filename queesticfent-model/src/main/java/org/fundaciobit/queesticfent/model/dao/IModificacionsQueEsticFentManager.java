package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IModificacionsQueEsticFentManager extends org.fundaciobit.genapp.common.query.ITableManager<ModificacionsQueEsticFent, Long> {


	public ModificacionsQueEsticFent create( long _accioID_, java.lang.String _usuariID_, java.lang.Long _projecteID_, java.sql.Date _data_, java.lang.Long _queEsticFentID_, java.lang.String _dada1_, java.lang.String _dada2_) throws I18NException;

	public ModificacionsQueEsticFent findByPrimaryKey(long _modificacioID_);

	public void delete(long _modificacioID_);

}
