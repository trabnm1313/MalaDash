/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.Clip;
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
    private NewRecordController rec;
    
    public void init() {
        
        model = new GameOverModel();
        view = new GameOverView();
        view.setImg(model.getImg());
        view.setLayout(null);
        rec = new NewRecordController();
        
        view.add(view.getTryagain());
        view.add(view.getExited());
        view.add(view.getHighScore());
        view.add(view.getScore());
        
        
        view.getTryagain().addActionListener(this);
        view.getExited().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getTryagain())){
            mainGame.resetBGM();
            mainGame = new MainGameController();
            mainGame.setMenu(game.getMenu());
            mainGame.setGame(game);
            mainGame.init();
            
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
            mainGame.stopBGM();
            menu = new MainMenuController();
            menu.setGame(game);
            menu.clickedSound();
            menu.startBGM();
            
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

    public MainGameController getMainGame() {
        return mainGame;
    }

    public void setMainGame(MainGameController mainGame) {
        this.mainGame = mainGame;
    }

    public NewRecordController getRec() {
        return rec;
    }

    public void setRec(NewRecordController rec) {
        this.rec = rec;
    }
    
    
}
