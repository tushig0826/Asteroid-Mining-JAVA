package src.AsteroidMining;

import java.awt.*;

public class Robot extends Visitor {

private int health;

    public Robot(int x, int y) {
        super(x, y, ID.Robot);
    }
    public Robot() {
        super(ID.Robot);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
    /*Robot is damaged by given amount*/
    public  void getDamage( int i ){
        this.health-=i;
    }
    /*Getting the Robots health status*/
    public int getHealth(){
        return health;
    }

}
