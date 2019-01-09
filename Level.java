
package Orion.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * klasa Level której obiektami są trzy dostępne poziomy gry
 * @author karolinaandruszkiewicz
 */
public class Level {
    /**lista cykli w danym poziomie*/
    public List<Cycle> cycles; 
    /**indeks cyklu w liście cykli */
    public int currentCycle; 
    /**ikona poziomu*/
    public String icon; 
    
    /**
     * konstruktor poziomu
     */
    Level(){
        this.cycles = new ArrayList<Cycle>();
        currentCycle=0;     
    }
    /**
     * funkcja pobierająca i zwracająca obecny cykl 
     * @return 
     */
    public Cycle getCurrentCycle() { 
        return this.cycles.get(currentCycle);
    }

    
}
