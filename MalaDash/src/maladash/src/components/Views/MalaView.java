/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author USER
 */
public class MalaView extends JPanel{
    private BufferedImage img;
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(img, 0, 0, this);
        g2D.setColor(Color.black);
//        g2D.drawRect(0, 0, (int)this.getSize().getWidth(), (int)this.getSize().getHeight());
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
