package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IGrupsusuariManager extends org.fundaciobit.genapp.common.query.ITableManager<Grupsusuari, Long> {


	public Grupsusuari create( java.lang.String _usuariID_, long _grupID_) throws I18NException;

	public Grupsusuari findByPrimaryKey(long _grupsUsuariID_);

	public void delete(long _grupsUsuariID_);

}
