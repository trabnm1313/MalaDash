package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameOverView extends JPanel{
    //Coponents
    private Image img;
    private JButton tryagain, exited;

    public GameOverView() {
        
        tryagain = new JButton("Try Agian");
        
        tryagain.setFont(new Font("Arial", Font.BOLD, 24));
        tryagain.setSize(100, 50);
        tryagain.setBounds(100, 1000, 100, 50);
        
        exited = new JButton("Back To Menu");
        
        exited.setFont(new Font("Arial", Font.BOLD, 24));
        exited.setSize(100, 50);
        exited.setBounds(1800, 1000, 100, 50);
        
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

    public JButton getTryagain() {
        return tryagain;
    }

    public void setTryagain(JButton tryagain) {
        this.tryagain = tryagain;
    }

    public JButton getExited() {
        return exited;
    }

    public void setExited(JButton exited) {
        this.exited = exited;
    }

    
    
}

