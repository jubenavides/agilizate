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
@Table(name = "pasatiempo")
@NamedQueries({
    @NamedQuery(name = "Pasatiempo.findAll", query = "SELECT p FROM Pasatiempo p")})
public class Pasatiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_PASATIEMPO")
    private String codPasatiempo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Pasatiempo() {
    }

    public Pasatiempo(String codPasatiempo) {
        this.codPasatiempo = codPasatiempo;
    }

    public Pasatiempo(String codPasatiempo, String descripcion) {
        this.codPasatiempo = codPasatiempo;
        this.descripcion = descripcion;
    }

    public String getCodPasatiempo() {
        return codPasatiempo;
    }

    public void setCodPasatiempo(String codPasatiempo) {
        this.codPasatiempo = codPasatiempo;
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
        hash += (codPasatiempo != null ? codPasatiempo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pasatiempo)) {
            return false;
        }
        Pasatiempo other = (Pasatiempo) object;
        if ((this.codPasatiempo == null && other.codPasatiempo != null) || (this.codPasatiempo != null && !this.codPasatiempo.equals(other.codPasatiempo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.agilizate.model.Pasatiempo[ codPasatiempo=" + codPasatiempo + " ]";
    }
    
}
