
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


@Entity(name = "ProjectesJPA")
@Table(name = "qef_projectes" , indexes = { 
        @Index(name="qef_projectes_pk_i", columnList = "projecteid"),
        @Index(name="qef_projectes_departamen_fk_i", columnList = "departamentid")})
@SequenceGenerator(name="PROJECTES_SEQ", sequenceName="qef_projectes_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class ProjectesJPA implements Projectes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PROJECTES_SEQ")
    @Column(name="projecteid",nullable = false,length = 19)
    long projecteid;

    @Column(name="nom",nullable = false,length = 45)
    java.lang.String nom;

    @Column(name="departamentid",nullable = false,length = 19)
    long departamentid;

    @Column(name="descripcio",length = 500)
    java.lang.String descripcio;

    @Column(name="actiu",length = 10)
    boolean actiu;

    @Column(name="fromdata",nullable = false,length = 13)
    java.sql.Date fromdata;

    @Column(name="todata",length = 13)
    java.sql.Date todata;

    @Column(name="actiu2",length = 1)
    boolean actiu2;



  /** Constructor Buit */
  public ProjectesJPA() {
  }

  /** Constructor amb tots els camps  */
  public ProjectesJPA(long projecteid , java.lang.String nom , long departamentid , java.lang.String descripcio , boolean actiu , java.sql.Date fromdata , java.sql.Date todata , boolean actiu2) {
    this.projecteid=projecteid;
    this.nom=nom;
    this.departamentid=departamentid;
    this.descripcio=descripcio;
    this.actiu=actiu;
    this.fromdata=fromdata;
    this.todata=todata;
    this.actiu2=actiu2;
}
  /** Constructor sense valors autoincrementals */
  public ProjectesJPA(java.lang.String nom , long departamentid , java.lang.String descripcio , boolean actiu , java.sql.Date fromdata , java.sql.Date todata , boolean actiu2) {
    this.nom=nom;
    this.departamentid=departamentid;
    this.descripcio=descripcio;
    this.actiu=actiu;
    this.fromdata=fromdata;
    this.todata=todata;
    this.actiu2=actiu2;
}
  /** Constructor dels valors Not Null */
  public ProjectesJPA(long projecteid , java.lang.String nom , long departamentid , java.sql.Date fromdata) {
    this.projecteid=projecteid;
    this.nom=nom;
    this.departamentid=departamentid;
    this.fromdata=fromdata;
}
  public ProjectesJPA(Projectes __bean) {
    this.setProjecteid(__bean.getProjecteid());
    this.setNom(__bean.getNom());
    this.setDepartamentid(__bean.getDepartamentid());
    this.setDescripcio(__bean.getDescripcio());
    this.setActiu(__bean.isActiu());
    this.setFromdata(__bean.getFromdata());
    this.setTodata(__bean.getTodata());
    this.setActiu2(__bean.isActiu2());
	}

	public long getProjecteid() {
		return(projecteid);
	};
	public void setProjecteid(long _projecteid_) {
		this.projecteid = _projecteid_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public long getDepartamentid() {
		return(departamentid);
	};
	public void setDepartamentid(long _departamentid_) {
		this.departamentid = _departamentid_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public boolean isActiu() {
		return(actiu);
	};
	public void setActiu(boolean _actiu_) {
		this.actiu = _actiu_;
	};

	public java.sql.Date getFromdata() {
		return(fromdata);
	};
	public void setFromdata(java.sql.Date _fromdata_) {
		this.fromdata = _fromdata_;
	};

	public java.sql.Date getTodata() {
		return(todata);
	};
	public void setTodata(java.sql.Date _todata_) {
		this.todata = _todata_;
	};

	public boolean isActiu2() {
		return(actiu2);
	};
	public void setActiu2(boolean _actiu2_) {
		this.actiu2 = _actiu2_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Projectes) {
      Projectes __instance = (Projectes)__obj;
      __result = true;
      __result = __result && (this.getProjecteid() == __instance.getProjecteid()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:projecteid | Table: qef_modificacionsqueesticfent | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectes")
    private Set<ModificacionsQueEsticFentJPA> modificacionsQueEsticFents = new HashSet<ModificacionsQueEsticFentJPA>(0);
    public  Set<ModificacionsQueEsticFentJPA> getModificacionsQueEsticFents() {
    return this.modificacionsQueEsticFents;
  }

    public void setModificacionsQueEsticFents(Set<ModificacionsQueEsticFentJPA> modificacionsQueEsticFents) {
      this.modificacionsQueEsticFents = modificacionsQueEsticFents;
    }


// EXP  Field:projecteid | Table: qef_personalprojecte | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projectes")
    private Set<PersonalProjecteJPA> personalProjectes = new HashSet<PersonalProjecteJPA>(0);
    public  Set<PersonalProjecteJPA> getPersonalProjectes() {
    return this.personalProjectes;
  }

    public void setPersonalProjectes(Set<PersonalProjecteJPA> personalProjectes) {
      this.personalProjectes = personalProjectes;
    }


// IMP Field:departamentid | Table: qef_departaments | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamentid", referencedColumnName ="departamentid", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_projectes_departamen_d_fk"))
    private DepartamentsJPA departaments;

    public DepartamentsJPA getDepartaments() {
    return this.departaments;
  }

    public  void setDepartaments(DepartamentsJPA departaments) {
    this.departaments = departaments;
  }


 // ---------------  STATIC METHODS ------------------
  public static ProjectesJPA toJPA(Projectes __bean) {
    if (__bean == null) { return null;}
    ProjectesJPA __tmp = new ProjectesJPA();
    __tmp.setProjecteid(__bean.getProjecteid());
    __tmp.setNom(__bean.getNom());
    __tmp.setDepartamentid(__bean.getDepartamentid());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setActiu(__bean.isActiu());
    __tmp.setFromdata(__bean.getFromdata());
    __tmp.setTodata(__bean.getTodata());
    __tmp.setActiu2(__bean.isActiu2());
		return __tmp;
	}


  public static ProjectesJPA copyJPA(ProjectesJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<ProjectesJPA> copyJPA(java.util.Set<ProjectesJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<ProjectesJPA> __tmpSet = (java.util.Set<ProjectesJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<ProjectesJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (ProjectesJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static ProjectesJPA copyJPA(ProjectesJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    ProjectesJPA __tmp = (ProjectesJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"PersonalProjecteJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.personalProjectes) || org.hibernate.Hibernate.isInitialized(__jpa.getPersonalProjectes())) ) {
      __tmp.setPersonalProjectes(PersonalProjecteJPA.copyJPA(__jpa.getPersonalProjectes(), __alreadyCopied,"ProjectesJPA"));
    }
    if(!"ModificacionsQueEsticFentJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.modificacionsQueEsticFents) || org.hibernate.Hibernate.isInitialized(__jpa.getModificacionsQueEsticFents())) ) {
      __tmp.setModificacionsQueEsticFents(ModificacionsQueEsticFentJPA.copyJPA(__jpa.getModificacionsQueEsticFents(), __alreadyCopied,"ProjectesJPA"));
    }
    // Copia de beans complexes (IMP)
    if(!"DepartamentsJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.departaments) || org.hibernate.Hibernate.isInitialized(__jpa.getDepartaments()) ) ) {
      __tmp.setDepartaments(DepartamentsJPA.copyJPA(__jpa.getDepartaments(), __alreadyCopied,"ProjectesJPA"));
    }

    return __tmp;
  }




}
