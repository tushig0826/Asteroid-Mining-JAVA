package src.AsteroidMining;

import java.util.ArrayList;

public class Asteroid extends place {

    private boolean hollow;
    int depth;
    private int distanceFromSun;

    public ArrayList<Resource> resource;

    public void deepenhole(int n){ }
    public Resource getResource(){
        return null;
    }
    public boolean addResource(Resource r){
        return false;
    }
    public void removeResource(){ }
    public boolean isHollow(){
        return false;
    }
    public boolean isPrehelion(){

        return false;
    }
}
