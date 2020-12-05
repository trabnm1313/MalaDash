package maladash.src.components.Controllers;

import java.awt.event.*;
import maladash.src.components.Classes.Player;
import maladash.src.components.Models.ComputerModel;
import maladash.src.components.Views.ComputerView;

public class ComputerController{
    private Player player;
    private ComputerModel model;
    private ComputerView view;
    
    public ComputerController(){
        model = new ComputerModel();
        view = new ComputerView();
        view.setImg(model.getImg());
        
        view.setOpaque(false);
        view.setBounds(775, 175, 136, 117);
        
        view.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
//                1-4
//                Thread t = new Thread(new MalaController(player.getBill()));
                System.out.println("[Mock]: new MalaController created.");
            }
        });
    }

    public ComputerModel getModel() {
        return model;
    }

    public void setModel(ComputerModel model) {
        this.model = model;
    }

    public ComputerView getView() {
        return view;
    }

    public void setView(ComputerView view) {
        this.view = view;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    
}
