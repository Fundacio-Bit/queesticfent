
package org.fundaciobit.queesticfent.back.form.webdb;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.stereotype.Component;

import org.fundaciobit.genapp.common.StringKeyValue;
import org.fundaciobit.genapp.common.query.Field;
import org.fundaciobit.genapp.common.query.OrderBy;
import org.fundaciobit.genapp.common.query.Select;
import org.fundaciobit.genapp.common.query.Where;

import org.fundaciobit.queesticfent.ejb.EntradesService;
import org.fundaciobit.genapp.common.i18n.I18NException;
import org.fundaciobit.queesticfent.model.fields.EntradesFields;
import org.fundaciobit.genapp.common.web.controller.RefListBase;

/**
 *  ========= FITXER AUTOGENERAT - NO MODIFICAR !!!!! 
 * @author GenApp
 * 
 */
@Component
public class EntradesRefList extends RefListBase
    implements EntradesFields {

  @EJB(mappedName = EntradesService.JNDI_NAME)
  private EntradesService entradesEjb;

  public EntradesRefList(EntradesRefList __clone) {
    super(__clone);
    this.entradesEjb = __clone.entradesEjb;
  }
  public EntradesRefList() {
    setSelects(new Select<?>[] { ENTRADAID.select });
  }
  public List<StringKeyValue> getReferenceList(Field<?> keyField, Where where, OrderBy ... orderBy) throws I18NException {
    Select<StringKeyValue> select =  new org.fundaciobit.genapp.common.query.SelectMultipleStringKeyValue(keyField.select, getSeparator(), getSelects());
    List<StringKeyValue> list = entradesEjb.executeQuery(select, where, (orderBy==null || orderBy.length == 0) ? getOrderBy() : orderBy);
    return list;
  }
}
