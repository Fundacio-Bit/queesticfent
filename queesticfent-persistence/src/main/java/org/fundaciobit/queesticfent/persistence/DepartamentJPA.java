
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


@Entity(name = "DepartamentJPA")
@Table(name = "qef_departament" , indexes = { 
        @Index(name="qef_departaments_pk_i", columnList = "departamentid")})
@SequenceGenerator(name="DEPARTAMENT_SEQ", sequenceName="qef_departament_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class DepartamentJPA implements Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEPARTAMENT_SEQ")
    @Column(name="departamentid",nullable = false,length = 19)
    long departamentID;

    @Column(name="nom",nullable = false,length = 300)
    java.lang.String nom;

    @Column(name="coordinadorid",nullable = false,length = 200)
    java.lang.String coordinadorid;

    @Column(name="nomldap",nullable = false,length = 200)
    java.lang.String nomldap;

    @Column(name="descripcio",length = 3000)
    java.lang.String descripcio;



  /** Constructor Buit */
  public DepartamentJPA() {
  }

  /** Constructor amb tots els camps  */
  public DepartamentJPA(long departamentID , java.lang.String nom , java.lang.String coordinadorid , java.lang.String nomldap , java.lang.String descripcio) {
    this.departamentID=departamentID;
    this.nom=nom;
    this.coordinadorid=coordinadorid;
    this.nomldap=nomldap;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public DepartamentJPA(java.lang.String nom , java.lang.String coordinadorid , java.lang.String nomldap , java.lang.String descripcio) {
    this.nom=nom;
    this.coordinadorid=coordinadorid;
    this.nomldap=nomldap;
    this.descripcio=descripcio;
}
  public DepartamentJPA(Departament __bean) {
    this.setDepartamentID(__bean.getDepartamentID());
    this.setNom(__bean.getNom());
    this.setCoordinadorid(__bean.getCoordinadorid());
    this.setNomldap(__bean.getNomldap());
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

	public java.lang.String getCoordinadorid() {
		return(coordinadorid);
	};
	public void setCoordinadorid(java.lang.String _coordinadorid_) {
		this.coordinadorid = _coordinadorid_;
	};

	public java.lang.String getNomldap() {
		return(nomldap);
	};
	public void setNomldap(java.lang.String _nomldap_) {
		this.nomldap = _nomldap_;
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
        if (__obj != null && __obj instanceof Departament) {
            Departament __instance = (Departament)__obj;
            __result = true;
            __result = __result && (this.getDepartamentID() == __instance.getDepartamentID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getDepartamentID())).hashCode();
    }

// EXP  Field:departamentid | Table: qef_projecte | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departament")
    private Set<ProjecteJPA> projectes = new HashSet<ProjecteJPA>(0);
    public  Set<ProjecteJPA> getProjectes() {
    return this.projectes;
  }

    public void setProjectes(Set<ProjecteJPA> projectes) {
      this.projectes = projectes;
    }


// EXP  Field:departamentid | Table: qef_usuaridepartament | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "departament")
    private Set<UsuariDepartamentJPA> usuariDepartaments = new HashSet<UsuariDepartamentJPA>(0);
    public  Set<UsuariDepartamentJPA> getUsuariDepartaments() {
    return this.usuariDepartaments;
  }

    public void setUsuariDepartaments(Set<UsuariDepartamentJPA> usuariDepartaments) {
      this.usuariDepartaments = usuariDepartaments;
    }



 // ---------------  STATIC METHODS ------------------
  public static DepartamentJPA toJPA(Departament __bean) {
    if (__bean == null) { return null;}
    DepartamentJPA __tmp = new DepartamentJPA();
    __tmp.setDepartamentID(__bean.getDepartamentID());
    __tmp.setNom(__bean.getNom());
    __tmp.setCoordinadorid(__bean.getCoordinadorid());
    __tmp.setNomldap(__bean.getNomldap());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}


  public static DepartamentJPA copyJPA(DepartamentJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<DepartamentJPA> copyJPA(java.util.Set<DepartamentJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<DepartamentJPA> __tmpSet = (java.util.Set<DepartamentJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<DepartamentJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (DepartamentJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static DepartamentJPA copyJPA(DepartamentJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    DepartamentJPA __tmp = (DepartamentJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"ProjecteJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.projectes) || org.hibernate.Hibernate.isInitialized(__jpa.getProjectes())) ) {
      __tmp.setProjectes(ProjecteJPA.copyJPA(__jpa.getProjectes(), __alreadyCopied,"DepartamentJPA"));
    }
    if(!"UsuariDepartamentJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.usuariDepartaments) || org.hibernate.Hibernate.isInitialized(__jpa.getUsuariDepartaments())) ) {
      __tmp.setUsuariDepartaments(UsuariDepartamentJPA.copyJPA(__jpa.getUsuariDepartaments(), __alreadyCopied,"DepartamentJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
