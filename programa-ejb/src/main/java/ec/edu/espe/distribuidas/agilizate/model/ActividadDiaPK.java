/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Daniel
 */
@Embeddable
public class ActividadDiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_DIA")
    private int codDia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EJERCICIO")
    private int codEjercicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PROGRAMA")
    private int codPrograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CLIENTE")
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
