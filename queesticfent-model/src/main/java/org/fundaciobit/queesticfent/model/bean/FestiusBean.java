
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Festius;


public class FestiusBean implements Festius {



	long festiuid;// PK
	java.lang.String nom;
	java.sql.Date data;
	java.lang.String descripcio;


  /** Constructor Buit */
  public FestiusBean() {
  }

  /** Constructor amb tots els camps  */
  public FestiusBean(long festiuid , java.lang.String nom , java.sql.Date data , java.lang.String descripcio) {
    this.festiuid=festiuid;
    this.nom=nom;
    this.data=data;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public FestiusBean(java.lang.String nom , java.sql.Date data , java.lang.String descripcio) {
    this.nom=nom;
    this.data=data;
    this.descripcio=descripcio;
}
  public FestiusBean(Festius __bean) {
    this.setFestiuid(__bean.getFestiuid());
    this.setNom(__bean.getNom());
    this.setData(__bean.getData());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getFestiuid() {
		return(festiuid);
	};
	public void setFestiuid(long _festiuid_) {
		this.festiuid = _festiuid_;
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

  public static FestiusBean toBean(Festius __bean) {
    if (__bean == null) { return null;}
    FestiusBean __tmp = new FestiusBean();
    __tmp.setFestiuid(__bean.getFestiuid());
    __tmp.setNom(__bean.getNom());
    __tmp.setData(__bean.getData());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}



}
