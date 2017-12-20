/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "seguimiento")
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_SEGUIMIENTO", nullable = false)
    private Integer codSeguimiento;
    
    @Column(name = "AVANCE", nullable = false)
    private short avance;
    
    @Column(name = "CALIFICACION_APLICACION", nullable = false)
    private short calificacionAplicacion;
    
    @Column(name = "TOTAL_DURACION")
    private Short totalDuracion;

    public Seguimiento() {
    }

    public Seguimiento(Integer codSeguimiento) {
        this.codSeguimiento = codSeguimiento;
    }

    public Seguimiento(Integer codSeguimiento, short avance, short calificacionAplicacion) {
        this.codSeguimiento = codSeguimiento;
        this.avance = avance;
        this.calificacionAplicacion = calificacionAplicacion;
    }

    public Integer getCodSeguimiento() {
        return codSeguimiento;
    }

    public void setCodSeguimiento(Integer codSeguimiento) {
        this.codSeguimiento = codSeguimiento;
    }

    public short getAvance() {
        return avance;
    }

    public void setAvance(short avance) {
        this.avance = avance;
    }

    public short getCalificacionAplicacion() {
        return calificacionAplicacion;
    }

    public void setCalificacionAplicacion(short calificacionAplicacion) {
        this.calificacionAplicacion = calificacionAplicacion;
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
        hash += (codSeguimiento != null ? codSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.codSeguimiento == null && other.codSeguimiento != null) || (this.codSeguimiento != null && !this.codSeguimiento.equals(other.codSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seguimiento{" + "codSeguimiento=" + codSeguimiento + ", avance=" + avance + ", calificacionAplicacion=" + calificacionAplicacion + ", totalDuracion=" + totalDuracion + '}';
    }
    
}
