package maladash.src.components.Classes;

public class Player {
    private boolean carryDish;
    private boolean carryBill;
    private boolean carryOrder;
    private boolean washing;
    private boolean ready;
    private int whichTable;
    private int heart;

    public Player() {
        this(false, false, false, false, false, 0, 5);
    }
    
    public Player(boolean isCarryDish, boolean isCarryBill, boolean isCarryOrder, boolean isWashing, boolean isReady, int whichTable, int heart) {
        this.carryDish = isCarryDish;
        this.carryBill = isCarryBill;
        this.carryOrder = isCarryOrder;
        this.washing = isWashing;
        this.ready = ready;
        this.whichTable = whichTable;
        this.heart = heart;
    }
    
    public boolean isCarryDish() {
        return carryDish;
    }

    public void setCarryDish(boolean carryDish) {
        this.carryDish = carryDish;
    }

    public boolean isCarryBill() {
        return carryBill;
    }

    public void setCarryBill(boolean CarryBill) {
        this.carryBill = CarryBill;
    }

    public boolean isCarryOrder() {
        return carryOrder;
    }

    public void setCarryOrder(boolean CarryOrder) {
        this.carryOrder = CarryOrder;
    }

    public boolean isWashing() {
        return washing;
    }

    public void setWashing(boolean Washing) {
        this.washing = Washing;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getWhichTable() {
        return whichTable;
    }

    public void setWhichTable(int whichTable) {
        this.whichTable = whichTable;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }
    
    
}
