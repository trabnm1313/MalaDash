package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import maladash.src.components.Models.MainGameModel;

public class MainGameView{
    //Coponents
    private JFrame frame;
    private JPanel backGroundPanel, player;
    private BufferedImage img;
    //Integer
    private int width = 1980;
    private int height = 1020;
    
    public void init(){
        //Initate
        this.player = player;
        frame = new JFrame();
        backGroundPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponents(g);
                
                Graphics2D g2D = (Graphics2D) g;
                g2D.drawImage(img, 0, 0, this);
            }
        };
        backGroundPanel.setLayout(null);
        
        player.setBounds(50, 50, 200, 200);
        
        backGroundPanel.add(player);
        
        //Add to frame
        frame.add(backGroundPanel);
        
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }  
    
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getBackGroundPanel() {
        return backGroundPanel;
    }

    public void setBackGroundPanel(JPanel backGroundPanel) {
        this.backGroundPanel = backGroundPanel;
    }

    public JPanel getPlayer() {
        return player;
    }

    public void setPlayer(JPanel player) {
        this.player = player;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
