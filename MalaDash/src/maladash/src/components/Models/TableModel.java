/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Models;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import maladash.src.components.Classes.Table;
/**
 *
 * @author USER
 */
public class TableModel {
    private BufferedImage img;
    private boolean imageLoaded;
    private Table table;

    public TableModel(int numTable, int sit) {
        if(numTable == 1){
            imageLoaded = init("table1.png");
            if (imageLoaded){
                System.out.println("[TableModel]: Image loaded.");
            }else{
                System.out.println("[TableModel]: Image failed to loaded.");
            }
        }else if(numTable == 2){
            imageLoaded = init("table2.png");
            if (imageLoaded){
                System.out.println("[TableModel]: Image loaded.");
            }else{
                System.out.println("[TableModel]: Image failed to loaded.");
            }
        }
        else if(numTable == 3){
            imageLoaded = init("table3.png");
            if (imageLoaded){
                System.out.println("[TableModel]: Image loaded.");
            }else{
                System.out.println("[TableModel]: Image failed to loaded.");
            }
        }
        else if(numTable == 4){
            imageLoaded = init("table4.png");
            if (imageLoaded){
                System.out.println("[TableModel]: Image loaded.");
            }else{
                System.out.println("[TableModel]: Image failed to loaded.");
            }
        }
        table = new Table(numTable, sit, true, false, false);
    }
     private boolean init(String fileName){
        URL src = this.getClass().getResource("../../images/" + fileName);
        
        try{
            this.img = ImageIO.read(src);
            return true;
        }catch(IOException err){
            err.printStackTrace();
            return false;
        }
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
     

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

}
