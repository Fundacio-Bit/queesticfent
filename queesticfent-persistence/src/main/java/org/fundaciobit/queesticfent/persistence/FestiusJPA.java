
package org.fundaciobit.queesticfent.persistence;
import org.fundaciobit.queesticfent.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;


@Entity(name = "FestiusJPA")
@Table(name = "qef_festius" , indexes = { 
        @Index(name="qef_festiu_pk_i", columnList = "festiuid")})
@SequenceGenerator(name="FESTIUS_SEQ", sequenceName="qef_festius_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class FestiusJPA implements Festius {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FESTIUS_SEQ")
    @Column(name="festiuid",nullable = false,length = 19)
    long festiuid;

    @Column(name="nom",nullable = false,length = 300)
    java.lang.String nom;

    @Column(name="data",nullable = false,length = 13)
    java.sql.Date data;

    @Column(name="descripcio",length = 2000)
    java.lang.String descripcio;



  /** Constructor Buit */
  public FestiusJPA() {
  }

  /** Constructor amb tots els camps  */
  public FestiusJPA(long festiuid , java.lang.String nom , java.sql.Date data , java.lang.String descripcio) {
    this.festiuid=festiuid;
    this.nom=nom;
    this.data=data;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public FestiusJPA(java.lang.String nom , java.sql.Date data , java.lang.String descripcio) {
    this.nom=nom;
    this.data=data;
    this.descripcio=descripcio;
}
  public FestiusJPA(Festius __bean) {
    this.setFestiuid(__bean.getFestiuid());
    this.setNom(__bean.getNom());
    this.setData(__bean.getData());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getFestiuid() {
		return(festiuid);
	};
	public void setFestiuid(long _festiuid_) {
		this.festiuid = _festiuid_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.sql.Date getData() {
		return(data);
	};
	public void setData(java.sql.Date _data_) {
		this.data = _data_;
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
    if (__obj != null && __obj instanceof Festius) {
      Festius __instance = (Festius)__obj;
      __result = true;
      __result = __result && (this.getFestiuid() == __instance.getFestiuid()) ;
    } else {
      __result = false;
    }
    return __result;
  }


 // ---------------  STATIC METHODS ------------------
  public static FestiusJPA toJPA(Festius __bean) {
    if (__bean == null) { return null;}
    FestiusJPA __tmp = new FestiusJPA();
    __tmp.setFestiuid(__bean.getFestiuid());
    __tmp.setNom(__bean.getNom());
    __tmp.setData(__bean.getData());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}


  public static FestiusJPA copyJPA(FestiusJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<FestiusJPA> copyJPA(java.util.Set<FestiusJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<FestiusJPA> __tmpSet = (java.util.Set<FestiusJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<FestiusJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (FestiusJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static FestiusJPA copyJPA(FestiusJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    FestiusJPA __tmp = (FestiusJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
