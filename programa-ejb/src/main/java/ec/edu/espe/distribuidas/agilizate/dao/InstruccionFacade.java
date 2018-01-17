/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.dao;

import ec.edu.espe.distribuidas.agilizate.model.Instruccion;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class InstruccionFacade extends AbstractFacade<Instruccion>{

    @PersistenceContext(unitName = "punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InstruccionFacade() {
        super(Instruccion.class);
    }
    
    public List<Instruccion> findByExercise(Integer codEjercicio) {
        Query qry = this.em.createQuery("SELECT obj FROM Instruccion obj WHERE obj.codEjercicio=?1");
        qry.setParameter(1, codEjercicio);
        return qry.getResultList();
    }
    
}
