package src.AsteroidMining;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.Math.abs;

public abstract class Place extends GameObject {

    List<Place> neighbours = new ArrayList<Place>();/*List of neighbours of the place-> asteroid and telepor*/
    //protected Visitor visitor; /*Visitor of the place*/
    List<Visitor> visitors = new ArrayList<>();
    //list
    //there can 2 visitors

    public Place(ID id) {
        super(id);
    }


    public void addVisitor(Visitor v){
        System.out.println("addVisitor(Visitor v)");
        v.setPlace(this);
        visitors.add(v);
        //this.visitor.setPlace(this);
        System.out.println("Visitor landed successfully!");
    }
    //public Visitor getVisitor(){return this.visitor;}
    public void removeVisitor(Visitor v){
        visitors.remove(v);
    }
    public List<Visitor> getVisitors(){
        return visitors;
    }


    public List<Place> getNeighbours(){

        return neighbours;
    }

    /*Returning the neighbouring asteroid*/
    public Place getNeighbour(){
        return neighbours.get(0);
    }

    public void addNeighbour(Place p){
        neighbours.add(p);
    }

}
