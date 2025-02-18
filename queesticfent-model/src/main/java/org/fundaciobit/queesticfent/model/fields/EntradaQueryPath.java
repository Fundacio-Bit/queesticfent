
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class EntradaQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public EntradaQueryPath() {
  }

  protected EntradaQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField ENTRADAID() {
    return new LongField(getQueryPath(), EntradaFields.ENTRADAID);
  }

  public LongField ACCIOID() {
    return new LongField(getQueryPath(), EntradaFields.ACCIOID);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), EntradaFields.USUARIID);
  }

  public LongField PROJECTEID() {
    return new LongField(getQueryPath(), EntradaFields.PROJECTEID);
  }

  public StringField DADA1() {
    return new StringField(getQueryPath(), EntradaFields.DADA1);
  }

  public LongField QUEESTICFENTID() {
    return new LongField(getQueryPath(), EntradaFields.QUEESTICFENTID);
  }

  public StringField DADA2() {
    return new StringField(getQueryPath(), EntradaFields.DADA2);
  }

  public TimestampField DATA() {
    return new TimestampField(getQueryPath(), EntradaFields.DATA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (EntradaFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public AccioQueryPath ACCIO() {
    return new AccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EntradaQueryPath.this.getQueryPath() + "accio" + ".";
      }
    });
  }

  public ProjecteQueryPath PROJECTE() {
    return new ProjecteQueryPath(new QueryPath() {
      public String getQueryPath() {
          return EntradaQueryPath.this.getQueryPath() + "projecte" + ".";
      }
    });
  }

}
