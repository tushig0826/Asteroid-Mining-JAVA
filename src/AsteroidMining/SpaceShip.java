package src.AsteroidMining;

import java.util.HashMap;
/*Initializing SpaceShip*/
public class SpaceShip {

    private int capacity=10; /*SpaceShip's max capacity*/
    private int currentInventory=0;

    HashMap<Resource, Integer> resources = new HashMap<Resource, Integer>();

    /*adding resource to the inventory*/
    public boolean addResource(Resource r){
        int num=0;
        if(currentInventory<capacity) {
            if(resources.containsKey(r)) {
                num = resources.get(r);
                resources.put(r, num + 1);

            }
            else {
                resources.put(r, 1);
            }
            currentInventory++;
            return true;
        }
        else return false;

    }
    /*removing resource from the inventory*/
    public boolean removeResource(Resource r){
        if(resources.containsKey(r)){
            resources.remove(r, 1);
            currentInventory--;
            return true;
        }
        return false;
    }
    public boolean removeResource(ID id, int num){
        Resource r = getResource(id);
        if(resources.containsKey(r)){
            resources.remove(r, num);
            currentInventory--;
            return true;
        }
        return false;
    }
    /*Counting resource of the inventory*/
    public int countResource(ID id){ /*Counts the resource from the inventory return amount if there is, otherwise 0*/
        for(Resource r : resources.keySet()){
            if(r.getId().equals(id))
                return resources.get(r);
        }
        return 0;
    }
    public Resource getResource(ID id){
        if(countResource(id)>0)
            for(Resource r : resources.keySet())
                if(r.getId().equals(id))
                    return r;
        return null;
    }
    /*Checking the capacity of inventory*/
    public boolean checkCapacity(){
        if(currentInventory<=capacity)
            return true;
        return false;
    }

}
