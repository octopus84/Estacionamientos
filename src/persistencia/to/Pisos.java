/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.to;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario_pc
 */
@Entity
@Table(name = "pisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pisos.findAll", query = "SELECT p FROM Pisos p"),
    @NamedQuery(name = "Pisos.findByEdificioId", query = "SELECT p FROM Pisos p WHERE p.pisosPK.edificioId = :edificioId"),
    @NamedQuery(name = "Pisos.findById", query = "SELECT p FROM Pisos p WHERE p.pisosPK.id = :id"),
    @NamedQuery(name = "Pisos.findByPiso", query = "SELECT p FROM Pisos p WHERE p.piso = :piso"),
    @NamedQuery(name = "Pisos.findByEstacionamientos", query = "SELECT p FROM Pisos p WHERE p.estacionamientos = :estacionamientos"),
    @NamedQuery(name = "Pisos.findByDescripcion", query = "SELECT p FROM Pisos p WHERE p.descripcion = :descripcion")})
public class Pisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PisosPK pisosPK;
    @Basic(optional = false)
    @Column(name = "piso")
    private long piso;
    @Column(name = "estacionamientos")
    private Long estacionamientos;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "edificio_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Edificio edificio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pisos")
    private Collection<Estacionamientos> estacionamientosCollection;

    public Pisos() {
    }

    public Pisos(PisosPK pisosPK) {
        this.pisosPK = pisosPK;
    }

    public Pisos(PisosPK pisosPK, long piso) {
        this.pisosPK = pisosPK;
        this.piso = piso;
    }

    public Pisos(int edificioId, int id) {
        this.pisosPK = new PisosPK(edificioId, id);
    }

    public PisosPK getPisosPK() {
        return pisosPK;
    }

    public void setPisosPK(PisosPK pisosPK) {
        this.pisosPK = pisosPK;
    }

    public long getPiso() {
        return piso;
    }

    public void setPiso(long piso) {
        this.piso = piso;
    }

    public Long getEstacionamientos() {
        return estacionamientos;
    }

    public void setEstacionamientos(Long estacionamientos) {
        this.estacionamientos = estacionamientos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @XmlTransient
    public Collection<Estacionamientos> getEstacionamientosCollection() {
        return estacionamientosCollection;
    }

    public void setEstacionamientosCollection(Collection<Estacionamientos> estacionamientosCollection) {
        this.estacionamientosCollection = estacionamientosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pisosPK != null ? pisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pisos)) {
            return false;
        }
        Pisos other = (Pisos) object;
        if ((this.pisosPK == null && other.pisosPK != null) || (this.pisosPK != null && !this.pisosPK.equals(other.pisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.Pisos[ pisosPK=" + pisosPK + " ]";
    }
    
}
