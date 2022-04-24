package src.AsteroidMining;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.Math.abs;
/*Initializing Place*/
public abstract class Place extends GameObject {

    List<Place> neighbours = new ArrayList<Place>();/*List of neighbours of the place-> asteroid and telepor*/
    //protected Visitor visitor; /*Visitor of the place*/
    List<Visitor> visitors = new ArrayList<>();
    //list
    //there can 2 visitors
    /*Constructing the place*/
    public Place(ID id) {
        super(id);
    }

    /*Adding visitor to the place*/
    public void addVisitor(Visitor v){
        System.out.println("addVisitor(Visitor v)");
        v.setPlace(this);
        visitors.add(v);
        //this.visitor.setPlace(this);
        System.out.println("Visitor landed successfully!");
    }
    //public Visitor getVisitor(){return this.visitor;}
    /*Removing Visitor to the place*/
    public void removeVisitor(Visitor v){
        visitors.remove(v);
    }
    /*Getting the visitors*/
    public List<Visitor> getVisitors(){
        return visitors;
    }

    /*Getting the neighbours of the place*/
    public List<Place> getNeighbours(){

        return neighbours;
    }

    /*Returning the neighbouring asteroid*/
    public Place getNeighbour(){
        return neighbours.get(0);
    }
    /*Adding neighbour to the place*/
    public void addNeighbour(Place p){
        neighbours.add(p);
    }

}
