/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package predatorpreysimulator;

import java.awt.Color;

/**
 *
 * @author mcstutzman
 */
public class CellPanel extends javax.swing.JPanel {
    String type;
    int randNum;
    int icon;
    int x;
    int y;
    /**
     * Creates new form CellPanel
     */
    public CellPanel(int x, int y) {
        type = null;
        icon = -1;
        initComponents();       
        setBackground(Color.WHITE);
        
    }
    
    public void setType(String type){
        this.type = type;
        randNum = (int)(Math.random()*5);
        if (type.equalsIgnoreCase("doodlebug")){
            if (randNum == 0 || randNum == 1){
                iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/beard2.png")));
                this.icon = 7;
            }
            else{
                iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/beardPrime.jpg")));
                this.icon = 8;
            }
        }
        else if(type.equalsIgnoreCase("ant")){
            if (randNum == 0 || randNum == 1 || randNum == 2){
                iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pony" + randNum + ".png")));
                this.icon = randNum;
            }
            else{
                iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pony"+ randNum + ".jpg")));
                this.icon = randNum;
            }
        }
        else{
            iconLabel.setIcon(null);
        }
    }
    public void setType(String type, int icon){
        this.type = type;
        if (icon == 7){
            iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/beard2.png")));
            this.icon = 7;
        }
        else if (icon == 8){
            iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/beardPrime.jpg")));
            this.icon = 8;
        }
        else if (icon == 0 || icon == 1 || icon == 2){
            iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pony" + icon + ".png")));
            this.icon = icon;
        }
        else if (icon == 4 || icon == 5){
            iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pony"+ icon + ".jpg")));
            this.icon = icon;
        }
    }
    public String getType(){
        return this.type;
    }
    public int getIcon(){
        return this.icon;
    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        iconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(iconLabel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    // End of variables declaration//GEN-END:variables
}