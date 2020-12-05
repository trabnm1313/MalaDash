package maladash.src.components.Controllers;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import maladash.src.components.Models.MainGameModel;
import maladash.src.components.Views.MainGameView;

public class MainGameController {

    private MainGameView view;
    private MainGameModel model;
    private ArrayList<JPanel> malaViews;
    private ArrayList<TableController> tableControllers;
    private JPanel table1, table2, table3, table4, mala1, mala2, mala3, mala4;
    private MalaController malaController;
    private JLabel money;

    public MainGameController() {
        //Initate Model
        model = new MainGameModel();
        view = new MainGameView();
        view.setImg(model.getImg());
        view.setLayout(null);
        
        //money
        money = new JLabel(model.getMoney()+"");
        money.setFont(new Font("Serif", Font.PLAIN, 72));
        money.setSize(200, 100);
        money.setBounds(1700, 5, 200, 100);
        
        //table
        tableControllers = new ArrayList();
        for (int i = 1; i <= 4; i++) {
            if (i < 2) {
                tableControllers.add(new TableController(i, 4));
                System.out.println(i);
            } else {
                tableControllers.add(new TableController(i, 2));
                System.out.println(i);
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
        
        
        table1 = tableControllers.get(0).getTableView();
        table2 = tableControllers.get(1).getTableView();
        table3 = tableControllers.get(2).getTableView();
        table4 = tableControllers.get(3).getTableView();
        

        view.add(table1);
        view.add(table2);
        view.add(table3);
        view.add(table4);

        //mala
        malaViews = new ArrayList();
        for (int i = 1; i <= 4; i++) {
               malaViews.add(new MalaController(i).getMalaView());
            }
          
        mala1 = malaViews.get(0);
        mala2 = malaViews.get(1);
        mala3 = malaViews.get(2);
        mala4 = malaViews.get(3);

        view.add(mala1);
        view.add(mala2);
        view.add(mala3);
        view.add(mala4);

        view.add(money);
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
