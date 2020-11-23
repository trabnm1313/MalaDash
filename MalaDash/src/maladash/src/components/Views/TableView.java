/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 *
 * @author USER
 */
public class TableView extends JPanel{
    public TableView(){
        this.setPreferredSize(new Dimension(150, 150));
    }
    
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        Graphics2D g2D = (Graphics2D) g;
        g.setColor(Color.black);
        g.fillRect(0, 0, (int)this.getSize().getWidth(), (int)this.getSize().getHeight());
    }
}
