/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.model.TipoCliente;
import ec.edu.espe.distribuidas.agilizate.model.TipoInstruccion;
import ec.edu.espe.distribuidas.agilizate.service.TipoClienteService;
import ec.edu.espe.distribuidas.agilizate.service.TipoInstruccionService;
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
public class TipoInstruccionBean extends BaseBean implements Serializable{
    
    private List<TipoInstruccion> tiposInstruccion;
    private TipoInstruccion tipoInstruccion;
    private TipoInstruccion tipoInstruccionSel;
    
    @Inject
    private TipoInstruccionService tipoInstruccionService;
    
    @PostConstruct
    public void init() {
        this.tiposInstruccion = this.tipoInstruccionService.obtenerTodos();
        this.tipoInstruccion = new TipoInstruccion();
    }

    public List<TipoInstruccion> getTiposInstruccion() {
        return tiposInstruccion;
    }
      
   
    @Override
    public void agregar() {
        this.tipoInstruccion = new TipoInstruccion();
        super.agregar();
        
    }

    @Override
    public void modificar() {
        super.modificar();
        this.tipoInstruccion = new TipoInstruccion();
        this.tipoInstruccion.setCodigo(this.tipoInstruccionSel.getCodigo());
        this.tipoInstruccion.setNombre(this.tipoInstruccionSel.getNombre());
        this.tipoInstruccion.setDescripcion(this.tipoInstruccionSel.getDescripcion());
    }
    
    public void eliminar() {
        try {
            this.tipoInstruccionService.eliminar(this.tipoInstruccionSel.getCodigo());
            this.tiposInstruccion = this.tipoInstruccionService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.tipoInstruccionSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.tipoInstruccion = this.tipoInstruccionSel;
    }

    public void cancelar() {
        super.reset();
        this.tipoInstruccion = new TipoInstruccion();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.tipoInstruccionService.crear(this.tipoInstruccion);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el nuevo tipo de instrucci\u00f3n: " + this.tipoInstruccion.getNombre());
            } else {
                this.tipoInstruccionService.modificar(this.tipoInstruccion);
                FacesUtil.addMessageInfo("Se modific\u00f3 el tipo de instrucci\u00f3n: " + this.tipoInstruccion.getNombre());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.tipoInstruccion = new TipoInstruccion();
        this.tiposInstruccion = this.tipoInstruccionService.obtenerTodos();
    }

    public TipoInstruccion getTipoInstruccion() {
        return tipoInstruccion;
    }

    public void setTipoInstruccion(TipoInstruccion tipoInstruccion) {
        this.tipoInstruccion = tipoInstruccion;
    }

    public TipoInstruccion getTipoInstruccionSel() {
        return tipoInstruccionSel;
    }

    public void setTipoInstruccionSel(TipoInstruccion tipoInstruccionSel) {
        this.tipoInstruccionSel = tipoInstruccionSel;
    }
   
}
