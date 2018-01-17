/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.SeguimientoFacade;
import ec.edu.espe.distribuidas.agilizate.model.Cliente;
import ec.edu.espe.distribuidas.agilizate.model.Seguimiento;
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
public class SeguimientoService{

    @EJB
    private SeguimientoFacade seguimientoFacade;
   
    public List<Seguimiento> obtenerTodos() {
        return this.seguimientoFacade.findAll();
    }
    
    public Seguimiento obtenerPorCodigo(Integer codigo) {
        return this.seguimientoFacade.find(codigo);
    }
    
    public List<Seguimiento> obtenerPorCliente(Cliente cliente) {
        return this.seguimientoFacade.findByCliente(cliente);
    }
    
    public void crear(Seguimiento seguimiento) {
        this.seguimientoFacade.create(seguimiento);
    }
    
    public void modificar(Seguimiento seguimiento) {
        this.seguimientoFacade.edit(seguimiento);
    }
    
    public void eliminar(Integer codigo) {
        Seguimiento seguimiento = this.seguimientoFacade.find(codigo);
        this.seguimientoFacade.remove(seguimiento);
    }
    
}
