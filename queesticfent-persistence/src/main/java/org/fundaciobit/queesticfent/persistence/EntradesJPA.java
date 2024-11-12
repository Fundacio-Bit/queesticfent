
package org.fundaciobit.queesticfent.persistence;
import org.fundaciobit.queesticfent.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.Id;


@Entity(name = "EntradesJPA")
@Table(name = "qef_entrades" , indexes = { 
        @Index(name="qef_entrad_pk_i", columnList = "entradaid"),
        @Index(name="qef_entrades_accioid_fk_i", columnList = "accioid"),
        @Index(name="qef_entrades_projecteid_fk_i", columnList = "projecteid")})
@SequenceGenerator(name="ENTRADES_SEQ", sequenceName="qef_entrades_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class EntradesJPA implements Entrades {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ENTRADES_SEQ")
    @Column(name="entradaid",nullable = false,length = 19)
    long entradaID;

    @Column(name="accioid",nullable = false,length = 19)
    long accioid;

    @Column(name="usuariid",nullable = false,length = 45)
    java.lang.String usuariid;

    @Column(name="projecteid",length = 19)
    java.lang.Long projecteid;

    @Column(name="queesticfentid",length = 19)
    java.lang.Long queesticfentid;

    @Column(name="dada1",length = 500)
    java.lang.String dada1;

    @Column(name="dada2",length = 500)
    java.lang.String dada2;

    @Column(name="data",nullable = false,length = 15,precision = 6)
    java.sql.Time data;



  /** Constructor Buit */
  public EntradesJPA() {
  }

  /** Constructor amb tots els camps  */
  public EntradesJPA(long entradaID , long accioid , java.lang.String usuariid , java.lang.Long projecteid , java.lang.Long queesticfentid , java.lang.String dada1 , java.lang.String dada2 , java.sql.Time data) {
    this.entradaID=entradaID;
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.queesticfentid=queesticfentid;
    this.dada1=dada1;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor sense valors autoincrementals */
  public EntradesJPA(long accioid , java.lang.String usuariid , java.lang.Long projecteid , java.lang.Long queesticfentid , java.lang.String dada1 , java.lang.String dada2 , java.sql.Time data) {
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.queesticfentid=queesticfentid;
    this.dada1=dada1;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor dels valors Not Null */
  public EntradesJPA(long entradaID , long accioid , java.lang.String usuariid , java.sql.Time data) {
    this.entradaID=entradaID;
    this.accioid=accioid;
    this.usuariid=usuariid;
    this.data=data;
}
  public EntradesJPA(Entrades __bean) {
    this.setEntradaID(__bean.getEntradaID());
    this.setAccioid(__bean.getAccioid());
    this.setUsuariid(__bean.getUsuariid());
    this.setProjecteid(__bean.getProjecteid());
    this.setQueesticfentid(__bean.getQueesticfentid());
    this.setDada1(__bean.getDada1());
    this.setDada2(__bean.getDada2());
    this.setData(__bean.getData());
	}

	public long getEntradaID() {
		return(entradaID);
	};
	public void setEntradaID(long _entradaID_) {
		this.entradaID = _entradaID_;
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

	public java.sql.Time getData() {
		return(data);
	};
	public void setData(java.sql.Time _data_) {
		this.data = _data_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Entrades) {
      Entrades __instance = (Entrades)__obj;
      __result = true;
      __result = __result && (this.getEntradaID() == __instance.getEntradaID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:entradaid | Table: qef_modificacions | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entrades")
    private Set<ModificacionsJPA> modificacionss = new HashSet<ModificacionsJPA>(0);
    public  Set<ModificacionsJPA> getModificacionss() {
    return this.modificacionss;
  }

    public void setModificacionss(Set<ModificacionsJPA> modificacionss) {
      this.modificacionss = modificacionss;
    }


// IMP Field:accioid | Table: qef_accions | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accioid", referencedColumnName ="accioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_entrades_accions_accioi_fk"))
    private AccionsJPA accions;

    public AccionsJPA getAccions() {
    return this.accions;
  }

    public  void setAccions(AccionsJPA accions) {
    this.accions = accions;
  }

// IMP Field:projecteid | Table: qef_projectes | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projecteid", referencedColumnName ="projecteID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_entrades_projectes_pid_fk"))
    private ProjectesJPA projectes;

    public ProjectesJPA getProjectes() {
    return this.projectes;
  }

    public  void setProjectes(ProjectesJPA projectes) {
    this.projectes = projectes;
  }


 // ---------------  STATIC METHODS ------------------
  public static EntradesJPA toJPA(Entrades __bean) {
    if (__bean == null) { return null;}
    EntradesJPA __tmp = new EntradesJPA();
    __tmp.setEntradaID(__bean.getEntradaID());
    __tmp.setAccioid(__bean.getAccioid());
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setProjecteid(__bean.getProjecteid());
    __tmp.setQueesticfentid(__bean.getQueesticfentid());
    __tmp.setDada1(__bean.getDada1());
    __tmp.setDada2(__bean.getDada2());
    __tmp.setData(__bean.getData());
		return __tmp;
	}


  public static EntradesJPA copyJPA(EntradesJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<EntradesJPA> copyJPA(java.util.Set<EntradesJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<EntradesJPA> __tmpSet = (java.util.Set<EntradesJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<EntradesJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (EntradesJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static EntradesJPA copyJPA(EntradesJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    EntradesJPA __tmp = (EntradesJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"ModificacionsJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.modificacionss) || org.hibernate.Hibernate.isInitialized(__jpa.getModificacionss())) ) {
      __tmp.setModificacionss(ModificacionsJPA.copyJPA(__jpa.getModificacionss(), __alreadyCopied,"EntradesJPA"));
    }
    // Copia de beans complexes (IMP)
    if(!"AccionsJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.accions) || org.hibernate.Hibernate.isInitialized(__jpa.getAccions()) ) ) {
      __tmp.setAccions(AccionsJPA.copyJPA(__jpa.getAccions(), __alreadyCopied,"EntradesJPA"));
    }
    if(!"ProjectesJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.projectes) || org.hibernate.Hibernate.isInitialized(__jpa.getProjectes()) ) ) {
      __tmp.setProjectes(ProjectesJPA.copyJPA(__jpa.getProjectes(), __alreadyCopied,"EntradesJPA"));
    }

    return __tmp;
  }




}
