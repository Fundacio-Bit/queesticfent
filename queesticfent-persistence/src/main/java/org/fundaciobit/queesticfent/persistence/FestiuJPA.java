
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


@Entity(name = "FestiuJPA")
@Table(name = "qef_festiu" , indexes = { 
        @Index(name="qef_festiu_pk_i", columnList = "festiuid")})
@SequenceGenerator(name="FESTIU_SEQ", sequenceName="qef_festiu_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class FestiuJPA implements Festiu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="FESTIU_SEQ")
    @Column(name="festiuid",nullable = false,length = 19)
    long festiuID;

    @Column(name="nom",nullable = false,length = 300)
    java.lang.String nom;

    @Column(name="data",nullable = false,length = 13)
    java.sql.Date data;

    @Column(name="descripcio",length = 2000)
    java.lang.String descripcio;



  /** Constructor Buit */
  public FestiuJPA() {
  }

  /** Constructor amb tots els camps  */
  public FestiuJPA(long festiuID , java.lang.String nom , java.sql.Date data , java.lang.String descripcio) {
    this.festiuID=festiuID;
    this.nom=nom;
    this.data=data;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public FestiuJPA(java.lang.String nom , java.sql.Date data , java.lang.String descripcio) {
    this.nom=nom;
    this.data=data;
    this.descripcio=descripcio;
}
  public FestiuJPA(Festiu __bean) {
    this.setFestiuID(__bean.getFestiuID());
    this.setNom(__bean.getNom());
    this.setData(__bean.getData());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getFestiuID() {
		return(festiuID);
	};
	public void setFestiuID(long _festiuID_) {
		this.festiuID = _festiuID_;
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
        if (__obj != null && __obj instanceof Festiu) {
            Festiu __instance = (Festiu)__obj;
            __result = true;
            __result = __result && (this.getFestiuID() == __instance.getFestiuID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getFestiuID())).hashCode();
    }


 // ---------------  STATIC METHODS ------------------
  public static FestiuJPA toJPA(Festiu __bean) {
    if (__bean == null) { return null;}
    FestiuJPA __tmp = new FestiuJPA();
    __tmp.setFestiuID(__bean.getFestiuID());
    __tmp.setNom(__bean.getNom());
    __tmp.setData(__bean.getData());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}


  public static FestiuJPA copyJPA(FestiuJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<FestiuJPA> copyJPA(java.util.Set<FestiuJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<FestiuJPA> __tmpSet = (java.util.Set<FestiuJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<FestiuJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (FestiuJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static FestiuJPA copyJPA(FestiuJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    FestiuJPA __tmp = (FestiuJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
