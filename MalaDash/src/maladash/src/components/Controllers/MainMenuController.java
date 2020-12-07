package maladash.src.components.Controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import maladash.src.components.Models.MainMenuModel;
import maladash.src.components.Views.MainMenuView;

public class MainMenuController implements ActionListener {

    private MainMenuView view;
    private MainMenuModel model;
    private GameController game;
    private MainGameController mainGame;
    private HowToController howTo;
            
    public MainMenuController() {
        //Init
        model = new MainMenuModel();
        view = new MainMenuView();
        view.setImg(model.getImg());

        
        //Add ActionListener
        view.getStartButton().addActionListener(this);
        view.getOptionButton().addActionListener(this);
        view.getExitButton().addActionListener(this);
    }

    public MainMenuView getView() {
        return view;
    }

    public void setView(MainMenuView view) {
        this.view = view;
    }

    public MainMenuModel getModel() {
        return model;
    }

    public void setModel(MainMenuModel model) {
        this.model = model;
    }

    public GameController getGame() {
        return game;
    }

    public void setGame(GameController game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //IF startButton clicked
        if (e.getSource().equals(view.getStartButton())) {
            //Initate Controller
            mainGame = new MainGameController();

            //Short Variable
            JFrame gameFrame = game.getView().getFrame();

            //Change ContentPane from MainMenu to MainGame
            gameFrame.setContentPane(mainGame.getView());
            gameFrame.setSize(1920, 1080);

            gameFrame.getContentPane().revalidate();
            gameFrame.getContentPane().repaint();
            gameFrame.setVisible(true);

        }

        //IF optionButton clicked
        if (e.getSource().equals(view.getOptionButton())) {
            //Initate Controller
            howTo = new HowToController();
            
            howTo.setGame(game);

            //Short Variable
            JFrame gameFrame = game.getView().getFrame();

            //Change ContentPane from MainMenu to MainGame
            gameFrame.setContentPane(howTo.getView());
            gameFrame.setSize(1920, 1080);

            gameFrame.getContentPane().revalidate();
            gameFrame.getContentPane().repaint();
            gameFrame.setVisible(true);
        }

        //IF exitButton clicked
        if (e.getSource().equals(view.getExitButton())) {
            JDialog dialog = new JDialog(new JFrame(), "Exit?");
            dialog.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            JPanel exitPanel = new JPanel();
            JLabel exitText = new JLabel("Are you sure?", SwingConstants.CENTER);
            JButton yes = new JButton("Yes"), no = new JButton("No");
            yes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            no.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });

            exitPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.ipady = 10;
            gbc.ipadx = 40;
            gbc.fill = GridBagConstraints.BOTH;

            gbc.gridheight = 1;
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 0;
            exitPanel.add(exitText, gbc);

            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 1;
            exitPanel.add(yes, gbc);

            gbc.gridx = 1;
            exitPanel.add(no, gbc);

            dialog.add(exitPanel);
            dialog.pack();
            dialog.setVisible(true);
        }

        
    }
}
