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
public class SalesPay extends PaycheckDecorator {

    //SalesPay costructor
    public SalesPay(Paycheck paycheck) {

        super(paycheck);
    }

    @Override
    public void generate(String name) {
        super.generate(name);
        String out = "Adding new features";

    }

}
