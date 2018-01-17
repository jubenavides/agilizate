/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.dao;

import ec.edu.espe.distribuidas.agilizate.model.Cliente;
import ec.edu.espe.distribuidas.agilizate.model.ProgramaCliente;
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
public class ProgramaClienteFacade extends AbstractFacade<ProgramaCliente>{

    @PersistenceContext(unitName = "punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramaClienteFacade() {
        super(ProgramaCliente.class);
    }
    
    public List<ProgramaCliente> findByCliente(Cliente cliente){
        Query qry=this.em.createQuery("SELECT obj FROM ProgramaCliente obj WHERE obj.programaClientePK.codCliente=?1");
        qry.setParameter(1, cliente.getCodigo());
        return qry.getResultList();  
    } 
    
}
