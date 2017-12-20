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
import javax.persistence.Embeddable;

/**
 *
 * @author Daniel
 */
@Embeddable
public class ActividadDiaPK implements Serializable {

    @Column(name = "COD_DIA", nullable=false)
    private int codDia;

    @Column(name = "COD_EJERCICIO", nullable=false)
    private int codEjercicio;

    @Column(name = "COD_PROGRAMA", nullable=false)
    private int codPrograma;
    
    @Column(name = "COD_CLIENTE", nullable=false)
    private int codCliente;

    public ActividadDiaPK() {
    }

    public ActividadDiaPK(int codDia, int codEjercicio, int codPrograma, int codCliente) {
        this.codDia = codDia;
        this.codEjercicio = codEjercicio;
        this.codPrograma = codPrograma;
        this.codCliente = codCliente;
    }

    public int getCodDia() {
        return codDia;
    }

    public void setCodDia(int codDia) {
        this.codDia = codDia;
    }

    public int getCodEjercicio() {
        return codEjercicio;
    }

    public void setCodEjercicio(int codEjercicio) {
        this.codEjercicio = codEjercicio;
    }

    public int getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(int codPrograma) {
        this.codPrograma = codPrograma;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codDia;
        hash += (int) codEjercicio;
        hash += (int) codPrograma;
        hash += (int) codCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadDiaPK)) {
            return false;
        }
        ActividadDiaPK other = (ActividadDiaPK) object;
        if (this.codDia != other.codDia) {
            return false;
        }
        if (this.codEjercicio != other.codEjercicio) {
            return false;
        }
        if (this.codPrograma != other.codPrograma) {
            return false;
        }
        if (this.codCliente != other.codCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.agilizate.model.ActividadDiaPK[ codDia=" + codDia + ", codEjercicio=" + codEjercicio + ", codPrograma=" + codPrograma + ", codCliente=" + codCliente + " ]";
    }
    
}
