package Orion.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * klasa Game tworząca obiekt gry przechowujący dane o obecnym poziomie, poziomie życia, cyklu
 * @author karolinaandruszkiewicz
 */
public class Game {
    /**lista poziomów*/
    public List<Level> levels; 
    /**indeks obecnego poziomu w liście poziomów*/
    public int currentLevel; 
    /**liczba "żyć"*/
    public int life; 
    /**ikona poziomu początkującego*/
    ImageIcon baby= new ImageIcon("baby.png");
    /**ikona poziomu średniozaawansowanego*/
    ImageIcon flower= new ImageIcon("flower.png");
    /**ikona poziomu zaawansowanego*/
    ImageIcon einstein= new ImageIcon("einstein.png");
    /**ikona trzech żyć*/
    ImageIcon hearts3= new ImageIcon("3hearts.png");
    /**ikona dwóch żyć*/
    ImageIcon hearts2= new ImageIcon("2hearts.png");
    /**ikona jendego życia*/
    ImageIcon heart1= new ImageIcon("1heart.png");
    
    /**
     * konstruktor bezargumentowy, tworzy grę na poziomie początkującym
     */
    
    Game(){ 
        this.levels = new ArrayList<Level>();
        this.levels.add(Data.beginner);
        this.currentLevel=0; 
        this.life=3; 
        
    }
    /**
     * konstruktor gry na wybranym poziomie przekazywanym w argumencie
     * @param currentLevel 
     */
     Game(int currentLevel){ 
        Data myData=new Data(); 
        myData.createQuestions();
        myData.createConnections();
        myData.createConstelations();
        myData.createCycles();
        myData.createLevels();
        this.currentLevel=currentLevel; 
        this.life=3; 
        this.levels = new ArrayList<Level>();
        this.levels.add(Data.beginner); 
        this.levels.add(Data.intermediate); 
        this.levels.add(Data.advanced);  
    }
    /**
     * funkcja zwracająca indeks obecnego poziomu gry z listy poziomów
     * @return 
     */
    public Level getCurrentLevel() { 
        return this.levels.get(currentLevel);
    }
    /**
     * funkcja zwracająca obecny cykl
     * @return 
     */
    public Cycle getCurrentCycle(){ 
        return this.getCurrentLevel().getCurrentCycle();
    }
    /**
     * funkcja sprawdzająca wynik cyklu 
     */
    public void checkCyclePoints(){ 
        if (this.getCurrentCycle().score>=9) { //wymóg przejścia cyklu : minimum 8 pkt, czyli 80% z 12 pkt możliwych do zdobycia
            if(this.getCurrentLevel().currentCycle!=2){ //jeśli cykl nie jest ostatnim cyklem poziomu
                this.getCurrentLevel().currentCycle++;
                this.getCurrentCycle().score=0;
                GameWindow.changed= true; 
                } 
                    else if (this.currentLevel!=2){ //jeśli poziom nie jest poziomem ostatnim to zwiększ go
                        this.currentLevel++; 
                        this.getCurrentLevel().currentCycle=0; 
                        this.getCurrentCycle().score=0;
                        GameWindow.changed= true; 
                    }
        } 
                       else {this.life--; //w przeciwym wypadku odejmij jedno życie
                        GameWindow.changed= false;}

    } 
    /**
     * funkcja zmieniająca ikonę poziomu w lewym panelu 
     */
    public void changeIcon(){ 
        if(this.currentLevel==0)
            GameWindow.level.setIcon(baby); 
        else if (this.currentLevel==1){
            GameWindow.level.setIcon(flower); 
        }
        else if (this.currentLevel==2){
            GameWindow.level.setIcon(einstein); 
        }
    }
    /**
     * funkcja zmieniająca ikony serc ("żyć") w lewym panelu
     */
    public void changeheart(){ 
        if(this.life==3)
            GameWindow.life.setIcon(hearts3); 
        else if (this.life==2){
            GameWindow.life.setIcon(hearts2); 
        }
        else if (this.life==1){
            GameWindow.life.setIcon(heart1); 
        }
        else if (this.life==0){
            GameWindow.life.setIcon(null); 
        }
        
    }
  
}

