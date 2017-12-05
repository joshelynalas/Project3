/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author burgosA
 * @author joshelynalas
 */
import java.util.Comparator;

 /**
 * @author joshelynalas /** Method that implements the strategy design pattern
 * to compare parts and sort them by part number
 */
public class SortNumber implements Comparator<Bikepart> {
public int compare(Bikepart c, Bikepart d)
{
    return c.getNum().compareTo(d.getNum());
}
    

    
}
