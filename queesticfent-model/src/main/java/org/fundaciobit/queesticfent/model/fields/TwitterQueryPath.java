
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class TwitterQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public TwitterQueryPath() {
  }

  protected TwitterQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField ID() {
    return new LongField(getQueryPath(), TwitterFields.ID);
  }

  public StringField USERNAME() {
    return new StringField(getQueryPath(), TwitterFields.USERNAME);
  }

  public StringField COMENTARIO() {
    return new StringField(getQueryPath(), TwitterFields.COMENTARIO);
  }

  public DateField FECHA() {
    return new DateField(getQueryPath(), TwitterFields.FECHA);
  }

  public LongField USER_ID() {
    return new LongField(getQueryPath(), TwitterFields.USER_ID);
  }

  public StringField IP() {
    return new StringField(getQueryPath(), TwitterFields.IP);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (TwitterFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


}
