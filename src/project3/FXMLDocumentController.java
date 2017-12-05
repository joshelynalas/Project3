/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/*
* @author aburgos
* @author joshelynalas
 */
import newpackage.Person;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML
    public TextField userCommand;
    public TextField userCommand2;
//method is activated when the login buttin is pused, opens up corresponding page to user

    @FXML
    void Loginbutton(ActionEvent event) throws IOException {

        String user = userCommand.getText();
        String pass = userCommand2.getText();
        String position;

        if (Project3.cmd.getValid(user, pass) == true) {
            //output.appendText("Valid!"); 

            for (Person p : Project3.people) {

                if (p.getUsername().equals(user)) {
                    position = p.getPosition();
//if ; opens up Sales Associate page
                    if (position.equals("Sales Associate")) {

                        Stage stage6 = new Stage();
                        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLSalesAssociate.fxml"));
                        //home_page_parent.setStyle("-fx-background-color: pink");
                        stage6.setScene(new Scene(home_page_parent));

                        stage6.initModality(Modality.WINDOW_MODAL);
                        stage6.initOwner(((Node) event.getSource()).getScene().getWindow());
                        stage6.show();

                    }
//if ; opens up Office Manager page
                    if (position.equals("Office Manager")) {

                        Stage stage11 = new Stage();
                        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLOfficeManager.fxml"));
                        stage11.setScene(new Scene(home_page_parent));
                        stage11.initModality(Modality.WINDOW_MODAL);
                        stage11.initOwner(((Node) event.getSource()).getScene().getWindow());
                        stage11.show();

                    }
//if ; opens up WareHouse Manager page
                    if (position.equals("Warehouse Manager")) {
                        Stage stage12 = new Stage();
                        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLWarehouseManager.fxml"));
                        stage12.setScene(new Scene(home_page_parent));
                        stage12.initModality(Modality.WINDOW_MODAL);
                        stage12.initOwner(((Node) event.getSource()).getScene().getWindow());
                        stage12.show();

                    }
//if ; opens up System Admin page
                    if (position.equals("System Adminstrator")) {

                        Stage stage = new Stage();
                        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLSystemAdmin.fxml"));
                        stage.setScene(new Scene(home_page_parent));
                        stage.setTitle("Welcome System Administrator");
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
                        stage.show();

                    }

                }

            } //end of for loop

        } else {
            Stage stage13 = new Stage();
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLInvalid.fxml"));
            stage13.setScene(new Scene(home_page_parent));
            stage13.initModality(Modality.WINDOW_MODAL);
            stage13.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage13.show();

        }

    }

    @FXML
    private Label label;

    @FXML
    private TextArea output;

    @FXML
    //send username
    void getUsername(ActionEvent event) {
        String u = userCommand.getText();
        System.out.print(u);

    }
//sends password

    @FXML
    void getPassword(ActionEvent event) {
        String p = userCommand2.getText();
        System.out.print(p);

    }

}
