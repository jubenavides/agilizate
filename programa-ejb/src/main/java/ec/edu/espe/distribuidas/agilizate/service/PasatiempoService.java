/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.PasatiempoFacade;
import ec.edu.espe.distribuidas.agilizate.model.Pasatiempo;
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
public class PasatiempoService{

    @EJB
    private PasatiempoFacade pasatiempoFacade;
   
    public List<Pasatiempo> obtenerTodos() {
        return this.pasatiempoFacade.findAll();
    }
    
    public Pasatiempo obtenerPorCodigo(Integer codigo) {
        return this.pasatiempoFacade.find(codigo);
    }
    
    public void crear(Pasatiempo pasatiempo) {
        this.pasatiempoFacade.create(pasatiempo);
    }
    
    public void modificar(Pasatiempo pasatiempo) {
        this.pasatiempoFacade.edit(pasatiempo);
    }
    
    public void eliminar(Integer codigo) {
        Pasatiempo pasatiempo = this.pasatiempoFacade.find(codigo);
        this.pasatiempoFacade.remove(pasatiempo);
    }
    
}
