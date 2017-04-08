/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predatorpreysimulator;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author mcstutzman
 */
public class DataOutput {
    int antsBred;
    int dBugsBred;
    int antsEaten;
    int totalOrgs;
    int totalTurns;
    int dBugsStarved;
    PredatorPreySimulator sim;
    
    public DataOutput(PredatorPreySimulator newSim){
        sim = newSim;
        antsBred = sim.numOfAnts;
        dBugsBred = sim.numOfDoodlebugs;
        antsEaten = sim.eaten;
        dBugsStarved = sim.starved;
        totalOrgs = sim.numOfAnts + sim.numOfDoodlebugs;
        totalTurns = sim.turnCounter;
        
        PrintWriter oStream;
        try{
            oStream = new PrintWriter(new FileOutputStream("SimulationData.txt", true));
            oStream.println("Total Turns: " + totalTurns);
            oStream.println("Total Organisms: " + totalOrgs);
            oStream.println(antsBred + " ants were created and " + antsEaten + " were eaten.");
            oStream.println(dBugsBred + " doodlebugs were created and " + dBugsStarved + " starved to death.");
            oStream.println();
            oStream.close();
            
        }
        catch(FileNotFoundException e){
            System.out.println("Where the file at?  Dummy.");
        }
        
    }
    
            
    
}
