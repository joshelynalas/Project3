/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import newpackage.SalesAssociate;
import newpackage.Person;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author joshelynalas
 * @author aburgos
 */
public class Project3 extends Application {

    //Method that shows the log in screen at run time
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    public static ArrayList<Person> people = new ArrayList<Person>();
    public static ArrayList<Bikepart> bp = new ArrayList<Bikepart>();
    public static ArrayList<Warehouse> wHouse = new ArrayList<Warehouse>();
    public static ArrayList<Invoice> iv = new ArrayList<Invoice>();
    public static ArrayList<SalesAssociate> speople = new ArrayList<SalesAssociate>();
    public static Warehouse w = new Warehouse("", "");
    public static Command cmd = new Command();

    //Method that searches all warehouse in the database and returns a warehouse object 
    public static Warehouse findWH(String whName) {
        for (Warehouse w : wHouse) {
            if (w.getWareHouseName().equals(whName)) {
                return w;
            }
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        //Creating new instances of the different users 
        Person p = new Person("Office Manager", "Joshelyn", "Alas", "jalas", "1245", "jalas@yahoo.com");
        SalesAssociate sa1 = new SalesAssociate("Sales Associate", "Ava", "Mansouri", "aman", "1236", "avaman@umw.edu", "jvan", "aman.txt");
        SalesAssociate sa2 = new SalesAssociate("Sales Associate", "Alexia", "Burgos", "aburgos", "1216", "aburgos@umw.edu", "avan", "aburgos.txt");
        SalesAssociate sa3 = new SalesAssociate("Sales Associate", "Bob", "King", "bKing", "1111", "bking@umw.edu", "bvan", "bKing.txt");
        Person p2 = new Person("Warehouse Manager", "Nelson", "Melendez", "hubby", "0609", "nelson@hotmail");
        Person p3 = new Person("System Adminstrator", "John", "Doe", "jdoe", "123", "jdoe@yahoo.com");

        //Adding new Sales Associates to the arraylist of sales associates
        speople.add(sa1);
        speople.add(sa2);
        speople.add(sa3);

        //Adding new instances of a Person to the arraylist of Person
        people.add(p);
        people.add(p2);
        people.add(p3);
        people.add(sa1);
        people.add(sa2);
        people.add(sa3);

        //Ading the users to the hashmap 
        cmd.addUser("jdoe", "123");
        cmd.addUser("aman", "1236");
        cmd.addUser("jalas", "1245");
        cmd.addUser("hubby", "0609");
        cmd.addUser("aburgos", "1216");

        launch(args);
    }
}
