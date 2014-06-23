/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.to;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author usuario_pc
 */
@Embeddable
public class ModeloMarcaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "marca_vehiculo_id")
    private int marcaVehiculoId;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public ModeloMarcaPK() {
    }

    public ModeloMarcaPK(int marcaVehiculoId, int id) {
        this.marcaVehiculoId = marcaVehiculoId;
        this.id = id;
    }

    public int getMarcaVehiculoId() {
        return marcaVehiculoId;
    }

    public void setMarcaVehiculoId(int marcaVehiculoId) {
        this.marcaVehiculoId = marcaVehiculoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) marcaVehiculoId;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloMarcaPK)) {
            return false;
        }
        ModeloMarcaPK other = (ModeloMarcaPK) object;
        if (this.marcaVehiculoId != other.marcaVehiculoId) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.ModeloMarcaPK[ marcaVehiculoId=" + marcaVehiculoId + ", id=" + id + " ]";
    }
    
}
