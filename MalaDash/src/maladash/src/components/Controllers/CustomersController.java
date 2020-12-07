package maladash.src.components.Controllers;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import maladash.src.components.Models.CustomersModel;
import maladash.src.components.Views.CustomersView;

public class CustomersController implements ActionListener {

    private CustomersModel model;
    private CustomersView view;
    private ArrayList<TableController> tableControllers;
    private Timer tm = new Timer(1000, this);
    private int time;
    private Point prevPt, curPt, newPt;
    private Rectangle original;
    private int whichTable;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public CustomersController() {
        model = new CustomersModel();
        view = new CustomersView();

        time = (int) (Math.random() * 10) + 30;
        tm.start();

        view.setImg(model.getImgNormal());
        view.setOpaque(false);
        view.setBounds(500, 350, 100, 250);
        original = view.getBounds();

        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prevPt = SwingUtilities.convertPoint(view, e.getPoint(), view.getParent());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(checkCustomersTable() == false){
                    view.setBounds(original);
                }else{
                    prevPt = null;
                    view.setVisible(false);
                    
                    tm.stop();
                    
                    tableControllers.get(whichTable).getTableModel().getTable().setSitable(false);
                    tableControllers.get(whichTable).setCustomersModel(model);
                    tableControllers.get(whichTable).eating();
                    
                    time = (int) (Math.random() * 10) + 30;
                    tm.start();
                }
            }
        });

        view.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                curPt = SwingUtilities.convertPoint(view, e.getPoint(), view.getParent());
                if (view.getParent().getBounds().contains(curPt)) {
                    newPt = view.getLocation();
                    newPt.translate(curPt.x - prevPt.x, curPt.y - prevPt.y);
                    newPt.x = Math.max(newPt.x, 0);
                    newPt.y = Math.max(newPt.y, 0);
                    newPt.x = Math.min(newPt.x, view.getParent().getWidth() - view.getWidth());
                    newPt.y = Math.min(newPt.y, view.getParent().getHeight() - view.getHeight());
                    view.setLocation(newPt);
                    prevPt = curPt;
                }
            }
        });
    }

    public CustomersModel getModel() {
        return model;
    }

    public void setModel(CustomersModel model) {
        this.model = model;
    }

    public CustomersView getView() {
        return view;
    }

    public void setView(CustomersView view) {
        this.view = view;
    }

    public ArrayList<TableController> getTableControllers() {
        return tableControllers;
    }

    public void setTableControllers(ArrayList<TableController> tableControllers) {
        this.tableControllers = tableControllers;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(tm)) {
            time--;
            System.out.println(time);
            if (time <= 20) {
                view.setImg(model.getImgSad());
            }
            if (time <= 10) {
                view.setImg(model.getImgSaddest());
            }
            if (time <= 0) {
                System.out.println("dead");
                tm.stop();
            }
        }
    }

    public boolean checkCustomersTable() {
        int mouseX = curPt.x;
        int mouseY = curPt.y;
        Rectangle table1 = tableControllers.get(0).getTableView().getBounds();
        Rectangle table2 = tableControllers.get(1).getTableView().getBounds();
        Rectangle table3 = tableControllers.get(2).getTableView().getBounds();
        Rectangle table4 = tableControllers.get(3).getTableView().getBounds();
        
        if ((mouseX >= table1.getMinX() && mouseX <= table1.getMaxX())&&(mouseY >= table1.getMinY() && mouseY <= table1.getMaxY())){
            whichTable = tableControllers.get(0).getTableModel().getTable().getNumTable() - 1;
            return true;
        }
        else if ((mouseX >= table2.getMinX() && mouseX <= table2.getMaxX())&&(mouseY >= table2.getMinY() && mouseY <= table2.getMaxY())){
            whichTable = tableControllers.get(1).getTableModel().getTable().getNumTable() - 1;
            return true;
        }
        else if ((mouseX >= table3.getMinX() && mouseX <= table3.getMaxX())&&(mouseY >= table3.getMinY() && mouseY <= table3.getMaxY())){
            whichTable = tableControllers.get(2).getTableModel().getTable().getNumTable() - 1;
            return true;
        }
        else if ((mouseX >= table4.getMinX() && mouseX <= table4.getMaxX())&&(mouseY >= table4.getMinY() && mouseY <= table4.getMaxY())){
            whichTable = tableControllers.get(3).getTableModel().getTable().getNumTable() - 1;
            return true;
        }
        
        return false;
    }
}
