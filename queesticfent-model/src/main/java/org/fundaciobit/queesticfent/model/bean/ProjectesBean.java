
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Projectes;


public class ProjectesBean implements Projectes {



	long projecteId;// PK
	java.lang.String nom;
	long departamentid;
	java.lang.String descripcio;
	boolean actiu;
	java.sql.Date fromdata;
	java.sql.Date todata;


  /** Constructor Buit */
  public ProjectesBean() {
  }

  /** Constructor amb tots els camps  */
  public ProjectesBean(long projecteId , java.lang.String nom , long departamentid , java.lang.String descripcio , boolean actiu , java.sql.Date fromdata , java.sql.Date todata) {
    this.projecteId=projecteId;
    this.nom=nom;
    this.departamentid=departamentid;
    this.descripcio=descripcio;
    this.actiu=actiu;
    this.fromdata=fromdata;
    this.todata=todata;
}
  /** Constructor sense valors autoincrementals */
  public ProjectesBean(java.lang.String nom , long departamentid , java.lang.String descripcio , boolean actiu , java.sql.Date fromdata , java.sql.Date todata) {
    this.nom=nom;
    this.departamentid=departamentid;
    this.descripcio=descripcio;
    this.actiu=actiu;
    this.fromdata=fromdata;
    this.todata=todata;
}
  /** Constructor dels valors Not Null */
  public ProjectesBean(long projecteId , java.lang.String nom , long departamentid , boolean actiu , java.sql.Date fromdata) {
    this.projecteId=projecteId;
    this.nom=nom;
    this.departamentid=departamentid;
    this.actiu=actiu;
    this.fromdata=fromdata;
}
  public ProjectesBean(Projectes __bean) {
    this.setProjecteId(__bean.getProjecteId());
    this.setNom(__bean.getNom());
    this.setDepartamentid(__bean.getDepartamentid());
    this.setDescripcio(__bean.getDescripcio());
    this.setActiu(__bean.isActiu());
    this.setFromdata(__bean.getFromdata());
    this.setTodata(__bean.getTodata());
	}

	public long getProjecteId() {
		return(projecteId);
	};
	public void setProjecteId(long _projecteId_) {
		this.projecteId = _projecteId_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public long getDepartamentid() {
		return(departamentid);
	};
	public void setDepartamentid(long _departamentid_) {
		this.departamentid = _departamentid_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public boolean isActiu() {
		return(actiu);
	};
	public void setActiu(boolean _actiu_) {
		this.actiu = _actiu_;
	};

	public java.sql.Date getFromdata() {
		return(fromdata);
	};
	public void setFromdata(java.sql.Date _fromdata_) {
		this.fromdata = _fromdata_;
	};

	public java.sql.Date getTodata() {
		return(todata);
	};
	public void setTodata(java.sql.Date _todata_) {
		this.todata = _todata_;
	};



  // ======================================

  public static ProjectesBean toBean(Projectes __bean) {
    if (__bean == null) { return null;}
    ProjectesBean __tmp = new ProjectesBean();
    __tmp.setProjecteId(__bean.getProjecteId());
    __tmp.setNom(__bean.getNom());
    __tmp.setDepartamentid(__bean.getDepartamentid());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setActiu(__bean.isActiu());
    __tmp.setFromdata(__bean.getFromdata());
    __tmp.setTodata(__bean.getTodata());
		return __tmp;
	}



}
