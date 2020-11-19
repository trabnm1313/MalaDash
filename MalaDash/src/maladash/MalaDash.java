package maladash;

import maladash.src.components.Classes.*;

public class MalaDash {

    public static void main(String[] args) {
        System.out.println("Hello Maladash Project!");
        MainMenu menu = new MainMenu();
        Player p1 = new Player();
        System.out.println(p1.isCarryBill());
    }
    
}
