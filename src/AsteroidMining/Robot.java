package src.AsteroidMining;

import java.awt.*;

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

    public  void getDamage( int i ){ }

}
