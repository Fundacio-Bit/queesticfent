
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Departament;


public class DepartamentBean implements Departament {



	long departamentID;// PK
	java.lang.String nom;
	java.lang.String coordinadorid;
	java.lang.String nomldap;
	java.lang.String descripcio;


  /** Constructor Buit */
  public DepartamentBean() {
  }

  /** Constructor amb tots els camps  */
  public DepartamentBean(long departamentID , java.lang.String nom , java.lang.String coordinadorid , java.lang.String nomldap , java.lang.String descripcio) {
    this.departamentID=departamentID;
    this.nom=nom;
    this.coordinadorid=coordinadorid;
    this.nomldap=nomldap;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public DepartamentBean(java.lang.String nom , java.lang.String coordinadorid , java.lang.String nomldap , java.lang.String descripcio) {
    this.nom=nom;
    this.coordinadorid=coordinadorid;
    this.nomldap=nomldap;
    this.descripcio=descripcio;
}
  public DepartamentBean(Departament __bean) {
    this.setDepartamentID(__bean.getDepartamentID());
    this.setNom(__bean.getNom());
    this.setCoordinadorid(__bean.getCoordinadorid());
    this.setNomldap(__bean.getNomldap());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getDepartamentID() {
		return(departamentID);
	};
	public void setDepartamentID(long _departamentID_) {
		this.departamentID = _departamentID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getCoordinadorid() {
		return(coordinadorid);
	};
	public void setCoordinadorid(java.lang.String _coordinadorid_) {
		this.coordinadorid = _coordinadorid_;
	};

	public java.lang.String getNomldap() {
		return(nomldap);
	};
	public void setNomldap(java.lang.String _nomldap_) {
		this.nomldap = _nomldap_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};



  // ======================================

  public static DepartamentBean toBean(Departament __bean) {
    if (__bean == null) { return null;}
    DepartamentBean __tmp = new DepartamentBean();
    __tmp.setDepartamentID(__bean.getDepartamentID());
    __tmp.setNom(__bean.getNom());
    __tmp.setCoordinadorid(__bean.getCoordinadorid());
    __tmp.setNomldap(__bean.getNomldap());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}



}
