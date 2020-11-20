package maladash.src.components.Controllers;

import javax.swing.JPanel;
import maladash.src.components.Models.MainGameModel;
import maladash.src.components.Views.MainGameView;


public class MainGameController {
    private MainGameView view;
    private MainGameModel model;
    
    public MainGameController(){
        view = new MainGameView();
        model = new MainGameModel();
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
