package src.AsteroidMining;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    ArrayList<Place> neighbours = new ArrayList<Place>();

    public void render(Graphics g) throws IOException {
        for(GameObject obj : objects)
            obj.render(g);
    }
    public void tick(){
        for(GameObject obj : objects)
            obj.tick();
    }


    public void addObject( GameObject obj){
        if(obj instanceof Place){
            Place p = (Place)obj;
            neighbours.add(p);

        }

        this.objects.add(obj);

    }
    /*Generating neighbours of the place*/
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
    /*Removing objects*/
    public void removeObject(GameObject obj){
        this.objects.remove(obj);
    }
    /*Checking asteroids if it is exploded*/
    public void checkAsteroids(){
        Iterator<GameObject> it = objects.iterator();
        while(it.hasNext()){
            boolean isExploded = false;
            GameObject obj = it.next();
            if(obj instanceof Asteroid){
                Asteroid a1 = (Asteroid) obj;
                a1.inPerihelion(isExploded);
                if(isExploded) this.removeObject(obj);
            }
        }
    }
}
