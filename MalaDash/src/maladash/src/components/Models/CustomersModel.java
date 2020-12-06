package maladash.src.components.Models;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import maladash.src.components.Classes.Customers;

public class CustomersModel {

    private Customers customers;
    private boolean imageLoaded;
    private Image imgNormal, imgSad, imgSaddest;

    public CustomersModel() {
        customers = new Customers(false, false, false, 0, false);
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

}
