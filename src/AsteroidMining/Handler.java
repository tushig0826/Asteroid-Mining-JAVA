package src.AsteroidMining;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    ArrayList<Place> neighbours = new ArrayList<Place>();;

    public void render(Graphics g){
        for(GameObject obj : objects)
            obj.render(g);
    }
    public void tick(){
        for(GameObject obj : objects) {
                obj.tick();
        }

        /*int i=0;
        for(GameObject obj:objects){
            if(!(obj.checkForCollision(objects.get(2)))){
                obj.tick();
            }*/


    }


    public void addObject( GameObject obj){

        this.objects.addFirst(obj);
        if(obj instanceof Place)
            this.neighbours.add((Place)obj);
    }
    public void removeObject(GameObject obj){
        this.objects.remove(obj);
    }
    public Settler getSettler(){
        for(GameObject obj : objects)
            if(obj.getId()==ID.Settler)
                return (Settler) obj;

        return null;
    }
    public void checkExplosiveAsteroids(){
        for(GameObject obj : objects){
            if(obj.getId() == ID.RadioActiveAsteroid){
                //
            }
        }
    }
}
