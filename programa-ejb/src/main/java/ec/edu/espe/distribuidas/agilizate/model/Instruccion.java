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
@Table(name = "instruccion")
@NamedQueries({
    @NamedQuery(name = "Instruccion.findAll", query = "SELECT i FROM Instruccion i")})
public class Instruccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_INSTRUCCION")
    private Integer codInstruccion;
    @Size(max = 3)
    @Column(name = "COD_TIP_INSTRUCCION")
    private String codTipInstruccion;
    @Column(name = "COD_EJERCICIO")
    private Integer codEjercicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RECURSO")
    private String recurso;

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

    public String getCodTipInstruccion() {
        return codTipInstruccion;
    }

    public void setCodTipInstruccion(String codTipInstruccion) {
        this.codTipInstruccion = codTipInstruccion;
    }

    public Integer getCodEjercicio() {
        return codEjercicio;
    }

    public void setCodEjercicio(Integer codEjercicio) {
        this.codEjercicio = codEjercicio;
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
        return "ec.edu.espe.distribuidas.agilizate.model.Instruccion[ codInstruccion=" + codInstruccion + " ]";
    }
    
}
