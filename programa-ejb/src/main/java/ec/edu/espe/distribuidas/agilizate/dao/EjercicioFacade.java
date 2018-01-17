/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.dao;

import ec.edu.espe.distribuidas.agilizate.enums.CodCategoriaEnum;
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
        qry.setParameter(1, codDificultad);
        return qry.getResultList();
    }

    public List<Ejercicio> findByPasatiempo(Integer codPasatiempo) {
        Query qry = this.em.createQuery("SELECT obj FROM Ejercicio obj WHERE obj.codPasatiempo=?1");
        qry.setParameter(1, codPasatiempo);
        return qry.getResultList();
    }

    public List<Ejercicio> findByTipCliente(Integer codTipoCliente) {
        Query qry = this.em.createQuery("SELECT obj FROM Ejercicio obj WHERE obj.codTipoCliente=?1");
        qry.setParameter(1, codTipoCliente);
        return qry.getResultList();
    }

    public List<Ejercicio> findByCategoria(CodCategoriaEnum codCategoria) {
        Query qry = this.em.createQuery("SELECT obj FROM Ejercicio obj WHERE obj.codCategoria=?1");
        qry.setParameter(1, codCategoria);
        return qry.getResultList();
    }

    public List<Ejercicio> findByMaterial(Integer codMaterial) {
        Query qry = this.em.createQuery("SELECT obj FROM Ejercicio obj WHERE obj.codMaterial=?1");
        qry.setParameter(1, codMaterial);
        return qry.getResultList();
    }

}
