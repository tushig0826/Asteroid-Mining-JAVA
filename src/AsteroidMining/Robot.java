package src.AsteroidMining;

import java.awt.*;

/**
 * This class is responsible for managing robots, which are a type of visitors. It stores information
 * about the health of the robot, which is a metric indicating if a robot has been affected by
 * dangers. It also contains a method that marks a robot as damaged, decreasing its health if it is
 * affected by a danger.
 */
public class Robot extends Visitor {

    private int health;

    public Robot(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    /*Robot is damaged by given amount*/
    public void getDamage(int i) {

    }
}
