
package maladash.src.components.Controllers;

import maladash.src.components.Models.MainMenuModel;
import maladash.src.components.Views.GameView;

public class GameController {
    GameView view;
    MainMenuController menu;
    
    public GameController(){
        view = new GameView();
        menu = new MainMenuController();
        menu.setGame(this);
        
        view.init();
        view.getFrame().setContentPane(menu.getView());
        
    }

    public GameView getView() {
        return view;
    }

    public void setView(GameView view) {
        this.view = view;
    }
    
    
}