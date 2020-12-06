package maladash.src.components.Classes;


public class Customers {
    private int timer;
    private boolean sit;
    private boolean done;
    private boolean eat;
    private int count;
    private boolean ready;

    public Customers(){
        this(0, false, false, false, 0, false);
    }

    public Customers(int timer, boolean sit, boolean done, boolean eat, int count, boolean ready) {
        this.timer = timer;
        this.sit = sit;
        this.done = done;
        this.eat = eat;
        this.count = count;
        this.ready = ready;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public boolean isSit() {
        return sit;
    }

    public void setSit(boolean sit) {
        this.sit = sit;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isEat() {
        return eat;
    }

    public void setEat(boolean eat) {
        this.eat = eat;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
    
    
    
}
