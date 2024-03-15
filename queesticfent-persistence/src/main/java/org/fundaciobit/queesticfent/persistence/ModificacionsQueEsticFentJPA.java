
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
    long modificacioID;

    @Column(name="accioid",nullable = false,length = 19)
    long accioID;

    @Column(name="usuariid",nullable = false,length = 45)
    java.lang.String usuariID;

    @Column(name="projecteid",length = 19)
    java.lang.Long projecteID;

    @Column(name="data",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp data;

  /** -1 significa nou */
    @Column(name="queesticfentid",length = 19)
    java.lang.Long queEsticFentID;

    @Column(name="dada1",length = 500)
    java.lang.String dada1;

    @Column(name="dada2",length = 500)
    java.lang.String dada2;



  /** Constructor Buit */
  public ModificacionsQueEsticFentJPA() {
  }

  /** Constructor amb tots els camps  */
  public ModificacionsQueEsticFentJPA(long modificacioID , long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.sql.Timestamp data , java.lang.Long queEsticFentID , java.lang.String dada1 , java.lang.String dada2) {
    this.modificacioID=modificacioID;
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.data=data;
    this.queEsticFentID=queEsticFentID;
    this.dada1=dada1;
    this.dada2=dada2;
}
  /** Constructor sense valors autoincrementals */
  public ModificacionsQueEsticFentJPA(long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.sql.Timestamp data , java.lang.Long queEsticFentID , java.lang.String dada1 , java.lang.String dada2) {
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.data=data;
    this.queEsticFentID=queEsticFentID;
    this.dada1=dada1;
    this.dada2=dada2;
}
  /** Constructor dels valors Not Null */
  public ModificacionsQueEsticFentJPA(long modificacioID , long accioID , java.lang.String usuariID , java.sql.Timestamp data) {
    this.modificacioID=modificacioID;
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.data=data;
}
  public ModificacionsQueEsticFentJPA(ModificacionsQueEsticFent __bean) {
    this.setModificacioID(__bean.getModificacioID());
    this.setAccioID(__bean.getAccioID());
    this.setUsuariID(__bean.getUsuariID());
    this.setProjecteID(__bean.getProjecteID());
    this.setData(__bean.getData());
    this.setQueEsticFentID(__bean.getQueEsticFentID());
    this.setDada1(__bean.getDada1());
    this.setDada2(__bean.getDada2());
	}

	public long getModificacioID() {
		return(modificacioID);
	};
	public void setModificacioID(long _modificacioID_) {
		this.modificacioID = _modificacioID_;
	};

	public long getAccioID() {
		return(accioID);
	};
	public void setAccioID(long _accioID_) {
		this.accioID = _accioID_;
	};

	public java.lang.String getUsuariID() {
		return(usuariID);
	};
	public void setUsuariID(java.lang.String _usuariID_) {
		this.usuariID = _usuariID_;
	};

	public java.lang.Long getProjecteID() {
		return(projecteID);
	};
	public void setProjecteID(java.lang.Long _projecteID_) {
		this.projecteID = _projecteID_;
	};

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};

	public java.lang.Long getQueEsticFentID() {
		return(queEsticFentID);
	};
	public void setQueEsticFentID(java.lang.Long _queEsticFentID_) {
		this.queEsticFentID = _queEsticFentID_;
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
      __result = __result && (this.getModificacioID() == __instance.getModificacioID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:accioid | Table: qef_accions | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accioid", referencedColumnName ="accioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modific_accions_accioid_fk"))
    private AccionsJPA accions;

    public AccionsJPA getAccions() {
    return this.accions;
  }

    public  void setAccions(AccionsJPA accions) {
    this.accions = accions;
  }

// IMP Field:projecteid | Table: qef_projectes | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projecteid", referencedColumnName ="projecteID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modific_projectes_proje_fk"))
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
    __tmp.setModificacioID(__bean.getModificacioID());
    __tmp.setAccioID(__bean.getAccioID());
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setProjecteID(__bean.getProjecteID());
    __tmp.setData(__bean.getData());
    __tmp.setQueEsticFentID(__bean.getQueEsticFentID());
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
