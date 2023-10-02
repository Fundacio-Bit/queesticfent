
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Departaments;


public class DepartamentsBean implements Departaments {



	long departamentID;// PK
	java.lang.String nom;
	java.lang.String coordinadorId;
	java.lang.String nomLDAP;
	java.lang.String descripcio;


  /** Constructor Buit */
  public DepartamentsBean() {
  }

  /** Constructor amb tots els camps  */
  public DepartamentsBean(long departamentID , java.lang.String nom , java.lang.String coordinadorId , java.lang.String nomLDAP , java.lang.String descripcio) {
    this.departamentID=departamentID;
    this.nom=nom;
    this.coordinadorId=coordinadorId;
    this.nomLDAP=nomLDAP;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public DepartamentsBean(java.lang.String nom , java.lang.String coordinadorId , java.lang.String nomLDAP , java.lang.String descripcio) {
    this.nom=nom;
    this.coordinadorId=coordinadorId;
    this.nomLDAP=nomLDAP;
    this.descripcio=descripcio;
}
  public DepartamentsBean(Departaments __bean) {
    this.setDepartamentID(__bean.getDepartamentID());
    this.setNom(__bean.getNom());
    this.setCoordinadorId(__bean.getCoordinadorId());
    this.setNomLDAP(__bean.getNomLDAP());
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

	public java.lang.String getCoordinadorId() {
		return(coordinadorId);
	};
	public void setCoordinadorId(java.lang.String _coordinadorId_) {
		this.coordinadorId = _coordinadorId_;
	};

	public java.lang.String getNomLDAP() {
		return(nomLDAP);
	};
	public void setNomLDAP(java.lang.String _nomLDAP_) {
		this.nomLDAP = _nomLDAP_;
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
    __tmp.setDepartamentID(__bean.getDepartamentID());
    __tmp.setNom(__bean.getNom());
    __tmp.setCoordinadorId(__bean.getCoordinadorId());
    __tmp.setNomLDAP(__bean.getNomLDAP());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}



}
