/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.GeneroFacade;
import ec.edu.espe.distribuidas.agilizate.enums.CodGeneroEnum;
import ec.edu.espe.distribuidas.agilizate.model.Genero;
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
public class GeneroService{

    @EJB    
    private GeneroFacade generoFacade;
   
    public List<Genero> obtenerTodos() {
        return this.generoFacade.findAll();
    }
    
    public Genero obtenerPorCodigo(CodGeneroEnum codigo) {
        return this.generoFacade.find(codigo);
    }
    
    public void crear(Genero genero) {
        this.generoFacade.create(genero);
    }
    
    public void modificar(Genero genero) {
        this.generoFacade.edit(genero);
    }
    
}
