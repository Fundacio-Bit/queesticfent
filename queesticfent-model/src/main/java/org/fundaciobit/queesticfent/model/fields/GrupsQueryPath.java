
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class GrupsQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public GrupsQueryPath() {
  }

  protected GrupsQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField GRUPID() {
    return new LongField(getQueryPath(), GrupsFields.GRUPID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), GrupsFields.NOM);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), GrupsFields.DESCRIPCIO);
  }

  public LongField NIVELLSEGURETAT() {
    return new LongField(getQueryPath(), GrupsFields.NIVELLSEGURETAT);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (GrupsFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public GrupsusuariQueryPath GRUPSUSUARIS() {
    return new GrupsusuariQueryPath(new QueryPath() {
      public String getQueryPath() {
          return GrupsQueryPath.this.getQueryPath() + "grupsusuaris" + ".";
      }
    });
  }
*/

}
