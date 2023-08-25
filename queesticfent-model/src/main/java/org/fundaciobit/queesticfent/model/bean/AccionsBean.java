
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Accions;


public class AccionsBean implements Accions {



	long accioid;// PK
	java.lang.String nom;
	java.lang.String nomllegenda;
	java.lang.String color;
	java.lang.String descripcio;


  /** Constructor Buit */
  public AccionsBean() {
  }

  /** Constructor amb tots els camps  */
  public AccionsBean(long accioid , java.lang.String nom , java.lang.String nomllegenda , java.lang.String color , java.lang.String descripcio) {
    this.accioid=accioid;
    this.nom=nom;
    this.nomllegenda=nomllegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor sense valors autoincrementals */
  public AccionsBean(java.lang.String nom , java.lang.String nomllegenda , java.lang.String color , java.lang.String descripcio) {
    this.nom=nom;
    this.nomllegenda=nomllegenda;
    this.color=color;
    this.descripcio=descripcio;
}
  /** Constructor dels valors Not Null */
  public AccionsBean(long accioid , java.lang.String nom , java.lang.String nomllegenda) {
    this.accioid=accioid;
    this.nom=nom;
    this.nomllegenda=nomllegenda;
}
  public AccionsBean(Accions __bean) {
    this.setAccioid(__bean.getAccioid());
    this.setNom(__bean.getNom());
    this.setNomllegenda(__bean.getNomllegenda());
    this.setColor(__bean.getColor());
    this.setDescripcio(__bean.getDescripcio());
	}

	public long getAccioid() {
		return(accioid);
	};
	public void setAccioid(long _accioid_) {
		this.accioid = _accioid_;
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

  public static AccionsBean toBean(Accions __bean) {
    if (__bean == null) { return null;}
    AccionsBean __tmp = new AccionsBean();
    __tmp.setAccioid(__bean.getAccioid());
    __tmp.setNom(__bean.getNom());
    __tmp.setNomllegenda(__bean.getNomllegenda());
    __tmp.setColor(__bean.getColor());
    __tmp.setDescripcio(__bean.getDescripcio());
		return __tmp;
	}



}
