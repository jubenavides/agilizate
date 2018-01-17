/*
 * Agillizate
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2018 (c) Arcentales-Benavides.SA.
 */
package ec.edu.espe.distribuidas.agilizate.model;

import ec.edu.espe.distribuidas.agilizate.enums.CodGeneroEnum;
import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_CLIENTE", nullable = false)
    private Integer codigo;

    @Column(name = "COD_TIPO_CLIENTE", nullable = false)
    private Integer codTipoCliente;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "COD_GENERO", nullable = false, length = 1)
    private CodGeneroEnum codGenero;
    
    @Column(name = "COD_PASATIEMPO", nullable = false)
    private Integer codPasatiempo;
    
    
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "APELLIDO", nullable = false, length = 100)
    private String apellido;
    
    @Column(name = "EDAD", nullable = false)
    private short edad;
    
    @Column(name = "CORREO", length = 100)
    private String correo;

    @JoinColumn(name = "COD_TIPO_CLIENTE", referencedColumnName = "COD_TIPO_CLIENTE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoCliente tipoCliente;
    
    @JoinColumn(name = "COD_GENERO", referencedColumnName = "COD_GENERO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Genero genero;
    
    @JoinColumn(name = "COD_PASATIEMPO", referencedColumnName = "COD_PASATIEMPO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pasatiempo pasatiempo;

    public Cliente() {
    }

    public Cliente(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Pasatiempo getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(Pasatiempo pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public Integer getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(Integer codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public CodGeneroEnum getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(CodGeneroEnum codGenero) {
        this.codGenero = codGenero;
    }

    public Integer getCodPasatiempo() {
        return codPasatiempo;
    }

    public void setCodPasatiempo(Integer codPasatiempo) {
        this.codPasatiempo = codPasatiempo;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.codigo);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", codTipoCliente=" + codTipoCliente + ", codGenero=" + codGenero + ", codPasatiempo=" + codPasatiempo + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", correo=" + correo + ", tipoCliente=" + tipoCliente + ", genero=" + genero + ", pasatiempo=" + pasatiempo + '}';
    }


}
