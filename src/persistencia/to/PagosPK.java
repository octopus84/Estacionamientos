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
public class PagosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "bitacora_estacionamiento_id")
    private int bitacoraEstacionamientoId;

    public PagosPK() {
    }

    public PagosPK(int id, int bitacoraEstacionamientoId) {
        this.id = id;
        this.bitacoraEstacionamientoId = bitacoraEstacionamientoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBitacoraEstacionamientoId() {
        return bitacoraEstacionamientoId;
    }

    public void setBitacoraEstacionamientoId(int bitacoraEstacionamientoId) {
        this.bitacoraEstacionamientoId = bitacoraEstacionamientoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) bitacoraEstacionamientoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagosPK)) {
            return false;
        }
        PagosPK other = (PagosPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.bitacoraEstacionamientoId != other.bitacoraEstacionamientoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.PagosPK[ id=" + id + ", bitacoraEstacionamientoId=" + bitacoraEstacionamientoId + " ]";
    }
    
}
