package maladash.src.components.Controllers;

import java.awt.Image;
import java.awt.event.*;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.Timer;
import maladash.src.components.Models.PlayerModel;
import maladash.src.components.Views.PlayerView;

public class PlayerController implements ActionListener{
    private PlayerModel model;
    private PlayerView view;
    private JButton move;
    
    //Boolean
    private boolean sameTable = false;
    
    //Integer
    private int default_X = 1075;
    private int default_Y = 250;
    private int position_X;
    private int position_Y;
    
    //Timer
    private Timer tm = new Timer(16, this);
    
    //String
    String currentDirection = "STAND";

    //ArrayList<Image>
    ArrayList<Image> front, back, left, right;
    
    public PlayerController(){
        model = new PlayerModel();
        view = new PlayerView();
        view.setImg(model.getFront().get(0));
        view.setOpaque(false);
        view.setBounds(default_X, default_Y, 200, 300);
        
        front = model.getFront();
        back = model.getBack();
        left = model.getLeft();
        right = model.getRight();
        
        view.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("HELLO");
            }
        });
        System.out.println("[Player]: View created.");
    }
    
    public void travel(int target){
        if(model.getPlayer().isReady()){
            model.getPlayer().setTarget(target);
            model.getPlayer().setReady(false);
            tm.start();
        }
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
    
    public void stand(){
        this.view.setImg(front.get(0));
        currentDirection = "STAND";
    }
    
    public void standWithBill(){
        this.view.setImg(front.get(1));
        currentDirection = "STAND";
    }
    
    public void standWithMala(){
        this.view.setImg(front.get(2));
        currentDirection = "STAND";
    }
    
    public void standWithBin(){
        this.view.setImg(front.get(3));
        currentDirection= "STAND";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
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
                        animateChange("FRONT");
                        view.setBounds(position_X, position_Y+5, 200, 300);
                    }else if(position_Y > default_Y){
                        animateChange("BACK");
                        view.setBounds(position_X, position_Y-5, 200, 300);
                    }else if(position_X < default_X){
                        animateChange("RIGHT");
                        view.setBounds(position_X+5, position_Y, 200, 300);
                    }else if(position_X > default_X){
                        animateChange("LEFT");
                        view.setBounds(position_X-5, position_Y, 200, 350);
                    }else{
                        tm.stop(); 
                        animateChange("STAND");
                        model.getPlayer().setWhichTable(0);
                        model.getPlayer().setReady(true);
                    }
                //Go to Table 1
                }else if(model.getPlayer().getTarget() == 1){
                    //850, default_Y+20
                    if(position_Y < default_Y+20){
                        animateChange("FRONT");
                        view.setBounds(position_X, position_Y+5, 200, 300);
                    }else if(position_Y > default_Y+20){
                        animateChange("BACK");
                        view.setBounds(position_X, position_Y-5, 200, 300);
                    }else if(position_X < 850){
                        view.setBounds(position_X+5, position_Y, 200, 300);
                        animateChange("RIGHT");
                    }else if(position_X > 850){
                        animateChange("LEFT");
                        view.setBounds(position_X-5, position_Y, 200, 350);
                    }else{
                        tm.stop(); 
                        animateChange("STAND");
                        model.getPlayer().setWhichTable(1);
                        model.getPlayer().setReady(true);
                    }
                }else if(model.getPlayer().getTarget() == 2){
                    //576, 550
                    if(position_X < 575){
                        animateChange("RIGHT");
                        view.setBounds(position_X+5, position_Y, 200, 300);
                    }else if(position_X > 576){
                        animateChange("LEFT");
                        view.setBounds(position_X-5, position_Y, 200, 350);
                    }else if(position_Y < 550){
                        animateChange("FRONT");
                        view.setBounds(position_X, position_Y+5, 200, 300);
                    }else if(position_Y > 550){
                        animateChange("BACK");
                        view.setBounds(position_X, position_Y-5, 200, 300);
                    }else{
                        tm.stop(); 
                        animateChange("STAND");
                        model.getPlayer().setWhichTable(2);
                        model.getPlayer().setReady(true);
                    }
                }else if(model.getPlayer().getTarget() == 3){
                    //1326, default_Y+20
                    if(position_Y < default_Y+20){
                        animateChange("FRONT");
                        view.setBounds(position_X, position_Y+5, 200, 300);
                    }else if(position_Y > default_Y+20){
                        animateChange("BACK");
                        view.setBounds(position_X, position_Y-5, 200, 300);
                    }else if(position_X < 1325){
                        animateChange("RIGHT");
                        view.setBounds(position_X+5, position_Y, 200, 300);
                    }else if(position_X > 1325){
                        animateChange("LEFT");
                        view.setBounds(position_X-5, position_Y, 200, 350);
                    }else{
                        tm.stop(); 
                        animateChange("STAND");
                        model.getPlayer().setWhichTable(3);
                        model.getPlayer().setReady(true);
                    }
                }else if(model.getPlayer().getTarget() == 4){
                    //1590, 550
                    if(position_X < 1590){
                        animateChange("RIGHT");
                        view.setBounds(position_X+5, position_Y, 200, 300);
                    }else if(position_X > 1590){
                        animateChange("LEFT");
                        view.setBounds(position_X-5, position_Y, 200, 350);
                    }else if(position_Y < 550){
                        animateChange("FRONT");
                        view.setBounds(position_X, position_Y+5, 200, 300);
                    }else if(position_Y > 550){
                        animateChange("BACK");
                        view.setBounds(position_X, position_Y-5, 200, 300);
                    }else{
                        tm.stop();
                        animateChange("STAND");
                        model.getPlayer().setWhichTable(4);
                        model.getPlayer().setReady(true);
                    }
                }
                
            }
            
        }
    }
    
    public void animateChange(String direction){
        
        //LEFT
        if(!model.getPlayer().isCarryOrder() && !model.getPlayer().isCarryDish() && !model.getPlayer().isWashing()){
            
            if(direction.equals("LEFT") && !direction.equals(currentDirection)){
                view.setImg(left.get(0));
                currentDirection = "LEFT";
            }
            if(direction.equals("RIGHT") && !direction.equals(currentDirection)){
                view.setImg(right.get(0));
                currentDirection = "RIGHT";
            }
            if(direction.equals("BACK") && !direction.equals(currentDirection)){
                view.setImg(back.get(0));
                currentDirection = "BACK";
            }
            if(direction.equals("FRONT") && !direction.equals(currentDirection)){
                view.setImg(front.get(4));
                currentDirection = "FRONT";
            }
            if(direction.equals("STAND") && !direction.equals(currentDirection)){
                view.setImg(front.get(0));
                currentDirection = "STAND";
            }
        
        }else if(model.getPlayer().isCarryOrder()){
        
            if(direction.equals("LEFT") && !direction.equals(currentDirection)){
                view.setImg(left.get(1));
                currentDirection = "LEFT";
            }
            if(direction.equals("RIGHT") && !direction.equals(currentDirection)){
                view.setImg(right.get(1));
                currentDirection = "RIGHT";
            }
            if(direction.equals("BACK") && !direction.equals(currentDirection)){
                view.setImg(back.get(1));
                currentDirection = "BACK";
            }
            if(direction.equals("FRONT") && !direction.equals(currentDirection)){
                view.setImg(front.get(5));
                currentDirection = "FRONT";
            }
            if(direction.equals("STAND") && !direction.equals(currentDirection)){
                view.setImg(front.get(1));
                currentDirection = "STAND";
            }
        
        }else if(model.getPlayer().isCarryDish()){
        
            if(direction.equals("LEFT") && !direction.equals(currentDirection)){
                view.setImg(left.get(2));
                currentDirection = "LEFT";
            }
            if(direction.equals("RIGHT") && !direction.equals(currentDirection)){
                view.setImg(right.get(2));
                currentDirection = "RIGHT";
            }
            if(direction.equals("BACK") && !direction.equals(currentDirection)){
                view.setImg(back.get(2));
                currentDirection = "BACK";
            }
            if(direction.equals("FRONT") && !direction.equals(currentDirection)){
                view.setImg(front.get(6));
                currentDirection = "FRONT";
            }
            if(direction.equals("STAND") && !direction.equals(currentDirection)){
                view.setImg(front.get(2));
                currentDirection = "STAND";
            }
        
        }else if(model.getPlayer().isWashing()){
        
            if(direction.equals("LEFT") && !direction.equals(currentDirection)){
                view.setImg(left.get(3));
                currentDirection = "LEFT";
            }
            if(direction.equals("RIGHT") && !direction.equals(currentDirection)){
                view.setImg(right.get(3));
                currentDirection = "RIGHT";
            }
            if(direction.equals("BACK") && !direction.equals(currentDirection)){
                view.setImg(back.get(3));
                currentDirection = "BACK";
            }
            if(direction.equals("FRONT") && !direction.equals(currentDirection)){
                view.setImg(front.get(7));
                currentDirection = "FRONT";
            }
            if(direction.equals("STAND") && !direction.equals(currentDirection)){
                view.setImg(front.get(3));
                currentDirection = "STAND";
            }
        
        }
    }
    
}
