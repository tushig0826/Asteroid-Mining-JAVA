package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Uranium extends Resource{
    public Uranium() {
        super(ID.Uranium);
        this.type ="Uranium";
        try{
            img = ImageIO.read(new File("Assets/Uranium.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
