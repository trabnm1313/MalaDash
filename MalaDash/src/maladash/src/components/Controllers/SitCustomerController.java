
package maladash.src.components.Controllers;

import java.util.ArrayList;
import maladash.src.components.Models.CustomersModel;



class SitCustomerController implements Runnable{
    
    private CustomersModel model;
    private ArrayList<TableController> tableControllers;
    
    private int waitTime;
    private int minWaitTime = 25;
    private int maxWaitTime = 10;
    
    private int whichTable;
    
    private boolean stopThis = false;
    
    public SitCustomerController(){
        model = new CustomersModel();
        
        waitTime = (int)(Math.random() * maxWaitTime) + minWaitTime;
    }
    
    public void run(){
        while(true){
            if(stopThis) break;
            
            try{
                Thread.sleep(1000);
                waitTime--;
//                System.out.println("[SitCustomer][" + whichTable + "]: waitTime: " + waitTime);
//                System.out.println("[SitCustomer][" + whichTable + "]: isWait: " + model.getCustomers().isWait() + ", isEat: " + model.getCustomers().isEat() + ", isDone: " + model.getCustomers().isDone());
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            if(!stopThis){
                //Handup && ready to give order
                if(waitTime > 15 && waitTime <= 26){
                    if(!model.getCustomers().isReady()){
                        model.getCustomers().setReady(true);
                        model.getCustomers().setLvAngry(0);
                        tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                    }else if(model.getCustomers().isDone()){
                        //IF Finish eating but not collect money angrylvl = 1
                        model.getCustomers().setLvAngry(0);
                        tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                    }
                }

                if(waitTime > 5 && waitTime <= 15){
                    //If isWait(take order) && isEat(eat yet?) is false
                    if(model.getCustomers().isReady() && !model.getCustomers().isWait() && !model.getCustomers().isEat() && !model.getCustomers().isDone()){
                        model.getCustomers().setLvAngry(1);
                        tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                    }else if(model.getCustomers().isDone()){
                        //IF Finish eating but not collect money angrylvl = 2
                        model.getCustomers().setLvAngry(1);
                        tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                    }
                }

                if(waitTime > 0 && waitTime <= 5){
                    if(model.getCustomers().isReady() &&!model.getCustomers().isWait() && !model.getCustomers().isEat() && !model.getCustomers().isDone()){
                        model.getCustomers().setLvAngry(2);
                        tableControllers.get(whichTable).handUp(model.getCustomers().getLvAngry());
                    }else if(model.getCustomers().isDone()){
                        model.getCustomers().setLvAngry(2);
                        tableControllers.get(whichTable).letDirty(model.getCustomers().getLvAngry());
                    }
                }

                if(model.getCustomers().isEat()){
                    tableControllers.get(whichTable).eating();
                    if(waitTime == 0){
                        model.getCustomers().setDone(true);
                        model.getCustomers().setEat(false);
                        tableControllers.get(whichTable).getTableModel().getTable().setDirty(true);
                        waitTime = (int)(Math.random() * maxWaitTime) + minWaitTime;
                    }
                }

                if(waitTime == 0 && (!model.getCustomers().isWait() || model.getCustomers().isDone())){
                    tableControllers.get(whichTable).notDirty();
                    tableControllers.get(whichTable).getTableModel().getTable().setSitable(true);
                    tableControllers.get(whichTable).setCustomersController(null);
                    stopThis = true;
                }
            }
        }
    }

    public CustomersModel getModel() {
        return model;
    }

    public void setModel(CustomersModel model) {
        this.model = model;
    }

    public ArrayList<TableController> getTableControllers() {
        return tableControllers;
    }

    public void setTableControllers(ArrayList<TableController> tableControllers) {
        this.tableControllers = tableControllers;
    }

    public int getWhichTable() {
        return whichTable;
    }

    public void setWhichTable(int whichTable) {
        this.whichTable = whichTable;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public boolean isStopThis() {
        return stopThis;
    }

    public void setStopThis(boolean stopThis) {
        this.stopThis = stopThis;
    }
    
    
}
