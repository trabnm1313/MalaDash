package maladash.src.components.Models;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import maladash.src.components.Views.DrawingPanel;

public class MainGameModel {
    private BufferedImage img;
    private boolean imageLoaded;
    
    public MainGameModel(){
        imageLoaded = init();
        if(imageLoaded){
            System.out.println("[MainGameModel]: Image loaded.");
        }else{
            System.out.println("[MainGameModel]: Image failed to loaded.");
        }
    }
    
    private boolean init(){
        URL src = DrawingPanel.class.getResource("../../images/MainGameViewBG.png");
        try{
            this.img = ImageIO.read(src);
            return true;
        }catch(IOException err){
            err.printStackTrace();
            return false;
        }
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public boolean isImageLoaded() {
        return imageLoaded;
    }

    public void setImageLoaded(boolean imageLoaded) {
        this.imageLoaded = imageLoaded;
    }
    
}
