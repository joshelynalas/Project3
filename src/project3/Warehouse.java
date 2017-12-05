/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author joshelynalas
 * @author aburgos
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.lang.String;

public class Warehouse {

    public String fileName;
    public String wareHouseName;
    public File mainWareHouse = new File("mainWarehouse.txt");
    public String partName;
    ArrayList<Bikepart> wh = new ArrayList<Bikepart>();

    //Warehouse constructor
    public Warehouse(String whName, String n) {
        wareHouseName = whName;
        fileName = n;
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            // true = append file
            fw = new FileWriter(mainWareHouse.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            File file = new File(fileName);
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                String line = read.nextLine();
                String regExp = "\\s*(\\s|,)\\s*";
                String[] sValues = line.split(regExp);
                Bikepart s = new Bikepart(sValues[0], sValues[1], Double.parseDouble(sValues[2]), Double.parseDouble(sValues[3]), Boolean.parseBoolean(sValues[4]), Integer.parseInt(sValues[5]));
                wh.add(s);
            }
            //output =(Arrays.toString(sValues));
            bw.write(wareHouseName + "," + fileName + "\n");
        } catch (IOException e) {
        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }
    }

    //Method that gets an arraylist of bikeparts and returns that arraylist of bikeparts 
    public ArrayList<Bikepart> getWHArrayList() {
        return wh;

    }

    /**
     * Method that gets the part name of a Bike part and checks if that partName
     * is in the ArrayList of parts
     * @return partName
     */
    public String getPartName() {
        if (wh.contains(partName)) {
            partName = partName;
        }
        return partName;
    }

    /**
     * Method that gets the text file of a warehouse
     * @return fileName
     */
    public String getWareHouseFile() {

        return fileName;
    }

    /**
     * Method that returns a wareHouseName
     * @return string wareHouseName
     */
    public String getWareHouseName() {
        return wareHouseName;
    }

    /**
     * Method that sets wareHouseName to name
     * @param name
     */

    public void setName(String name) {
        wareHouseName = name;
    }

    /**
     * Method that sets the fileName to s
     * @param s
     */
    public void setFile(String s) {
        fileName = s;
    }

    /**
     * Method that sets the array list of bike parts bp to wh
     * @param bp
     */
    public void setArrayList(ArrayList<Bikepart> bp) {
        wh = bp;
    }

    String getAbsoluteFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method that adds bike parts
     * @param b
     */
    public void addPart(Bikepart b) {
        for (Bikepart bp : wh) {
            if (bp.partName.equals(b.partName)) {
                bp.quantity += b.quantity;
                return;
            }
        }

        wh.add(b);
    }
}
