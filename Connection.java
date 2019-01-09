package Orion.Model;

import java.awt.Graphics;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * klasa Connection - połączenie między gwiazdami
 * @author karolinaandruszkiewicz
 */

    public class Connection{
        /**punkt pierwszy w połączeniu*/
        public Point point1; 
        /**punkt drugi w połączeniu*/
        public Point point2; 

        /**
         * konstruktor połączenia 
         * @param point1
         * @param point2 
         */
        Connection(Point point1, Point point2){
            this.point1=point1; //przypisz 2 punkty (gwiazdy) do połączenia
            this.point2=point2; 
        }
}              
                   
                       
                   
           
            
                
    
