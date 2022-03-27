package src.AsteroidMining;

import java.awt.*;

public abstract class Visitor extends GameObject {
    Handler handler;
    private boolean alive=true;
    private boolean hidden=false;
    private Place place;

    public Visitor(int x, int y, ID id) {
        super(x, y, id);
    }

    //@Override
    public abstract void tick();

    public abstract void render(Graphics g);

    public void travel(int n){

    }
    public void drill(){

        Asteroid a1 = (Asteroid) this.getPlace();

        a1.deepenHole(1);

    }

    public Place getPlace(){
        return this.place;
    }


    public void setPlace(Place place){
        this.place = place;
    }

    public boolean hide(){

        Asteroid a1 = (Asteroid) this.getPlace();
        if(a1!=null && a1.isHollow()){
            hidden = true;

            return true;
        }
        return false;

    }
    public boolean isHidden(){
        return hidden;
    }


}
