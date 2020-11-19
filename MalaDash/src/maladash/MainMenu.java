package maladash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import maladash.src.components.Views.DrawingPanel;

public class MainMenu implements ActionListener{
    //Declare attribute
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
        
        //JPanel with BackgroundImage
        buttonPanel = new DrawingPanel("mockBGC.jpg");
        
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
        
        //JButton Modification
        startButton.setFont(new Font("Arial", Font.BOLD, 24));
        optionButton.setFont(new Font("Arial", Font.BOLD, 24));
        exitButton.setFont(new Font("Arial", Font.BOLD, 24));
        startButton.addActionListener(this);
        optionButton.addActionListener(this);
        exitButton.addActionListener(this);
        
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
        buttonPanel.add(startButton, constraint);
        constraint.gridy = 1;
        buttonPanel.add(optionButton, constraint);
        constraint.gridy = 2;
        buttonPanel.add(exitButton, constraint);

        //Added to frame
        frame.add(buttonPanel);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //IF startButton clicked
        if(e.getSource().equals(startButton)){
            JDialog dialog = new JDialog(frame, "¯\\_(( ͡° ͜ʖ ͡°)_/¯");
            dialog.setLocation(width/2, height/2);
            JPanel exitPanel = new JPanel();
            JLabel exitText = new JLabel("Coming sooon..", SwingConstants.CENTER);
            JButton yes = new JButton("Maybe"), no = new JButton("Sometimes");
            yes.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            no.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    dialog.dispose();
                }
            });
            
            exitPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.ipady = 10;
            gbc.ipadx = 40;
            gbc.fill = GridBagConstraints.BOTH;
            
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 0;
            exitPanel.add(exitText, gbc);
            
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 1;
            exitPanel.add(yes, gbc);
            
            gbc.gridx = 1;
            exitPanel.add(no, gbc);
            
            dialog.add(exitPanel);
            dialog.pack();
            dialog.setVisible(true);
        }
        
        //IF exitButton clicked
        if(e.getSource().equals(optionButton)){
            JDialog dialog = new JDialog(frame, "WIP");
            dialog.setLocation(width/2, height/2);
            JPanel exitPanel = new JPanel();
            JLabel exitText = new JLabel("Not yet.", SwingConstants.CENTER);
            JButton yes = new JButton("No"), no = new JButton("No");
            yes.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    dialog.dispose();
                }
            });
            no.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    dialog.dispose();
                }
            });
            
            exitPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.ipady = 10;
            gbc.ipadx = 40;
            gbc.fill = GridBagConstraints.BOTH;
            
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 0;
            exitPanel.add(exitText, gbc);
            
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 1;
            exitPanel.add(yes, gbc);
            
            gbc.gridx = 1;
            exitPanel.add(no, gbc);
            
            dialog.add(exitPanel);
            dialog.pack();
            dialog.setVisible(true);
        }
        
        //IF optionButton clicked
        if(e.getSource().equals(exitButton)){
            JDialog dialog = new JDialog(frame, "Exit?");
            dialog.setLocation(width/2, height/2);
            JPanel exitPanel = new JPanel();
            JLabel exitText = new JLabel("Are you sure?", SwingConstants.CENTER);
            JButton yes = new JButton("Yes"), no = new JButton("No");
            yes.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            no.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    dialog.dispose();
                }
            });
            
            exitPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.ipady = 10;
            gbc.ipadx = 40;
            gbc.fill = GridBagConstraints.BOTH;
            
            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 0;
            exitPanel.add(exitText, gbc);
            
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 1;
            exitPanel.add(yes, gbc);
            
            gbc.gridx = 1;
            exitPanel.add(no, gbc);
            
            dialog.add(exitPanel);
            dialog.pack();
            dialog.setVisible(true);
        }
        
    }
}

