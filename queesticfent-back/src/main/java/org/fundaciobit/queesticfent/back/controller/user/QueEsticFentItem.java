package org.fundaciobit.queesticfent.back.controller.user;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueEsticFentItem {
  

  
  private String usuariID;
  
  private Date data;
  
  private String descripcio;
  
  //private IQueEsticFent queesticfentOriginal;
 
  private List<ModificacioItem> modificacions = new ArrayList<ModificacioItem>();

  private Map<Long, ModificacioItem> modificacionsByType = new HashMap<Long, ModificacioItem>();

  public List<ModificacioItem> getModificacions() {
    return modificacions;
  }

  public void addModificacioItem(ModificacioItem mi) {
    this.modificacions.add(mi);    
    modificacionsByType.put(mi.getAccio().getAccioID(), mi);
  }
  
  
  public ModificacioItem getModificacioItemByAccioType(long type) {
    return modificacionsByType.get(type);
  }
  

  /**
   * @param usuariID
   * @param data
   * @param descripcio
   */
  public QueEsticFentItem(String usuariID, Date data, String descripcio) {
    super();
    this.usuariID = usuariID;
    this.data = data;
    this.descripcio = descripcio;
  }

  public String getUsuariID() {
    return usuariID;
  }

  public void setUsuariID(String usuariID) {
    this.usuariID = usuariID;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getDescripcio() {
    return descripcio;
  }

  public void setDescripcio(String descripcio) {
    this.descripcio = descripcio;
  }
 
}
