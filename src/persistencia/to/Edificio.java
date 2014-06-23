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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "edificio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edificio.findAll", query = "SELECT e FROM Edificio e"),
    @NamedQuery(name = "Edificio.findById", query = "SELECT e FROM Edificio e WHERE e.id = :id"),
    @NamedQuery(name = "Edificio.findByNombre", query = "SELECT e FROM Edificio e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Edificio.findByPisos1", query = "SELECT e FROM Edificio e WHERE e.pisos1 = :pisos1"),
    @NamedQuery(name = "Edificio.findByDescripcion", query = "SELECT e FROM Edificio e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Edificio.findByControles", query = "SELECT e FROM Edificio e WHERE e.controles = :controles")})
public class Edificio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pisos")
    private Long pisos1;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "controles")
    private Long controles;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "edificio")
    private Pisos pisos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "edificio")
    private Collection<Controles> controlesCollection;

    public Edificio() {
    }

    public Edificio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPisos1() {
        return pisos1;
    }

    public void setPisos1(Long pisos1) {
        this.pisos1 = pisos1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getControles() {
        return controles;
    }

    public void setControles(Long controles) {
        this.controles = controles;
    }

    public Pisos getPisos() {
        return pisos;
    }

    public void setPisos(Pisos pisos) {
        this.pisos = pisos;
    }

    @XmlTransient
    public Collection<Controles> getControlesCollection() {
        return controlesCollection;
    }

    public void setControlesCollection(Collection<Controles> controlesCollection) {
        this.controlesCollection = controlesCollection;
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
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.to.Edificio[ id=" + id + " ]";
    }
    
}
