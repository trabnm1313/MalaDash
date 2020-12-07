package maladash.src.components.Models;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainGameModel {
    private BufferedImage img;
    private boolean imageLoaded;
    private JPanel player;
    private int money;
    
    public MainGameModel(){
        imageLoaded = init();
        if(imageLoaded){
            System.out.println("[MainGame]: Image loaded.");
        }else{
            System.out.println("[MainGame]: Image failed to load.");
        }
    }
    
    private boolean init(){
        URL src = this.getClass().getResource("../../images/MainGameViewBG.png");
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

    public JPanel getPlayer() {
        return player;
    }

    public void setPlayer(JPanel player) {
        this.player = player;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    
}
