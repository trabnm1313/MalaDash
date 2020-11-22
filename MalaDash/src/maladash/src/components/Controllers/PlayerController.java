package maladash.src.components.Controllers;

import maladash.src.components.Classes.Player;
import maladash.src.components.Models.PlayerModel;
import maladash.src.components.Views.PlayerView;

public class PlayerController{
    PlayerModel model = new PlayerModel();
    PlayerView view = new PlayerView();
    //MainGame = new MainGame();
    
    public void travel(){
        
    }
    
    public void resetPosition(){
        
    }

    public PlayerModel getModel() {
        return model;
    }

    public void setModel(PlayerModel model) {
        this.model = model;
    }

    public PlayerView getView() {
        return view;
    }

    public void setView(PlayerView view) {
        this.view = view;
    }
    
    
}
