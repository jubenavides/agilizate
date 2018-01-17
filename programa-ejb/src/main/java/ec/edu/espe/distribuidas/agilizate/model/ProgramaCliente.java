/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import ec.edu.espe.distribuidas.agilizate.enums.EstadoProgramaClienteEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "programa_cliente")
public class ProgramaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ProgramaClientePK programaClientePK;
    
    @Column(name = "DESCRIPCION", nullable=false, length = 500)
    private String descripcion;
    
    @Column(name = "FECHA_INICIO", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    @Column(name = "EJERCICIO_FISICO", nullable=false)
    private short ejercicioFisico;
    
    @Column(name = "EJERCICIO_MENTAL", nullable=false)
    private short ejercicioMental;
    
    @Column(name = "EJERCICIO_COMBINADO", nullable=false)
    private short ejercicioCombinado;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable=false,length = 3)
    private EstadoProgramaClienteEnum estado;
    
    @Column(name = "TOTAL_DURACION")
    private Short totalDuracion;

    @JoinColumn(name="COD_CLIENTE",referencedColumnName="COD_CLIENTE",nullable=false,insertable=false,updatable=false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    
    public ProgramaCliente() {
    }

    public ProgramaCliente(ProgramaClientePK programaClientePK) {
        this.programaClientePK = programaClientePK;
    }

    public ProgramaCliente(int codPrograma, int codCliente) {
        this.programaClientePK = new ProgramaClientePK(codPrograma, codCliente);
    }

    public ProgramaClientePK getProgramaClientePK() {
        return programaClientePK;
    }

    public void setProgramaClientePK(ProgramaClientePK programaClientePK) {
        this.programaClientePK = programaClientePK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public short getEjercicioFisico() {
        return ejercicioFisico;
    }

    public void setEjercicioFisico(short ejercicioFisico) {
        this.ejercicioFisico = ejercicioFisico;
    }

    public short getEjercicioMental() {
        return ejercicioMental;
    }

    public void setEjercicioMental(short ejercicioMental) {
        this.ejercicioMental = ejercicioMental;
    }

    public short getEjercicioCombinado() {
        return ejercicioCombinado;
    }

    public void setEjercicioCombinado(short ejercicioCombinado) {
        this.ejercicioCombinado = ejercicioCombinado;
    }

    public EstadoProgramaClienteEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoProgramaClienteEnum estado) {
        this.estado = estado;
    }

    public Short getTotalDuracion() {
        return totalDuracion;
    }

    public void setTotalDuracion(Short totalDuracion) {
        this.totalDuracion = totalDuracion;
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
        hash += (programaClientePK != null ? programaClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaCliente)) {
            return false;
        }
        ProgramaCliente other = (ProgramaCliente) object;
        if ((this.programaClientePK == null && other.programaClientePK != null) || (this.programaClientePK != null && !this.programaClientePK.equals(other.programaClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProgramaCliente{" + "programaClientePK=" + programaClientePK + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", ejercicioFisico=" + ejercicioFisico + ", ejercicioMental=" + ejercicioMental + ", ejercicioCombinado=" + ejercicioCombinado + ", estado=" + estado + ", totalDuracion=" + totalDuracion + ", cliente=" + cliente + '}';
    }

      
}
