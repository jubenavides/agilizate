/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.model.Dificultad;
import ec.edu.espe.distribuidas.agilizate.service.DificultadService;
import ec.edu.espe.distribuidas.agilizate.web.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author DanielCasa
 */
@Named
@ViewScoped
public class DificultadBean extends BaseBean implements Serializable{
    
    private List<Dificultad> dificultades;
    private Dificultad dificultad;
    private Dificultad dificultadSel;
    
    @Inject
    private DificultadService dificultadService;
    
    @PostConstruct
    public void init() {
        this.dificultades = this.dificultadService.obtenerTodos();
        this.dificultad = new Dificultad();
    }

    public List<Dificultad> getDificultades() {
        return dificultades;
    }
    
    @Override
    public void agregar() {
        this.dificultad = new Dificultad();
        super.agregar();
        
    }

    @Override
    public void modificar() {
        super.modificar();
        this.dificultad = new Dificultad();
        this.dificultad.setCodigo(this.dificultadSel.getCodigo());
        this.dificultad.setNombre(this.dificultadSel.getNombre());
        this.dificultad.setDescripcion(this.dificultadSel.getDescripcion());
    }
    
    public void eliminar() {
        try {
            this.dificultadService.eliminar(this.dificultadSel.getCodigo());
            this.dificultades = this.dificultadService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.dificultadSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.dificultad = this.dificultadSel;
    }

    public void cancelar() {
        super.reset();
        this.dificultad = new Dificultad();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.dificultadService.crear(this.dificultad);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el nivel de dificultad: " + this.dificultad.getNombre());
            } else {
                this.dificultadService.modificar(this.dificultad);
                FacesUtil.addMessageInfo("Se modific\u00f3 el nivel de dificultad: " + this.dificultad.getNombre());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.dificultad = new Dificultad();
        this.dificultades = this.dificultadService.obtenerTodos();
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Dificultad getDificultadSel() {
        return dificultadSel;
    }

    public void setDificultadSel(Dificultad dificultadSel) {
        this.dificultadSel = dificultadSel;
    }
   
}
