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
@Table(name = "material")
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_MATERIAL", nullable = false)
    private Integer codMaterial;

    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "IMAGEN", length = 200)
    private String imagen;

    public Material() {
    }

    public Material(Integer codMaterial) {
        this.codMaterial = codMaterial;
    }

    public Material(Integer codMaterial, String descripcion) {
        this.codMaterial = codMaterial;
        this.descripcion = descripcion;
    }

    public Integer getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Integer codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMaterial != null ? codMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.codMaterial == null && other.codMaterial != null) || (this.codMaterial != null && !this.codMaterial.equals(other.codMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Material{" + "codMaterial=" + codMaterial + ", descripcion=" + descripcion + ", imagen=" + imagen + '}';
    }

}
