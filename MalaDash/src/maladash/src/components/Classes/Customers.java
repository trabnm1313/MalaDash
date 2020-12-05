package maladash.src.components.Classes;


public class Customers {
    private int timer;
    private boolean isSit;
    private boolean isDone;
    private boolean isEat;
    private int count;

    public Customers(){
        this(0, false, false, false, 0);
    }
    
    public Customers(int timer, boolean isSit, boolean isDone, boolean isEat, int count) {
        this.timer = timer;
        this.isSit = isSit;
        this.isDone = isDone;
        this.isEat = isEat;
        this.count = count;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public boolean isIsSit() {
        return isSit;
    }

    public void setIsSit(boolean isSit) {
        this.isSit = isSit;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public boolean isIsEat() {
        return isEat;
    }

    public void setIsEat(boolean isEat) {
        this.isEat = isEat;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
