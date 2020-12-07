package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class HowToView extends JPanel{
    //Coponents
    private Image img;
    private JButton back;

    public HowToView() {
        
        back = new JButton("Back");
        
        back.setFont(new Font("Arial", Font.BOLD, 24));
        back.setSize(100, 50);
        back.setBounds(100, 1000, 100, 50);
        
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D)g;
        g.drawImage(img, 0, 0, this);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        this.revalidate();
        this.repaint();
    }

    public JButton getBack() {
        return back;
    }

    public void setBack(JButton back) {
        this.back = back;
    }
    
}

