/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.client;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Bien;
import model.Client;
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser;
import service.IImmobilier;

/**
 *
 * @author berose
 */
public class ClientController implements Initializable {
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
    
    List<Client> listC = new ArrayList<>();
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        listC = im.findAllClient();
        
        for (Client client : listC) {
            table_client.getItems().add(client);
        }
    }
    
    @FXML
    void goSupprimer(ActionEvent event) throws Exception {
        ObservableList<Client> allclient,Single; 
	IImmobilier im = getImplement();
        
        allclient = table_client.getItems();
        Single = table_client.getSelectionModel().getSelectedItems();
        Single.forEach(allclient::remove);
        
        im.deleteClient(Single.get(0).getId());
        ClientIFx.showClient(); 
    }
    
    public void onEdit(){
        if(table_client.getSelectionModel().getSelectedItems()!=null){
           Client sp = (Client) table_client.getSelectionModel().getSelectedItems();
        }
    }
    
    @FXML
    void goAjoutClient(ActionEvent event) throws Exception {
        ClientIFx.showaddClient();
    }
    
    @FXML
    void goModifier(ActionEvent event) {

    }
    
    @FXML
    void goPrint(ActionEvent event) {

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
