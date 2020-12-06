package maladash.src.components.Controllers;

import javax.swing.JButton;
import java.util.*;
import javax.swing.JPanel;
import maladash.src.components.Models.MainGameModel;
import maladash.src.components.Views.MainGameView;

public class MainGameController {

    private MainGameView view;
    private MainGameModel model;
    private ArrayList<JPanel> tableViews, malaViews;
    private ArrayList<MalaController> malaController;
    private JPanel table1, table2, table3, table4, mala1, mala2, mala3, mala4;
    private PlayerController player;
    private ComputerController computer;
    

    public MainGameController() {
        //Initate Model
        model = new MainGameModel();
        view = new MainGameView();
        view.setImg(model.getImg());
        view.setLayout(null);
        
        //Table
        tableViews = new ArrayList();
        for (int i = 1; i <= 4; i++) {
            if (i < 2) {
                tableViews.add(new TableController(i, 4).getTableView());
            } else {
                tableViews.add(new TableController(i, 2).getTableView());
            }
        }
        table1 = tableViews.get(0);
        table2 = tableViews.get(1);
        table3 = tableViews.get(2);
        table4 = tableViews.get(3);

        //Mala
        malaController = new ArrayList();
        for (int i = 1; i <= 4; i++) {
            malaController.add(new MalaController(i));
        }
          
        mala1 = malaController.get(0).getMalaView();
        mala2 = malaController.get(1).getMalaView();
        mala3 = malaController.get(2).getMalaView();
        mala4 = malaController.get(3).getMalaView();
        
        //Player
        player = new PlayerController();
        
        //Bill
        computer = new ComputerController();
        computer.setMalaController(malaController);
        computer.setPlayer(player.getModel().getPlayer());
        
        JButton move = new JButton("Move");
        move.setBounds(50, 50, 100, 50);
        player.setMove(move);
        
        //Add to view
        view.add(table1);
        view.add(table2);
        view.add(table3);
        view.add(table4);
        
        view.add(mala1);
        view.add(mala2);
        view.add(mala3);
        view.add(mala4);
        
        view.add(move);
        view.add(player.getView());
        
        view.add(computer.getView());
        
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
