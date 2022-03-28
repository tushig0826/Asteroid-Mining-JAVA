package src.AsteroidMining;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Place extends GameObject {

    List<Place> neighbours = new ArrayList<Place>();
    protected Visitor visitor;

    public Place(ID id) {
        super(id);
    }


    public void addVisitor(Visitor v){
        System.out.println("addVisitor(Visitor v)");
        this.visitor = v;
        this.visitor.setPlace(this);
        System.out.println("Visitor landed successfully!");
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
