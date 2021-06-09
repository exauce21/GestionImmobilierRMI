/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.loyer;

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
import model.Loyer;
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
    private TableView<Loyer> table_loyer;
    @FXML
    private TableColumn<Loyer, String> ID;
    @FXML
    private TableColumn<Loyer, String> Bien;
    @FXML
    private TableColumn<Loyer, String> Client;
    @FXML
    private TableColumn<Loyer, String> Date;
    @FXML
    private TableColumn<Loyer, String> Caution;

    /**
     * Initializes the controller class.
     */
    List<Loyer> listL = new ArrayList<>();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {			
		loadTable();		
	} catch (Exception e) {
            e.printStackTrace();
	}
        
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Caution.setCellValueFactory(new PropertyValueFactory<>("caution"));
        Date.setCellValueFactory(new PropertyValueFactory<>("dateentree"));
        Client.setCellValueFactory(new PropertyValueFactory<>("idclient"));
        Bien.setCellValueFactory(new PropertyValueFactory<>("idbien"));
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
        listL = im.findAllLoyer();
        
        for (Loyer ly : listL) {
            table_loyer.getItems().add(ly);
        }
    }  
    
     @FXML
    private void goAjoutLoyer(ActionEvent event) throws IOException {
        ClientIFx.showaddLoyer();
    }

    @FXML
    private void goModifier(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    private void goLoyer(ActionEvent event) throws IOException {
        ClientIFx.showLoyer();
    }

    @FXML
    private void goSupprimer(ActionEvent event) throws IOException {
        ClientIFx.showStatistic();
    }

    @FXML
    private void goMenu(ActionEvent event) throws IOException {
         ClientIFx.showMenu();
    }

    @FXML
    private void goAccueil(ActionEvent event) throws IOException {
         ClientIFx.showAccueil();
    }

    @FXML
    private void goMessage(ActionEvent event) throws IOException {
        ClientIFx.showMessage();
    }

    @FXML
    private void goEmploi(ActionEvent event) throws IOException {
        ClientIFx.showEmploi();
    }

    @FXML
    private void goStatistic(ActionEvent event) throws IOException {
        ClientIFx.showStatistic();
    }

    @FXML
    private void goNotification(ActionEvent event) throws IOException {
        ClientIFx.showStatistic();
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
    private void goMaison(ActionEvent event) throws IOException {
        ClientIFx.showMaison();
    }

    @FXML
    private void goLocataire(ActionEvent event) throws IOException {
        ClientIFx.showClient();
    }

    @FXML
    private void goFacture(ActionEvent event) throws IOException {
        ClientIFx.showFacture();
    }

   @FXML
    private void goBayeur(ActionEvent event) throws IOException {
        ClientIFx.showBayeur();
    }

    @FXML
    private void goContrat(ActionEvent event) throws IOException {
        ClientIFx.showContrat();
    }

    @FXML
    private void goSearch(ActionEvent event) throws IOException {
        ClientIFx.showSearch();
    }

    @FXML
    private void goExit(ActionEvent event) {
    }

    @FXML
    private void goPrint(ActionEvent event) throws IOException {
       
    }
    
}
