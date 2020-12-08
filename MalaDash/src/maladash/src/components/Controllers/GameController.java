
package maladash.src.components.Controllers;

import maladash.src.components.Models.GameModel;
import maladash.src.components.Models.MainMenuModel;
import maladash.src.components.Views.GameView;

public class GameController {
    GameView view;
    GameModel model;
    MainMenuController menu;
    
    public GameController(){
        view = new GameView();
        model = new GameModel();
        menu = new MainMenuController();
        menu.setGame(this);
        
        view.setIconImage(model.getGameIcon());
        view.init();
        view.getFrame().setContentPane(menu.getView());
        
    }

    public GameView getView() {
        return view;
    }

    public void setView(GameView view) {
        this.view = view;
    }

    public MainMenuController getMenu() {
        return menu;
    }

    public void setMenu(MainMenuController menu) {
        this.menu = menu;
    }
    
    
    
}
