
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Festiu;


public class FestiuBean implements Festiu {



	long festiuID;// PK
	java.lang.String nom;
	java.sql.Date data;
	java.lang.String descripcio;


  /** Constructor Buit */
  public FestiuBean() {
  }

  /** Constructor amb tots els camps  */
  public FestiuBean(long festiuID , java.lang.String nom , java.sql.Date data , java.lang.String descripcio) {
    this.festiuID=festiuID;
    this.nom=nom;
    this.data=data;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public FestiuBean(java.lang.String nom , java.sql.Date data , java.lang.String descripcio) {
    this.nom=nom;
    this.data=data;
    this.descripcio=descripcio;
}
  public FestiuBean(Festiu __bean) {
    this.setFestiuID(__bean.getFestiuID());
    this.setNom(__bean.getNom());
    this.setData(__bean.getData());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getFestiuID() {
		return(festiuID);
	};
	public void setFestiuID(long _festiuID_) {
		this.festiuID = _festiuID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.sql.Date getData() {
		return(data);
	};
	public void setData(java.sql.Date _data_) {
		this.data = _data_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};



  // ======================================

  public static FestiuBean toBean(Festiu __bean) {
    if (__bean == null) { return null;}
    FestiuBean __tmp = new FestiuBean();
    __tmp.setFestiuID(__bean.getFestiuID());
    __tmp.setNom(__bean.getNom());
    __tmp.setData(__bean.getData());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}



}
