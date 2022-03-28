package src.AsteroidMining;

import java.awt.*;

public class Robot extends Visitor {

private int health;

    public Robot() {
        super(ID.Robot);
    }



    public  void getDamage( int i ){
        this.health-=i;
    }
    public int getHealth(){
        return health;
    }

}
