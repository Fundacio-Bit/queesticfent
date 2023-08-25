
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import org.fundaciobit.queesticfent.ejb.ModificacionsQueEsticFentService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.queesticfent.model.fields.ModificacionsQueEsticFentFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class ModificacionsQueEsticFentRefList extends RefListBase
    implements ModificacionsQueEsticFentFields {

  @EJB(mappedName = ModificacionsQueEsticFentService.JNDI_NAME)
  private ModificacionsQueEsticFentService modificacionsQueEsticFentEjb;

  public ModificacionsQueEsticFentRefList(ModificacionsQueEsticFentRefList __clone) {
    super(__clone);
    this.modificacionsQueEsticFentEjb = __clone.modificacionsQueEsticFentEjb;
  }
  public ModificacionsQueEsticFentRefList() {
    setSelects(new Select<?>[] { DATA.select, DADA1.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = modificacionsQueEsticFentEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
