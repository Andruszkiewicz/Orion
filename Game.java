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
public class Game {
    public List<Level> levels;
    
    public int currentLevel; 
    public int score; 
    
    
    Game(){
        Level beginner = new Level();
        
        this.levels = new ArrayList<Level>();
        
        this.levels.add(beginner);
        this.currentLevel=0; 
        this.score=0; 
        
    }
    
    public Level getCurrentLevel() {
        return this.levels.get(currentLevel);
    }
    
    public Cycle getCurrentCycle() {
        return this.getCurrentLevel().getCurrenctCycle();
    }
    
    
}

