package src.AsteroidMining;

import java.awt.*;
/*Initializing TeleportationGate*/
public class TeleportationGate extends Place {

    private TeleportationGate pairGate;
    /*Initializing Constructor*/
    public TeleportationGate() {
        super(ID.TeleportationGate);
    }

    /*Geting gate*/
    public TeleportationGate getGate(){
        return pairGate;
    }
    /*Setting gate*/
    public void setGate(TeleportationGate gate) {
        this.pairGate = gate;
    }

}
