
package org.fundaciobit.queesticfent.model.fields;

import org.fundaciobit.genapp.common.query.LongField;
import org.fundaciobit.genapp.common.query.QueryPath;
import org.fundaciobit.genapp.common.query.StringField;

public class GrupsusuariQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public GrupsusuariQueryPath() {
  }

  protected GrupsusuariQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField GRUPSUSUARIID() {
    return new LongField(getQueryPath(), GrupsusuariFields.GRUPSUSUARIID);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), GrupsusuariFields.USUARIID);
  }

  public LongField GRUPID() {
    return new LongField(getQueryPath(), GrupsusuariFields.GRUPID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (GrupsusuariFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public UsuariQueryPath USUARIS() {
    return new UsuariQueryPath(new QueryPath() {
      public String getQueryPath() {
          return GrupsusuariQueryPath.this.getQueryPath() + "usuaris" + ".";
      }
    });
  }

  public GrupsQueryPath GRUPS() {
    return new GrupsQueryPath(new QueryPath() {
      public String getQueryPath() {
          return GrupsusuariQueryPath.this.getQueryPath() + "grups" + ".";
      }
    });
  }

}
