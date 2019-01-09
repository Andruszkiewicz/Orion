
package Orion.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 * klasa Reading stworzona w celu możliwości uniwersalnego czytania tekstu z plików tekstowych
 * @author karolinaandruszkiewicz
 */
public class Reading { 
    /**nazwa pliku tekstowego*/
    String fileName; 
    /**pole tekstowe*/
    JTextArea txtArea;
    /**
     * konstruktor argumentowy klasy Reading 
     * @param fileName
     * @param txtArea 
     */
    Reading (String fileName, JTextArea txtArea){ 
        this.fileName= fileName; 
        this.txtArea=txtArea; 
    }
    
    /**
     * funkcja czytania z pliku i jednoczesnego wpisywania tekstu do pola tekstowego
     * @param txtArea
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void read(JTextArea txtArea) throws FileNotFoundException, IOException{
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String str; 
            
        while ((str = in.readLine()) != null) { //dopóki  BufferedReader czyta linijki tekstu z pliku o nazwie filename
                txtArea.append(str+"\n"); //wczytuj linijki tekstu z pliku i dodawaj znak nowej linii po każdej 
            }
        } catch (IOException e) {
        } finally {
            try { in.close(); } catch (Exception ex) { }
        }

  } 
}
