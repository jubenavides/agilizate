/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.enums.CodCategoriaEnum;
import ec.edu.espe.distribuidas.agilizate.enums.CodGeneroEnum;
import ec.edu.espe.distribuidas.agilizate.model.Categoria;
import ec.edu.espe.distribuidas.agilizate.model.Dificultad;
import ec.edu.espe.distribuidas.agilizate.model.Ejercicio;
import ec.edu.espe.distribuidas.agilizate.model.Genero;
import ec.edu.espe.distribuidas.agilizate.model.Material;
import ec.edu.espe.distribuidas.agilizate.model.Pasatiempo;
import ec.edu.espe.distribuidas.agilizate.model.TipoCliente;
import ec.edu.espe.distribuidas.agilizate.service.CategoriaService;
import ec.edu.espe.distribuidas.agilizate.service.DificultadService;
import ec.edu.espe.distribuidas.agilizate.service.EjercicioService;
import ec.edu.espe.distribuidas.agilizate.service.GeneroService;
import ec.edu.espe.distribuidas.agilizate.service.MaterialService;
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
public class EjercicioAdminBean extends BaseBean implements Serializable{
    
    //Listados
    private List<Ejercicio> ejercicios;
    private List<Dificultad> dificultades;
    private List<Pasatiempo> pasatiempos;
    private List<TipoCliente> tipoClientes;
    private List<Categoria> categorias;
    private List<Material> materiales;
    private List<Genero> generos;
    
    
    //Variables
    private String filtro;
    private Ejercicio ejercicio;
    private Ejercicio ejercicioSel;
    private Dificultad dificultad;
    
    //Variables para codigos
    private Integer codDificultad;
    private Integer codPasatiempo;
    private Integer codTipoCliente;
    private CodCategoriaEnum codCategoria;
    private Integer codMaterial;
    private CodGeneroEnum codGenero;
    
    //Boolean para render
    private Boolean enBusquedaPorDificultad;
    private Boolean enBusquedaPorPasatiempo;
    
    @Inject
    private EjercicioService ejercicioService;
    @Inject
    private DificultadService dificultadService;
    @Inject
    private PasatiempoService pasatiempoService;
    @Inject
    private TipoClienteService tipoClienteService;
    @Inject
    private CategoriaService categoriaService;
    @Inject
    private MaterialService materialService;
    @Inject
    private GeneroService generoService;
    
    @PostConstruct
    public void init() {
        this.filtro = "DIF";
        this.ejercicio = new Ejercicio();
        this.enBusquedaPorDificultad = true;
        this.codDificultad=1;
        this.dificultades = this.dificultadService.obtenerTodos();
        this.pasatiempos = this.pasatiempoService.obtenerTodos();
        this.tipoClientes = this.tipoClienteService.obtenerTodos();
        this.generos = this.generoService.obtenerTodos();
        this.categorias = this.categoriaService.obtenerTodos();
        this.materiales = this.materialService.obtenerTodos();
    }
    
    public void cambiarFiltro() {
        switch(this.filtro){
            case "DIF":
                this.enBusquedaPorPasatiempo = false;
                this.enBusquedaPorDificultad = true;
                break;
            case "PAS":
                this.enBusquedaPorDificultad = false;
                this.enBusquedaPorPasatiempo = true;
                break;
        }
    }
    
    public void buscar(){
        System.out.println("-----"+this.codDificultad);
        this.ejercicios = this.ejercicioService.obtenerPorDificultad(this.codDificultad);
    }
    
   @Override
    public void agregar() {

        this.ejercicio = new Ejercicio();
        super.agregar();
    }
    
     public void guardar() {     
        try {
            if (this.enAgregar) {
                this.ejercicioService.crear(this.ejercicio);
                FacesUtil.addMessageInfo("Se agreg\u00f3 un nuevo pasatiempo: ");
            } else {
                this.ejercicioService.modificar(this.ejercicio);
                FacesUtil.addMessageInfo("Se modific\u00f3 el pasatiempo: ");
            }
        } catch (Exception ex) {
            FacesUtil.addMessageError(null, "Ocurri\u00f3 un error al actualizar la informaci\u00f3n");
        }
        super.reset();
        this.ejercicio = new Ejercicio();
    }

    public List<Dificultad> getDificultades() {
        return dificultades;
    }

    public List<Pasatiempo> getPasatiempos() {
        return pasatiempos;
    }

    public List<Ejercicio> getListadoEjercicios() {
        return ejercicios;
    }

    public void setDificultades(List<Dificultad> dificultades) {
        this.dificultades = dificultades;
    }

    public void setPasatiempos(List<Pasatiempo> pasatiempos) {
        this.pasatiempos = pasatiempos;
    }

    public void setTipoClientes(List<TipoCliente> tipoClientes) {
        this.tipoClientes = tipoClientes;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public List<TipoCliente> getTipoClientes() {
        return tipoClientes;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Material> getMateriales() {
        return materiales;
    }
    
    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Ejercicio getEjercicioSel() {
        return ejercicioSel;
    }

    public void setEjercicioSel(Ejercicio ejercicioSel) {
        this.ejercicioSel = ejercicioSel;
    }
    
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    } 

    public Integer getCodDificultad() {
        return codDificultad;
    }

    public void setCodDificultad(Integer codDificultad) {
        this.codDificultad = codDificultad;
    }

    public Integer getCodPasatiempo() {
        return codPasatiempo;
    }

    public void setCodPasatiempo(Integer codPasatiempo) {
        this.codPasatiempo = codPasatiempo;
    }

    public Integer getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(Integer codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public CodCategoriaEnum getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(CodCategoriaEnum codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Integer getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Integer codMaterial) {
        this.codMaterial = codMaterial;
    }

    public CodGeneroEnum getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(CodGeneroEnum codGenero) {
        this.codGenero = codGenero;
    }
    
    public Boolean getEnBusquedaPorDificultad() {
        return enBusquedaPorDificultad;
    }

    public void setEnBusquedaPorDificultad(Boolean enBusquedaPorDificultad) {
        this.enBusquedaPorDificultad = enBusquedaPorDificultad;
    }

    public Boolean getEnBusquedaPorPasatiempo() {
        return enBusquedaPorPasatiempo;
    }

    public void setEnBusquedaPorPasatiempo(Boolean enBusquedaPorPasatiempo) {
        this.enBusquedaPorPasatiempo = enBusquedaPorPasatiempo;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }
      
    
    
}
