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
    private BufferedImage img = null;

    public Asteroid(int x, int y, Resource r, int depth) {
        super(x, y, ID.Asteroid);

        if(r!=null)
            this.resource = r;
        else
            this.hollow = true;

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

        g.drawImage(img, x, y,depth*10,depth*10, null);

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



}
