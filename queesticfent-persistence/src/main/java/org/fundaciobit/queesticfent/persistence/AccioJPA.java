
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


@Entity(name = "AccioJPA")
@Table(name = "qef_accio" , indexes = { 
        @Index(name="qef_accions_pk_i", columnList = "accioid")})
@SequenceGenerator(name="ACCIO_SEQ", sequenceName="qef_accio_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class AccioJPA implements Accio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ACCIO_SEQ")
    @Column(name="accioid",nullable = false,length = 19)
    long accioID;

    @Column(name="nom",nullable = false,length = 45)
    java.lang.String nom;

    @Column(name="nomllegenda",nullable = false,length = 45)
    java.lang.String nomllegenda;

    @Column(name="color",length = 2147483647)
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    java.lang.String color;

    @Column(name="descripcio",length = 500)
    java.lang.String descripcio;



  /** Constructor Buit */
  public AccioJPA() {
  }

  /** Constructor amb tots els camps  */
  public AccioJPA(long accioID , java.lang.String nom , java.lang.String nomllegenda , java.lang.String color , java.lang.String descripcio) {
    this.accioID=accioID;
    this.nom=nom;
    this.nomllegenda=nomllegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public AccioJPA(java.lang.String nom , java.lang.String nomllegenda , java.lang.String color , java.lang.String descripcio) {
    this.nom=nom;
    this.nomllegenda=nomllegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor dels valors Not Null */
  public AccioJPA(long accioID , java.lang.String nom , java.lang.String nomllegenda) {
    this.accioID=accioID;
    this.nom=nom;
    this.nomllegenda=nomllegenda;
}
  public AccioJPA(Accio __bean) {
    this.setAccioID(__bean.getAccioID());
    this.setNom(__bean.getNom());
    this.setNomllegenda(__bean.getNomllegenda());
    this.setColor(__bean.getColor());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getAccioID() {
		return(accioID);
	};
	public void setAccioID(long _accioID_) {
		this.accioID = _accioID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getNomllegenda() {
		return(nomllegenda);
	};
	public void setNomllegenda(java.lang.String _nomllegenda_) {
		this.nomllegenda = _nomllegenda_;
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
        if (__obj != null && __obj instanceof Accio) {
            Accio __instance = (Accio)__obj;
            __result = true;
            __result = __result && (this.getAccioID() == __instance.getAccioID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getAccioID())).hashCode();
    }

// EXP  Field:accioid | Table: qef_entrada | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accio")
    private Set<EntradaJPA> entradas = new HashSet<EntradaJPA>(0);
    public  Set<EntradaJPA> getEntradas() {
    return this.entradas;
  }

    public void setEntradas(Set<EntradaJPA> entradas) {
      this.entradas = entradas;
    }


// EXP  Field:accioid | Table: qef_modificacioqueesticfent | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accio")
    private Set<ModificacioQueEsticFentJPA> modificacioQueEsticFents = new HashSet<ModificacioQueEsticFentJPA>(0);
    public  Set<ModificacioQueEsticFentJPA> getModificacioQueEsticFents() {
    return this.modificacioQueEsticFents;
  }

    public void setModificacioQueEsticFents(Set<ModificacioQueEsticFentJPA> modificacioQueEsticFents) {
      this.modificacioQueEsticFents = modificacioQueEsticFents;
    }



 // ---------------  STATIC METHODS ------------------
  public static AccioJPA toJPA(Accio __bean) {
    if (__bean == null) { return null;}
    AccioJPA __tmp = new AccioJPA();
    __tmp.setAccioID(__bean.getAccioID());
    __tmp.setNom(__bean.getNom());
    __tmp.setNomllegenda(__bean.getNomllegenda());
    __tmp.setColor(__bean.getColor());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}


  public static AccioJPA copyJPA(AccioJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<AccioJPA> copyJPA(java.util.Set<AccioJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<AccioJPA> __tmpSet = (java.util.Set<AccioJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<AccioJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (AccioJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static AccioJPA copyJPA(AccioJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    AccioJPA __tmp = (AccioJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"EntradaJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.entradas) || org.hibernate.Hibernate.isInitialized(__jpa.getEntradas())) ) {
      __tmp.setEntradas(EntradaJPA.copyJPA(__jpa.getEntradas(), __alreadyCopied,"AccioJPA"));
    }
    if(!"ModificacioQueEsticFentJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.modificacioQueEsticFents) || org.hibernate.Hibernate.isInitialized(__jpa.getModificacioQueEsticFents())) ) {
      __tmp.setModificacioQueEsticFents(ModificacioQueEsticFentJPA.copyJPA(__jpa.getModificacioQueEsticFents(), __alreadyCopied,"AccioJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
