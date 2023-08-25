package org.fundaciobit.queesticfent.logic;

//import java.util.Set;

import javax.ejb.Local;

/*
import org.fundaciobit.queesticfent.ejb.AnnexService;
import org.fundaciobit.queesticfent.persistence.AnnexJPA;

import org.fundaciobit.genapp.common.i18n.I18NException;
*/
/**
 * 
 * @author anadal
 *
 */
@Local
public interface SampleLogicaService /* extends AnnexService */ {

    public static final String JNDI_NAME = "java:app/queesticfent-ejb/SampleLogicaEJB!org.fundaciobit.queesticfent.logic.SampleLogicaService";
/*
    public void deleteFull(AnnexJPA annex) throws I18NException;

    
     * public AnnexJPA createFull(AnnexJPA annex) throws I18NException;
     */
}
