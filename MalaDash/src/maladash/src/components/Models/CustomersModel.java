package maladash.src.components.Models;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import maladash.src.components.Classes.Customers;

public class CustomersModel {

    private Customers customers;
    private boolean imageLoaded;
    private Image imgNormal, imgSad, imgSaddest, imgHandUp, imgHandUpSad, imgEat;

    public CustomersModel() {
        customers = new Customers(false, false, false, 0, false, false);
        init();
        System.out.println("[Customers]: Model loaded.");
    }

    private void init() {
        URL imageNormal = this.getClass().getResource("../../images/customernormal.png");
        imgNormal = new ImageIcon(imageNormal).getImage();

        URL imageSad = this.getClass().getResource("../../images/customer-sad1.png");
        imgSad = new ImageIcon(imageSad).getImage();
        
        URL imageSaddest = this.getClass().getResource("../../images/customer-sad2.png");
        imgSaddest = new ImageIcon(imageSaddest).getImage();
        
//        URL imageHandUp = this.getClass().getResource("../../images/customer_puthand.png");
//        imgHandUp = new ImageIcon(imageHandUp).getImage();
//        
//        URL imageHandUpSad = this.getClass().getResource("../../images/customer_puthand_sad1.png");
//        imgHandUpSad = new ImageIcon(imageHandUpSad).getImage();
//        
//        URL imageEat = this.getClass().getResource("../../images/customer_eat.png");
//        imgEat = new ImageIcon(imageEat).getImage();
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

    public Image getImgNormal() {
        return imgNormal;
    }

    public void setImgNormal(Image imgNormal) {
        this.imgNormal = imgNormal;
    }

    public Image getImgSad() {
        return imgSad;
    }

    public void setImgSad(Image imgSad) {
        this.imgSad = imgSad;
    }

    public Image getImgSaddest() {
        return imgSaddest;
    }

    public void setImgSaddest(Image imgSaddest) {
        this.imgSaddest = imgSaddest;
    }

    public Image getImgHandUp() {
        return imgHandUp;
    }

    public void setImgHandUp(Image imgHandUp) {
        this.imgHandUp = imgHandUp;
    }

    public Image getImgHandUpSad() {
        return imgHandUpSad;
    }

    public void setImgHandUpSad(Image imgHandUpSad) {
        this.imgHandUpSad = imgHandUpSad;
    }

    public Image getImgEat() {
        return imgEat;
    }

    public void setImgEat(Image imgEat) {
        this.imgEat = imgEat;
    }

    
}
