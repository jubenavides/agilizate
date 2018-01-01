/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.TipoClienteFacade;
import ec.edu.espe.distribuidas.agilizate.model.TipoCliente;
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
public class TipoClienteService{

    @EJB
    private TipoClienteFacade tipoClienteFacade;
   
    public List<TipoCliente> obtenerTodos() {
        return this.tipoClienteFacade.findAll();
    }
    
    public TipoCliente obtenerPorCodigo(Integer codigo) {
        return this.tipoClienteFacade.find(codigo);
    }
    
    public void crear(TipoCliente tipoCliente) {
        this.tipoClienteFacade.create(tipoCliente);
    }
    
    public void modificar(TipoCliente tipoCliente) {
        this.tipoClienteFacade.edit(tipoCliente);
    }
    
    public void eliminar(Integer codigo) {
        TipoCliente tipoCliente = this.tipoClienteFacade.find(codigo);
        this.tipoClienteFacade.remove(tipoCliente);
    }
    
}
