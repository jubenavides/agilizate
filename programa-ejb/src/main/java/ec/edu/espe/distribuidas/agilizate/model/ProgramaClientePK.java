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
public class ProgramaClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PROGRAMA")
    private int codPrograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CLIENTE")
    private int codCliente;

    public ProgramaClientePK() {
    }

    public ProgramaClientePK(int codPrograma, int codCliente) {
        this.codPrograma = codPrograma;
        this.codCliente = codCliente;
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
        hash += (int) codPrograma;
        hash += (int) codCliente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramaClientePK)) {
            return false;
        }
        ProgramaClientePK other = (ProgramaClientePK) object;
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
        return "ec.edu.espe.distribuidas.agilizate.model.ProgramaClientePK[ codPrograma=" + codPrograma + ", codCliente=" + codCliente + " ]";
    }
    
}
