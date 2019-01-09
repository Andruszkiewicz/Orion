
package Orion.Model;

import javax.swing.JButton;

/**
 * klasa punkt której obiektami są abstrakcyjne punkty reprezentowane przez przyciski gwiazd
 * @author karolinaandruszkiewicz
 */
 public class Point{
        /**zmienna pozwalająca na manipulowanie działaniem MouseListener'ów przypisywanych do gwiazd (JButton'ów) */
        public int clicked =0; 
        /**JButton należący do obiektu Point*/
        public JButton star = new JButton(); 
        /**współrzędna x gwiazdy*/
        public int x; 
        /**współrzędna y gwiazdy*/
        public int y; 
        /**
         * konstruktor argumentowy punktu
         * @param star
         * @param x
         * @param y 
         */
        Point(JButton star, int x, int y){
            this.star=star; 
            this.x=x; 
            this.y=y; 
        }
        /**
         * konstruktor bezargumentowy punktu
         */
        Point(){
            
        }
    }