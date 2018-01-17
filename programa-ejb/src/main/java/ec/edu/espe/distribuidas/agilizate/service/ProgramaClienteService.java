/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.ProgramaClienteFacade;
import ec.edu.espe.distribuidas.agilizate.model.Cliente;
import ec.edu.espe.distribuidas.agilizate.model.ProgramaCliente;
import ec.edu.espe.distribuidas.agilizate.model.ProgramaClientePK;
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
public class ProgramaClienteService{

    @EJB
    private ProgramaClienteFacade programaClienteFacade;
   
    public List<ProgramaCliente> obtenerTodos() {
        return this.programaClienteFacade.findAll();
    }
    
    public ProgramaCliente obtenerPorCodigo(ProgramaClientePK codigo) {
        return this.programaClienteFacade.find(codigo);
    }
    
    public List<ProgramaCliente> obtenerPorCliente(Cliente cliente) {
        return this.programaClienteFacade.findByCliente(cliente);
    }
    
    public void crear(ProgramaCliente programaCliente) {
        this.programaClienteFacade.create(programaCliente);
    }
    
    public void modificar(ProgramaCliente programaCliente) {
        this.programaClienteFacade.edit(programaCliente);
    }
    
    public void eliminar(ProgramaClientePK codigo) {
        ProgramaCliente programaCliente = this.programaClienteFacade.find(codigo);
        this.programaClienteFacade.remove(programaCliente);
    }
    
}
