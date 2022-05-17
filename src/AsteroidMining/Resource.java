package src.AsteroidMining;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Resource extends GameObject {
    protected String type;
    protected BufferedImage img = null;
    /*Constructing the resource*/
    public Resource(ID id){
        super(id);}

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
    public BufferedImage getImg(){
        return img;
    }

    /*Getting the type of the resource*/
    public String getType(){ return this.type;}
}
