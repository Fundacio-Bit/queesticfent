package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IProjectesManager extends org.fundaciobit.genapp.common.query.ITableManager<Projectes, Long> {


	public Projectes create( java.lang.String _nom_, long _departamentid_, java.lang.String _descripcio_, boolean _actiu_, java.sql.Date _fromdata_, java.sql.Date _todata_) throws I18NException;

	public Projectes findByPrimaryKey(long _projecteId_);

	public void delete(long _projecteId_);

}
