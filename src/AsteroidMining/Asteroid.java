package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Asteroid extends Place {

    private boolean hollow=false;
    protected int depth;
    protected int distanceFromSun;
    protected Resource resource;

    /*Initialzing the asteroid class*/
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
    }
    public void removeResource(){
        this.resource = null;
        hollow= true;
    }

    public boolean isHollow(){
        return hollow;
    }

    public boolean isPerihelion(){
        return false;
    }



}
