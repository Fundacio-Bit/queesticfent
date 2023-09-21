
package org.fundaciobit.queesticfent.persistence;
import org.fundaciobit.queesticfent.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;
import org.hibernate.annotations.Type;
import javax.persistence.Id;


@Entity(name = "AccionsJPA")
@Table(name = "qef_accions" , indexes = { 
        @Index(name="qef_accions_pk_i", columnList = "accioid")})
@SequenceGenerator(name="ACCIONS_SEQ", sequenceName="qef_accions_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class AccionsJPA implements Accions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ACCIONS_SEQ")
    @Column(name="accioid",nullable = false,length = 19)
    long accioId;

    @Column(name="nom",nullable = false,length = 45)
    java.lang.String nom;

    @Column(name="nomllegenda",nullable = false,length = 45)
    java.lang.String nomLlegenda;

    @Column(name="color",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String color;

    @Column(name="descripcio",length = 500)
    java.lang.String descripcio;



  /** Constructor Buit */
  public AccionsJPA() {
  }

  /** Constructor amb tots els camps  */
  public AccionsJPA(long accioId , java.lang.String nom , java.lang.String nomLlegenda , java.lang.String color , java.lang.String descripcio) {
    this.accioId=accioId;
    this.nom=nom;
    this.nomLlegenda=nomLlegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public AccionsJPA(java.lang.String nom , java.lang.String nomLlegenda , java.lang.String color , java.lang.String descripcio) {
    this.nom=nom;
    this.nomLlegenda=nomLlegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor dels valors Not Null */
  public AccionsJPA(long accioId , java.lang.String nom , java.lang.String nomLlegenda) {
    this.accioId=accioId;
    this.nom=nom;
    this.nomLlegenda=nomLlegenda;
}
  public AccionsJPA(Accions __bean) {
    this.setAccioId(__bean.getAccioId());
    this.setNom(__bean.getNom());
    this.setNomLlegenda(__bean.getNomLlegenda());
    this.setColor(__bean.getColor());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getAccioId() {
		return(accioId);
	};
	public void setAccioId(long _accioId_) {
		this.accioId = _accioId_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getNomLlegenda() {
		return(nomLlegenda);
	};
	public void setNomLlegenda(java.lang.String _nomLlegenda_) {
		this.nomLlegenda = _nomLlegenda_;
	};

	public java.lang.String getColor() {
		return(color);
	};
	public void setColor(java.lang.String _color_) {
		this.color = _color_;
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
    if (__obj != null && __obj instanceof Accions) {
      Accions __instance = (Accions)__obj;
      __result = true;
      __result = __result && (this.getAccioId() == __instance.getAccioId()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:accioid | Table: qef_modificacionsqueesticfent | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accions")
    private Set<ModificacionsQueEsticFentJPA> modificacionsQueEsticFents = new HashSet<ModificacionsQueEsticFentJPA>(0);
    public  Set<ModificacionsQueEsticFentJPA> getModificacionsQueEsticFents() {
    return this.modificacionsQueEsticFents;
  }

    public void setModificacionsQueEsticFents(Set<ModificacionsQueEsticFentJPA> modificacionsQueEsticFents) {
      this.modificacionsQueEsticFents = modificacionsQueEsticFents;
    }



 // ---------------  STATIC METHODS ------------------
  public static AccionsJPA toJPA(Accions __bean) {
    if (__bean == null) { return null;}
    AccionsJPA __tmp = new AccionsJPA();
    __tmp.setAccioId(__bean.getAccioId());
    __tmp.setNom(__bean.getNom());
    __tmp.setNomLlegenda(__bean.getNomLlegenda());
    __tmp.setColor(__bean.getColor());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}


  public static AccionsJPA copyJPA(AccionsJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<AccionsJPA> copyJPA(java.util.Set<AccionsJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<AccionsJPA> __tmpSet = (java.util.Set<AccionsJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<AccionsJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (AccionsJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static AccionsJPA copyJPA(AccionsJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    AccionsJPA __tmp = (AccionsJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"ModificacionsQueEsticFentJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.modificacionsQueEsticFents) || org.hibernate.Hibernate.isInitialized(__jpa.getModificacionsQueEsticFents())) ) {
      __tmp.setModificacionsQueEsticFents(ModificacionsQueEsticFentJPA.copyJPA(__jpa.getModificacionsQueEsticFents(), __alreadyCopied,"AccionsJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
