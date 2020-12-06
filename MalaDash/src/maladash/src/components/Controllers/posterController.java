/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import maladash.src.components.Views.posterView;

/**
 *
 * @author Krittin_Chuaylamae
 */
public class posterController {
    private posterView poster;
    private PlayerController player;
    public posterController() {
        poster = new posterView();
        poster.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent ev){
                if(player.getModel().getPlayer().isReady()){
                    player.travel(0);
                }
            }
        });
    }

    public posterView getPoster() {
        return poster;
    }

    public void setPoster(posterView poster) {
        this.poster = poster;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }
    
    
}
