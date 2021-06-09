/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientifx.typebien;
import clientifx.ClientIFx;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
/**
/**
 *
 * @author berose
 */
public class AjoutController {
     @FXML
    private VBox box1;

    @FXML
    private JFXTextField search;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXToggleButton btnExit;

    @FXML
    private TableView<?> table;

    @FXML
    private void goAccueil(ActionEvent event) throws IOException {
        ClientIFx.showAccueil();
    }

    @FXML
    private void goContrat(ActionEvent event) {

    }

    @FXML
    private void goEmploi(ActionEvent event) {

    }

    @FXML
    private void goExit(ActionEvent event) {

    }

    @FXML
    private void goFacture(ActionEvent event) {

    }

    @FXML
    private void goLocataire(ActionEvent event) {

    }

    @FXML
    private void goLoyer(ActionEvent event) {

    }

    @FXML
    private void goMaison(ActionEvent event) throws IOException {
        ClientIFx.showMaison();
    }

    @FXML
    private void goMenu(ActionEvent event) {

    }

    @FXML
    private void goMessage(ActionEvent event) {

    }

    @FXML
    private void goNotification(ActionEvent event) {

    }

    @FXML
    private void goParametre(ActionEvent event) {

    }

    @FXML
    private void goProfile(ActionEvent event) {

    }

    @FXML
    private void goReglement(ActionEvent event) {

    }

    @FXML
    private void goSearch(ActionEvent event) {

    }

    @FXML
    private void goStatistic(ActionEvent event) {

    }


    @FXML
    void goAjoutMaison(ActionEvent event) {

    }

    @FXML
    void goPrint(ActionEvent event) {

    }
}
