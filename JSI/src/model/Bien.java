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
@Table(name = "bien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bien.findAll", query = "SELECT b FROM Bien b")
    , @NamedQuery(name = "Bien.findById", query = "SELECT b FROM Bien b WHERE b.id = :id")
    , @NamedQuery(name = "Bien.findByCode", query = "SELECT b FROM Bien b WHERE b.code = :code")
    , @NamedQuery(name = "Bien.findByLoyer", query = "SELECT b FROM Bien b WHERE b.loyer = :loyer")
    , @NamedQuery(name = "Bien.findByNombrepeice", query = "SELECT b FROM Bien b WHERE b.nombrepeice = :nombrepeice")
    , @NamedQuery(name = "Bien.findByPhoto", query = "SELECT b FROM Bien b WHERE b.photo = :photo")
    , @NamedQuery(name = "Bien.findBySuperficie", query = "SELECT b FROM Bien b WHERE b.superficie = :superficie")
    , @NamedQuery(name = "Bien.findByEtat", query = "SELECT b FROM Bien b WHERE b.etat = :etat")})
public class Bien implements Serializable {

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
    @Column(name = "loyer")
    private int loyer;
    @Basic(optional = false)
    @Column(name = "nombrepeice")
    private int nombrepeice;
    @Basic(optional = false)
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @Column(name = "superficie")
    private int superficie;
    @Basic(optional = false)
    @Column(name = "etat")
    private String etat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbien")
    private List<Loyer> loyerList;
    @JoinColumn(name = "idtype", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Typebien idtype;
    @JoinColumn(name = "idproprio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proprietaire idproprio;

    public Bien() {
    }

    public Bien(Integer id) {
        this.id = id;
    }

    public Bien(Integer id, String code, int loyer, int nombrepeice, String photo, int superficie, String etat) {
        this.id = id;
        this.code = code;
        this.loyer = loyer;
        this.nombrepeice = nombrepeice;
        this.photo = photo;
        this.superficie = superficie;
        this.etat = etat;
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

    public int getLoyer() {
        return loyer;
    }

    public void setLoyer(int loyer) {
        this.loyer = loyer;
    }

    public int getNombrepeice() {
        return nombrepeice;
    }

    public void setNombrepeice(int nombrepeice) {
        this.nombrepeice = nombrepeice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<Loyer> getLoyerList() {
        return loyerList;
    }

    public void setLoyerList(List<Loyer> loyerList) {
        this.loyerList = loyerList;
    }

    public Typebien getIdtype() {
        return idtype;
    }

    public void setIdtype(Typebien idtype) {
        this.idtype = idtype;
    }

    public Proprietaire getIdproprio() {
        return idproprio;
    }

    public void setIdproprio(Proprietaire idproprio) {
        this.idproprio = idproprio;
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
        if (!(object instanceof Bien)) {
            return false;
        }
        Bien other = (Bien) object;
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
