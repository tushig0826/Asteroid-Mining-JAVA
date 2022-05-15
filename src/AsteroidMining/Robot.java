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

    //elapsed time
    int time = 0;
    //unit time
    int mod = 10;

    //for an operation travel
    int min = 0;
    //for an operation drill
    int max = 1;

    @Override
    public void tick() {
        if (isAlive() == true) {
            /*ignore below code*/
            /*if(sunstorm occurred)
            try {
                hide();
            }catch(Exception e){
                System.out.println("Exception is thrown in tick() of Robot.java: "+e);
            }*/

            //an operation of robot is executed in every unit of time
            if ((++time) % mod == 0) {
                //randomly generated number determines which operation to execute
                int randNum = (int) (Math.random() * (max - min + 1) + min);

                switch (randNum) {
                    case 0: travel(); break;
                    case 1: drill(); break;
                }
            }

            //to avoid overflow
            time = time % mod;
        }
    }

    @Override
    public void render(Graphics g) {

    }

    /*Robot is damaged by given amount*/
    public void getDamage(int i) {
        this.health -= i;
    }

    /*Getting the Robots health status*/
    public int getHealth() {
        return health;
    }

}
