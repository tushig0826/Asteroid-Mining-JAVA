package src.AsteroidMining;

import java.awt.*;
import java.util.*;
import java.util.List;

import static java.lang.Math.abs;

public abstract class Place extends GameObject {

    static List<Place> neighbours = new ArrayList<Place>();/*List of neighbours of the place-> asteroid and telepor*/
    public static Set<Place> setN = new HashSet<Place>();
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


    public Set<Place> getNeighbours(){

        return setN;
    }

    /*Returning the neighbouring asteroid*/
    public Place getNeighbour(){
        for (Iterator<Place> it = setN.iterator(); it.hasNext(); ) {
            Place p = it.next();
            if(!p.equals(this)){
                setN.remove(p);
                //setN.add(this);
                return p;
            }
            else{
                return it.next();
            }

        }
        return null;
    }

    public void addNeighbour(Place p){
        setN.add(p);
    }

}
