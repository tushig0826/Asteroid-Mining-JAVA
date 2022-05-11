package src.AsteroidMining;

public class WaterIce extends Resource{
    public WaterIce() {
        super(ID.WaterIce);
        this.type = "WaterIce";
    }
    /*Subliming the water ice*/
    public void sublime(Asteroid a) {
        System.out.println("Water ice is subliming..");
        a.removeResource();
    }
}
