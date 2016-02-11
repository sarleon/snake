package sarleon.game;

import sarleon.core.Snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sarleon on 1/18/16.
 */
public class GameFrame extends JFrame {
    public GameFrame(){
        setVisible(true);
        setLayout(null);
        setBounds(0,0,1920,1080);
        setBackground(Color.magenta);
        Snake snake=new Snake();
        GamePanel gamePanel=new GamePanel(snake);
        add(gamePanel);

    }
}
