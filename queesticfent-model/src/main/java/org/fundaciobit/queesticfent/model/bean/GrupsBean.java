
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Grups;


public class GrupsBean implements Grups {



	long grupid;// PK
	java.lang.String nom;
	java.lang.String descripcio;
	java.lang.Long nivellseguretat;


  /** Constructor Buit */
  public GrupsBean() {
  }

  /** Constructor amb tots els camps  */
  public GrupsBean(long grupid , java.lang.String nom , java.lang.String descripcio , java.lang.Long nivellseguretat) {
    this.grupid=grupid;
    this.nom=nom;
    this.descripcio=descripcio;
    this.nivellseguretat=nivellseguretat;
}
  /** Constructor sense valors autoincrementals */
  public GrupsBean(java.lang.String nom , java.lang.String descripcio , java.lang.Long nivellseguretat) {
    this.nom=nom;
    this.descripcio=descripcio;
    this.nivellseguretat=nivellseguretat;
}
  /** Constructor dels valors Not Null */
  public GrupsBean(long grupid , java.lang.String nom) {
    this.grupid=grupid;
    this.nom=nom;
}
  public GrupsBean(Grups __bean) {
    this.setGrupid(__bean.getGrupid());
    this.setNom(__bean.getNom());
    this.setDescripcio(__bean.getDescripcio());
    this.setNivellseguretat(__bean.getNivellseguretat());
	}

	public long getGrupid() {
		return(grupid);
	};
	public void setGrupid(long _grupid_) {
		this.grupid = _grupid_;
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

	public java.lang.Long getNivellseguretat() {
		return(nivellseguretat);
	};
	public void setNivellseguretat(java.lang.Long _nivellseguretat_) {
		this.nivellseguretat = _nivellseguretat_;
	};



  // ======================================

  public static GrupsBean toBean(Grups __bean) {
    if (__bean == null) { return null;}
    GrupsBean __tmp = new GrupsBean();
    __tmp.setGrupid(__bean.getGrupid());
    __tmp.setNom(__bean.getNom());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setNivellseguretat(__bean.getNivellseguretat());
		return __tmp;
	}



}
