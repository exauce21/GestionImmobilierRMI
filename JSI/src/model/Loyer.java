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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "loyer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loyer.findAll", query = "SELECT l FROM Loyer l")
    , @NamedQuery(name = "Loyer.findById", query = "SELECT l FROM Loyer l WHERE l.id = :id")
    , @NamedQuery(name = "Loyer.findByCode", query = "SELECT l FROM Loyer l WHERE l.code = :code")
    , @NamedQuery(name = "Loyer.findByDateentree", query = "SELECT l FROM Loyer l WHERE l.dateentree = :dateentree")
    , @NamedQuery(name = "Loyer.findByCaution", query = "SELECT l FROM Loyer l WHERE l.caution = :caution")})
public class Loyer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "dateentree")
    private String dateentree;
    @Basic(optional = false)
    @Column(name = "caution")
    private int caution;
    @JoinColumn(name = "idclient", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client idclient;
    @JoinColumn(name = "idbien", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bien idbien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idloyer")
    private List<Facture> factureList;

    public Loyer() {
    }

    public Loyer(Integer id) {
        this.id = id;
    }

    public Loyer(Integer id, String code, String dateentree, int caution) {
        this.id = id;
        this.code = code;
        this.dateentree = dateentree;
        this.caution = caution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDateentree() {
        return dateentree;
    }

    public void setDateentree(String dateentree) {
        this.dateentree = dateentree;
    }

    public int getCaution() {
        return caution;
    }

    public void setCaution(int caution) {
        this.caution = caution;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Bien getIdbien() {
        return idbien;
    }

    public void setIdbien(Bien idbien) {
        this.idbien = idbien;
    }

    @XmlTransient
    public List<Facture> getFactureList() {
        return factureList;
    }

    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
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
        if (!(object instanceof Loyer)) {
            return false;
        }
        Loyer other = (Loyer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code;
    }
    
}
