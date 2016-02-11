package sarleon.core;

import java.util.ArrayList;

/**
 * Created by sarleon on 1/18/16.
 */
public class Snake {
    public static long flushtime=100;
    public Food food;
    public Direction direction;
    public ArrayList<SnakeBody> snakeBodies=new ArrayList<SnakeBody>();
    public void init(){
        int x=Initialize.randomnum();
        int y=Initialize.randomnum();
        snakeBodies.add(new SnakeBody(x,y));
    }
    public void move(){

    }
    public void eat(){

    }
    public  Food createFood(){

        int x=Initialize.randomnum();
        int y=Initialize.randomnum();
        for (int i = 0; i <this.snakeBodies.size() ; i++) {
            while(x==(this.snakeBodies.get(i).getLocationX())&&y==(this.snakeBodies.get(i).getLocationY()))
                x=Initialize.randomnum();
                 y=Initialize.randomnum();
            }
        Food food=new Food();
        this.food=food;
        food.setLocationX(x);
        food.setLocationY(y);
        return food;
        }
    }


