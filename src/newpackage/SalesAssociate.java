/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author joshelynalas
 */
public class SalesAssociate extends Person {
    
    public String salesVan;
    public String Invoice;

    public SalesAssociate(String position, String fName, String Lname, String name, String password, String email, String sv, String invoice) {
        super(position, fName, Lname, name, password, email);
        
        this.salesVan = sv;
        this.Invoice = invoice;

    }
   

    
}
