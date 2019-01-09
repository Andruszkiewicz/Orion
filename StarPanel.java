
package Orion.Model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * klasa StarPanel której obiektami są panele o określonym tle 
 * @author karolinaandruszkiewicz
 */
public class StarPanel extends JPanel{
    /**grafika tła*/
    Image stars = Toolkit.getDefaultToolkit().createImage("4.jpg");
    /**
     * funkcja rysująca grafikę jako tło panelu
     * @param g 
     */
    protected void paintComponent(Graphics g) { //funkcja umieszczająca obrazek jpg jako tło panelu 
        super.paintComponent(g);
        g.drawImage(stars, 0,0, this);
    }
}
