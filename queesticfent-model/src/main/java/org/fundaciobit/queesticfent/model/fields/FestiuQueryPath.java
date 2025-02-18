
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class FestiuQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public FestiuQueryPath() {
  }

  protected FestiuQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField FESTIUID() {
    return new LongField(getQueryPath(), FestiuFields.FESTIUID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), FestiuFields.NOM);
  }

  public DateField DATA() {
    return new DateField(getQueryPath(), FestiuFields.DATA);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), FestiuFields.DESCRIPCIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (FestiuFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


}
