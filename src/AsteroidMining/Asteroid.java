package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Asteroid extends Place {

    protected boolean hollow=false;
    protected int depth;
    protected int distanceFromSun;
    protected Resource resource;
    private BufferedImage img = null;

    public Asteroid(int x, int y, Resource r, int depth) {
        super(x, y, ID.Asteroid);
        this.resource = r;
        this.depth = depth;
        if(resource instanceof Uranium)
            this.setId(ID.RadioActiveAsteroid);

        try{
            img = ImageIO.read(new File("Assets/Asteroid.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }


    }



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
    }

    public boolean isHollow(){
        return hollow;
    }

    public boolean isPerihelion(){
        return false;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(img, x, y,depth*10,depth*10, null);

    }
}
