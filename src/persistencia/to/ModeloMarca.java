/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.to;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario_pc
 */
@Entity
@Table(name = "modelo_marca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeloMarca.findAll", query = "SELECT m FROM ModeloMarca m"),
    @NamedQuery(name = "ModeloMarca.findByMarcaVehiculoId", query = "SELECT m FROM ModeloMarca m WHERE m.modeloMarcaPK.marcaVehiculoId = :marcaVehiculoId"),
    @NamedQuery(name = "ModeloMarca.findById", query = "SELECT m FROM ModeloMarca m WHERE m.modeloMarcaPK.id = :id"),
    @NamedQuery(name = "ModeloMarca.findByModelo", query = "SELECT m FROM ModeloMarca m WHERE m.modelo = :modelo")})
public class ModeloMarca implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModeloMarcaPK modeloMarcaPK;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @JoinColumn(name = "marca_vehiculo_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MarcaVehiculo marcaVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloMarca")
    private Collection<Vehiculos> vehiculosCollection;

    public ModeloMarca() {
    }

    public ModeloMarca(ModeloMarcaPK modeloMarcaPK) {
        this.modeloMarcaPK = modeloMarcaPK;
    }

    public ModeloMarca(ModeloMarcaPK modeloMarcaPK, String modelo) {
        this.modeloMarcaPK = modeloMarcaPK;
        this.modelo = modelo;
    }

    public ModeloMarca(int marcaVehiculoId, int id) {
        this.modeloMarcaPK = new ModeloMarcaPK(marcaVehiculoId, id);
    }

    public ModeloMarcaPK getModeloMarcaPK() {
        return modeloMarcaPK;
    }

    public void setModeloMarcaPK(ModeloMarcaPK modeloMarcaPK) {
        this.modeloMarcaPK = modeloMarcaPK;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }

    public MarcaVehiculo getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(MarcaVehiculo marcaVehiculo) {
        MarcaVehiculo oldMarcaVehiculo = this.marcaVehiculo;
        this.marcaVehiculo = marcaVehiculo;
        changeSupport.firePropertyChange("marcaVehiculo", oldMarcaVehiculo, marcaVehiculo);
    }

    @XmlTransient
    public Collection<Vehiculos> getVehiculosCollection() {
        return vehiculosCollection;
    }

    public void setVehiculosCollection(Collection<Vehiculos> vehiculosCollection) {
        this.vehiculosCollection = vehiculosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modeloMarcaPK != null ? modeloMarcaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloMarca)) {
            return false;
        }
        ModeloMarca other = (ModeloMarca) object;
        if ((this.modeloMarcaPK == null && other.modeloMarcaPK != null) || (this.modeloMarcaPK != null && !this.modeloMarcaPK.equals(other.modeloMarcaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.ModeloMarca[ modeloMarcaPK=" + modeloMarcaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
