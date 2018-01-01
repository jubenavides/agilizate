/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.model.TipoCliente;
import ec.edu.espe.distribuidas.agilizate.service.TipoClienteService;
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
public class TipoClienteBean extends BaseBean implements Serializable{
    
    private List<TipoCliente> tiposClientes;
    private TipoCliente tipoCliente;
    private TipoCliente tipoClienteSel;
    
    @Inject
    private TipoClienteService tipoClienteService;
    
    @PostConstruct
    public void init() {
        this.tiposClientes = this.tipoClienteService.obtenerTodos();
        this.tipoCliente = new TipoCliente();
    }

    public List<TipoCliente> getTiposClientes() {
        return tiposClientes;
    }
   
    @Override
    public void agregar() {
        this.tipoCliente = new TipoCliente();
        super.agregar();
        
    }

    @Override
    public void modificar() {
        super.modificar();
        this.tipoCliente = new TipoCliente();
        this.tipoCliente.setCodigo(this.tipoClienteSel.getCodigo());
        this.tipoCliente.setNombre(this.tipoClienteSel.getNombre());
        this.tipoCliente.setDescripcion(this.tipoClienteSel.getDescripcion());
    }
    
    public void eliminar() {
        try {
            this.tipoClienteService.eliminar(this.tipoClienteSel.getCodigo());
            this.tiposClientes = this.tipoClienteService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.tipoClienteSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.tipoCliente = this.tipoClienteSel;
    }

    public void cancelar() {
        super.reset();
        this.tipoCliente = new TipoCliente();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                this.tipoClienteService.crear(this.tipoCliente);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el nuevo tipo de cliente: " + this.tipoCliente.getNombre());
            } else {
                this.tipoClienteService.modificar(this.tipoCliente);
                FacesUtil.addMessageInfo("Se modific\u00f3 el tipo de cliente: " + this.tipoCliente.getNombre());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.tipoCliente = new TipoCliente();
        this.tiposClientes = this.tipoClienteService.obtenerTodos();
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoClienteSel() {
        return tipoClienteSel;
    }

    public void setTipoClienteSel(TipoCliente tipoClienteSel) {
        this.tipoClienteSel = tipoClienteSel;
    }
    
    
 
}
