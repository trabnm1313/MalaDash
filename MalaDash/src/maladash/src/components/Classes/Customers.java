package maladash.src.components.Classes;


public class Customers {
    private boolean sit;
    private boolean done;
    private boolean eat;
    private int count;
    private boolean ready;
    private boolean wait;
    private int lvAngry;

    public Customers(){
        this(false, false, false, 0, false, false, 0);
    }

    public Customers(boolean sit, boolean done, boolean eat, int count, boolean ready, boolean wait, int lvAngry) {
        this.sit = sit;
        this.done = done;
        this.eat = eat;
        this.count = count;
        this.ready = ready;
        this.lvAngry = lvAngry;
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
    
    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public int getLvAngry() {
        return lvAngry;
    }

    public void setLvAngry(int lvAngry) {
        this.lvAngry = lvAngry;
    }
    
}
