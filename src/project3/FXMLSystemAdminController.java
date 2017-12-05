/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author joshelynalas
 * @author aburgos
 */
public class FXMLSystemAdminController {

    /**
     * Method that changes current screen to the creating account screen /*if
     * Create button is clicked
     */
    @FXML
    void createAccount(ActionEvent event) throws IOException {

        Stage stage2 = new Stage();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLCreate.fxml"));
        stage2.setScene(new Scene(home_page_parent));
        stage2.setTitle("Welcome System Administrator");
        stage2.initModality(Modality.WINDOW_MODAL);
        stage2.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage2.show();

    }

    /**
     * Method that changes current screen to the deleting account screen /* if
     * delete button is clicked
     */
    @FXML
    void deleteAccount(ActionEvent event) throws IOException {

        Stage stage3 = new Stage();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDelete.fxml"));
        stage3.setScene(new Scene(home_page_parent));
        //stage3.setTitle("Welcome System Administrator"); 
        stage3.initModality(Modality.WINDOW_MODAL);
        stage3.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage3.show();
    }

    /**
     * Method that changes current screen to the creating account screen /*if
     * Reset Password button is clicked
     */
    @FXML
    void resetPassword(ActionEvent event) throws IOException {

        Stage stage4 = new Stage();
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLReset.fxml"));
        stage4.setScene(new Scene(home_page_parent));
        //stage4.setTitle("Welcome System Administrator"); 
        stage4.initModality(Modality.WINDOW_MODAL);
        stage4.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage4.show();

    }

}
