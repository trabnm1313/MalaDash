/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import maladash.src.components.Models.MalaModel;
import maladash.src.components.Views.MalaView;
import java.awt.event.*;

/**
 *
 * @author USER
 */
public class MalaController implements Runnable {

    private MalaModel malaModel;
    private MalaView malaView;
    private static PlayerController playerController;
    private int time;

    public MalaController(int numTable) {
        malaModel = new MalaModel(numTable);
        malaView = new MalaView();
        malaView.setImg(malaModel.getImg());
        if (numTable == 1) {
            malaView.setBounds(1025, 270, 75, 25);
        }else if(numTable == 2){
            malaView.setBounds(1225, 270, 75, 25);
        }else if(numTable == 3){
            malaView.setBounds(1340, 270, 75, 25);
        }else if(numTable == 4){
            malaView.setBounds(1460, 270, 75, 25);
        }
        malaView.setOpaque(false);
        malaView.setVisible(false);
        malaView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                boolean playerReady = playerController.getModel().getPlayer().isReady();
                boolean playerCarryOrder = playerController.getModel().getPlayer().isCarryOrder();
                boolean playerCarryDish = playerController.getModel().getPlayer().isCarryDish();
                boolean playerWashing = playerController.getModel().getPlayer().isWashing();
                if ((playerController.getModel().getPlayer().getWhichTable() == 0) && !playerCarryOrder && !playerCarryDish && !playerWashing ) {
                    malaView.setVisible(false);
                    playerController.getModel().getPlayer().setCarryDish(true);
                    playerController.getModel().getPlayer().setMala(malaModel.getMala());
                    if (playerController.getModel().getPlayer().isCarryDish()) {
                        System.out.println("[Mala]: Get Dish Number #" + playerController.getModel().getPlayer().getMala().getNumTable());
                    }
                    playerController.standWithMala();
                }

            }
        });

    }

    public MalaModel getMalaModel() {
        return malaModel;
    }

    public void setMalaModel(MalaModel malaModel) {
        this.malaModel = malaModel;
    }

    public MalaView getMalaView() {
        return malaView;
    }

    public void setMalaView(MalaView malaView) {
        this.malaView = malaView;
    }

    @Override
    public void run() {
        time = (int) (Math.random() * 7000) + 5000;
        try {
            Thread.sleep(time);
            malaView.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

}
