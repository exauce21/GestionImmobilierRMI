/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.accueil;
import clientifx.ClientIFx;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import model.Bien;
import model.Client;
import model.Facture;
import model.Proprietaire;
import service.IImmobilier;
/**
 *
 * @author berose
 */
public class AccueilController implements Initializable {
    
    @FXML
    private VBox box1;

    @FXML
    private JFXTextField search;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private Label MLibre;
    @FXML
    private Label MOccupee;
    
    @FXML
    private Label revenus;
    
    @FXML
    private Label nombre;
    
    @FXML
    private Label NombreClient;
    
    @FXML
    private Label NombrePartenaire;
    
    List<Bien> listB = new ArrayList<>();
    List<Client> listC = new ArrayList<>();
    List<Proprietaire> listP = new ArrayList<>();
    List<Facture> listF = new ArrayList<>();
    
    @FXML
    private Label NombreFacture;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         try {			
		loadTable();		
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
    
    public void loadTable() throws Exception{
        IImmobilier im = getImplement();
        listB = im.findAllBien();
        listC = im.findAllClient();
        listP = im.findAllProprietaire();
        listF = im.findAllFacture();
        int l=0,o=0,n=0,s=0,p=0,c=0,f=0;
        
        for (Bien bien : listB) {
            if(bien.getEtat().equals("Libre")){
                l++;
            }else{
                s = s + bien.getLoyer()*2;
                o++;
            }
        }
        n = l+o;
        
        for (Client client : listC) {
           c++;
        }
        
        for (Proprietaire prop : listP) {
           p++;
        }
        
        for (Facture fc : listF) {
           if(fc.getArrierees()==0){
                f++;
            }
        }
         
        nombre.setText(""+n);
        revenus.setText(""+s);
        MLibre.setText(""+l);
        MOccupee.setText(""+o);
        NombrePartenaire.setText(""+p);
        NombreClient.setText(""+c);
        NombreFacture.setText(""+f);
    }
    
     @FXML
    private void goClient(ActionEvent event) throws IOException {
        ClientIFx.showClientM();
    }
    
    
    
    @FXML
    private void goMLibre(ActionEvent event) throws IOException {
        ClientIFx.showMLibre();
    }

    @FXML
    private void goMOccupee(ActionEvent event) throws IOException {
        ClientIFx.showOccupee();
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
    private void goEtat(ActionEvent event) {
    }   
}
