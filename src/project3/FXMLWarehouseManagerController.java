/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
public class FXMLWarehouseManagerController {

    @FXML
    private TextArea output1;

    @FXML
    private TextField userCommand1;

    @FXML
    private TextArea output2;

    @FXML
    private TextField userCommand2;

    @FXML
    private TextField userCommand3;

    @FXML
    private TextArea output3;

    /**
     * Method that reads a file and establishes the initial inventory of the
     * database
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void doUpdate(ActionEvent event) throws IOException {

        String param = userCommand1.getText();
        String output = "";

        File file = new File(param);
        try {
            Scanner read = new Scanner(file);
            Warehouse newWh = new Warehouse("mainwh", "mainwh.txt");
            Project3.wHouse.add(newWh);
            String wareHouseName = "mainwh";
            newWh.setName(wareHouseName);
            newWh.setFile(param);
            ArrayList<Bikepart> bikePartArrayList = newWh.getWHArrayList();
            while (read.hasNext()) {
                String line = read.nextLine();
                String regExp = "\\s*(\\s|,)\\s*";
                String[] sValues = line.split(regExp);
                Bikepart s = new Bikepart(sValues[0], sValues[1], Double.parseDouble(sValues[2]), Double.parseDouble(sValues[3]), Boolean.parseBoolean(sValues[4]), Integer.parseInt(sValues[5]));
                bikePartArrayList.add(s);
                //Project3.bp.add(s);
                output = (Arrays.toString(sValues) + "\n");
                output1.appendText(output);

                int e = -1;

                for (int i = 0; i < Project3.bp.size(); i++) {

                    if (s.getName().equals(Project3.bp.get(i).getName())) {

                        e = i;
                    }

                }

                if (e == -1) {

                    Project3.bp.add(s);

                } else {

                    Project3.bp.get(e).setQuantity(Project3.bp.get(e).getQuantity() + s.getQuantity());

                    if (s.getListPrice() < Project3.bp.get(e).getListPrice() || s.getListPrice() > Project3.bp.get(e).getListPrice()) {

                        Project3.bp.get(e).setListPrice(s.getListPrice());

                    }

                    if (s.getSalePrice() < Project3.bp.get(e).getSalePrice() || s.getSalePrice() > Project3.bp.get(e).getSalePrice()) {

                        Project3.bp.get(e).setSalePrice(s.getSalePrice());

                    }

                    if (s.onSale() != Project3.bp.get(e).onSale()) {

                        Project3.bp.get(e).setOnSale(s.onSale());

                    }
                }

            }
        } catch (IOException e) {
            output = ("file error!");
            e.printStackTrace();
        }

    }

    /**
     * Method that takes a warehouse name and gets the inventory for that
     *
     * @param event
     * @throws IOException
     */
    @FXML
    void getWarehouse(ActionEvent event) throws IOException {

        String wareHouse = userCommand2.getText();
        String outputtwo = "";

        for (Warehouse w : Project3.wHouse) {
            if (w.getWareHouseName().equals(wareHouse)) {
                System.out.println("found warehouse");
                for (Bikepart bp : w.getWHArrayList()) {
                    outputtwo = (bp.getName() + "," + bp.getNum() + "," + bp.getListPrice() + "," + bp.getSalePrice() + "," + bp.onSale() + "," + bp.getQuantity() + "\n");
                    output2.appendText(outputtwo);
                    System.out.print(outputtwo);
                    System.out.print("FOUND WAREHOUSE");
                    wareHouse = "hkfjhashf";
                }

            }
        }
    }

    /**
     * Method that sorts parts in a warehouse by name
     *
     * @param event
     * @throws FileNotFoundException
     * @throws IOException
     */
    @FXML
    void doSortName(ActionEvent event) throws FileNotFoundException, IOException {
        String param = userCommand3.getText();
        String output = "";
        if (param.equals("mainwh")) {

            BufferedReader reader = null;
            ArrayList<String> rows = new ArrayList<String>();
            try {
                reader = new BufferedReader(new FileReader("initialInventory.txt"));
                String file;
                while ((file = reader.readLine()) != null) {
                    rows.add(file);
                }
                Collections.sort(rows);
                String[] strArr = rows.toArray(new String[0]);
                for (String cur : strArr) {
                    output = output + cur + "\n";
                }
            } finally {
                if (reader != null) {

                }

            }
        } else if (param.equals(Project3.w.wareHouseName)) {
            String filename = param + ".txt";
            BufferedReader reader = null;
            ArrayList<String> rows = new ArrayList<String>();
            try {
                reader = new BufferedReader(new FileReader(filename));
                String file;
                while ((file = reader.readLine()) != null) {
                    rows.add(file);
                }
                Collections.sort(rows);
                String[] strArr = rows.toArray(new String[0]);
                for (String cur : strArr) {
                    output = output + cur + "\n";
                }
            } finally {
                if (reader != null) {

                }

            }
        } else {
            output = "NO FOUND WAREHOUSE!";

        }
        output3.appendText("Inventory sorted by name: \n" + output);
    }

    /**
     * Method that sorts parts in a warehouse by number
     *
     * @param event
     */
    @FXML
    void doSortNumber(ActionEvent event) {
        String param = userCommand3.getText();
        String output = "";
        ArrayList<Bikepart> BIKEPART = new ArrayList<>();

        if (param.equals("mainwh")) {
            Collections.sort(Project3.bp, new SortNumber());
            for (int i = 0; i < Project3.bp.size(); i++) {
                output = output + (Project3.bp.get(i).getName() + "," + Project3.bp.get(i).getNum() + "," + Project3.bp.get(i).getListPrice() + "," + Project3.bp.get(i).getSalePrice() + "," + Project3.bp.get(i).onSale() + "," + Project3.bp.get(i).getQuantity() + "\n");
            }

        } else if (param.equals(Project3.w.getWareHouseName())) {
            System.out.print("im in here");
            String h = param + ".txt";
            System.out.print("the file is called: " + h);
            Scanner read = new Scanner(h);
            while (read.hasNext()) {
                System.out.print("COOL");
                String line = read.nextLine();
                String regExp = ",";
                String[] sValues = line.split(regExp);
                Bikepart good = new Bikepart(sValues[0], sValues[1], Double.parseDouble(sValues[2]), Double.parseDouble(sValues[3]), Boolean.parseBoolean(sValues[4]), Integer.parseInt(sValues[5]));
                BIKEPART.add(good);
                System.out.println("My array is: " + Arrays.toString(sValues));
                Collections.sort(BIKEPART, new SortNumber());
                for (int j = 0; j < BIKEPART.size(); j++) {
                    output = output + ("IN FOOR LOOP");
                    System.out.print(BIKEPART.get(j).getName() + "," + BIKEPART.get(j).getNum() + "," + BIKEPART.get(j).getListPrice() + "," + BIKEPART.get(j).getSalePrice() + "," + BIKEPART.get(j).onSale() + "," + BIKEPART.get(j).getQuantity() + "\n");
                }
            }
        } else {
            output = "Warehouse not found!!";
        }

        output3.appendText("Inventory sorted by number: \n" + output);
    }

}
