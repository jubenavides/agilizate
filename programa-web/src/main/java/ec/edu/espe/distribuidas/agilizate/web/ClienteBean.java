/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.enums.CodGeneroEnum;
import ec.edu.espe.distribuidas.agilizate.model.Cliente;
import ec.edu.espe.distribuidas.agilizate.model.Genero;
import ec.edu.espe.distribuidas.agilizate.model.Pasatiempo;
import ec.edu.espe.distribuidas.agilizate.model.TipoCliente;
import ec.edu.espe.distribuidas.agilizate.service.ClienteService;
import ec.edu.espe.distribuidas.agilizate.service.DificultadService;
import ec.edu.espe.distribuidas.agilizate.service.GeneroService;
import ec.edu.espe.distribuidas.agilizate.service.PasatiempoService;
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
public class ClienteBean extends BaseBean implements Serializable{
    
    private List<Cliente> clientes;
    private List<TipoCliente> tipoClientes;
    private List<Genero> generos;
    private List<Pasatiempo> pasaTiempos;
            
    private Cliente cliente;
    private Cliente clienteSel;
    private Integer codTipoCliente;
    private CodGeneroEnum  codGenero;
    private Integer codPasatiempo;
    
    
    @Inject
    private ClienteService clienteService;
    @Inject
    private GeneroService generoService;
    @Inject
    private PasatiempoService pasatiempoService;
    @Inject
    private TipoClienteService tipoClienteService;
    
    @PostConstruct
    public void init() {
        this.clientes = this.clienteService.obtenerTodos();
        this.cliente = new Cliente();
        this.pasaTiempos = this.pasatiempoService.obtenerTodos();
        this.generos = this.generoService.obtenerTodos();
        this.tipoClientes = this.tipoClienteService.obtenerTodos();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
    @Override
    public void agregar() {
        this.cliente = new Cliente();
        super.agregar();
        
    }

    @Override
    public void modificar() {
        super.modificar();
        this.cliente = new Cliente();
        this.cliente.setCodigo(this.clienteSel.getCodigo());
        this.cliente.setCodTipoCliente(this.clienteSel.getCodTipoCliente());
        this.cliente.setCodGenero(this.clienteSel.getCodGenero());
        this.cliente.setCodPasatiempo(this.clienteSel.getCodPasatiempo());
        this.cliente.setNombre(this.clienteSel.getNombre());
        this.cliente.setApellido(this.clienteSel.getApellido());
        this.cliente.setEdad(this.clienteSel.getEdad());
        this.cliente.setCorreo(this.clienteSel.getCorreo());
        
    }
    
    public void eliminar() {
        try {
            this.clienteService.eliminar(this.clienteSel.getCodigo());
            this.clientes = this.clienteService.obtenerTodos();
            FacesUtil.addMessageInfo("Se elimino el registro ");
            this.clienteSel = null;
        } catch (Exception e) {
            FacesUtil.addMessageError(null, "No se puede eliminar el registro seleccionado. Verifique que no tenga informacion relacionada.");
        }
    }

    @Override
    public void detalles() {
        super.detalles();
        this.cliente = this.clienteSel;
    }

    public void cancelar() {
        super.reset();
        this.cliente = new Cliente();
    }

    public void guardar() {
        try {
            if (this.enAgregar) {
                //this.cliente.setCodPasatiempo(this.codPasatiempo);
                System.out.println("Pasatiempo ----"+this.codPasatiempo);
                this.clienteService.crear(this.cliente);
                FacesUtil.addMessageInfo("Se agreg\u00f3 el nuevo cliente: " + this.cliente.getNombre());
            } else {
                this.clienteService.modificar(this.cliente);
                FacesUtil.addMessageInfo("Se modific\u00f3 el cliente: " + this.cliente.getNombre());
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurrí\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.clientes = this.clienteService.obtenerTodos();
        this.cliente = new Cliente();
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClienteSel() {
        return clienteSel;
    }

    public void setClienteSel(Cliente clienteSel) {
        this.clienteSel = clienteSel;
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<TipoCliente> getTipoClientes() {
        return tipoClientes;
    }

    public void setTipoClientes(List<TipoCliente> tipoClientes) {
        this.tipoClientes = tipoClientes;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Pasatiempo> getPasaTiempos() {
        return pasaTiempos;
    }

    public void setPasaTiempos(List<Pasatiempo> pasaTiempos) {
        this.pasaTiempos = pasaTiempos;
    }

    public Integer getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(Integer codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }


    public Integer getCodPasatiempo() {
        return codPasatiempo;
    }

    public void setCodPasatiempo(Integer codPasatiempo) {
        this.codPasatiempo = codPasatiempo;
    }

    public GeneroService getGeneroService() {
        return generoService;
    }

    public void setGeneroService(GeneroService generoService) {
        this.generoService = generoService;
    }

    public PasatiempoService getPasatiempoService() {
        return pasatiempoService;
    }

    public void setPasatiempoService(PasatiempoService pasatiempoService) {
        this.pasatiempoService = pasatiempoService;
    }

    public TipoClienteService getTipoClienteService() {
        return tipoClienteService;
    }

    public void setTipoClienteService(TipoClienteService tipoClienteService) {
        this.tipoClienteService = tipoClienteService;
    }

    public CodGeneroEnum getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(CodGeneroEnum codGenero) {
        this.codGenero = codGenero;
    }
    
    
    
}
