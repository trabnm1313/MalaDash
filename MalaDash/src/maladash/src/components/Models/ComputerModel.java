package maladash.src.components.Models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import maladash.src.components.Classes.Player;

public class ComputerModel {
    private Player player;
    private boolean imageLoaded;
    private BufferedImage img;
    
    public ComputerModel(){
        player = new Player(false, 0, false, false, false, 5, 0, 0);
        imageLoaded = init();
        if(imageLoaded) System.out.println("[Computer]: Model loaded.");
        else System.out.println("[Computer]: Model fail to load.");
    }

    public boolean init(){
        URL imageFile = this.getClass().getResource("../../images/com.png");
        try{
            img = ImageIO.read(imageFile);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isImageLoaded() {
        return imageLoaded;
    }

    public void setImageLoaded(boolean imageLoaded) {
        this.imageLoaded = imageLoaded;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
