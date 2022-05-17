package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class WaterIce extends Resource{
    public WaterIce() {
        super(ID.WaterIce);
        this.type = "WaterIce";
        try{
            img = ImageIO.read(new File("Assets/WaterIce.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    /*Subliming the water ice*/
    public void sublime(Asteroid a) {
        System.out.println("Water ice is subliming..");
        a.removeResource();
    }
}
