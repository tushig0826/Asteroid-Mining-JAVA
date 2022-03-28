package src.AsteroidMining;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

public abstract class Place extends GameObject {

    static List<Place> neighbours = new ArrayList<Place>();/*List of neighbours of the place-> asteroid and telepor*/
    protected Visitor visitor; /*Visitor of the place*/

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
    public Place getNeighbour(){
        System.out.println(this.getNeighbours());
        return neighbours.get(3);
    }

    public void addNeighbour(Place p){
        neighbours.add(p);
    }

}
