/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx;
import com.gn.lab.GNButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javax.swing.JOptionPane;
import model.User;
import service.IImmobilier;

/**
 *
 * @author berose
 */
public class ConnexionController {
    
    @FXML
    private JFXTextField login;

    @FXML
    private JFXPasswordField password;
    
   
    @FXML
    private void goConnexion(ActionEvent event) throws RemoteException {
        String log = login.getText();
        String pas = password.getText();
       
        try {
            
            System.setSecurityManager(new SecurityManager());
            Registry r = LocateRegistry.getRegistry("localhost",5023);
            IImmobilier im = (IImmobilier) r.lookup("Immobilier");
              ClientIFx.showAccueil();    
            User u;
            u = im.findUser(log);
//            System.out.println(""+u.getNom());
             if(u==null){
                System.out.println("User no found");
            }else{
                if(!u.getPassword().equals(pas)){
                   JOptionPane.showMessageDialog(null, "Password incorrect");
                } else {
                   JOptionPane.showMessageDialog(null, "Bienvenu "+u.getNom());
                   ClientIFx.showAccueil();
                }   
            }	
	} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
    }
    
   

    
}
