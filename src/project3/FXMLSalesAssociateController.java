/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import newpackage.Person;
import newpackage.SalesAssociate;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class 
 * @author aburgos
 * @author joshelynalas
 */
public class FXMLSalesAssociateController {

    @FXML
    private TextField userCommand1;
    @FXML
    private TextField userName;
    @FXML
    private TextField userCommandName;
    @FXML
    private TextField userCommandQ;
    @FXML
    private TextArea output;

    @FXML
    private TextArea output1;

    @FXML
    private TextField deliveryFile;

    @FXML
    private TextArea output2;

    public String sa = "jalas";
    public double price;
    public Date date = new Date();
    public String out = "";
    ArrayList<Invoice> v = new ArrayList<Invoice>();
//method that generate an invoice for specific customer

    @FXML
    void GenerateInvoice(ActionEvent event) {
        String invoicefm = "";
        double total = 0;
        for (Invoice i : v) {
            invoicefm = invoicefm + (i.partName + "," + i.partNum + ", " + i.Price + ", " + i.salePrice + ", " + i.quantity + ", $" + i.total + "\n");
            total = total + i.getTotal();
        }
        output2.appendText("Sales invoice for: " + sa + "'s Bike Shop. " + date + "\n");
        output2.appendText("\n" + invoicefm + "\nTotal: $" + total);

    }
// method takes in delivery file and "moves" parts according to file

    @FXML
    void doMove(ActionEvent event) throws IOException {
        String out = "";
        String fromWHName;
        String toWHName;
        String fileName;
        int num;
        String okay;
        String[] bp;
        String partName;
        Scanner j = new Scanner(System.in);
        String name = deliveryFile.getText();
        File file2 = new File(name);
        try {
            Scanner brTest = new Scanner(file2);
            String test = brTest.nextLine();
            String[] v = test.split(",");
            fromWHName = v[0];
            toWHName = v[1];
            System.out.println("Firstline is:" + fromWHName + " " + toWHName);
            while (brTest.hasNext()) {
                String line = brTest.nextLine();
                String regExp = "\\s*(\\s|,)\\s*";
                System.out.println(line);
                bp = line.split(",");
                partName = bp[0];
                num = Integer.parseInt(bp[1]);

                Warehouse fromWHouse = Project3.findWH(fromWHName);
                Warehouse toWHouse = Project3.findWH(toWHName);

                for (Bikepart n : fromWHouse.getWHArrayList()) {
                    if (n.getName().equals(partName)) {
                        out = out + (n.getName() + "," + n.getNum() + "," + n.getListPrice() + "," + n.getSalePrice() + "," + n.onSale() + "," + num + "\n");
                        System.out.print(out);
                        int newQuantity = n.getQuantity() - num;
                        n.setQuantity(newQuantity);
                        Bikepart newBP = new Bikepart(n.getName(), n.getNum(), n.getListPrice(), n.getSalePrice(), n.onSale(), num);
                        toWHouse.addPart(newBP);
                    }
                }

            }
            output1.appendText(out);
            System.out.print(out);
            toWHName = toWHName + ".txt";
            fromWHName = fromWHName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(toWHName));
            writer.write(out);
            writer.close();
        } catch (FileNotFoundException e) {
        }
    }
//method sells item, creates inovoice, updates invoice and warehouse accordingly 

    @FXML
    void doSell(ActionEvent event) throws IOException {
        String invoice = "";
        int amount = Integer.parseInt(userCommandQ.getText());
        for (Person a : Project3.people) {
            if (a.userName.equals(userName.getText())) {
                String name = a.userName;
                for (Bikepart compare : Project3.bp) {
                    if (userCommand1.getText().equals(compare.getNum()))// see if user nput of part num is in wareHouse 
                    {
                        out = (compare.getName() + ", " + compare.getNum() + ", " + compare.getListPrice() + ", " + compare.getSalePrice() + ", " + compare.getQuantity() + ", " + date.toString() + "\n");
                        //decrement quantity by 1
                        int value = compare.getQuantity();
                        value = value - amount;
                        compare.setQuantity(value);// sends new vlaue to setQuantity method with new value
                        Invoice iv = new Invoice(compare.getName(), compare.partNum, compare.listPrice, compare.salePrice, amount, date);
                        iv.setSAName(a.userName);
                        iv.setCName(userCommandName.getText());
                        v.add(iv);

                        Project3.iv.add(iv);
                        System.out.print("SA name :" + a + "\n Customer name is: " + userCommandName.getText() + "\n");

                    }

                }
                invoice = (a.userName + ".txt");

            }
            //output.appendText(out);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(invoice, true));
        System.out.print(out);
        writer.write(out);
        writer.close();
        output.appendText("Sold");

    }

}
