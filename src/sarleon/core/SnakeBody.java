package sarleon.core;

/**
 * Created by sarleon on 1/18/16.
 */
public class SnakeBody {
    private int locationX;
    private int locationY;
    public int getLocationX() {
        return locationX;
    }
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }
    public int getLocationY() {
        return locationY;
    }
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
   public SnakeBody(int locatoionX,int locatoionY){
        setLocationX(locatoionX);
        setLocationY(locatoionY);
            }
}
