package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Carbon extends Resource{

    /*Initializing resource "Carbon"*/
    public Carbon() {
        super(ID.Carbon);
        this.type ="Carbon";
        try{
            img = ImageIO.read(new File("Assets/Carbon.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
