// ยังไม่เสร็จขอ commit ไปก่อน เดี๋ยวไฟล์หายอิเวน

package maladash.src.components.Views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class CustomersView extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.black);
        g2D.fillRect(0, 0, (int)this.getSize().getWidth(), (int)this.getSize().getHeight());
    }
}
