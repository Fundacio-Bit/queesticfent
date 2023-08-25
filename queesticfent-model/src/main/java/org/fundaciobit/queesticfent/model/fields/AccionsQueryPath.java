
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class AccionsQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public AccionsQueryPath() {
  }

  protected AccionsQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField ACCIOID() {
    return new LongField(getQueryPath(), AccionsFields.ACCIOID);
  }

  public StringField NOM() {
    return new StringField(getQueryPath(), AccionsFields.NOM);
  }

  public StringField NOMLLEGENDA() {
    return new StringField(getQueryPath(), AccionsFields.NOMLLEGENDA);
  }

  public StringField COLOR() {
    return new StringField(getQueryPath(), AccionsFields.COLOR);
  }

  public StringField DESCRIPCIO() {
    return new StringField(getQueryPath(), AccionsFields.DESCRIPCIO);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (AccionsFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


/* L'ús d'aquest camp (OneToMany) llança una exception:
 [Illegal attempt to dereference a collection]

 // TODO Solució dins el mètode testOneByOneDirect de la classe TestJPA 

  public ModificacionsQueEsticFentQueryPath MODIFICACIONSQUEESTICFENTS() {
    return new ModificacionsQueEsticFentQueryPath(new QueryPath() {
      public String getQueryPath() {
          return AccionsQueryPath.this.getQueryPath() + "modificacionsQueEsticFents" + ".";
      }
    });
  }
*/

}
