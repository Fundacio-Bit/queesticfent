
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class DepartamentsQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public DepartamentsQueryPath() {
  }

  protected DepartamentsQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField DEPARTAMENTID() {
    return new LongField(getQueryPath(), DepartamentsFields.DEPARTAMENTID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), DepartamentsFields.NOM);
  }

  public StringField COORDINADORID() {
    return new StringField(getQueryPath(), DepartamentsFields.COORDINADORID);
  }

  public StringField NOMLDAP() {
    return new StringField(getQueryPath(), DepartamentsFields.NOMLDAP);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), DepartamentsFields.DESCRIPCIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (DepartamentsFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ProjectesQueryPath PROJECTESS() {
    return new ProjectesQueryPath(new QueryPath() {
      public String getQueryPath() {
          return DepartamentsQueryPath.this.getQueryPath() + "projectess" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public UsuarisDepartamentQueryPath USUARISDEPARTAMENTS() {
    return new UsuarisDepartamentQueryPath(new QueryPath() {
      public String getQueryPath() {
          return DepartamentsQueryPath.this.getQueryPath() + "usuarisDepartaments" + ".";
      }
    });
  }
*/

}
