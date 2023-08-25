
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Departaments;


public class DepartamentsBean implements Departaments {



	long departamentid;// PK
	java.lang.String nom;
	java.lang.String coordinadorid;
	java.lang.String nomldap;
	java.lang.String descripcio;


  /** Constructor Buit */
  public DepartamentsBean() {
  }

  /** Constructor amb tots els camps  */
  public DepartamentsBean(long departamentid , java.lang.String nom , java.lang.String coordinadorid , java.lang.String nomldap , java.lang.String descripcio) {
    this.departamentid=departamentid;
    this.nom=nom;
    this.coordinadorid=coordinadorid;
    this.nomldap=nomldap;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public DepartamentsBean(java.lang.String nom , java.lang.String coordinadorid , java.lang.String nomldap , java.lang.String descripcio) {
    this.nom=nom;
    this.coordinadorid=coordinadorid;
    this.nomldap=nomldap;
    this.descripcio=descripcio;
}
  public DepartamentsBean(Departaments __bean) {
    this.setDepartamentid(__bean.getDepartamentid());
    this.setNom(__bean.getNom());
    this.setCoordinadorid(__bean.getCoordinadorid());
    this.setNomldap(__bean.getNomldap());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getDepartamentid() {
		return(departamentid);
	};
	public void setDepartamentid(long _departamentid_) {
		this.departamentid = _departamentid_;
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

  public static DepartamentsBean toBean(Departaments __bean) {
    if (__bean == null) { return null;}
    DepartamentsBean __tmp = new DepartamentsBean();
    __tmp.setDepartamentid(__bean.getDepartamentid());
    __tmp.setNom(__bean.getNom());
    __tmp.setCoordinadorid(__bean.getCoordinadorid());
    __tmp.setNomldap(__bean.getNomldap());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}



}
