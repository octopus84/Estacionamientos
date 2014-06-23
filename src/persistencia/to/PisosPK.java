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
public class PisosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "edificio_id")
    private int edificioId;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;

    public PisosPK() {
    }

    public PisosPK(int edificioId, int id) {
        this.edificioId = edificioId;
        this.id = id;
    }

    public int getEdificioId() {
        return edificioId;
    }

    public void setEdificioId(int edificioId) {
        this.edificioId = edificioId;
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
        hash += (int) edificioId;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PisosPK)) {
            return false;
        }
        PisosPK other = (PisosPK) object;
        if (this.edificioId != other.edificioId) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.PisosPK[ edificioId=" + edificioId + ", id=" + id + " ]";
    }
    
}
