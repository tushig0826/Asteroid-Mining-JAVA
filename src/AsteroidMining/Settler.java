package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Settler<nextDestX> extends Visitor{
    private List<TeleportationGate> gates;
    private SpaceShip spaceship;
    private BufferedImage img = null;
    private boolean moveable = true;




    public Settler(int x, int y, Handler handler) {

        super(x, y, ID.Settler);
        this.handler = handler;
        try{
            img = ImageIO.read(new File("Assets/spaceship.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        this.width = 100;
        this.height = 100;
        vel = 5;
    }

    public void travel(Direction dir){
        //this.handler = handler;

        //for(GameObject obj: handler.objects) {
            //if (!obj.getId().equals(ID.Settler) && this.checkForCollision(obj)) {
                switch (dir) {
                    case UP:
                        setVelY(-vel);
                        break;
                    case DOWN:
                        setVelY(vel);
                        break;
                    case LEFT:
                        setVelX(-vel);
                        break;
                    case RIGHT:
                        setVelX(vel);
                        break;
                    //case default: break;
                }
            //moveable = true;
        /* }
            else {
                moveable = false;

            }
    }*/

    }

    @Override
    public void tick() {
        /*//nextDestX = x+gap;
        //nextDestY = x+gap;
        for(GameObject obj : handler.objects) {
            if (this.checkForCollision(obj)) {
                x = x + velX;
                y = y + velY;
            }
        }
        if(moveable) {*/

        //int m = (nextDestX-x)/(nextDestY-y);
        //y = m*x - m*nextDestX + nextDestY;
       // x = x + velX;
        //y = y + velY;
        //x = nextDestX;
        //y = nextDestY;





    }
    public void generateLine(){

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);

        g.drawImage(img, x, y, width, height, null);
        g.drawRect(x,y, width, height);
    }

    public boolean mine(){
        return true;
    }
    public boolean buildTeleportationGates(Handler handler){
        return false;
    }

    public void deployGate(){

    }

}
