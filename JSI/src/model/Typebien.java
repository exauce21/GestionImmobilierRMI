/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author berose
 */
@Entity
@Table(name = "typebien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typebien.findAll", query = "SELECT t FROM Typebien t")
    , @NamedQuery(name = "Typebien.findById", query = "SELECT t FROM Typebien t WHERE t.id = :id")
    , @NamedQuery(name = "Typebien.findByLibelle", query = "SELECT t FROM Typebien t WHERE t.libelle = :libelle")})
public class Typebien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtype")
    private List<Bien> bienList;

    public Typebien() {
    }

    public Typebien(Integer id) {
        this.id = id;
    }

    public Typebien(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Bien> getBienList() {
        return bienList;
    }

    public void setBienList(List<Bien> bienList) {
        this.bienList = bienList;
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
        if (!(object instanceof Typebien)) {
            return false;
        }
        Typebien other = (Typebien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
}
