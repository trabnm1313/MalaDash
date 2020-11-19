/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maladash.src.components.Classes;

/**
 *
 * @author USER
 */
public class Table {
    private int chair;
    private boolean sitable;
    private boolean drity;

    public Table(int chair, boolean sitable, boolean drity) {
        this.chair = chair;
        this.sitable = sitable;
        this.drity = drity;
    }



    public int getChair() {
        return chair;
    }

    public void setChair(int chair) {
        this.chair = chair;
    }

    public boolean isSitable() {
        return sitable;
    }

    public void setSitable(boolean sitable) {
        this.sitable = sitable;
    }

    public boolean isDrity() {
        return drity;
    }

    public void setDrity(boolean drity) {
        this.drity = drity;
    }
    
    
}
