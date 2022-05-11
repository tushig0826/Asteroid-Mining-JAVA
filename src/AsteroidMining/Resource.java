package src.AsteroidMining;

import java.awt.*;

public class Resource extends GameObject {
    protected String type;
    /*Constructing the resource*/
    public Resource(ID id){super(id);}

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    /*Getting the type of the resource*/
    public String getType(){ return this.type;}
}
