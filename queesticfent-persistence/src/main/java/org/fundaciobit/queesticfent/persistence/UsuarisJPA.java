
package org.fundaciobit.queesticfent.persistence;
import org.fundaciobit.queesticfent.model.entity.*;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.Id;


@Entity(name = "UsuarisJPA")
@Table(name = "qef_usuaris" , indexes = { 
        @Index(name="qef_usuaris_pk_i", columnList = "usuariid")})
@SequenceGenerator(name="USUARIS_SEQ", sequenceName="qef_usuaris_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class UsuarisJPA implements Usuaris {

    @Id
    @Column(name="usuariid",nullable = false,length = 100)
    java.lang.String usuariID;

    @Column(name="llinatge1",length = 100)
    java.lang.String llinatge1;

    @Column(name="llinatge2",length = 100)
    java.lang.String llinatge2;

    @Column(name="nom",nullable = false,length = 100)
    java.lang.String nom;

    @Column(name="correu",nullable = false,length = 100)
    java.lang.String correu;

    @Column(name="descripcio",length = 100)
    java.lang.String descripcio;

    @Column(name="extensio",length = 100)
    java.lang.String extensio;

    @Column(name="naixement",length = 13)
    java.sql.Date naixement;

    @Column(name="telefoncasa",length = 100)
    java.lang.String telefoncasa;

    @Column(name="telefonmobil",length = 100)
    java.lang.String telefonmobil;

    @Column(name="contrasenya",length = 100)
    java.lang.String contrasenya;



  /** Constructor Buit */
  public UsuarisJPA() {
  }

  /** Constructor amb tots els camps  */
  public UsuarisJPA(java.lang.String usuariID , java.lang.String llinatge1 , java.lang.String llinatge2 , java.lang.String nom , java.lang.String correu , java.lang.String descripcio , java.lang.String extensio , java.sql.Date naixement , java.lang.String telefoncasa , java.lang.String telefonmobil , java.lang.String contrasenya) {
    this.usuariID=usuariID;
    this.llinatge1=llinatge1;
    this.llinatge2=llinatge2;
    this.nom=nom;
    this.correu=correu;
    this.descripcio=descripcio;
    this.extensio=extensio;
    this.naixement=naixement;
    this.telefoncasa=telefoncasa;
    this.telefonmobil=telefonmobil;
    this.contrasenya=contrasenya;
}
  /** Constructor dels valors Not Null */
  public UsuarisJPA(java.lang.String usuariID , java.lang.String nom , java.lang.String correu) {
    this.usuariID=usuariID;
    this.nom=nom;
    this.correu=correu;
}
  public UsuarisJPA(Usuaris __bean) {
    this.setUsuariID(__bean.getUsuariID());
    this.setLlinatge1(__bean.getLlinatge1());
    this.setLlinatge2(__bean.getLlinatge2());
    this.setNom(__bean.getNom());
    this.setCorreu(__bean.getCorreu());
    this.setDescripcio(__bean.getDescripcio());
    this.setExtensio(__bean.getExtensio());
    this.setNaixement(__bean.getNaixement());
    this.setTelefoncasa(__bean.getTelefoncasa());
    this.setTelefonmobil(__bean.getTelefonmobil());
    this.setContrasenya(__bean.getContrasenya());
	}

	public java.lang.String getUsuariID() {
		return(usuariID);
	};
	public void setUsuariID(java.lang.String _usuariID_) {
		this.usuariID = _usuariID_;
	};

	public java.lang.String getLlinatge1() {
		return(llinatge1);
	};
	public void setLlinatge1(java.lang.String _llinatge1_) {
		this.llinatge1 = _llinatge1_;
	};

	public java.lang.String getLlinatge2() {
		return(llinatge2);
	};
	public void setLlinatge2(java.lang.String _llinatge2_) {
		this.llinatge2 = _llinatge2_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getCorreu() {
		return(correu);
	};
	public void setCorreu(java.lang.String _correu_) {
		this.correu = _correu_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.String getExtensio() {
		return(extensio);
	};
	public void setExtensio(java.lang.String _extensio_) {
		this.extensio = _extensio_;
	};

	public java.sql.Date getNaixement() {
		return(naixement);
	};
	public void setNaixement(java.sql.Date _naixement_) {
		this.naixement = _naixement_;
	};

	public java.lang.String getTelefoncasa() {
		return(telefoncasa);
	};
	public void setTelefoncasa(java.lang.String _telefoncasa_) {
		this.telefoncasa = _telefoncasa_;
	};

	public java.lang.String getTelefonmobil() {
		return(telefonmobil);
	};
	public void setTelefonmobil(java.lang.String _telefonmobil_) {
		this.telefonmobil = _telefonmobil_;
	};

	public java.lang.String getContrasenya() {
		return(contrasenya);
	};
	public void setContrasenya(java.lang.String _contrasenya_) {
		this.contrasenya = _contrasenya_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Usuaris) {
      Usuaris __instance = (Usuaris)__obj;
      __result = true;
      if (this.getUsuariID() == null) {
        __result = __result && (__instance.getUsuariID() == null);
      } else {
        __result = __result && this.getUsuariID().equals(__instance.getUsuariID()) ;
      }

    } else {
      __result = false;
    }
    return __result;
  }

// EXP  Field:usuariid | Table: qef_grupsusuari | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuaris")
    private Set<GrupsusuariJPA> grupsusuaris = new HashSet<GrupsusuariJPA>(0);
    public  Set<GrupsusuariJPA> getGrupsusuaris() {
    return this.grupsusuaris;
  }

    public void setGrupsusuaris(Set<GrupsusuariJPA> grupsusuaris) {
      this.grupsusuaris = grupsusuaris;
    }


// EXP  Field:usuariid | Table: qef_usuarisdepartament | Type: 0  

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuaris")
    private Set<UsuarisDepartamentJPA> usuarisDepartaments = new HashSet<UsuarisDepartamentJPA>(0);
    public  Set<UsuarisDepartamentJPA> getUsuarisDepartaments() {
    return this.usuarisDepartaments;
  }

    public void setUsuarisDepartaments(Set<UsuarisDepartamentJPA> usuarisDepartaments) {
      this.usuarisDepartaments = usuarisDepartaments;
    }



 // ---------------  STATIC METHODS ------------------
  public static UsuarisJPA toJPA(Usuaris __bean) {
    if (__bean == null) { return null;}
    UsuarisJPA __tmp = new UsuarisJPA();
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setLlinatge1(__bean.getLlinatge1());
    __tmp.setLlinatge2(__bean.getLlinatge2());
    __tmp.setNom(__bean.getNom());
    __tmp.setCorreu(__bean.getCorreu());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setExtensio(__bean.getExtensio());
    __tmp.setNaixement(__bean.getNaixement());
    __tmp.setTelefoncasa(__bean.getTelefoncasa());
    __tmp.setTelefonmobil(__bean.getTelefonmobil());
    __tmp.setContrasenya(__bean.getContrasenya());
		return __tmp;
	}


  public static UsuarisJPA copyJPA(UsuarisJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<UsuarisJPA> copyJPA(java.util.Set<UsuarisJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<UsuarisJPA> __tmpSet = (java.util.Set<UsuarisJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<UsuarisJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (UsuarisJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static UsuarisJPA copyJPA(UsuarisJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    UsuarisJPA __tmp = (UsuarisJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    if(!"GrupsusuariJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.grupsusuaris) || org.hibernate.Hibernate.isInitialized(__jpa.getGrupsusuaris())) ) {
      __tmp.setGrupsusuaris(GrupsusuariJPA.copyJPA(__jpa.getGrupsusuaris(), __alreadyCopied,"UsuarisJPA"));
    }
    if(!"UsuarisDepartamentJPA".equals(origenJPA) 
       && ( !org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.usuarisDepartaments) || org.hibernate.Hibernate.isInitialized(__jpa.getUsuarisDepartaments())) ) {
      __tmp.setUsuarisDepartaments(UsuarisDepartamentJPA.copyJPA(__jpa.getUsuarisDepartaments(), __alreadyCopied,"UsuarisJPA"));
    }
    // Copia de beans complexes (IMP)

    return __tmp;
  }




}
