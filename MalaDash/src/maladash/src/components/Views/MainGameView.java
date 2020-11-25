package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import maladash.src.components.Models.MainGameModel;

public class MainGameView{
    //Coponents
    private JFrame frame;
    private JPanel backGroundPanel;
    //Integer
    private int width = 1980;
    private int height = 1020;
    
     
    public MainGameView(BufferedImage img){
        //Initate
        frame = new JFrame();
        backGroundPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponents(g);
                
                Graphics2D g2D = (Graphics2D) g;
                g2D.drawImage(img, 0, 0, this);
            }
        };
        
        //Add to frame
        frame.add(backGroundPanel);
        
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
    }
}
