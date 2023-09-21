
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


@Entity(name = "GrupsJPA")
@Table(name = "qef_grups" , indexes = { 
        @Index(name="qef_grups_pk_i", columnList = "grupid")})
@SequenceGenerator(name="GRUPS_SEQ", sequenceName="qef_grups_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class GrupsJPA implements Grups {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GRUPS_SEQ")
    @Column(name="grupid",nullable = false,length = 19)
    long grupID;

    @Column(name="nom",nullable = false,length = 255)
    java.lang.String nom;

    @Column(name="descripcio",length = 1000)
    java.lang.String descripcio;

    @Column(name="nivellseguretat",length = 19)
    java.lang.Long nivellSeguretat;



  /** Constructor Buit */
  public GrupsJPA() {
  }

  /** Constructor amb tots els camps  */
  public GrupsJPA(long grupID , java.lang.String nom , java.lang.String descripcio , java.lang.Long nivellSeguretat) {
    this.grupID=grupID;
    this.nom=nom;
    this.descripcio=descripcio;
    this.nivellSeguretat=nivellSeguretat;
}
  /** Constructor sense valors autoincrementals */
  public GrupsJPA(java.lang.String nom , java.lang.String descripcio , java.lang.Long nivellSeguretat) {
    this.nom=nom;
    this.descripcio=descripcio;
    this.nivellSeguretat=nivellSeguretat;
}
  /** Constructor dels valors Not Null */
  public GrupsJPA(long grupID , java.lang.String nom) {
    this.grupID=grupID;
    this.nom=nom;
}
  public GrupsJPA(Grups __bean) {
    this.setGrupID(__bean.getGrupID());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setNivellSeguretat(__bean.getNivellSeguretat());
	}

	public long getGrupID() {
		return(grupID);
	};
	public void setGrupID(long _grupID_) {
		this.grupID = _grupID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.Long getNivellSeguretat() {
		return(nivellSeguretat);
	};
	public void setNivellSeguretat(java.lang.Long _nivellSeguretat_) {
		this.nivellSeguretat = _nivellSeguretat_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Grups) {
      Grups __instance = (Grups)__obj;
      __result = true;
      __result = __result && (this.getGrupID() == __instance.getGrupID()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:grupid | Table: qef_grupsusuari | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grups")
    private Set<GrupsusuariJPA> grupsusuaris = new HashSet<GrupsusuariJPA>(0);
    public  Set<GrupsusuariJPA> getGrupsusuaris() {
    return this.grupsusuaris;
  }

    public void setGrupsusuaris(Set<GrupsusuariJPA> grupsusuaris) {
      this.grupsusuaris = grupsusuaris;
    }



 // ---------------  STATIC METHODS ------------------
  public static GrupsJPA toJPA(Grups __bean) {
    if (__bean == null) { return null;}
    GrupsJPA __tmp = new GrupsJPA();
    __tmp.setGrupID(__bean.getGrupID());
    __tmp.setNom(__bean.getNom());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setNivellSeguretat(__bean.getNivellSeguretat());
		return __tmp;
	}


  public static GrupsJPA copyJPA(GrupsJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<GrupsJPA> copyJPA(java.util.Set<GrupsJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<GrupsJPA> __tmpSet = (java.util.Set<GrupsJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<GrupsJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (GrupsJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static GrupsJPA copyJPA(GrupsJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    GrupsJPA __tmp = (GrupsJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"GrupsusuariJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.grupsusuaris) || org.hibernate.Hibernate.isInitialized(__jpa.getGrupsusuaris())) ) {
      __tmp.setGrupsusuaris(GrupsusuariJPA.copyJPA(__jpa.getGrupsusuaris(), __alreadyCopied,"GrupsJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
