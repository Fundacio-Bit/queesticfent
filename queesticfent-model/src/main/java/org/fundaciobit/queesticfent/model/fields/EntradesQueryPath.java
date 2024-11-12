
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class EntradesQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public EntradesQueryPath() {
  }

  protected EntradesQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField ENTRADAID() {
    return new LongField(getQueryPath(), EntradesFields.ENTRADAID);
  }

  public LongField ACCIOID() {
    return new LongField(getQueryPath(), EntradesFields.ACCIOID);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), EntradesFields.USUARIID);
  }

  public LongField PROJECTEID() {
    return new LongField(getQueryPath(), EntradesFields.PROJECTEID);
  }

  public LongField QUEESTICFENTID() {
    return new LongField(getQueryPath(), EntradesFields.QUEESTICFENTID);
  }

  public StringField DADA1() {
    return new StringField(getQueryPath(), EntradesFields.DADA1);
  }

  public StringField DADA2() {
    return new StringField(getQueryPath(), EntradesFields.DADA2);
  }

  public TimeField DATA() {
    return new TimeField(getQueryPath(), EntradesFields.DATA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (EntradesFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ModificacionsQueryPath MODIFICACIONSS() {
    return new ModificacionsQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EntradesQueryPath.this.getQueryPath() + "modificacionss" + ".";
      }
    });
  }
*/

  public AccionsQueryPath ACCIONS() {
    return new AccionsQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EntradesQueryPath.this.getQueryPath() + "accions" + ".";
      }
    });
  }

  public ProjectesQueryPath PROJECTES() {
    return new ProjectesQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EntradesQueryPath.this.getQueryPath() + "projectes" + ".";
      }
    });
  }

}
