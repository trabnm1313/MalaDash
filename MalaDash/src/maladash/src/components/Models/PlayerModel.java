package maladash.src.components.Models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import maladash.src.components.Classes.Player;

public class PlayerModel {
    private Player player;
    private boolean imageLoaded;
    private Image img;
    
    public PlayerModel(){
        player = new Player(false, 0, false, false, true, 5, 0, 0);
        init();
        System.out.println("[Player]: Model loaded(?).");
    }

    public void init(){
        URL imageFile = this.getClass().getResource("../../images/Player/jianormal.png");
        img = new ImageIcon(imageFile).getImage();
        
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
}
