
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class FestiusQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public FestiusQueryPath() {
  }

  protected FestiusQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField FESTIUID() {
    return new LongField(getQueryPath(), FestiusFields.FESTIUID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), FestiusFields.NOM);
  }

  public DateField DATA() {
    return new DateField(getQueryPath(), FestiusFields.DATA);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), FestiusFields.DESCRIPCIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (FestiusFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


}
