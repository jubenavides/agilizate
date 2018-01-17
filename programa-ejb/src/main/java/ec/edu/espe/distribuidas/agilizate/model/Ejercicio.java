/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import ec.edu.espe.distribuidas.agilizate.enums.CodCategoriaEnum;
import ec.edu.espe.distribuidas.agilizate.enums.CodGeneroEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "ejercicio")
public class Ejercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_EJERCICIO", nullable = false)
    private Integer codEjercicio;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 500)
    private String descripcion;
    
    @Column(name = "COD_PASATIEMPO", nullable = false)
    private Integer codPasatiempo;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_GENERO", nullable = false, length = 1)
    private CodGeneroEnum codGenero;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_CATEGORIA", nullable = false, length = 3)
    private CodCategoriaEnum codCategoria;
    
    @Column(name = "COD_MATERIAL", nullable = false)
    private Integer codMaterial;
    
    @Column(name = "COD_DIFICULTAD", nullable = false)
    private Integer codDificultad;
    
    @Column(name = "COD_TIPO_CLIENTE", nullable = false)
    private Integer codTipoCliente;


    @JoinColumn(name = "COD_PASATIEMPO", referencedColumnName = "COD_PASATIEMPO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pasatiempo pasatiempo;
     
    @JoinColumn(name = "COD_GENERO", referencedColumnName = "COD_GENERO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Genero genero;
    
    @JoinColumn(name = "COD_CATEGORIA", referencedColumnName = "COD_CATEGORIA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;
   
    @JoinColumn(name = "COD_MATERIAL", referencedColumnName = "COD_MATERIAL", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Material material;
    
    @JoinColumn(name = "COD_DIFICULTAD", referencedColumnName = "COD_DIFICULTAD", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dificultad dificultad;
    
    @JoinColumn(name = "COD_TIPO_CLIENTE", referencedColumnName = "COD_TIPO_CLIENTE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoCliente tipoCliente;
     
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

    public Pasatiempo getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(Pasatiempo pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCodPasatiempo() {
        return codPasatiempo;
    }

    public void setCodPasatiempo(Integer codPasatiempo) {
        this.codPasatiempo = codPasatiempo;
    }

    public CodGeneroEnum getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(CodGeneroEnum codGenero) {
        this.codGenero = codGenero;
    }

    public CodCategoriaEnum getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(CodCategoriaEnum codCategoria) {
        this.codCategoria = codCategoria;
    }

    public Integer getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Integer codMaterial) {
        this.codMaterial = codMaterial;
    }

    public Integer getCodDificultad() {
        return codDificultad;
    }

    public void setCodDificultad(Integer codDificultad) {
        this.codDificultad = codDificultad;
    }

    public Integer getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(Integer codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
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
        return "Ejercicio{" + "codEjercicio=" + codEjercicio + ", descripcion=" + descripcion + ", codPasatiempo=" + codPasatiempo + ", codGenero=" + codGenero + ", codCategoria=" + codCategoria + ", codMaterial=" + codMaterial + ", codDificultad=" + codDificultad + ", codTipoCliente=" + codTipoCliente + ", pasatiempo=" + pasatiempo + ", genero=" + genero + ", categoria=" + categoria + ", material=" + material + ", dificultad=" + dificultad + ", tipoCliente=" + tipoCliente + '}';
    }
    
}
