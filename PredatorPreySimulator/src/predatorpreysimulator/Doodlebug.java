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
public class Doodlebug extends Organism{
    public int starve;   
    
    
    
    public Doodlebug(Point loc, int turns, PredatorPreySimulator newSim){
        super(loc, turns, newSim);
        starve = 0;
        this.bred = 8;       
    }
    public String toString(){
        return "Doodlebug";
    }
    
    public void move(){
        Point up = new Point(this.location.x, this.location.y-1);
        Point down = new Point (this.location.x, this.location.y+1);
        Point left = new Point (this.location.x-1, this.location.y);
        Point right = new Point(this.location.x+1, this.location.y);
        int icon = sim.grid[location.x][location.y].getIcon();
        int x = location.x;
        int y = location.y;
        if(this.turn < sim.turnCounter){
            
            if (sim.adjacent(up) == 1){                    
                sim.oGrid[up.x][up.y]=this;
                sim.grid[up.x][up.y].setType("doodlebug",icon);
                sim.grid[up.x][up.y].setBackground(Color.green);
                sim.oGrid[location.x][location.y]=null;
                sim.grid[location.x][location.y].setType("empty");
                this.location = up;
                this.starve = 0;
                this.turn++;
                sim.eaten++;
            }
            else if (sim.adjacent(down)== 1){
                sim.oGrid[down.x][down.y]=this;
                sim.grid[down.x][down.y].setType("doodlebug",icon);
                sim.grid[down.x][down.y].setBackground(Color.green);
                sim.oGrid[location.x][location.y]=null;
                sim.grid[location.x][location.y].setType("empty");
                this.location = down;
                this.starve = 0;
                this.turn++;
                sim.eaten++;

            }
            else if (sim.adjacent(left)==1){
                sim.oGrid[left.x][left.y]=this;
                sim.grid[left.x][left.y].setType("doodlebug",icon);
                sim.grid[left.x][left.y].setBackground(Color.green);
                sim.oGrid[location.x][location.y]=null;
                sim.grid[location.x][location.y].setType("none");
                this.location = left;
                this.starve = 0;
                this.turn++;
                sim.eaten++;
            }
            else if (sim.adjacent(right)==1){
                sim.oGrid[right.x][right.y]=this;
                sim.grid[right.x][right.y].setType("doodlebug",icon);
                sim.grid[right.x][right.y].setBackground(Color.green);
                sim.oGrid[location.x][location.y]=null;
                sim.grid[location.x][location.y].setType("empty");
                this.location = right;
                this.starve = 0;
                this.turn++;
                sim.eaten++;
            }
            else{
                starve++;
                super.move();
            }
        }
            
        
    }
    public void starve(){
        if (this.starve >= 3){
            sim.oGrid[location.x][location.y] = null;  //starved to death
            sim.grid[location.x][location.y].setType("empty");
            sim.grid[location.x][location.y].setBackground(Color.black);
            sim.starved++;
        }
    }
    public void breed(){
        if (this.bred > 0){
            this.bred--;
        }
        else{
            sim.numOfDoodlebugs++;
            super.breed();
        }
    }
}
