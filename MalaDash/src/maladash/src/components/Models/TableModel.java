/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Models;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import maladash.src.components.Classes.Table;
/**
 *
 * @author USER
 */
public class TableModel {
    private Image img;
    private boolean imageLoaded;
    private Table table;

    public TableModel(int numTable, int sit) {
        //set image
        if(numTable == 1){
            imageLoaded = init(numTable,"table1.png");
        }else if(numTable == 2){
            imageLoaded = init(numTable, "table2.png");
        }
        else if(numTable == 3){
            imageLoaded = init(numTable, "table3.png");
        }
        else if(numTable == 4){
            imageLoaded = init(numTable, "table4.png");
        }
        //check load image
        if (imageLoaded) {
            System.out.println("[TableModel]: Image loaded.");
        } else {
            System.out.println("[TableModel]: Image failed to load.");
        }
        table = new Table(numTable, sit, true, false, false);
    }
     public boolean init(int numTable, String fileName){
        URL src = this.getClass().getResource("../../images/Table/"+ numTable +"/"+ fileName);
        
        try{
            this.img = new ImageIcon(src).getImage();
            return true;
        }catch(Exception err){
            err.printStackTrace();
            return false;
        }
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public boolean isImageLoaded() {
        return imageLoaded;
    }

    public void setImageLoaded(boolean imageLoaded) {
        this.imageLoaded = imageLoaded;
    }
     

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

}
