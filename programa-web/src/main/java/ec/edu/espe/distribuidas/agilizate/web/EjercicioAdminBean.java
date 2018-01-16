/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.web;

import ec.edu.espe.distribuidas.agilizate.model.Dificultad;
import ec.edu.espe.distribuidas.agilizate.model.Ejercicio;
import ec.edu.espe.distribuidas.agilizate.model.Genero;
import ec.edu.espe.distribuidas.agilizate.model.Pasatiempo;
import ec.edu.espe.distribuidas.agilizate.service.DificultadService;
import ec.edu.espe.distribuidas.agilizate.service.EjercicioService;
import ec.edu.espe.distribuidas.agilizate.service.GeneroService;
import ec.edu.espe.distribuidas.agilizate.service.PasatiempoService;
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
    private List<Ejercicio> listadoEjercicios;
    private List<Dificultad> dificultades;
    private List<Pasatiempo> pasatiempos;
    
    //Variables
    private String filtro;
    private Ejercicio ejercicio;
    private Ejercicio ejercicioSel;
    private Integer codDificultad;
    private Integer codPasatiempo;
    
    //Boolean para render
    private Boolean enBusquedaPorDificultad;
    private Boolean enBusquedaPorPasatiempo;
    
    @Inject
    private EjercicioService ejercicioService;
    @Inject
    private DificultadService dificultadService;
    @Inject
    private PasatiempoService pasatiempoService;
    
    @PostConstruct
    public void init() {
        this.filtro = "DIF";
        this.ejercicio = new Ejercicio();
        this.ejercicio.setDificultad(new Dificultad());
        this.enBusquedaPorDificultad = true;
        this.dificultades = this.dificultadService.obtenerTodos();
        this.pasatiempos = this.pasatiempoService.obtenerTodos();
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
        
    }
    
   @Override
    public void agregar() {
        this.ejercicio = new Ejercicio();
        super.agregar();
    }

    public List<Dificultad> getDificultades() {
        return dificultades;
    }

    public List<Pasatiempo> getPasatiempos() {
        return pasatiempos;
    }

    public List<Ejercicio> getListadoEjercicios() {
        return listadoEjercicios;
    }

    public void setListadoEjercicios(List<Ejercicio> listadoEjercicios) {
        this.listadoEjercicios = listadoEjercicios;
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
      
}
