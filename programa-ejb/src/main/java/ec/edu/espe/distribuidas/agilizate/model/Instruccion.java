/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import java.io.Serializable;
import java.util.Objects;
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
    private Integer codigo;
    
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

    public Instruccion(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Instruccion other = (Instruccion) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Instruccion{" + "codigo=" + codigo + ", recurso=" + recurso + ", tipoInstruccion=" + tipoInstruccion + ", ejercicio=" + ejercicio + '}';
    }
       
}
