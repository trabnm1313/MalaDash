package maladash.src.components.Controllers;

import javax.swing.JButton;
import javax.swing.JPanel;
import maladash.src.components.Models.MainGameModel;
import maladash.src.components.Views.MainGameView;


public class MainGameController {
    private MainGameView view;
    private MainGameModel model;
    
    public MainGameController(){
        //Initate Model
        model = new MainGameModel();
        view = new MainGameView();
        view.setImg(model.getImg());
        view.setLayout(null);
        
        PlayerController p1 = new PlayerController();
        p1.getView().setBounds(1000, 300, 300, 300);
        p1.getView().setOpaque(false);
        
        JButton move = new JButton("Move");
        move.setBounds(50, 50, 100, 50);
        p1.setMove(move);
        
        view.add(move);
        view.add(p1.getView());
        
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
