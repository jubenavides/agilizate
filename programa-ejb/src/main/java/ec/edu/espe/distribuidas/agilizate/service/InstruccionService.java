/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.InstruccionFacade;
import ec.edu.espe.distribuidas.agilizate.dao.TipoInstruccionFacade;
import ec.edu.espe.distribuidas.agilizate.model.Instruccion;
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
public class InstruccionService{

    @EJB
    private InstruccionFacade instruccionFacade;
   
    public List<Instruccion> obtenerTodos() {
        return this.instruccionFacade.findAll();
    }
    
    public Instruccion obtenerPorCodigo(Integer codigo) {
        return this.instruccionFacade.find(codigo);
    }
    
    public void crear(Instruccion instruccion) {
        this.instruccionFacade.create(instruccion);
    }
    
    public void modificar(Instruccion instruccion) {
        this.instruccionFacade.edit(instruccion);
    }
    
    public void eliminar(Integer codigo) {
        Instruccion instruccion = this.instruccionFacade.find(codigo);
        this.instruccionFacade.remove(instruccion);
    }
    
    public List<Instruccion> buscarPorEjercicio(Integer codEjercicio) {
        return this.instruccionFacade.findByExercise(codEjercicio);
    }
    
}
