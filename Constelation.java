package Orion.Model;

import java.util.List;

/**
 * klasa Constelation - każdy obiekt jest jedną z sześciu konstelacji w grze
 * @author karolinaandruszkiewicz
 */
public class Constelation {
    /** nazwa konstelacji*/
    public String name; 
    /**informacje przedstawiane w quizie wiedzy */
    public String description; 
    /**lista zawierająca punkty (gwiazdy) danej konstelacji*/
    public List<Point> points ; 
    /**lista zawierająca połączenia pomiędzy gwiazdami w danej konstelacji*/
    public List<Connection> connections; 
    /**lista pytań do quizów */
    public List<Question> questions; 
    /**nazwa pliku png przedstawiającego konstelację*/
    public String pictureName; 
    
    /**
     * Konstruktor argumentowy konstelacji
     * @param name
     * @param description
     * @param points
     * @param connections
     * @param questions
     * @param pictureName 
     */
    Constelation(String name, String description, List<Point> points, List<Connection> connections, List<Question> questions, String pictureName){
        this.name=name; 
        this.description=description; 
        this.points=points;
        this.connections=connections; 
        this.questions= questions; 
        this.pictureName=pictureName; 
    }
    /**
     * konstruktor bezargumentowy konstelacji
     */
    Constelation(){
        
    }
       
}
