package maladash.src.components.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameOverView extends JPanel{
    //Coponents
    private Image img;
    private JButton tryagain, exited;
    private JLabel score, highScore;

    public GameOverView() {
        
        score = new JLabel("0");
        score.setFont(new Font("Serif", Font.BOLD, 72));
        score.setSize(200, 100);
        score.setBounds(920, 480, 200, 100);
        
        highScore = new JLabel("0");
        highScore.setFont(new Font("Serif", Font.BOLD, 72));
        highScore.setSize(200, 100);
        highScore.setBounds(920, 800, 200, 100);
        
        tryagain = new JButton("Try Agian");
        
        tryagain.setFont(new Font("Arial", Font.BOLD, 24));
        tryagain.setSize(100, 50);
        tryagain.setBounds(100, 1000, 100, 50);
        
        exited = new JButton("Back To Menu");
        
        exited.setFont(new Font("Arial", Font.BOLD, 24));
        exited.setSize(100, 50);
        exited.setBounds(1800, 1000, 100, 50);
        
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2D = (Graphics2D)g;
        g.drawImage(img, 0, 0, this);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        this.revalidate();
        this.repaint();
    }

    public JButton getTryagain() {
        return tryagain;
    }

    public void setTryagain(JButton tryagain) {
        this.tryagain = tryagain;
    }

    public JButton getExited() {
        return exited;
    }

    public void setExited(JButton exited) {
        this.exited = exited;
    }

    public JLabel getScore() {
        return score;
    }

    public void setScore(JLabel score) {
        this.score = score;
    }

    public JLabel getHighScore() {
        return highScore;
    }

    public void setHighScore(JLabel highScore) {
        this.highScore = highScore;
    }


    
    
}

