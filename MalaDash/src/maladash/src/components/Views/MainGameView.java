package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import maladash.src.components.Models.MainGameModel;

public class MainGameView extends JPanel{
    MainGameModel model = new MainGameModel();
    
    public MainGameView(){
        //Find better way later
        this.setLayout(null);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(model.getImg(), 0, 0, this);
    }
}
