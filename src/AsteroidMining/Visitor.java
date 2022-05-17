package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Visitor extends GameObject {
    Handler handler;
    protected boolean alive=true;
    protected boolean hidden=false;
    protected Place place;
    protected BufferedImage img = null;


    public Visitor(ID id, Handler handler) {
        super(id);
    }
    public Visitor(int x, int y, ID id) {
        super(x, y, id);
    }

    public Visitor(ID id) {
        super(id);
    }

    //@Override
    public abstract void tick();

    public abstract void render(Graphics g) throws IOException;

    public void travel(){
        System.out.println("travel()");

        if(place.equals(null))
            System.out.println("null");

        System.out.println(place);
        System.out.println(handler.neighbours);
        place.removeVisitor(this);
        handler.neighbours.remove(place);
        handler.neighbours.add(place);
        handler.neighbours.get(0).addVisitor(this);
        System.out.println(place);
        System.out.println("Travelling to the Neighbouring asteroid..");


    }
    public boolean drill(){
        System.out.println("Drilling!");
        Asteroid a1 = (Asteroid) this.getPlace();
        if(a1==null) return false;
        if(a1.depth>=0) {
            a1.deepenHole(2);
            return true;
        }else{
            System.out.println("Asteroid is fully drilled!");
            return false;}
    }



    public Place getPlace(){
        return this.place;
    }

    public void setPlace(Place place){
        this.place = place;
    }

    /*Hiding in the hollow asteroid*/
    public boolean hide(){

        if (isHidden() ){
            hidden = false;
             return true;
         }

        Asteroid a1 = (Asteroid) this.getPlace();
        if(a1!=null && a1.isHollow()){
            hidden = true; System.out.println("hide");
            return true;
        }
        return false;

    }
    public boolean isHidden(){
        return hidden;
    }


    public void die() {
        this.alive=false;
    }

    public boolean isAlive(){
        return alive;
    }
}
