package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IFestiusManager extends org.fundaciobit.genapp.common.query.ITableManager<Festius, Long> {


	public Festius create( java.lang.String _nom_, java.sql.Date _data_, java.lang.String _descripcio_) throws I18NException;

	public Festius findByPrimaryKey(long _festiuid_);

	public void delete(long _festiuid_);

}
