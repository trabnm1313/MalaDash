
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
            System.out.println("[MalaModel]: Image failed to load.");
        }
        mala = new Mala(numTable);
    }
    
    public boolean init(){
        URL imageFile = this.getClass().getResource("../../images/mala.png");
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

    public Mala getMala() {
        return mala;
    }

    public void setMala(Mala mala) {
        this.mala = mala;
    }
    
}
