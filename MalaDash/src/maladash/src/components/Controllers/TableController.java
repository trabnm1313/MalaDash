/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import java.awt.*;
import maladash.src.components.Models.TableModel;
import maladash.src.components.Views.TableView;

import java.awt.event.*;
import javax.swing.*;
import maladash.src.components.Classes.Customers;
import maladash.src.components.Models.CustomersModel;
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
    private SitCustomerController customersController = null;
    private static JLabel text;
    private int h = 281;
    private int w = 400;

    public TableController(int numTable, int sit) {
        tableModel = new TableModel(numTable, sit);
        tableView = new TableView();
        tableView.setImg(tableModel.getImg());
        tableView.addMouseListener(this);
        tableView.setOpaque(false);
        if (numTable == 1) {
            tableView.setBounds(675, 550, w, h);
        } else if (numTable == 2) {
            tableView.setBounds(250, 750, w, h);
        } else if (numTable == 3) {
            tableView.setBounds(1085, 550, w, h);
        } else if (numTable == 4) {
            tableView.setBounds(1500, 750, w, h);
        }
    }

    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }
    
    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //get value on playerController
        boolean playerReady = playerController.getModel().getPlayer().isReady();
        boolean playerCarryOrder = playerController.getModel().getPlayer().isCarryOrder();
        boolean playerCarryDish = playerController.getModel().getPlayer().isCarryDish();
        boolean playerWashing = playerController.getModel().getPlayer().isWashing();
        //move
        playerController.travel(tableModel.getTable().getNumTable());

        //same table?
        if (playerReady && playerController.getModel().getPlayer().getWhichTable() == tableModel.getTable().getNumTable()) {

            //sitable
            if (!tableModel.getTable().isSitable()) {
                Customers customer = customersController.getModel().getCustomers();
                //order
                if (customer.isReady() && !customer.isWait() && !customer.isEat() && !customer.isDone() && !playerCarryOrder && !playerCarryDish && !playerWashing ) {
                    playerController.getModel().getPlayer().setBill(tableModel.getTable().getNumTable());
                    playerController.getModel().getPlayer().setCarryOrder(true);
                    playerController.standWithBill();
                    
                    customer.setWait(true);
                    sit();
                }

                //Serve
                if (customer.isWait()&& playerCarryDish && (playerController.getModel().getPlayer().getMala().getNumTable() == tableModel.getTable().getNumTable())) {
                    playerController.getModel().getPlayer().setCarryDish(false);
                    playerController.getModel().getPlayer().setMala(null);
                    playerController.stand();
                    
                    customer.setEat(true);
                    customer.setWait(false);
                    int time = (int) (Math.random() * 5) + 10;
                    
                    customersController.setWaitTime(time);
                    
                    
                    customersController.setWaitTime(time);
                }

                //dirty
                if (customer.isDone()&& tableModel.getTable().isDirty() && !playerCarryOrder && !playerCarryDish && !playerWashing) {
                    customersController.setStopThis(true);
                    tableModel.getTable().setDirty(false);
                    playerController.getModel().getPlayer().setWashing(true);
                    notDirty();
                    playerController.standWithBin();
                    setCustomersController(null);

                    //collect money
                    money = (int) (10 + (Math.random() * 20)) + Integer.parseInt(getText().getText());
                    text.setText(money + "");
                    mainGame.getModel().setMoney(money);
                    tableModel.getTable().setSitable(true);
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

    public SitCustomerController getCustomersController() {
        return customersController;
    }

    public void setCustomersController(SitCustomerController customersController) {
        this.customersController = customersController;
    }
    
    
  
    //dirty table and done
    public void letDirty(int lv) {
        if(lv == 0){
            tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + "_done.png");
        }else if(lv == 1){
            tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + "_done_sad1.png");
        }else if(lv == 2){
            tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + "_done_sad2.png");
        }
        
        tableView.setImg(tableModel.getImg());
    }
  
    // clean table
    public void notDirty() {
        tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + ".png");
        tableView.setImg(tableModel.getImg());
    }
  
    public void sit() {
        tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + "_sit.png");
        tableView.setImg(tableModel.getImg());
    }

    public void handUp(int lv) {
        if(lv == 0){
            tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + "_handUp.png");
        }else if(lv == 1){
            tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + "_handUp_sad1.png");
        }else if(lv == 2){
            tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + "_handUp_sad2.png");
        }
        
        tableView.setImg(tableModel.getImg());
    }

    public void eating() {
        tableModel.init(tableModel.getTable().getNumTable(), "table" + tableModel.getTable().getNumTable() + "_eat.gif");
        tableView.setImg(tableModel.getImg());
    }
}
