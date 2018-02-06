/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.dao;

import ec.edu.espe.distribuidas.agilizate.model.ActividadDia;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class ActividadDiaFacade extends AbstractFacade<ActividadDia>{

    @PersistenceContext(unitName = "punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadDiaFacade() {
        super(ActividadDia.class);
    }
    
    public List <ActividadDia> findByCliPro(Integer codCliente, Integer codPrograma){
        Query qry = this.em.createQuery("SELECT obj FROM ActividadDia obj WHERE obj.actividadDiaPK.codCliente=?1 AND obj.actividadDiaPK.codPrograma=?2");
        qry.setParameter(1, codCliente);
        qry.setParameter(2, codPrograma);
        return qry.getResultList();
    }
    
}
