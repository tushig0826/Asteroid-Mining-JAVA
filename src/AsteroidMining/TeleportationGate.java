package src.AsteroidMining;

import java.awt.*;

/**
 * This class stores information about teleportation gates that were deployed by settlers. These
 * come in pairs, so it is important for two gates of a pair to be linked with one another, which is
 * why we need a pairGate attribute, and methods to set and get a gate’s pair. This is a child class
 * of the Place class, since it is one of the two available types of places, and through Place, it
 * inherits its ID from Game Object.
 */
public class TeleportationGate extends Place {

    private TeleportationGate pairGate;

    public TeleportationGate() {
        super(ID.TeleportationGate);
    }


    public TeleportationGate getGate() {
        return pairGate;
    }

    public void setGate(TeleportationGate gate) {
        this.pairGate = gate;
    }

}
