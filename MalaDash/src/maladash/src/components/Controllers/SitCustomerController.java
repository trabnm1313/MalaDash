package maladash.src.components.Controllers;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import maladash.src.components.Models.CustomersModel;

class SitCustomerController implements Runnable {

    private CustomersModel model;
    private ArrayList<TableController> tableControllers;
    private ArrayList<HeartController> heats;
    private PlayerController player;
    private GameController gameCon;
    private MainMenuController menu;
    private MainGameController game;
    private CustomersController cos;

    private int waitTime;
    private int minWaitTime = 25;
    private int maxWaitTime = 5;

    private int whichTable;

    private boolean stopThis = false;

    public SitCustomerController() {
        model = new CustomersModel();

        waitTime = (int) (Math.random() * maxWaitTime) + minWaitTime;
    }

    public void run() {
        while (true) {
            if (stopThis) {
                break;
            }

            try {
                Thread.sleep(1000);
                waitTime--;
//                System.out.println("[SitCustomer][" + whichTable + "]: waitTime: " + waitTime);
//                System.out.println("[SitCustomer][" + whichTable + "]: isWait: " + model.getCustomers().isWait() + ", isEat: " + model.getCustomers().isEat() + ", isDone: " + model.getCustomers().isDone());

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (!stopThis) {
                //Handup && ready to give order
                if (waitTime > 15 && waitTime <= 26) {
                    if (!model.getCustomers().isReady()) {
                        model.getCustomers().setReady(true);
                        model.getCustomers().setLvAngry(0);
                        tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                    } else if (model.getCustomers().isDone()) {
                        //IF Finish eating but not collect money angrylvl = 1
                        model.getCustomers().setLvAngry(0);
                        tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                    }
                }

                if (waitTime > 5 && waitTime <= 15) {
                    //If isWait(take order) && isEat(eat yet?) is false
                    if (model.getCustomers().isReady() && !model.getCustomers().isWait() && !model.getCustomers().isEat() && !model.getCustomers().isDone()) {
                        model.getCustomers().setLvAngry(1);
                        tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                    } else if (model.getCustomers().isDone()) {
                        //IF Finish eating but not collect money angrylvl = 2
                        model.getCustomers().setLvAngry(1);
                        tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                    }
                }

                if (waitTime > 0 && waitTime <= 5) {
                    if (model.getCustomers().isReady() && !model.getCustomers().isWait() && !model.getCustomers().isEat() && !model.getCustomers().isDone()) {
                        model.getCustomers().setLvAngry(2);
                        tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                    } else if (model.getCustomers().isDone()) {
                        model.getCustomers().setLvAngry(2);
                        tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                    }
                }

                if (model.getCustomers().isEat()) {
                    tableControllers.get(whichTable).eating();
                    if (waitTime == 0) {
                        model.getCustomers().setDone(true);
                        model.getCustomers().setEat(false);
                        tableControllers.get(whichTable).getTableModel().getTable().setDirty(true);
                        waitTime = (int) (Math.random() * maxWaitTime) + minWaitTime;
                    }
                }

                if (waitTime == 0 && (!model.getCustomers().isWait() || model.getCustomers().isDone())) {
                    tableControllers.get(whichTable).notDirty();
                    tableControllers.get(whichTable).getTableModel().getTable().setSitable(true);
                    tableControllers.get(whichTable).setCustomersController(null);
                    stopThis = true;
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
                        System.out.println(menu + " " + game);
                        if (game.getModel().getMoney() > menu.getHighScore()) {
                            over.getView().getHighScore().setText("" + game.getModel().getMoney());
                            try {
                                FileWriter fe = new FileWriter("HighScore.dat");
                                over.setGame(gameCon);
                                over.init();
                                fe.write(game.getModel().getMoney());
                                System.out.println("Writing successful");
                                fe.close();
                            } catch (IOException er) {
                                System.out.print(er);
                            }
                        } else {
                            over.getView().getHighScore().setText("" + menu.getHighScore());
                            try {
                                FileWriter fe = new FileWriter("HighScore.dat");
                                fe.write(menu.getHighScore());
                                System.out.println("Writing successful");
                                fe.close();
                            } catch (IOException er) {
                                System.out.print(er);
                            }
                        }
                        cos.setIndex(0);
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

    public ArrayList<HeartController> getHeats() {
        return heats;
    }

    public void setHeats(ArrayList<HeartController> heats) {
        this.heats = heats;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }

    public GameController getGameCon() {
        return gameCon;
    }

    public void setGameCon(GameController gameCon) {
        this.gameCon = gameCon;
    }

    public MainMenuController getMenu() {
        return menu;
    }

    public void setMenu(MainMenuController menu) {
        this.menu = menu;
    }

    public MainGameController getGame() {
        return game;
    }

    public void setGame(MainGameController game) {
        this.game = game;
    }

    public CustomersModel getModel() {
        return model;
    }

    public void setModel(CustomersModel model) {
        this.model = model;
    }

    public ArrayList<TableController> getTableControllers() {
        return tableControllers;
    }

    public void setTableControllers(ArrayList<TableController> tableControllers) {
        this.tableControllers = tableControllers;
    }

    public int getWhichTable() {
        return whichTable;
    }

    public void setWhichTable(int whichTable) {
        this.whichTable = whichTable;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public boolean isStopThis() {
        return stopThis;
    }

    public void setStopThis(boolean stopThis) {
        this.stopThis = stopThis;
    }

    public CustomersController getCos() {
        return cos;
    }

    public void setCos(CustomersController cos) {
        this.cos = cos;
    }

    
}
