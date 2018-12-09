/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.Model;

/**
 *
 * @author karolinaandruszkiewicz
 */
public class Cycle {
    public Constelation constelation1; 
    public Constelation constelation2; 
    public int score; 
    Cycle(Constelation constelation1,Constelation constelation2){
        this.constelation1= constelation1; 
        this.constelation2= constelation2; 
        this.score=0; 
    }
    
}
