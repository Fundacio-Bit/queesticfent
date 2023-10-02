
package org.fundaciobit.queesticfent.persistence;
import org.fundaciobit.queesticfent.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Id;


@Entity(name = "DepartamentsJPA")
@Table(name = "qef_departaments" , indexes = { 
        @Index(name="qef_departaments_pk_i", columnList = "departamentid")})
@SequenceGenerator(name="DEPARTAMENTS_SEQ", sequenceName="qef_departaments_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class DepartamentsJPA implements Departaments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEPARTAMENTS_SEQ")
    @Column(name="departamentid",nullable = false,length = 19)
    long departamentID;

    @Column(name="nom",nullable = false,length = 300)
    java.lang.String nom;

    @Column(name="coordinadorid",nullable = false,length = 200)
    java.lang.String coordinadorId;

    @Column(name="nomldap",nullable = false,length = 200)
    java.lang.String nomLDAP;

    @Column(name="descripcio",nullable = false,length = 3000)
    java.lang.String descripcio;



  /** Constructor Buit */
  public DepartamentsJPA() {
  }

  /** Constructor amb tots els camps  */
  public DepartamentsJPA(long departamentID , java.lang.String nom , java.lang.String coordinadorId , java.lang.String nomLDAP , java.lang.String descripcio) {
    this.departamentID=departamentID;
    this.nom=nom;
    this.coordinadorId=coordinadorId;
    this.nomLDAP=nomLDAP;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public DepartamentsJPA(java.lang.String nom , java.lang.String coordinadorId , java.lang.String nomLDAP , java.lang.String descripcio) {
    this.nom=nom;
    this.coordinadorId=coordinadorId;
    this.nomLDAP=nomLDAP;
    this.descripcio=descripcio;
}
  public DepartamentsJPA(Departaments __bean) {
    this.setDepartamentID(__bean.getDepartamentID());
    this.setNom(__bean.getNom());
    this.setCoordinadorId(__bean.getCoordinadorId());
    this.setNomLDAP(__bean.getNomLDAP());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getDepartamentID() {
		return(departamentID);
	};
	public void setDepartamentID(long _departamentID_) {
		this.departamentID = _departamentID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getCoordinadorId() {
		return(coordinadorId);
	};
	public void setCoordinadorId(java.lang.String _coordinadorId_) {
		this.coordinadorId = _coordinadorId_;
	};

	public java.lang.String getNomLDAP() {
		return(nomLDAP);
	};
	public void setNomLDAP(java.lang.String _nomLDAP_) {
		this.nomLDAP = _nomLDAP_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Departaments) {
      Departaments __instance = (Departaments)__obj;
      __result = true;
      __result = __result && (this.getDepartamentID() == __instance.getDepartamentID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:departamentid | Table: qef_projectes | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departaments")
    private Set<ProjectesJPA> projectess = new HashSet<ProjectesJPA>(0);
    public  Set<ProjectesJPA> getProjectess() {
    return this.projectess;
  }

    public void setProjectess(Set<ProjectesJPA> projectess) {
      this.projectess = projectess;
    }


// EXP  Field:departamentid | Table: qef_usuarisdepartament | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departaments")
    private Set<UsuarisDepartamentJPA> usuarisDepartaments = new HashSet<UsuarisDepartamentJPA>(0);
    public  Set<UsuarisDepartamentJPA> getUsuarisDepartaments() {
    return this.usuarisDepartaments;
  }

    public void setUsuarisDepartaments(Set<UsuarisDepartamentJPA> usuarisDepartaments) {
      this.usuarisDepartaments = usuarisDepartaments;
    }



 // ---------------  STATIC METHODS ------------------
  public static DepartamentsJPA toJPA(Departaments __bean) {
    if (__bean == null) { return null;}
    DepartamentsJPA __tmp = new DepartamentsJPA();
    __tmp.setDepartamentID(__bean.getDepartamentID());
    __tmp.setNom(__bean.getNom());
    __tmp.setCoordinadorId(__bean.getCoordinadorId());
    __tmp.setNomLDAP(__bean.getNomLDAP());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}


  public static DepartamentsJPA copyJPA(DepartamentsJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<DepartamentsJPA> copyJPA(java.util.Set<DepartamentsJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<DepartamentsJPA> __tmpSet = (java.util.Set<DepartamentsJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<DepartamentsJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (DepartamentsJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static DepartamentsJPA copyJPA(DepartamentsJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    DepartamentsJPA __tmp = (DepartamentsJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"ProjectesJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.projectess) || org.hibernate.Hibernate.isInitialized(__jpa.getProjectess())) ) {
      __tmp.setProjectess(ProjectesJPA.copyJPA(__jpa.getProjectess(), __alreadyCopied,"DepartamentsJPA"));
    }
    if(!"UsuarisDepartamentJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.usuarisDepartaments) || org.hibernate.Hibernate.isInitialized(__jpa.getUsuarisDepartaments())) ) {
      __tmp.setUsuarisDepartaments(UsuarisDepartamentJPA.copyJPA(__jpa.getUsuarisDepartaments(), __alreadyCopied,"DepartamentsJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
