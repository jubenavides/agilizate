/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.MaterialFacade;
import ec.edu.espe.distribuidas.agilizate.model.Material;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Daniel
 */
@Stateless
@LocalBean
public class MaterialService{

    @EJB
    private MaterialFacade materialFacade;
    
    public List<Material> obtenerTodos() {
        return this.materialFacade.findAll();
    }
    
    public void crear(Material material) {
        this.materialFacade.create(material);
    }
    
    public void modificar(Material material) {
        this.materialFacade.edit(material);
    }
    
    public void eliminar(Integer codigo) {
        Material material = this.materialFacade.find(codigo);
        this.materialFacade.remove(material);
    }
    
}
