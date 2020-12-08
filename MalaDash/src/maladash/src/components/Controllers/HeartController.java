/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import maladash.src.components.Models.HeartModel;
import maladash.src.components.Views.HeartView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author USER
 */
public class HeartController {
    private HeartModel model;
    private HeartView view;

    public HeartController(int index) {
        model = new HeartModel();
        view = new HeartView();
        view.setImg(model.getImg());
        
        if(index == 0){
            view.setBounds(10, 10, 55, 58);
        }else if(index == 1){
            view.setBounds(75, 10, 55, 58);
        }else if(index == 2){
            view.setBounds(140, 10, 55, 58);
        }else if(index == 3){
            view.setBounds(205, 10, 55, 58);
        }
        else if(index == 4){
            view.setBounds(270, 10, 55, 58);
        }
        view.setOpaque(false);
    }

    public HeartModel getModel() {
        return model;
    }

    public void setModel(HeartModel model) {
        this.model = model;
    }

    public HeartView getView() {
        return view;
    }

    public void setView(HeartView view) {
        this.view = view;
    }
    
    
    
}
