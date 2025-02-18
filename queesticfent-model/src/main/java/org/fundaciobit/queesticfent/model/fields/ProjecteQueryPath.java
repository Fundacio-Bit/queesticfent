
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class ProjecteQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public ProjecteQueryPath() {
  }

  protected ProjecteQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField PROJECTEID() {
    return new LongField(getQueryPath(), ProjecteFields.PROJECTEID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), ProjecteFields.NOM);
  }

  public LongField DEPARTAMENTID() {
    return new LongField(getQueryPath(), ProjecteFields.DEPARTAMENTID);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), ProjecteFields.DESCRIPCIO);
  }

  public BooleanField ACTIU() {
    return new BooleanField(getQueryPath(), ProjecteFields.ACTIU);
  }

  public DateField FROMDATA() {
    return new DateField(getQueryPath(), ProjecteFields.FROMDATA);
  }

  public DateField TODATA() {
    return new DateField(getQueryPath(), ProjecteFields.TODATA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ProjecteFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public EntradaQueryPath ENTRADAS() {
    return new EntradaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ProjecteQueryPath.this.getQueryPath() + "entradas" + ".";
      }
    });
  }
*/

/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ModificacioQueEsticFentQueryPath MODIFICACIOQUEESTICFENTS() {
    return new ModificacioQueEsticFentQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ProjecteQueryPath.this.getQueryPath() + "modificacioQueEsticFents" + ".";
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
          return ProjecteQueryPath.this.getQueryPath() + "personalProjectes" + ".";
      }
    });
  }
*/

  public DepartamentQueryPath DEPARTAMENT() {
    return new DepartamentQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ProjecteQueryPath.this.getQueryPath() + "departament" + ".";
      }
    });
  }

}
