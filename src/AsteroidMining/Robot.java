package src.AsteroidMining;

import java.awt.*;

public class Robot extends Visitor {

private int health;

    public Robot() {
        super(ID.Robot);
    }


    /*Robot is damaged by given amount*/
    public  void getDamage( int i ){
        this.health-=i;
    }
    public int getHealth(){
        return health;
    }

}
