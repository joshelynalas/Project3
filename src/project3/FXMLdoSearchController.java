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
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author joshelynalas
 * @author aburgos
 */
public class FXMLdoSearchController {

    @FXML
    private TextField userCommand1;

    @FXML
    private TextArea output;

    @FXML
    private TextArea output2;

    @FXML
    private TextField userCommand2;

    @FXML
    private TextField userCommand3;

    @FXML
    private TextArea output3;

    /**
     * Method that allows a warehouse manager to search for a part by name
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void doFindByName(ActionEvent event) throws IOException {
        String part = userCommand1.getText();
        boolean found = false;
        String print = "";

        for (Bikepart bp : Project3.bp) {
            if (part.equals(bp.getName()))//see if it is in wareHouse class
            {
                found = true;
                if (bp.onSale() == true)// if it is on sale
                {
                    print = (bp.getName() + ", " + bp.getSalePrice() + ", " + bp.getQuantity() + "\n");
                    break;
                } else {
                    print = (bp.getName() + ", " + bp.getListPrice() + ", " + bp.getQuantity() + "\n");
                    break;
                }
            }
        }
        if (!found) {
            print = "Part not found!";
        }

        output.appendText(print);
    }

    /**
     * Method that allows a warehouse manager to search for a part by number
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void doFindByNumber(ActionEvent event) throws IOException {
        String part = userCommand2.getText();
        boolean found = false;
        String print = "";

        for (Bikepart bp : Project3.bp) {

            if (part.equals(bp.getNum()))//see if it is in wareHouse class
            {
                found = true;
                if (bp.onSale() == true)// if it is on sale
                {
                    print = (bp.getName() + ", " + bp.getNum() + ", " + bp.getSalePrice() + ", " + bp.getQuantity() + "\n");

                } else {
                    print = (bp.getName() + ", " + bp.getNum() + ", " + bp.getListPrice() + ", " + bp.getQuantity() + "\n");

                }
            }
        }
        if (!found) {
            print = "Part not found!";
        }

        output2.appendText(print);

    }

    /**
     * Method that allows a warehouse manager to search for a part by quantity
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void doFindByQuantity(ActionEvent event) throws IOException {
        String part = userCommand3.getText();
        int newPart = Integer.parseInt(part);
        boolean found = false;
        String print = "";

        for (Bikepart bp : Project3.bp) {

            if (newPart == bp.getQuantity())//see if it is in wareHouse class
            {
                found = true;
                System.out.println("HERE");
                print = print + (bp.getName() + ", " + bp.getQuantity() + "\n");

            }

        }
        if (!found) {
            print = "Part not found!";
        }
        output3.appendText("The parts with the quantity of " + part + " are: \n" + print);
    }

}
