package src.AsteroidMining;

import java.awt.*;

public class SunStorm extends GameObject {
    private int time;


    public SunStorm(int time) {
        super(ID.SunStorm);
        this.time = time;
    }
    public void collisionWith(Asteroid a1){
        Visitor visitor = a1.getVisitor();
        if(visitor!=null && !visitor.isHidden()){
            if(visitor.getId().equals(ID.Settler)){
                visitor.die();
            }
            else if(visitor.getId().equals(ID.Robot)){
                Robot r1 = (Robot) visitor;
                r1.getDamage(5);
                if(r1.getHealth()<=0){
                    visitor.die();
                }
            }
        }
    }

}
