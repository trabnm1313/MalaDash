
package maladash.src.components.Models;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import maladash.src.components.Classes.Mala;

public class MalaModel {
    private BufferedImage img;
    private boolean imageLoaded;
    private Mala mala;
    
    public MalaModel(int numTable){
        imageLoaded = init();
        if(imageLoaded){
            System.out.println("[MalaModel]: Image loaded.");
        }else{
            System.out.println("[MalaModel]: Image failed to loaded.");
        }
        mala = new Mala(numTable);
    }
    
    public boolean init(){
        URL imageFile = this.getClass().getResource("../../images/mala.png");
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
