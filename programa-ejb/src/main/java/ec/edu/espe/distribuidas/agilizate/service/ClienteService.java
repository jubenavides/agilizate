/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.ClienteFacade;
import ec.edu.espe.distribuidas.agilizate.model.Cliente;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author DanielCasa
 */
@Stateless
@LocalBean
public class ClienteService{

    @EJB    
    private ClienteFacade clienteFacade;
   
    public List<Cliente> obtenerTodos() {
        return this.clienteFacade.findAll();
    }
    
    public Cliente obtenerPorCodigo(Integer codigo) {
        return this.clienteFacade.find(codigo);
    }
    
    public void crear(Cliente cliente) {
        this.clienteFacade.create(cliente);
    }
    
    public void modificar(Cliente cliente) {
        this.clienteFacade.edit(cliente);
    }
    
    public void eliminar(Integer codigo) {
        Cliente cliente = this.clienteFacade.find(codigo);
        this.clienteFacade.remove(cliente);
    }
    
}
