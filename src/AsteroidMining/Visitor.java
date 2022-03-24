package src.AsteroidMining;

import java.awt.*;

public abstract class Visitor extends GameObject {

    private boolean alive;
    private boolean hidden;
    private Place place;

    public Visitor(int x, int y, ID id) {
        super(x, y, id);
    }

    //@Override
    public abstract void tick();

    public abstract void render(Graphics g);

    public void travel(int n){

    }
    public boolean drill(){
        return true;
    }

    public Place getPlace(){return this.place;}

    public void setPlace(Place place){
        this.place = place;
    }

    public boolean hide(){
        return true;
    }


}
