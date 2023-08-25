
package org.fundaciobit.queesticfent.persistence;
import org.fundaciobit.queesticfent.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.Id;


@Entity(name = "ModificacionsQueEsticFentJPA")
@Table(name = "qef_modificacionsqueesticfent" , indexes = { 
        @Index(name="qef_modific_pk_i", columnList = "modificacioid"),
        @Index(name="qef_modific_accioid_fk_i", columnList = "accioid"),
        @Index(name="qef_modific_projecteid_fk_i", columnList = "projecteid")})
@SequenceGenerator(name="MODIFICACIONSQUEESTICFENT_SEQ", sequenceName="qef_modificacionsqueesticfent_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class ModificacionsQueEsticFentJPA implements ModificacionsQueEsticFent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MODIFICACIONSQUEESTICFENT_SEQ")
    @Column(name="modificacioid",nullable = false,length = 19)
    long modificacioid;

    @Column(name="accioid",nullable = false,length = 19)
    long accioid;

    @Column(name="usuariid",nullable = false,length = 45)
    java.lang.String usuariid;

    @Column(name="projecteid",length = 19)
    java.lang.Long projecteid;

    @Column(name="data",nullable = false,length = 35,precision = 6)
    java.sql.Timestamp data;

  /** -1 significa nou */
    @Column(name="queesticfentid",length = 19)
    java.lang.Long queesticfentid;

    @Column(name="dada1",length = 500)
    java.lang.String dada1;

    @Column(name="dada2",length = 500)
    java.lang.String dada2;



  /** Constructor Buit */
  public ModificacionsQueEsticFentJPA() {
  }

  /** Constructor amb tots els camps  */
  public ModificacionsQueEsticFentJPA(long modificacioid , long accioid , java.lang.String usuariid , java.lang.Long projecteid , java.sql.Timestamp data , java.lang.Long queesticfentid , java.lang.String dada1 , java.lang.String dada2) {
    this.modificacioid=modificacioid;
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.data=data;
    this.queesticfentid=queesticfentid;
    this.dada1=dada1;
    this.dada2=dada2;
}
  /** Constructor sense valors autoincrementals */
  public ModificacionsQueEsticFentJPA(long accioid , java.lang.String usuariid , java.lang.Long projecteid , java.sql.Timestamp data , java.lang.Long queesticfentid , java.lang.String dada1 , java.lang.String dada2) {
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.data=data;
    this.queesticfentid=queesticfentid;
    this.dada1=dada1;
    this.dada2=dada2;
}
  /** Constructor dels valors Not Null */
  public ModificacionsQueEsticFentJPA(long modificacioid , long accioid , java.lang.String usuariid , java.sql.Timestamp data) {
    this.modificacioid=modificacioid;
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.data=data;
}
  public ModificacionsQueEsticFentJPA(ModificacionsQueEsticFent __bean) {
    this.setModificacioid(__bean.getModificacioid());
    this.setAccioid(__bean.getAccioid());
    this.setUsuariid(__bean.getUsuariid());
    this.setProjecteid(__bean.getProjecteid());
    this.setData(__bean.getData());
    this.setQueesticfentid(__bean.getQueesticfentid());
    this.setDada1(__bean.getDada1());
    this.setDada2(__bean.getDada2());
	}

	public long getModificacioid() {
		return(modificacioid);
	};
	public void setModificacioid(long _modificacioid_) {
		this.modificacioid = _modificacioid_;
	};

	public long getAccioid() {
		return(accioid);
	};
	public void setAccioid(long _accioid_) {
		this.accioid = _accioid_;
	};

	public java.lang.String getUsuariid() {
		return(usuariid);
	};
	public void setUsuariid(java.lang.String _usuariid_) {
		this.usuariid = _usuariid_;
	};

	public java.lang.Long getProjecteid() {
		return(projecteid);
	};
	public void setProjecteid(java.lang.Long _projecteid_) {
		this.projecteid = _projecteid_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public java.lang.Long getQueesticfentid() {
		return(queesticfentid);
	};
	public void setQueesticfentid(java.lang.Long _queesticfentid_) {
		this.queesticfentid = _queesticfentid_;
	};

	public java.lang.String getDada1() {
		return(dada1);
	};
	public void setDada1(java.lang.String _dada1_) {
		this.dada1 = _dada1_;
	};

	public java.lang.String getDada2() {
		return(dada2);
	};
	public void setDada2(java.lang.String _dada2_) {
		this.dada2 = _dada2_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof ModificacionsQueEsticFent) {
      ModificacionsQueEsticFent __instance = (ModificacionsQueEsticFent)__obj;
      __result = true;
      __result = __result && (this.getModificacioid() == __instance.getModificacioid()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:accioid | Table: qef_accions | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accioid", referencedColumnName ="accioid", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modific_accions_accioid_fk"))
    private AccionsJPA accions;

    public AccionsJPA getAccions() {
    return this.accions;
  }

    public  void setAccions(AccionsJPA accions) {
    this.accions = accions;
  }

// IMP Field:projecteid | Table: qef_projectes | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projecteid", referencedColumnName ="projecteid", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modific_projectes_proje_fk"))
    private ProjectesJPA projectes;

    public ProjectesJPA getProjectes() {
    return this.projectes;
  }

    public  void setProjectes(ProjectesJPA projectes) {
    this.projectes = projectes;
  }


 // ---------------  STATIC METHODS ------------------
  public static ModificacionsQueEsticFentJPA toJPA(ModificacionsQueEsticFent __bean) {
    if (__bean == null) { return null;}
    ModificacionsQueEsticFentJPA __tmp = new ModificacionsQueEsticFentJPA();
    __tmp.setModificacioid(__bean.getModificacioid());
    __tmp.setAccioid(__bean.getAccioid());
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setProjecteid(__bean.getProjecteid());
    __tmp.setData(__bean.getData());
    __tmp.setQueesticfentid(__bean.getQueesticfentid());
    __tmp.setDada1(__bean.getDada1());
    __tmp.setDada2(__bean.getDada2());
		return __tmp;
	}


  public static ModificacionsQueEsticFentJPA copyJPA(ModificacionsQueEsticFentJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<ModificacionsQueEsticFentJPA> copyJPA(java.util.Set<ModificacionsQueEsticFentJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<ModificacionsQueEsticFentJPA> __tmpSet = (java.util.Set<ModificacionsQueEsticFentJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<ModificacionsQueEsticFentJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (ModificacionsQueEsticFentJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static ModificacionsQueEsticFentJPA copyJPA(ModificacionsQueEsticFentJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    ModificacionsQueEsticFentJPA __tmp = (ModificacionsQueEsticFentJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"AccionsJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.accions) || org.hibernate.Hibernate.isInitialized(__jpa.getAccions()) ) ) {
      __tmp.setAccions(AccionsJPA.copyJPA(__jpa.getAccions(), __alreadyCopied,"ModificacionsQueEsticFentJPA"));
    }
    if(!"ProjectesJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.projectes) || org.hibernate.Hibernate.isInitialized(__jpa.getProjectes()) ) ) {
      __tmp.setProjectes(ProjectesJPA.copyJPA(__jpa.getProjectes(), __alreadyCopied,"ModificacionsQueEsticFentJPA"));
    }

    return __tmp;
  }




}
