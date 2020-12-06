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
    private static JLabel text;

    public TableController(int numTable, int sit) {
        tableModel = new TableModel(numTable, sit);
        tableView = new TableView();
        tableView.setImg(tableModel.getImg());
        tableView.addMouseListener(this);
        
        if(numTable == 1){
            tableView.setBounds(700, 550, 400, 200);
        }else if (numTable == 2){
            tableView.setBounds(450, 750, 400, 200);
        }else if (numTable == 3){
            tableView.setBounds(1200, 550, 400, 200);
        }else if (numTable == 4){
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
        money = (int)(10+(Math.random()*20)) + Integer.parseInt(getText().getText());
        System.out.println(money);
        text.setText(money+"");
        if (!tableModel.getTable().isSitable()) {
            if (tableModel.getTable().isDrity()) {
                System.out.println("Done.");
                tableModel.getTable().setDrity(false);
                
            } else {
                System.out.println("Not yet.");
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
        System.out.println("IN");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("OUT");
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

    
}
