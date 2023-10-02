
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Accions;


public class AccionsBean implements Accions {



	long accioID;// PK
	java.lang.String nom;
	java.lang.String nomLlegenda;
	java.lang.String color;
	java.lang.String descripcio;


  /** Constructor Buit */
  public AccionsBean() {
  }

  /** Constructor amb tots els camps  */
  public AccionsBean(long accioID , java.lang.String nom , java.lang.String nomLlegenda , java.lang.String color , java.lang.String descripcio) {
    this.accioID=accioID;
    this.nom=nom;
    this.nomLlegenda=nomLlegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public AccionsBean(java.lang.String nom , java.lang.String nomLlegenda , java.lang.String color , java.lang.String descripcio) {
    this.nom=nom;
    this.nomLlegenda=nomLlegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor dels valors Not Null */
  public AccionsBean(long accioID , java.lang.String nom , java.lang.String nomLlegenda) {
    this.accioID=accioID;
    this.nom=nom;
    this.nomLlegenda=nomLlegenda;
}
  public AccionsBean(Accions __bean) {
    this.setAccioID(__bean.getAccioID());
    this.setNom(__bean.getNom());
    this.setNomLlegenda(__bean.getNomLlegenda());
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

	public java.lang.String getNomLlegenda() {
		return(nomLlegenda);
	};
	public void setNomLlegenda(java.lang.String _nomLlegenda_) {
		this.nomLlegenda = _nomLlegenda_;
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

  public static AccionsBean toBean(Accions __bean) {
    if (__bean == null) { return null;}
    AccionsBean __tmp = new AccionsBean();
    __tmp.setAccioID(__bean.getAccioID());
    __tmp.setNom(__bean.getNom());
    __tmp.setNomLlegenda(__bean.getNomLlegenda());
    __tmp.setColor(__bean.getColor());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}



}
