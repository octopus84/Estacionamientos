/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.to;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario_pc
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v"),
    @NamedQuery(name = "Vehiculos.findByPlacaPatente", query = "SELECT v FROM Vehiculos v WHERE v.placaPatente = :placaPatente"),
    @NamedQuery(name = "Vehiculos.findByFechaRegistro", query = "SELECT v FROM Vehiculos v WHERE v.fechaRegistro = :fechaRegistro")})
public class Vehiculos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placa_patente")
    private String placaPatente;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumns({
        @JoinColumn(name = "modelo_marca_marca_vehiculo_id", referencedColumnName = "marca_vehiculo_id"),
        @JoinColumn(name = "modelo_marca_id", referencedColumnName = "id")})
    @ManyToOne(optional = false)
    private ModeloMarca modeloMarca;
    @JoinColumn(name = "cliente_rut", referencedColumnName = "rut")
    @ManyToOne(optional = false)
    private Cliente clienteRut;

    public Vehiculos() {
    }

    public Vehiculos(String placaPatente) {
        this.placaPatente = placaPatente;
    }

    public String getPlacaPatente() {
        return placaPatente;
    }

    public void setPlacaPatente(String placaPatente) {
        this.placaPatente = placaPatente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public ModeloMarca getModeloMarca() {
        return modeloMarca;
    }

    public void setModeloMarca(ModeloMarca modeloMarca) {
        this.modeloMarca = modeloMarca;
    }

    public Cliente getClienteRut() {
        return clienteRut;
    }

    public void setClienteRut(Cliente clienteRut) {
        this.clienteRut = clienteRut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placaPatente != null ? placaPatente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.placaPatente == null && other.placaPatente != null) || (this.placaPatente != null && !this.placaPatente.equals(other.placaPatente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.Vehiculos[ placaPatente=" + placaPatente + " ]";
    }
    
}
