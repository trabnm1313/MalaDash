
package maladash.src.components.Models;

import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HeartModel {
    private Image img;
    private boolean imageLoaded;
    
    public HeartModel(){
        imageLoaded = init();
        if(imageLoaded){
            System.out.println("[HeartModel]: Image loaded.");
        }else{
            System.out.println("[HeartModel]: Image failed to load.");
        }
    }
    
    public boolean init(){
        URL imageFile = this.getClass().getResource("../../images/heartfull.png");
        System.out.println(imageFile);
        try{
            img = new ImageIcon(imageFile).getImage();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
