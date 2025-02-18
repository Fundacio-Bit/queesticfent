
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


@Entity(name = "ModificacioQueEsticFentJPA")
@Table(name = "qef_modificacioqueesticfent" , indexes = { 
        @Index(name="qef_modific_pk_i", columnList = "modificacioid"),
        @Index(name="qef_modifqef_accioid_fk_i", columnList = "accioid"),
        @Index(name="qef_modifqef_projecteid_fk_i", columnList = "projecteid")})
@SequenceGenerator(name="MODIFICACIOQUEESTICFENT_SEQ", sequenceName="qef_modificacioqueesticfen_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class ModificacioQueEsticFentJPA implements ModificacioQueEsticFent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MODIFICACIOQUEESTICFENT_SEQ")
    @Column(name="modificacioid",nullable = false,length = 19)
    long modificacioID;

    @Column(name="accioid",nullable = false,length = 19)
    long accioID;

    @Column(name="usuariid",nullable = false,length = 45)
    java.lang.String usuariID;

    @Column(name="projecteid",length = 19)
    java.lang.Long projecteID;

  /** -1 significa nou */
    @Column(name="queesticfentid",length = 19)
    java.lang.Long queEsticFentID;

    @Column(name="dada1",length = 500)
    java.lang.String dada1;

    @Column(name="dada2",length = 500)
    java.lang.String dada2;

    @Column(name="data",length = 29,precision = 6)
    java.sql.Timestamp data;



  /** Constructor Buit */
  public ModificacioQueEsticFentJPA() {
  }

  /** Constructor amb tots els camps  */
  public ModificacioQueEsticFentJPA(long modificacioID , long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.lang.Long queEsticFentID , java.lang.String dada1 , java.lang.String dada2 , java.sql.Timestamp data) {
    this.modificacioID=modificacioID;
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.queEsticFentID=queEsticFentID;
    this.dada1=dada1;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor sense valors autoincrementals */
  public ModificacioQueEsticFentJPA(long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.lang.Long queEsticFentID , java.lang.String dada1 , java.lang.String dada2 , java.sql.Timestamp data) {
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.queEsticFentID=queEsticFentID;
    this.dada1=dada1;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor dels valors Not Null */
  public ModificacioQueEsticFentJPA(long modificacioID , long accioID , java.lang.String usuariID) {
    this.modificacioID=modificacioID;
    this.accioID=accioID;
    this.usuariID=usuariID;
}
  public ModificacioQueEsticFentJPA(ModificacioQueEsticFent __bean) {
    this.setModificacioID(__bean.getModificacioID());
    this.setAccioID(__bean.getAccioID());
    this.setUsuariID(__bean.getUsuariID());
    this.setProjecteID(__bean.getProjecteID());
    this.setQueEsticFentID(__bean.getQueEsticFentID());
    this.setDada1(__bean.getDada1());
    this.setDada2(__bean.getDada2());
    this.setData(__bean.getData());
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

	public java.sql.Timestamp getData() {
		return(data);
	};
	public void setData(java.sql.Timestamp _data_) {
		this.data = _data_;
	};



    @Override
    public boolean equals(Object __obj) {
        boolean __result;
        if (__obj != null && __obj instanceof ModificacioQueEsticFent) {
            ModificacioQueEsticFent __instance = (ModificacioQueEsticFent)__obj;
            __result = true;
            __result = __result && (this.getModificacioID() == __instance.getModificacioID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getModificacioID())).hashCode();
    }

// IMP Field:accioid | Table: qef_accio | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accioid", referencedColumnName ="accioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modifqef_accio_accioid_fk"))
    private AccioJPA accio;

    public AccioJPA getAccio() {
    return this.accio;
  }

    public  void setAccio(AccioJPA accio) {
    this.accio = accio;
  }

// IMP Field:projecteid | Table: qef_projecte | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projecteid", referencedColumnName ="projecteID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modifqef_projecte_proje_fk"))
    private ProjecteJPA projecte;

    public ProjecteJPA getProjecte() {
    return this.projecte;
  }

    public  void setProjecte(ProjecteJPA projecte) {
    this.projecte = projecte;
  }


 // ---------------  STATIC METHODS ------------------
  public static ModificacioQueEsticFentJPA toJPA(ModificacioQueEsticFent __bean) {
    if (__bean == null) { return null;}
    ModificacioQueEsticFentJPA __tmp = new ModificacioQueEsticFentJPA();
    __tmp.setModificacioID(__bean.getModificacioID());
    __tmp.setAccioID(__bean.getAccioID());
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setProjecteID(__bean.getProjecteID());
    __tmp.setQueEsticFentID(__bean.getQueEsticFentID());
    __tmp.setDada1(__bean.getDada1());
    __tmp.setDada2(__bean.getDada2());
    __tmp.setData(__bean.getData());
		return __tmp;
	}


  public static ModificacioQueEsticFentJPA copyJPA(ModificacioQueEsticFentJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<ModificacioQueEsticFentJPA> copyJPA(java.util.Set<ModificacioQueEsticFentJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<ModificacioQueEsticFentJPA> __tmpSet = (java.util.Set<ModificacioQueEsticFentJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<ModificacioQueEsticFentJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (ModificacioQueEsticFentJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static ModificacioQueEsticFentJPA copyJPA(ModificacioQueEsticFentJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    ModificacioQueEsticFentJPA __tmp = (ModificacioQueEsticFentJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"AccioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.accio) || org.hibernate.Hibernate.isInitialized(__jpa.getAccio()) ) ) {
      __tmp.setAccio(AccioJPA.copyJPA(__jpa.getAccio(), __alreadyCopied,"ModificacioQueEsticFentJPA"));
    }
    if(!"ProjecteJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.projecte) || org.hibernate.Hibernate.isInitialized(__jpa.getProjecte()) ) ) {
      __tmp.setProjecte(ProjecteJPA.copyJPA(__jpa.getProjecte(), __alreadyCopied,"ModificacioQueEsticFentJPA"));
    }

    return __tmp;
  }




}
