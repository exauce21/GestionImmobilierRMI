/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.contrat;

import clientifx.ClientIFx;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import model.Client;
import model.Contrat;
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
    private JFXTextField Somme;
    @FXML
    private JFXComboBox<String> Client;
     ObservableList<String> listClient = FXCollections.observableArrayList();
    @FXML
    private JFXDatePicker Datecreation;
    @FXML
    private JFXTextField Numero;
    @FXML
    private JFXDatePicker Daterenouvellemnt;
    
    List<Client> ltc = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
                LoadClient();
	} catch (Exception e) {
            e.printStackTrace();
	}
    }   
    
    public IImmobilier getImplement() throws Exception{
                
        System.setSecurityManager(new SecurityManager());
        Registry r = LocateRegistry.getRegistry("localhost",5023);
        IImmobilier im;
        im = (IImmobilier) r.lookup("Immobilier");
        return im;
    }
    
    private void LoadClient() throws Exception {
        IImmobilier im = getImplement();
        ltc = im.findAllClient();
        
        for (Client cl : ltc) {
           listClient.add(cl.getNci());
        }
        
        Client.setItems(listClient);
    }
    
    @FXML
    private void goAjoutContrat(ActionEvent event) throws Exception {
        Contrat ct = new Contrat();
        IImmobilier im = getImplement();
        
        ct.setDatecreation(Datecreation.getEditor().getText());
        ct.setDaternvllmnt(Daterenouvellemnt.getEditor().getText());
        ct.setMontantDE(Integer.parseInt(Somme.getText()));
        
        for (Client cl : ltc) { 
           if(cl.getNci().equals(Client.getValue())){
                ct.setIdclient(cl);
            }
        }
        
        im.addContrat(ct);
        ClientIFx.showContrat();
    }
    @FXML
    private void goAnnuler(ActionEvent event) {
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
    
}
