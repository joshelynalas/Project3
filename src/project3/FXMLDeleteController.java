/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import newpackage.Person;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aburgos
 * @author joshelynalas
 */
public class FXMLDeleteController {

    public String usernameInput;
    @FXML
    private TextField userCommand;

    @FXML
    private Button delete;

    @FXML
    private TextArea output;
//method deltes user from person arraylist and HashMap

    @FXML
    void doDelete(ActionEvent event) {

        String user = userCommand.getText();
        Person delete = null;
        for (Person compare : Project3.people) {
            if (user.equals(compare.getUsername())) {
                System.out.print(compare.getUser());

                delete = compare;
            }

        }
        Project3.people.remove(delete);
        Project3.cmd.user_map.remove(user);
        output.appendText("User has been deleted");

    }

}
