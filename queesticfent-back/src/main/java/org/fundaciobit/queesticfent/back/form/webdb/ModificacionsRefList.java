
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import org.fundaciobit.queesticfent.ejb.ModificacionsService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.queesticfent.model.fields.ModificacionsFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class ModificacionsRefList extends RefListBase
    implements ModificacionsFields {

  @EJB(mappedName = ModificacionsService.JNDI_NAME)
  private ModificacionsService modificacionsEjb;

  public ModificacionsRefList(ModificacionsRefList __clone) {
    super(__clone);
    this.modificacionsEjb = __clone.modificacionsEjb;
  }
  public ModificacionsRefList() {
    setSelects(new Select<?>[] { MODIFICACIOID.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = modificacionsEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
