
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.PersonalProjecte;


public class PersonalProjecteBean implements PersonalProjecte {



	long personalProjecteID;// PK
	java.lang.String usuariID;
	long projecteID;
	long ordre;
	java.lang.Short percent;


  /** Constructor Buit */
  public PersonalProjecteBean() {
  }

  /** Constructor amb tots els camps  */
  public PersonalProjecteBean(long personalProjecteID , java.lang.String usuariID , long projecteID , long ordre , java.lang.Short percent) {
    this.personalProjecteID=personalProjecteID;
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.ordre=ordre;
    this.percent=percent;
}
  /** Constructor sense valors autoincrementals */
  public PersonalProjecteBean(java.lang.String usuariID , long projecteID , long ordre , java.lang.Short percent) {
    this.usuariID=usuariID;
    this.projecteID=projecteID;
    this.ordre=ordre;
    this.percent=percent;
}
  public PersonalProjecteBean(PersonalProjecte __bean) {
    this.setPersonalProjecteID(__bean.getPersonalProjecteID());
    this.setUsuariID(__bean.getUsuariID());
    this.setProjecteID(__bean.getProjecteID());
    this.setOrdre(__bean.getOrdre());
    this.setPercent(__bean.getPercent());
	}

	public long getPersonalProjecteID() {
		return(personalProjecteID);
	};
	public void setPersonalProjecteID(long _personalProjecteID_) {
		this.personalProjecteID = _personalProjecteID_;
	};

	public java.lang.String getUsuariID() {
		return(usuariID);
	};
	public void setUsuariID(java.lang.String _usuariID_) {
		this.usuariID = _usuariID_;
	};

	public long getProjecteID() {
		return(projecteID);
	};
	public void setProjecteID(long _projecteID_) {
		this.projecteID = _projecteID_;
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



  // ======================================

  public static PersonalProjecteBean toBean(PersonalProjecte __bean) {
    if (__bean == null) { return null;}
    PersonalProjecteBean __tmp = new PersonalProjecteBean();
    __tmp.setPersonalProjecteID(__bean.getPersonalProjecteID());
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setProjecteID(__bean.getProjecteID());
    __tmp.setOrdre(__bean.getOrdre());
    __tmp.setPercent(__bean.getPercent());
		return __tmp;
	}



}
