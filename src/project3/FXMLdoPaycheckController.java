/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import newpackage.Person;
import java.util.ResourceBundle;
import java.util.Scanner;
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
public class FXMLdoPaycheckController implements Initializable {

    @FXML
    private TextField userCommand1;

    @FXML
    private TextField userCommand2;

    @FXML
    private TextField userCommand3;

    @FXML
    private TextArea output1;

    String username = "";

    /**
     * Method that allows an office manager to generate a sales commission for
     * sales associate
     *
     * @param event
     * @throws FileNotFoundException
     * @throws ParseException
     */
    @FXML
    void generatePaycheck(ActionEvent event) throws FileNotFoundException, ParseException {

        Paycheck salesPay = new SalesPay(new BasicPaycheck());
        salesPay.generate(userCommand1.getText());
        String output = "";
        double total = 0;
        for (Person p : Project3.people) {
            if (userCommand1.getText().equals(p.userName)) {
                String invoice = (p.userName + ".txt");
                File file = new File(invoice);
                Scanner read = new Scanner(file);

                ArrayList<Invoice> ivv = Project3.iv;
                while (read.hasNext()) {
                    String line = read.nextLine();
                    String regExp = "\\s*(\\s|,)\\s*";
                    String[] sValues = line.split(regExp);
                    Date date = new Date();

                    Invoice s = new Invoice(sValues[0], sValues[1], Double.parseDouble(sValues[2]), Double.parseDouble(sValues[3]), Integer.parseInt(sValues[4]), date);
                    ivv.add(s);
                    //Project3.bp.add(s);
                    output = (Arrays.toString(sValues) + "\n");
                    total = total + s.getTotal();

                }
                double commission = (total * .15);
                output1.appendText("This is the paycheck for: " + userCommand1.getText() + "\n  The total commission for " + userCommand1.getText() + "between " + userCommand2.getText() + "-" + userCommand3.getText() + "\n is : " + commission);
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
