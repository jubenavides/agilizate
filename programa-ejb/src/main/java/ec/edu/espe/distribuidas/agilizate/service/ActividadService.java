/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.service;

import ec.edu.espe.distribuidas.agilizate.dao.ActividadDiaFacade;
import ec.edu.espe.distribuidas.agilizate.enums.CumplidoActividadEnum;
import ec.edu.espe.distribuidas.agilizate.model.ActividadDia;
import ec.edu.espe.distribuidas.agilizate.model.ActividadDiaPK;
import ec.edu.espe.distribuidas.agilizate.model.Ejercicio;
import ec.edu.espe.distribuidas.agilizate.model.ProgramaCliente;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DanielCasa
 */
@Stateless
@LocalBean
public class ActividadService{

    @EJB    
    private ActividadDiaFacade actividadFacade;
   
    @Inject
    private EjercicioService ejercicioService;
    
    public List<ActividadDia> obtenerTodos() {
        return this.actividadFacade.findAll();
    }

    public void crear(ActividadDia actividadDia) {
        this.actividadFacade.create(actividadDia);
    }
    
     public List<ActividadDia> obtenerPorProgramaCliente(Integer codPrograma, Integer codCliente) {
        return this.actividadFacade.findByCliPro(codCliente, codPrograma);
    }
    
    public void generarActividades(ProgramaCliente programa){
        
        Integer codDificultad = 1;
        List<Ejercicio> ejerciciosEspecificosFaciles = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), programa.getCliente().getCodPasatiempo(), codDificultad);
        System.out.println("Especificos Faciles: "+ ejerciciosEspecificosFaciles.size()+"---"+ejerciciosEspecificosFaciles);       
        List<Ejercicio> ejerciciosGeneroOtrosFaciles = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), programa.getCliente().getCodPasatiempo(), codDificultad);
        System.out.println("Genericos Faciles: "+ ejerciciosGeneroOtrosFaciles.size()+"---"+ejerciciosGeneroOtrosFaciles);
        List<Ejercicio> ejerciciosGeneroOtrosPasaFaciles = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), 4, codDificultad);
        System.out.println("Genericos Faciles: "+ ejerciciosGeneroOtrosPasaFaciles.size()+"---"+ejerciciosGeneroOtrosPasaFaciles);
        
        codDificultad = 2;
        List<Ejercicio> ejerciciosEspecificosMedios = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), programa.getCliente().getCodPasatiempo(), codDificultad);
        System.out.println("Especificos Medios:"+ ejerciciosEspecificosMedios.size()+"---"+ejerciciosEspecificosMedios);  
        List<Ejercicio> ejerciciosGeneroOtrosMedios = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), programa.getCliente().getCodPasatiempo(), codDificultad);
        System.out.println("Genericos Medios: "+ ejerciciosGeneroOtrosMedios.size()+"---"+ejerciciosGeneroOtrosMedios);
        List<Ejercicio> ejerciciosGeneroOtrosPasaMedios = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), 4, codDificultad);
        System.out.println("Genericos Faciles: "+ ejerciciosGeneroOtrosPasaMedios.size()+"---"+ejerciciosGeneroOtrosPasaMedios);
        
        codDificultad = 3;
        List<Ejercicio> ejerciciosEspecificosDificiles = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), programa.getCliente().getCodPasatiempo(), codDificultad);
        System.out.println("Especificos Dificiles: "+ ejerciciosEspecificosDificiles.size()+"---"+ejerciciosEspecificosDificiles);
        List<Ejercicio> ejerciciosGeneroOtrosDificiles = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), programa.getCliente().getCodPasatiempo(), codDificultad);
        System.out.println("Genericos Dificiles: "+ ejerciciosGeneroOtrosDificiles.size()+"---"+ejerciciosGeneroOtrosDificiles);
        List<Ejercicio> ejerciciosGeneroOtrosPasaDificiles = this.ejercicioService.obtenerPorGTcPD(programa.getCliente().getCodGenero(), programa.getCliente().getCodTipoCliente(), 4, codDificultad);
        System.out.println("Genericos Dificiles: "+ ejerciciosGeneroOtrosPasaDificiles.size()+"---"+ejerciciosGeneroOtrosPasaDificiles);
        
        ActividadDia actividad = new ActividadDia();
        actividad.setActividadDiaPK(new ActividadDiaPK());
        
        List<Ejercicio> ejerciciosTotales = new ArrayList<>();
        ejerciciosTotales.addAll(ejerciciosEspecificosFaciles);
        ejerciciosTotales.addAll(ejerciciosGeneroOtrosFaciles);
        ejerciciosTotales.addAll(ejerciciosGeneroOtrosPasaFaciles);
        ejerciciosTotales.addAll(ejerciciosEspecificosMedios);
        ejerciciosTotales.addAll(ejerciciosGeneroOtrosMedios);
        ejerciciosTotales.addAll(ejerciciosGeneroOtrosPasaMedios);
        ejerciciosTotales.addAll(ejerciciosEspecificosDificiles);
        ejerciciosTotales.addAll(ejerciciosGeneroOtrosDificiles);
        ejerciciosTotales.addAll(ejerciciosGeneroOtrosPasaDificiles);
        
        System.out.println("Ejercicios Faciles total: "+ ejerciciosTotales.size()+"---"+ejerciciosTotales);
        
        

        SecureRandom sr = new SecureRandom();
        for (int i = 0; i < (int)programa.getTotalDuracion(); i++) {
            for (int j = 0; j < 3; j++) {
               actividad = new ActividadDia();
                ActividadDiaPK actividadDiaPk = new ActividadDiaPK();  
                actividadDiaPk.setCodCliente(programa.getCliente().getCodigo());
                actividadDiaPk.setCodPrograma(programa.getProgramaClientePK().getCodPrograma()); 
                actividadDiaPk.setCodDia(i+1);   
                
                int ejer;
                do {
                    ejer = sr.nextInt(ejerciciosTotales.size())+1;    
                } while (this.ejercicioService.obtenerPorCodigo(ejer)== null);

                actividadDiaPk.setCodEjercicio(ejer);
                actividad.setActividadDiaPK(actividadDiaPk);
                actividad.setCumplido(CumplidoActividadEnum.NO);
                actividad.setFecha(CalculaFechaFin(programa,j));
                actividad.setEjercicio(this.ejercicioService.obtenerPorCodigo(ejer));
                System.out.println("Ya casi: "+i+"---"+j+"------"+actividad);
                crear(actividad); 
            }
        }        
    }
    
    public Date CalculaFechaFin(ProgramaCliente programa, Integer TotalDuracion) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(programa.getFechaInicio());
        calendar.add(Calendar.DAY_OF_YEAR,TotalDuracion);
        return calendar.getTime();
    }
    
}
