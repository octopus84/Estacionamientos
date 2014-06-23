/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.to;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario_pc
 */
@Entity
@Table(name = "estacionamientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estacionamientos.findAll", query = "SELECT e FROM Estacionamientos e"),
    @NamedQuery(name = "Estacionamientos.findById", query = "SELECT e FROM Estacionamientos e WHERE e.estacionamientosPK.id = :id"),
    @NamedQuery(name = "Estacionamientos.findByPisosId", query = "SELECT e FROM Estacionamientos e WHERE e.estacionamientosPK.pisosId = :pisosId"),
    @NamedQuery(name = "Estacionamientos.findByPisosEdificioId", query = "SELECT e FROM Estacionamientos e WHERE e.estacionamientosPK.pisosEdificioId = :pisosEdificioId"),
    @NamedQuery(name = "Estacionamientos.findByNumero", query = "SELECT e FROM Estacionamientos e WHERE e.numero = :numero"),
    @NamedQuery(name = "Estacionamientos.findByEstado", query = "SELECT e FROM Estacionamientos e WHERE e.estado = :estado")})
public class Estacionamientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstacionamientosPK estacionamientosPK;
    @Column(name = "numero")
    private Long numero;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumns({
        @JoinColumn(name = "pisos_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "pisos_edificio_id", referencedColumnName = "edificio_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pisos pisos;

    public Estacionamientos() {
    }

    public Estacionamientos(EstacionamientosPK estacionamientosPK) {
        this.estacionamientosPK = estacionamientosPK;
    }

    public Estacionamientos(int id, int pisosId, int pisosEdificioId) {
        this.estacionamientosPK = new EstacionamientosPK(id, pisosId, pisosEdificioId);
    }

    public EstacionamientosPK getEstacionamientosPK() {
        return estacionamientosPK;
    }

    public void setEstacionamientosPK(EstacionamientosPK estacionamientosPK) {
        this.estacionamientosPK = estacionamientosPK;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Pisos getPisos() {
        return pisos;
    }

    public void setPisos(Pisos pisos) {
        this.pisos = pisos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estacionamientosPK != null ? estacionamientosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacionamientos)) {
            return false;
        }
        Estacionamientos other = (Estacionamientos) object;
        if ((this.estacionamientosPK == null && other.estacionamientosPK != null) || (this.estacionamientosPK != null && !this.estacionamientosPK.equals(other.estacionamientosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.Estacionamientos[ estacionamientosPK=" + estacionamientosPK + " ]";
    }
    
}
