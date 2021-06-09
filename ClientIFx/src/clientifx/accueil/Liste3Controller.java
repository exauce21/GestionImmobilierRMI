/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.accueil;

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
import model.Client;
import model.Facture;
import service.IImmobilier;

/**
 * FXML Controller class
 *
 * @author berose
 */
public class Liste3Controller implements Initializable {

    @FXML
    private VBox box1;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private TableView<Client> table_client;

    @FXML
    private TableColumn<Client, String> Nom;

    @FXML
    private TableColumn<Client, String> Prenom;

    @FXML
    private TableColumn<Client, String> Email;

    @FXML
    private TableColumn<Client, String> Tel;

    @FXML
    private TableColumn<Client, String> NCI;

    @FXML
    private TableColumn<Client, String> ID;
   

    /**
     * Initializes the controller class.
     */
    List<Facture> listF = new ArrayList<>();
    List<Client> listC = new ArrayList<>();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {			
		loadTable();		
	} catch (Exception e) {
            e.printStackTrace();
	}
        
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        Tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        NCI.setCellValueFactory(new PropertyValueFactory<>("nci"));
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
        int ok=1;
        
        for (Facture ft : listF) {
            if(ft.getArrierees()==0){             
                table_client.getItems().add(ft.getIdloyer().getIdclient());
            }
        }
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

    @FXML
    private void goAjoutClient(ActionEvent event) {
    }
}
