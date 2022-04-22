package src.AsteroidMining;

public class WaterIce extends Resource{



    public WaterIce(ID id) {
        super(id);
    }

    public WaterIce() {
        super(ID.WaterIce);
        this.type = "WaterIce";
    }
    Visitor s = new Visitor( id);
    public void sublime() {
        if(s.fullydrilled == true)
            System.out.println("Water Ice Sublimates.");
    }


}
