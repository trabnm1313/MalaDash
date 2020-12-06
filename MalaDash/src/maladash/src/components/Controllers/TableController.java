/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import maladash.src.components.Models.TableModel;
import maladash.src.components.Views.TableView;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class TableController implements MouseListener {

    private int money;
    private TableModel tableModel;
    private TableView tableView;
    private static MainGameController mainGame;
    private static PlayerController playerController;
    private static JLabel text;

    public TableController(int numTable, int sit) {
        tableModel = new TableModel(numTable, sit);
        tableView = new TableView();
        tableView.setImg(tableModel.getImg());
        tableView.addMouseListener(this);

        if (numTable == 1) {
            tableView.setBounds(700, 550, 400, 200);
        } else if (numTable == 2) {
            tableView.setBounds(450, 750, 400, 200);
        } else if (numTable == 3) {
            tableView.setBounds(1200, 550, 400, 200);
        } else if (numTable == 4) {
            tableView.setBounds(1450, 750, 400, 200);
        }
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //move
         playerController.travel(tableModel.getTable().getNumTable());
         System.out.println("[Player]: Move to Table #" + tableModel.getTable().getNumTable());
         
        //sitable
        if (tableModel.getTable().isSitable()) {
            
            //order
            if(playerController.getModel().getPlayer().isReady() && !playerController.getModel().getPlayer().isCarryOrder() && !playerController.getModel().getPlayer().isCarryDish()){
                playerController.getModel().getPlayer().setBill(tableModel.getTable().getNumTable());
                playerController.getModel().getPlayer().setCarryOrder(true);
                System.out.println("[Table]: Get Order Table #" + tableModel.getTable().getNumTable());
            }
                
            
            
            //dirty
            if (tableModel.getTable().isDirty()) {
                System.out.println("Done.");
                tableModel.getTable().setDirty(false);
                money = (int) (10 + (Math.random() * 20)) + Integer.parseInt(getText().getText());
                System.out.println(money);
                text.setText(money + "");

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    public static MainGameController getMainGame() {
        return mainGame;
    }

    public static void setMainGame(MainGameController mainGame) {
        TableController.mainGame = mainGame;
    }

    public static JLabel getText() {
        return text;
    }

    public static void setText(JLabel text) {
        TableController.text = text;
    }

    public static PlayerController getPlayerController() {
        return playerController;
    }

    public static void setPlayerController(PlayerController playController) {
        TableController.playerController = playController;
    }

    
}
