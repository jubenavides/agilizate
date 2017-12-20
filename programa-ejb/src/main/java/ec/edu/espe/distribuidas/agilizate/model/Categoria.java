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
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_CATEGORIA", nullable = false, length = 3)
    private String codCategoria;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    public Categoria() {
    }

    public Categoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Categoria(String codCategoria, String descripcion) {
        this.codCategoria = codCategoria;
        this.descripcion = descripcion;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
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
        hash += (codCategoria != null ? codCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codCategoria == null && other.codCategoria != null) || (this.codCategoria != null && !this.codCategoria.equals(other.codCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "codCategoria=" + codCategoria + ", descripcion=" + descripcion + '}';
    }
  
}
