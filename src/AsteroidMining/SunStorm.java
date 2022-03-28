package src.AsteroidMining;

import java.awt.*;

/**
 * This class stores information about the sun storm- when it occurs. It also contains the methods
 * needed for the collisions with objects of the game. The sun storm inherits its ID from the Game
 * object.
 */
public class SunStorm extends GameObject {
    private int time;

    public SunStorm(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    /**
     * @author kasay
     */
    public void setTime(int t) {
        time = t;
    }

    ;

    /**
     * @author kasay
     */
    public void collisionWith(Asteroid obj) {
        System.out.println("colisionWith(a1)");

        obj.getVisitor();
        System.out.println("getVisitor(): visitor");
    }
}
