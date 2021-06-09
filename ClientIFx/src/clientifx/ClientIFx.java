/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author berose
 */
public class ClientIFx extends Application {

   
	private Stage primaryStage;
	private static Stage secondStage;
	private static BorderPane mainLayout;
	
    @Override
    public void start(Stage primaryStage) throws Exception { 
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion Immobiliere");
		
        showMainView();
        showConnexion();
    }
    
    private void showMainView() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("FXMLDocument.fxml"));
	mainLayout = loader.load();
	Scene scene = new Scene(mainLayout);
	primaryStage.setScene(scene);
	primaryStage.show();
    }
    
    public static void showConnexion() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("Connexion.fxml"));
	BorderPane mIt = loader.load();
	mainLayout.setCenter(mIt);
    }
    
    public static void showAccueil() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("accueil/Home.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showMLibre() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("accueil/Liste.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showOccupee() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("accueil/Liste2.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showMaison() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("maison/Liste.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
   
    
    public static void showaddMaison() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("maison/Ajout.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showClient() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("client/Client.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showaddClient() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("client/Ajout.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showLoyer() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("loyer/Liste.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showaddLoyer() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("loyer/Ajout.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showFacture() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("facture/Liste.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showaddFacture() throws IOException {
	FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("facture/Ajout.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showBayeur() throws IOException {
        FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("bayeur/Liste.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showaddBayeur() throws IOException {
        FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("bayeur/Ajout.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
     public static void showClientM() throws IOException {
        FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("accueil/Client.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showMenu() throws IOException {
	
    }
    
    public static void showProfil() throws IOException {
	
    }
    
    public static void showParametre() throws IOException {
	
    }
    
    public static void showContrat() throws IOException {
        FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("contrat/Liste.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showaddContrat() throws IOException {
        FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("contrat/Ajout.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showEdit() throws IOException {
        FXMLLoader loader = new FXMLLoader();
	loader.setLocation(ClientIFx.class.getResource("maison/Edite.fxml"));
	BorderPane menu = loader.load();
	mainLayout.setCenter(menu);
    }
    
    public static void showEmploi() throws IOException {
	
    }
    
    public static void showMessage() throws IOException {
    }

    public static void showNotification() throws IOException {
    }

    public static void showStatistic() throws IOException {
    }

    public static void showSearch() throws IOException {
    }

    public static void showProfile() throws IOException {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
