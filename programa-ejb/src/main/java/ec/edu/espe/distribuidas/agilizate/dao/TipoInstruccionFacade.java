/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.dao;

import ec.edu.espe.distribuidas.agilizate.model.TipoInstruccion;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class TipoInstruccionFacade extends AbstractFacade<TipoInstruccion>{

    @PersistenceContext(unitName = "punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoInstruccionFacade() {
        super(TipoInstruccion.class);
    }
    
}
