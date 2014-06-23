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
@Table(name = "controles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Controles.findAll", query = "SELECT c FROM Controles c"),
    @NamedQuery(name = "Controles.findById", query = "SELECT c FROM Controles c WHERE c.controlesPK.id = :id"),
    @NamedQuery(name = "Controles.findByEdificioId", query = "SELECT c FROM Controles c WHERE c.controlesPK.edificioId = :edificioId"),
    @NamedQuery(name = "Controles.findByControl", query = "SELECT c FROM Controles c WHERE c.control = :control"),
    @NamedQuery(name = "Controles.findByTipo", query = "SELECT c FROM Controles c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Controles.findByDescripcion", query = "SELECT c FROM Controles c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Controles.findByEstado", query = "SELECT c FROM Controles c WHERE c.estado = :estado")})
public class Controles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ControlesPK controlesPK;
    @Column(name = "control")
    private Long control;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "edificio_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Edificio edificio;

    public Controles() {
    }

    public Controles(ControlesPK controlesPK) {
        this.controlesPK = controlesPK;
    }

    public Controles(int id, int edificioId) {
        this.controlesPK = new ControlesPK(id, edificioId);
    }

    public ControlesPK getControlesPK() {
        return controlesPK;
    }

    public void setControlesPK(ControlesPK controlesPK) {
        this.controlesPK = controlesPK;
    }

    public Long getControl() {
        return control;
    }

    public void setControl(Long control) {
        this.control = control;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (controlesPK != null ? controlesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Controles)) {
            return false;
        }
        Controles other = (Controles) object;
        if ((this.controlesPK == null && other.controlesPK != null) || (this.controlesPK != null && !this.controlesPK.equals(other.controlesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.Controles[ controlesPK=" + controlesPK + " ]";
    }
    
}
