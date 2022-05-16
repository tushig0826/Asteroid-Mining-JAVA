package src.AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Settler extends Visitor {

    private List<TeleportationGate> gates = new ArrayList<>(); /*Settler only carries two gates to deploy*/
    protected SpaceShip spaceship; /*Settler's private spaceship*/
    protected Robot robot;
    private BufferedImage img = null;


    public Settler(int x, int y, Handler handler) {

        super(x, y, ID.Settler);
        spaceship = new SpaceShip();
        //this.handler = handler;

        try {
            img = ImageIO.read(new File("Assets/newSpaceship.png"));
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

    /*Settler mining the available asteroid*/
    public boolean mine() {
        System.out.println("mine()");
        Asteroid a1 = (Asteroid) this.getPlace();
        if (a1.depth <= 0 && !(a1.isHollow())) {
            if (spaceship.checkCapacity()) {
                spaceship.addResource(a1.getResource());
                a1.removeResource();
                System.out.println("mining!");
                return true;

            }
        } else if (a1.depth >= 0) {
            System.out.println("Asteroid is not fully drilled!");
        } else if (a1.isHollow()) {
            System.out.println("Asteroid is hollow, does not contain any resources");
        }
        return false;

    }

    public boolean buildRobot() {
        System.out.println("buildRobot()");

        Place p = this.getPlace();
        int nIron = spaceship.countResource(ID.Iron);
        System.out.println("countResource(\"iron”): nIron");
        int nCarbon = spaceship.countResource(ID.Carbon);
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(ID.Uranium);
        System.out.println("countResource(\"uranium”): nUranium");

        if (nIron >= 1 && nCarbon >= 1 && nUranium >= 1) {
            System.out.println("You have enough resources! Do you want to build a robot?");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("yes")) {
                robot = new Robot();

                handler.addObject(robot);/*inside addObject(robot) of Handler, it calls addVisitor(robot) of Asteroid*/
                System.out.println("Robot has been created successfully!");
                this.getPlace().getNeighbour().addVisitor(robot);
                System.out.println("Robots are automatically controlled by the system from now on.");
                this.spaceship.removeResource(ID.Carbon, 1);
                this.spaceship.removeResource(ID.Uranium, 1);
                this.spaceship.removeResource(ID.Iron, 1);

                return true;
            }
        } else {
            System.out.println("You do not have enough resources!");
        }
        return false;
    }

    /*Filling the hollow asteroid with one unit of selected resource*/
    public boolean fillAsteroid() {
        System.out.println("FillAsteroid(Resource r)");
        Asteroid a1 = (Asteroid) this.getPlace();
        if (!a1.isFullyDrilled()) {
            System.out.println("Current asteroid is not fully drilled!");
            return false;
        }
        if (a1.isHollow()) {
            System.out.println("Select your resource to fill the asteroid!");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String input = sc.nextLine();
            Resource resource = null;

            /*we can select the resource */

            switch (input.toLowerCase()) {
                case "uranium":
                    resource = spaceship.getResource(ID.Uranium);
                    break;
                case "iron":
                    resource = spaceship.getResource(ID.Iron);
                    break;
                case "carbon":
                    resource = spaceship.getResource(ID.Carbon);
                    break;
                case "waterice":
                    resource = spaceship.getResource(ID.WaterIce);
                    ;
                    break;
            }

            if (resource != null) {
                if (spaceship.removeResource(resource)) {
                    a1.addResource(resource);
                    //System.out.println("a1.addResource(resource)");
                    return true;
                }
            } else {
                System.out.println("You dont have enough resource!");
                return false;
            }
        } else {
            System.out.println("Asteroid is not hollow!");
            return false;
        }
        return false;
    }


    /*Checking the inventory of Spaceship of settler*/
    public void checkInventory() {
        System.out.println("checkInventory()");
        System.out.println("SpaceShip's inventory:");
        for (Resource r : spaceship.resources.keySet()) {
            System.out.println(r.getType() + "->" + spaceship.resources.get(r));
        }
    }

    /*Building the teleporation gate but if necessary resources are available*/
    public boolean buildTeleportationGates() {
        System.out.println("buildTeleportationGate()");

        Place p = this.getPlace();
        int nIron = spaceship.countResource(ID.Iron);
        System.out.println("countResource(\"iron”): nIron");
        int nWaterIce = spaceship.countResource(ID.WaterIce);
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(ID.Uranium);
        System.out.println("countResource(\"uranium”): nUranium");

        if (nIron >= 1 && nWaterIce >= 1 && nUranium >= 1) {
            System.out.println("You have enough resources! Do you want to build a teleportation gates?");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("yes")) {
                TeleportationGate gate1 = new TeleportationGate();
                TeleportationGate gate2 = new TeleportationGate();
                gate1.setGate(gate2);
                gate2.setGate(gate1);
                gates.add(gate1);
                System.out.println("First Gate Added- addGate()");
                gates.add(gate2);
                System.out.println("Second Gate Added- addGate()");

                this.spaceship.removeResource(ID.Uranium, 1);
                this.spaceship.removeResource(ID.Iron, 1);
                this.spaceship.removeResource(ID.WaterIce, 1);


                return true;
            }
        } else {
            System.out.println("You do not have enough resources!");
        }
        return false;
    }

    /*Deploying the new built available gate*/
    public void deployGate() {
        System.out.println("deployGate()");
        if (gates.size() == 2) {
            TeleportationGate gate1 = gates.get(0); // creating the gate
            //System.out.println("setGate(gate1) -- setGate(gate2)");
            this.getPlace().addNeighbour(gate1);
            System.out.println("addNeighbour(gate1)");
            System.out.println("First gate deployed successfully!");
            gates.remove(gate1);
        } else if (gates.size() == 1) {
            this.getPlace().addNeighbour(gates.get(0));
            System.out.println("addNeighbour(gate2)");
            System.out.println("Second gate deployed successfully!");
            gates.clear();
        } else {
            System.out.println("You have no new build Teleportation Gates");
        }
    }

    public boolean buildSpaceStation() {
        System.out.println("buildSpacaStation()");

        Place p = this.getPlace();
        int nIron = spaceship.countResource(ID.Iron);
        System.out.println("countResource(\"iron”): nIron");
        int nCarbon = spaceship.countResource(ID.Carbon);
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(ID.Uranium);
        System.out.println("countResource(\"uranium”): nUranium");
        int nWaterIce = spaceship.countResource(ID.WaterIce);
        System.out.println("countResource(\"uranium”): waterIce");

        if (nIron >= 3 && nCarbon >= 3 && nUranium >= 3 && nWaterIce >= 3) {
            System.out.println("You have enough resources! Do you want to build a SpaceStation?");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("yes")) {
                robot = new Robot();


                System.out.println("SpaceStation is built successfully!");
                this.spaceship.removeResource(ID.Carbon, 3);
                this.spaceship.removeResource(ID.Uranium, 3);
                this.spaceship.removeResource(ID.Iron, 3);
                this.spaceship.removeResource(ID.WaterIce, 3);
                return true;
            }
        } else {
            System.out.println("You do not have enough resources!");
        }
        return false;
    }
}
