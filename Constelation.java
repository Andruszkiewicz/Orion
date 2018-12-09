/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.Model;

import java.util.List;

/**
 *
 * @author karolinaandruszkiewicz
 */
public class Constelation {

    public static void createConstelations() {
        
    }
    public String name; 
    public String description; 
    public List<Point> points ; 
    public List<Connection> conections; 
    public List<Question> questions; 
    public String pictureName; 
    
   
    Constelation(String name, String description, List<Point> points, List<Connection> connections, List<Question> questions, String pictureName){
        this.name=name; 
        this.description=description; 
        this.points=points;
        this.conections=connections; 
        this.questions= questions; 
        this.pictureName=pictureName; 
                
    }
    
    
    
}
