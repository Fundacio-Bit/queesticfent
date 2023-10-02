
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Projectes;


public class ProjectesBean implements Projectes {



	long projecteID;// PK
	java.lang.String nom;
	long departamentID;
	java.lang.String descripcio;
	boolean actiu;
	java.sql.Date fromdata;
	java.sql.Date todata;


  /** Constructor Buit */
  public ProjectesBean() {
  }

  /** Constructor amb tots els camps  */
  public ProjectesBean(long projecteID , java.lang.String nom , long departamentID , java.lang.String descripcio , boolean actiu , java.sql.Date fromdata , java.sql.Date todata) {
    this.projecteID=projecteID;
    this.nom=nom;
    this.departamentID=departamentID;
    this.descripcio=descripcio;
    this.actiu=actiu;
    this.fromdata=fromdata;
    this.todata=todata;
}
  /** Constructor sense valors autoincrementals */
  public ProjectesBean(java.lang.String nom , long departamentID , java.lang.String descripcio , boolean actiu , java.sql.Date fromdata , java.sql.Date todata) {
    this.nom=nom;
    this.departamentID=departamentID;
    this.descripcio=descripcio;
    this.actiu=actiu;
    this.fromdata=fromdata;
    this.todata=todata;
}
  /** Constructor dels valors Not Null */
  public ProjectesBean(long projecteID , java.lang.String nom , long departamentID , boolean actiu , java.sql.Date fromdata) {
    this.projecteID=projecteID;
    this.nom=nom;
    this.departamentID=departamentID;
    this.actiu=actiu;
    this.fromdata=fromdata;
}
  public ProjectesBean(Projectes __bean) {
    this.setProjecteID(__bean.getProjecteID());
    this.setNom(__bean.getNom());
    this.setDepartamentID(__bean.getDepartamentID());
    this.setDescripcio(__bean.getDescripcio());
    this.setActiu(__bean.isActiu());
    this.setFromdata(__bean.getFromdata());
    this.setTodata(__bean.getTodata());
	}

	public long getProjecteID() {
		return(projecteID);
	};
	public void setProjecteID(long _projecteID_) {
		this.projecteID = _projecteID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public long getDepartamentID() {
		return(departamentID);
	};
	public void setDepartamentID(long _departamentID_) {
		this.departamentID = _departamentID_;
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
    __tmp.setProjecteID(__bean.getProjecteID());
    __tmp.setNom(__bean.getNom());
    __tmp.setDepartamentID(__bean.getDepartamentID());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setActiu(__bean.isActiu());
    __tmp.setFromdata(__bean.getFromdata());
    __tmp.setTodata(__bean.getTodata());
		return __tmp;
	}



}
