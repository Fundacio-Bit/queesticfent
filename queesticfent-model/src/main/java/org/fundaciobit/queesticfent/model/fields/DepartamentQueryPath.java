
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class DepartamentQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public DepartamentQueryPath() {
  }

  protected DepartamentQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField DEPARTAMENTID() {
    return new LongField(getQueryPath(), DepartamentFields.DEPARTAMENTID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), DepartamentFields.NOM);
  }

  public StringField COORDINADORID() {
    return new StringField(getQueryPath(), DepartamentFields.COORDINADORID);
  }

  public StringField NOMLDAP() {
    return new StringField(getQueryPath(), DepartamentFields.NOMLDAP);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), DepartamentFields.DESCRIPCIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (DepartamentFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ProjecteQueryPath PROJECTES() {
    return new ProjecteQueryPath(new QueryPath() {
      public String getQueryPath() {
          return DepartamentQueryPath.this.getQueryPath() + "projectes" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public UsuariDepartamentQueryPath USUARIDEPARTAMENTS() {
    return new UsuariDepartamentQueryPath(new QueryPath() {
      public String getQueryPath() {
          return DepartamentQueryPath.this.getQueryPath() + "usuariDepartaments" + ".";
      }
    });
  }
*/

}
