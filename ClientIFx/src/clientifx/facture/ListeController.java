/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.facture;

import clientifx.ClientIFx;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Contrat;
import model.Facture;
import service.IImmobilier;

/**
 * FXML Controller class
 *
 * @author berose
 */
public class ListeController implements Initializable {

    @FXML
    private VBox box1;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private TableView<Facture> table_facture;
    @FXML
    private TableColumn<Facture, String> ID;
    @FXML
    private TableColumn<Facture, String> Code;
    @FXML
    private TableColumn<Facture, String> Client;
    @FXML
    private TableColumn<Facture, String> Loyer;
    @FXML
    private TableColumn<Facture, String> Date;
    @FXML
    private TableColumn<Facture, String> Arrieree;
    @FXML
    private TableColumn<Facture, String> Avance;
    @FXML
    private TableColumn<Facture, String> Total;

    /**
     * Initializes the controller class.
     */
    List<Facture> listF = new ArrayList<>();
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {			
		loadTable();		
	} catch (Exception e) {
            e.printStackTrace();
	}
        
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Code.setCellValueFactory(new PropertyValueFactory<>("numf"));
        Loyer.setCellValueFactory(new PropertyValueFactory<>("idloyer"));
        Date.setCellValueFactory(new PropertyValueFactory<>("datef"));
        Arrieree.setCellValueFactory(new PropertyValueFactory<>("arrierees"));
        Avance.setCellValueFactory(new PropertyValueFactory<>("avance"));
        Total.setCellValueFactory(new PropertyValueFactory<>("total"));
    }  
    
    public IImmobilier getImplement() throws Exception{
        
        System.setSecurityManager(new SecurityManager());
        Registry r = LocateRegistry.getRegistry("localhost",5023);
        IImmobilier im;
        im = (IImmobilier) r.lookup("Immobilier");
                
        return im; 
    }
    
    public void loadTable() throws Exception{
        IImmobilier im = getImplement();
        listF= im.findAllFacture();
        
        for (Facture ft : listF) {
            table_facture.getItems().add(ft);
        }
    }    
    
    @FXML
    private void goAjoutFacture(ActionEvent event) throws IOException {
        ClientIFx.showaddFacture();
    }

    @FXML
    private void goModifier(ActionEvent event) {
    }

    @FXML
    private void goSupprimer(ActionEvent event) {
    }

    @FXML
    private void goPrint(ActionEvent event) {
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
