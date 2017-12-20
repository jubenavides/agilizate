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
@Table(name = "genero")
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_GENERO", nullable = false, length = 1)
    private String codGenero;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;

    public Genero() {
    }

    public Genero(String codGenero) {
        this.codGenero = codGenero;
    }

    public Genero(String codGenero, String descripcion) {
        this.codGenero = codGenero;
        this.descripcion = descripcion;
    }

    public String getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(String codGenero) {
        this.codGenero = codGenero;
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
        hash += (codGenero != null ? codGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.codGenero == null && other.codGenero != null) || (this.codGenero != null && !this.codGenero.equals(other.codGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Genero{" + "codGenero=" + codGenero + ", descripcion=" + descripcion + '}';
    }

}
