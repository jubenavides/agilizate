/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "programa_cliente")
@NamedQueries({
    @NamedQuery(name = "ProgramaCliente.findAll", query = "SELECT p FROM ProgramaCliente p")})
public class ProgramaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProgramaClientePK programaClientePK;
    @Column(name = "COD_SEGUIMIENTO")
    private Integer codSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EJERCICIO_FISICO")
    private short ejercicioFisico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EJERCICIO_MENTAL")
    private short ejercicioMental;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EJERCICIO_COMBINADO")
    private short ejercicioCombinado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "TOTAL_DURACION")
    private Short totalDuracion;

    public ProgramaCliente() {
    }

    public ProgramaCliente(ProgramaClientePK programaClientePK) {
        this.programaClientePK = programaClientePK;
    }

    public ProgramaCliente(ProgramaClientePK programaClientePK, String descripcion, Date fechaInicio, short ejercicioFisico, short ejercicioMental, short ejercicioCombinado, String estado) {
        this.programaClientePK = programaClientePK;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.ejercicioFisico = ejercicioFisico;
        this.ejercicioMental = ejercicioMental;
        this.ejercicioCombinado = ejercicioCombinado;
        this.estado = estado;
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

    public Integer getCodSeguimiento() {
        return codSeguimiento;
    }

    public void setCodSeguimiento(Integer codSeguimiento) {
        this.codSeguimiento = codSeguimiento;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Short getTotalDuracion() {
        return totalDuracion;
    }

    public void setTotalDuracion(Short totalDuracion) {
        this.totalDuracion = totalDuracion;
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
        return "ec.edu.espe.distribuidas.agilizate.model.ProgramaCliente[ programaClientePK=" + programaClientePK + " ]";
    }
    
}
