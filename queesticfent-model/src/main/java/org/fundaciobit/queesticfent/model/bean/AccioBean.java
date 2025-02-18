
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Accio;


public class AccioBean implements Accio {



	long accioID;// PK
	java.lang.String nom;
	java.lang.String nomllegenda;
	java.lang.String color;
	java.lang.String descripcio;


  /** Constructor Buit */
  public AccioBean() {
  }

  /** Constructor amb tots els camps  */
  public AccioBean(long accioID , java.lang.String nom , java.lang.String nomllegenda , java.lang.String color , java.lang.String descripcio) {
    this.accioID=accioID;
    this.nom=nom;
    this.nomllegenda=nomllegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public AccioBean(java.lang.String nom , java.lang.String nomllegenda , java.lang.String color , java.lang.String descripcio) {
    this.nom=nom;
    this.nomllegenda=nomllegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor dels valors Not Null */
  public AccioBean(long accioID , java.lang.String nom , java.lang.String nomllegenda) {
    this.accioID=accioID;
    this.nom=nom;
    this.nomllegenda=nomllegenda;
}
  public AccioBean(Accio __bean) {
    this.setAccioID(__bean.getAccioID());
    this.setNom(__bean.getNom());
    this.setNomllegenda(__bean.getNomllegenda());
    this.setColor(__bean.getColor());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getAccioID() {
		return(accioID);
	};
	public void setAccioID(long _accioID_) {
		this.accioID = _accioID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getNomllegenda() {
		return(nomllegenda);
	};
	public void setNomllegenda(java.lang.String _nomllegenda_) {
		this.nomllegenda = _nomllegenda_;
	};

	public java.lang.String getColor() {
		return(color);
	};
	public void setColor(java.lang.String _color_) {
		this.color = _color_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};



  // ======================================

  public static AccioBean toBean(Accio __bean) {
    if (__bean == null) { return null;}
    AccioBean __tmp = new AccioBean();
    __tmp.setAccioID(__bean.getAccioID());
    __tmp.setNom(__bean.getNom());
    __tmp.setNomllegenda(__bean.getNomllegenda());
    __tmp.setColor(__bean.getColor());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}



}
