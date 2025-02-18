
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class UsuariDepartamentQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public UsuariDepartamentQueryPath() {
  }

  protected UsuariDepartamentQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), UsuariDepartamentFields.USUARIID);
  }

  public LongField DEPARTAMENTID() {
    return new LongField(getQueryPath(), UsuariDepartamentFields.DEPARTAMENTID);
  }

  public LongField USUARIDEPARTAMENTID() {
    return new LongField(getQueryPath(), UsuariDepartamentFields.USUARIDEPARTAMENTID);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (UsuariDepartamentFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public UsuariQueryPath USUARI() {
    return new UsuariQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuariDepartamentQueryPath.this.getQueryPath() + "usuari" + ".";
      }
    });
  }

  public DepartamentQueryPath DEPARTAMENT() {
    return new DepartamentQueryPath(new QueryPath() {
      public String getQueryPath() {
          return UsuariDepartamentQueryPath.this.getQueryPath() + "departament" + ".";
      }
    });
  }

}
