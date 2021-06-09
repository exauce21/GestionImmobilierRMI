/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.maison;

import clientifx.ClientIFx;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import model.Bien;
import model.Proprietaire;
import model.Typebien;
import service.IImmobilier;

/**
 * FXML Controller class
 *
 * @author berose
 */
public class EditeController implements Initializable {
    List<Typebien> ltb = new ArrayList<>();
    List<Proprietaire> ltp = new ArrayList<>();
    List<Bien> lb = new ArrayList<>();
    
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
    private JFXButton Browse;
    @FXML
    private ImageView image;
    @FXML
    private JFXComboBox<String> Proprio;
    ObservableList<String> listproprio = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> Bien;
    ObservableList<String> listBien = FXCollections.observableArrayList();
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
        // TODO
        
         try {
		LoadType();
                LoadProprio();
                LoadBien();
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
    
    private void LoadBien() throws Exception {
        IImmobilier im = getImplement();
        lb = im.findAllBien();
        
        for (Bien b : lb) {
           listBien.add(b.getCode());
        }
        
        Bien.setItems(listBien);
    }
    
   
    
    
    @FXML
    private void goEdite(ActionEvent event) throws Exception {
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
                p.setPaiement(p.getPaiement()+st);
                im.updateProprietaire(p);
                bn.setIdproprio(p);
            }
        }            image.setImage(img);

        
        im.updateBienData(bn);
        ClientIFx.showMaison();
    }
    
    @FXML
    private void goChargeBien(ActionEvent event) throws Exception {
        for (Bien bn : lb) {  
           if(bn.getCode().equals(Bien.getValue())){
                Code.setText(bn.getCode());
                Superficie.setText(bn.getNombrepeice()+"");
                Loyer.setText(bn.getLoyer()+"");
                Nombrepiece.setText(bn.getNombrepeice()+"");
                
                Type.getItems().clear();
        
                for (Typebien tyb : ltb) {
                    if(tyb.getLibelle() == bn.getIdtype().getLibelle()){
                        Type.setValue(tyb.getLibelle());
                        System.out.println(""+tyb.getLibelle());
                    }
                }
                LoadType();
                Proprio.getItems().clear();
                for (Proprietaire p : ltp) {
                    if(p.getId() == bn.getIdproprio().getId()){
                        Proprio.setValue(p.getNom());
                        System.out.println(""+p.getNom());
                    }
                }  
                LoadProprio();   
           }
        }
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
    private void goImage(ActionEvent event) {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            filename = f.getAbsolutePath();
            this.path = (filename);
            
        } catch (Exception e) {
        }
    }

    
    
}
