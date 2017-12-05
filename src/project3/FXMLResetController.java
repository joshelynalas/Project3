/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/*
* @author aburgos
* @author josheylnalas
 */
import newpackage.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLResetController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextArea output;

    @FXML
    private Button buttonChange;
//method that allows office mamanger to change password for user 

    @FXML
    void changePassword(ActionEvent event) {
        String print = "";
        String user = username.getText();
        String Password = password.getText();
        for (Person compare : Project3.people) {
            if (user.equals(compare.getUsername())) {
                compare.setPassword(Password);
                Project3.cmd.addUser(user, Password);
                print = compare.getUser();
            }

        }
        output.appendText(print);

    }

}
