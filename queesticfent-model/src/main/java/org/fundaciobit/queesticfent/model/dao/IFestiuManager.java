package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IFestiuManager extends org.fundaciobit.genapp.common.query.ITableManager<Festiu, Long> {


	public Festiu create( java.lang.String _nom_, java.sql.Date _data_, java.lang.String _descripcio_) throws I18NException;

	public Festiu findByPrimaryKey(long _festiuID_);

	public void delete(long _festiuID_);

}
