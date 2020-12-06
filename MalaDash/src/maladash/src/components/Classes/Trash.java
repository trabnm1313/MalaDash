
package maladash.src.components.Classes;


public class Trash {
    private boolean trash;
    
    public Trash(){
        this(false);
    }

    public Trash(boolean trash) {
        this.trash = trash;
    }

    public boolean isTrash() {
        return trash;
    }

    public void setTrash(boolean trash) {
        this.trash = trash;
    }
    
    
}
