/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.dao;

import ec.edu.espe.distribuidas.agilizate.model.Cliente;
import ec.edu.espe.distribuidas.agilizate.model.ProgramaCliente;
import ec.edu.espe.distribuidas.agilizate.model.Seguimiento;
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
public class SeguimientoFacade extends AbstractFacade<Seguimiento>{

    @PersistenceContext(unitName = "punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguimientoFacade() {
        super(Seguimiento.class);
    }
     
    public List<Seguimiento> findByCliente(Cliente cliente){
        Query qry=this.em.createQuery("SELECT obj FROM Seguimiento obj WHERE obj.codCliente=?1");
        qry.setParameter(1, cliente.getCodigo());
        return qry.getResultList();  
    } 
}
