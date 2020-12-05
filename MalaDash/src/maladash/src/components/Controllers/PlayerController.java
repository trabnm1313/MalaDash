package maladash.src.components.Controllers;

import java.awt.event.*;
import static java.lang.Thread.sleep;
import javax.swing.JButton;
import javax.swing.Timer;
import maladash.src.components.Models.PlayerModel;
import maladash.src.components.Views.PlayerView;

public class PlayerController implements ActionListener, Runnable{
    private PlayerModel model;
    private PlayerView view;
    private JButton move;
    private int tm_count = 0;
    private Timer tm = new Timer(1, this);
    private boolean isPositionReseted = false;
    
    public PlayerController(){
        model = new PlayerModel();
        view = new PlayerView();
        view.setImg(model.getImg());
        
        
        view.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("HELLO");
            }
        });
        System.out.println("[Player]: View created.");
    }
    
    public void travel(int target){
        model.getPlayer().setTarget(target);
        tm.start();
    }

    public PlayerModel getModel() {
        return model;
    }

    public void setModel(PlayerModel model) {
        this.model = model;
    }

    public PlayerView getView() {
        return view;
    }

    public void setView(PlayerView view) {
        this.view = view;
    }

    public JButton getMove() {
        return move;
    }

    public void setMove(JButton move) {
        this.move = move;
        move.addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(move)){
            travel(1);
        }
        
        if(e.getSource().equals(tm)){
            //If select a table that player already in
            if(model.getPlayer().getTarget() == model.getPlayer().getWhichTable()){
                tm.stop();
                tm_count = -1;
            }
            
            
            if(tm_count != -1){
                if(isPositionReseted){

                    if(model.getPlayer().getTarget() == 1){
                        tm.stop();
                    }else if(model.getPlayer().getTarget() == 2){
                        tm.stop();
                    }else if(model.getPlayer().getTarget() == 3){
                        tm.stop();
                    }else if(model.getPlayer().getTarget() == 4){
                        tm.stop();
                    }

                }else{

                    if(view.getBounds().getY() < 275){
                        view.setBounds((int)view.getBounds().getX(), (int)view.getBounds().getY()+1, 300, 300);
                    }else if(view.getBounds().getY() > 275){
                        view.setBounds((int)view.getBounds().getX(), (int)view.getBounds().getY()-1, 300, 300);
                    }else if(view.getBounds().getX() < 950){
                        view.setBounds((int)view.getBounds().getX()+1, (int)view.getBounds().getY(), 300, 300);
                    }else if(view.getBounds().getX() > 950){
                        view.setBounds((int)view.getBounds().getX()-1, (int)view.getBounds().getY(), 300, 300);
                    }else{
                        isPositionReseted = true;
                    }
                    
                }
            }
            
            
            tm_count++;
            System.out.println(tm_count);
        }
    }

    @Override
    public void run() {
    }
    
    
}
