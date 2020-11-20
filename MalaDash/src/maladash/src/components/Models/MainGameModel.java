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
        imageLoaded = loadImage("MainGameViewBG.png");
    }
    
    private boolean loadImage(String fileName){
        URL src = DrawingPanel.class.getResource("../../images/" + fileName);
        
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
