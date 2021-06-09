/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.loyer;
import clientifx.ClientIFx;
import clientifx.ConnexionController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import model.Bien;
import model.Client;
import model.Loyer;
import service.IImmobilier;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import model.Contrat;

/**
 * FXML Controller class
 *
 * @author berose
 */
public class AjoutController implements Initializable {
    List<Bien> ltb = new ArrayList<>();
    List<Client> ltc = new ArrayList<>();
    
    @FXML
    private VBox box1;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private JFXTextField Code;
    @FXML
    private JFXTextField Caution;
    @FXML
    private JFXComboBox<String> Bien;
    ObservableList<String> listBien = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> Client;
    ObservableList<String> listClient = FXCollections.observableArrayList();
    @FXML
    private JFXDatePicker Date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
		LoadBien();
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
     
    private void LoadBien() throws Exception {
        IImmobilier im = getImplement();
        ltb = im.findAllBien();
        
        for (Bien bn : ltb) {
            if(bn.getEtat().equals("Libre")){
                listBien.add(bn.getCode());
            }
        }
        
        Bien.setItems(listBien);
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
    private void showInfo(javafx.scene.input.MouseEvent event) {
        for (Bien bn : ltb) {  
           if(bn.getCode().equals(Bien.getValue())){      
               Caution.setText(""+bn.getLoyer());
            }
        }
    }
    
    @FXML
    private void goAjoutLoyer(ActionEvent event) throws Exception {
        Loyer ly = new Loyer();
        Contrat ct = new Contrat();
        
        IImmobilier im = getImplement();
        
        int st;
        
        String FILE_NAME = "C:\\Users\\HP\\Documents\\L3\\Java\\ClientIFx\\src\\contrat\\"+Code.getText()+"_contrat.pdf";
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
        
        st = Integer.parseInt(Caution.getText())*2;
        ly.setCaution(st);
        ly.setCode(Code.getText());
        ly.setDateentree(Date.getEditor().getText());
       
        ct.setMontantDE(st);
        ct.setDatecreation(Date.getEditor().getText());
        ct.setDaternvllmnt(Date.getEditor().getText());
        
        //Fichier PDF
        PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
        document.open();
        document.add(Image.getInstance("C:\\Users\\HP\\Documents\\L3\\Java\\ClientIFx\\src\\img\\logo.png"));
        
        f5.setStyle(Font.ITALIC);
        f5.setFamily("Century Gothic");
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
        f1.setSize(25);
        document.add(new Paragraph(" ", f1));
        
        f.setStyle(Font.BOLD);
        f.setColor(BaseColor.BLUE);
        f.setSize(20);
        p4.setFont(f);
        p4.add("CONTRAT DE LOCATION A \n USAGE D'HABITATION");
        p4.setAlignment(Element.ALIGN_CENTER);
        document.add(p4);
        
        
        f1.setStyle(Font.BOLD);
        f1.setFamily("Century Gothic");
        f1.setSize(30);
        document.add(new Paragraph(" ", f1));
      
        f2.setStyle(Font.NORMAL);
        f2.setFamily("Times New Roman");
        f2.setSize(13);
        document.add(new Paragraph("Code loyer: "+Code.getText()+" Date d'entrée"+Date.getEditor().getText()+" "
                + "Solde "+Integer.parseInt(Caution.getText())*2+"fcfa.", f2));
        

        f1.setSize(15);
        document.add(new Paragraph(" ", f1));
        
        //End Fichier PDF
        f3.setStyle(Font.NORMAL);
        f3.setFamily("Times New Roman");
        f3.setSize(13);
        
        for (Client cl : ltc) { 
           if(cl.getNci().equals(Client.getValue())){
                ly.setIdclient(cl);
                ct.setIdclient(cl);
                
                p6.setAlignment(Element.ALIGN_JUSTIFIED);
                p6.setFont(f3);
                p6.add("        Entre les soussignés d'une part:"
                        + " Monsieur le bailleur de G.Immobilière YANGA Exaucé à la rue 31 x 26 Médina"
                        + " D'autre part le client "+cl.getNom()+" "+cl.getPrenom()+" NCI°"
                        + " "+cl.getNci()+" autre contact "+cl.getEmail()+" tel "+cl.getTel()+" . Monsieur"
                        + " le bailleur donne en location le local d'écrit ainsi qu'il suit : "); 
                document.add(p6);
           }
        }
        
        for (Bien bn : ltb) {  
           if(bn.getCode().equals(Bien.getValue())){
               bn.setEtat("Occupé");
               im.updateBien(bn);
               ly.setIdbien(bn);
               
               p7.setAlignment(Element.ALIGN_JUSTIFIED);
               p7.setFont(f3);
               p7.add("Un "+bn.getIdtype().getLibelle()+" de numero: "+bn.getCode()+" "
                        + "nombre de piece "+bn.getNombrepeice()+" une superficie de :"+bn.getSuperficie()+" m²"
                        + ". Il présent client à fournit deux mois de location dont le montant est"
                        + " "+bn.getLoyer()*2+"fcfa un pour le mois d’entrée et un autre pour la caution.");
               document.add(p7);
            }
        }
        

        f1.setSize(30);
        document.add(new Paragraph(" ", f1));
        
        f4.setStyle(Font.BOLD);
        f4.setFamily("Times New Roman");
        f4.setSize(14);
        p8.setAlignment(Element.ALIGN_JUSTIFIED);
        p8.setFont(f4);
        p8.add("La présente location est consentie pour une durée de un an (1 an) prenant"
                + " effet en date "+Date.getEditor().getText()+" renouvelable par tacite reconduction.");
        document.add(p8);
       
        f1.setSize(10);
        document.add(new Paragraph(" ", f1));
        
        p9.add("Fait à Dakar, le"+Date.getEditor().getText()+"");
        p9.setAlignment(Element.ALIGN_CENTER);
        document.add(p9);
        
        f1.setSize(30);
        document.add(new Paragraph(" ", f1));
        
        p10.add("Lu et approuvé");
        p10.setAlignment(Element.ALIGN_RIGHT);
        p11.add("Signature du preneur et bailleur");
        p11.setAlignment(Element.ALIGN_RIGHT);
        document.add(p10);
        document.add(p11);
        
        document.close();
        im.addContrat(ct);
        im.addLoyer(ly);
        ClientIFx.showLoyer();
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
