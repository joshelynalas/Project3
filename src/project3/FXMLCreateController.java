/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;


import newpackage.Person;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.xml.ws.Action;
import java.util.ArrayList;
import javafx.scene.control.TextArea;
/**
 * FXML Controller class
 *
 * @author joshelynalas
 */
public class FXMLCreateController implements Initializable {

    public TextField userCommand;
    public TextField userCommand2;
    public TextField userCommand3;
    public TextField userCommand4;
    public TextField userCommand5;
    public TextField userCommand6;
    String position;
    String Firstname;
    String Lastname;
    String username;
    String password;
    String email;
    
    
    //ArrayList<Person> people = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
      @FXML
    void setEmail(ActionEvent event) {

        String e = userCommand6.getText();
        email = e;
    }

    @FXML
    void setFirstName(ActionEvent event) {

        String fname = userCommand2.getText();
        Firstname = fname;

    }

    @FXML
    void setLastName(ActionEvent event) {

        String lname = userCommand3.getText();
        Lastname = lname;

    }

    @FXML
    void setPassword(ActionEvent event) {
        String passw = userCommand5.getText();
        password = passw;


    }

    @FXML
    void setPosition(ActionEvent event) {
        
        String p = userCommand.getText();
        position= p;


    }

    @FXML
    void setUsername(ActionEvent event) {

        String uname = userCommand4.getText();
        username = uname;

    }
    
    @FXML
    void doCreate(ActionEvent event) throws IOException { 
        
        Person p = new Person(position, Firstname, Lastname, username, password, email);
        Project3.people.add(p);
        output.appendText("This new user has been added: \n"+ p.getUser());
        System.out.print(p.getUser());
        
        Project3.cmd.addUser(username, password);
         
    }
    
  
    @FXML
    private TextArea output;
    {
        
    }
    
    

}
    
    

