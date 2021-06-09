/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.client;
import clientifx.ClientIFx;
import clientifx.ConnexionController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import model.Client;
import service.IImmobilier;
/**
/**
 *
 * @author berose
 */
public class AjoutController {
    
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
    private JFXTextField Prenom;

    @FXML
    private JFXTextField Email;

    @FXML
    private JFXTextField NCI;
    
    
    public IImmobilier getImplement() throws Exception{   
        System.setSecurityManager(new SecurityManager());
        Registry r = LocateRegistry.getRegistry("localhost",5023);
        IImmobilier im;
        im = (IImmobilier) r.lookup("Immobilier");
                
        return im;
    }
    
    @FXML
    void goAjout(ActionEvent event) throws Exception {
        Client cl = new Client();
        IImmobilier im = getImplement();
        
        cl.setNom(Nom.getText());
        cl.setPrenom(Prenom.getText());
        cl.setTel(Tel.getText());
        cl.setEmail(Email.getText());
        cl.setNci(NCI.getText());
        
        im.addClient(cl);
        ClientIFx.showClient();
    }

    @FXML
    void goAnnuler(ActionEvent event) {
        Nom.setText("");
        Prenom.setText("");
        Tel.setText("");
        Email.setText("");
        NCI.setText("");
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
    private void goBayeur(ActionEvent event) throws IOException {
        ClientIFx.showBayeur();
    }

    @FXML
    private void goSearch(ActionEvent event) throws IOException {
        ClientIFx.showSearch();
    }

    @FXML
    private void goStatistic(ActionEvent event) throws IOException{
        ClientIFx.showStatistic();
    }

     @FXML
    void goListClient(ActionEvent event) throws IOException {
        ClientIFx.showClient();
    }

    @FXML
    void goPrint(ActionEvent event) {

    }
}
