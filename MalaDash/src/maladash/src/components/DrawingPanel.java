
package maladash.src.components;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawingPanel extends JPanel {
    private BufferedImage img;
    
    public DrawingPanel(String fileName){
        URL src = DrawingPanel.class.getResource("../images/" + fileName);
        try{
            img = ImageIO.read(src);
        }catch(IOException err){
            err.printStackTrace();
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}
