package src.AsteroidMining;

import java.awt.*;
import java.util.*;

public class Handler {

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    ArrayList<Place> neighbours = new ArrayList<Place>();;


    public void addObject( GameObject obj){
        if(obj instanceof Place){
            Place p = (Place)obj;
            neighbours.add(p);

        }

        this.objects.add(obj);

    }
    public void generateNbrs(){
        for(GameObject obj: objects){
            if(obj instanceof Place) {
                for(Place p: neighbours){
                    if(!p.equals((Place) obj)){
                        ((Place) obj).addNeighbour(p);
                    }
                }

            }
        }
    }
    public void removeObject(GameObject obj){
        this.objects.remove(obj);
    }

    public void checkExplosiveAsteroids(){
        for(GameObject obj : objects){
            if(obj.getId() == ID.RadioActiveAsteroid){
                RadioActiveAsteroid a1 = (RadioActiveAsteroid) obj;
                if(a1.depth==0 && !a1.getResource().equals(null)){
                    a1.explode(this);
                }
            }
        }
    }
}
