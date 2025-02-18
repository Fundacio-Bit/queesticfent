
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class ModificacioQueEsticFentQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public ModificacioQueEsticFentQueryPath() {
  }

  protected ModificacioQueEsticFentQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField MODIFICACIOID() {
    return new LongField(getQueryPath(), ModificacioQueEsticFentFields.MODIFICACIOID);
  }

  public LongField ACCIOID() {
    return new LongField(getQueryPath(), ModificacioQueEsticFentFields.ACCIOID);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), ModificacioQueEsticFentFields.USUARIID);
  }

  public LongField PROJECTEID() {
    return new LongField(getQueryPath(), ModificacioQueEsticFentFields.PROJECTEID);
  }

  public LongField QUEESTICFENTID() {
    return new LongField(getQueryPath(), ModificacioQueEsticFentFields.QUEESTICFENTID);
  }

  public StringField DADA1() {
    return new StringField(getQueryPath(), ModificacioQueEsticFentFields.DADA1);
  }

  public StringField DADA2() {
    return new StringField(getQueryPath(), ModificacioQueEsticFentFields.DADA2);
  }

  public TimestampField DATA() {
    return new TimestampField(getQueryPath(), ModificacioQueEsticFentFields.DATA);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ModificacioQueEsticFentFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public AccioQueryPath ACCIO() {
    return new AccioQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ModificacioQueEsticFentQueryPath.this.getQueryPath() + "accio" + ".";
      }
    });
  }

  public ProjecteQueryPath PROJECTE() {
    return new ProjecteQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ModificacioQueEsticFentQueryPath.this.getQueryPath() + "projecte" + ".";
      }
    });
  }

}
