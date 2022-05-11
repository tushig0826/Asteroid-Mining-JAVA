package src.AsteroidMining;

import java.awt.*;

public class TeleportationGate extends Place {

    private TeleportationGate pairGate;

    public TeleportationGate(int x, int y) {
        super(x, y, ID.TeleportationGate);
    }
    public TeleportationGate() {
        super(ID.TeleportationGate);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

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
