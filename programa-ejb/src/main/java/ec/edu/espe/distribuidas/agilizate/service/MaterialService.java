/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
}
