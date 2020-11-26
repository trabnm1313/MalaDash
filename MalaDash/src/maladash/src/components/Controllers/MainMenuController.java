
package maladash.src.components.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import maladash.src.components.Models.MainMenuModel;
import maladash.src.components.Views.MainMenuView;

public class MainMenuController implements ActionListener{
    private MainMenuView view;
    private MainMenuModel model;
    
    public MainMenuController(){
        //Init
        model = new MainMenuModel();
        view = new MainMenuView(model.getImg());
        //Add ActionListener
        view.getStartButton().addActionListener(this);
        view.getOptionButton().addActionListener(this);
        view.getExitButton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //IF startButton clicked
        if(e.getSource().equals(view.getStartButton())){
            
            //Initate Controller
            PlayerController p1 = new PlayerController();
            MainGameController mainGame = new MainGameController();
            
            //Set attribute in model
            mainGame.getModel().setPlayer(p1.getView());
            
            //Init mainGameView
            mainGame.init();
            
            view.getFrame().dispose();
        }
        
        //IF exitButton clicked
        if(e.getSource().equals(view.getOptionButton())){
            JDialog dialog = new JDialog(new JFrame(), "WIP");
            dialog.setLocation(view.getWidth()/2, view.getHeight()/2);
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
        if(e.getSource().equals(view.getExitButton())){
            JDialog dialog = new JDialog(new JFrame(), "Exit?");
            dialog.setLocation(view.getWidth()/2, view.getHeight()/2);
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
