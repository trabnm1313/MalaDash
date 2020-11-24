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
import maladash.src.components.Views.DrawingPanel;
/**
 *
 * @author USER
 */
public class TableModel {
    private BufferedImage img;
    private boolean imageLoaded;
    private Table table1;
    private Table table2;
    private Table table3;
    private Table table4;

    public TableModel(int sit) {
        if(sit == 4){
            imageLoaded = loadImage("table1.png");
        }else if(sit == 2){
            imageLoaded = loadImage("table2.png");
        }
        table1 = new Table(4, true, false);
        table2 = new Table(4, true, false);
        table3 = new Table(2, true, false);
        table4 = new Table(2, true, false);
    }
     private boolean loadImage(String fileName){
        URL src = DrawingPanel.class.getResource("../../images/" + fileName);
        
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
     

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table table1) {
        this.table1 = table1;
    }

    public Table getTable2() {
        return table2;
    }

    public void setTable2(Table table2) {
        this.table2 = table2;
    }

    public Table getTable3() {
        return table3;
    }

    public void setTable3(Table table3) {
        this.table3 = table3;
    }

    public Table getTable4() {
        return table4;
    }

    public void setTable4(Table table4) {
        this.table4 = table4;
    }

}
