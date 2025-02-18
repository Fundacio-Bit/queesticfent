
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class AccioQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public AccioQueryPath() {
  }

  protected AccioQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField ACCIOID() {
    return new LongField(getQueryPath(), AccioFields.ACCIOID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), AccioFields.NOM);
  }

  public StringField NOMLLEGENDA() {
    return new StringField(getQueryPath(), AccioFields.NOMLLEGENDA);
  }

  public StringField COLOR() {
    return new StringField(getQueryPath(), AccioFields.COLOR);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), AccioFields.DESCRIPCIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (AccioFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public EntradaQueryPath ENTRADAS() {
    return new EntradaQueryPath(new QueryPath() {
      public String getQueryPath() {
          return AccioQueryPath.this.getQueryPath() + "entradas" + ".";
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
          return AccioQueryPath.this.getQueryPath() + "modificacioQueEsticFents" + ".";
      }
    });
  }
*/

}
