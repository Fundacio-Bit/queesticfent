
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


@Entity(name = "GrupsusuariJPA")
@Table(name = "qef_grupsusuari" , indexes = { 
        @Index(name="qef_grupsusuari_pk_i", columnList = "grupsusuariid"),
        @Index(name="qef_grupsusuari_usuariid_fk_i", columnList = "usuariid"),
        @Index(name="qef_grupsusuari_grupid_fk_i", columnList = "grupid")})
@SequenceGenerator(name="GRUPSUSUARI_SEQ", sequenceName="qef_grupsusuari_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class GrupsusuariJPA implements Grupsusuari {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="GRUPSUSUARI_SEQ")
    @Column(name="grupsusuariid",nullable = false,length = 19)
    long grupsusuariid;

    @Column(name="usuariid",nullable = false,length = 20)
    java.lang.String usuariid;

    @Column(name="grupid",nullable = false,length = 19)
    long grupid;



  /** Constructor Buit */
  public GrupsusuariJPA() {
  }

  /** Constructor amb tots els camps  */
  public GrupsusuariJPA(long grupsusuariid , java.lang.String usuariid , long grupid) {
    this.grupsusuariid=grupsusuariid;
    this.usuariid=usuariid;
    this.grupid=grupid;
}
  /** Constructor sense valors autoincrementals */
  public GrupsusuariJPA(java.lang.String usuariid , long grupid) {
    this.usuariid=usuariid;
    this.grupid=grupid;
}
  public GrupsusuariJPA(Grupsusuari __bean) {
    this.setGrupsusuariid(__bean.getGrupsusuariid());
    this.setUsuariid(__bean.getUsuariid());
    this.setGrupid(__bean.getGrupid());
	}

	public long getGrupsusuariid() {
		return(grupsusuariid);
	};
	public void setGrupsusuariid(long _grupsusuariid_) {
		this.grupsusuariid = _grupsusuariid_;
	};

	public java.lang.String getUsuariid() {
		return(usuariid);
	};
	public void setUsuariid(java.lang.String _usuariid_) {
		this.usuariid = _usuariid_;
	};

	public long getGrupid() {
		return(grupid);
	};
	public void setGrupid(long _grupid_) {
		this.grupid = _grupid_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof Grupsusuari) {
      Grupsusuari __instance = (Grupsusuari)__obj;
      __result = true;
      __result = __result && (this.getGrupsusuariid() == __instance.getGrupsusuariid()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:usuariid | Table: qef_usuaris | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuariid", referencedColumnName ="usuariid", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_grupsusu_usuaris_usuari_fk"))
    private UsuarisJPA usuaris;

    public UsuarisJPA getUsuaris() {
    return this.usuaris;
  }

    public  void setUsuaris(UsuarisJPA usuaris) {
    this.usuaris = usuaris;
  }

// IMP Field:grupid | Table: qef_grups | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupid", referencedColumnName ="grupid", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_grupsusu_grups_grupid_fk"))
    private GrupsJPA grups;

    public GrupsJPA getGrups() {
    return this.grups;
  }

    public  void setGrups(GrupsJPA grups) {
    this.grups = grups;
  }


 // ---------------  STATIC METHODS ------------------
  public static GrupsusuariJPA toJPA(Grupsusuari __bean) {
    if (__bean == null) { return null;}
    GrupsusuariJPA __tmp = new GrupsusuariJPA();
    __tmp.setGrupsusuariid(__bean.getGrupsusuariid());
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setGrupid(__bean.getGrupid());
		return __tmp;
	}


  public static GrupsusuariJPA copyJPA(GrupsusuariJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<GrupsusuariJPA> copyJPA(java.util.Set<GrupsusuariJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<GrupsusuariJPA> __tmpSet = (java.util.Set<GrupsusuariJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<GrupsusuariJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (GrupsusuariJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static GrupsusuariJPA copyJPA(GrupsusuariJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    GrupsusuariJPA __tmp = (GrupsusuariJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"GrupsJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.grups) || org.hibernate.Hibernate.isInitialized(__jpa.getGrups()) ) ) {
      __tmp.setGrups(GrupsJPA.copyJPA(__jpa.getGrups(), __alreadyCopied,"GrupsusuariJPA"));
    }
    if(!"UsuarisJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.usuaris) || org.hibernate.Hibernate.isInitialized(__jpa.getUsuaris()) ) ) {
      __tmp.setUsuaris(UsuarisJPA.copyJPA(__jpa.getUsuaris(), __alreadyCopied,"GrupsusuariJPA"));
    }

    return __tmp;
  }




}
