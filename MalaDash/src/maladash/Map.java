package maladash;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Map extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 50, 720);
    }
}
