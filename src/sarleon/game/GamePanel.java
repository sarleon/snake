package sarleon.game;

import sarleon.core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sarleon on 1/18/16.
 */
public class GamePanel extends JPanel {
    GamePanel(Snake s){
        this.snake=s;

        setVisible(true);
        setBounds(0,0,1920,1080);
        setBackground(Color.cyan);
        setLayout(null);
        JButton beginbutton=new JButton("开始游戏");
        beginbutton.setFont(new Font("微软雅黑",Font.BOLD,30));
        beginbutton.setBounds(1250,120,200,50);
        JLabel scorelabel=new JLabel("SCORE:                    ");
        scorelabel.setFont(new Font("微软雅黑",Font.BOLD,30));
        scorelabel.setBounds(1200,250,300,50);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                boolean check=true;
                while (true) {

                    System.out.println("HELL"+snake.direction);
                    GamePanel.this.repaint();
                    try {
                        Thread.sleep(Snake.flushtime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (snake.direction == Direction.UP) {
                        if (snake.snakeBodies.get(0).getLocationY()>0) {
                            snake.snakeBodies.add(0,new SnakeBody(snake.snakeBodies.get(0).getLocationX(), snake.snakeBodies.get(0).getLocationY() - 1));
                           if(snake.snakeBodies.get(0).getLocationX()==food.getLocationX()&&snake.snakeBodies.get(0).getLocationY()==food.getLocationY()){
                               food=snake.createFood();
                           } else
                            snake.snakeBodies.remove(snake.snakeBodies.size()-1);
                        }
                        else {
                            check=false;
                        }
                    }
                    if (snake.direction == Direction.DOWN) {
                        if (snake.snakeBodies.get(0).getLocationY()<19) {
                            snake.snakeBodies.add(0,new SnakeBody(snake.snakeBodies.get(0).getLocationX(), snake.snakeBodies.get(0).getLocationY() +1));
                            if(snake.snakeBodies.get(0).getLocationX()==food.getLocationX()&&snake.snakeBodies.get(0).getLocationY()==food.getLocationY()){
                                food= snake.createFood();
                            } else
                                snake.snakeBodies.remove(snake.snakeBodies.size()-1);
                        }
                        else {
                            check=false;
                        }
                    }
                    if (snake.direction == Direction.LEFT) {
                        if (snake.snakeBodies.get(0).getLocationX()>0) {
                            snake.snakeBodies.add(0,new SnakeBody(snake.snakeBodies.get(0).getLocationX()-1, snake.snakeBodies.get(0).getLocationY() ));
                            if(snake.snakeBodies.get(0).getLocationX()==food.getLocationX()&&snake.snakeBodies.get(0).getLocationY()==food.getLocationY()){
                                food=snake.createFood();
                            } else
                                snake.snakeBodies.remove(snake.snakeBodies.size()-1);
                        }
                        else {
                            check=false;
                        }
                    }
                    if (snake.direction == Direction.RIGHT) {
                        if (snake.snakeBodies.get(0).getLocationX()<19) {
                            snake.snakeBodies.add(0,new SnakeBody(snake.snakeBodies.get(0).getLocationX()+1, snake.snakeBodies.get(0).getLocationY()));
                            if(snake.snakeBodies.get(0).getLocationX()==food.getLocationX()&&snake.snakeBodies.get(0).getLocationY()==food.getLocationY()){
                                food= snake.createFood();
                            } else
                                snake.snakeBodies.remove(snake.snakeBodies.size()-1);
                        }
                        else {
                            check=false;
                        }
                    }

                    if(!check){
                        try {


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }


                }



            }


        });






        beginbutton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP&&snake.direction!=Direction.DOWN)
                    snake.direction= Direction.UP;
                if(e.getKeyCode()==KeyEvent.VK_DOWN&&snake.direction!=Direction.UP)
                    snake.direction= Direction.DOWN;
                if(e.getKeyCode()==KeyEvent.VK_LEFT&&snake.direction!=Direction.RIGHT)
                    snake.direction= Direction.LEFT;
                if(e.getKeyCode()==KeyEvent.VK_RIGHT&&snake.direction!=Direction.LEFT)
                    snake.direction= Direction.RIGHT;


            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        beginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.snakeBodies.clear();
                food=null;
                snake.direction=null;

                snake.init();
                snake.createFood();
                GamePanel.this.food=snake.food;
                repaint();
                if(thread.isAlive()){
                    thread.notify();
                }
                thread.start();

            }
        });


        add(beginbutton);
        add(scorelabel);
    }
    Snake snake;
    JLabel background;
    JButton startbutton;

    Food food;
    static final int GAMEWINDOWX=60;
    static final int GAMEWINDOWY=60;
    static final int SQUARELENGTH=45;
    public void setBackground(){
        ImageIcon imageIcon=new ImageIcon("/res/maoboli.jpg");
        background=new JLabel(imageIcon);
        background.setBounds(0,0,1920,1080);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;  //g是Graphics对象

        //画边框线
        for (int i = 0; i <= Initialize.getMAX(); i++) {

            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1.0f));
            g2.drawLine(GAMEWINDOWX, GAMEWINDOWY + i * SQUARELENGTH, GAMEWINDOWX + SQUARELENGTH * Initialize.getMAX(), GAMEWINDOWY + i * SQUARELENGTH);
            g2.drawLine(GAMEWINDOWX + i * SQUARELENGTH, GAMEWINDOWY, GAMEWINDOWX + i * SQUARELENGTH, GAMEWINDOWY + SQUARELENGTH * Initialize.getMAX());

        }
        g2.setFont(new Font("微软雅黑",Font.BOLD,30));
        g2.drawString(String.valueOf(snake.snakeBodies.size()),1340,283);

        System.out.println(snake.snakeBodies.size());
        for (int i  =0; i <snake.snakeBodies.size(); i++) {
                g2.setColor(Color.BLUE);
                g2.fillRect(GAMEWINDOWX+snake.snakeBodies.get(i).getLocationX()*SQUARELENGTH,GAMEWINDOWY+snake.snakeBodies.get(i).getLocationY()*SQUARELENGTH,SQUARELENGTH,SQUARELENGTH);
        }
        g2.setColor(Color.RED);
        g2.fillRect(GAMEWINDOWX+(food.getLocationX())*SQUARELENGTH,GAMEWINDOWY+(food.getLocationY())*SQUARELENGTH,SQUARELENGTH,SQUARELENGTH);
    }
}
