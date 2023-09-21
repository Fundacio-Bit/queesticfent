package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IPersonalProjecteManager extends org.fundaciobit.genapp.common.query.ITableManager<PersonalProjecte, Long> {


	public PersonalProjecte create( java.lang.String _usuariid_, long _projecteid_, long _ordre_, java.lang.Short _percent_) throws I18NException;

	public PersonalProjecte findByPrimaryKey(long _personalProjecteId_);

	public void delete(long _personalProjecteId_);

}
