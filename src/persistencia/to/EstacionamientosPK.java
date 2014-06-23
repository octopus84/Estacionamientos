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
public class EstacionamientosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "pisos_id")
    private int pisosId;
    @Basic(optional = false)
    @Column(name = "pisos_edificio_id")
    private int pisosEdificioId;

    public EstacionamientosPK() {
    }

    public EstacionamientosPK(int id, int pisosId, int pisosEdificioId) {
        this.id = id;
        this.pisosId = pisosId;
        this.pisosEdificioId = pisosEdificioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPisosId() {
        return pisosId;
    }

    public void setPisosId(int pisosId) {
        this.pisosId = pisosId;
    }

    public int getPisosEdificioId() {
        return pisosEdificioId;
    }

    public void setPisosEdificioId(int pisosEdificioId) {
        this.pisosEdificioId = pisosEdificioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) pisosId;
        hash += (int) pisosEdificioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstacionamientosPK)) {
            return false;
        }
        EstacionamientosPK other = (EstacionamientosPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.pisosId != other.pisosId) {
            return false;
        }
        if (this.pisosEdificioId != other.pisosEdificioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.EstacionamientosPK[ id=" + id + ", pisosId=" + pisosId + ", pisosEdificioId=" + pisosEdificioId + " ]";
    }
    
}
