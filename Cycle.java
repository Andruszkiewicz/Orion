package Orion.Model;

/**
 * klasa Cycle - cyckl gry (każdy poziom składa się z trzech cykli)
 * @author karolinaandruszkiewicz
 */
public class Cycle {
    /**konstelacja pierwsza danego cyklu*/
    public Constelation constelation1; 
    /**konstelacja druga danego cyklu*/
    public Constelation constelation2; 
    /**liczba punktów uzyskana w cyklu*/
    public int score; 
    /**
     * Konstruktor argumentowy cyklu
     * @param constelation1
     * @param constelation2 
     */
    Cycle(Constelation constelation1,Constelation constelation2){
        this.constelation1= constelation1; 
        this.constelation2= constelation2; 
        this.score=0; 
    }
    /**
     * konstruktor bezargumentowy konstelacji
     */
    Cycle(){
        
    }
    
}
