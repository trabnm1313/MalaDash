
package maladash.src.components.Models;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import maladash.src.components.Classes.Trash;

public class TrashModel {
    private Trash t1;
    private BufferedImage img;
    private boolean imageLoaded;

    public TrashModel() {
        t1 = new Trash(false);
        imageLoaded = init();
        
        if (imageLoaded) {
            System.out.println("[Trash]: Model loaded.");
        } else {
            System.out.println("[Trash]: Model failed to load.");
        }
    }

    public Trash getT1() {
        return t1;
    }

    public void setT1(Trash t1) {
        this.t1 = t1;
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

    public boolean init() {
        URL imageFile = this.getClass().getResource("../../images/rabbit.png");
        try {
            img = ImageIO.read(imageFile);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
