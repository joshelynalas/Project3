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
public class Person {
    
    public String position;
    public String firstName;
    public String lastName;
    public String userName;
    public String password;
    public String email;
    
    public Person( String position, String fName, String Lname, String name, String password , String email)
    {
        this.position = position;
        this.firstName = fName;
        this.lastName = Lname;
        this.userName = name;
        this.password = password;
        this.email = email;
    }

 
    public void setPosition(String q) { 
        
        position = q; 
        
    }
    
    public String getPosition() { 
        
        return position; 
    }
      public String getPassword() { 
        
        return password; 
    }
    
    public void setFirstName(String n) { 
        
        firstName = n;
    }
    
    public void setLastName(String l) {
        
        lastName = l;
    }
    
    public void setUsername(String u) { 
        
        userName = u;
    }
    
    public String getUsername() { 
        
        return userName;
    }
    
    public void setEmail(String e) { 
        
       email = e;
    }
    
    public void setPassword(String p)
    {
        password = p;
    }
    
    public String toString() { 
    
    return (position + "," + firstName + "," + lastName + "," + userName + "," + password + "," + email+ "\n");
    
    
    } 
  public String getUser() { 
    
    return ("Position: "+position + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nUsername: " + userName + "\nPassword: " + password + "\nEmail: " + email);
    
    
    } 
  
  
    
}
