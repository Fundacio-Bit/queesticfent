
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


@Entity(name = "ModificacionsJPA")
@Table(name = "qef_modificacions" , indexes = { 
        @Index(name="qef_modif_pk_i", columnList = "modificacioid"),
        @Index(name="qef_modif_entradaid_fk_i", columnList = "entradaid"),
        @Index(name="qef_modif_accioid_fk_i", columnList = "accioid"),
        @Index(name="qef_modif_oldproject_fk_i", columnList = "oldprojecteid"),
        @Index(name="qef_modif_newproject_fk_i", columnList = "newprojecteid")})
@SequenceGenerator(name="MODIFICACIONS_SEQ", sequenceName="qef_modificacions_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class ModificacionsJPA implements Modificacions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MODIFICACIONS_SEQ")
    @Column(name="modificacioid",nullable = false,length = 19)
    long modificacioid;

    @Column(name="entradaid",nullable = false,length = 19)
    long entradaid;

    @Column(name="accioid",nullable = false,length = 19)
    long accioid;

    @Column(name="oldusuariid",nullable = false,length = 45)
    java.lang.String oldusuariID;

    @Column(name="oldprojecteid",length = 19)
    java.lang.Long oldprojecteID;

    @Column(name="oldqueesticfentid",length = 19)
    java.lang.Long oldqueesticfentid;

    @Column(name="olddada1",length = 500)
    java.lang.String olddada1;

    @Column(name="olddada2",length = 500)
    java.lang.String olddada2;

    @Column(name="olddata",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp olddata;

    @Column(name="newusuariid",nullable = false,length = 45)
    java.lang.String newusuariID;

    @Column(name="newprojecteid",length = 19)
    java.lang.Long newprojecteID;

    @Column(name="newqueesticfentid",length = 19)
    java.lang.Long newqueesticfentid;

    @Column(name="newdada1",length = 500)
    java.lang.String newdada1;

    @Column(name="newdada2",length = 500)
    java.lang.String newdada2;

    @Column(name="newdata",nullable = false,length = 29,precision = 6)
    java.sql.Timestamp newdata;



  /** Constructor Buit */
  public ModificacionsJPA() {
  }

  /** Constructor amb tots els camps  */
  public ModificacionsJPA(long modificacioid , long entradaid , long accioid , java.lang.String oldusuariID , java.lang.Long oldprojecteID , java.lang.Long oldqueesticfentid , java.lang.String olddada1 , java.lang.String olddada2 , java.sql.Timestamp olddata , java.lang.String newusuariID , java.lang.Long newprojecteID , java.lang.Long newqueesticfentid , java.lang.String newdada1 , java.lang.String newdada2 , java.sql.Timestamp newdata) {
    this.modificacioid=modificacioid;
    this.entradaid=entradaid;
    this.accioid=accioid;
    this.oldusuariID=oldusuariID;
    this.oldprojecteID=oldprojecteID;
    this.oldqueesticfentid=oldqueesticfentid;
    this.olddada1=olddada1;
    this.olddada2=olddada2;
    this.olddata=olddata;
    this.newusuariID=newusuariID;
    this.newprojecteID=newprojecteID;
    this.newqueesticfentid=newqueesticfentid;
    this.newdada1=newdada1;
    this.newdada2=newdada2;
    this.newdata=newdata;
}
  /** Constructor sense valors autoincrementals */
  public ModificacionsJPA(long entradaid , long accioid , java.lang.String oldusuariID , java.lang.Long oldprojecteID , java.lang.Long oldqueesticfentid , java.lang.String olddada1 , java.lang.String olddada2 , java.sql.Timestamp olddata , java.lang.String newusuariID , java.lang.Long newprojecteID , java.lang.Long newqueesticfentid , java.lang.String newdada1 , java.lang.String newdada2 , java.sql.Timestamp newdata) {
    this.entradaid=entradaid;
    this.accioid=accioid;
    this.oldusuariID=oldusuariID;
    this.oldprojecteID=oldprojecteID;
    this.oldqueesticfentid=oldqueesticfentid;
    this.olddada1=olddada1;
    this.olddada2=olddada2;
    this.olddata=olddata;
    this.newusuariID=newusuariID;
    this.newprojecteID=newprojecteID;
    this.newqueesticfentid=newqueesticfentid;
    this.newdada1=newdada1;
    this.newdada2=newdada2;
    this.newdata=newdata;
}
  /** Constructor dels valors Not Null */
  public ModificacionsJPA(long modificacioid , long entradaid , long accioid , java.lang.String oldusuariID , java.sql.Timestamp olddata , java.lang.String newusuariID , java.sql.Timestamp newdata) {
    this.modificacioid=modificacioid;
    this.entradaid=entradaid;
    this.accioid=accioid;
    this.oldusuariID=oldusuariID;
    this.olddata=olddata;
    this.newusuariID=newusuariID;
    this.newdata=newdata;
}
  public ModificacionsJPA(Modificacions __bean) {
    this.setModificacioid(__bean.getModificacioid());
    this.setEntradaid(__bean.getEntradaid());
    this.setAccioid(__bean.getAccioid());
    this.setOldusuariID(__bean.getOldusuariID());
    this.setOldprojecteID(__bean.getOldprojecteID());
    this.setOldqueesticfentid(__bean.getOldqueesticfentid());
    this.setOlddada1(__bean.getOlddada1());
    this.setOlddada2(__bean.getOlddada2());
    this.setOlddata(__bean.getOlddata());
    this.setNewusuariID(__bean.getNewusuariID());
    this.setNewprojecteID(__bean.getNewprojecteID());
    this.setNewqueesticfentid(__bean.getNewqueesticfentid());
    this.setNewdada1(__bean.getNewdada1());
    this.setNewdada2(__bean.getNewdada2());
    this.setNewdata(__bean.getNewdata());
	}

	public long getModificacioid() {
		return(modificacioid);
	};
	public void setModificacioid(long _modificacioid_) {
		this.modificacioid = _modificacioid_;
	};

	public long getEntradaid() {
		return(entradaid);
	};
	public void setEntradaid(long _entradaid_) {
		this.entradaid = _entradaid_;
	};

	public long getAccioid() {
		return(accioid);
	};
	public void setAccioid(long _accioid_) {
		this.accioid = _accioid_;
	};

	public java.lang.String getOldusuariID() {
		return(oldusuariID);
	};
	public void setOldusuariID(java.lang.String _oldusuariID_) {
		this.oldusuariID = _oldusuariID_;
	};

	public java.lang.Long getOldprojecteID() {
		return(oldprojecteID);
	};
	public void setOldprojecteID(java.lang.Long _oldprojecteID_) {
		this.oldprojecteID = _oldprojecteID_;
	};

	public java.lang.Long getOldqueesticfentid() {
		return(oldqueesticfentid);
	};
	public void setOldqueesticfentid(java.lang.Long _oldqueesticfentid_) {
		this.oldqueesticfentid = _oldqueesticfentid_;
	};

	public java.lang.String getOlddada1() {
		return(olddada1);
	};
	public void setOlddada1(java.lang.String _olddada1_) {
		this.olddada1 = _olddada1_;
	};

	public java.lang.String getOlddada2() {
		return(olddada2);
	};
	public void setOlddada2(java.lang.String _olddada2_) {
		this.olddada2 = _olddada2_;
	};

	public java.sql.Timestamp getOlddata() {
		return(olddata);
	};
	public void setOlddata(java.sql.Timestamp _olddata_) {
		this.olddata = _olddata_;
	};

	public java.lang.String getNewusuariID() {
		return(newusuariID);
	};
	public void setNewusuariID(java.lang.String _newusuariID_) {
		this.newusuariID = _newusuariID_;
	};

	public java.lang.Long getNewprojecteID() {
		return(newprojecteID);
	};
	public void setNewprojecteID(java.lang.Long _newprojecteID_) {
		this.newprojecteID = _newprojecteID_;
	};

	public java.lang.Long getNewqueesticfentid() {
		return(newqueesticfentid);
	};
	public void setNewqueesticfentid(java.lang.Long _newqueesticfentid_) {
		this.newqueesticfentid = _newqueesticfentid_;
	};

	public java.lang.String getNewdada1() {
		return(newdada1);
	};
	public void setNewdada1(java.lang.String _newdada1_) {
		this.newdada1 = _newdada1_;
	};

	public java.lang.String getNewdada2() {
		return(newdada2);
	};
	public void setNewdada2(java.lang.String _newdada2_) {
		this.newdada2 = _newdada2_;
	};

	public java.sql.Timestamp getNewdata() {
		return(newdata);
	};
	public void setNewdata(java.sql.Timestamp _newdata_) {
		this.newdata = _newdata_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Modificacions) {
      Modificacions __instance = (Modificacions)__obj;
      __result = true;
      __result = __result && (this.getModificacioid() == __instance.getModificacioid()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:entradaid | Table: qef_entrades | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entradaid", referencedColumnName ="entradaID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modif_entrades_entradai_fk"))
    private EntradesJPA entrades;

    public EntradesJPA getEntrades() {
    return this.entrades;
  }

    public  void setEntrades(EntradesJPA entrades) {
    this.entrades = entrades;
  }

// IMP Field:accioid | Table: qef_accions | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accioid", referencedColumnName ="accioID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modif_accions_accioid_fk"))
    private AccionsJPA accions;

    public AccionsJPA getAccions() {
    return this.accions;
  }

    public  void setAccions(AccionsJPA accions) {
    this.accions = accions;
  }

// IMP Field:projecteid | Table: qef_projectes | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oldprojecteid", referencedColumnName ="projecteID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modif_projectes_oldproj_fk"))
    private ProjectesJPA oldprojecte;

    public ProjectesJPA getOldprojecte() {
    return this.oldprojecte;
  }

    public  void setOldprojecte(ProjectesJPA oldprojecte) {
    this.oldprojecte = oldprojecte;
  }

// IMP Field:projecteid | Table: qef_projectes | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "newprojecteid", referencedColumnName ="projecteID", nullable = true, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_modif_projectes_newproj_fk"))
    private ProjectesJPA newprojecte;

    public ProjectesJPA getNewprojecte() {
    return this.newprojecte;
  }

    public  void setNewprojecte(ProjectesJPA newprojecte) {
    this.newprojecte = newprojecte;
  }


 // ---------------  STATIC METHODS ------------------
  public static ModificacionsJPA toJPA(Modificacions __bean) {
    if (__bean == null) { return null;}
    ModificacionsJPA __tmp = new ModificacionsJPA();
    __tmp.setModificacioid(__bean.getModificacioid());
    __tmp.setEntradaid(__bean.getEntradaid());
    __tmp.setAccioid(__bean.getAccioid());
    __tmp.setOldusuariID(__bean.getOldusuariID());
    __tmp.setOldprojecteID(__bean.getOldprojecteID());
    __tmp.setOldqueesticfentid(__bean.getOldqueesticfentid());
    __tmp.setOlddada1(__bean.getOlddada1());
    __tmp.setOlddada2(__bean.getOlddada2());
    __tmp.setOlddata(__bean.getOlddata());
    __tmp.setNewusuariID(__bean.getNewusuariID());
    __tmp.setNewprojecteID(__bean.getNewprojecteID());
    __tmp.setNewqueesticfentid(__bean.getNewqueesticfentid());
    __tmp.setNewdada1(__bean.getNewdada1());
    __tmp.setNewdada2(__bean.getNewdada2());
    __tmp.setNewdata(__bean.getNewdata());
		return __tmp;
	}


  public static ModificacionsJPA copyJPA(ModificacionsJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<ModificacionsJPA> copyJPA(java.util.Set<ModificacionsJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<ModificacionsJPA> __tmpSet = (java.util.Set<ModificacionsJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<ModificacionsJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (ModificacionsJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static ModificacionsJPA copyJPA(ModificacionsJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    ModificacionsJPA __tmp = (ModificacionsJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"AccionsJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.accions) || org.hibernate.Hibernate.isInitialized(__jpa.getAccions()) ) ) {
      __tmp.setAccions(AccionsJPA.copyJPA(__jpa.getAccions(), __alreadyCopied,"ModificacionsJPA"));
    }
    if(!"ProjectesJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.oldprojecte) || org.hibernate.Hibernate.isInitialized(__jpa.getOldprojecte()) ) ) {
      __tmp.setOldprojecte(ProjectesJPA.copyJPA(__jpa.getOldprojecte(), __alreadyCopied,"ModificacionsJPA"));
    }
    if(!"ProjectesJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.newprojecte) || org.hibernate.Hibernate.isInitialized(__jpa.getNewprojecte()) ) ) {
      __tmp.setNewprojecte(ProjectesJPA.copyJPA(__jpa.getNewprojecte(), __alreadyCopied,"ModificacionsJPA"));
    }
    if(!"EntradesJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.entrades) || org.hibernate.Hibernate.isInitialized(__jpa.getEntrades()) ) ) {
      __tmp.setEntrades(EntradesJPA.copyJPA(__jpa.getEntrades(), __alreadyCopied,"ModificacionsJPA"));
    }

    return __tmp;
  }




}
