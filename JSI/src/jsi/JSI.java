/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.IImmobilier;
import service.ImmobilierImpl;

/**
 *
 * @author berose
 */
public class JSI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
                System.setSecurityManager(new SecurityManager());
                IImmobilier iRemote = new ImmobilierImpl();
                Registry r = LocateRegistry.createRegistry(5023);
                r.bind("Immobilier", iRemote);
                System.out.println("Server lance sur le port 5023");        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
