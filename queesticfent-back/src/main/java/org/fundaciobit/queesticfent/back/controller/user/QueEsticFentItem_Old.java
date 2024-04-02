package org.fundaciobit.queesticfent.back.controller.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueEsticFentItem_Old {
  

  
  private String usuariID;
  
  private Timestamp data;
  
  private String descripcio;
  
  //private IQueEsticFent queesticfentOriginal;
 
  private List<ModificacioItem_Old> modificacions = new ArrayList<ModificacioItem_Old>();

  private Map<Long, ModificacioItem_Old> modificacionsByType = new HashMap<Long, ModificacioItem_Old>();

  public List<ModificacioItem_Old> getModificacions() {
    return modificacions;
  }

  public void addModificacioItem(ModificacioItem_Old mi) {
    this.modificacions.add(mi);    
    modificacionsByType.put(mi.getAccio().getAccioID(), mi);
  }
  
  
  public ModificacioItem_Old getModificacioItemByAccioType(long type) {
    return modificacionsByType.get(type);
  }
  

  /**
   * @param usuariID
   * @param data
   * @param descripcio
   */
  public QueEsticFentItem_Old(String usuariID, Timestamp data, String descripcio) {
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

  public Timestamp getData() {
    return data;
  }

  public void setData(Timestamp data) {
    this.data = data;
  }

  public String getDescripcio() {
    return descripcio;
  }

  public void setDescripcio(String descripcio) {
    this.descripcio = descripcio;
  }
 
}
