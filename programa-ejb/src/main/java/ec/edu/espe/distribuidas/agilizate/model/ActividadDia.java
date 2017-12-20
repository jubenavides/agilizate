/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "actividad_dia")
public class ActividadDia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ActividadDiaPK actividadDiaPK;
    
    @Column(name = "FECHA",nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "DURACION",nullable=false)
    private short duracion;

    @Column(name = "CUMPLIDO",nullable=false,length=2)
    private String cumplido;

    @JoinColumn(name="COD_EJERCICIO",referencedColumnName="COD_EJERCICIO",nullable=false,insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private Ejercicio ejercicio;
       
    @JoinColumn(name="COD_PROGRAMA",referencedColumnName="COD_PROGRAMA",nullable=false,insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private ProgramaCliente programaCliente;
    
    @JoinColumn(name="COD_CLIENTE",referencedColumnName="COD_CLIENTE",nullable=false,insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private Cliente cliente;
       
    public ActividadDia() {
    }

    public ActividadDia(ActividadDiaPK actividadDiaPK) {
        this.actividadDiaPK = actividadDiaPK;
    }

    public ActividadDia(ActividadDiaPK actividadDiaPK, Date fecha, short duracion, String cumplido) {
        this.actividadDiaPK = actividadDiaPK;
        this.fecha = fecha;
        this.duracion = duracion;
        this.cumplido = cumplido;
    }

    public ActividadDia(int codDia, int codEjercicio, int codPrograma, int codCliente) {
        this.actividadDiaPK = new ActividadDiaPK(codDia, codEjercicio, codPrograma, codCliente);
    }

    public ActividadDiaPK getActividadDiaPK() {
        return actividadDiaPK;
    }

    public void setActividadDiaPK(ActividadDiaPK actividadDiaPK) {
        this.actividadDiaPK = actividadDiaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public short getDuracion() {
        return duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    public String getCumplido() {
        return cumplido;
    }

    public void setCumplido(String cumplido) {
        this.cumplido = cumplido;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public ProgramaCliente getProgramaCliente() {
        return programaCliente;
    }

    public void setProgramaCliente(ProgramaCliente programaCliente) {
        this.programaCliente = programaCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadDiaPK != null ? actividadDiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadDia)) {
            return false;
        }
        ActividadDia other = (ActividadDia) object;
        if ((this.actividadDiaPK == null && other.actividadDiaPK != null) || (this.actividadDiaPK != null && !this.actividadDiaPK.equals(other.actividadDiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActividadDia{" + "actividadDiaPK=" + actividadDiaPK + ", fecha=" + fecha + ", duracion=" + duracion + ", cumplido=" + cumplido + ", ejercicio=" + ejercicio + ", programaCliente=" + programaCliente + ", cliente=" + cliente + '}';
    }
    
}
