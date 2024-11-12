package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IEntradesManager extends org.fundaciobit.genapp.common.query.ITableManager<Entrades, Long> {


	public Entrades create( long _accioid_, java.lang.String _usuariid_, java.lang.Long _projecteid_, java.lang.Long _queesticfentid_, java.lang.String _dada1_, java.lang.String _dada2_, java.sql.Time _data_) throws I18NException;

	public Entrades findByPrimaryKey(long _entradaID_);

	public void delete(long _entradaID_);

}
