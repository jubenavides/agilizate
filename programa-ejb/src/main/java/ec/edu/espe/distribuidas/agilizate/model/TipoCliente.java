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
@Table(name = "tipo_cliente")
public class TipoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_TIPO_CLIENTE", nullable = false, length = 3)
    private String codTipoCliente;
    
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;

    public TipoCliente() {
    }

    public TipoCliente(String codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public String getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(String codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoCliente != null ? codTipoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCliente)) {
            return false;
        }
        TipoCliente other = (TipoCliente) object;
        if ((this.codTipoCliente == null && other.codTipoCliente != null) || (this.codTipoCliente != null && !this.codTipoCliente.equals(other.codTipoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoCliente{" + "codTipoCliente=" + codTipoCliente + ", descripcion=" + descripcion + '}';
    }
    
}