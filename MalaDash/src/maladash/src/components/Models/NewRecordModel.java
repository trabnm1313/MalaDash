/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Models;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
/**
 *
 * @author USER
 */
public class NewRecordModel {
        private Image img;
    private boolean imageLoaded;
    
    public NewRecordModel(){
        imageLoaded = init();
        if(imageLoaded){
            System.out.println("[HeartModel]: Image loaded.");
        }else{
            System.out.println("[HeartModel]: Image failed to load.");
        }
    }
    
    public boolean init(){
        URL imageFile = this.getClass().getResource("../../images/newrecord.gif");
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
