
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


@Entity(name = "EntradaJPA")
@Table(name = "qef_entrada" , indexes = { 
        @Index(name="qef_entrad_pk_i", columnList = "entradaid"),
        @Index(name="qef_entrada_accioid_fk_i", columnList = "accioid"),
        @Index(name="qef_entrada_projecteid_fk_i", columnList = "projecteid")})
@SequenceGenerator(name="ENTRADA_SEQ", sequenceName="qef_entrada_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class EntradaJPA implements Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ENTRADA_SEQ")
    @Column(name="entradaid",nullable = false,length = 19)
    long entradaID;

    @Column(name="accioid",nullable = false,length = 19)
    long accioID;

    @Column(name="usuariid",nullable = false,length = 45)
    java.lang.String usuariID;

    @Column(name="projecteid",length = 19)
    java.lang.Long projecteID;

    @Column(name="dada1",length = 500)
    java.lang.String dada1;

    @Column(name="queesticfentid",length = 19)
    java.lang.Long queEsticFentID;

    @Column(name="dada2",length = 500)
    java.lang.String dada2;

    @Column(name="data",length = 29,precision = 6)
    java.sql.Timestamp data;



  /** Constructor Buit */
  public EntradaJPA() {
  }

  /** Constructor amb tots els camps  */
  public EntradaJPA(long entradaID , long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.lang.String dada1 , java.lang.Long queEsticFentID , java.lang.String dada2 , java.sql.Timestamp data) {
    this.entradaID=entradaID;
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.dada1=dada1;
    this.queEsticFentID=queEsticFentID;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor sense valors autoincrementals */
  public EntradaJPA(long accioID , java.lang.String usuariID , java.lang.Long projecteID , java.lang.String dada1 , java.lang.Long queEsticFentID , java.lang.String dada2 , java.sql.Timestamp data) {
    this.accioID=accioID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.dada1=dada1;
    this.queEsticFentID=queEsticFentID;
    this.dada2=dada2;
    this.data=data;
}
  /** Constructor dels valors Not Null */
  public EntradaJPA(long entradaID , long accioID , java.lang.String usuariID) {
    this.entradaID=entradaID;
    this.accioID=accioID;
    this.usuariID=usuariID;
}
  public EntradaJPA(Entrada __bean) {
    this.setEntradaID(__bean.getEntradaID());
    this.setAccioID(__bean.getAccioID());
    this.setUsuariID(__bean.getUsuariID());
    this.setProjecteID(__bean.getProjecteID());
    this.setDada1(__bean.getDada1());
    this.setQueEsticFentID(__bean.getQueEsticFentID());
    this.setDada2(__bean.getDada2());
    this.setData(__bean.getData());
	}

	public long getEntradaID() {
		return(entradaID);
	};
	public void setEntradaID(long _entradaID_) {
		this.entradaID = _entradaID_;
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

	public java.lang.String getDada1() {
		return(dada1);
	};
	public void setDada1(java.lang.String _dada1_) {
		this.dada1 = _dada1_;
	};

	public java.lang.Long getQueEsticFentID() {
		return(queEsticFentID);
	};
	public void setQueEsticFentID(java.lang.Long _queEsticFentID_) {
		this.queEsticFentID = _queEsticFentID_;
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
        if (__obj != null && __obj instanceof Entrada) {
            Entrada __instance = (Entrada)__obj;
            __result = true;
            __result = __result && (this.getEntradaID() == __instance.getEntradaID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getEntradaID())).hashCode();
    }

// IMP Field:accioid | Table: qef_accio | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accioid", referencedColumnName ="accioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_entrada_accio_accioid_fk"))
    private AccioJPA accio;

    public AccioJPA getAccio() {
    return this.accio;
  }

    public  void setAccio(AccioJPA accio) {
    this.accio = accio;
  }

// IMP Field:projecteid | Table: qef_projecte | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projecteid", referencedColumnName ="projecteID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_entrada_projecte_projec_fk"))
    private ProjecteJPA projecte;

    public ProjecteJPA getProjecte() {
    return this.projecte;
  }

    public  void setProjecte(ProjecteJPA projecte) {
    this.projecte = projecte;
  }


 // ---------------  STATIC METHODS ------------------
  public static EntradaJPA toJPA(Entrada __bean) {
    if (__bean == null) { return null;}
    EntradaJPA __tmp = new EntradaJPA();
    __tmp.setEntradaID(__bean.getEntradaID());
    __tmp.setAccioID(__bean.getAccioID());
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setProjecteID(__bean.getProjecteID());
    __tmp.setDada1(__bean.getDada1());
    __tmp.setQueEsticFentID(__bean.getQueEsticFentID());
    __tmp.setDada2(__bean.getDada2());
    __tmp.setData(__bean.getData());
		return __tmp;
	}


  public static EntradaJPA copyJPA(EntradaJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<EntradaJPA> copyJPA(java.util.Set<EntradaJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<EntradaJPA> __tmpSet = (java.util.Set<EntradaJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<EntradaJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (EntradaJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static EntradaJPA copyJPA(EntradaJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    EntradaJPA __tmp = (EntradaJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"AccioJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.accio) || org.hibernate.Hibernate.isInitialized(__jpa.getAccio()) ) ) {
      __tmp.setAccio(AccioJPA.copyJPA(__jpa.getAccio(), __alreadyCopied,"EntradaJPA"));
    }
    if(!"ProjecteJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.projecte) || org.hibernate.Hibernate.isInitialized(__jpa.getProjecte()) ) ) {
      __tmp.setProjecte(ProjecteJPA.copyJPA(__jpa.getProjecte(), __alreadyCopied,"EntradaJPA"));
    }

    return __tmp;
  }




}
