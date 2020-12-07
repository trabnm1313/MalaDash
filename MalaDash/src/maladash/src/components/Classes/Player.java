package maladash.src.components.Classes;

public class Player {

    private boolean carryDish;
    private int bill;
    private boolean carryOrder;
    private boolean washing;
    private boolean ready;
    private int heart;
    private int whichTable;
    private int target;
    private Mala Mala;

    public Player() {
        this(false, 1, true, false, true, 5, 0, 0);
    }

    public Player(boolean carryDish, int bill, boolean carryOrder, boolean washing, boolean ready, int heart, int whichTable, int target) {
        this.carryDish = carryDish;
        this.bill = bill;
        this.carryOrder = carryOrder;
        this.washing = washing;
        this.ready = ready;
        this.heart = heart;
        this.whichTable = whichTable;
        this.target = target;
    }

    public Player(boolean carryDish) {
        this.carryDish = carryDish;
    }
    
    public boolean isCarryDish() {
        return carryDish;
    }

    public void setCarryDish(boolean carryDish) {
        this.carryDish = carryDish;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
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

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public int getWhichTable() {
        return whichTable;
    }

    public void setWhichTable(int whichTable) {
        this.whichTable = whichTable;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Mala getMala() {
        return Mala;
    }

    public void setMala(Mala Mala) {
        this.Mala = Mala;
    }
    
}