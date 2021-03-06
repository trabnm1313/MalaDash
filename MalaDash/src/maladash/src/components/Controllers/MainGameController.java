package maladash.src.components.Controllers;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import maladash.src.components.Models.MainGameModel;
import maladash.src.components.Views.MainGameView;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class MainGameController {

    private posterController poster;
    private MainGameView view;
    private MainGameModel model;
    private ArrayList<TableController> tableControllers;
    private JPanel table1, table2, table3, table4, mala1, mala2, mala3, mala4, h1, h2, h3, h4, h5;
    private CustomersController customer1, customer2, customer3;
    private ArrayList<MalaController> malaController;
    private JLabel money;
    private PlayerController player;
    private ComputerController computer;
    private TrashController trash;
    private CustomersController customers;
    private GameController game;
    private ArrayList<HeartController> hearts;
    private MainMenuController menu;
    private int highScore;
    private ArrayList<AudioInputStream> audioList = new ArrayList();
    private Clip bgm, bgm2, bgm3;

    public void init() {
        //Initate Model
        model = new MainGameModel();
        view = new MainGameView();
        view.setImg(model.getImg());
        view.setLayout(null);
        
        try (FileReader fin = new FileReader("HighScore.dat")) {
                    int i;
                    while ((i = fin.read()) != -1) {
                        highScore = i;
                    }
                } catch (IOException er) {
                    System.out.print(er);}
        System.out.println(highScore);

        //Player
        player = new PlayerController();

        Thread tPlayer = new Thread(player);
        tPlayer.start();
        
        //heart
        hearts = new ArrayList();

        for (int i = 0; i < 5; i++) {
            hearts.add(new HeartController(i));
        }
        h1 = hearts.get(0).getView();
        h2 = hearts.get(1).getView();
        h3 = hearts.get(2).getView();
        h4 = hearts.get(3).getView();
        h5 = hearts.get(4).getView();

        //money
        money = new JLabel(model.getMoney() + "");
        money.setFont(new Font("Serif", Font.BOLD, 72));
        money.setSize(200, 100);
        money.setBounds(1700, 5, 200, 100);

        //table
        tableControllers = new ArrayList();
        for (int i = 1; i <= 4; i++) {
            if (i <= 2) {
                tableControllers.add(new TableController(i, 4));
            } else {
                tableControllers.add(new TableController(i, 2));
            }
        }
        tableControllers.get(0).setMainGame(this);
        tableControllers.get(1).setMainGame(this);
        tableControllers.get(2).setMainGame(this);
        tableControllers.get(3).setMainGame(this);

        tableControllers.get(0).setText(money);
        tableControllers.get(1).setText(money);
        tableControllers.get(2).setText(money);
        tableControllers.get(3).setText(money);

        tableControllers.get(0).setPlayerController(player);
        tableControllers.get(1).setPlayerController(player);
        tableControllers.get(2).setPlayerController(player);
        tableControllers.get(3).setPlayerController(player);

        table1 = tableControllers.get(0).getTableView();
        table2 = tableControllers.get(1).getTableView();
        table3 = tableControllers.get(2).getTableView();
        table4 = tableControllers.get(3).getTableView();

        //Mala
        malaController = new ArrayList();
        for (int i = 1; i <= 4; i++) {
            malaController.add(new MalaController(i));
        }

        mala1 = malaController.get(0).getMalaView();
        mala2 = malaController.get(1).getMalaView();
        mala3 = malaController.get(2).getMalaView();
        mala4 = malaController.get(3).getMalaView();

        malaController.get(0).setPlayerController(player);
        malaController.get(1).setPlayerController(player);
        malaController.get(2).setPlayerController(player);
        malaController.get(3).setPlayerController(player);

        //Bill
        computer = new ComputerController();
        computer.setMalaController(malaController);
        computer.setPlayer(player);
        poster = new posterController();
        poster.getPoster().setOpaque(false);
        poster.setPlayer(player);
        poster.getPoster().setBounds(935, 337, 412, 150);

        //Trash
        trash = new TrashController();
        trash.setPlayerController(player);

        //Customers
        customer1 = new CustomersController();
        customer2 = new CustomersController();
        customer3 = new CustomersController();
        //Customers Configuration
        customer1.setTableControllers(tableControllers);
        customer2.setTableControllers(tableControllers);
        customer3.setTableControllers(tableControllers);
        
        customer1.setPlayer(player);
        customer1.setHeats(hearts);
        customer1.setGame(this);
        customer1.setGameCon(game);
        customer1.setMenu(menu);
        
        customer2.setPlayer(player);
        customer2.setHeats(hearts);
        customer2.setGame(this);
        customer2.setGameCon(game);
        customer2.setMenu(menu);
        
        customer3.setPlayer(player);
        customer3.setHeats(hearts);
        customer3.setGame(this);
        customer3.setGameCon(game);
        customer3.setMenu(menu);
        
        //Init
        customer1.init();
        customer2.init();
        customer3.init();
        //Customers Thread
        Thread tCustomer1 = new Thread(customer1);
        Thread tCustomer2 = new Thread(customer2);
        Thread tCustomer3 = new Thread(customer3);
        tCustomer1.start();
        tCustomer2.start();
        tCustomer3.start();


        //Add to view
        view.add(h1);
        view.add(h2);
        view.add(h3);
        view.add(h4);
        view.add(h5);

        view.add(money);

        view.add(table2);
        view.add(table4);

        view.add(player.getView());
        
        view.add(customer1.getView());
        view.add(customer2.getView());
        view.add(customer3.getView());

        view.add(table1);
        view.add(table3);

        view.add(mala1);
        view.add(mala2);
        view.add(mala3);
        view.add(mala4);

        view.add(computer.getView());

        view.add(trash.getTrashView());

        view.add(poster.getPoster());
    }
    
    public void audioInit(){
        try{
            URL path = this.getClass().getResource("../../audio/menuBGM.wav");
            File audioFile = new File(path.toURI());
            audioList.add(AudioSystem.getAudioInputStream(audioFile));
            path = this.getClass().getResource("../../audio/click.wav");
            audioFile = new File(path.toURI());
            audioList.add(AudioSystem.getAudioInputStream(audioFile));
            path = this.getClass().getResource("../../audio/gameBGM.wav");
            audioFile = new File(path.toURI());
            audioList.add(AudioSystem.getAudioInputStream(audioFile));
            
            bgm = AudioSystem.getClip();
            bgm2 = AudioSystem.getClip();
            bgm3 = AudioSystem.getClip();
            
            //Buffered
            bgm.open(audioList.get(0));
            //Audio Change
            FloatControl gainControl = (FloatControl)bgm.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-15.0f);
            
            bgm2.open(audioList.get(1));
            
            bgm3.open(audioList.get(2));
            gainControl = (FloatControl)bgm3.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-15.0f);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void clickedSound(){
        bgm2.setFramePosition(0);
        bgm2.start();
    }
    
    public void startBGM(){
        bgm3.start();
    }
    
    public void stopBGM(){
        bgm3.stop();
    }
    
    public void resetBGM(){
        bgm3.setFramePosition(0);
    }

    public MainGameView getView() {
        return view;
    }

    public void setView(MainGameView view) {
        this.view = view;
    }

    public MainGameModel getModel() {
        return model;
    }

    public void setModel(MainGameModel model) {
        this.model = model;
    }

    public GameController getGame() {
        return game;
    }

    public void setGame(GameController game) {
        this.game = game;
    }

    public MainMenuController getMenu() {
        return menu;
    }

    public void setMenu(MainMenuController menu) {
        this.menu = menu;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public CustomersController getCustomer1() {
        return customer1;
    }

    public void setCustomer1(CustomersController customer1) {
        this.customer1 = customer1;
    }

    public CustomersController getCustomer2() {
        return customer2;
    }

    public void setCustomer2(CustomersController customer2) {
        this.customer2 = customer2;
    }

    public CustomersController getCustomer3() {
        return customer3;
    }

    public void setCustomer3(CustomersController customer3) {
        this.customer3 = customer3;
    }
    
    
    

}
