package src.AsteroidMining;

public class TeleportationGate extends place {

    private TeleportationGate pairGate;

    public TeleportationGate getGate(){
        return pairGate;
    }
    public void setGate(TeleportationGate gate) {
        this.pairGate = gate;
    }

}
