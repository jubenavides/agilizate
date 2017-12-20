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
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "COD_CLIENTE", nullable = false)
    private Integer codCliente;

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

    public Cliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Cliente(Integer codCliente, String nombre, String apellido, short edad) {
        this.codCliente = codCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCliente != null ? codCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCliente == null && other.codCliente != null) || (this.codCliente != null && !this.codCliente.equals(other.codCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", correo=" + correo + ", tipoCliente=" + tipoCliente + ", genero=" + genero + ", pasatiempo=" + pasatiempo + '}';
    }

}
