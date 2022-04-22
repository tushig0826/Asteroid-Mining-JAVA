package src.AsteroidMining;

import java.util.HashMap;

public class SpaceShip {

    private int capacity=10; /*SpaceShip's max capacity*/
    private int currentInventory=0;

    HashMap<Resource, Integer> resources = new HashMap<Resource, Integer>();

    public boolean addResource(Resource r){ /*adding resource to the inventory*/
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

    public boolean removeResource(Resource r){
        if(resources.containsKey(r)){
            resources.remove(r, 1);
            currentInventory--;
            return true;
        }
        return false;
    }

    public int countResource(ID id){ /*Counts the resource from the inventory return amount if there is, otherwise 0*/
        for(Resource r : resources.keySet()){
            if(r.getId().equals(id))
                return resources.get(r);
        }
        return 0;
    }

    public boolean checkCapacity(){
        if(currentInventory<=capacity)
            return true;
        return false;
    }

}
