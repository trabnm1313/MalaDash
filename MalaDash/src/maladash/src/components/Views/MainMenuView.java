
package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;
import maladash.src.components.Controllers.MainMenuController;

public class MainMenuView{
    //JComponents
    private JFrame frame;
    private JPanel backGroundPanel;
    private JButton startButton, optionButton, exitButton;
    //Integer
    private int width = 1280;
    private int height = 720;
    
    public MainMenuView(BufferedImage img){
        
        //Container Initate
        frame = new JFrame();
        backGroundPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponents(g);
                
                Graphics2D g2D = (Graphics2D)g;
                g2D.drawImage(img ,0 ,0 ,this);
            }
        };
        startButton = new JButton("Start");
        optionButton = new JButton("Option");
        exitButton = new JButton("Exit");
        
        //backGroundPanel Configuration
        backGroundPanel.setLayout(new GridBagLayout());
        backGroundPanel.setBorder(new EmptyBorder(0, width/3, 0, width/3));
        
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
        backGroundPanel.add(startButton, constraint);
        constraint.gridy = 1;
        backGroundPanel.add(optionButton, constraint);
        constraint.gridy = 2;
        backGroundPanel.add(exitButton, constraint);
        
        //Add to frame
        frame.add(backGroundPanel);
        
        //Frame Configuration
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
