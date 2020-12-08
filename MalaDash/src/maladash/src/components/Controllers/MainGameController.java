package maladash.src.components.Controllers;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import maladash.src.components.Models.MainGameModel;
import maladash.src.components.Views.MainGameView;


public class MainGameController {
    private posterController poster;
    private MainGameView view;
    private MainGameModel model;
    private ArrayList<TableController> tableControllers;
    private JPanel table1, table2, table3, table4, mala1, mala2, mala3, mala4;
    private CustomersController customer1, customer2, customer3, customer4;
    private ArrayList<MalaController> malaController;
    private JLabel money;
    private PlayerController player;
    private ComputerController computer;
    private TrashController trash;
    

    public MainGameController() {
        //Initate Model
        model = new MainGameModel();
        view = new MainGameView();
        view.setImg(model.getImg());
        view.setLayout(null);
        
        //Player
        player = new PlayerController();
        Thread tPlayer = new Thread(player);
        tPlayer.start();
        
        //money
        money = new JLabel(model.getMoney() + "");
        money.setFont(new Font("Serif", Font.PLAIN, 72));
        money.setSize(200, 100);
        money.setBounds(1700, 5, 200, 100);

        //table
        tableControllers = new ArrayList();
        for (int i = 1; i <= 4; i++) {
            if (i <= 2) {
                tableControllers.add(new TableController(i, 4));
            } else {
                tableControllers.add(new TableController(i, 2));
            }
        }
        tableControllers.get(0).setMainGame(this);
        tableControllers.get(1).setMainGame(this);
        tableControllers.get(2).setMainGame(this);
        tableControllers.get(3).setMainGame(this);

        tableControllers.get(0).setText(money);
        tableControllers.get(1).setText(money);
        tableControllers.get(2).setText(money);
        tableControllers.get(3).setText(money);

        tableControllers.get(0).setPlayerController(player);
        tableControllers.get(1).setPlayerController(player);
        tableControllers.get(2).setPlayerController(player);
        tableControllers.get(3).setPlayerController(player);

        table1 = tableControllers.get(0).getTableView();
        table2 = tableControllers.get(1).getTableView();
        table3 = tableControllers.get(2).getTableView();
        table4 = tableControllers.get(3).getTableView();

        //Mala
        malaController = new ArrayList();
        for (int i = 1; i <= 4; i++) {
            malaController.add(new MalaController(i));
        }

        mala1 = malaController.get(0).getMalaView();
        mala2 = malaController.get(1).getMalaView();
        mala3 = malaController.get(2).getMalaView();
        mala4 = malaController.get(3).getMalaView();

        malaController.get(0).setPlayerController(player);
        malaController.get(1).setPlayerController(player);
        malaController.get(2).setPlayerController(player);
        malaController.get(3).setPlayerController(player);

        //Bill
        computer = new ComputerController();
        computer.setMalaController(malaController);
        computer.setPlayer(player);
        poster = new posterController();
        poster.getPoster().setOpaque(false);
        poster.setPlayer(player);
        poster.getPoster().setBounds(935,337,412,150);
        
        //Trash
        trash = new TrashController();
        trash.setPlayerController(player);
        
        //Customers
        customer1 = new CustomersController();
        customer2 = new CustomersController();
        customer3 = new CustomersController();
        //Customers Configuration
        customer1.setTableControllers(tableControllers);
        customer2.setTableControllers(tableControllers);
        customer3.setTableControllers(tableControllers);
        //Init
        customer1.init();
        customer2.init();
        customer3.init();
        //Customers Thread
        Thread tCustomer1 = new Thread(customer1);
        Thread tCustomer2 = new Thread(customer2);
        Thread tCustomer3 = new Thread(customer3);
        tCustomer1.start();
        tCustomer2.start();
        tCustomer3.start();

        
        //Add to view

        view.add(money);
        
        view.add(table2);
        view.add(table4);

        view.add(player.getView());
        
        view.add(customer1.getView());
        view.add(customer2.getView());
        view.add(customer3.getView());

        view.add(table1);
        view.add(table3);

        view.add(mala1);
        view.add(mala2);
        view.add(mala3);
        view.add(mala4);
        
        view.add(computer.getView());
        
        view.add(trash.getTrashView());
                
        view.add(poster.getPoster());
    }

    public MainGameView getView() {
        return view;
    }

    public void setView(MainGameView view) {
        this.view = view;
    }

    public MainGameModel getModel() {
        return model;
    }

    public void setModel(MainGameModel model) {
        this.model = model;
    }

}
