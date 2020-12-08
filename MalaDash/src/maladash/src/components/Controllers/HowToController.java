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
    private Clip bgm, bgm2;
    
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
            bgm2.setFramePosition(0);
            bgm2.start();
            menu = new MainMenuController();
            menu.setBgm(bgm);
            menu.setBgm2(bgm2);
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

    public Clip getBgm() {
        return bgm;
    }

    public void setBgm(Clip bgm) {
        this.bgm = bgm;
    }

    public Clip getBgm2() {
        return bgm2;
    }

    public void setBgm2(Clip bgm2) {
        this.bgm2 = bgm2;
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
