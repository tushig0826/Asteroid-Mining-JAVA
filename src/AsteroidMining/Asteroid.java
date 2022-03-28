package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is a child class of Place, and through place it inherits an ID from Game Object. It is
 * the parent class of RadioActiveAsteroid class, since radioactive asteroids are one distinct type
 * of asteroid. This class stores information about whether asteroids are hollow, the depth of their
 * rock mantle, and which resource the core is made from. Also, it contains methods such as
 * deepening the rock mantle, adding and removing resources, determining whether the asteroid
 * is hollow, and whether or not it is at perihelion.
 */
public class Asteroid extends Place {

    private boolean hollow = false;
    protected int depth;
    protected int distanceFromSun;
    protected Resource resource;
    private BufferedImage img = null;

    /*Initialzing the asteroid class*/
    public Asteroid(int x, int y, Resource r, int depth) {
        super(x, y, ID.Asteroid);

        if (r != null)
            this.resource = r;
        else
            this.hollow = true;

        this.depth = depth;
        if (resource instanceof Uranium)
            this.setId(ID.RadioActiveAsteroid);

        try {
            img = ImageIO.read(new File("Assets/Asteroid.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void tick() {
        //overwhelming console output
        //our planning skeleton specified that the test case is done by the user input "test sunstorm"
        //contact to kasay for more details
        /*if(visitor!=null)
            System.out.println("Visitor is hidden" + visitor.isHidden());*/
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(img, x, y, depth * 10, depth * 10, null);

    }

    /*Decreases the depth of the asteroid by given magnitude*/
    public void deepenHole(int n) {
        this.depth -= n;
    }

    public Resource getResource() {
        return this.resource;
    }

    public void addResource(Resource r) {
        this.resource = r;
    }

    public void removeResource() {
        this.resource = null;
    }

    public boolean isHollow() {
        return hollow;
    }

    public boolean isPerihelion() {
        return false;
    }


}
