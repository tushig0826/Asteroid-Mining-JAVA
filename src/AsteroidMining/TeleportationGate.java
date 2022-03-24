package src.AsteroidMining;

import java.awt.*;

public class TeleportationGate extends Place {

    private TeleportationGate pairGate;

    public TeleportationGate(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    public TeleportationGate getGate(){
        return pairGate;
    }

    public void setGate(TeleportationGate gate) {
        this.pairGate = gate;
    }

}
