/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;
import java.awt.Color;
import java.awt.Point;
/**
 *
 * @author mcstutzman
 */
public class Organism {
    int randNum;
    Point location ;
    int turn;
    int bred;
    PredatorPreySimulator sim;
    
    
    
    public Organism(Point loc, int turns, PredatorPreySimulator newSim){
        location = loc;
        turn = turns;
        bred = 0;
        sim = newSim;
        
    }
    
    public void move(){        
        randNum = (int)(Math.random()*4);
        int destination;
        Point newPoint = null;
        int icon = sim.grid[location.x][location.y].getIcon();
        
        if(this.turn < sim.turnCounter){            
        
            if(randNum == 0){ //move up
                newPoint = new Point(this.location.x, this.location.y-1);                 
            }
            else if (randNum == 1){//move right
                newPoint = new Point(this.location.x+1, this.location.y);
            }
            else if (randNum == 2){ //move down
                newPoint = new Point(this.location.x, this.location.y+1);
            }           
            else if (randNum == 3){//move left
                newPoint = new Point(this.location.x-1, this.location.y);
            }
            destination = sim.adjacent(newPoint);
            if(destination == 0){                
                sim.oGrid[newPoint.x][newPoint.y]=this;            
                sim.oGrid[location.x][location.y]=null;
                sim.grid[newPoint.x][newPoint.y].setType(this.toString(),icon);
                sim.grid[location.x][location.y].setType("empty");
                this.location = newPoint;
                this.turn++;
            }
            else{
                this.turn++;
            }
            
        }
    }
    public void breed(){
        String type = this.toString();
        int icon = sim.grid[location.x][location.y].getIcon();
        Point loc;        
        Point up = new Point(this.location.x, this.location.y-1);
        Point down = new Point (this.location.x, this.location.y+1);
        Point left = new Point (this.location.x-1, this.location.y);
        Point right = new Point(this.location.x+1, this.location.y);
            
        if (sim.adjacent(up) == 0){
            loc = up;                
        }
        else if (sim.adjacent(down) == 0){
            loc = down;                
        }
        else if(sim.adjacent(left) == 0){
            loc = left;
        }
        else if(sim.adjacent(right) == 0){
            loc = right;
        }
        else{
            loc = null;
            }
        if(loc != null){
            if(type.equalsIgnoreCase("ant")){
                sim.oGrid[loc.x][loc.y] = new Ant(loc, sim.turnCounter, sim);
                sim.grid[loc.x][loc.y].setType(type, icon);
                sim.grid[loc.x][loc.y].setBackground(Color.pink);
                this.bred = 3;
                }
            else{
                sim.oGrid[loc.x][loc.y]= new Doodlebug(loc, sim.turnCounter, sim);
                sim.grid[loc.x][loc.y].setType(type, icon);
                sim.grid[loc.x][loc.y].setBackground(Color.pink);
                this.bred = 8;
                }
            }
        }
    public void starve(){
   
    }
    
   
    
}
