
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class ProjectesQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public ProjectesQueryPath() {
  }

  protected ProjectesQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField PROJECTEID() {
    return new LongField(getQueryPath(), ProjectesFields.PROJECTEID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), ProjectesFields.NOM);
  }

  public LongField DEPARTAMENTID() {
    return new LongField(getQueryPath(), ProjectesFields.DEPARTAMENTID);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), ProjectesFields.DESCRIPCIO);
  }

  public BooleanField ACTIU() {
    return new BooleanField(getQueryPath(), ProjectesFields.ACTIU);
  }

  public DateField FROMDATA() {
    return new DateField(getQueryPath(), ProjectesFields.FROMDATA);
  }

  public DateField TODATA() {
    return new DateField(getQueryPath(), ProjectesFields.TODATA);
  }

  public BooleanField ACTIU2() {
    return new BooleanField(getQueryPath(), ProjectesFields.ACTIU2);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ProjectesFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ModificacionsQueEsticFentQueryPath MODIFICACIONSQUEESTICFENTS() {
    return new ModificacionsQueEsticFentQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ProjectesQueryPath.this.getQueryPath() + "modificacionsQueEsticFents" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public PersonalProjecteQueryPath PERSONALPROJECTES() {
    return new PersonalProjecteQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ProjectesQueryPath.this.getQueryPath() + "personalProjectes" + ".";
      }
    });
  }
*/

  public DepartamentsQueryPath DEPARTAMENTS() {
    return new DepartamentsQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ProjectesQueryPath.this.getQueryPath() + "departaments" + ".";
      }
    });
  }

}
