package org.fundaciobit.queesticfent.model.dao;

import org.fundaciobit.queesticfent.model.entity.*;
import org.fundaciobit.genapp.common.i18n.I18NException;


public interface IPersonalProjecteManager extends org.fundaciobit.genapp.common.query.ITableManager<PersonalProjecte, Long> {


	public PersonalProjecte create( java.lang.String _usuariID_, long _projecteID_, long _ordre_, java.lang.Short _percent_) throws I18NException;

	public PersonalProjecte findByPrimaryKey(long _personalProjecteID_);

	public void delete(long _personalProjecteID_);

}
