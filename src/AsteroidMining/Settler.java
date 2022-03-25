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

    /**
     * @author kasay
     */
    public boolean buildRobot(){
        System.out.println("buildRobot()");

        int nIron=spaceship.countResource(new Iron());
        System.out.println("countResource(\"iron”): nIron");
        int nCarbon=spaceship.countResource(new Carbon());
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium=spaceship.countResource(new Uranium());
        System.out.println("countResource(\"uranium”): nUranium");

        System.out.println("Do you have enough resources?");
        java.util.Scanner sc=new java.util.Scanner(System.in);
        String input=sc.nextLine();

        if(input.equals("yes")){
            Robot robot=new Robot(0,0,ID.Robot);

            //how can settler know handler?
            Handler tmp=new Handler();
            tmp.addObject(robot);
            System.out.println("addObject(r1)");
            //inside addObject(robot) of Handler, it calls addVisitor(robot) of Asteroid
            System.out.println("addVisitor(r1)");

            System.out.println("Robots are automatically controlled by the system from now on.");

            return true;
        }

        return false;
    }

    /**
     * @author kasay
     */
    public boolean putResource(Resource r, Asteroid a) {

        System.out.println("putResource(r1)");

        Place p = this.getPlace();
        System.out.println("getPlace(): a1");

        boolean value = a.isHollow();
        System.out.println("isHollow(): value");

        int num = spaceship.countResource(r);
        System.out.println("countResource(r1): num");

        if (p.equals(a)){
            /*if(value && num >= 1) {
                a.addResource(r);
                spaceship.removeResource(r);

                return true;
            }*/
            System.out.println("Is the asteroid hollow and do you have enough resources?");
            java.util.Scanner sc=new java.util.Scanner(System.in);
            String input=sc.nextLine();
            if(input.equals("yes")) {
                a.addResource(r);
                System.out.println("addResource(r1)");

                spaceship.removeResource(r);
                System.out.println("removeResource(r1)");

                return true;
            }
        }

        return false;
    }

    @Override
    public void tick() {
        x = x+velX;
        y = y+velY;

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, x, y, 100, 100, null);
    }
}
