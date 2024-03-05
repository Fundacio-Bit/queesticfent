package org.fundaciobit.queesticfent.api.externa.secure.modificacions;

import java.util.List;


/**
 * 
 * @author anadal
 *
 */
public class GetModificacionsResponse {
    
    
    private List<ModificacioRest> modificacions;

    public List<ModificacioRest> getModificacions() {
        return modificacions;
    }

    public void setModificacions(List<ModificacioRest> modificacions) {
        this.modificacions = modificacions;
    }

    
    
}
