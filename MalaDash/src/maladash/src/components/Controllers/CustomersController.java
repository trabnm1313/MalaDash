package maladash.src.components.Controllers;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import maladash.src.components.Models.CustomersModel;
import maladash.src.components.Views.CustomersView;

public class CustomersController implements ActionListener {

    private CustomersModel model;
    private CustomersView view;
    private Timer tm = new Timer(1000, this);
    private int time;
    private Point prevPt, curPt, newPt;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public CustomersController() {
        model = new CustomersModel();
        view = new CustomersView();

        time = (int) (Math.random() * 10) + 30;
        tm.start();

        view.setImg(model.getImgNormal());
        view.setOpaque(false);
        view.setBounds(500, 350, 100, 250);

        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prevPt = SwingUtilities.convertPoint(view, e.getPoint(), view.getParent());
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                prevPt = null;
            }
        });

        view.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                curPt = SwingUtilities.convertPoint(view, e.getPoint(), view.getParent());
                if (view.getParent().getBounds().contains(curPt)) {
                    newPt = view.getLocation();
                    newPt.translate(curPt.x - prevPt.x, curPt.y - prevPt.y);
                    newPt.x = Math.max(newPt.x, 0);
                    newPt.y = Math.max(newPt.y, 0);
                    newPt.x = Math.min(newPt.x, view.getParent().getWidth() - view.getWidth());
                    newPt.y = Math.min(newPt.y, view.getParent().getHeight() - view.getHeight());
                    view.setLocation(newPt);
                    prevPt = curPt;
                }
            }
        });
    }

    public CustomersModel getModel() {
        return model;
    }

    public void setModel(CustomersModel model) {
        this.model = model;
    }

    public CustomersView getView() {
        return view;
    }

    public void setView(CustomersView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(tm)) {
            time--;
            System.out.println(time);
            if (time <= 20) {
                view.setImg(model.getImgSad());
            }
            if (time <= 10) {
                view.setImg(model.getImgSaddest());
            }
            if (time <= 0) {
                System.out.println("dead");
                tm.stop();
            }
        }
    }

}
