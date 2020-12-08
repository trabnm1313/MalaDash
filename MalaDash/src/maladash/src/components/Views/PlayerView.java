package maladash.src.components.Views;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PlayerView extends JPanel{
    Image img;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D) g;
//        g2D.drawRect(0, 0, (int)this.getSize().getWidth(), (int)this.getSize().getHeight());
        g2D.drawImage(img, 0, 0, this);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        this.revalidate();
        this.repaint();
    }
    
    
}
