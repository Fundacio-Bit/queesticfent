
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


@Entity(name = "UsuariDepartamentJPA")
@Table(name = "qef_usuaridepartament" , indexes = { 
        @Index(name="qef_usudepart_usuariid_fk_i", columnList = "usuariid"),
        @Index(name="qef_usudepart_depid_fk_i", columnList = "departamentid"),
        @Index(name="qef_usuarisdepartament_pk_i", columnList = "usuaridepartamentid")})
@SequenceGenerator(name="USUARIDEPARTAMENT_SEQ", sequenceName="qef_usuaridepartament_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class UsuariDepartamentJPA implements UsuariDepartament {

    @Column(name="usuariid",nullable = false,length = 20)
    java.lang.String usuariID;

    @Column(name="departamentid",nullable = false,length = 19)
    long departamentID;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USUARIDEPARTAMENT_SEQ")
    @Column(name="usuaridepartamentid",nullable = false,length = 19)
    long usuaridepartamentID;



  /** Constructor Buit */
  public UsuariDepartamentJPA() {
  }

  /** Constructor amb tots els camps  */
  public UsuariDepartamentJPA(java.lang.String usuariID , long departamentID , long usuaridepartamentID) {
    this.usuariID=usuariID;
    this.departamentID=departamentID;
    this.usuaridepartamentID=usuaridepartamentID;
}
  /** Constructor sense valors autoincrementals */
  public UsuariDepartamentJPA(java.lang.String usuariID , long departamentID) {
    this.usuariID=usuariID;
    this.departamentID=departamentID;
}
  public UsuariDepartamentJPA(UsuariDepartament __bean) {
    this.setUsuariID(__bean.getUsuariID());
    this.setDepartamentID(__bean.getDepartamentID());
    this.setUsuaridepartamentID(__bean.getUsuaridepartamentID());
	}

	public java.lang.String getUsuariID() {
		return(usuariID);
	};
	public void setUsuariID(java.lang.String _usuariID_) {
		this.usuariID = _usuariID_;
	};

	public long getDepartamentID() {
		return(departamentID);
	};
	public void setDepartamentID(long _departamentID_) {
		this.departamentID = _departamentID_;
	};

	public long getUsuaridepartamentID() {
		return(usuaridepartamentID);
	};
	public void setUsuaridepartamentID(long _usuaridepartamentID_) {
		this.usuaridepartamentID = _usuaridepartamentID_;
	};



    @Override
    public boolean equals(Object __obj) {
        boolean __result;
        if (__obj != null && __obj instanceof UsuariDepartament) {
            UsuariDepartament __instance = (UsuariDepartament)__obj;
            __result = true;
            __result = __result && (this.getUsuaridepartamentID() == __instance.getUsuaridepartamentID()) ;
        } else {
            __result = false;
        }
        return __result;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(this.getUsuaridepartamentID())).hashCode();
    }

// IMP Field:usuariid | Table: qef_usuari | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuariid", referencedColumnName ="usuariID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_usudepart_usuari_usuari_fk"))
    private UsuariJPA usuari;

    public UsuariJPA getUsuari() {
    return this.usuari;
  }

    public  void setUsuari(UsuariJPA usuari) {
    this.usuari = usuari;
  }

// IMP Field:departamentid | Table: qef_departament | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamentid", referencedColumnName ="departamentID", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_usudepart_departamen_d_fk"))
    private DepartamentJPA departament;

    public DepartamentJPA getDepartament() {
    return this.departament;
  }

    public  void setDepartament(DepartamentJPA departament) {
    this.departament = departament;
  }


 // ---------------  STATIC METHODS ------------------
  public static UsuariDepartamentJPA toJPA(UsuariDepartament __bean) {
    if (__bean == null) { return null;}
    UsuariDepartamentJPA __tmp = new UsuariDepartamentJPA();
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setDepartamentID(__bean.getDepartamentID());
    __tmp.setUsuaridepartamentID(__bean.getUsuaridepartamentID());
		return __tmp;
	}


  public static UsuariDepartamentJPA copyJPA(UsuariDepartamentJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<UsuariDepartamentJPA> copyJPA(java.util.Set<UsuariDepartamentJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<UsuariDepartamentJPA> __tmpSet = (java.util.Set<UsuariDepartamentJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<UsuariDepartamentJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (UsuariDepartamentJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static UsuariDepartamentJPA copyJPA(UsuariDepartamentJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    UsuariDepartamentJPA __tmp = (UsuariDepartamentJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"DepartamentJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.departament) || org.hibernate.Hibernate.isInitialized(__jpa.getDepartament()) ) ) {
      __tmp.setDepartament(DepartamentJPA.copyJPA(__jpa.getDepartament(), __alreadyCopied,"UsuariDepartamentJPA"));
    }
    if(!"UsuariJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.usuari) || org.hibernate.Hibernate.isInitialized(__jpa.getUsuari()) ) ) {
      __tmp.setUsuari(UsuariJPA.copyJPA(__jpa.getUsuari(), __alreadyCopied,"UsuariDepartamentJPA"));
    }

    return __tmp;
  }




}
