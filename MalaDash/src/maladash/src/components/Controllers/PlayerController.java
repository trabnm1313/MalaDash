package maladash.src.components.Controllers;

import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.Timer;
import maladash.src.components.Models.PlayerModel;
import maladash.src.components.Views.PlayerView;

public class PlayerController implements ActionListener, Runnable{
    private PlayerModel model;
    private PlayerView view;
    private JButton move;
    
    //Boolean
    private boolean isPositionReseted = false;
    private boolean isMoving = false;
    private boolean sameTable = false;
    
    //Integer
    private int default_X = 1075;
    private int default_Y = 250;
    
    //Timer
    private Timer tm = new Timer(1, this);
    
    //mock
    Random rand = new Random();
    
    
    public PlayerController(){
        model = new PlayerModel();
        view = new PlayerView();
        view.setImg(model.getImg());
        view.setOpaque(false);
        view.setBounds(default_X+rand.nextInt(500) + 1, default_Y+rand.nextInt(500)+1, 150, 300);
        
        
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
                sameTable = true;
            }
            
            
            if(!sameTable){
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

                    if(view.getBounds().getY() < default_Y){
                        view.setBounds((int)view.getBounds().getX(), (int)view.getBounds().getY()+1, 150, 300);
                    }else if(view.getBounds().getY() > default_Y){
                        view.setBounds((int)view.getBounds().getX(), (int)view.getBounds().getY()-1, 150, 300);
                    }else if(view.getBounds().getX() < default_X){
                        view.setBounds((int)view.getBounds().getX()+1, (int)view.getBounds().getY(), 150, 300);
                    }else if(view.getBounds().getX() > default_X){
                        view.setBounds((int)view.getBounds().getX()-1, (int)view.getBounds().getY(), 150, 350);
                    }else{
                        isPositionReseted = true;
                    }
                    
                }
            }
            
        }
    }

    @Override
    public void run() {
    }
    
    
}
