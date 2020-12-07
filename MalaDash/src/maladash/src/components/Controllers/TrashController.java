package maladash.src.components.Controllers;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;
import maladash.src.components.Classes.Player;
import maladash.src.components.Models.TrashModel;
import maladash.src.components.Views.TrashView;

public class TrashController {

    private TrashModel trashModel;
    private TrashView trashView;
    private PlayerController playerController;
    
    private Point prevPoint;

    public TrashController() {
        trashModel = new TrashModel();
        trashView = new TrashView();

        trashView.setImg(trashModel.getImg());
        trashView.setOpaque(false);
        trashView.setBounds(775, 420, 120, 127);

        trashView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                boolean playerReady = playerController.getModel().getPlayer().isReady();
                boolean playerCarryOrder = playerController.getModel().getPlayer().isCarryOrder();
                boolean playerCarryDish = playerController.getModel().getPlayer().isCarryDish();
                boolean playerWashing = playerController.getModel().getPlayer().isWashing();
                int playerWhichTable = playerController.getModel().getPlayer().getWhichTable();
                
                if(playerWashing && playerReady && !playerCarryOrder && !playerCarryDish && playerWhichTable == 0){
                    playerController.getModel().getPlayer().setWashing(false);
                }
                System.out.println("Hello trash");
            }
        });
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public TrashModel getTrashModel() {
        return trashModel;
    }

    public void setTrashModel(TrashModel trashModel) {
        this.trashModel = trashModel;
    }

    public TrashView getTrashView() {
        return trashView;
    }

    public void setTrashView(TrashView trashView) {
        this.trashView = trashView;
    }

}
