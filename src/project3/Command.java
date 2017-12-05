/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author aburgos
 * @author joshelynalas
 * @author ava
 */
package project3;

import java.util.HashMap;
import javafx.scene.control.TextField;

public class Command {

    boolean valid = false;
    boolean check;
    //HashMap that holds username(key) password(value)
    HashMap<String, String> user_map = new HashMap<String, String>();

//method that takes in two strings(username and password) and adds them to the HashMap 
    public void addUser(String user, String password) {
        user_map.put(user, password);
    }
//method that checks if the username is in the hasmap and unlocks value(password)

    public boolean checkValid(String user, String pass) {

        if (user_map.getOrDefault(user, "aqwejbjdskf").equals(pass)) {
            System.out.println("Valid");
            check = true;
        } else {
            System.out.println("Not Valid!!!!");
            check = false;
        }
        return check;
    }
//mathod  that returns a boolean if correct(true) of not correct(false)

    public boolean getValid(String user, String pass) {
        if (checkValid(user, pass) == true) {
            System.out.print("Correct UserName\n");
            valid = true;
        } else {
            System.out.print("incorrect UserName" + "\n");
            valid = false;
        }
        return valid;
    }

}
