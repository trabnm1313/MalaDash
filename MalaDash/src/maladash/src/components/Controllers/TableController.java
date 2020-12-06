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
    private boolean entered;

    public TableController(int numTable, int sit) {
        tableModel = new TableModel(numTable, sit);
        tableView = new TableView();
        tableView.setImg(tableModel.getImg());
        tableView.addMouseListener(this);
        tableView.setOpaque(false);
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
        tableView.getBounds().translate(300, 250);
        //get value on playerController
        boolean playerReady = playerController.getModel().getPlayer().isReady();
        boolean playerCarryOrder = playerController.getModel().getPlayer().isCarryOrder();
        boolean playerCarryDish = playerController.getModel().getPlayer().isCarryDish();
        boolean playerWashing = playerController.getModel().getPlayer().isWashing();
        //move
        playerController.travel(tableModel.getTable().getNumTable());
        System.out.println("[Player]: Move to Table #" + tableModel.getTable().getNumTable());

        //same table?
        if (playerReady && playerController.getModel().getPlayer().getWhichTable() == tableModel.getTable().getNumTable()) {

            //sitable
            if (!tableModel.getTable().isSitable()) {

                //order ยังไม่เสร็จ
                if (!playerCarryOrder && !playerCarryDish && !playerWashing) {
                    playerController.getModel().getPlayer().setBill(tableModel.getTable().getNumTable());
                    playerController.getModel().getPlayer().setCarryOrder(true);
                    System.out.println("[Table]: Get Order Table #" + tableModel.getTable().getNumTable());
                }

                //Serve ยังไม่เสร็จ
                if (playerCarryDish && (playerController.getModel().getPlayer().getMala().getNumTable() == tableModel.getTable().getNumTable())) {
                    playerController.getModel().getPlayer().setCarryDish(false);
                    playerController.getModel().getPlayer().setMala(null);
                    System.out.println("[Table]: Serve Mala Table #" + tableModel.getTable().getNumTable());
                }

                //เก็บตัง ยังไม่เสร็จ
                if (true) {
                    money = (int) (10 + (Math.random() * 20)) + Integer.parseInt(getText().getText());
                    System.out.println(money);
                    text.setText(money + "");
                }
            } else {
                //dirty
                if (tableModel.getTable().isDirty() && !playerCarryOrder && !playerCarryDish && !playerWashing) {
                    System.out.println("Done.");
                    tableModel.getTable().setDirty(false);
                    playerController.getModel().getPlayer().setWashing(true);
                    notDirty();
                }
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
        setEntered(true);
        System.out.println(isEntered());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setEntered(false);
        System.out.println(isEntered());
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
//dirty table
    public void letDirty() {
        tableModel.init("table" + tableModel.getTable().getNumTable() + "_d.png");
        tableView.setImg(tableModel.getImg());
    }
// clean table
    public void notDirty() {
        tableModel.init("table" + tableModel.getTable().getNumTable() + ".png");
        tableView.setImg(tableModel.getImg());
    }

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }
    
}
