/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.dao;

import ec.edu.espe.distribuidas.agilizate.model.Ejercicio;
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
public class EjercicioFacade extends AbstractFacade<Ejercicio> {

    @PersistenceContext(unitName = "punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EjercicioFacade() {
        super(Ejercicio.class);
    }

    public List<Ejercicio> findByDificultad(Integer codDificultad) {
        Query qry = this.em.createQuery("SELECT obj FROM Ejercicio obj WHERE obj.codDificultad=?1");
        System.out.println("-------------------------------"+qry);
        qry.setParameter(1, codDificultad);
        return qry.getResultList();
    }

    public List<Ejercicio> findByPasatiempo(Integer codDificultad) {
        Query qry = this.em.createQuery("SELECT obj FROM Ejercicio obj WHERE obj.codPasatiempo?1");
        qry.setParameter(1, codDificultad);
        return qry.getResultList();
    }

}
