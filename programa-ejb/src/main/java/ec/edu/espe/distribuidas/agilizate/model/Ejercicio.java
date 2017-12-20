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
@Table(name = "ejercicio")
@NamedQueries({
    @NamedQuery(name = "Ejercicio.findAll", query = "SELECT e FROM Ejercicio e")})
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EJERCICIO")
    private Integer codEjercicio;
    @Size(max = 3)
    @Column(name = "COD_PASATIEMPO")
    private String codPasatiempo;
    @Size(max = 1)
    @Column(name = "COD_GENERO")
    private String codGenero;
    @Size(max = 3)
    @Column(name = "COD_CATEGORIA")
    private String codCategoria;
    @Column(name = "COD_MATERIAL")
    private Integer codMaterial;
    @Size(max = 3)
    @Column(name = "COD_DIFICULTAD")
    private String codDificultad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Ejercicio() {
    }

    public Ejercicio(Integer codEjercicio) {
        this.codEjercicio = codEjercicio;
    }

    public Ejercicio(Integer codEjercicio, String descripcion) {
        this.codEjercicio = codEjercicio;
        this.descripcion = descripcion;
    }

    public Integer getCodEjercicio() {
        return codEjercicio;
    }

    public void setCodEjercicio(Integer codEjercicio) {
        this.codEjercicio = codEjercicio;
    }

    public String getCodPasatiempo() {
        return codPasatiempo;
    }

    public void setCodPasatiempo(String codPasatiempo) {
        this.codPasatiempo = codPasatiempo;
    }

    public String getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(String codGenero) {
        this.codGenero = codGenero;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Integer getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Integer codMaterial) {
        this.codMaterial = codMaterial;
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
        hash += (codEjercicio != null ? codEjercicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejercicio)) {
            return false;
        }
        Ejercicio other = (Ejercicio) object;
        if ((this.codEjercicio == null && other.codEjercicio != null) || (this.codEjercicio != null && !this.codEjercicio.equals(other.codEjercicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.agilizate.model.Ejercicio[ codEjercicio=" + codEjercicio + " ]";
    }
    
}
