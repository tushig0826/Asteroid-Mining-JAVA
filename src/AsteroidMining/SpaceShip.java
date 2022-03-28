package src.AsteroidMining;

import java.util.HashMap;

/**
 * The responsibility of this class is to store attributes regarding inventory, capacity, the resources
 * stored in the spaceship, and the settler that the spaceship belongs to. The methods deal with
 * inventory- adding resources, removing them, and counting them.
 */
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
     * Checking the inventory of Spaceship
     * @author kasay
     */
    public int countResource(Resource r) {
        if (resources.containsKey(r))
            return resources.get(r);
        else
            return 0;
    }
}
