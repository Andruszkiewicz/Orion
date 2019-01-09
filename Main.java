
package Orion.Model;
import Orion.Model.GameWindow;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * główna klasa w grze, tworzy obiekt GameWindow
 * @author karolinaandruszkiewicz
 */
public class Main {
    
  
    public static void main(String[] args) {
         try {
             try {
                 // Ustaw Java L&F ( "Metal")
                 UIManager.setLookAndFeel(
                         "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             } catch (InstantiationException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IllegalAccessException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
    } 
    catch (UnsupportedLookAndFeelException e) {
       System.out.println("Nie udało się wczytać L&F"); //obsługa wyjątku
    }
        new GameWindow().setVisible(true); //wywołanie okna gry
        
    }
    
}
