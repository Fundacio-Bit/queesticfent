
package org.fundaciobit.queesticfent.model.fields;
import org.fundaciobit.genapp.common.query.*;

public class ModificacionsQueEsticFentQueryPath extends org.fundaciobit.genapp.common.query.QueryPath {

  public ModificacionsQueEsticFentQueryPath() {
  }

  protected ModificacionsQueEsticFentQueryPath(QueryPath parentQueryPath) {
    super(parentQueryPath);
  }

  public LongField MODIFICACIOID() {
    return new LongField(getQueryPath(), ModificacionsQueEsticFentFields.MODIFICACIOID);
  }

  public LongField ACCIOID() {
    return new LongField(getQueryPath(), ModificacionsQueEsticFentFields.ACCIOID);
  }

  public StringField USUARIID() {
    return new StringField(getQueryPath(), ModificacionsQueEsticFentFields.USUARIID);
  }

  public LongField PROJECTEID() {
    return new LongField(getQueryPath(), ModificacionsQueEsticFentFields.PROJECTEID);
  }

  public TimestampField DATA() {
    return new TimestampField(getQueryPath(), ModificacionsQueEsticFentFields.DATA);
  }

  public LongField QUEESTICFENTID() {
    return new LongField(getQueryPath(), ModificacionsQueEsticFentFields.QUEESTICFENTID);
  }

  public StringField DADA1() {
    return new StringField(getQueryPath(), ModificacionsQueEsticFentFields.DADA1);
  }

  public StringField DADA2() {
    return new StringField(getQueryPath(), ModificacionsQueEsticFentFields.DADA2);
  }



  @Override
  public String getQueryPath() {
    return ((this.parentQueryPath == null) ? (ModificacionsQueEsticFentFields._TABLE_MODEL + ".")
        : this.parentQueryPath.getQueryPath());
  }


  public AccionsQueryPath ACCIONS() {
    return new AccionsQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ModificacionsQueEsticFentQueryPath.this.getQueryPath() + "accions" + ".";
      }
    });
  }

  public ProjectesQueryPath PROJECTES() {
    return new ProjectesQueryPath(new QueryPath() {
      public String getQueryPath() {
          return ModificacionsQueEsticFentQueryPath.this.getQueryPath() + "projectes" + ".";
      }
    });
  }

}
