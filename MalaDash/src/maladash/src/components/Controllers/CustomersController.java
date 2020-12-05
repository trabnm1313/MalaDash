package maladash.src.components.Controllers;

import maladash.src.components.Models.CustomersModel;
import maladash.src.components.Views.CustomersView;

public class CustomersController {
    CustomersModel model;
    CustomersView view;
    
    public CustomersController(){
        model = new CustomersModel();
        view = new CustomersView();
    }

    public CustomersModel getModel() {
        return model;
    }

    public void setModel(CustomersModel model) {
        this.model = model;
    }

    public CustomersView getView() {
        return view;
    }

    public void setView(CustomersView view) {
        this.view = view;
    }
    
    
}
