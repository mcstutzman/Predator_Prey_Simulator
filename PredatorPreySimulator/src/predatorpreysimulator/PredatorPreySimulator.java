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
public class PredatorPreySimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new SimulationFrame().setVisible(true);
    }
    
    public CellPanel[][] grid;
    public Organism[][] oGrid;
    int numOfRows, numOfCols, numOfDoodlebugs, numOfAnts, eaten, starved;
    Point loc;
    int turnCounter;
    
    public PredatorPreySimulator(int rows, int cols, int bugs, int ants ){
        numOfRows = rows;        
        numOfCols = cols;
        numOfDoodlebugs = bugs;
        numOfAnts = ants;
        oGrid = new Organism[numOfRows][numOfCols];
        grid = null;
        loc = null;
        turnCounter = 0;
        eaten = 0;
        starved = 0;
        
        
    }
    
    public void setGrid(CellPanel[][] newGrid){
        grid = newGrid;
    }
    public String toString(){
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < numOfCols; j++){
                System.out.println(oGrid[i][j]);
            }            
        }
        return "end";
    }
    
    public void addOrgs(){
        for (int d = 0; d < numOfDoodlebugs; d++){
            loc = new Point ((int)(Math.random()*numOfRows), (int)(Math.random()*numOfCols));
            while (oGrid[loc.x][loc.y] != null){
                loc = new Point((int)(Math.random()*numOfRows), (int)(Math.random()*numOfCols));
            }
            oGrid[loc.x][loc.y] = new Doodlebug(loc, turnCounter, this);           
            grid[loc.x][loc.y].setType("doodlebug");
            
            
            //System.out.println("bug");
        }
        for (int a = 0; a < numOfAnts; a++){
            loc = new Point ((int)(Math.random()*numOfRows), ((int)Math.random()*numOfCols));
            while (oGrid[loc.x][loc.y] != null){
                loc = new Point((int)(Math.random()*numOfRows), (int)(Math.random()*numOfCols));
            }
            oGrid[loc.x][loc.y] = new Ant(loc, turnCounter, this);
            grid[loc.x][loc.y].setType("ant");            
            
            //System.out.println("ant");
        }
        
    }
    public int adjacent(Point loc){
        try{
            if(oGrid[loc.x][loc.y] == null){
            return 0;
            }
            else if (oGrid[loc.x][loc.y].getClass().equals(Ant.class) ){
            return 1;
            }
            else{
                return 2;
            }
        }
        catch(IndexOutOfBoundsException e){
            return 2;            
        }
    }
    
}
