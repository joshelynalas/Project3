/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author joshelynalas
 * @autho aburgos
 * @author aman
 */
public class PaycheckDecorator implements Paycheck {

    protected Paycheck paycheck;

    //PaycheckDecorator Constructor
    public PaycheckDecorator(Paycheck p) {

        this.paycheck = p;

    }

    @Override
    public void generate(String name) {

        this.paycheck.generate(name);

    }

}
