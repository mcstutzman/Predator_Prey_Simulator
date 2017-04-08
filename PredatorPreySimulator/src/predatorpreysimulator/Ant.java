/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;
import java.awt.Point;
/**
 *
 * @author mcstutzman
 */
public class Ant extends Organism{    
    
    
    public Ant(Point loc, int turns, PredatorPreySimulator newSim){
        super(loc, turns, newSim);
        this.bred = 3;        
    }
    public String toString(){
        return "Ant";
    }
    
    public void breed(){
       if (this.bred > 0){
            this.bred--;
        }
        else{
           sim.numOfAnts++;
           super.breed();
       }
    }
    
}
