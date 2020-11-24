/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import maladash.src.components.Models.TableModel;
/**
 *
 * @author USER
 */
public class TableView extends JPanel{
    private TableModel model;
    public TableView(int sit){
        model = new TableModel(sit);
    }
 
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(model.getImg(), 0, 0, this);
    }
}
