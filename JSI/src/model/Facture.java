/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author berose
 */
@Entity
@Table(name = "facture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f")
    , @NamedQuery(name = "Facture.findById", query = "SELECT f FROM Facture f WHERE f.id = :id")
    , @NamedQuery(name = "Facture.findByNumf", query = "SELECT f FROM Facture f WHERE f.numf = :numf")
    , @NamedQuery(name = "Facture.findByAvance", query = "SELECT f FROM Facture f WHERE f.avance = :avance")
    , @NamedQuery(name = "Facture.findByArrierees", query = "SELECT f FROM Facture f WHERE f.arrierees = :arrierees")
    , @NamedQuery(name = "Facture.findByRestant", query = "SELECT f FROM Facture f WHERE f.restant = :restant")
    , @NamedQuery(name = "Facture.findByDatef", query = "SELECT f FROM Facture f WHERE f.datef = :datef")
    , @NamedQuery(name = "Facture.findByTotal", query = "SELECT f FROM Facture f WHERE f.total = :total")})
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numf")
    private String numf;
    @Basic(optional = false)
    @Column(name = "avance")
    private int avance;
    @Basic(optional = false)
    @Column(name = "arrierees")
    private int arrierees;
    @Basic(optional = false)
    @Column(name = "restant")
    private int restant;
    @Basic(optional = false)
    @Column(name = "datef")
    private String datef;
    @Basic(optional = false)
    @Column(name = "total")
    private int total;
    @JoinColumn(name = "idloyer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Loyer idloyer;

    public Facture() {
    }

    public Facture(Integer id) {
        this.id = id;
    }

    public Facture(Integer id, String numf, int avance, int arrierees, int restant, String datef, int total) {
        this.id = id;
        this.numf = numf;
        this.avance = avance;
        this.arrierees = arrierees;
        this.restant = restant;
        this.datef = datef;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumf() {
        return numf;
    }

    public void setNumf(String numf) {
        this.numf = numf;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }

    public int getArrierees() {
        return arrierees;
    }

    public void setArrierees(int arrierees) {
        this.arrierees = arrierees;
    }

    public int getRestant() {
        return restant;
    }

    public void setRestant(int restant) {
        this.restant = restant;
    }

    public String getDatef() {
        return datef;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Loyer getIdloyer() {
        return idloyer;
    }

    public void setIdloyer(Loyer idloyer) {
        this.idloyer = idloyer;
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
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numf;
    }
    
}
