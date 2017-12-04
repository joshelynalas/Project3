/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joshelynalas
 */

package project3;

import java.util.HashMap;
import javafx.scene.control.TextField;

public class Command {
    
  

/**
 *
 * @author burgosA
 */  
 boolean valid = false;
 
 boolean check; 
 
 HashMap<String, String> user_map = new HashMap<String, String>(); 
 
    public void addUser(String user, String password) 
    { 
        
        user_map.put(user, password); 
    }
    

    
    public boolean checkValid(String user, String pass) { 
        
        if(user_map.getOrDefault(user, "aqwejbjdskf").equals(pass)) { 
            System.out.println("Valid");
            check = true;
        }
        
        else { 
            System.out.println("Not Valid!!!!"); 
            check = false;
        }
        
        return check;
    }
    
    public boolean getValid(String user, String pass)
    {
      
        if(checkValid(user, pass) ==true)
        {
            System.out.print("Correct UserName\n" );
            valid = true;
            
        }
        else
        {
            System.out.print("incorrect UserName" + "\n");
            valid = false;
        }
        return valid;
    }
  
}

    
