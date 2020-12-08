
package maladash.src.components.Models;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class GameModel {
    private Image gameIcon;
    private boolean imageLoaded;
    
    public GameModel(){
        imageLoaded = init();
        if(imageLoaded) System.out.println("[GameModel]: Image loaded.");
        else System.out.println("[GameModel]: Image failed to load.");
    }
    
    public boolean init(){
        URL imageFile = this.getClass().getResource("../../images/logo.png");
        try{
            gameIcon = new ImageIcon(imageFile).getImage();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public Image getGameIcon() {
        return gameIcon;
    }

    public void setGameIcon(Image gameIcon) {
        this.gameIcon = gameIcon;
    }

    public boolean isImageLoaded() {
        return imageLoaded;
    }

    public void setImageLoaded(boolean imageLoaded) {
        this.imageLoaded = imageLoaded;
    }
    
    
}
