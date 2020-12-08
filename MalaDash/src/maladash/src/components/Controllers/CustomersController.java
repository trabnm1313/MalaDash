package maladash.src.components.Controllers;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import maladash.src.components.Models.CustomersModel;
import maladash.src.components.Views.CustomersView;

public class CustomersController implements MouseMotionListener, MouseListener, Runnable {

    //ModelView and Refference Class
    private CustomersModel model;
    private CustomersView view;
    private ArrayList<TableController> tableControllers;

    //Timer
    private int waitTime;
    private int time;
    private int timeSpawn;
    private int minSpawnTime = 1;
    private int maxSpawnTime = 5;

    private int minWaitTime = 1;
    private int maxWaitTime = 30;

    //Mouse&&CustomerPosition
    private Point prevPt, curPt, newPt;
    private Rectangle original;
    private int whichTable;

    //Boolean
    private boolean isSpawning = true;

    //Class unique and global Variable
    private static int index = 0;

    private ArrayList<HeartController> heats;
    private PlayerController player;
    private GameController gameCon;
    private MainMenuController menu;
    private MainGameController game;

    //Random association
    private double pivot;
    private int people;

    public void init() {

        model = new CustomersModel();
        view = new CustomersView();

        view.setVisible(false);
        view.setBounds(300 * (index), 300, 300, 250);
        original = view.getBounds();
        view.setOpaque(false);

        view.addMouseListener(this);
        view.addMouseMotionListener(this);

        pivot = Math.random() * 100;
        if (pivot > 50) {
            people = 4;
        } else {
            people = 2;
        }

        timeSpawn = (int) (Math.random() * maxSpawnTime) + minSpawnTime;
        time = (int) (Math.random() * maxWaitTime) + minWaitTime;

        index++;
    }

    //Setter&&Getter
    public MainGameController getGame() {
        return game;
    }

    public void setGame(MainGameController game) {
        this.game = game;
    }

    public GameController getGameCon() {
        return gameCon;
    }

    public void setGameCon(GameController gameCon) {
        this.gameCon = gameCon;
    }

    public ArrayList<HeartController> getHeats() {
        return heats;
    }

    public void setHeats(ArrayList<HeartController> heats) {
        this.heats = heats;
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

    public Rectangle getOriginal() {
        return original;
    }

    public void setOriginal(Rectangle original) {
        this.original = original;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }

    @Override
    public void run() {
        while (true) {
            try {

                Thread.sleep(1000);

                if (isSpawning) {
                    timeSpawn--;
                } else {
                    time--;
                }

//                System.out.println("[Customer][" + index + "]: Time: " + time + ", TimeSpawn: " + timeSpawn);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (isSpawning) {
                if (timeSpawn == 0) {
                    view.setVisible(true);

                    pivot = (int) (Math.random() * 100);
                    if (pivot > 50) {
                        people = 4;
                        view.setImg(model.getImgNormal_4());
                    } else {
                        people = 2;
                        view.setImg(model.getImgNormal_2());
                    }

                    model.getCustomers().setCount(people);
                    isSpawning = false;
                    timeSpawn = (int) (Math.random() * maxSpawnTime) + minSpawnTime;
                }
            } else {

                //Change expression if customer didn't sit yet
                if (!model.getCustomers().isSit()) {
                    //Sad
                    if (time > 10 && time <= 20) {
                        if (people == 4) {
                            view.setImg(model.getImgSad_4());
                        } else {
                            view.setImg(model.getImgSad_2());
                        }
                    }
                    //Saddest
                    if (time > 0 && time <= 10) {
                        if (people == 4) {
                            view.setImg(model.getImgSaddest_4());
                        } else {
                            view.setImg(model.getImgSaddest_2());
                        }
                    }
                    //DEATH
                    if (time == 0) {
                        System.out.println("[Customer][" + index + "]: DEAD");
                        view.setVisible(false);
                        time = (int) (Math.random() * maxWaitTime) + minWaitTime;
                        isSpawning = true;

                        player.getModel().getPlayer().setHeart(player.getModel().getPlayer().getHeart() - 1);

                        if (player.getModel().getPlayer().getHeart() == 4) {
                            heats.get(player.getModel().getPlayer().getHeart()).getView().setVisible(false);
                        } else if (player.getModel().getPlayer().getHeart() == 3) {
                            heats.get(player.getModel().getPlayer().getHeart()).getView().setVisible(false);
                        } else if (player.getModel().getPlayer().getHeart() == 2) {
                            heats.get(player.getModel().getPlayer().getHeart()).getView().setVisible(false);
                        } else if (player.getModel().getPlayer().getHeart() == 1) {
                            heats.get(player.getModel().getPlayer().getHeart()).getView().setVisible(false);
                        } else if (player.getModel().getPlayer().getHeart() == 0) {
                            //GameOver
                            heats.get(player.getModel().getPlayer().getHeart()).getView().setVisible(false);
                            GameOverController over = new GameOverController();
                            over.setGame(gameCon);
                            over.init();
                            over.getView().getScore().setText("" + game.getModel().getMoney());
                            if (game.getModel().getMoney() > game.getHighScore()) {
                                System.out.println(game.getModel().getMoney());
                                over.getView().add(over.getRec().getView());
                                over.getView().getHighScore().setText("" + game.getModel().getMoney());
                                try {
                                    FileWriter fe = new FileWriter("HighScore.dat");
                                    fe.write(game.getModel().getMoney());
                                    System.out.println("Writing successful");
                                    fe.close();
                                } catch (IOException er) {
                                    System.out.print(er);
                                }
                            } else {
                                over.getView().getHighScore().setText("" + game.getHighScore());
                                try {
                                    FileWriter fe = new FileWriter("HighScore.dat");
                                    fe.write(game.getHighScore());
                                    System.out.println("Writing successful");
                                    fe.close();
                                } catch (IOException er) {
                                    System.out.print(er);
                                }
                            }
                            setIndex(0);
                            //Short Variable
                            JFrame gameFrame = gameCon.getView().getFrame();
                            //Change ContentPane from MainMenu to MainGame
                            gameFrame.setContentPane(over.getView());
                            gameFrame.setSize(1920, 1080);
                            gameFrame.getContentPane().revalidate();
                            gameFrame.getContentPane().repaint();
                            gameFrame.setVisible(true);
                        }
                    }

                }

            }
        }
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
        System.out.println("HELLO");
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

                    SitCustomerController sitCustomer = new SitCustomerController();

                    sitCustomer.getModel().getCustomers().setCount(people);
                    sitCustomer.getModel().getCustomers().setSit(true);
                    sitCustomer.setTableControllers(tableControllers);
                    sitCustomer.setWhichTable(whichTable);
                    sitCustomer.setPlayer(getPlayer());
                    sitCustomer.setHeats(getHeats());
                    sitCustomer.setGame(getGame());
                    sitCustomer.setGameCon(getGameCon());
                    sitCustomer.setMenu(getMenu());
                    sitCustomer.setCos(this);

                    Thread tSitCustomer = new Thread(sitCustomer);
                    tSitCustomer.start();

                    tableControllers.get(whichTable).setCustomersController(sitCustomer);
                    tableControllers.get(whichTable).getTableModel().getTable().setSitable(false);
                    tableControllers.get(whichTable).sit();

                    isSpawning = true;
                    time = (int) (Math.random() + minWaitTime) + maxWaitTime;
                    view.setBounds(original);
                } else {
                    view.setBounds(original);
                }
            } else {
                view.setBounds(original);
            }

        }
    }

    public MainMenuController getMenu() {
        return menu;
    }

    public void setMenu(MainMenuController menu) {
        this.menu = menu;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    //Custom Method
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
}
