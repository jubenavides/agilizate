/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.model.Material;
import ec.edu.espe.distribuidas.agilizate.service.MaterialService;
import ec.edu.espe.distribuidas.agilizate.web.util.FacesUtil;
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
public class MaterialBean extends BaseBean implements Serializable{
    
    private List<Material> materiales;
    private Material material;
    private Material materialSel;
    
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

    @Override
    public void agregar() {
        this.material = new Material();
        super.agregar();
        
    }

    @Override
    public void modificar() {
        super.modificar();
        this.material = new Material();
        this.material.setCodigo(this.materialSel.getCodigo());
        this.material.setDescripcion(this.materialSel.getDescripcion());
        this.material.setImagen(this.materialSel.getImagen());
    }
     
    public void eliminar() {
        try {
            this.materialService.eliminar(this.materialSel.getCodigo());
            this.materiales = this.materialService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.materialSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.material = this.materialSel;
    }

    public void cancelar() {
        super.reset();
        this.material = new Material();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.materialService.crear(this.material);
                FacesUtil.addMessageInfo("Se agreg\u00f3 un nuevo tipo de material");
            } else {
                this.materialService.modificar(this.material);
                FacesUtil.addMessageInfo("Se modific\u00f3 el tipo de material: " + this.material.getCodigo());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.material = new Material();
        this.materiales = this.materialService.obtenerTodos();
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Material getMaterialSel() {
        return materialSel;
    }

    public void setMaterialSel(Material materialSel) {
        this.materialSel = materialSel;
    }
    
    
}

