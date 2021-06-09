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
@Table(name = "proprietaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proprietaire.findAll", query = "SELECT p FROM Proprietaire p")
    , @NamedQuery(name = "Proprietaire.findById", query = "SELECT p FROM Proprietaire p WHERE p.id = :id")
    , @NamedQuery(name = "Proprietaire.findByNom", query = "SELECT p FROM Proprietaire p WHERE p.nom = :nom")
    , @NamedQuery(name = "Proprietaire.findByAdresse", query = "SELECT p FROM Proprietaire p WHERE p.adresse = :adresse")
    , @NamedQuery(name = "Proprietaire.findByTel", query = "SELECT p FROM Proprietaire p WHERE p.tel = :tel")
    , @NamedQuery(name = "Proprietaire.findByEmail", query = "SELECT p FROM Proprietaire p WHERE p.email = :email")
    , @NamedQuery(name = "Proprietaire.findByPaiement", query = "SELECT p FROM Proprietaire p WHERE p.paiement = :paiement")
    , @NamedQuery(name = "Proprietaire.findByMoyen", query = "SELECT p FROM Proprietaire p WHERE p.moyen = :moyen")
    , @NamedQuery(name = "Proprietaire.findByType", query = "SELECT p FROM Proprietaire p WHERE p.type = :type")})
public class Proprietaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @Column(name = "tel")
    private int tel;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "paiement")
    private int paiement;
    @Basic(optional = false)
    @Column(name = "moyen")
    private String moyen;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproprio")
    private List<Bien> bienList;

    public Proprietaire() {
    }

    public Proprietaire(Integer id) {
        this.id = id;
    }

    public Proprietaire(Integer id, String nom, String adresse, int tel, String email, int paiement, String moyen, String type) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
        this.paiement = paiement;
        this.moyen = moyen;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPaiement() {
        return paiement;
    }

    public void setPaiement(int paiement) {
        this.paiement = paiement;
    }

    public String getMoyen() {
        return moyen;
    }

    public void setMoyen(String moyen) {
        this.moyen = moyen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Proprietaire)) {
            return false;
        }
        Proprietaire other = (Proprietaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
