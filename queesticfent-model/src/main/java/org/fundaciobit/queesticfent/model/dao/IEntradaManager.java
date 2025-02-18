package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IEntradaManager extends org.fundaciobit.genapp.common.query.ITableManager<Entrada, Long> {


	public Entrada create( long _accioID_, java.lang.String _usuariID_, java.lang.Long _projecteID_, java.lang.String _dada1_, java.lang.Long _queEsticFentID_, java.lang.String _dada2_, java.sql.Timestamp _data_) throws I18NException;

	public Entrada findByPrimaryKey(long _entradaID_);

	public void delete(long _entradaID_);

}
