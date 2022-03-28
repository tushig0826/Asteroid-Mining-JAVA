package src.AsteroidMining;

import java.util.HashMap;

public class SpaceShip {


    private int capacity;
    private int currentInventory;

    HashMap<Resource, Integer> resources = new HashMap<Resource, Integer>();

    public boolean addResource(Resource r) {
        return false;
    }

    public boolean removeResource(Resource r) {
        return true;
    }

    /**
     * @author kasay
     */
    public int countResource(Resource r) {
        if (resources.containsKey(r))
            return resources.get(r);
        else
            return 0;
    }
}
