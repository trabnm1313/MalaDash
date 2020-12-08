/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Controllers;

import maladash.src.components.Models.NewRecordModel;
import maladash.src.components.Views.NewRecordView;
/**
 *
 * @author USER
 */
public class NewRecordController {
    private NewRecordModel model;
    private NewRecordView view;
    
    public NewRecordController(){
        model = new NewRecordModel();
        view = new NewRecordView();
        view.setImg(model.getImg());
        
        view.setBounds(805, 615, 344, 98);
        view.setOpaque(false);
    }

    public NewRecordModel getModel() {
        return model;
    }

    public void setModel(NewRecordModel model) {
        this.model = model;
    }

    public NewRecordView getView() {
        return view;
    }

    public void setView(NewRecordView view) {
        this.view = view;
    }
    
    
    
}
