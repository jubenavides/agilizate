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
@Table(name = "pasatiempo")
public class Pasatiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_PASATIEMPO", nullable = false, length = 3)
    private String codPasatiempo;

    @Column(name = "DESCRIPCION", nullable = false, length = 100)
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
        return "Pasatiempo{" + "codPasatiempo=" + codPasatiempo + ", descripcion=" + descripcion + '}';
    }
    
}
