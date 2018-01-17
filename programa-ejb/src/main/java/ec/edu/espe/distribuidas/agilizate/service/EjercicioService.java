/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.EjercicioFacade;
import ec.edu.espe.distribuidas.agilizate.enums.CodCategoriaEnum;
import ec.edu.espe.distribuidas.agilizate.model.Ejercicio;
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
public class EjercicioService{

    @EJB    
    private EjercicioFacade ejercicioFacade;
   
    public List<Ejercicio> obtenerTodos() {
        return this.ejercicioFacade.findAll();
    }
    
    public Ejercicio obtenerPorCodigo(Integer codigo) {
        return this.ejercicioFacade.find(codigo);
    }
    
    public void crear(Ejercicio ejercicio) {
        this.ejercicioFacade.create(ejercicio);
    }
    
    public void modificar(Ejercicio ejercicio) {
        this.ejercicioFacade.edit(ejercicio);
    }
    
    public void eliminar(Integer codigo) {
        Ejercicio ejercicio = this.ejercicioFacade.find(codigo);
        this.ejercicioFacade.remove(ejercicio);
    }
    
    public List<Ejercicio> obtenerPorDificultad(Integer codDificultad) {
        return this.ejercicioFacade.findByDificultad(codDificultad);
    }
    
    public List<Ejercicio> obtenerPorPasatiempo(Integer codPasatiempo) {
        return this.ejercicioFacade.findByPasatiempo(codPasatiempo);
    }
    
    public List<Ejercicio> obtenerTipoCliente(Integer codTipoCliente) {
        return this.ejercicioFacade.findByTipCliente(codTipoCliente);
    }
    
    public List<Ejercicio> obtenerPorCategoria(CodCategoriaEnum codCategoria) {
        return this.ejercicioFacade.findByCategoria(codCategoria);
    }
    
    public List<Ejercicio> obtenerPorMaterial(Integer codMaterial) {
        return this.ejercicioFacade.findByMaterial(codMaterial);
    }
    
}
