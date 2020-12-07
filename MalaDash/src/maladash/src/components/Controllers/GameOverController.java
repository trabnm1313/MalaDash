/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import maladash.src.components.Models.GameOverModel;
import maladash.src.components.Views.GameOverView;
/**
 *
 * @author USER
 */
public class GameOverController implements ActionListener{
    private GameOverView view;
    private GameOverModel model;
    private MainMenuController menu;
    private GameController game;
    private TableController table;
    private MainGameController mainGame;
    
    public GameOverController() {
        
        model = new GameOverModel();
        view = new GameOverView();
        view.setImg(model.getImg());
        view.setLayout(null);
        
        view.add(view.getTryagain());
        view.add(view.getExited());
        
        
        
        view.getTryagain().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getTryagain())){
            
            mainGame = new MainGameController();
            
            mainGame.setGame(game);
            
            //Short Variable
            JFrame gameFrame = game.getView().getFrame();

            //Change ContentPane from MainMenu to MainGame
            gameFrame.setContentPane(mainGame.getView());
            gameFrame.setSize(1920, 1080);

            gameFrame.getContentPane().revalidate();
            gameFrame.getContentPane().repaint();
            gameFrame.setVisible(true);
        }
        if(e.getSource().equals(view.getExited())){
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

    public GameOverView getView() {
        return view;
    }

    public void setView(GameOverView view) {
        this.view = view;
    }

    public GameOverModel getModel() {
        return model;
    }

    public void setModel(GameOverModel model) {
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

    public TableController getTable() {
        return table;
    }

    public void setTable(TableController table) {
        this.table = table;
    }
    
}
