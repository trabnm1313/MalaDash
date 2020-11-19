package maladash.src.components.Views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MainGameView extends JPanel{
    
    public MainGameView(){
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        Graphics2D g2D = (Graphics2D) g;
        
        g2D.setBackground(Color.black);
        g2D.fillRect(50, 50, 1180, 620);
    }
}
