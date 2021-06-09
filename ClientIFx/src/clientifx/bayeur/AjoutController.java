/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.bayeur;

import clientifx.ClientIFx;
import clientifx.ConnexionController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import model.Client;
import model.Proprietaire;
import service.IImmobilier;

/**
 * FXML Controller class
 *
 * @author berose
 */
public class AjoutController implements Initializable {

    @FXML
    private VBox box1;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXTextField Nom;
    @FXML
    private JFXTextField Tel;
    @FXML
    private JFXTextField Adresse;
    @FXML
    private JFXTextField Email;
    @FXML
    private JFXTextField Paiement;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public IImmobilier getImplement(){
        try {
                System.setSecurityManager(new SecurityManager());
                Registry r = LocateRegistry.getRegistry("localhost",5023);
                IImmobilier im;
                im = (IImmobilier) r.lookup("Immobilier");
                
                return im;
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
                Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @FXML
    void goAjout(ActionEvent event) throws Exception {
        Proprietaire pt = new Proprietaire();
        IImmobilier im = getImplement();
        
        pt.setNom(Nom.getText());
        pt.setTel(Integer.parseInt(Tel.getText()));
        pt.setEmail(Email.getText());
        pt.setMoyen(Paiement.getText());
        pt.setAdresse(Adresse.getText());
        pt.setPaiement(0);
        
        im.addProprietaire(pt);
        ClientIFx.showBayeur();
    }

    @FXML
    void goAnnuler(ActionEvent event) {
        Nom.setText("");
        Adresse.setText("");
        Tel.setText("");
        Email.setText("");
        Tel.setText("");
    }

    @FXML
    private void goBayeur(ActionEvent event) throws IOException {
        ClientIFx.showBayeur();
    }
    
    @FXML
    private void goAccueil(ActionEvent event) throws IOException {
        ClientIFx.showAccueil();
    }

    @FXML
    private void goContrat(ActionEvent event) throws IOException {
        ClientIFx.showContrat();
    }

    @FXML
    private void goEmploi(ActionEvent event) throws IOException{
        ClientIFx.showEmploi();
    }

    @FXML
    private void goExit(ActionEvent event) {

    }

    @FXML
    private void goFacture(ActionEvent event) throws IOException {
        ClientIFx.showFacture();
    }

    @FXML
    private void goLocataire(ActionEvent event) throws IOException {
        ClientIFx.showClient();
    }
    
    @FXML
    private void goMaison(ActionEvent event) throws IOException {
        ClientIFx.showMaison();
    }

    @FXML
    private void goLoyer(ActionEvent event) throws IOException {
        ClientIFx.showLoyer();
    }

    @FXML
    private void goMenu(ActionEvent event) {

    }

    @FXML
    private void goMessage(ActionEvent event) throws IOException{
         ClientIFx.showMessage();
    }

    @FXML
    private void goNotification(ActionEvent event) throws IOException {
        ClientIFx.showNotification();
    }

    @FXML
    private void goParametre(ActionEvent event) throws IOException {
        ClientIFx.showParametre();
    }

    @FXML
    private void goProfile(ActionEvent event) throws IOException {
        ClientIFx.showProfile();
    }

    @FXML
    private void goSearch(ActionEvent event) throws IOException {
        ClientIFx.showSearch();
    }

    @FXML
    private void goStatistic(ActionEvent event) throws IOException{
        ClientIFx.showStatistic();
    }
    
    
}
