package src.AsteroidMining;

import java.awt.*;
/*Initializing Robot*/
public class Robot extends Visitor {

private int health;
    /*Constucting the robot*/
    public Robot() {
        super(ID.Robot);
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
