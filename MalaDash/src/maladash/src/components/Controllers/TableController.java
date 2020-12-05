/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import maladash.src.components.Models.TableModel;
import maladash.src.components.Views.TableView;
import maladash.src.components.Controllers.PlayerController;

import java.awt.event.*;

/**
 *
 * @author USER
 */
public class TableController implements MouseListener {

    private TableModel tableModel;
    private TableView tableView;

    public TableController(int numTable, int sit) {
        tableModel = new TableModel(numTable, sit);
        tableView = new TableView();
        tableView.setImg(tableModel.getImg());
        tableView.addMouseListener(this);
        
        if(numTable == 1){
            tableView.setBounds(650, 500, 400, 200);
        }else if (numTable == 2){
            tableView.setBounds(650, 750, 400, 200);
        }else if (numTable == 3){
            tableView.setBounds(1250, 500, 400, 200);
        }else if (numTable == 4){
            tableView.setBounds(1250, 750, 400, 200);
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
        System.out.println("hello");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("IN");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("OUT");
    }

}
