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
    
    //Boolean
    private boolean sameTable = false;
    
    //Integer
    private int default_X = 1076;
    private int default_Y = 250;
    private int position_X;
    private int position_Y;
    
    //Timer
    private Timer tm = new Timer(1, this);

    
    
    public PlayerController(){
        model = new PlayerModel();
        view = new PlayerView();
        view.setImg(model.getImg());
        view.setOpaque(false);
        view.setBounds(default_X, default_Y, 150, 300);
        
        
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
            travel(model.getPlayer().getWhichTable()+1);
            model.getPlayer().setReady(false);
        }
        
        if(e.getSource().equals(tm)){
            //Set player current position
            position_X = (int)view.getBounds().getX();
            position_Y = (int)view.getBounds().getY();
            
            //If select a table that player already in
            if(model.getPlayer().getTarget() == model.getPlayer().getWhichTable() && model.getPlayer().isReady()){
                tm.stop();
                sameTable = true;
            }else{
                sameTable = false;
            }
            
            if(!sameTable){

                //Go to counter
                if(model.getPlayer().getTarget() == 0){
                    if(position_Y < default_Y){
                        view.setBounds(position_X, position_Y+2, 150, 300);
                    }else if(position_Y > default_Y){
                        view.setBounds(position_X, position_Y-2, 150, 300);
                    }else if(position_X < default_X){
                        view.setBounds(position_X+2, position_Y, 150, 300);
                    }else if(position_X > default_X){
                        view.setBounds(position_X-2, position_Y, 150, 350);
                    }else{
                        tm.stop(); 
                        model.getPlayer().setWhichTable(0);
                        model.getPlayer().setReady(true);
                    }
                //Go to Table 1
                }else if(model.getPlayer().getTarget() == 1){
                    //850, default_Y+20
                    if(position_Y < default_Y+20){
                        view.setBounds(position_X, position_Y+2, 150, 300);
                    }else if(position_Y > default_Y+20){
                        view.setBounds(position_X, position_Y-2, 150, 300);
                    }else if(position_X < 850){
                        view.setBounds(position_X+2, position_Y, 150, 300);
                    }else if(position_X > 850){
                        view.setBounds(position_X-2, position_Y, 150, 350);
                    }else{
                        tm.stop(); 
                        model.getPlayer().setWhichTable(1);
                        model.getPlayer().setReady(true);
                    }
                }else if(model.getPlayer().getTarget() == 2){
                    //576, 550
                    if(position_X < 576){
                        view.setBounds(position_X+2, position_Y, 150, 300);
                    }else if(position_X > 576){
                        view.setBounds(position_X-2, position_Y, 150, 350);
                    }else if(position_Y < 550){
                        view.setBounds(position_X, position_Y+2, 150, 300);
                    }else if(position_Y > 550){
                        view.setBounds(position_X, position_Y-2, 150, 300);
                    }else{
                        tm.stop(); 
                        model.getPlayer().setWhichTable(2);
                        model.getPlayer().setReady(true);
                    }
                }else if(model.getPlayer().getTarget() == 3){
                    //1326, default_Y+20
                    if(position_Y < default_Y+20){
                        view.setBounds(position_X, position_Y+2, 150, 300);
                    }else if(position_Y > default_Y+20){
                        view.setBounds(position_X, position_Y-2, 150, 300);
                    }else if(position_X < 1326){
                        view.setBounds(position_X+2, position_Y, 150, 300);
                    }else if(position_X > 1326){
                        view.setBounds(position_X-2, position_Y, 150, 350);
                    }else{
                        tm.stop(); 
                        model.getPlayer().setWhichTable(3);
                        model.getPlayer().setReady(true);
                    }
                }else if(model.getPlayer().getTarget() == 4){
                    //1590, 550
                    if(position_X < 1590){
                        view.setBounds(position_X+2, position_Y, 150, 300);
                    }else if(position_X > 1590){
                        view.setBounds(position_X-2, position_Y, 150, 350);
                    }else if(position_Y < 550){
                        view.setBounds(position_X, position_Y+2, 150, 300);
                    }else if(position_Y > 550){
                        view.setBounds(position_X, position_Y-2, 150, 300);
                    }else{
                        tm.stop(); 
                        model.getPlayer().setWhichTable(4);
                        model.getPlayer().setReady(true);
                    }
                }
                
            }
            
        }
    }

    @Override
    public void run() {
    }
    
    
}
