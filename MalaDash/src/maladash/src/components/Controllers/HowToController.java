/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import maladash.src.components.Models.HowToModel;
import maladash.src.components.Views.HowToView;
/**
 *
 * @author USER
 */
public class HowToController implements ActionListener{
    private HowToView view;
    private HowToModel model;
    private MainMenuController menu;
    private GameController game;
    
    public HowToController() {
        
        model = new HowToModel();
        view = new HowToView();
        view.setImg(model.getImg());
        view.setLayout(null);
        
        view.add(view.getBack());
        
        
        
        view.getBack().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getBack())){
            
            menu = new MainMenuController();
            
            menu.setGame(game);
            
            //Short Variable
            JFrame gameFrame = game.getView().getFrame();

            //Change ContentPane from MainMenu to MainGame
            gameFrame.setContentPane(menu.getView());
            gameFrame.setSize(1920, 1080);

            gameFrame.getContentPane().revalidate();
            gameFrame.getContentPane().repaint();
            gameFrame.setVisible(true);
        }
    }

    public HowToView getView() {
        return view;
    }

    public void setView(HowToView view) {
        this.view = view;
    }

    public HowToModel getModel() {
        return model;
    }

    public void setModel(HowToModel model) {
        this.model = model;
    }

    public MainMenuController getMenu() {
        return menu;
    }

    public void setMenu(MainMenuController menu) {
        this.menu = menu;
    }

    public GameController getGame() {
        return game;
    }

    public void setGame(GameController game) {
        this.game = game;
    }
    
    
    
}
