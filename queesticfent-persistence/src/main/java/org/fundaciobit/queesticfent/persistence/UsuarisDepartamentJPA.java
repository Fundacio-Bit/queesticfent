
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


@Entity(name = "UsuarisDepartamentJPA")
@Table(name = "qef_usuarisdepartament" , indexes = { 
        @Index(name="qef_usudep_departamentid_fk_i", columnList = "departamentid"),
        @Index(name="qef_usuarisdepartament_pk_i", columnList = "usuaridepartamentid")})
@SequenceGenerator(name="USUARISDEPARTAMENT_SEQ", sequenceName="qef_usuarisdepartament_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class UsuarisDepartamentJPA implements UsuarisDepartament {

    @Column(name="usuariid",nullable = false,length = 20)
    java.lang.String usuariid;

    @Column(name="departamentid",nullable = false,length = 19)
    long departamentid;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USUARISDEPARTAMENT_SEQ")
    @Column(name="usuaridepartamentid",nullable = false,length = 19)
    long usuaridepartamentid;



  /** Constructor Buit */
  public UsuarisDepartamentJPA() {
  }

  /** Constructor amb tots els camps  */
  public UsuarisDepartamentJPA(java.lang.String usuariid , long departamentid , long usuaridepartamentid) {
    this.usuariid=usuariid;
    this.departamentid=departamentid;
    this.usuaridepartamentid=usuaridepartamentid;
}
  /** Constructor sense valors autoincrementals */
  public UsuarisDepartamentJPA(java.lang.String usuariid , long departamentid) {
    this.usuariid=usuariid;
    this.departamentid=departamentid;
}
  public UsuarisDepartamentJPA(UsuarisDepartament __bean) {
    this.setUsuariid(__bean.getUsuariid());
    this.setDepartamentid(__bean.getDepartamentid());
    this.setUsuaridepartamentid(__bean.getUsuaridepartamentid());
	}

	public java.lang.String getUsuariid() {
		return(usuariid);
	};
	public void setUsuariid(java.lang.String _usuariid_) {
		this.usuariid = _usuariid_;
	};

	public long getDepartamentid() {
		return(departamentid);
	};
	public void setDepartamentid(long _departamentid_) {
		this.departamentid = _departamentid_;
	};

	public long getUsuaridepartamentid() {
		return(usuaridepartamentid);
	};
	public void setUsuaridepartamentid(long _usuaridepartamentid_) {
		this.usuaridepartamentid = _usuaridepartamentid_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof UsuarisDepartament) {
      UsuarisDepartament __instance = (UsuarisDepartament)__obj;
      __result = true;
      __result = __result && (this.getUsuaridepartamentid() == __instance.getUsuaridepartamentid()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:departamentid | Table: qef_departaments | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamentid", referencedColumnName ="departamentid", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_usudep_departamen_depar_fk"))
    private DepartamentsJPA departaments;

    public DepartamentsJPA getDepartaments() {
    return this.departaments;
  }

    public  void setDepartaments(DepartamentsJPA departaments) {
    this.departaments = departaments;
  }


 // ---------------  STATIC METHODS ------------------
  public static UsuarisDepartamentJPA toJPA(UsuarisDepartament __bean) {
    if (__bean == null) { return null;}
    UsuarisDepartamentJPA __tmp = new UsuarisDepartamentJPA();
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setDepartamentid(__bean.getDepartamentid());
    __tmp.setUsuaridepartamentid(__bean.getUsuaridepartamentid());
		return __tmp;
	}


  public static UsuarisDepartamentJPA copyJPA(UsuarisDepartamentJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<UsuarisDepartamentJPA> copyJPA(java.util.Set<UsuarisDepartamentJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<UsuarisDepartamentJPA> __tmpSet = (java.util.Set<UsuarisDepartamentJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<UsuarisDepartamentJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (UsuarisDepartamentJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static UsuarisDepartamentJPA copyJPA(UsuarisDepartamentJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    UsuarisDepartamentJPA __tmp = (UsuarisDepartamentJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"DepartamentsJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.departaments) || org.hibernate.Hibernate.isInitialized(__jpa.getDepartaments()) ) ) {
      __tmp.setDepartaments(DepartamentsJPA.copyJPA(__jpa.getDepartaments(), __alreadyCopied,"UsuarisDepartamentJPA"));
    }

    return __tmp;
  }




}
