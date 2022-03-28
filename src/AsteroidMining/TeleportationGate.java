package src.AsteroidMining;

import java.awt.*;

public class TeleportationGate extends Place {

    private TeleportationGate pairGate;

    public TeleportationGate() {
        super(ID.TeleportationGate);
    }


    public TeleportationGate getGate(){
        return pairGate;
    }

    public void setGate(TeleportationGate gate) {
        this.pairGate = gate;
    }

}
