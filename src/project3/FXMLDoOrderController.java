/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author aburgos
 * @author joshelynalas
 */
public class FXMLDoOrderController {

    @FXML
    public TextArea output;
//method goes through warehouse iventory and sees if there are parts with quantity less than 5

    @FXML
    public void initialize() {
        String print = "";
        for (Bikepart bp : Project3.bp) {
            if (bp.getQuantity() <= 5) {
                print = print + bp.toString();
            }
        }
        output.appendText(print);
    }

}
