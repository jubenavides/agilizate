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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "instruccion")
public class Instruccion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_INSTRUCCION", nullable = false)
    private Integer codInstruccion;
    
    @Column(name = "RECURSO", nullable = false, length = 200)
    private String recurso;

    @JoinColumn(name = "COD_TIPO_INSTRUCCION", referencedColumnName = "COD_TIPO_INSTRUCCION", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoInstruccion tipoInstruccion;
    
    @JoinColumn(name = "COD_EJERCICIO", referencedColumnName = "COD_EJERCICIO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ejercicio ejercicio;
    
    public Instruccion() {
    }

    public Instruccion(Integer codInstruccion) {
        this.codInstruccion = codInstruccion;
    }

    public Instruccion(Integer codInstruccion, String recurso) {
        this.codInstruccion = codInstruccion;
        this.recurso = recurso;
    }

    public Integer getCodInstruccion() {
        return codInstruccion;
    }

    public void setCodInstruccion(Integer codInstruccion) {
        this.codInstruccion = codInstruccion;
    }

    public TipoInstruccion getTipoInstruccion() {
        return tipoInstruccion;
    }

    public void setTipoInstruccion(TipoInstruccion tipoInstruccion) {
        this.tipoInstruccion = tipoInstruccion;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInstruccion != null ? codInstruccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instruccion)) {
            return false;
        }
        Instruccion other = (Instruccion) object;
        if ((this.codInstruccion == null && other.codInstruccion != null) || (this.codInstruccion != null && !this.codInstruccion.equals(other.codInstruccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Instruccion{" + "codInstruccion=" + codInstruccion + ", recurso=" + recurso + ", tipoInstruccion=" + tipoInstruccion + ", ejercicio=" + ejercicio + '}';
    }

}
