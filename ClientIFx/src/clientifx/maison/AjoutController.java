/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.maison;

import clientifx.ClientIFx;
import clientifx.ConnexionController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Bien;
import model.Proprietaire;
import model.Typebien;
import service.IImmobilier;

/**
 * FXML Controller class
 *
 * @author berose
 */
public class AjoutController implements Initializable {
    
    List<Typebien> ltb = new ArrayList<>();
    List<Proprietaire> ltp = new ArrayList<>();
    
    @FXML
    private VBox box1;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXTextField Code;
    @FXML
    private JFXTextField Superficie;
    @FXML
    private JFXTextField Loyer;
    @FXML
    private JFXTextField Nombrepiece;
    @FXML
    private JFXComboBox<String> Type;
    ObservableList<String> listTypebien = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> Proprio;
    ObservableList<String> listproprio = FXCollections.observableArrayList();
    @FXML
    private ImageView image;
    @FXML
    private JFXButton Browse;
    
    private File file;
    private FileChooser fileChose = new FileChooser();
    private Image img;
    private FileInputStream fileInpStrm;
    private FileInputStream fileis ;
    private byte[] imgbyte;
    String filename = null;
    public static String path;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
		LoadType();
                LoadProprio();
	} catch (Exception e) {
            e.printStackTrace();
	}	
    }


    @FXML
    void goImage(ActionEvent event) throws Exception {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        file = fileChose.showOpenDialog(stage);
      
        if(file!=null){

            img = new Image(file.toURI().toString(),204,200,true,true);
            image.setImage(img);
            
        }else{
            JOptionPane.showMessageDialog(null, "Erreur");
        }
    }
    
    
    void goImages(ActionEvent event) throws Exception {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            filename = f.getAbsolutePath();
            this.path = (filename);
            image.setImage(img);
            
        } catch (Exception e) {
        }
    }
    
    public IImmobilier getImplement() throws Exception{
     
        System.setSecurityManager(new SecurityManager());
        Registry r = LocateRegistry.getRegistry("localhost",5023);
        IImmobilier im;
        im = (IImmobilier) r.lookup("Immobilier");
                
        return im;
    }
    
    private void LoadType() throws Exception {
        IImmobilier im = getImplement();
        ltb = im.findAllTypebien();
        
        for (Typebien tyb : ltb) {
           listTypebien.add(tyb.getLibelle());
        }
        
        Type.setItems(listTypebien);
    }
    
    private void LoadProprio() throws Exception {
        IImmobilier im = getImplement();
        ltp = im.findAllProprietaire();
        
        for (Proprietaire p : ltp) {
           listproprio.add(p.getNom());
        }
        
        Proprio.setItems(listproprio);
    }
    
    @FXML
    private void goAjout(ActionEvent event) throws Exception {
        Bien bn = new Bien();
        IImmobilier im = getImplement();
        int st;
        
        bn.setCode(Code.getText());
        bn.setLoyer(Integer.parseInt(Loyer.getText()));
        bn.setNombrepeice(Integer.parseInt(Nombrepiece.getText()));
        bn.setSuperficie(Integer.parseInt(Superficie.getText()));
        bn.setEtat("Libre");
        bn.setPhoto("");
        
        st = Integer.parseInt(Loyer.getText());
        
        for (Typebien tyb : ltb) {
           if(tyb.getLibelle().equals(Type.getValue())){
                bn.setIdtype(tyb);
            }
        }
        
        for (Proprietaire p : ltp) {
           if(p.getNom().equals(Proprio.getValue())){
                p.setPaiement(p.getPaiement()+((st*90)/100));
                im.updateProprietaire(p);
                bn.setIdproprio(p);
            }
        }
        
        im.addBien(bn);
        ClientIFx.showMaison();
       
    } 
    
    @FXML
    private void goAnnuler(ActionEvent event) {
        Code.setText("");
        Loyer.setText("");
        Nombrepiece.setText("");
        Superficie.setText("");
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
    private void goPrint(ActionEvent event) {
    }
    
}
