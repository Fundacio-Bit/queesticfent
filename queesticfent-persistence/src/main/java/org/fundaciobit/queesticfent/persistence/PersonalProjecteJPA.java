
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


@Entity(name = "PersonalProjecteJPA")
@Table(name = "qef_personalprojecte" , indexes = { 
        @Index(name="qef_personalprojecte_pk_i", columnList = "personalprojecteid"),
        @Index(name="qef_persproj_projecteid_fk_i", columnList = "projecteid")})
@SequenceGenerator(name="PERSONALPROJECTE_SEQ", sequenceName="qef_personalprojecte_seq", allocationSize=1, initialValue=1000)
@javax.xml.bind.annotation.XmlRootElement
public class PersonalProjecteJPA implements PersonalProjecte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PERSONALPROJECTE_SEQ")
    @Column(name="personalprojecteid",nullable = false,length = 19)
    long personalProjecteId;

    @Column(name="usuariid",nullable = false,length = 50)
    java.lang.String usuariid;

    @Column(name="projecteid",nullable = false,length = 19)
    long projecteid;

    @Column(name="ordre",nullable = false,length = 19)
    long ordre;

    @Column(name="percent",length = 5)
    java.lang.Short percent;



  /** Constructor Buit */
  public PersonalProjecteJPA() {
  }

  /** Constructor amb tots els camps  */
  public PersonalProjecteJPA(long personalProjecteId , java.lang.String usuariid , long projecteid , long ordre , java.lang.Short percent) {
    this.personalProjecteId=personalProjecteId;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.ordre=ordre;
    this.percent=percent;
}
  /** Constructor sense valors autoincrementals */
  public PersonalProjecteJPA(java.lang.String usuariid , long projecteid , long ordre , java.lang.Short percent) {
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.ordre=ordre;
    this.percent=percent;
}
  public PersonalProjecteJPA(PersonalProjecte __bean) {
    this.setPersonalProjecteId(__bean.getPersonalProjecteId());
    this.setUsuariid(__bean.getUsuariid());
    this.setProjecteid(__bean.getProjecteid());
    this.setOrdre(__bean.getOrdre());
    this.setPercent(__bean.getPercent());
	}

	public long getPersonalProjecteId() {
		return(personalProjecteId);
	};
	public void setPersonalProjecteId(long _personalProjecteId_) {
		this.personalProjecteId = _personalProjecteId_;
	};

	public java.lang.String getUsuariid() {
		return(usuariid);
	};
	public void setUsuariid(java.lang.String _usuariid_) {
		this.usuariid = _usuariid_;
	};

	public long getProjecteid() {
		return(projecteid);
	};
	public void setProjecteid(long _projecteid_) {
		this.projecteid = _projecteid_;
	};

	public long getOrdre() {
		return(ordre);
	};
	public void setOrdre(long _ordre_) {
		this.ordre = _ordre_;
	};

	public java.lang.Short getPercent() {
		return(percent);
	};
	public void setPercent(java.lang.Short _percent_) {
		this.percent = _percent_;
	};



  @Override
  public boolean equals(Object __obj) {
  boolean __result;
    if (__obj != null && __obj instanceof PersonalProjecte) {
      PersonalProjecte __instance = (PersonalProjecte)__obj;
      __result = true;
      __result = __result && (this.getPersonalProjecteId() == __instance.getPersonalProjecteId()) ;
    } else {
      __result = false;
    }
    return __result;
  }

// IMP Field:projecteid | Table: qef_projectes | Type: 1  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projecteid", referencedColumnName ="projecteId", nullable = false, insertable=false, updatable=false, foreignKey=@ForeignKey(name="qef_persproj_projectes_pro_fk"))
    private ProjectesJPA projectes;

    public ProjectesJPA getProjectes() {
    return this.projectes;
  }

    public  void setProjectes(ProjectesJPA projectes) {
    this.projectes = projectes;
  }


 // ---------------  STATIC METHODS ------------------
  public static PersonalProjecteJPA toJPA(PersonalProjecte __bean) {
    if (__bean == null) { return null;}
    PersonalProjecteJPA __tmp = new PersonalProjecteJPA();
    __tmp.setPersonalProjecteId(__bean.getPersonalProjecteId());
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setProjecteid(__bean.getProjecteid());
    __tmp.setOrdre(__bean.getOrdre());
    __tmp.setPercent(__bean.getPercent());
		return __tmp;
	}


  public static PersonalProjecteJPA copyJPA(PersonalProjecteJPA __jpa) {
    return copyJPA(__jpa,new java.util.HashMap<Object,Object>(), null);
  }

  static java.util.Set<PersonalProjecteJPA> copyJPA(java.util.Set<PersonalProjecteJPA> __jpaSet,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpaSet == null) { return null; }
    java.util.Set<PersonalProjecteJPA> __tmpSet = (java.util.Set<PersonalProjecteJPA>) __alreadyCopied.get(__jpaSet);
    if (__tmpSet != null) { return __tmpSet; };
    __tmpSet = new java.util.HashSet<PersonalProjecteJPA>(__jpaSet.size());
    __alreadyCopied.put(__jpaSet, __tmpSet);
    for (PersonalProjecteJPA __jpa : __jpaSet) {
      __tmpSet.add(copyJPA(__jpa, __alreadyCopied, origenJPA));
    }
    return __tmpSet;
  }

  static PersonalProjecteJPA copyJPA(PersonalProjecteJPA __jpa,
    java.util.Map<Object,Object> __alreadyCopied, String origenJPA) {
    if (__jpa == null) { return null; }
    PersonalProjecteJPA __tmp = (PersonalProjecteJPA) __alreadyCopied.get(__jpa);
    if (__tmp != null) { return __tmp; };
    __tmp = toJPA(__jpa);
    __alreadyCopied.put(__jpa, __tmp);
    // Copia de beans complexes (EXP)
    // Copia de beans complexes (IMP)
    if(!"ProjectesJPA".equals(origenJPA) && 
       (!org.fundaciobit.genapp.common.utils.Utils.isEmpty(__jpa.projectes) || org.hibernate.Hibernate.isInitialized(__jpa.getProjectes()) ) ) {
      __tmp.setProjectes(ProjectesJPA.copyJPA(__jpa.getProjectes(), __alreadyCopied,"PersonalProjecteJPA"));
    }

    return __tmp;
  }




}
