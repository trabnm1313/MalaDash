
package maladash.src.components.Models;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class MainMenuModel {
    private BufferedImage img;
    private boolean imageLoaded;
    
    public MainMenuModel(){
        imageLoaded = init();
        if(imageLoaded){
            System.out.println("[MainMenuModel]: Image loaded.");
        }else{
            System.out.println("[MainMenuModel]: Image failed to load.");
        }
    }
    
    public boolean init(){
        URL imageFile = this.getClass().getResource("../../images/menuBG.png");
        System.out.println(imageFile);
        try{
            img = ImageIO.read(imageFile);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
