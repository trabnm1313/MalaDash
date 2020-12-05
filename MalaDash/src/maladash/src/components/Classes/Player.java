package maladash.src.components.Classes;

public class Player {
    private boolean carryDish;
    private int bill;
    private boolean carryOrder;
    private boolean washing;
    private boolean ready;
    private int heart;

    public Player() {
        this(false, 0, false, false, false, 5);
    }

    public Player(boolean carryDish, int bill, boolean carryOrder, boolean washing, boolean ready, int heart) {
        this.carryDish = carryDish;
        this.bill = bill;
        this.carryOrder = carryOrder;
        this.washing = washing;
        this.ready = ready;
        this.heart = heart;
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
    
    
}