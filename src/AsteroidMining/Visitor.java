package src.AsteroidMining;

import java.awt.*;
import java.util.Random;

public abstract class Visitor extends GameObject {
    Handler handler;
    private boolean alive=true;
    private boolean hidden=false;
    private Place place;

    public Visitor(ID id, Handler handler) {
        super(id);
    }
    public Visitor(ID id) {
        super(id);
    }


    public void travel(){
        System.out.println("travel()");

        if(place.equals(null))
            System.out.println("null");
        System.out.println(place.getNeighbours());
        Random rand = new Random();

        Place a2 = place.getNeighbour();
        System.out.println(a2);
        System.out.println("Travelling to the Neighbouring asteroid..");
        place.removeVisitor(this);

        a2.addVisitor(this);





    }
    public boolean drill(){
        System.out.println("Drilling!");
        Asteroid a1 = (Asteroid) this.getPlace();

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
        System.out.println("hide()");

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


    public void die() {
        this.alive=false;
    }
}
