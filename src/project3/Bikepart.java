/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.ArrayList;

/**
 * @author aburgos
 * @author joshelynalas
 */
public class Bikepart implements Comparable {

    public String partName;
    public String partNum;
    public double listPrice;
    public double salePrice;
    public boolean onSale;
    public int quantity;

    /*
 * constuctor for bikePart class
 *
     */
    public Bikepart(String partName, String partNum, double listPrice, double salePrice, boolean onSale, int quantity) {

        this.partName = partName;
        this.partNum = partNum;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.onSale = onSale;
        this.quantity = quantity;

    }
    //Method that returns part name when called 

    public String getName() {
        return partName;
    }

    //Method that returns part num when called 
    public String getNum() {
        return partNum;
    }

    //Method sets true price 
    public void updatePrice(double a, double b, boolean c) {
        listPrice = a;
        salePrice = b;
        onSale = c;
    }
    //Method that returns list price when called 

    public double getListPrice() {
        return listPrice;
    }
    //Method that returns sale price when called

    public double getSalePrice() {
        return salePrice;
    }
    //Method that returns weither the part is on sale when called

    public boolean onSale() {
        return onSale;
    }
    //Method that will get new quantity method and set quantity to it 

    public void setQuantity(int quan) {
        quantity = quan;
    }
    //Method that returns quantity when called

    public int getQuantity() {
        return quantity;
    }
    //Special method in Java that will override "<" ">" "=" operators and compare my two araylist part Names to eachother and send back and integer (-1, 0, 1)
    //*Citation: <"prk"> (<May 15, 2013>) <compareToExample.java> (<code version>) [<java>]. https://stackoverflow.com/questions/1551235/java-strings-compareto-vs-equals.

    @Override
    public int compareTo(Object wh) {
        Bikepart temp = (Bikepart) wh;
        String tempString = partName.toUpperCase();
        return tempString.compareTo(temp.getName().toUpperCase());
    }

    public int compareTo(Bikepart c, Bikepart d) {
        Bikepart temp3 = (Bikepart) c;
        Bikepart temp4 = (Bikepart) d;
        String tempString = partNum.toString();
        return tempString.compareTo(temp3.getNum().toString());
    }
    //Method sets listPrice 

    void setListPrice(double lPrice) {
        listPrice = lPrice;
    }
    //Method sets salePrice

    void setSalePrice(double sPrice) {
        salePrice = sPrice;
    }
    //Method sets if part is on sale

    void setOnSale(boolean s) {
        onSale = s;
    }
    //Method returns the part formatted

    public String toString() {
        return partName + ", " + partNum + ", " + listPrice + ", " + salePrice + ", " + onSale + ", " + quantity + "\n";
    }

}
