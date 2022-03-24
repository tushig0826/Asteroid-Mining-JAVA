package src.AsteroidMining;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void render(Graphics g){
        for(GameObject obj : objects)
            obj.render(g);
    }
    public void tick(){
        for(GameObject obj : objects)
            obj.tick();
    }


    public void addObject( GameObject obj){
        this.objects.addFirst(obj);
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
