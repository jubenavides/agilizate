/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import ec.edu.espe.distribuidas.agilizate.enums.CodTipoInstruccionEnum;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "tipo_instruccion")
public class TipoInstruccion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_TIP_INSTRUCCION", nullable = false, length = 3)
    private CodTipoInstruccionEnum codTipInstruccion;
    
    @Column(name = "DESCRIPCION", nullable = false, length = 200)
    private String descripcion;

    public TipoInstruccion() {
    }

    public TipoInstruccion(CodTipoInstruccionEnum codTipInstruccion) {
        this.codTipInstruccion = codTipInstruccion;
    }

    public CodTipoInstruccionEnum getCodTipInstruccion() {
        return codTipInstruccion;
    }

    public void setCodTipInstruccion(CodTipoInstruccionEnum codTipInstruccion) {
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
        return "TipoInstruccion{" + "codTipInstruccion=" + codTipInstruccion + ", descripcion=" + descripcion + '}';
    }

    
}
