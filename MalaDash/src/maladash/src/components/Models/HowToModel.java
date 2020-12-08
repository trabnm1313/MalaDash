
package maladash.src.components.Models;

import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HowToModel {
    private Image img;
    private boolean imageLoaded;
    
    public HowToModel(){
        imageLoaded = init();
        if(imageLoaded){
            System.out.println("[HowToModel]: Image loaded.");
        }else{
            System.out.println("[HowToModel]: Image failed to load.");
        }
    }
    
    public boolean init(){
        URL imageFile = this.getClass().getResource("../../images/tutorial.png");
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
