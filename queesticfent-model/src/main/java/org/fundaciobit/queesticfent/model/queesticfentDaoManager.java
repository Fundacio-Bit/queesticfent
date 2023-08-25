package org.fundaciobit.queesticfent.model;

public class queesticfentDaoManager {
  
  private static IqueesticfentDaoManagers instance = null;
  
  public static void setDaoManagers(IqueesticfentDaoManagers managers) {
    instance = managers;
  }
  
  public static IqueesticfentDaoManagers getDaoManagers() throws Exception {
    if(instance == null) {
      throw new Exception("Ha de inicialitzar el sistema de Managers cridant "
          + " al mètode queesticfentDaoManager.setDaoManagers(...)");
    }
    return instance;
  }
  
}
