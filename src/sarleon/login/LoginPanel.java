package sarleon.login;

import sarleon.game.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sarleon on 1/18/16.
 */
public class LoginPanel extends JPanel {
    LoginPanel(){
        setLayout(null);
        setBounds(0,0,1920,1080);
        JLabel title=new JLabel("贪吃蛇");
        setBackground(Color.orange);
        title.setBounds(750,100,500,150);
        title.setFont(new Font("微软雅黑",Font.BOLD,100));
        title.setBackground(Color.RED);
        JLabel level=new JLabel();
        level.setBounds(750,800,400,60);
        level.setText("游戏难度:简单");
        level.setFont(new Font("微软雅黑",Font.PLAIN,50));

       //选择难度
        JButton easy=new JButton("简单");
        JButton medium=new JButton("中等");
        JButton hard=new JButton("困难");
        easy.setFont(new Font("微软雅黑",Font.BOLD,30));
        medium.setFont(new Font("微软雅黑",Font.BOLD,30));
        hard.setFont(new Font("微软雅黑",Font.BOLD,30));
        easy.setBounds(500,600,150,40);
        medium.setBounds(800,600,150,40);
        hard.setBounds(1100,600,150,40);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.setText("游戏难度:简单");
            }
        });
        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.setText("游戏难度:中等");
            }
        });
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.setText("游戏难度:困难");
            }
        });
        JButton start =new JButton("开始游戏");
        start.setFont(new Font("微软雅黑",Font.BOLD,40));
        start.setBounds(750,500,300,80);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame gameFrame=new GameFrame();
                setVisible(false);

            }
        });
        add(title);
        add(level);
        add(easy);
        add(medium);
        add(hard);
        add(start);

    }
}
