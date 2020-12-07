package maladash.src.components.Controllers;

import java.awt.event.*;
import java.util.ArrayList;
import maladash.src.components.Classes.Player;
import maladash.src.components.Models.ComputerModel;
import maladash.src.components.Views.ComputerView;

public class ComputerController{
    private PlayerController player;
    private ComputerModel model;
    private ComputerView view;
    private ArrayList<MalaController> malaController;
    
    public ComputerController(){
        model = new ComputerModel();
        view = new ComputerView();
        view.setImg(model.getImg());
        
        view.setOpaque(false);
        view.setBounds(775, 175, 136, 117);
        
        view.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(player.getModel().getPlayer().isCarryOrder() && player.getModel().getPlayer().getWhichTable() == 0 && player.getModel().getPlayer().isReady()){
                    player.getModel().getPlayer().setCarryOrder(false);
                    player.stand();
                    Thread t = new Thread(malaController.get(player.getModel().getPlayer().getBill()-1));
                    t.start();
                    System.out.println("[Mock]: new MalaController created.");
                }
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

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }
    
    public ArrayList<MalaController> getMalaController() {
        return malaController;
    }

    public void setMalaController(ArrayList<MalaController> malaController) {
        this.malaController = malaController;
    }    
    
    
}
