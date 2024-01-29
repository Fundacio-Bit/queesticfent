package org.fundaciobit.queesticfent.api.externa.secure.modificacions;

import java.util.Date;

/**
 * 
 * @author anadal
 *
 */
public class Modificacio {
    
    protected String language;
    
    protected java.lang.String usuariID;

    protected java.lang.Long projecteID;

    protected Date data;

    protected java.lang.String dada1;

    public java.lang.String getUsuariID() {
        return usuariID;
    }

    public void setUsuariID(java.lang.String usuariID) {
        this.usuariID = usuariID;
    }

    public java.lang.Long getProjecteID() {
        return projecteID;
    }

    public void setProjecteID(java.lang.Long projecteID) {
        this.projecteID = projecteID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public java.lang.String getDada1() {
        return dada1;
    }

    public void setDada1(java.lang.String dada1) {
        this.dada1 = dada1;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    
    
}
