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
@Table(name = "tipo_instruccion")
@NamedQueries({
    @NamedQuery(name = "TipoInstruccion.findAll", query = "SELECT t FROM TipoInstruccion t")})
public class TipoInstruccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_TIP_INSTRUCCION")
    private String codTipInstruccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public TipoInstruccion() {
    }

    public TipoInstruccion(String codTipInstruccion) {
        this.codTipInstruccion = codTipInstruccion;
    }

    public TipoInstruccion(String codTipInstruccion, String descripcion) {
        this.codTipInstruccion = codTipInstruccion;
        this.descripcion = descripcion;
    }

    public String getCodTipInstruccion() {
        return codTipInstruccion;
    }

    public void setCodTipInstruccion(String codTipInstruccion) {
        this.codTipInstruccion = codTipInstruccion;
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
        hash += (codTipInstruccion != null ? codTipInstruccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInstruccion)) {
            return false;
        }
        TipoInstruccion other = (TipoInstruccion) object;
        if ((this.codTipInstruccion == null && other.codTipInstruccion != null) || (this.codTipInstruccion != null && !this.codTipInstruccion.equals(other.codTipInstruccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.distribuidas.agilizate.model.TipoInstruccion[ codTipInstruccion=" + codTipInstruccion + " ]";
    }
    
}
