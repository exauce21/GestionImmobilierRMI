/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Bien;
import model.Client;
import model.Contrat;
import model.Facture;
import model.Loyer;
import model.Proprietaire;
import model.Typebien;
import model.User;

/**
 *
 * @author berose
 */
public class ImmobilierImpl extends UnicastRemoteObject implements IImmobilier {
   EntityManagerFactory factory = Persistence.createEntityManagerFactory("JSIPU");
    EntityManager em;
    
    public EntityManager getEntityManager(){
      return factory.createEntityManager();
    }
    
    public ImmobilierImpl() throws RemoteException{
        
    }
    
    @Override
    public User findUser(String login) throws RemoteException {
        em = getEntityManager();
        
        try {         
            return em.createNamedQuery("User.findByLogin",User.class).setParameter("login", login).getSingleResult();
     
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }    
    }
    
    
     //--------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------
    
    @Override
    public void addClient(Client cl) throws RemoteException {
       em = getEntityManager();
       EntityTransaction tx = em.getTransaction();
       
        try {  
             tx.begin();
             em.persist(cl);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Client> findAllClient() throws RemoteException {
        em = getEntityManager();
        return em.createNamedQuery("Client.findAll",Client.class).getResultList();    
    }
    
    @Override
    public Client findClient(String nom) throws RemoteException {
        em = getEntityManager();
        try {
              return em.createNamedQuery("Client.findByNom",Client.class)
                    .setParameter("nom", nom).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateClient(Client cl) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteClient(int id) throws RemoteException {
        em = getEntityManager();  
        EntityTransaction tx = em.getTransaction();
        
        Client cl = em.find(Client.class, id);
       
        try {  
             tx.begin();
             em.remove(cl);
             tx.commit();
             return 1;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        return 0;
    }
    
    
     //--------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------

    @Override
    public void addBien(Bien b) throws RemoteException {
       em = getEntityManager();
       EntityTransaction tx = em.getTransaction();
       
        try {  
             tx.begin();
             em.persist(b);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Bien> findAllBien() throws RemoteException {
        em = getEntityManager();
        return em.createNamedQuery("Bien.findAll",Bien.class).getResultList(); 
    }

    @Override
    public Bien findBien(int id) throws RemoteException {
        em = getEntityManager();
        try {
              return em.createNamedQuery("Bien.findById",Bien.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateBien(Bien b) throws RemoteException {
        em = getEntityManager();
        
        Bien bn = findBien(b.getId());  
        bn.setEtat(b.getEtat());
        
        EntityTransaction tx = em.getTransaction(); 
       
        try {  
             tx.begin();
             em.merge(bn);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateBienData(Bien b) throws RemoteException{
        em = getEntityManager();
        
        Bien bn = findBien(b.getId());  
        bn.setEtat(b.getEtat());
        bn.setNombrepeice(b.getNombrepeice());
        bn.setIdtype(b.getIdtype());
        bn.setCode(b.getCode());
        bn.setIdproprio(b.getIdproprio());
        bn.setSuperficie(b.getSuperficie());
        bn.setLoyer(b.getLoyer());
        
        EntityTransaction tx = em.getTransaction(); 
       
        try {  
             tx.begin();
             em.merge(bn);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBien(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     //--------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------

    @Override
    public void addLoyer(Loyer l) throws RemoteException {
        em = getEntityManager();
       EntityTransaction tx = em.getTransaction();
       
        try {  
             tx.begin();
             em.persist(l);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Loyer> findAllLoyer() throws RemoteException {
         em = getEntityManager();
        return em.createNamedQuery("Loyer.findAll",Loyer.class).getResultList();
    }

    @Override
    public Loyer findLoyer(int id) throws RemoteException {
        em = getEntityManager();
        try {
              return em.createNamedQuery("Loyer.findById",Loyer.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateLoyer(Loyer l) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLoyer(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     //--------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------
    
    @Override
    public void addFacture(Facture f) throws RemoteException {
        em = getEntityManager();
       EntityTransaction tx = em.getTransaction();
       
        try {  
             tx.begin();
             em.persist(f);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Facture> findAllFacture() throws RemoteException {
         em = getEntityManager();
        return em.createNamedQuery("Facture.findAll",Facture.class).getResultList();
    }

    @Override
    public Facture findFacture(int id) throws RemoteException {
        em = getEntityManager();
        try {
              return em.createNamedQuery("Facture.findById",Facture.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
     public List<Facture> findFactureByClient(int id) throws RemoteException {
        em = getEntityManager();
        return em.createNamedQuery("Facture.findAll",Facture.class).getResultList();
    }

    @Override
    public void updateFacture(Facture f) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFacture(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     //--------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------

    @Override
    public void addContrat(Contrat c) throws RemoteException {
        em = getEntityManager();
       EntityTransaction tx = em.getTransaction();
       
        try {  
             tx.begin();
             em.persist(c);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Contrat> findAllContrat() throws RemoteException {
         em = getEntityManager();
        return em.createNamedQuery("Contrat.findAll",Contrat.class).getResultList();
    }

    @Override
    public Contrat findContrat(int id) throws RemoteException {
        em = getEntityManager();
        try {
              return em.createNamedQuery("Contrat.findById",Contrat.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateContrat(Contrat c) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //--------------------------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------

    @Override
    public List<Typebien> findAllTypebien() throws RemoteException {
        em = getEntityManager();
        return em.createNamedQuery("Typebien.findAll",Typebien.class).getResultList(); 
    }

    @Override
    public Typebien findTypebien(String nom) throws RemoteException {
        em = getEntityManager();
        try {
              return em.createNamedQuery("Typebien.findByLibelle",Typebien.class)
                    .setParameter("libelle", nom).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 

    @Override
    public void addProprietaire(Proprietaire p) throws RemoteException {
        em = getEntityManager();
       EntityTransaction tx = em.getTransaction();
       
        try {  
             tx.begin();
             em.persist(p);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }  
    }

    @Override
    public List<Proprietaire> findAllProprietaire() throws RemoteException {
        em = getEntityManager();
        return em.createNamedQuery("Proprietaire.findAll",Proprietaire.class).getResultList(); 
    }

    @Override
    public Proprietaire findProprietaire(int id) throws RemoteException {
         em = getEntityManager();
        try {
              return em.createNamedQuery("Proprietaire.findById",Proprietaire.class)
                    .setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateProprietaire(Proprietaire p) throws RemoteException {
        em = getEntityManager();
        
        Proprietaire pt = findProprietaire(p.getId()); 
        
        pt.setPaiement(p.getPaiement());
        
        EntityTransaction tx = em.getTransaction(); 
       
        try {  
             tx.begin();
             em.merge(pt);
             tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}
