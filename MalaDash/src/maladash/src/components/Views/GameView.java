package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import maladash.src.components.Models.MainGameModel;

public class GameView {

    //Coponents
    private JFrame frame;
    //Integer
    private int width = 1920;
    private int height = 1080;
    
    private Image iconImage;

    public void init() {
        //Initate
        frame = new JFrame("MalaDash: JiaRush in the billions");

        frame.setIconImage(iconImage);
        frame.setSize(width, height);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
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

    public Image getIconImage() {
        return iconImage;
    }

    public void setIconImage(Image iconImage) {
        this.iconImage = iconImage;
    }
    
    

}
