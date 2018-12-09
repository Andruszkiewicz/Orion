/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karolinaandruszkiewicz
 */
public class Level {
    public List<Cycle> cycles; 
    public int currentCycle; 
    
    Level(){
        Cycle first = new Cycle();
        
        this.cycles = new ArrayList<Cycle>();
        
        this.cycles.add(first);
        currentCycle=0; 
        
        
    }
    
    public Cycle getCurrentCycle() {
        return this.cycles.get(currentCycle);
    }
    
}
