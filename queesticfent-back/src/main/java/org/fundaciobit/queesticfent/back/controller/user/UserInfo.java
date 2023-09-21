package org.fundaciobit.queesticfent.back.controller.user;

import java.util.List;

public class UserInfo {
    
    
    String nom;
    
    List<Item> items;

    
    public UserInfo() {
      
    }
    /**
     * @param nom
     * @param items
     */
    public UserInfo(String nom, List<Item> items) {
      super();
      this.nom = nom;
      this.items = items;
    }

    public String getNom() {
      return nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public List<Item> getItems() {
      return items;
    }

    public void setItems(List<Item> items) {
      this.items = items;
    }

  }

