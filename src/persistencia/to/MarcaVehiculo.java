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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "marca_vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarcaVehiculo.findAll", query = "SELECT m FROM MarcaVehiculo m"),
    @NamedQuery(name = "MarcaVehiculo.findById", query = "SELECT m FROM MarcaVehiculo m WHERE m.id = :id"),
    @NamedQuery(name = "MarcaVehiculo.findByMarca", query = "SELECT m FROM MarcaVehiculo m WHERE m.marca = :marca")})
public class MarcaVehiculo implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcaVehiculo")
    private Collection<ModeloMarca> modeloMarcaCollection;

    public MarcaVehiculo() {
    }

    public MarcaVehiculo(Integer id) {
        this.id = id;
    }

    public MarcaVehiculo(Integer id, String marca) {
        this.id = id;
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
    }

    @XmlTransient
    public Collection<ModeloMarca> getModeloMarcaCollection() {
        return modeloMarcaCollection;
    }

    public void setModeloMarcaCollection(Collection<ModeloMarca> modeloMarcaCollection) {
        this.modeloMarcaCollection = modeloMarcaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcaVehiculo)) {
            return false;
        }
        MarcaVehiculo other = (MarcaVehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.MarcaVehiculo[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
