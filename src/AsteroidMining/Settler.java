package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Settler extends Visitor{

    private List<TeleportationGate> gates;
    private SpaceShip spaceship;
    private BufferedImage img = null;



    public Settler(int x, int y) {

        super(x, y, ID.Settler);
        try{
            img = ImageIO.read(new File("Assets/spaceship.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {
        x = x+velX;
        y = y+velY;
        System.out.println(velX);
        System.out.println(velY);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, x, y, 100, 100, null);
    }
}
