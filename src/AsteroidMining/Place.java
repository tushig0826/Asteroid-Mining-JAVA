package src.AsteroidMining;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Place extends GameObject {

    List<Place> neighbours = new ArrayList<Place>();
    protected Visitor visitor;

    public Place(int x, int y, ID id) {
        super(x, y, id);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void addVisitor(Visitor v){
        this.visitor = v;
    }
    public Visitor getVisitor(){return this.visitor;}
    public void removeVisitor(){
        this.visitor = null;
    }

    public List<Place> getNeighbours(){
        return neighbours;
    }

    public void addNeighbour(Place p){
        neighbours.add(p);
    }

}
