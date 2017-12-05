/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aburgos
 * @author joshelynalas
 */
public class FXMLOfficeManagerController {

    @FXML
    private Button orderButton;
//method initizalizes pop up warning if quaniity is less than 5

    @FXML
    public void initialize() {
        String part = "";
        boolean found = false;
        for (Bikepart bp : Project3.bp) {
            if (bp.getQuantity() <= 5) {
                found = true;
            }
        }
        if (found == true) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("ATTENTION");
            alert.setContentText("There are parts that are running low");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.out.print("okay clicked");
            }
        }
    }
//opens page shows all parts with quantity is less than 5

    @FXML
    void doOrder(ActionEvent event) throws IOException {

        Stage stage8 = new Stage();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDoOrder.fxml"));
        stage8.setScene(new Scene(home_page_parent));

        stage8.initModality(Modality.WINDOW_MODAL);
        stage8.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage8.show();

    }
//opens page to compute paycheck for specific sales associate

    @FXML
    void doPaycheck(ActionEvent event) throws IOException {

        Stage stage9 = new Stage();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLdoPaycheck.fxml"));
        stage9.setScene(new Scene(home_page_parent));
        stage9.initModality(Modality.WINDOW_MODAL);
        stage9.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage9.show();

    }
//opens page to find part

    @FXML
    void doSearch(ActionEvent event) throws IOException {

        Stage stage10 = new Stage();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLdoSearch.fxml"));
        stage10.setScene(new Scene(home_page_parent));
        stage10.initModality(Modality.WINDOW_MODAL);
        stage10.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage10.show();

    }

}
