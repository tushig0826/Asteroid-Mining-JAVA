package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Iron extends Resource{
    public Iron() {
        super(ID.Iron);
        this.type ="Iron";
        try{
            img = ImageIO.read(new File("Assets/Iron.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
