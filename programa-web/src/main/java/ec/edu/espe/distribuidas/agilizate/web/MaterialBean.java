/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.model.Material;
import ec.edu.espe.distribuidas.agilizate.service.MaterialService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Daniel
 */
@Named
@ViewScoped
public class MaterialBean implements Serializable{
    
    private List<Material> materiales;
    private boolean enAgregar;
    
    private Material material;
    
    @Inject
    private MaterialService materialService;
    
    @PostConstruct
    public void init() {
        this.materiales = this.materialService.obtenerTodos();
        this.material = new Material();
    }

    public List<Material> getMateriales() {
        return materiales;
    }
    
    
    public void agregar() {
        this.material = new Material();
        this.enAgregar = true;
        
    }
    
    public void cancelar() {
        this.enAgregar = false;
    }
    
    public void guardar() {
        this.materialService.crear(this.material);
        this.enAgregar = false;
        this.materiales = this.materialService.obtenerTodos();
    }

    public boolean isEnAgregar() {
        return enAgregar;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    
}

