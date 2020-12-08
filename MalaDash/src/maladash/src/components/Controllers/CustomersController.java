package maladash.src.components.Controllers;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import maladash.src.components.Models.CustomersModel;
import maladash.src.components.Views.CustomersView;

public class CustomersController implements ActionListener, MouseMotionListener, MouseListener {

    private CustomersModel model;
    private CustomersView view;
    private ArrayList<TableController> tableControllers;
    private ArrayList<CustomersController> csConList = new ArrayList();
    private Timer tm = new Timer(1000, this);
    private Timer tm2 = new Timer(1000, this);
    private int time, count = 10;
    private Point prevPt, curPt, newPt;
    private Rectangle original;
    private boolean ancestor = false;
    private int whichTable;
    private static int totalCustomers = 0;
    MainGameController game;
    CustomersController csCon, csSelf;
    private int index;
    private static final int LIMIT = 3;

    private double pivot;
    private int people;

    public CustomersController() {

        model = new CustomersModel();
        view = new CustomersView();

        time = (int) (Math.random() * 10) + 30;

        for (int i = 0; i < LIMIT; i++) {
            csConList.add(i, null);
        }
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

    public MainGameController getGame() {
        return game;
    }

    public void setGame(MainGameController game) {
        this.game = game;
    }

    public Timer getTm2() {
        return tm2;
    }

    public void setTm2(Timer tm2) {
        this.tm2 = tm2;
    }

    public Rectangle getOriginal() {
        return original;
    }

    public void setOriginal(Rectangle original) {
        this.original = original;
    }

    public CustomersController getCsSelf() {
        return csSelf;
    }

    public void setCsSelf(CustomersController csSelf) {
        this.csSelf = csSelf;
    }

    public Timer getTm() {
        return tm;
    }

    public void setTm(Timer tm) {
        this.tm = tm;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<CustomersController> getCsConList() {
        return csConList;
    }

    public void setCsConList(ArrayList<CustomersController> csConList) {
        this.csConList = csConList;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isAncestor() {
        return ancestor;
    }

    public void setAncestor(boolean ancestor) {
        this.ancestor = ancestor;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(tm) && ancestor){
            for(int i = 0; i < LIMIT; i++){
                if(csConList.get(i) != null){
                    csConList.get(i).actionPerformed(ae);
                }
            }
            for(int i = 0; i < 4; i++){
                if(tableControllers.get(i).getCustomersController() != null){
                    tableControllers.get(i).getCustomersController().actionPerformed(ae);
                }
            }
        }
        
        if (!ancestor){
            if (ae.getSource().equals(csSelf.getTm())) {
                time--;
                if (!model.getCustomers().isSit()) {
                    if (time <= 20) {
                        if (people == 4) {
                            view.setImg(model.getImgSad_4());
                        } else if (people == 2) {
                            view.setImg(model.getImgSad_2());
                        }
                    }
                    if (time <= 10) {
                        if (people == 4) {
                            view.setImg(model.getImgSaddest_4());
                        } else if (people == 2) {
                            view.setImg(model.getImgSaddest_2());
                        }
                    }
                    if (time == 0) {
                        System.out.println("dead");
                        view.setVisible(false);

                        totalCustomers--;
                        csSelf.getCsConList().set(index, null);
                        csSelf.getTm2().start();
                    }
                } else {
                    if( model.getCustomers().isEat() && !model.getCustomers().isDone()){
                            tableControllers.get(whichTable).eating();
                        }
                    if((time == 0) && model.getCustomers().isEat()){
                        model.getCustomers().setDone(true);
                        tableControllers.get(whichTable).getTableModel().getTable().setDirty(true);
                        setTime((int) (Math.random() * 10) + 30);
                    }
                    if (time <= 26) {
                        if (!model.getCustomers().isReady() && !model.getCustomers().isEat()) {
                            model.getCustomers().setReady(true); // พร้อมสั่งอาหาร
                            model.getCustomers().setLvAngry(0);
                            tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                        }else if(model.getCustomers().isDone()){
                            model.getCustomers().setLvAngry(0);
                            tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                        }
                    }
                    if (time <= 15) {
                        if (!model.getCustomers().isWait() && !model.getCustomers().isEat()) {
                            model.getCustomers().setLvAngry(1);
                            tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                        }else if(model.getCustomers().isDone()){
                            model.getCustomers().setLvAngry(1);
                            tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                        }
                    }
                    if (time <= 5) {
                        if (!model.getCustomers().isWait() && !model.getCustomers().isEat()) {
                            model.getCustomers().setLvAngry(2);
                            tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                        }else if(model.getCustomers().isDone()){
                            model.getCustomers().setLvAngry(2);
                            tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                        }
                    }
                    if (time == 0 && (!model.getCustomers().isWait() || model.getCustomers().isDone())){
                        tableControllers.get(whichTable).notDirty();
                        tableControllers.get(whichTable).getTableModel().getTable().setSitable(true);
                        tableControllers.get(whichTable).setCustomersController(null);
                    }
                }
            }

        }
        
        if (ae.getSource().equals(tm2)) {
            count--;
            if (count <= 0) {
                for (int i = 0; i < LIMIT; i++) {
                    if (csConList.get(i) == null) {
                        index = i;
                        break;
                    }
                }
                totalCustomers++;
                System.out.println(totalCustomers);

                csCon = new CustomersController();

                csCon.setTableControllers(tableControllers);

                csCon.setCsSelf(this);
                
                pivot = Math.random() * 100;
                if (pivot > 50) {
                    people = 4;
                } else {
                    people = 2;
                }

                if (people == 4) {
                    csCon.getView().setImg(model.getImgNormal_4());
                } else if (people == 2) {
                    csCon.getView().setImg(model.getImgNormal_2());
                }

                csCon.getView().setOpaque(false);

                if (people == 4) {
                    csCon.getView().setBounds(300 * (index), 350, 300, 250);
                } else if (people == 2) {
                    csCon.getView().setBounds(300 * (index), 350, 300, 250);
                }

                csCon.setOriginal(csCon.getView().getBounds());
                csCon.getModel().getCustomers().setCount(people);
                csCon.setPeople(people);

                csCon.setIndex(index);
                csConList.set(index, csCon);

                csCon.setCsConList(csConList);

                csCon.getView().addMouseMotionListener(csCon);
                csCon.getView().addMouseListener(csCon);

                game.getView().add(csCon.getView());

                game.getView().revalidate();
                game.getView().repaint();

                count = (int) (Math.random() * 3) + 4;

                if (totalCustomers == LIMIT) {
                    tm2.stop();
                }
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

        if ((mouseX >= table1.getMinX() && mouseX <= table1.getMaxX()) && (mouseY >= table1.getMinY() && mouseY <= table1.getMaxY())) {
            whichTable = tableControllers.get(0).getTableModel().getTable().getNumTable() - 1;
            return true;
        } else if ((mouseX >= table2.getMinX() && mouseX <= table2.getMaxX()) && (mouseY >= table2.getMinY() && mouseY <= table2.getMaxY())) {
            whichTable = tableControllers.get(1).getTableModel().getTable().getNumTable() - 1;
            return true;
        } else if ((mouseX >= table3.getMinX() && mouseX <= table3.getMaxX()) && (mouseY >= table3.getMinY() && mouseY <= table3.getMaxY())) {
            whichTable = tableControllers.get(2).getTableModel().getTable().getNumTable() - 1;
            return true;
        } else if ((mouseX >= table4.getMinX() && mouseX <= table4.getMaxX()) && (mouseY >= table4.getMinY() && mouseY <= table4.getMaxY())) {
            whichTable = tableControllers.get(3).getTableModel().getTable().getNumTable() - 1;
            return true;
        }

        return false;
    }

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

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        prevPt = SwingUtilities.convertPoint(view, e.getPoint(), view.getParent());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (checkCustomersTable() == false) {
            view.setBounds(original);
        } else {
            if (tableControllers.get(whichTable).getTableModel().getTable().isSitable()) {
                if (model.getCustomers().getCount() == tableControllers.get(whichTable).getTableModel().getTable().getChair()) {
                    prevPt = null;
                    view.setVisible(false);

                    model.getCustomers().setSit(true);

                    totalCustomers--;
                    csSelf.getCsConList().set(index, null);
                    csSelf.getTm2().start();

                    tableControllers.get(whichTable).setCustomersController(this);

                    tableControllers.get(whichTable).getTableModel().getTable().setSitable(false);

                    tableControllers.get(whichTable).sit();

                    time = (int) (Math.random() * 10) + 30;
                } else {
                    view.setBounds(original);
                }
            } else {
                view.setBounds(original);
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
