/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.TipoInstruccionFacade;
import ec.edu.espe.distribuidas.agilizate.model.TipoInstruccion;
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
public class TipoInstruccionService{

    @EJB
    private TipoInstruccionFacade tipoInstruccionFacade;
   
    public List<TipoInstruccion> obtenerTodos() {
        return this.tipoInstruccionFacade.findAll();
    }
    
    public TipoInstruccion obtenerPorCodigo(Integer codigo) {
        return this.tipoInstruccionFacade.find(codigo);
    }
    
    public void crear(TipoInstruccion tipoInstruccion) {
        this.tipoInstruccionFacade.create(tipoInstruccion);
    }
    
    public void modificar(TipoInstruccion tipoInstruccion) {
        this.tipoInstruccionFacade.edit(tipoInstruccion);
    }
    
    public void eliminar(Integer codigo) {
        TipoInstruccion tipoInstruccion = this.tipoInstruccionFacade.find(codigo);
        this.tipoInstruccionFacade.remove(tipoInstruccion);
    }
    
}
