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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "seguimiento")
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_SEGUIMIENTO", nullable = false)
    private Integer codigo;
    
    @Column(name = "COD_PROGRAMA", nullable=false)
    private int codPrograma;

    @Column(name = "COD_CLIENTE", nullable=false)
    private int codCliente;
    
    @Column(name = "AVANCE", nullable = false)
    private Integer avance;
    
    @Column(name = "CALIFICACION_APLICACION", nullable = false)
    private Integer calificacionAplicacion;
    
    @Column(name = "TOTAL_DURACION")
    private Integer totalDuracion;

    @JoinColumns({
        @JoinColumn(name="COD_PROGRAMA",referencedColumnName="COD_PROGRAMA",nullable=false,insertable=false,updatable=false),
        @JoinColumn(name="COD_CLIENTE",referencedColumnName="COD_CLIENTE",nullable=false,insertable=false,updatable=false)})
    @ManyToOne
    private ProgramaCliente programaCliente;
    
    public Seguimiento() {
    }

    public Seguimiento(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getAvance() {
        return avance;
    }

    public void setAvance(Integer avance) {
        this.avance = avance;
    }

    public Integer getCalificacionAplicacion() {
        return calificacionAplicacion;
    }

    public void setCalificacionAplicacion(Integer calificacionAplicacion) {
        this.calificacionAplicacion = calificacionAplicacion;
    }

    public Integer getTotalDuracion() {
        return totalDuracion;
    }

    public void setTotalDuracion(Integer totalDuracion) {
        this.totalDuracion = totalDuracion;
    }
    
    public ProgramaCliente getProgramaCliente() {
        return programaCliente;
    }

    public void setProgramaCliente(ProgramaCliente programaCliente) {
        this.programaCliente = programaCliente;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
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
        final Seguimiento other = (Seguimiento) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    public int getCodPrograma() {
        return codPrograma;
    }

    public void setCodPrograma(int codPrograma) {
        this.codPrograma = codPrograma;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public String toString() {
        return "Seguimiento{" + "codigo=" + codigo + ", codPrograma=" + codPrograma + ", codCliente=" + codCliente + ", avance=" + avance + ", calificacionAplicacion=" + calificacionAplicacion + ", totalDuracion=" + totalDuracion + ", programaCliente=" + programaCliente + '}';
    }

}
