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
public class MalaController {
    private MalaModel malaModel;
    private MalaView malaView;

    public MalaController(int numTable) {
        malaModel = new MalaModel(numTable);
        malaView = new MalaView();
        malaView.setImg(malaModel.getImg());
        if(numTable == 1){
            malaView.setBounds(1025, 270, 75, 25);
        }else if(numTable == 2){
            malaView.setBounds(1129, 270, 75, 25);
        }else if(numTable == 3){
            malaView.setBounds(1233, 270, 75, 25);
        }else if(numTable == 4){
            malaView.setBounds(1337, 270, 75, 25);
        }
        malaView.setVisible(false);
        malaView.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                malaView.setVisible(false);
                
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
    
    
}
