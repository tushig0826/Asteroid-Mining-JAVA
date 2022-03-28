package src.AsteroidMining;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a parent class of Asteroid and TeleportationGate. These two entities are places
 * where a Visitor can be, and the Place class deals with them. It stores information about its
 * neighbors, and the visitors of the places. It inherits its id from the GameObject class.
 */
public abstract class Place extends GameObject {

    private TeleportationGate pairGate;
    List<Place> neighbours = new ArrayList<Place>();
    protected Visitor visitor;

    public Place(int x, int y, ID id) {
        super(x, y, id);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public void addVisitor(Visitor v) {
        this.visitor = v;
    }

    public Visitor getVisitor() {
        return this.visitor;
    }

    public void removeVisitor() {
        this.visitor = null;
    }

    public List<Place> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Place p) {
        neighbours.add(p);
    }

    public void setPair(TeleportationGate t) {
        pairGate = t;
    }

    public TeleportationGate getPair() {
        return pairGate;
    }
}
