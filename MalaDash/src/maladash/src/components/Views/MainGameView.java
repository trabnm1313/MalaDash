package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainGameView extends JPanel{
    //Coponents
    private BufferedImage img;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D)g;
        g.drawImage(img, 0, 0, this);
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
        this.revalidate();
        this.repaint();
    }
    
}

