package maladash.src.components.Models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import maladash.src.components.Classes.Player;

public class PlayerModel {
    private Player player;
    private boolean imageLoaded;
    private ArrayList<Image> front, back, left, right;
    private URL imageFile;
    
    public PlayerModel(){
        player = new Player(false, 0, false, false, true, 5, 0, 0);
        init();
        System.out.println("[Player]: Model loaded(?).");
    }

    public void init(){
        
        //Initate
        front = new ArrayList();
        back = new ArrayList();
        left = new ArrayList();
        right = new ArrayList();
        
        //FRONT
        imageFile = this.getClass().getResource("../../images/Player/jianormal.png");
        front.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_bill.png");
        front.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_mala.png");
        front.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_bin.png");
        front.add(new ImageIcon(imageFile).getImage());

        //FRONT WITH ANIMATE
        imageFile = this.getClass().getResource("../../images/Player/jia_forward.gif");
        front.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_forward_bill.gif");
        front.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_forward_mala.gif");
        front.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_forward_bin.gif");
        front.add(new ImageIcon(imageFile).getImage());
        
        //BACK WITH ANIMATE
        imageFile = this.getClass().getResource("../../images/Player/jia_back.gif");
        back.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_back_bill.gif");
        back.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_back_mala.gif");
        back.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_back_bin.gif");
        back.add(new ImageIcon(imageFile).getImage());

        //LEFT WITH ANIMATE
        imageFile = this.getClass().getResource("../../images/Player/jia_left.gif");
        left.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_left_bill.gif");
        left.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_left_mala.gif");
        left.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_left_bin.gif");
        left.add(new ImageIcon(imageFile).getImage());
        
        //RIGHT WITH ANIMATE
        imageFile = this.getClass().getResource("../../images/Player/jia_right.gif");
        right.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_right_bill.gif");
        right.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_right_mala.gif");
        right.add(new ImageIcon(imageFile).getImage());
        imageFile = this.getClass().getResource("../../images/Player/jia_right_bin.gif");
        right.add(new ImageIcon(imageFile).getImage());
        
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

    public ArrayList<Image> getFront() {
        return front;
    }

    public void setFront(ArrayList<Image> front) {
        this.front = front;
    }

    public ArrayList<Image> getBack() {
        return back;
    }

    public void setBack(ArrayList<Image> back) {
        this.back = back;
    }

    public ArrayList<Image> getLeft() {
        return left;
    }

    public void setLeft(ArrayList<Image> left) {
        this.left = left;
    }

    public ArrayList<Image> getRight() {
        return right;
    }

    public void setRight(ArrayList<Image> right) {
        this.right = right;
    }
    
    
    
}
