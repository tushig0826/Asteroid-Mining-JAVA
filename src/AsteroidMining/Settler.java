package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The settler class inherits many attributes and methods from the visitor class. The Settler class
 * has a few additional attributes and methods, since a Settler has some different capabilities and
 * responsibilities compared to the other type of visitors-robots. This class stores information about
 * the teleportation gates and spaceship belonging to a specific settler. It contains methods
 * exclusive to settlers - such as mining, building robots and teleportation gates, storing resources
 * and deploying gates.
 */
public class Settler extends Visitor {

    private List<TeleportationGate> gates = new ArrayList<TeleportationGate>(); /*Settler only carries two gates to deploy*/
    private SpaceShip spaceship; /*Settler's private spaceship*/
    private BufferedImage img = null;

    /*Initializing the settler class*/
    public Settler(int x, int y) {
        super(x, y, ID.Settler);
        try {
            img = ImageIO.read(new File("Assets/spaceship.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {
        x = x + velX;
        y = y + velY;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, x, y, 100, 100, null);
    }

    /**
     * @author kasay
     */
    public void setSpaceship(SpaceShip sp) {
        this.spaceship = sp;
    }

    /**
     * This function returns a teleportation gate at the first index that the settler currently has.
     *
     * @author kasay
     */
    public TeleportationGate getTeleportationGate() {
        for (TeleportationGate tg : this.gates)
            if (tg != null)
                return tg;

        return null;
    }

    /**
     * Settler mining the available asteroid
     * @author kasay
     */
    public boolean mine() {
        System.out.println("\nmine()");

        Place p1 = this.getPlace();
        System.out.println("getPlace(): a1");

        //if the current place is not Asteroid, then returns false
        if (!p1.getClass().getName().equals(Asteroid.class.getName()))
            return false;

        Asteroid a1 = (Asteroid) this.getPlace();

        //checks depth
        //if(!a1.depth>0)
        System.out.println("Is depth 0 and is the asteroid non-hollow?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            a1.getResource();
            System.out.println("getResource(): r1");

            a1.removeResource();
            System.out.println("removeResource()");

            //check if the capacity is ok or not
            System.out.println("See sequence diagram 4.4.5. “Capacity Check”");

            return true;
        } else if (input.equals("no")) {
            this.drill();

            return false;
        }

        return false;
    }

    /**
     * @author kasay
     */
    public boolean buildRobot() {
        System.out.println("\nbuildRobot()");

        int nIron = spaceship.countResource(new Iron());
        System.out.println("countResource(\"iron”): nIron");
        int nCarbon = spaceship.countResource(new Carbon());
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(new Uranium());
        System.out.println("countResource(\"uranium”): nUranium");

        //check if the spaceship has enough resources to build a robot
        System.out.println("Do you have enough resources?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            Robot robot = new Robot(0, 0, ID.Robot);

            //how can settler know handler?
            Handler tmp = new Handler();
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
     * Building the teleporation gate but if necessary resources are available
     * @author kasay
     */
    public boolean buildTeleportationGates() {
        System.out.println("\nbuildTeleportationGates()");

        int nIron = spaceship.countResource(new Iron());
        System.out.println("countResource(\"iron”): nIron");
        int nWaterIce = spaceship.countResource(new WaterIce());
        System.out.println("countResource(\"waterIce”): nWaterIce");
        int nUranium = spaceship.countResource(new Uranium());
        System.out.println("countResource(\"uranium”): nUranium");

        //check if the spaceship has enough resources to build a pair of teleportation gates and the settler has no gates now
        System.out.println("Do you have enough resources and do you have no gates?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            TeleportationGate t1 = new TeleportationGate(0, 0, ID.TeleportationGate);
            TeleportationGate t2 = new TeleportationGate(0, 0, ID.TeleportationGate);

            this.gates.add(t1);
            this.gates.add(t2);
            System.out.println("addGates()");

            return true;
        }

        return false;
    }

    /**
     * Filling the hollow asteroid with one unit of selected resource
     * @author kasay
     */
    public boolean putResource(Resource r) {
        System.out.println("\nputResource(r1)");

        Place p = this.getPlace();
        System.out.println("getPlace(): a1");

        //if the current place is not Asteroid, then returns false
        if (!p.getClass().getName().equals(Asteroid.class.getName()))
            return false;

        Asteroid a = (Asteroid) this.getPlace();

        boolean value = a.isHollow();
        System.out.println("isHollow(): value");

        int num = spaceship.countResource(r);
        System.out.println("countResource(r1): num");

        /*if(value && num >= 1) {
            a.addResource(r);
            spaceship.removeResource(r);
            return true;
        }*/
        System.out.println("Is the asteroid hollow and do you have enough resources?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            a.addResource(r);
            System.out.println("addResource(r1)");

            spaceship.removeResource(r);
            System.out.println("removeResource(r1)");

            return true;
        }

        return false;
    }

    /**
     * Deploying the new built available gate
     * @kasay
     */
    public void deployGate(TeleportationGate g) {
        System.out.println("\ndeployGate(tg)");

        if (g != null) {
            Place p = this.getPlace();
            p.addNeighbour(g);
            System.out.println("addNeighbour()");

            //how can this deployed gate know the pair gate?
            TeleportationGate tmp = new TeleportationGate(0, 0, ID.TeleportationGate);
            g.setPair(tmp);
            System.out.println("setPair(t)");

            this.gates.remove(g);

            if (gates.isEmpty())
                System.out.println("gates = null");
            else
                System.out.println("Please travel somewhere!");
        }
    }

    /**
     * @author kasay
     */
    public void addGates() {

    }

    /**
     * @author kasay
     */
    public void buildSpaceShip() {
        System.out.println("\nbuildSpaceStation()");

        int nIron = spaceship.countResource(new Iron());
        System.out.println("countResource(\"iron”): nIron");
        int nWaterIce = spaceship.countResource(new WaterIce());
        System.out.println("countResource(\"waterIce”): nWaterIce");
        int nCarbon = spaceship.countResource(new Carbon());
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(new Uranium());
        System.out.println("countResource(\"uranium”): nUranium");

        System.out.println();

        //check if the spaceship has enough resources to build a pair of teleportation gates and the settler has no gates now
        System.out.println("Do you have enough resources and do you have no gates?");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("yes")) {
            System.out.println("endGame()");

            //how can the settler know object game?
            Game tmp = new Game();
            tmp.endGame();
        }
    }
}
