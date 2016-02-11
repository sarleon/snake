package sarleon.login;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sarleon on 1/18/16.
 */
public class LoginFrame extends JFrame {
    public LoginFrame(String s){
        setTitle(s);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,1920,1080);
        setLayout(null);
        LoginPanel loginPanel= new LoginPanel();
        add(loginPanel);


    }
}
