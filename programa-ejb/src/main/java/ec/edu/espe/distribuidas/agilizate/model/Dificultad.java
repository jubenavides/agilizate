/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "dificultad")
@NamedQueries({
    @NamedQuery(name = "Dificultad.findAll", query = "SELECT d FROM Dificultad d")})
public class Dificultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_DIFICULTAD")
    private String codDificultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRIPCION")
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
        return "ec.edu.espe.distribuidas.agilizate.model.Dificultad[ codDificultad=" + codDificultad + " ]";
    }
    
}
