/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
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
public interface IImmobilier extends Remote {
    
    public User findUser(String login) throws RemoteException;
    
    
    public void addClient(Client cl) throws RemoteException;
    public List<Client> findAllClient() throws RemoteException;
    public Client findClient(String nom) throws RemoteException;
    public void updateClient(Client cl) throws RemoteException;
    public int deleteClient(int id) throws RemoteException;
    //--------------------------------------------------------------
    
    public void addBien(Bien b) throws RemoteException;
    public List<Bien> findAllBien() throws RemoteException;
    public Bien findBien(int id) throws RemoteException;
    public void updateBien(Bien b) throws RemoteException;
    public void updateBienData(Bien b) throws RemoteException;
    public void deleteBien(int id) throws RemoteException;
    //--------------------------------------------------------------
    
   
    public void addProprietaire(Proprietaire p) throws RemoteException;
    public List<Proprietaire> findAllProprietaire() throws RemoteException;
    public Proprietaire findProprietaire(int id) throws RemoteException;
    public void updateProprietaire(Proprietaire p) throws RemoteException;
    
     //--------------------------------------------------------------
    
    public void addLoyer(Loyer l) throws RemoteException;
    public List<Loyer> findAllLoyer() throws RemoteException;
    public Loyer findLoyer(int id) throws RemoteException;
    public void updateLoyer(Loyer l) throws RemoteException;
    public void deleteLoyer(int id) throws RemoteException;
    //--------------------------------------------------------
    
    public void addFacture(Facture f) throws RemoteException;
    public List<Facture> findAllFacture() throws RemoteException;
    public Facture findFacture(int id) throws RemoteException;
    public void updateFacture(Facture f) throws RemoteException;
    public void deleteFacture(int id) throws RemoteException;
    //--------------------------------------------------------
    
    public void addContrat(Contrat c) throws RemoteException;
    public List<Contrat> findAllContrat() throws RemoteException;
    public Contrat findContrat(int id) throws RemoteException;
    public void updateContrat(Contrat c) throws RemoteException;
    //--------------------------------------------------------
    
    public List<Typebien> findAllTypebien() throws RemoteException;
    public Typebien findTypebien(String nom) throws RemoteException;
    //--------------------------------------------------------
    
    
    
}
