/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.accueil;

import clientifx.maison.*;
import clientifx.ClientIFx;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
import model.Bien;
import model.Client;
import model.Facture;
import model.Proprietaire;
import service.IImmobilier;

/**
 * FXML Controller class
 *
 * @author berose
 */
public class Liste2Controller implements Initializable {

    @FXML
    private VBox box1;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private TableView<Bien> table_maison;
    @FXML
    private TableColumn<Bien, String> Photo;
    @FXML
    private TableColumn<Bien, String> Code;
    @FXML
    private TableColumn<Bien, String> Loyer;
    @FXML
    private TableColumn<Bien, String> Nombpiece;
    @FXML
    private TableColumn<Bien, String> Superficie;
    @FXML
    private TableColumn<Bien, String> Type;
    @FXML
    private TableColumn<Bien, String> Action;

    /**
     * Initializes the controller class.
     */
    List<Bien> listB = new ArrayList<>();
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {			
		loadTable();		
	} catch (Exception e) {
            e.printStackTrace();
	}
        
        Code.setCellValueFactory(new PropertyValueFactory<>("code"));
        Loyer.setCellValueFactory(new PropertyValueFactory<>("loyer"));
        Nombpiece.setCellValueFactory(new PropertyValueFactory<>("nombrepeice"));
        Photo.setCellValueFactory(new PropertyValueFactory<>("photo"));
        Superficie.setCellValueFactory(new PropertyValueFactory<>("superficie"));
        Type.setCellValueFactory(new PropertyValueFactory<>("idtype"));
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
        listB = im.findAllBien();
        
        for (Bien bien : listB) {
            if(!bien.getEtat().equals("Libre")){
                table_maison.getItems().add(bien);
            }
        }
    } 
    
    @FXML
    private void goEdit(ActionEvent event) {

    }
    
    @FXML
    private void goSupprimer(ActionEvent event) {

    }
 
    @FXML
    private void goPrint(ActionEvent event) {
    }
    
    @FXML
    private void goAjoutMaison(ActionEvent event) throws IOException {
        ClientIFx.showaddMaison();
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
