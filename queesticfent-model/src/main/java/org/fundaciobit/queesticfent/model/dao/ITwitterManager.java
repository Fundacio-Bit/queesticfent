package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface ITwitterManager extends org.fundaciobit.genapp.common.query.ITableManager<Twitter, Long> {


	public Twitter create( java.lang.String _username_, java.lang.String _comentario_, java.sql.Date _fecha_, java.lang.Long _user_id_, java.lang.String _ip_) throws I18NException;

	public Twitter findByPrimaryKey(long _id_);

	public void delete(long _id_);

}
