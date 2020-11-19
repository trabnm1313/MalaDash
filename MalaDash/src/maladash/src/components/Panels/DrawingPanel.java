package maladash.src.components.Panels;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawingPanel extends JPanel {
    private BufferedImage img;
    
    public DrawingPanel(String fileName){
        URL src = DrawingPanel.class.getResource("../../images/" + fileName);
        try{
            img = ImageIO.read(src);
        }catch(IOException err){
            err.printStackTrace();
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        Graphics2D g2D = (Graphics2D) g;
        
        g2D.drawImage(img, 0, 0, this);
        g2D.drawRect(50, 50, 50, 50);
        g2D.setColor(Color.white);
        g2D.fillRect(50, 50, 50, 50);
        
    }
}
