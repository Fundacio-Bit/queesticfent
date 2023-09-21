
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class UsuarisDepartamentQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public UsuarisDepartamentQueryPath() {
  }

  protected UsuarisDepartamentQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), UsuarisDepartamentFields.USUARIID);
  }

  public LongField DEPARTAMENTID() {
    return new LongField(getQueryPath(), UsuarisDepartamentFields.DEPARTAMENTID);
  }

  public LongField USUARIDEPARTAMENTID() {
    return new LongField(getQueryPath(), UsuarisDepartamentFields.USUARIDEPARTAMENTID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (UsuarisDepartamentFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public UsuarisQueryPath USUARIS() {
    return new UsuarisQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuarisDepartamentQueryPath.this.getQueryPath() + "usuaris" + ".";
      }
    });
  }

  public DepartamentsQueryPath DEPARTAMENTS() {
    return new DepartamentsQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuarisDepartamentQueryPath.this.getQueryPath() + "departaments" + ".";
      }
    });
  }

}
