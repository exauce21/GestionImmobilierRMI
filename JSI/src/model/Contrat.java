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
@Table(name = "contrat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrat.findAll", query = "SELECT c FROM Contrat c")
    , @NamedQuery(name = "Contrat.findById", query = "SELECT c FROM Contrat c WHERE c.id = :id")
    , @NamedQuery(name = "Contrat.findByDatecreation", query = "SELECT c FROM Contrat c WHERE c.datecreation = :datecreation")
    , @NamedQuery(name = "Contrat.findByDaternvllmnt", query = "SELECT c FROM Contrat c WHERE c.daternvllmnt = :daternvllmnt")
    , @NamedQuery(name = "Contrat.findByMontantDE", query = "SELECT c FROM Contrat c WHERE c.montantDE = :montantDE")})
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "datecreation")
    private String datecreation;
    @Basic(optional = false)
    @Column(name = "daternvllmnt")
    private String daternvllmnt;
    @Basic(optional = false)
    @Column(name = "montantDE")
    private int montantDE;
    @JoinColumn(name = "idclient", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client idclient;

    public Contrat() {
    }

    public Contrat(Integer id) {
        this.id = id;
    }

    public Contrat(Integer id, String datecreation, String daternvllmnt, int montantDE) {
        this.id = id;
        this.datecreation = datecreation;
        this.daternvllmnt = daternvllmnt;
        this.montantDE = montantDE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    public String getDaternvllmnt() {
        return daternvllmnt;
    }

    public void setDaternvllmnt(String daternvllmnt) {
        this.daternvllmnt = daternvllmnt;
    }

    public int getMontantDE() {
        return montantDE;
    }

    public void setMontantDE(int montantDE) {
        this.montantDE = montantDE;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
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
        if (!(object instanceof Contrat)) {
            return false;
        }
        Contrat other = (Contrat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Contrat[ id=" + id + " ]";
    }
    
}
