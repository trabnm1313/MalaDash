package maladash;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class MainMenu {
    //Declare attribute
    private Map mapping = new Map();
    private JFrame frame;
    private JPanel buttonPanel, leftPanel, rightPanel;
    private JButton startButton, optionButton, exitButton;
    
    //Declare and create object
    private int width = 1280;
    private int height = 720;
    
    public MainMenu(){
        //Create object
        //JFrame
        frame = new JFrame("MalaDash");
        //JPanel
        buttonPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        
        //JButton
        startButton = new JButton("Start");
        optionButton = new JButton("Option");
        exitButton = new JButton("Exit");
        
        //Frame Modification
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //JPanel Modification
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBorder(new EmptyBorder(0, width/3, 0, width/3));
        
        
        //Grid Constraint
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.weightx = 1;
        constraint.weighty = 1;
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.ipady = 75;
        
        //startButton Modification
        constraint.gridwidth = 1;
        constraint.gridheight = 1;
        constraint.gridx = 0;
        
        //Actually Buttons
        constraint.gridy = 0;
        buttonPanel.add(startButton, constraint);
        constraint.gridy = 1;
        buttonPanel.add(optionButton, constraint);
        constraint.gridy = 2;
        buttonPanel.add(exitButton, constraint);
        
        constraint.gridy = 0;
        buttonPanel.add(mapping, constraint);
        
        

        //Added to frame
        frame.add(buttonPanel);
        frame.setVisible(true);
        
    }
}
