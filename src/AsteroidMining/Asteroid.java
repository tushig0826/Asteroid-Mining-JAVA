package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/*Initializing the Asteroid class*/
public class Asteroid extends Place {

    private boolean hollow=false;
    protected int depth;
    private boolean isPerihelion;
    private Resource resource;

    /*Constructing the asteroid class*/
    public Asteroid(Resource r, int depth) {
        super(ID.Asteroid);

        if(r!=null)
            this.resource = r;
        else
            this.hollow=true;

        this.depth = depth;
        if(resource instanceof Uranium)
            this.setId(ID.RadioActiveAsteroid);


    }
    /*Decreases the depth of the asteroid by given magnitude*/
    public void deepenHole(int n){
        this.depth-=n;
    }
    public Resource getResource(){
        return this.resource;
    }

    public void addResource(Resource r){
        this.resource = r;
        this.hollow = false;
    }
    public void removeResource(){
        this.resource = null;
        hollow= true;
    }

    public boolean isHollow(){
        return hollow;
    }

    public boolean isPerihelion(){
        return isPerihelion;
    }
    public boolean isFullyDrilled(){
        if(depth<=0){
            return true;
        }
        return false;
    }
    public void inPerihelion(boolean exploded){
        System.out.println("Asteroid is in the perihelion!");
        this.isPerihelion = true;
        if(this.isFullyDrilled()) {
            if (this.getId() == ID.RadioActiveAsteroid) {
                explode(exploded);
            }
            if (this.resource.getId() == ID.WaterIce) {
                WaterIce wIce = (WaterIce) resource;
                wIce.sublime(this);
            }
        }
    }

    public void explode(boolean ex){
        System.out.println("Asteroid has been exploded!");
        for(Visitor visitor: visitors) {
            if (visitor.getId().equals(ID.Settler)) {
                visitor.die();
                System.out.println("Settler has been killed by asteroid explosion");
            }
            if (visitor.getId().equals(ID.Robot)) {
                Asteroid a2 = (Asteroid) this.getNeighbour();
                a2.addVisitor(visitor);
                this.removeVisitor(visitor);
                System.out.println("Robot has been moved to neighbouring asteroid");
            }

        }
        ex = true;
    }



}
