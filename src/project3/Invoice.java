/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author josheylnalas
 * @author burgosA
 */
public class Invoice {

    public String partName;
    public String salesA;
    public String partNum;
    public double Price;
    public double salePrice;
    public String date;
    public int quantity;
    public double total;
    public String sa;
    Date setdate = new Date();
    public String customer;
    ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    //Invoice constructor that takes all the parts an invoice should have
    public Invoice(String partName, String partNum, double Price, double salePrice, int quantity, Date date) {

        this.partName = partName;
        this.partNum = partNum;
        this.Price = Price;
        this.salePrice = salePrice;
        this.setdate = date;
        this.quantity = quantity;
        this.total = (salePrice * quantity);

    }

    //Method that sets sa to String s 
    public void setSAName(String s) {
        this.sa = s;
    }

    //Method that returns a sales associate's name
    public String getSAName() {
        return sa;
    }

    //Method that sets customer to String c
    public void setCName(String c) {
        this.customer = c;
    }

    //Method that returns a customer's name  
    public String getCName() {
        return customer;
    }

    //Method that adds an invoice to the array list of invoices
    public void addInvoice(ArrayList<Invoice> i) {
        invoices = i;
    }

    //Method that returns an arraylist of invoices
    public ArrayList<Invoice> getInvoice() {
        return invoices;

    }

    //Method that returns the total
    public double getTotal() {
        return total;
    }

    //Method that returns the attributes of a bikepart in String format 
    public String toString() {
        return partName + ", " + partNum + ", " + Price + ", " + salePrice + ", " + quantity + ", " + setdate + "\n";
    }

}
