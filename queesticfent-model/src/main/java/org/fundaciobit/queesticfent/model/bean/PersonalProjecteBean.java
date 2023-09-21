
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.PersonalProjecte;


public class PersonalProjecteBean implements PersonalProjecte {



	long personalProjecteId;// PK
	java.lang.String usuariid;
	long projecteid;
	long ordre;
	java.lang.Short percent;


  /** Constructor Buit */
  public PersonalProjecteBean() {
  }

  /** Constructor amb tots els camps  */
  public PersonalProjecteBean(long personalProjecteId , java.lang.String usuariid , long projecteid , long ordre , java.lang.Short percent) {
    this.personalProjecteId=personalProjecteId;
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.ordre=ordre;
    this.percent=percent;
}
  /** Constructor sense valors autoincrementals */
  public PersonalProjecteBean(java.lang.String usuariid , long projecteid , long ordre , java.lang.Short percent) {
    this.usuariid=usuariid;
    this.projecteid=projecteid;
    this.ordre=ordre;
    this.percent=percent;
}
  public PersonalProjecteBean(PersonalProjecte __bean) {
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



  // ======================================

  public static PersonalProjecteBean toBean(PersonalProjecte __bean) {
    if (__bean == null) { return null;}
    PersonalProjecteBean __tmp = new PersonalProjecteBean();
    __tmp.setPersonalProjecteId(__bean.getPersonalProjecteId());
    __tmp.setUsuariid(__bean.getUsuariid());
    __tmp.setProjecteid(__bean.getProjecteid());
    __tmp.setOrdre(__bean.getOrdre());
    __tmp.setPercent(__bean.getPercent());
		return __tmp;
	}



}
