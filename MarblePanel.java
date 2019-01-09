
package Orion.Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Klasa panelu o marmurowym tle
 * @author karolinaandruszkiewicz
 */
public class MarblePanel extends JPanel{
   /**marmurowa grafika*/
   Image marble = Toolkit.getDefaultToolkit().createImage("marble.jpg");
   
   /**
    * funkcja umieszczająca grafikę marmurową jako tło panelu oraz rysująca połączenia w konstelacjach
    * @param g 
    */
    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g);
            g.drawImage(marble, 0,0, this);
        for (GameWindow.Line line : GameWindow.lines) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g2.setColor(line.color);
            g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }


}
