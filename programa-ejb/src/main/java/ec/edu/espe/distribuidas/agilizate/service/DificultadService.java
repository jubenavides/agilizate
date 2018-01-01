/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.DificultadFacade;
import ec.edu.espe.distribuidas.agilizate.model.Dificultad;
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
public class DificultadService{

    @EJB    
    private DificultadFacade dificultadFacade;
   
    public List<Dificultad> obtenerTodos() {
        return this.dificultadFacade.findAll();
    }
    
    public Dificultad obtenerPorCodigo(Integer codigo) {
        return this.dificultadFacade.find(codigo);
    }
    
    public void crear(Dificultad dificultad) {
        this.dificultadFacade.create(dificultad);
    }
    
    public void modificar(Dificultad dificultad) {
        this.dificultadFacade.edit(dificultad);
    }
    
    public void eliminar(Integer codigo) {
        Dificultad dificultad = this.dificultadFacade.find(codigo);
        this.dificultadFacade.remove(dificultad);
    }
    
}
