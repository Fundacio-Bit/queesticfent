
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Grups;


public class GrupsBean implements Grups {



	long grupID;// PK
	java.lang.String nom;
	java.lang.String descripcio;
	java.lang.Long nivellSeguretat;


  /** Constructor Buit */
  public GrupsBean() {
  }

  /** Constructor amb tots els camps  */
  public GrupsBean(long grupID , java.lang.String nom , java.lang.String descripcio , java.lang.Long nivellSeguretat) {
    this.grupID=grupID;
    this.nom=nom;
    this.descripcio=descripcio;
    this.nivellSeguretat=nivellSeguretat;
}
  /** Constructor sense valors autoincrementals */
  public GrupsBean(java.lang.String nom , java.lang.String descripcio , java.lang.Long nivellSeguretat) {
    this.nom=nom;
    this.descripcio=descripcio;
    this.nivellSeguretat=nivellSeguretat;
}
  /** Constructor dels valors Not Null */
  public GrupsBean(long grupID , java.lang.String nom) {
    this.grupID=grupID;
    this.nom=nom;
}
  public GrupsBean(Grups __bean) {
    this.setGrupID(__bean.getGrupID());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setNivellSeguretat(__bean.getNivellSeguretat());
	}

	public long getGrupID() {
		return(grupID);
	};
	public void setGrupID(long _grupID_) {
		this.grupID = _grupID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.Long getNivellSeguretat() {
		return(nivellSeguretat);
	};
	public void setNivellSeguretat(java.lang.Long _nivellSeguretat_) {
		this.nivellSeguretat = _nivellSeguretat_;
	};



  // ======================================

  public static GrupsBean toBean(Grups __bean) {
    if (__bean == null) { return null;}
    GrupsBean __tmp = new GrupsBean();
    __tmp.setGrupID(__bean.getGrupID());
    __tmp.setNom(__bean.getNom());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setNivellSeguretat(__bean.getNivellSeguretat());
		return __tmp;
	}



}
