/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Models;
import maladash.src.components.Classes.Table;
/**
 *
 * @author USER
 */
public class TableModel {
    private Table table1;
    private Table table2;
    private Table table3;
    private Table table4;

    public TableModel() {
        table1 = new Table(4, true);
        table2 = new Table(4, true);
        table3 = new Table(2, true);
        table4 = new Table(2, true);
    }

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table table1) {
        this.table1 = table1;
    }

    public Table getTable2() {
        return table2;
    }

    public void setTable2(Table table2) {
        this.table2 = table2;
    }

    public Table getTable3() {
        return table3;
    }

    public void setTable3(Table table3) {
        this.table3 = table3;
    }

    public Table getTable4() {
        return table4;
    }

    public void setTable4(Table table4) {
        this.table4 = table4;
    }

}
