/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.facture;

import clientifx.ClientIFx;
import clientifx.ConnexionController;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
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
import javafx.scene.layout.VBox;
import model.Bien;
import model.Client;
import model.Facture;
import model.Loyer;
import service.IImmobilier;

/**
 * FXML Controller class
 *
 * @author berose
 */
public class AjoutController implements Initializable {
    List<Loyer> ltl = new ArrayList<>();
    
    
    @FXML
    private VBox box1;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXTextField Somme;
    @FXML
    private JFXComboBox<String> Loyer;
    ObservableList<String> listLoyer = FXCollections.observableArrayList();
    @FXML
    private JFXDatePicker Date;
    @FXML
    private JFXTextField Numero;
    @FXML
    private JFXTextField Avance;
    @FXML
    private JFXTextField Arrieree;
    @FXML
    private JFXTextField Restant;
    @FXML
    private JFXTextField Maison;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
		LoadBien();
	} catch (Exception e) {
            e.printStackTrace();
	}
    }    
    
    public IImmobilier getImplement(){
        try {
                System.setSecurityManager(new SecurityManager());
                Registry r = LocateRegistry.getRegistry("localhost",5023);
                IImmobilier im;
                im = (IImmobilier) r.lookup("Immobilier");
                
                return im;
        } catch (RemoteException ex) {
            Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
                Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    } 
    
    
    private void LoadBien() throws Exception {
        IImmobilier im = getImplement();
        ltl = im.findAllLoyer();
        
        for (Loyer ly : ltl) {
           listLoyer.add(ly.getCode());
        }
        
        Loyer.setItems(listLoyer);
    }
    
    @FXML
    private void showInfo(javafx.scene.input.MouseEvent event) {
        for (Loyer ly : ltl) {  
           if(ly.getCode().equals(Loyer.getValue())){      
               Maison.setText(ly.getIdbien().getCode());
               Somme.setText(""+ly.getIdbien().getLoyer());
            }
        }
    }
      
    @FXML
    private void goAjoutFacture(ActionEvent event) throws Exception {
        Facture fc = new Facture();
        IImmobilier im = getImplement();
        
        String FILE_NAME = "C:\\Users\\HP\\Documents\\L3\\Java\\ClientIFx\\src\\recu\\"+Numero.getText()+"_recu.pdf";
        Document document = new Document();
        Paragraph p = new Paragraph();
        Paragraph p1 = new Paragraph();
        Paragraph p2 = new Paragraph();
        Paragraph p3 = new Paragraph();
        Paragraph p4 = new Paragraph();
        Paragraph p5 = new Paragraph();
        Paragraph p6 = new Paragraph();
        Paragraph p7 = new Paragraph();
        Paragraph p8 = new Paragraph();
        Paragraph p9 = new Paragraph();
        Paragraph p10 = new Paragraph();
        Paragraph p11 = new Paragraph();
        Font f = new Font();
        Font f1 = new Font();
        Font f2 = new Font();
        Font f3 = new Font();
        Font f4 = new Font();
        Font f5 = new Font();
        
        //Fichier PDF
        PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
        document.open();
        document.add(new Paragraph("______________________________________________________________________________"));
        document.add(Image.getInstance("C:\\Users\\HP\\Documents\\L3\\Java\\ClientIFx\\src\\img\\logrecu.png"));
        
        f5.setStyle(Font.ITALIC);
        f5.setFamily("Century Gothic");
        f5.setColor(BaseColor.GRAY);
        f5.setSize(8);
        p.setFont(f5);
        p1.setFont(f5);
        p2.setFont(f5);
        p3.setFont(f5);
        p.add("G.Immobilière vente et location des bâtiments");
        p1.add("Adresse: Rue 29 x 28 Medina Dakar Sénégal");
        p2.add("Email: G.Immobliere221@info.com");
        p3.add("Tel: +221 70 455 99 23");
        document.add(p);
        document.add(p1);
        document.add(p2);
        document.add(p3);
        
        f1.setStyle(Font.BOLD);
        f1.setFamily("Century Gothic");
        f1.setSize(14);
        document.add(new Paragraph(" ", f1));
        
        f.setStyle(Font.BOLD);
        f.setColor(BaseColor.RED);
        f.setSize(17);
        p4.setFont(f);
        p4.add("Reçu");
        p4.setAlignment(Element.ALIGN_CENTER);
        document.add(p4);        
        
        f2.setStyle(Font.BOLD);
        f2.setFamily("Times New Roman");
        f2.setSize(14);
        document.add(new Paragraph("Numero: "+Numero.getText(), f2));
        
        fc.setTotal(Integer.parseInt(Somme.getText()));
        fc.setNumf(Numero.getText());
        fc.setRestant(Integer.parseInt(Restant.getText()));
        fc.setArrierees(Integer.parseInt(Arrieree.getText()));
        fc.setAvance(Integer.parseInt(Avance.getText()));
        fc.setDatef(Date.getEditor().getText());
      
        f1.setSize(15);
        document.add(new Paragraph(" ", f1));
        
        for (Loyer ly : ltl) {  
           if(ly.getCode().equals(Loyer.getValue())){      
               fc.setIdloyer(ly);
               
                p6.setAlignment(Element.ALIGN_JUSTIFIED);
                p6.setFont(f3);
                p6.add("Reçu de M: "+ly.getIdclient().getNom()+" "+ly.getIdclient().getPrenom()+" "); 
                document.add(p6);
               
                p5.setAlignment(Element.ALIGN_JUSTIFIED);
                p5.setFont(f3);
                p5.add("Code loyer: "+ly.getCode()+" Code maison: "+ly.getIdbien().getCode()+" "); 
                document.add(p5);
            }
        }
        
        p7.setAlignment(Element.ALIGN_JUSTIFIED);
        p7.setFont(f3);
        p7.add("La somme de: "+Somme.getText()+" fcfa\n"
                + "Avance: "+Avance.getText()+" fcfa --- Arriérées: "+Arrieree.getText()+" fcfa "
                + "-- Restant: "+Restant.getText()); 
        document.add(p7);
        
        f1.setSize(15);
        document.add(new Paragraph(" ", f1));
        
        p8.setAlignment(Element.ALIGN_RIGHT);
        p8.setFont(f3);
        p8.add("Date : "+Date.getEditor().getText()); 
        document.add(p8);
        
        document.add(new Paragraph("______________________________________________________________________________"));
        document.close();
        
        im.addFacture(fc);
        ClientIFx.showFacture();
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

    @FXML
    private void goPrint(ActionEvent event) {
    }

    

    
    
}
