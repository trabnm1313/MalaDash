package maladash.src.components.Controllers;

import java.awt.event.*;
import maladash.src.components.Models.PlayerModel;
import maladash.src.components.Views.PlayerView;

public class PlayerController{
    PlayerModel model;
    PlayerView view;
    
    public PlayerController(){
        model = new PlayerModel();
        view = new PlayerView();
        view.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("HELLO");
            }
        });
        System.out.println("[Player]: View created.");
    }
    
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
