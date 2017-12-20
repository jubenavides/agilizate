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
@Table(name = "actividad_dia")
@NamedQueries({
    @NamedQuery(name = "ActividadDia.findAll", query = "SELECT a FROM ActividadDia a")})
public class ActividadDia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActividadDiaPK actividadDiaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DURACION")
    private short duracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CUMPLIDO")
    private String cumplido;

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
        return "ec.edu.espe.distribuidas.agilizate.model.ActividadDia[ actividadDiaPK=" + actividadDiaPK + " ]";
    }
    
}
