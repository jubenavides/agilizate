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
@Table(name = "dificultad")
public class Dificultad implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_DIFICULTAD", nullable = false, length = 3)
    private String codDificultad;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    private String descripcion;

    public Dificultad() {
    }

    public Dificultad(String codDificultad) {
        this.codDificultad = codDificultad;
    }

    public Dificultad(String codDificultad, String descripcion) {
        this.codDificultad = codDificultad;
        this.descripcion = descripcion;
    }

    public String getCodDificultad() {
        return codDificultad;
    }

    public void setCodDificultad(String codDificultad) {
        this.codDificultad = codDificultad;
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
        hash += (codDificultad != null ? codDificultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dificultad)) {
            return false;
        }
        Dificultad other = (Dificultad) object;
        if ((this.codDificultad == null && other.codDificultad != null) || (this.codDificultad != null && !this.codDificultad.equals(other.codDificultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dificultad{" + "codDificultad=" + codDificultad + ", descripcion=" + descripcion + '}';
    }
    
}
