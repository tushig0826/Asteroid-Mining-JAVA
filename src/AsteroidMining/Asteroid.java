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
    protected Resource resource=null;
    private BufferedImage img = null;
    private boolean isPerihelion;
    private int rad;
    public int coreX, coreY;


    public Asteroid(int x, int y, Resource r, int depth) {
        super(x, y, ID.Asteroid);

        if(r!=null) {
            addResource(r);
        }
        else {
            this.hollow = true;

        }


        this.depth = depth;
        this.rad = depth;

        width =rad*12;
        height = rad*12;
        coreX = getX()+width/2-5;
        coreY = getY()+height/2;



        try{
                img = ImageIO.read(new File("Assets/asteroid1.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        if(depth==rad) {
            try{
                    img = ImageIO.read(new File("Assets/Asteroid1.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }else if(depth >= rad*0.75){
            try{
                    img = ImageIO.read(new File("Assets/drilled1.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
        else if(depth >= rad*0.5){
        try{
            img = ImageIO.read(new File("Assets/drilled2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }

        }
        else if(depth==0){
        try{
            img = ImageIO.read(new File("Assets/drilled3.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
        g.drawImage(img, x, y, width, height, null);
        if(resource!=null && depth<=0){
            g.drawImage(resource.getImg(), coreX, coreY, 30,30, null);
        }

    }



    public void deepenHole(int n) {
        this.depth -= n;
    }

    public Resource getResource(){
        return this.resource;
    }

    public void addResource(Resource r){
        if(resource instanceof Uranium)
            this.setId(ID.RadioActiveAsteroid);
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

    public void explode(boolean ex) {
        System.out.println("Asteroid has been exploded!");
        for (Visitor visitor : visitors) {
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


