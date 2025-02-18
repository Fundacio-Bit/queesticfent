
package org.fundaciobit.queesticfent.model.bean;

import org.fundaciobit.queesticfent.model.entity.Usuari;


public class UsuariBean implements Usuari {



	java.lang.String usuariID;// PK
	java.lang.String nom;
	java.lang.String llinatge1;
	java.lang.String llinatge2;
	java.lang.String correu;
	java.lang.String descripcio;
	java.lang.String extensio;
	java.sql.Date naixement;
	java.lang.String telefoncasa;
	java.lang.String telefonmobil;
	java.lang.String contrasenya;


  /** Constructor Buit */
  public UsuariBean() {
  }

  /** Constructor amb tots els camps  */
  public UsuariBean(java.lang.String usuariID , java.lang.String nom , java.lang.String llinatge1 , java.lang.String llinatge2 , java.lang.String correu , java.lang.String descripcio , java.lang.String extensio , java.sql.Date naixement , java.lang.String telefoncasa , java.lang.String telefonmobil , java.lang.String contrasenya) {
    this.usuariID=usuariID;
    this.nom=nom;
    this.llinatge1=llinatge1;
    this.llinatge2=llinatge2;
    this.correu=correu;
    this.descripcio=descripcio;
    this.extensio=extensio;
    this.naixement=naixement;
    this.telefoncasa=telefoncasa;
    this.telefonmobil=telefonmobil;
    this.contrasenya=contrasenya;
}
  /** Constructor dels valors Not Null */
  public UsuariBean(java.lang.String usuariID , java.lang.String nom , java.lang.String correu) {
    this.usuariID=usuariID;
    this.nom=nom;
    this.correu=correu;
}
  public UsuariBean(Usuari __bean) {
    this.setUsuariID(__bean.getUsuariID());
    this.setNom(__bean.getNom());
    this.setLlinatge1(__bean.getLlinatge1());
    this.setLlinatge2(__bean.getLlinatge2());
    this.setCorreu(__bean.getCorreu());
    this.setDescripcio(__bean.getDescripcio());
    this.setExtensio(__bean.getExtensio());
    this.setNaixement(__bean.getNaixement());
    this.setTelefoncasa(__bean.getTelefoncasa());
    this.setTelefonmobil(__bean.getTelefonmobil());
    this.setContrasenya(__bean.getContrasenya());
	}

	public java.lang.String getUsuariID() {
		return(usuariID);
	};
	public void setUsuariID(java.lang.String _usuariID_) {
		this.usuariID = _usuariID_;
	};

	public java.lang.String getNom() {
		return(nom);
	};
	public void setNom(java.lang.String _nom_) {
		this.nom = _nom_;
	};

	public java.lang.String getLlinatge1() {
		return(llinatge1);
	};
	public void setLlinatge1(java.lang.String _llinatge1_) {
		this.llinatge1 = _llinatge1_;
	};

	public java.lang.String getLlinatge2() {
		return(llinatge2);
	};
	public void setLlinatge2(java.lang.String _llinatge2_) {
		this.llinatge2 = _llinatge2_;
	};

	public java.lang.String getCorreu() {
		return(correu);
	};
	public void setCorreu(java.lang.String _correu_) {
		this.correu = _correu_;
	};

	public java.lang.String getDescripcio() {
		return(descripcio);
	};
	public void setDescripcio(java.lang.String _descripcio_) {
		this.descripcio = _descripcio_;
	};

	public java.lang.String getExtensio() {
		return(extensio);
	};
	public void setExtensio(java.lang.String _extensio_) {
		this.extensio = _extensio_;
	};

	public java.sql.Date getNaixement() {
		return(naixement);
	};
	public void setNaixement(java.sql.Date _naixement_) {
		this.naixement = _naixement_;
	};

	public java.lang.String getTelefoncasa() {
		return(telefoncasa);
	};
	public void setTelefoncasa(java.lang.String _telefoncasa_) {
		this.telefoncasa = _telefoncasa_;
	};

	public java.lang.String getTelefonmobil() {
		return(telefonmobil);
	};
	public void setTelefonmobil(java.lang.String _telefonmobil_) {
		this.telefonmobil = _telefonmobil_;
	};

	public java.lang.String getContrasenya() {
		return(contrasenya);
	};
	public void setContrasenya(java.lang.String _contrasenya_) {
		this.contrasenya = _contrasenya_;
	};



  // ======================================

  public static UsuariBean toBean(Usuari __bean) {
    if (__bean == null) { return null;}
    UsuariBean __tmp = new UsuariBean();
    __tmp.setUsuariID(__bean.getUsuariID());
    __tmp.setNom(__bean.getNom());
    __tmp.setLlinatge1(__bean.getLlinatge1());
    __tmp.setLlinatge2(__bean.getLlinatge2());
    __tmp.setCorreu(__bean.getCorreu());
    __tmp.setDescripcio(__bean.getDescripcio());
    __tmp.setExtensio(__bean.getExtensio());
    __tmp.setNaixement(__bean.getNaixement());
    __tmp.setTelefoncasa(__bean.getTelefoncasa());
    __tmp.setTelefonmobil(__bean.getTelefonmobil());
    __tmp.setContrasenya(__bean.getContrasenya());
		return __tmp;
	}



}
