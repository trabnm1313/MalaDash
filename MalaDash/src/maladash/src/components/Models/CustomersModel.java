package maladash.src.components.Models;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import maladash.src.components.Classes.Customers;

public class CustomersModel {

    private Customers customers;
    private boolean imageLoaded;
    private Image imgNormal_2, imgSad_2, imgSaddest_2, imgNormal_4, imgSad_4, imgSaddest_4;

    public CustomersModel(int people) {
        customers = new Customers(false, false, false, people, false, false, 0);
        init();
        System.out.println("[Customers]: Model loaded.");
    }

    private void init() {
        URL imageNormal_2 = this.getClass().getResource("../../images/customernormal_2.png");
        imgNormal_2 = new ImageIcon(imageNormal_2).getImage();

        URL imageSad_2 = this.getClass().getResource("../../images/customernormal_2_sad1.png");
        imgSad_2 = new ImageIcon(imageSad_2).getImage();
        
        URL imageSaddest_2 = this.getClass().getResource("../../images/customernormal_2_sad2.png");
        imgSaddest_2 = new ImageIcon(imageSaddest_2).getImage();
        
        URL imageNormal_4 = this.getClass().getResource("../../images/customernormal_4.png");
        imgNormal_4 = new ImageIcon(imageNormal_4).getImage();

        URL imageSad_4 = this.getClass().getResource("../../images/customernormal_4_sad1.png");
        imgSad_4 = new ImageIcon(imageSad_4).getImage();
        
        URL imageSaddest_4 = this.getClass().getResource("../../images/customernormal_4_sad2.png");
        imgSaddest_4 = new ImageIcon(imageSaddest_4).getImage();
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public boolean isImageLoaded() {
        return imageLoaded;
    }

    public void setImageLoaded(boolean imageLoaded) {
        this.imageLoaded = imageLoaded;
    }

    public Image getImgNormal_2() {
        return imgNormal_2;
    }

    public void setImgNormal_2(Image imgNormal_2) {
        this.imgNormal_2 = imgNormal_2;
    }

    public Image getImgSad_2() {
        return imgSad_2;
    }

    public void setImgSad_2(Image imgSad_2) {
        this.imgSad_2 = imgSad_2;
    }

    public Image getImgSaddest_2() {
        return imgSaddest_2;
    }

    public void setImgSaddest_2(Image imgSaddest_2) {
        this.imgSaddest_2 = imgSaddest_2;
    }

    public Image getImgNormal_4() {
        return imgNormal_4;
    }

    public void setImgNormal_4(Image imgNormal_4) {
        this.imgNormal_4 = imgNormal_4;
    }

    public Image getImgSad_4() {
        return imgSad_4;
    }

    public void setImgSad_4(Image imgSad_4) {
        this.imgSad_4 = imgSad_4;
    }

    public Image getImgSaddest_4() {
        return imgSaddest_4;
    }

    public void setImgSaddest_4(Image imgSaddest_4) {
        this.imgSaddest_4 = imgSaddest_4;
    }

    

    
}
