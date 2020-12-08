
package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;

public class MainMenuView extends JPanel{
    //JComponents
    private Image img;
    private JButton startButton, optionButton, exitButton;
    //Integer
    private int width = 1920;
    private int height = 1080;
    
    public MainMenuView(){
        
        startButton = new JButton("Start");
        optionButton = new JButton("How to play");
        exitButton = new JButton("Exit");
        
        //backGroundPanel Configuration
        this.setLayout(new GridBagLayout());
        this.setBorder(new EmptyBorder(0, width/3, 0, width/3));
        
        //JButton Modification
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        optionButton.setFont(new Font("Arial", Font.BOLD, 24));
        exitButton.setFont(new Font("Arial", Font.BOLD, 24));
        
        //Grid Constraint
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.weightx = 1;
        constraint.weighty = 1;
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.ipady = 75;
        
        //buttonPanel Modification
        constraint.gridwidth = 1;
        constraint.gridheight = 1;
        constraint.gridx = 0;
        
        //Actually Buttons
        constraint.gridy = 0;
        this.add(startButton, constraint);
        constraint.gridy = 1;
        this.add(optionButton, constraint);
        constraint.gridy = 2;
        this.add(exitButton, constraint);
        
        System.out.println("[MainMenuView]: View loaded.");
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
    }
    
    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JButton getOptionButton() {
        return optionButton;
    }

    public void setOptionButton(JButton optionButton) {
        this.optionButton = optionButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
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
}
